<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/common.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/common.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="js/inputChecker.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="leftFrameContent">
<div class="content">
<div class="formTitle"> Add Transaction (Borrow out)</div>
	<form class="form" action="Trans_add.shtml" id="TransAddFormId">
	<dl>
		<dd>
						<label>Item ID</label>
						<input type="text" name="item_id" id="item_id"  placeholder="last name" value="${t.item_id}">
					</dd>
					<dd id = "item_name" style="display:none;">
					<label>Item Name:&nbsp</label>
					<span ></span>
					</dd>
					<dd>
						<label>Personal ID</label>
						<input type="text" name="emp_id" id="emp_id"   placeholder="Item name" value="${t.emp_id}">
						
					</dd>
					<dd id = "emp_name" style="display:none;">
					<label>Personal Name:&nbsp</label>
					<span  ></span>
					</dd>
				
					 
					 <dd id="setreturntime">
						<label>Item ID</label>
						<input type="text" name="returntime" id="returntime"  placeholder="last name" value="${t.returntime}">
					</dd>
					

					<dt>
						<input type="submit" name="submit" value="Submit" class="button" >
					</dt>
				</dl>
			 
				<input type="hidden" name="i_mid" id="i_mid" value="${t_mid}" >
	</form>
</div>
</div>
<script type="text/javascript">
$('#ItemAddFormId').submit(function(){ 
	if($('#emp_name span').text()=='' || $('#emp_name span').text()=='Error' ||
		$('#item_name span').text()=='' || $('#item_name span').text()=='Error'	){
		alert("Please check the input");
		return false;
	}
});

$(function(){
	var t_mid=<%=request.getParameter("t_mid") %>;
	if (t_mid=="" || t_mid==null){
		$("#setreturntime").css("display","none");
		<%
		session.removeAttribute("t");
		%>
	}else{
		$("#setreturntime").css("display","block");
	}
});

$("#emp_id" ).focusout(function() {
	  var emp_id = $("#emp_id" ).val();
	  if (emp_id!="" && isNumber(emp_id)){
		  $("#emp_name").css("display","block");
	  	$.ajax({
		   //url: "Promotion_getPersonalById.shtml?timestamp="+((new Date()).getTime()),
		    url: "p_getPersonalById.shtml?pid="+(emp_id),
		    async: false,//改为同步方式
		    type: "POST",
		    data: { },
		    success: function (data) {
				var name = $(data).find("rstr").text();
				console.log("emp_id》"+name);
				name = name==""?"Error":name;
				$("#emp_name span").text(name);
		    }
		});
	  }else{
		  alert("Please input correct value")
	  }
	});
	
$("#item_id" ).focusout(function() {
	 var item_id = $("#item_id" ).val();
	  if (item_id!="" && isNumber(item_id)){
		  $("#item_name").css("display","block");
	  $.ajax({
		   //url: "Promotion_getPersonalById.shtml?timestamp="+((new Date()).getTime()),
		    url: "Item_checkItemById.shtml?iid="+item_id,
		    async: false,//改为同步方式
		    type: "POST",
		    data: { },
		    success: function (data) {
				var name = $(data).find("rstr").text();
				console.log("item_id》"+name);
				name = name==""?"Error":name;
				$("#item_name span").text(name);
		    }
		});
	  }else{
		  alert("Please input correct value")
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