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
						<c:forEach var="b" items="${bill}">
							<li class="fl"><a href="${pageContext.request.contextPath }${b.url}" name="${b.mname}">${b.mname}</a></li>
						</c:forEach>
					</ul>

				</div>
				<div class="rl ureg">
					<span>${userInfo.mname}</span>
					<span><a href="${pageContext.request.contextPath}/login/logout">注销</a></span>
				</div>
			</div>
			<div class="cl"></div>
		</div>
	</state:block>

	<state:block name="content"></state:block>

	<state:block name="footer"></state:block>
</body>
</html>
