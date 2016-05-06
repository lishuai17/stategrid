<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://www.state.com/state" prefix="state"%>

<state:override name="head">
	<title>登录</title>
	<style>
html {
	background-color: #E9EEF0
}

.wrapper {
	margin: 140px auto;
	width: 884px;
}

.loginBox {
	background-color: #FEFEFE;
	border: 1px solid #BfD6E1;
	border-radius: 5px;
	color: #444;
	font: 14px 'Microsoft YaHei', '微软雅黑';
	margin: 0 auto;
	width: 388px
}

.loginBox .loginBoxCenter {
	border-bottom: 1px solid #DDE0E8;
	padding: 24px;
}

.loginBox .loginBoxCenter p {
	margin-bottom: 10px
}

.loginBox .loginBoxButtons {
	background-color: #F0F4F6;
	border-top: 1px solid #FFF;
	border-bottom-left-radius: 5px;
	border-bottom-right-radius: 5px;
	line-height: 28px;
	overflow: hidden;
	padding: 20px 24px;
	vertical-align: center;
}

.loginBox .loginInput {
	border: 1px solid #D2D9dC;
	border-radius: 2px;
	color: #444;
	font: 12px 'Microsoft YaHei', '微软雅黑';
	padding: 8px 14px;
	margin-bottom: 8px;
	width: 310px;
}

.loginBox .loginInput:FOCUS {
	border: 1px solid #B7D4EA;
	box-shadow: 0 0 8px #B7D4EA;
}

.loginBox .loginBtn {
	background-image: -moz-linear-gradient(to bottom, #B5DEF2, #85CFEE);
	border: 1px solid #98CCE7;
	border-radius: 20px;
	box-shadow: inset rgba(255, 255, 255, 0.6) 0 1px 1px, rgba(0, 0, 0, 0.1)
		0 1px 1px;
	color: #2B2929;
	cursor: pointer;
	float: right;
	font: bold 13px Arial;
	padding: 5px 14px;
}

.loginBox .loginBtn:HOVER {
	background-image: -moz-linear-gradient(to top, #B5DEF2, #85CFEE);
}

.loginBox a.forgetLink {
	color: #ABABAB;
	cursor: pointer;
	float: right;
	font: 11px/20px Arial;
	text-decoration: none;
	vertical-align: middle;
}

.loginBox a.forgetLink:HOVER {
	text-decoration: underline;
}

.loginBox input#remember {
	vertical-align: middle;
}

.loginBox label[for="remember"] {
	font: 11px Arial;
}
</style>

<script type="text/javascript">
	$(function() {

		$("#loginBtn").click(function() {
			var email = $("#email").val();
			var password = $("#password").val();
			validLogin(email, password);
		});

	});
	//如果在方法中使用ajax的返回值作为方法的返回值一定要把ajax变成同步的	
	function validLogin(email, password) {
		var result = "no";
		var option = {
			url : "${pageContext.request.contextPath }/login/validLogin",
			type : "post",
			data : {
				email : email,
				password : password
			},
			dataType : "json",
			success : function(responseText) {
				if ("success" == responseText) {
					window.location.href = "${pageContext.request.contextPath }/index/frame/index";
				} else {
					alert("用户名密码错误");
				}
			},
			error : function() {
				alert("系统错误");
			}
		};
		$.ajax(option);
	}
</script>


</state:override>

<state:override name="content">
	<div class="wrapper">
		<form id="form111"
			action="${pageContext.request.contextPath }/login/validLogin"
			method="post">
			<div class="loginBox">
				<div class="loginBoxCenter">
					<input type="hidden" name="state" value="${state}" /> <input
						type="hidden" name="response_type" value="${code }" />
					<p>
						<label for="username">账号：</label>
					</p>
					<p>
						<input type="text" id="email" name="email" class="loginInput"
							autofocus="autofocus" required="required" autocomplete="off"
							placeholder="请输入电子邮箱" value="" />
					</p>
					<p>
						<label for="password">密码：</label><a class="forgetLink" href="#">忘记密码?</a>
					</p>
					<p>
						<input type="password" id="password" name="password"
							class="loginInput" required="required" placeholder="请输入密码"
							value="" />
					</p>
				</div>
				<div class="loginBoxButtons">
					<input id="remember" type="checkbox" name="remember" /> <input
						type="button" class="loginBtn" id="loginBtn" value="登录" />

				</div>
			</div>
		</form>
	</div>

</state:override>

<%@ include file="/common/block/block.jsp" %>
