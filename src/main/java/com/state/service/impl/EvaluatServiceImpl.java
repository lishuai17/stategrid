package com.state.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.state.dao.IEvaluateDao;
import com.state.dao.IPathResultDao;
import com.state.dao.IssueDao;
import com.state.po.DeclareDataPo;
import com.state.po.DeclarePo;
import com.state.po.DeclareType;
import com.state.po.LineLimitPo;
import com.state.po.PathDefinePo;
import com.state.po.PathResultPo;
import com.state.po.ResultPo;
import com.state.service.IEvaluateService;
import com.state.util.DateUtil;
import com.state.util.ReflectGetValueUtil;

@Service
@Transactional
public class EvaluatServiceImpl implements IEvaluateService {
	/**
	 * 撮合计算核心程序
	 */
	@Autowired
	private IEvaluateDao evaluateDao;
	@Autowired
	private IPathResultDao pathResultDao;
	@Autowired
	private IssueDao issueDao;
	
	private List<LineLimitPo> ZXLimitList = new ArrayList<LineLimitPo>();//正向限额
	
	private List<LineLimitPo> FXLimitList = new ArrayList<LineLimitPo>();//反向限额
	
	private String date = "20160509";
	
	private final String ZX_LIMIT = "正向限额";
	
	private final String FX_LIMIT = "反向限额";
	
	private String userId = "";
	
	private static DecimalFormat decimalFormat = new DecimalFormat("0.00");

