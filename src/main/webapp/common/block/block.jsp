<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://www.state.com/state" prefix="state" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html >
<head>
	<script src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js" type="text/javascript" ></script>
	<script src="${pageContext.request.contextPath }/js/jquery.form.js" type="text/javascript" ></script>
	<script src="${pageContext.request.contextPath }/js/jquery.json.min.js" type="text/javascript" ></script>
	<state:block name="head"></state:block>
</head>
<body>
	
	<state:block name="header"></state:block>

	<state:block name="content"></state:block>

	<state:block name="footer"></state:block>
</body>
</html>