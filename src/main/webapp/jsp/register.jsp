<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://www.state.com/state" prefix="state"%>
<script type="text/javascript" src="js/jquery/jquery-1.8.3.min.js"></script>

<state:override name="head">
	<title>注册</title>
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
	//注册按钮事件
	$(function() {
		$("#register").click(function() {
			var user = $("#user").val();
			var password = $("#password").val();
			var passwords = $("#passwords").val();
			var area = $("#selectArea  option:selected").text();
			if(user.length<5||user.length>10){
				alert("帐号长度应控制在5-10个字符");
				return false;
			}
			if(password.length==0){
				alert("密码不能为空");
				return false;
			}
			if(password!=passwords){
				alert("两次密码输入不同，请核对后提交");
				return false;
			}
			var pd=confirm("您确定要对(用户："+user+",地区："+area+")注册吗？");
			if(pd==true){
				//检查用户是否存在
				var isNo=false;
				var option = {
						url : "${pageContext.request.contextPath }/login/containUser",
						type : "post",
						data : {
							user : user
						},
						dataType : "json",
						success : function(response) {
							if ("fail" == response) {
								alert("此帐户已存在");
								return false;
							}else if("noapprove" == response){
								alert("此帐户未审核");
							}else{
								var options = {
										url : "${pageContext.request.contextPath }/login/registerUser",
										type : "post",
										data : {
											user : user,
											password : password,
											area : area
										},
										dataType : "json",
										success : function(response) {
											if("success" == response) {
												alert("注册成功，请联系管理员进行审批");
											}else {
												alert("注册失败");
											}
										},
										error : function() {
											alert("系统错误");
										}
									};
									$.ajax(options);
							}
						},
						error : function() {
							alert("检查用户是否存在系统出错");
						}
					};
					$.ajax(option);
			}
		});
	
	});
</script>


</state:override>
<state:override name="header"><div></div></state:override>
<state:override name="content">
	<div class="wrapper">
		<form id="form111"
			action="${pageContext.request.contextPath }/login/validLogin"
			method="post">
			<div class="loginBox">
				<div class="loginBoxCenter">
					<p>
						<label for="username">账号：</label>
					</p>
					<p>
						<input type="text" id="user" name="user" class="loginInput"
							autofocus="autofocus" required="required" autocomplete="off"
							placeholder="请输入帐号" value="" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')"/>
					</p>
					<p>
						<label for="password">密码：</label>
					</p>
					<p>
						<input type="password" id="password" name="password"
							class="loginInput" required="required" placeholder="请输入密码"
							value="" />
					</p>
					<p>
					<label for="password">确认密码：</label>
					</p>
					<p>
						<input type="password" id="passwords" name="passwords"
							class="loginInput" required="required" placeholder="请再次输入密码"
							value="" />
					</p>
					<p>
					<label for="password">区域：</label>
					</p>
					<p>
						<select name="selectArea" id="selectArea">   
					        <option value="1">四川</option>   
					        <option value="2">上海</option>   
					        <option value="3">江苏</option>   
					        <option value="4">浙江</option>   
					    </select>
					</p>
				</div>
				<div class="loginBoxButtons">
					<input type="button" class="loginBtn" id="register" value="注册" />
				</div>
			</div>
		</form>
	</div>

</state:override>

<%@ include file="/common/block/block_none.jsp" %>
