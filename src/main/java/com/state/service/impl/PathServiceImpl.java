package com.state.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.state.dao.IPathDefineDao;
import com.state.po.PathDefinePo;
import com.state.service.IPathService;

@Service
public class PathServiceImpl implements IPathService {

	@Autowired
	private IPathDefineDao pathDefineDao;
	
	/**
	 * 获取所有的通道定义数据
	 * @return
	 */
	public List<PathDefinePo> getAllPath(){
		return pathDefineDao.selectPathALL();
	}
	
	/**
	 * 根据通道名判断通道是否存在
	 * @param mpath
	 * @return
	 */
	public boolean existsPath(String mpath){
		return pathDefineDao.countPathByName(mpath) > 0;
	}
	
	/**
	 * 添加通道定义
	 * @param pathDefine
	 */
	public void addPath(PathDefinePo pathDefine){
		pathDefineDao.insertPathDefine(pathDefine);
	}
	
	/**
	 * 删除通道
	 * @param mpath
	 */
	public void deletePath(String mpath){
		pathDefineDao.deletePathDefine(mpath);
	}
}
