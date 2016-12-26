<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/common.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/common.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="leftFrameContent">
<div class="content">
<div class="formTitle"> Add Department(changing check)</div>
	<form class="form" action="Dept_add.shtml" id="DeptAddFormId">
	<dl>
					<dd>
						<label>Name：</label>
						<input type="text" name="dept_name" id="dept_name"   placeholder="Name" value="${dept_name}">
					</dd>
					<dd>
						<label>Location：</label>
						<input type="text" name="dept_addr" id="dept_addr"  placeholder="Location" value="${dept_addr}">
					</dd>
					<!-- <dd>
					<label>verify_code：</label>
						<input type="text" maxlength="4" name="captcha" id="login_captcha"  placeholder="verification code">
						<img src="./captcha.shtml">
					</dd> -->
					<dt>
						<input type="submit" name="submit" value="Submit" class="button" >
					</dt>
				</dl>
				<input type="hidden" name="dept_id" id="dept_id" value="${dept_id}" >
	</form>
</div>
</div>
<script type="text/javascript">
$('#DeptAddFormId').submit(function(){ 
	if($('#dept_name').val()==''){
		alert("Please input department name");
		return false;
	}
	
	if($('#dept_addr').val()==''){
		alert("Please input department address");
		return false;
	}
	
});

$(function(){
	var dept_mid=<%=request.getParameter("dept_mid") %>;
	if (dept_mid=="" || dept_mid==null){
		$("#dept_name").val("");
		$("#dept_addr").val("");
		$("#dept_id").val("");
	}
});
</script>


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

</body>
</html>