	@Override
	public void computeFunticon(String userId) {
//		Date tomorrow=new Date((new Date()).getTime()+1000*60*60*24);
//		date = DateUtil.format(tomorrow, "yyyyMMdd");
		this.userId = userId;
		//卖方每个子单的申报量
		List<DeclareDataPo> everyBillSBofSaleList = evaluateDao.selectEveryDeclareValueBySale(date);
		Vector<Vector<String>> everyBillSBofSaleVector= ReflectGetValueUtil.getValueByField(everyBillSBofSaleList);
		//每个省每个子单申报量
		List<DeclareDataPo> everyProviceBillBuyList = evaluateDao.selectEveryProviceDecValueBySale(date);
		Vector<Vector<String>> everyProviceBillBuyOfProviceVector = ReflectGetValueUtil.getValueByField(everyProviceBillBuyList);
		
		
		//卖方（四川）所有子单求和
		List<DeclareDataPo> saleSumList = evaluateDao.selectDeclareValueBySale(date);
		Vector<Double> saleSumVector = ReflectGetValueUtil.getValue(saleSumList.get(0));
		
		//买方（4个省）子单分别求和
		Map<String,Vector<Double>> buyMap = new HashMap<String, Vector<Double>>();
		List<ResultPo> buyOrderlist = evaluateDao.selectDeclareValueByBuy(date);
		for(ResultPo dataPo:buyOrderlist){
			Vector<Double> vec = ReflectGetValueUtil.getValue(dataPo);
			System.out.println(vec);
			buyMap.put(dataPo.getArea(), vec);
		}
		
		//联络线96点限额计算96点通道限额
		List<PathDefinePo> pathList = evaluateDao.getPathList();
		pathResultDao.deletePathResultByDate(date);//删除计算日所有通道的限额 --->先删后插
		for(PathDefinePo pathPo:pathList){
			String mdirection = pathPo.getMdirection();
			String corhrName = "";
			String direction = "";
			
			for(int i=1;i<=mdirection.length();i++){
				direction = String.valueOf(mdirection.charAt(i-1));
				corhrName = getCorhrName(i,pathPo);
				getPathLimit(corhrName,direction,pathPo);
			}
			
			getFinalPathLimit(ZXLimitList,pathPo.getMpath(),this.ZX_LIMIT);//通道正向限额
			getFinalPathLimit(FXLimitList,pathPo.getMpath(),this.FX_LIMIT);//通道反向限额
			ZXLimitList.clear();
			FXLimitList.clear();
		}
		
		//计算卖方通道限额之和
		double[] salePathSumLimit = getSalePathSumLimit();
		//计算各个买方通道限额
		Map<String, double[]> everBuyPathLimit = getEveryBuyPathSumLimit();
		
		//计算卖方有效量-->卖方（四川）所有子单与卖方通道限额之和比较，取小的
		Vector<Double> effectiveAmountSaleVector = new Vector<Double>();
		for(int i=0;i<saleSumVector.size();i++){
			double value1 = saleSumVector.get(i);
			double value2 = salePathSumLimit[i];
			if(value1<value2){
				effectiveAmountSaleVector.add(value1);
			}else if(value1>value2){
				effectiveAmountSaleVector.add(value2);
			}else if(value1==value2){
				effectiveAmountSaleVector.add(value1);
			}
		}
		
		//计算买方有效量 --->卖方（各省份）所有子单与买方通道限额之和比较，取小的
		Map<String,Vector<Double>> effectiveAmountBuyMap = new HashMap<String, Vector<Double>>();
		for(String area:buyMap.keySet()){
			Vector<Double> billValueVector = buyMap.get(area);//每个省子单
			double[] pathValueArray = everBuyPathLimit.get(area);//通道限额
			Vector<Double> effectiveAmountBuyVector = new Vector<Double>();
			for(int i=0;i<billValueVector.size();i++){
				double value1 = billValueVector.get(i);
				double value2 = pathValueArray[i];
				if(value1<value2){
					effectiveAmountBuyVector.add(value1);
				}else if(value1>value2){
					effectiveAmountBuyVector.add(value2);
				}else if(value1==value2){
					effectiveAmountBuyVector.add(value1);
				}
			}
			effectiveAmountBuyMap.put(area, effectiveAmountBuyVector);
		}
		
		//计算所有买方有效量的和
		double[] allBuySumArray = new double[96];
		for(String areaKey:effectiveAmountBuyMap.keySet()){
			Vector<Double> vec = effectiveAmountBuyMap.get(areaKey);
			for(int i=0;i<vec.size();i++){
				allBuySumArray[i]+=vec.get(i);
			}
		}
		
		//计算 卖方每个单子的成交量
		for(int i=0;i<96;i++){
			double effectiveAmountSale = effectiveAmountSaleVector.get(i);//卖方有效量 SV
			double effectiveAllBuySum = allBuySumArray[i];//买方有效量Bsum
			double saleVolumeTotal = 0;//卖方总成交量 RS
			double buyVolumeTotal = 0;
			if(effectiveAmountSale>=effectiveAllBuySum){
				saleVolumeTotal=effectiveAllBuySum;//卖方总成交量
				for(Vector<String> vec:everyBillSBofSaleVector){//卖方每个当子成交量
					double everySbOfSale = Double.parseDouble((vec.get(i+3)==null||vec.get(i+3).equals("null"))?"0.0":vec.get(i+3));//每个单子每个点申报量
					double saleSumValue = saleSumVector.get(i);//卖方所有子单和
					double newVlaue =everySbOfSale*saleVolumeTotal/saleSumValue;
					vec.set(i+3, decimalFormat.format(newVlaue));
				}
				//=========买方单子成交量
				
				for(Vector<String> vec:everyProviceBillBuyOfProviceVector){
					String area = vec.get(2);
					double everySbOfBuy = Double.parseDouble((vec.get(i+3)==null||vec.get(i+3).equals("null"))?"0.0":vec.get(i+3));//每个子单申报量
					double areaeffectiveAmountTotal = effectiveAmountBuyMap.get(area).get(i);//买方总有效量
					double areaSbTotal = buyMap.get(area).get(i);//地区总申报
					double newValue = everySbOfBuy*areaeffectiveAmountTotal/areaSbTotal;
					vec.set(i+3, decimalFormat.format(newValue));
				}
				
				
				
				
			}else if(effectiveAmountSale<effectiveAllBuySum){
				saleVolumeTotal = effectiveAmountSale;//卖方总成交量
				for(Vector<String> vec:everyBillSBofSaleVector){//卖方每个当子成交量
					double everySbOfSale = Double.parseDouble((vec.get(i+3)==null||vec.get(i+3).equals("null"))?"0.0":vec.get(i+3));//每个单子每个点申报量
					double saleSumValue = saleSumVector.get(i);//卖方所有子单和
					double newVlaue =everySbOfSale*saleVolumeTotal/saleSumValue;
					vec.set(i+3, decimalFormat.format(newVlaue));
				}
				//===========买方总成交量
				buyVolumeTotal = effectiveAmountSale;//SV
				for(Vector<String> vec:everyProviceBillBuyOfProviceVector){
					String area = vec.get(2);
					double everySbOfBuy = Double.parseDouble((vec.get(i+3)==null||vec.get(i+3).equals("null"))?"0.0":vec.get(i+3));//每个子单申报量
					double areaEffectiveAmountTotal = effectiveAmountBuyMap.get(area).get(i);//地区总有效量 BVi
					double areaSbTotal = buyMap.get(area).get(i);//地区总申报
					double newValue = everySbOfBuy*(areaEffectiveAmountTotal*buyVolumeTotal/effectiveAllBuySum)/areaSbTotal;
					vec.set(i+3, decimalFormat.format(newValue));
				}
				
				
				
			}
		}
		issueDao.deleteResultByDate(date);//先清空计算日所有单子成交量
		insertToDatabase(everyBillSBofSaleVector);
		insertToDatabase(everyProviceBillBuyOfProviceVector);
		getPathResultByDeclResult();//交易功率
			
  }
	
