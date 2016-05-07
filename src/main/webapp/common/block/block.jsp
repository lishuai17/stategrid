<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://www.state.com/state" prefix="state" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >
<head>
	<script src="${pageContext.request.contextPath }/js/jquery/jquery-1.8.3.min.js" type="text/javascript" ></script>
	<script src="${pageContext.request.contextPath }/js/jquery/jquery.form.js" type="text/javascript" ></script>
	<script src="${pageContext.request.contextPath }/js/jquery/jquery.json.min.js" type="text/javascript" ></script>
	<Link Rel="StyleSheet" Href="${pageContext.request.contextPath }/css/head.css" Type="Text/Css">
	<state:block name="head"></state:block>
</head>
<body>
	
	<state:block name="header">
		<div class="ttbg">
			<div class="mid">
				<div class="fl pdt10"><img src="${pageContext.request.contextPath }/img/logo.png"></div>
				<div class="menu">
					<ul>
						<li class="fl">数据申报</li>
						<li class="fl">限额管理</li>
						<li class="fl">发布</li>
						<li class="fl">撮合</li>
						<li class="fl">通道联络线管理</li>
						<li class="fl">用户管理</li>
					</ul>
				</div>
				<div class="rl ureg">
					<span>李小龙</span>
					<span>注销</span>
				</div>
			</div>
			<div class="cl"></div>
		</div>
	</state:block>

	<state:block name="content"></state:block>

	<state:block name="footer"></state:block>
</body>
</html>
