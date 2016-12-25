<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/common.css" type="text/css" rel="stylesheet"/>
<title>DB RESOURCE MANAGMENT</title>
</head>
<body>
<c:if test="${empty sessionScope.loginname}">
	<script type="text/javascript">	
	Window.parent.location.href="login.shtml";
	</script>
</c:if>
<div class="leftContent">
	 <div class="UL">
		 <ul class="">
			<li class="sb" id=""><a href="addPayment.shtml" target="transleft" style="color: black;display: block;width: 230px;height: 45px;">Add Payment</a></li>
			<li class="sb" id=""><a href="Payment_getPaymentList.shtml?pageSize=50&currentPage=1" target="transleft" style="color: black;display: block;width: 230px;height: 45px;">Payment List</a></li>
		</ul>
	</div>
	 <div class="frameContent">
	 	<iframe width="100%" height="580" scrolling="auto" name="transleft" frameborder="0"  src="addPayment.shtml"></iframe>
	</div>
 </div>
    
    

</body>
</html>