<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/common.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/common.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<title>DB RESOURCE MANAGMENT</title>
</head>
<body>

<c:if test="${not empty sessionScope.loginname}">
	<script type="text/javascript">	
	window.location.href = 'index.shtml';
	</script>
</c:if>

<script type="text/javascript">
	$(function(){
		$(".scrollUl").children().click(function(){
			//alert($(this).attr("class"));
			$(this).siblings().removeClass("sd-show");
			$(this).addClass("sd-show");
			//$(".scrollUl li:first-child").addClass("sd-show");
		});
	});
</script>


<h1 class="log">DB RESOURCE MANAGMENT</h1>
<div class= "main">
<c:choose>
	<c:when test="${empty sessionScope.loginname }">
		<form class="form" action="p_login.shtml" method="post" id="loginFormId" name="loginFormId">
			<dl>
				<dd>
					<label>loginname：</label>
					<input type="text" name="loginname" id="loginname"   placeholder="loginname">
				</dd>
				<dd>
					<label>password：</label>
					<input type="password" name="password" id="password"  placeholder="password">
				</dd>
				<dd>
				<label>verify_code：</label>
					<input type="text" maxlength="4" name="captcha" id="login_captcha"  placeholder="verification code">
					<img src="./captcha.shtml">
				</dd>
				<dt>
					<input type="submit" name="submit" value="login" class="button" style="width:160px;height:30px;margin-left:-100px;;">
					<!-- <a href="forgetPwd1.shtml" class="forPw">forgetPW</a> -->
				</dt>
			</dl>
			<input type="hidden" name="custype" value="1" />
			<div class="clear"></div>
		</form>

	</c:when>
</c:choose>

 

    
<c:if test="${not empty message}">
	<script type="text/javascript">
	    function displayMessage(){
	       	<c:choose>
				<c:when test="${message == 'done' }">alert('done');</c:when>
				<c:otherwise>alert('<c:out value="${message}"/>');</c:otherwise>
			</c:choose>
		}
		window.setTimeout(displayMessage,100);
	</script>	
</c:if>	
</div>
</body>
</html>