	private void insertToDatabase(Vector<Vector<String>> everyBillSBofSaleVector){
		for(Vector<String> vec:everyBillSBofSaleVector){
			String type = vec.remove(1);
			DeclareType mytype = Enum.valueOf(DeclareType.class, type);
			type = mytype.getCode();
			
			Long id = Long.parseLong(vec.remove(0));
			DeclarePo po = evaluateDao.getDeclarePoById(id,date);
			ResultPo resultPo = new ResultPo();
			resultPo.setMdate(po.getMdate());
			resultPo.setDtime(DateUtil.format(new Date(), "yyyyMMdd HH:mm:ss"));
			resultPo.setArea(po.getArea());
			resultPo.setMname(userId);
			resultPo.setDrloe(po.getDrloe());
			resultPo.setDsheet(id+"");
			resultPo.setDtype(type);
			for(int i=1;i<vec.size();i++){
				String setAttributeMethodName = "setH"+(i<10?"0"+i:i);
				Method setAttributeMethod = null;
				try {
					setAttributeMethod = ResultPo.class.getDeclaredMethod(
							setAttributeMethodName, Double.class);
					setAttributeMethod.invoke(resultPo,Double.parseDouble(vec.get(i)));
				} catch (SecurityException e) {
					
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				
			}
			
			issueDao.insertResult(resultPo);
		}
		
	}
	
	
	/**
	 * 计算通道限额入库
	 * @param LimitList
	 * @param pathName
	 * @param type
	 */
	private void getFinalPathLimit(List<LineLimitPo> LimitList,String pathName,String type){
		
		PathResultPo po = LineLimitPo.compareLittle(LimitList);
		po.setMpath(pathName);
		po.setMdate(date);
		po.setDtype(type);
		pathResultDao.insertPathResult(po);
		
	}
	
	
	private void getPathLimit(String corhrName,String direction,PathDefinePo pathPo){
		
		List<LineLimitPo> listLimit =  evaluateDao.getCorhrByCorhr(corhrName, date);
		LineLimitPo ZXlimitVo = null;
		LineLimitPo planlimitVo = null;
		LineLimitPo FXlimitVo = null;
	     for(LineLimitPo limitPo:listLimit){
	    	 String corhrType =  limitPo.getDtype();
	    	 if(corhrType.equals("正向限额")){
	    			ZXlimitVo = limitPo;
	    		
	    	 }else if(corhrType.equals("反向限额")){
	    		 FXlimitVo = limitPo;
	    		
	    	 }else if(corhrType.equals("计划值")){
	    		 planlimitVo = limitPo;
	    	 }
	    	 
	     }
	 	
	    
	    
	     if(direction.equals("+")){
	    	//通道正向限额--->加号时正向限额-计划值
	    	 List<LineLimitPo> listTemp = new ArrayList<LineLimitPo>();
	    	 listTemp.add(ZXlimitVo);
	    	 listTemp.add(planlimitVo);
	    	 LineLimitPo po = getMutilPoCompute(listTemp, ZX_LIMIT);
	    	 ZXLimitList.add(po);
	    	//通道反向限额--->加号时 计划值减反向限额
	    	 listTemp.clear();
	    	 listTemp.add(planlimitVo);
	    	 listTemp.add(FXlimitVo);
	    	 po = getMutilPoCompute(listTemp, FX_LIMIT);
	    	 FXLimitList.add(po);	
	     }else if(direction.equals("-")){
	    	//通道正向限额---->减号时计划值减反向限额
	    	 List<LineLimitPo> listTemp = new ArrayList<LineLimitPo>();
	    	 listTemp.add(planlimitVo);
	    	 listTemp.add(FXlimitVo);
	    	 LineLimitPo po = getMutilPoCompute(listTemp, ZX_LIMIT);
	    	 ZXLimitList.add(po);
	    	//通道反向限额---->减号时 正向限额-计划值
	    	 listTemp.clear();
	    	 listTemp.add(ZXlimitVo);
	    	 listTemp.add(planlimitVo);
	    	 po = getMutilPoCompute(listTemp, FX_LIMIT);
	    	 FXLimitList.add(po);
	     }
	     
	     
	     
	}
	
	/**
	 * 获取卖方通道限额之和
	 */
	private double[] getSalePathSumLimit(){
		List<PathResultPo> resultList = new ArrayList<PathResultPo>();
		List<DeclarePo> areaList = evaluateDao.getSaleAreaList(date);
		for(DeclarePo po:areaList){
			String area = po.getArea();
			List<PathDefinePo> pathPoOfSaleList = evaluateDao.getPathDefinePoListByArea(area);
			for(PathDefinePo pathPoOfSale:pathPoOfSaleList){
				String mpath = pathPoOfSale.getMpath();
				String startArea = pathPoOfSale.getStartArea();
				String endArea = pathPoOfSale.getEndArea();
				String type = "";
			    if(area.equals(startArea)){//卖方地区为首端就取通道正向限额
			    	type = "正向限额";
			    	PathResultPo resultPo = pathResultDao.getPathResult(date, mpath,type);
			    	if(resultPo!=null){
			    		resultList.add(resultPo);
			    	}
			    	
			    }else if(area.equals(endArea)){//为末端就用反向限额的相反数
			    	type = "反向限额";
			    	PathResultPo resultPo = pathResultDao.getPathResult(date, mpath,type);
			    	resultPo = getOppositeValueOfPathResult(resultPo);
			    	if(resultPo!=null){
			    		resultList.add(resultPo);
			    	}
			    }
			
			}
		}
		return getSumbyList(resultList);
	}
	
	
	/**
	 * 获取各买方通道限额
	 */
	private Map<String,double[]> getEveryBuyPathSumLimit(){
		Map<String,double[]> buyAreaMap = new HashMap<String, double[]>();
		List<PathResultPo> resultList = null;
		List<DeclarePo> areaList = evaluateDao.getBuyAreaList(date);
		for(DeclarePo po:areaList){
			String area = po.getArea();
			resultList = new ArrayList<PathResultPo>();
			List<PathDefinePo> pathPoOfSaleList = evaluateDao.getPathDefinePoListByArea(area);
			for(PathDefinePo pathPoOfSale:pathPoOfSaleList){
				String mpath = pathPoOfSale.getMpath();
				String startArea = pathPoOfSale.getStartArea();
				String endArea = pathPoOfSale.getEndArea();
				String type = "";
			    if(area.equals(startArea)){//买方地区为首端就取通道反向限额的相反数
			    	type = "反向限额";
			    	PathResultPo resultPo = pathResultDao.getPathResult(date, mpath,type);
			    	resultPo = getOppositeValueOfPathResult(resultPo);
			    	if(resultPo!=null){
			    		resultList.add(resultPo);
			    	}
			    	
			    }else if(area.equals(endArea)){//为末端就用正向限额
			    	type = "正向限额";
			    	PathResultPo resultPo = pathResultDao.getPathResult(date, mpath,type);
			    	if(resultPo!=null){
			    		resultList.add(resultPo);
			    	}
			    }
			
			}
			buyAreaMap.put(area, getSumbyList(resultList));
		}
		
		return buyAreaMap;
	}
	
	private double[] getSumbyList(List<PathResultPo> resultList){
		Vector<Vector<Double>> vector = getValueByField(resultList);
		double[] resultSumArray = new double[96];
		for(Vector<Double> vec:vector){
			for(int i=0;i<vec.size();i++){
				resultSumArray[i]+=vec.get(i);
			}
		}
		return resultSumArray;
	}
	
	private void getPathResultByDeclResult(){
		pathResultDao.deletePathResultByDate(date);
		List<PathDefinePo> pathList = evaluateDao.getPathList();
		for(PathDefinePo po:pathList){
			String mend = po.getEndArea();
			PathResultPo resultPo = evaluateDao.getDeclResultSumByArea(mend);
			resultPo.setMpath(po.getMpath());
			resultPo.setDtype("交易功率");
			resultPo.setMdate(date);
			pathResultDao.insertPathResult(resultPo);
			
		}
	}
	
	
	
	
	
	private String getCorhrName(Integer index,PathDefinePo pathPo){
		String corhrName = "";
		switch (index) {
		case 1:
			corhrName = pathPo.getCorhr1();
			break;
		case 2:
			corhrName = pathPo.getCorhr2();
			break;
		case 3:
			corhrName = pathPo.getCorhr3();
			break;
		case 4:
			corhrName = pathPo.getCorhr4();
			break;
		case 5:
			corhrName = pathPo.getCorhr5();
			break;
		case 6:
			corhrName = pathPo.getCorhr6();
			break;
		case 7:
			corhrName = pathPo.getCorhr7();
			break;
		case 8:
			corhrName = pathPo.getCorhr8();
			break;
		case 9:
			corhrName = pathPo.getCorhr9();
			break;
		case 10:
			corhrName = pathPo.getCorhr10();
			break;

		default:
			corhrName = "";
			break;
		}
		return corhrName;
	}
	
	
	/**
	 * 反射获取各个属性的值
	 * @param lines
	 */
	public Vector<Vector<Double>> getValueByField(List<PathResultPo> lines){
		Vector<Vector<Double>> vec = new Vector<Vector<Double>>();
		Vector<Double> unitVector = null;
		if(null == lines || lines.isEmpty()){
			//return null;
		}
		Field[] fields = PathResultPo.class.getDeclaredFields();
		
		for (int i=0;i<lines.size();i++) {
			unitVector = new Vector<Double>();
			for (Field field : fields) {
				if(field.getName().startsWith("h")){
					field.setAccessible(true);
					try {
						PathResultPo lineLimitPo = lines.get(i);
						Field lineField = lineLimitPo.getClass().getDeclaredField(field.getName());
						lineField.setAccessible(true);
						Double hh = (Double)lineField.get(lineLimitPo);
						unitVector.add(hh);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (NoSuchFieldException e) {
						e.printStackTrace();
					}
				}
			}
			vec.add(unitVector);
		}
		return vec;
		
	}
	
	
	
	
	/**
	 * 反射获取各个属性的相反值
	 * @param lines
	 */
	public PathResultPo getOppositeValueOfPathResult(PathResultPo po){
		
		Field[] fields = PathResultPo.class.getDeclaredFields();
			for (Field field : fields) {
				if(field.getName().startsWith("h")){
					field.setAccessible(true);
					try {
						
						Field lineField = po.getClass().getDeclaredField(field.getName());
						lineField.setAccessible(true);
						Double hh = Double.parseDouble(lineField.get(po)==null?"0":lineField.get(po).toString());
						hh = Double.parseDouble("-"+hh);
						String setAttributeMethodName = "set"
								+ Character.toUpperCase(field.getName().charAt(0))
								+ field.getName().substring(1);
						Method setAttributeMethod = PathResultPo.class.getDeclaredMethod(
								setAttributeMethodName, Double.class);
						setAttributeMethod.invoke(po,hh);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (NoSuchFieldException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
			
		
		return po;
		
	}
	
	
	/**
	 * 通过vector给对象属性赋值
	 * @param lines
	 */
	public ResultPo getPobyVector(ResultPo po,Vector<String> vector){
		
		Field[] fields = ResultPo.class.getDeclaredFields();
			for (Field field : fields) {
				if(field.getName().startsWith("h")){
					field.setAccessible(true);
					try {
						
						String setAttributeMethodName = "set"
								+ Character.toUpperCase(field.getName().charAt(0))
								+ field.getName().substring(1);
						Method setAttributeMethod = ResultPo.class.getDeclaredMethod(
								setAttributeMethodName, Double.class);
						setAttributeMethod.invoke(po,0.0);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
			
		
		return po;
		
	}
	/**
	 * 两个对象每个点的值相减（如果 反向限额为正取反）
	 * @param lines
	 * @param type
	 * @return
	 */
	public LineLimitPo getMutilPoCompute(List<LineLimitPo> lines,String type){
		if(null == lines || lines.isEmpty()){
			return null;
		}
		LineLimitPo firstPo = lines.get(0);
		Field[] fields = LineLimitPo.class.getDeclaredFields();
		for (Field field : fields) {
			if(field.getName().startsWith("h")){
				field.setAccessible(true);
				try {

					Field lineField1 = firstPo.getClass().getDeclaredField(field.getName());
					lineField1.setAccessible(true);
					double value1 = (Double)lineField1.get(firstPo);
					for (int i=1;i<lines.size();i++) {
						LineLimitPo lineLimitPo = lines.get(i);
						Field lineField = lineLimitPo.getClass().getDeclaredField(field.getName());
						lineField.setAccessible(true);
						double value2 = (Double)lineField.get(lineLimitPo);
						
						String setAttributeMethodName = "set"
								+ Character.toUpperCase(field.getName().charAt(0))
								+ field.getName().substring(1);
						Method setAttributeMethod = LineLimitPo.class.getDeclaredMethod(
								setAttributeMethodName, double.class);
						if(type.equals(FX_LIMIT)){
							if(value1-value2>0){
								setAttributeMethod.invoke(firstPo,Double.parseDouble("-"+(value1-value2)));
							}
							
						}else{
							setAttributeMethod.invoke(firstPo,value1-value2);
						}
						
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				}
			}
		}
		return firstPo;
	}
	
	
	
	
	
	

	
	
	

}
