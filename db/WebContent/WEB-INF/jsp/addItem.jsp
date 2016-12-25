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
<div class="formTitle"> Add Item</div>
	<form class="form" action="Item_add.shtml" id="ItemAddFormId">
	<dl>
					<dd>
						<label>Name</label>
						<input type="text" name="i_name" id="i_name"   placeholder="Item name" value="${i.name}">
					</dd>
					<dd>
						<label>Description</label>
						<input type="text" name="i_desp" id="i_desp"  placeholder="last name" value="${i.description}">
					</dd>
					<dd>
						<label>Department ID</label>
						<input type="text" name="dept_id" id="dept_id"   placeholder="loginname" value="${i.dept_id}">
					</dd>
					<dd>
						<label>value</label>
						<input type="text" name="i_value" id="i_value"  placeholder="password" value="${i.value}">
					</dd>
					<dd>
						<label>Quantity</label>
						<input type="text" name="i_qty" id="i_qty"  placeholder="password" value="${i.qty}">
					</dd>

					<dd>
						<label>Maxday</label>
						<input type="text" name="i_maxday" id="i_maxday"   placeholder="Maxday" value="${i.maxday}">
					</dd>
					<%-- <dd>
						<label>pay rate</label>
						<input type="text" name="i_rate" id="i_rate"  placeholder="role" value="${i.payrate}">
					</dd> --%>

					<dt>
						<input type="submit" name="submit" value="Submit" class="button" >
					</dt>
				</dl>
				<input type="hidden" name="i_id" id="i_id" value="${i_id}" >
				<input type="hidden" name="save" id="i_id" value="1" >
				<input type="hidden" name="i_mid" id="i_mid" value="${i_mid}" >
	</form>
</div>
</div>
<script type="text/javascript">
$('#ItemAddFormId').submit(function(){ 
	if($('#i_name').val()==''){
		alert("Please input first name");
		return false;
	}
	
	if($('#p_l_name').val()==''){
		alert("Please input last name");
		return false;
	}
	
});

$(function(){
	var i_mid=<%=request.getParameter("i_mid") %>;
	if (i_mid=="" || i_mid==null){
		<%
		session.removeAttribute("i");
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

</body>
</html>