<%@page import="org.apache.struts2.ServletActionContext"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage=""%>
<%@ include file="/WEB-INF/jsp/common/common.inc"%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".frameLeftUI").children().click(function(){
			$(this).siblings().removeClass("sbAdd");
			$(this).addClass("sbAdd");
		});
	});
</script>
<title>header</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<!--[if IE]>
		<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
<![endif]-->
<div class="leftContent">
<ul class="">
	<li class="sb" id=""><a href="addDept.shtml" target="deptleft" style="color: black;display: block;width: 230px;height: 45px;">Add Department</a></li>
	<li class="sb" id=""><a href="Dept_getList.shtml?pageSize=50&currentPage=1" target="deptleft" style="color: black;display: block;width: 230px;height: 45px;">Department List</a></li>
	<!-- <li class="sd-hidden3" id="mmmmm06"><a href="behaviorControl.shtml" target="infomationleft" style="color: black;display: block;width: 230px;height: 45px;">行为限制</a></li> -->
	<!-- <li class="sd-hidden3" id="mmmmm07"><a href="passwordSafe_safePassword.shtml" target="infomationleft" style="color: black;display: block;width: 230px;height: 45px;">安全密码</a></li> -->
</ul>
</div>