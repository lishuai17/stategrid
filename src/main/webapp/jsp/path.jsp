<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://www.state.com/state" prefix="state"%>

<state:override name="head">
	<title></title>
	<Link Rel="StyleSheet" Href="${pageContext.request.contextPath }/css/line.css" Type="Text/Css">
	<script src="${pageContext.request.contextPath }/js/state/path.js"></script>
	<script type="text/javascript">
		$(function(){
			var linesArea = new Array();
			linesArea.push($("#startLine"))
			linesArea.push($("#endLine"))
			areaSelect('${pageContext.request.contextPath}/area/getAllArea',linesArea);
		})
	</script>
</state:override>
<state:override name="content">
	<div>
			<div class="mid">
				<div class="contop">
					<div class="fl"><span class="xmenu">通道管理</span><span class="count">25条</span></div>
					<div class="rl"><span><a class="btn1" href="#">+添加</a></span></div>
					<div class="cl"></div>
				</div>
				<div>
					<div class="fl bd1 ustb">
						<div class="fl">
							<table width="1170" cellpadding="0" cellspacing="0">
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
									<td width="7%">2</td>
									<td width="7%"><a class="btn3" href="#">删除</a></td>
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
									<td width="7%"><a class="btn3" href="#">删除</a></td>
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
									<td width="7%"><a class="btn3" href="#">删除</a></td>
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
									<td width="7%"><a class="btn3" href="#">删除</a></td>
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
									<td width="7%"><a class="btn3" href="#">删除</a></td>
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
									<td width="7%"><a class="btn3" href="#">删除</a></td>
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
									<td width="7%"><a class="btn3" href="#">删除</a></td>
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
									<td width="7%"><a class="btn3" href="#">删除</a></td>
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
									<td width="7%"><a class="btn3" href="#">删除</a></td>
								</tr>
							</table>
						</div>
						<div class="cl"></div>
					</div>
				</div>
				<div class="contop">
					<div class="fl pdt20"><span class="xmenu">联络线管理</span><span class="count">25条</span></div>
					<div class="rl pdt20"><span><a class="btn1" href="#">+添加</a></span></div>
					<div class="cl"></div>
				</div>
				<div>
					<div class="fl bd1 ustb">
						<div class="fl">
							<table width="1170" cellpadding="0" cellspacing="0">
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
									<th width="7%"></th>
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
									<td width="7%"><a class="btn3" href="#">删除</a></td>
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
									<td width="7%"><a class="btn3" href="#">删除</a></td>
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
									<td width="7%"><a class="btn3" href="#">删除</a></td>
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
									<td width="7%"><a class="btn3" href="#">删除</a></td>
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
									<td width="7%"><a class="btn3" href="#">删除</a></td>
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
									<td width="7%"><a class="btn3" href="#">删除</a></td>
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
									<td width="7%"><a class="btn3" href="#">删除</a></td>
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
									<td width="7%"><a class="btn3" href="#">删除</a></td>
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
									<td width="7%"><a class="btn3" href="#">删除</a></td>
								</tr>
							</table>
						</div>
						<div class="cl"></div>
					</div>
				</div>
			</div>
		</div>
		<div id="tk">
			<div class="bcon">
				<div class="rl"><a class="btn3" href="#">x</a></div>
				<div class="cl"></div>
				<div class="pdt20">
					<div>通道名称<input name="名称" /></div>
					<div class="fl pdt20 ">
					<div><span>首端</span><select id="startLine">
						     <option value ="t1">文字1</option>
                             <option value ="t2">文字2</option>
                             <option value="t3">文字3</option>
                             <option value="t4">文字4</option>
					         </select>
					</div>
					<div class="pdt10"><span>末端</span><select id="endLine">
						     <option value ="t1">文字1</option>
                             <option value ="t2">文字2</option>
                             <option value="t3">文字3</option>
                             <option value="t4">文字4</option>
					         </select>
					</div>
					<div class="pdt10"><span>成员</span><select >
						     <option value ="t1">文字1</option>
                             <option value ="t2">文字2</option>
                             <option value="t3">文字3</option>
                             <option value="t4">文字4</option>
					         </select>
					</div>
					<div class="pdt10"><span>成员方向</span><select>
						     <option value ="t1">文字1</option>
                             <option value ="t2">文字2</option>
                             <option value="t3">文字3</option>
                             <option value="t4">文字4</option>
					         </select>
					</div>
					</div>
					<div class="fl pdt20 pdl30">
						<div  class="pdl10">成员1<select>
						     <option value ="t1">文字1</option>
                             <option value ="t2">文字2</option>
                             <option value="t3">文字3</option>
                             <option value="t4">文字4</option>
					         </select>
					    </div>
					    <div  class="pdl10 pdt10 fl">成员1<select>
						     <option value ="t1">文字1</option>
                             <option value ="t2">文字2</option>
                             <option value="t3">文字3</option>
                             <option value="t4">文字4</option>
					         </select>
					    </div>
					    <div class="pdl10 pdt10 fl"><a class="btn3">+</a></div>
					    
					</div>
					<div class="cl"></div>
					<div class="pdt20 rl pdr20"><a class="btn1"  href="#">提交</a></div>
				</div>
			</div>
			<div class="blbg">fff</div>
		</div>
	
</state:override>

<%@ include file="/common/block/block.jsp" %>

