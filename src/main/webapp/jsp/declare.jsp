<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://www.state.com/state" prefix="state"%>

<state:override name="head">
	<title></title>
	<Link Rel="StyleSheet" Href="${pageContext.request.contextPath }/css/declare.css" Type="Text/Css">
	<script src="${pageContext.request.contextPath }/js/charts/highcharts.js"></script>
	<script src="${pageContext.request.contextPath }/js/charts/modules/exporting.js"></script>
	<script src="${pageContext.request.contextPath }/js/state/declare.js"></script>
</state:override>
<state:override name="content">
	
	<div>
		<div class="mid">
			<div class="contop">
				<div class="fl"><span class="xmenu">数据申报单</span><span class="count">25条</span></div>
				<div class="rl"><span>+添加</span><span>-删除</span></div>
				<div class="cl"></div>
			</div>
			<div>
				<div class="lmenu">
					<ul>
						<li>
							<div class="fl bgy">单子</div>
							<div class="cl"></div>
						</li>
						<li>
							<div class="fl bgi">单子2</div>
							<div class="cl"></div>
						</li>
					
					</ul>
				</div>
				<div class="fl">
					<div class="conrightt1"><span class="fl">全天</span><span class="fl">高峰</span><span class="fl">低谷</span><span class="rl">保存</span></div>
					<div class="cl"></div>
					<div class="fl conrightt2"><span>平均值:450</span>|<span>平均值:450</span>|<span>平均值:450</span></div>
					<div class="cl"></div>
					<div class="fl">
						<table width="998" border="1" cellspacing="0">
							<tr>
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
					<div class="cchart">图表</div>
				</div>
			</div>
		</div>
	</div>
</state:override>

<%@ include file="/common/block/block.jsp" %>

