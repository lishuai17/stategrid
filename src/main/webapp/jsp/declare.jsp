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
			$("#declareMenu li").live('click', function(){declare.getDeclareData($(this), '1a');});
			$("#declareMenu li").live('dbclick', function(){declare.getDeclareData($(this), '1a');});
			$("#declareDataDiv input").live("keydown", function(e){declare.copyTableValue($(this), e);});
			$("#declareDataDiv input").live("click", function(e){declare.changeData();});
			$("#comment").live("click", function(e){declare.changeData();});
		})
	</script>
</state:override>
<state:override name="content">
	
	<div>
		<div class="mid">
			<div class="contop">
				<div class="fl"><span class="xmenu">数据申报单</span><span class="count">0条</span></div>
				<div class="rl"><span><a class="btn1" href="#" onclick="declare.addDeclare();">+添加</a></span><span><a class="btn1" href="#" onclick="declare.deleteDeclare();">-删除</a></span></div>
				<div class="cl"></div>
			</div>
			<div>
				<div class="lmenu">
					<ul id="declareMenu">
						
					</ul>
				</div>
				<div id="declareDataDiv" class="fl bd1" style="display:none;">
					<div class="conrightt1">
						<div class="fl mne"><a href="#" onclick="declare.getDeclareDataByDeclareType('1a');">全天</a></div>
						<div class="fl mne"><a href="#" onclick="declare.getDeclareDataByDeclareType('2a');">高峰</a></div>
						<div class="fl mne"><a href="#" onclick="declare.getDeclareDataByDeclareType('3a');">低谷</a></div>
						<div class="rl"><a class="btn2" href="#" onclick="declare.updateDeclare();">保存</a></div>
					</div>
					<div class="cl"></div>
					<div class="fl conrightt2"><span>总值:</span><span name="sumValue" class="avenum">0</span>|<span class="pdl30">平均值:</span><span name="avgValue" class="avenun">0</span></div>
					<div class="cl"></div>
					<div class="fl pdl10">
						<table width="968" height="302" cellpadding="0" cellspacing="0">
							<thead>
								<th width="16%">时间</th>
								<th width="7%">0</th>
								<th width="7%">1</th>
								<th width="7%">2</th>
								<th width="7%">3</th>
								<th width="7%">4</th>
								<th width="7%">5</th>
								<th width="7%">6</th>
								<th width="7%">7</th>
								<th width="7%">8</th>
								<th width="7%">9</th>
								<th width="7%">10</th>
								<th width="7%">11</th>
							</thead>
							<tr>
								<td width="16%">00:00</td>
								<td width="7%"><input name="h01"></td>
								<td width="7%"><input name="h02"></td>
								<td width="7%"><input name="h03"></td>
								<td width="7%"><input name="h04"></td>
								<td width="7%"><input name="h05"></td>
								<td width="7%"><input name="h06"></td>
								<td width="7%"><input name="h07"></td>
								<td width="7%"><input name="h08"></td>
								<td width="7%"><input name="h09"></td>
								<td width="7%"><input name="h10"></td>
								<td width="7%"><input name="h11"></td>
								<td width="7%"><input name="h12"></td>
							</tr>
							<tr class="bgh">
								<td width="16%">00:15</td>
								<td width="7%"><input name="h13"></td>
								<td width="7%"><input name="h14"></td>
								<td width="7%"><input name="h15"></td>
								<td width="7%"><input name="h16"></td>
								<td width="7%"><input name="h17"></td>
								<td width="7%"><input name="h18"></td>
								<td width="7%"><input name="h19"></td>
								<td width="7%"><input name="h20"></td>
								<td width="7%"><input name="h21"></td>
								<td width="7%"><input name="h22"></td>
								<td width="7%"><input name="h23"></td>
								<td width="7%"><input name="h24"></td>
							</tr>
							<tr>
								<td width="16%">00:30</td>
								<td width="7%"><input name="h25"></td>
								<td width="7%"><input name="h26"></td>
								<td width="7%"><input name="h27"></td>
								<td width="7%"><input name="h28"></td>
								<td width="7%"><input name="h29"></td>
								<td width="7%"><input name="h30"></td>
								<td width="7%"><input name="h31"></td>
								<td width="7%"><input name="h32"></td>
								<td width="7%"><input name="h33"></td>
								<td width="7%"><input name="h34"></td>
								<td width="7%"><input name="h35"></td>
								<td width="7%"><input name="h36"></td>
							</tr>
							<tr class="bgh">
								<td width="16%">00:45</td>
								<td width="7%"><input name="h37"></td>
								<td width="7%"><input name="h38"></td>
								<td width="7%"><input name="h39"></td>
								<td width="7%"><input name="h40"></td>
								<td width="7%"><input name="h41"></td>
								<td width="7%"><input name="h42"></td>
								<td width="7%"><input name="h43"></td>
								<td width="7%"><input name="h44"></td>
								<td width="7%"><input name="h45"></td>
								<td width="7%"><input name="h46"></td>
								<td width="7%"><input name="h47"></td>
								<td width="7%"><input name="h48"></td>
							</tr>
							<tr>
								<td width="16%">时间</td>
								<td width="7%">12</td>
								<td width="7%">13</td>
								<td width="7%">14</td>
								<td width="7%">15</td>
								<td width="7%">16</td>
								<td width="7%">17</td>
								<td width="7%">18</td>
								<td width="7%">19</td>
								<td width="7%">20</td>
								<td width="7%">21</td>
								<td width="7%">22</td>
								<td width="7%">23</td>
							</tr>
							<tr class="bgh">
								<td width="16%">00:00</td>
								<td width="7%"><input name="h49"></td>
								<td width="7%"><input name="h50"></td>
								<td width="7%"><input name="h51"></td>
								<td width="7%"><input name="h52"></td>
								<td width="7%"><input name="h53"></td>
								<td width="7%"><input name="h54"></td>
								<td width="7%"><input name="h55"></td>
								<td width="7%"><input name="h56"></td>
								<td width="7%"><input name="h57"></td>
								<td width="7%"><input name="h58"></td>
								<td width="7%"><input name="h59"></td>
								<td width="7%"><input name="h60"></td>
							</tr>
							<tr>
								<td width="16%">00:15</td>
								<td width="7%"><input name="h61"></td>
								<td width="7%"><input name="h62"></td>
								<td width="7%"><input name="h63"></td>
								<td width="7%"><input name="h64"></td>
								<td width="7%"><input name="h65"></td>
								<td width="7%"><input name="h66"></td>
								<td width="7%"><input name="h67"></td>
								<td width="7%"><input name="h68"></td>
								<td width="7%"><input name="h69"></td>
								<td width="7%"><input name="h70"></td>
								<td width="7%"><input name="h71"></td>
								<td width="7%"><input name="h72"></td>
							</tr>
							<tr class="bgh">
								<td width="16%">00:30</td>
								<td width="7%"><input name="h73"></td>
								<td width="7%"><input name="h74"></td>
								<td width="7%"><input name="h75"></td>
								<td width="7%"><input name="h76"></td>
								<td width="7%"><input name="h77"></td>
								<td width="7%"><input name="h78"></td>
								<td width="7%"><input name="h79"></td>
								<td width="7%"><input name="h80"></td>
								<td width="7%"><input name="h81"></td>
								<td width="7%"><input name="h82"></td>
								<td width="7%"><input name="h83"></td>
								<td width="7%"><input name="h84"></td>
							</tr>
							<tr>
								<td width="16%">00:45</td>
								<td width="7%"><input name="h85"></td>
								<td width="7%"><input name="h86"></td>
								<td width="7%"><input name="h87"></td>
								<td width="7%"><input name="h88"></td>
								<td width="7%"><input name="h89"></td>
								<td width="7%"><input name="h90"></td>
								<td width="7%"><input name="h91"></td>
								<td width="7%"><input name="h92"></td>
								<td width="7%"><input name="h93"></td>
								<td width="7%"><input name="h94"></td>
								<td width="7%"><input name="h95"></td>
								<td width="7%"><input name="h96"></td>
							</tr>
						</table>
					</div>
					<div class="cl"></div>
					<div class="cchart"></div>
					<div class="bz"><textarea id="comment"></textarea></div>
				</div>
			</div>
		</div>
	</div>
</state:override>

<%@ include file="/common/block/block.jsp" %>

