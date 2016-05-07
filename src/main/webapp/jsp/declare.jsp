<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://www.state.com/state" prefix="state"%>

<state:override name="head">
	<title></title>
	<Link Rel="StyleSheet" Href="${pageContext.request.contextPath }/css/declare.css" Type="Text/Css">
	<script src="${pageContext.request.contextPath }/js/charts/highcharts.js"></script>
	<script src="${pageContext.request.contextPath }/js/charts/modules/exporting.js"></script>
	<script src="${pageContext.request.contextPath }/js/state/declare.js"></script>
	<script type="text/javascript">
		var declare = new Declare();
		$(function(){
			declare.getDeclare();
			$("#declareMenu li").live('click', function(){declare.getDeclareData($(this).attr('declareId'), '1a')});
			$("#declareMenu li").live('dbclick', function(){declare.getDeclareData($(this).attr('declareId'), '1a')});
		})
	</script>
</state:override>
<state:override name="content">
	
	<div>
		<div class="mid">
			<div class="contop">
				<div class="fl"><span class="xmenu">数据申报单</span><span class="count">0条</span></div>
				<div class="rl"><span><a class="btn1" href="#" onclick="declare.showAddWin();">+添加</a></span><span><a class="btn1" href="#" onclick="declare.deleteDeclare();">-删除</a></span></div>
				<div class="cl"></div>
			</div>
			<div>
				<div class="lmenu">
					<ul id="declareMenu">
						
					</ul>
				</div>
				<div class="fl bd1">
					<div class="conrightt1">
						<div class="fl mne"><a href="#">全天</a></div>
						<div class="fl mne"><a href="">高峰</a></div>
						<div class="fl mne"><a href="#">低谷</a></div>
						<div class="rl"><a class="btn2" href="#">保存</a></div>
					</div>
					<div class="cl"></div>
					<div class="fl conrightt2"><span>平均值:</span><span class="avenum">450</span>|<span class="pdl30">平均值:</span><span class="avenun">450</span>|<span class="pdl30">平均值:</span><span class="avenuo">450</span></div>
					<div class="cl"></div>
					<div class="fl pdl10">
						<table width="968" height="302" cellpadding="0" cellspacing="0">
							<thead>
								<th width="16%">1</th>
								<th width="7%">1</th>
								<th width="7%">1</th>
								<th width="7%">1</th>
								<th width="7%">1</th>
								<th width="7%">1</th>
								<th width="7%">1</th>
								<th width="7%">1</th>
								<th width="7%">1</th>
								<th width="7%">1</th>
								<th width="7%">1</th>
								<th width="7%">1</th>
								<th width="7%">1</th>
							</thead>
							<tr>
								<td width="16%">1</td>
								<td width="7%">2</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
								<td width="7%">1</td>
								<td width="7%">2</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
							</tr>
							<tr class="bgh">
								<td width="16%">1</td>
								<td width="7%">2</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
								<td width="7%">1</td>
								<td width="7%">2</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
							</tr>
							<tr>
								<td width="16%">1</td>
								<td width="7%">2</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
								<td width="7%">1</td>
								<td width="7%">2</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
							</tr>
							<tr class="bgh">
								<td width="16%">1</td>
								<td width="7%">2</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
								<td width="7%">1</td>
								<td width="7%">2</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
							</tr>
							<tr>
								<td width="16%">1</td>
								<td width="7%">2</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
								<td width="7%">1</td>
								<td width="7%">2</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
							</tr>
							<tr class="bgh">
								<td width="16%">1</td>
								<td width="7%">2</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
								<td width="7%">1</td>
								<td width="7%">2</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
							</tr>
							<tr>
								<td width="16%">1</td>
								<td width="7%">2</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
								<td width="7%">1</td>
								<td width="7%">2</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
							</tr>
							<tr class="bgh">
								<td width="16%">1</td>
								<td width="7%">2</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
								<td width="7%">1</td>
								<td width="7%">2</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
							</tr>
							<tr>
								<td width="16%">1</td>
								<td width="7%">2</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
								<td width="7%">1</td>
								<td width="7%">2</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
								<td width="7%">3</td>
								<td width="7%">4</td>
								<td width="7%">5</td>
							</tr>
						</table>
					</div>
					<div class="cl"></div>
					<div class="cchart"></div>
					<div class="bz">备注：霏霏裁夺</div>
				</div>
			</div>
		</div>
	</div>
</state:override>

<%@ include file="/common/block/block.jsp" %>

