<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://www.state.com/state" prefix="state"%>

<state:override name="head">
	<title></title>
	<Link Rel="StyleSheet" Href="${pageContext.request.contextPath }/css/declare.css" Type="Text/Css">
	<script src="${pageContext.request.contextPath }/js/charts/highcharts.js"></script>
	<script src="${pageContext.request.contextPath }/js/charts/modules/exporting.js"></script>
	<script src="${pageContext.request.contextPath }/js/state/issue.js?date=new Date()"></script>
	<script type="text/javascript">
		var issue = new Issue();
		$(function(){
			$('.menu').find('a[name=发布]').attr('class', 'menufocus');
			
			issue.getIssue();
			issue.loadElData(${areaList});
			issue.showArea("${userInfo.area}");
			$("#IssueMenu li").live('click', function(){issue.getIssueData($(this), '1a');});
			$("#IssueMenu li").live('dbclick', function(){issue.getIssueData($(this), '1a');});
		})	
	</script>
</state:override>
<state:override name="content">
	
	<div>
		<div class="mid">
			<div class="contop">
				<div class="fl"><span class="xmenu">发布</span><span class="count">0条</span><span class="posty rl"><img src="${pageContext.request.contextPath }/img/pxy.png"/>｜<select id="area" onchange="issue.changeArea()"><option value=""></option></select></span></div>
				<div class="rl"></div>
				<div class="cl"></div>
			</div>
			<div>
				<div class="lmenu">
					<ul id="IssueMenu">
						
					</ul>
				</div>
				<div id="IssueDataDiv" class="fl bd1" style="display:none;">
					<div class="conrightt1">
						<div class="fl mne"><a href="#" name="1a" onclick="issue.getIssueDataByIssueType('1a');">全天</a></div>
						<div class="fl mne"><a href="#" name="2a" onclick="issue.getIssueDataByIssueType('2a');">高峰</a></div>
						<div class="fl mne"><a href="#" name="3a" onclick="issue.getIssueDataByIssueType('3a');">低谷</a></div>
						
					</div>
					<div class="cl"></div>
					<div class="fl conrightt2"><span>总值:</span><span name="sumValue" class="avenum">0</span>|<span class="pdl30">平均值:</span><span name="avgValue" class="avenun">0</span></div>
					<div class="cl"></div>
					<div class="fl pdl10">
						<table width="968" height="302" cellpadding="0" cellspacing="0">
							<thead>
								<th width="16%" class="cgr">时间</th>
								<th width="7%" class="cgr">0</th>
								<th width="7%" class="cgr">1</th>
								<th width="7%" class="cgr">2</th>
								<th width="7%" class="cgr">3</th>
								<th width="7%" class="cgr">4</th>
								<th width="7%" class="cgr">5</th>
								<th width="7%" class="cgr">6</th>
								<th width="7%" class="cgr">7</th>
								<th width="7%" class="cgr">8</th>
								<th width="7%" class="cgr">9</th>
								<th width="7%" class="cgr">10</th>
								<th width="7%" class="cgr">11</th>
							</thead>
							<tr>
								<td width="16%" class="cgr">00:00</td>
								<td width="7%"><input readonly="true" name="h01"></td>
								<td width="7%"><input readonly="true" name="h05"></td>
								<td width="7%"><input readonly="true" name="h09"></td>
								<td width="7%"><input readonly="true" name="h13"></td>
								<td width="7%"><input readonly="true" name="h17"></td>
								<td width="7%"><input readonly="true" name="h21"></td>
								<td width="7%"><input readonly="true" name="h25"></td>
								<td width="7%"><input readonly="true" name="h29"></td>
								<td width="7%"><input readonly="true" name="h33"></td>
								<td width="7%"><input readonly="true" name="h37"></td>
								<td width="7%"><input readonly="true" name="h41"></td>
								<td width="7%"><input readonly="true" name="h45"></td>
							</tr>
							<tr class="bgh">
								<td width="16%" class="cgr">00:15</td>
								<td width="7%"><input readonly="true" name="h02"></td>
								<td width="7%"><input readonly="true" name="h06"></td>
								<td width="7%"><input readonly="true" name="h10"></td>
								<td width="7%"><input readonly="true" name="h14"></td>
								<td width="7%"><input readonly="true" name="h18"></td>
								<td width="7%"><input readonly="true" name="h22"></td>
								<td width="7%"><input readonly="true" name="h26"></td>
								<td width="7%"><input readonly="true" name="h30"></td>
								<td width="7%"><input readonly="true" name="h34"></td>
								<td width="7%"><input readonly="true" name="h38"></td>
								<td width="7%"><input readonly="true" name="h42"></td>
								<td width="7%"><input readonly="true" name="h46"></td>
							</tr>
							<tr>
								<td width="16%" class="cgr">00:30</td>
								<td width="7%"><input readonly="true" name="h03"></td>
								<td width="7%"><input readonly="true" name="h07"></td>
								<td width="7%"><input readonly="true" name="h11"></td>
								<td width="7%"><input readonly="true" name="h15"></td>
								<td width="7%"><input readonly="true" name="h19"></td>
								<td width="7%"><input readonly="true" name="h23"></td>
								<td width="7%"><input readonly="true" name="h27"></td>
								<td width="7%"><input readonly="true" name="h31"></td>
								<td width="7%"><input readonly="true" name="h35"></td>
								<td width="7%"><input readonly="true" name="h39"></td>
								<td width="7%"><input readonly="true" name="h43"></td>
								<td width="7%"><input readonly="true" name="h47"></td>
							</tr>
							<tr class="bgh">
								<td width="16%" class="cgr">00:45</td>
								<td width="7%"><input readonly="true" name="h04"></td>
								<td width="7%"><input readonly="true" name="h08"></td>
								<td width="7%"><input readonly="true" name="h12"></td>
								<td width="7%"><input readonly="true" name="h16"></td>
								<td width="7%"><input readonly="true" name="h20"></td>
								<td width="7%"><input readonly="true" name="h24"></td>
								<td width="7%"><input readonly="true" name="h28"></td>
								<td width="7%"><input readonly="true" name="h32"></td>
								<td width="7%"><input readonly="true" name="h36"></td>
								<td width="7%"><input readonly="true" name="h40"></td>
								<td width="7%"><input readonly="true" name="h44"></td>
								<td width="7%"><input readonly="true" name="h48"></td>
							</tr>
							<tr>
								<td width="16%" class="cgr">时间</td>
								<td width="7%" class="cgr">12</td>
								<td width="7%" class="cgr">13</td>
								<td width="7%" class="cgr">14</td>
								<td width="7%" class="cgr">15</td>
								<td width="7%" class="cgr">16</td>
								<td width="7%" class="cgr">17</td>
								<td width="7%" class="cgr">18</td>
								<td width="7%" class="cgr">19</td>
								<td width="7%" class="cgr">20</td>
								<td width="7%" class="cgr">21</td>
								<td width="7%" class="cgr">22</td>
								<td width="7%" class="cgr">23</td>
							</tr>
							<tr class="bgh">
								<td width="16%" class="cgr">00:00</td>
								<td width="7%"><input readonly="true" name="h49"></td>
								<td width="7%"><input readonly="true" name="h53"></td>
								<td width="7%"><input readonly="true" name="h57"></td>
								<td width="7%"><input readonly="true" name="h61"></td>
								<td width="7%"><input readonly="true" name="h65"></td>
								<td width="7%"><input readonly="true" name="h69"></td>
								<td width="7%"><input readonly="true" name="h73"></td>
								<td width="7%"><input readonly="true" name="h77"></td>
								<td width="7%"><input readonly="true" name="h81"></td>
								<td width="7%"><input readonly="true" name="h85"></td>
								<td width="7%"><input readonly="true" name="h89"></td>
								<td width="7%"><input readonly="true" name="h93"></td>
							</tr>
							<tr>
								<td width="16%" class="cgr">00:15</td>
								<td width="7%"><input readonly="true" name="h50"></td>
								<td width="7%"><input readonly="true" name="h54"></td>
								<td width="7%"><input readonly="true" name="h58"></td>
								<td width="7%"><input readonly="true" name="h62"></td>
								<td width="7%"><input readonly="true" name="h66"></td>
								<td width="7%"><input readonly="true" name="h70"></td>
								<td width="7%"><input readonly="true" name="h74"></td>
								<td width="7%"><input readonly="true" name="h78"></td>
								<td width="7%"><input readonly="true" name="h82"></td>
								<td width="7%"><input readonly="true" name="h86"></td>
								<td width="7%"><input readonly="true" name="h90"></td>
								<td width="7%"><input readonly="true" name="h94"></td>
							</tr>
							<tr class="bgh">
								<td width="16%" class="cgr">00:30</td>
								<td width="7%"><input readonly="true" name="h51"></td>
								<td width="7%"><input readonly="true" name="h55"></td>
								<td width="7%"><input readonly="true" name="h59"></td>
								<td width="7%"><input readonly="true" name="h63"></td>
								<td width="7%"><input readonly="true" name="h67"></td>
								<td width="7%"><input readonly="true" name="h71"></td>
								<td width="7%"><input readonly="true" name="h75"></td>
								<td width="7%"><input readonly="true" name="h79"></td>
								<td width="7%"><input readonly="true" name="h83"></td>
								<td width="7%"><input readonly="true" name="h87"></td>
								<td width="7%"><input readonly="true" name="h91"></td>
								<td width="7%"><input readonly="true" name="h95"></td>
							</tr>
							<tr>
								<td width="16%" class="cgr">00:45</td>
								<td width="7%"><input readonly="true" name="h52"></td>
								<td width="7%"><input readonly="true" name="h56"></td>
								<td width="7%"><input readonly="true" name="h60"></td>
								<td width="7%"><input readonly="true" name="h64"></td>
								<td width="7%"><input readonly="true" name="h68"></td>
								<td width="7%"><input readonly="true" name="h72"></td>
								<td width="7%"><input readonly="true" name="h76"></td>
								<td width="7%"><input readonly="true" name="h80"></td>
								<td width="7%"><input readonly="true" name="h84"></td>
								<td width="7%"><input readonly="true" name="h88"></td>
								<td width="7%"><input readonly="true" name="h92"></td>
								<td width="7%"><input readonly="true" name="h96"></td>
							</tr>
						</table>
					</div>
					<div class="cl"></div>
					<div class="cchart"></div>
					<div class="bz" id='commentDiv'></div>
				</div>
			</div>
		</div>
	</div>
	
</state:override>

<%@ include file="/common/block/block.jsp" %>

