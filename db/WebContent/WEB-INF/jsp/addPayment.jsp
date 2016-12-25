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
<div class="formTitle"> Add Payment</div>
	<form class="form" action="Payment_add.shtml" id="PaymentAddFormId">
	<dl>
		<dd>
						<label>Transaction ID</label>
						<input type="text" name="use_id" id="use_id"  placeholder=" ID"  >
					</dd>
					<dd id = "useinfor" style="display:none;">
					<label>Transaction infor:&nbsp</label>
					<span ></span>
					</dd>
					<dd>
						<label>Amount</label>
						<input type="text" name="amount" id="amount"   placeholder="Amount" value="">
						
					</dd>
					<!-- <dd id = "emp_name" style="display:none;">
					<label>Personal Name:&nbsp</label>
					<span  ></span>
					</dd> -->
				
					 
					 <dd id="setreturntime">
						<label>Remark:</label>
						<input type="text" name="remark" id="remark"  placeholder="remark" value="">
					</dd>
					

					<dt>
						<input type="submit" name="submit" value="Submit" class="button" >
					</dt>
				</dl>
			 
				<input type="hidden" name="i_mid" id="i_mid" value="" >
				<input type="hidden" name="loginname" id="loginname" value="${sessionScope.loginname}" >
	</form>
</div>
</div>
<script type="text/javascript">
$('#PaymentAddFormId').submit(function(){ 
/* 	if($('#emp_name span').text()=='' || $('#emp_name span').text()=='Error' ||
		$('#item_name span').text()=='' || $('#item_name span').text()=='Error'	){
		alert("Please check the input");
		return false;
	} */
	var use_id= $("#use_id" ).val();
	 if (use_id=="" || $("#useinfor span").text()=="Error" ){
		alert("check input correct transaction id");
		return false;
	 } 
	 
	 var remark= $("#remark" ).val();
	 if (remark=="" ){
		 alert("please input remark");
		return false;
	 } 
	 
	 var amount= $("#amount" ).val();
	 if (amount=="" || (!isNum(amount))){
		 alert("please input correct amount");
		return false;
	 } 
});

 

$("#use_id" ).focusout(function() {
	  var use_id = $("#use_id" ).val();
	  if (use_id!="" && isNumber(use_id)){
		  $("#useinfor").css("display","block");
	  	$.ajax({
		   //url: "Promotion_getPersonalById.shtml?timestamp="+((new Date()).getTime()),
		    url: "Trans_checkTransId.shtml?use_id="+use_id,
		    async: false,//改为同步方式
		    type: "POST",
		    data: { },
		    success: function (data) {
				var name = $(data).find("rstr").text();
				console.log("emp_id》"+name);
				name = name==""?"Error":name;
				$("#useinfor span").text(name);
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