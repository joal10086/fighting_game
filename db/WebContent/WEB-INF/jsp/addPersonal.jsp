<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/common.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/common.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script src="js/datepicker/WdatePicker.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="leftFrameContent">
<div class="content">
<div class="formTitle"> Add Personal</div>
	<form class="form" action="p_savePersonal.shtml" id="PersonalAddFormId">
	<dl>
					<dd>
						<label>Loginname</label>
						<input type="text" name="p_loginname" id="p_loginname"   placeholder="loginname" value="${p.loginname}">
					</dd>
					<dd>
						<label>Password</label>
						<input type="text" name="p_password" id="p_password"  placeholder="password" value="${p.password}">
					</dd>
					<dd>
						<label>First Name</label>
						<input type="text" name="p_f_name" id="p_f_name"   placeholder="first name" value="${p.firstname}">
					</dd>
					<dd>
						<label >Last Name</label>
						<input type="text" name="p_l_name" id="p_l_name"  placeholder="last name" value="${p.lastname}">
					</dd>
					<dd>
					<label >Gender</label>
					 <c:choose>
			        	<c:when test="${p.gender eq 1}">
			        	 	<input type="text" value="Male" id="gender" name="gender" disabled="disabled"/>
			        	</c:when>
			        	<c:when test="${p.gender eq 0}">
					        <input type="text" value="Female" id="gender" name="gender" disabled="disabled"/>
			        	</c:when>
			        	<c:otherwise>
						<select name="gender" id="gender" style="margin-left:70px;">
	        			<option value="1">Male</option>
	        			<option value="0">Female</option>
	        			</select>
			        	</c:otherwise>
		       		</c:choose>
        			</dd>
					<dd>
						<label>Department ID:</label>
						<input type="text" name="p_dept_id" id="p_dept_id"   placeholder="department id" value="${p.dept_id}">
					</dd>
					<dd>
						<label>Role：</label>
						<input type="text" name="p_role" id="p_role"  placeholder="role" value="${p.role}">
					</dd>
						<dd>
						<label>Birthday：</label>
						<input type="text" name="p_bd" id="p_bd" class="dateinfo"  placeholder="birthday" value="${p.birthday}" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',autoPickDate:'true'})">
					</dd>
						<dd>
						<label>Email：</label>
						<input type="text" name="p_email" id="p_email"  placeholder="email" value="${p.email}">
					</dd>
						<dd>
						<label>Phone：</label>
						<input type="text" name="p_phone" id="p_phone"  placeholder="phone" value="${p.phone}">
					</dd>
					<dt>
						<input type="submit" name="submit" value="Submit" class="button" >
					</dt>
				</dl>
				<input type="hidden" name="p_id" id="p_id" value="${p.emp_id}" >
				<input type="hidden" name="modify" id="modify" value="<%=request.getParameter("modify") %>" >
				<input type="hidden" name="loginname" id="loginname" value="${sessionScope.loginname}" >
	</form>
</div>
</div>
<script type="text/javascript">
$('#loginButton').click(function(){ 
	$("#logininput").css("display","block");
	
});

$(function(){
	var p_mid=<%=request.getParameter("p.id") %>;
	if (p_mid=="" || p_mid==null){
		<%
		session.removeAttribute("p");
		%>
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

 <script type="text/javascript">
   /*  jeDate({
		dateCell:".dateinfo",
		format:"YYYY-MM-DD",
		isinitVal:false,
		isTime:true, //isClear:false,
		//minDate:"2014-09-19 00:00:00",
		okfun:function(val){alert(val)}
	}); */
</script>

</body>
</html>