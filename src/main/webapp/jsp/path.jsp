<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://www.state.com/state" prefix="state"%>

<state:override name="head">
	<title></title>
	<Link Rel="StyleSheet" Href="${pageContext.request.contextPath }/css/line.css" Type="Text/Css">
	<script src="${pageContext.request.contextPath }/js/state/path.js"></script>
	<script type="text/javascript">
		$(function(){
			$('.menu').find('a[name=通道联络线管理]').attr('class', 'menufocus');
		});
	
		var path = new Path();
		$(function(){
			path.getAllPath('pathTable','pathCount');
			path.getAllLine('lineTable', 'lineCount','lineSelect1');
			var linesArea = new Array();
			linesArea.push($("#startLine"));
			linesArea.push($("#endLine"));
			linesArea.push($("#lstartLine"));
			linesArea.push($("#lendLine"));
			areaSelect('${pageContext.request.contextPath}/area/getAllArea',linesArea);
		});
		
		function savePath(){
			var name = $("#addPathName").val();
			var start = $("#addPathStart").val();
			var end = $("#addPathEnd").val();
			var lines = new Array();
			lines.push();
			path.savePath(name, start, end, lines);
		}
		
		function saveLine(){
			var name = $("#addPathName").val();
			var start = $("#addPathStart").val();
			var end = $("#addPathEnd").val();
			path.saveLine(name, start, end);
		}
		
	</script>
</state:override>
<state:override name="content">
	<div>
			<div class="mid">
				<div class="contop">
					<div class="fl"><span class="xmenu">通道管理</span><span id="pathCount" class="count"></span></div>
					<div class="rl"><span><a class="btn1" href="javascript:void(0);" onclick="path.addPath('tk')">+添加</a></span></div>
					<div class="cl"></div>
				</div>
				<div>
					<div class="fl bd1 ustb">
						<div class="fl">
							<table id="pathTable" width="1170" cellpadding="0" cellspacing="0">
							</table>
						</div>
						<div class="cl"></div>
					</div>
				</div>
				<div class="contop">
					<div class="fl pdt20"><span class="xmenu">联络线管理</span><span id="lineCount" class="count"></span></div>
					<div class="rl pdt20"><span><a class="btn1"  href="javascript:void(0);" onclick="path.addLine('tk_line')">+添加</a></span></div>
					<div class="cl"></div>
				</div>
				<div>
					<div class="fl bd1 ustb">
						<div class="fl">
							<table id="lineTable" width="1170" cellpadding="0" cellspacing="0">
								
							</table>
						</div>
						<div class="cl"></div>
					</div>
				</div>
			</div>
		</div>
		<div id="tk">
			<div class="bcon">
				<div class="rl"><a class="btn3" href="javascript:void(0);" onclick="path.displayAddPanel('tk')">x</a></div>
				<div class="cl"></div>
				<div class="pdt20" >
					<div>通道名称&nbsp;&nbsp;<input id="addPathName" /></div>
					<div class="pdt20 ">
						<span>首端&nbsp;&nbsp;</span><select id="startLine"> </select>
						
						<span>末端&nbsp;&nbsp;</span><select id="endLine"> </select>
					</div>
					<div id="lineSelectDiv">
						<div class="fl pdt20" id="firstSelectPanel">
							成员1&nbsp;&nbsp;<select id="lineSelect1">
							     
						         </select>
							
							<span>成员方向&nbsp;&nbsp;</span><select>
							     <option value ="+">正</option>
	                             <option value ="-">反</option>
						         </select>
							<a class="btn3 addPath" href="javascript:void(0);" onclick="path.addLineSelect()">+</a>
						</div>
						<div class="cl"></div>
					</div>
					
					
					<div class="cl"></div>
					<div class="pdt20 rl pdr20"><a class="btn1"  href="javascript:void(0);" onclick="path.savePath('addPathName', 'startLine', 'endLine','lineSelectDiv')">提交</a></div>
				</div>
			</div>
			<div class="blbg">&nbsp;</div>
		</div>
		<div id="tk_line">
			<div class="bcon">
				<div class="rl"><a class="btn3" href="javascript:void(0);" onclick="path.displayAddLinePanel('tk_line')">x</a></div>
				<div class="cl"></div>
				<div class="pdt20" >
					<div>联络线名称&nbsp;&nbsp;<input id="addLineName" /></div>
					<div class="pdt20 ">
						<span>首端&nbsp;&nbsp;</span><select id="lstartLine"> </select>
						
						<span>末端&nbsp;&nbsp;</span><select id="lendLine"> </select>
					</div>
					
					<div class="cl"></div>
					<div class="pdt20 rl pdr20"><a class="btn1" href="javascript:void(0);" onclick="path.saveLine('addLineName', 'lstartLine', 'lendLine')">提交</a></div>
				</div>
			</div>
			<div class="blbg">&nbsp;</div>
		</div>
</state:override>

<%@ include file="/common/block/block.jsp" %>

