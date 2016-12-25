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
<script type="text/javascript">
	$(function(){
		$(".scrollUl").children().click(function(){
			$(this).siblings().removeClass("sbAdd");
			$(this).addClass("sbAdd");
		});
	});
</script>
<c:if test="${empty sessionScope.loginname}">
	<script type="text/javascript">
		window.location.href="login.shtml";
	</script>
</c:if>
<div>
<h1 class="log">DB RESOURCE MANAGMENT</h1>

</div>
<div class= "main">

		<div class="topContent">
			<div>
				<ul class="scrollUl">
					<li class="" id="">
					<a target="topFrame" href="greeting.shtml">home</a> 
					</li>
					<li class="" id="">
					<a target="topFrame" href="Department.shtml">Department</a> 
					</li>
					<li class="" id="">
					<a target="topFrame" href="Personal.shtml">Personal</a> 
					</li>
					<li class="" id="">
					<a target="topFrame" href="Item.shtml">Item</a> 
					</li>
					<li class="" id="">
					<a target="topFrame" href="Transaction.shtml">Transaction</a> 
					</li>
					<li class="" id="">
					<a target="topFrame" href="Payment.shtml">Payment</a> 
					</li>
					<li class="" id="">
					<a target="topFrame" href="Report.shtml">Report</a> 
					</li>
					<li class="" id="">
					<a href="logout.shtml"><button id="logout" >Logout</button></a>
					</li>
				</ul>
			</div>
		</div>

		<iframe name="topFrame" id="topFrame" height="100%" src="greeting.shtml" scrolling="no" frameborder="0"width="980px"></iframe>
    
    
<div class="clear"></div>
</div>
</body>
</html>