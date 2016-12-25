<%@page import="org.apache.struts2.ServletActionContext"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage=""%>
<%@page import="com.utils.Constant"%>
<%@ include file="/WEB-INF/jsp/common/common.inc"%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".scrollUl3").children().click(function(){
			//alert($(this).attr("id"));
			//$(this).toggleClass("sd-show3");
			$(this).siblings().removeClass("sd-show3");
			$(this).addClass("sd-show3");
		});
	});
</script>
<title>header</title>
<link rel="stylesheet" type="text/css" href="css/css.css" />
<link rel="stylesheet" type="text/css" href="css/common.css" />
<!--[if IE]>
		<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
<![endif]-->

<ul class="scrollUl3">
	<li class="sd-show3" id="mmmmm01"><a href="customerInfo.shtml" target="infomationleft" style="color: black;display: block;width: 230px;height: 45px;">会员资料</a></li>
	<li class="sd-hidden3" id="mmmmm02"><a href="passwordChange.shtml" target="infomationleft" style="color: black;display: block;width: 230px;height: 45px;">修改密码</a></li>
	<li class="sd-hidden3" id="mmmmm02"><a href="securityChange.shtml" target="infomationleft" style="color: black;display: block;width: 230px;height: 45px;">安全验证</a></li>
	<li class="sd-hidden3" id="mmmmm03"><a href="bankBinding.shtml" target="infomationleft" style="color: black;display: block;width: 230px;height: 45px;">绑定银行</a></li>
	<li class="sd-hidden3" id="mmmmm03"><a href="bankManage_getList.shtml?pageSize=10&currentPage=1" target="infomationleft" style="color: black;display: block;width: 230px;height: 45px;">银行卡管理</a></li>
	<li class="sd-hidden3" id="mmmmm04"><a href="alipayBinding.shtml" target="infomationleft" style="color: black;display: block;width: 230px;height: 45px;">绑定支付宝</a></li>
	<li class="sd-hidden3" id="mmmmm05"><a href="addressChange.shtml" target="infomationleft" style="color: black;display: block;width: 230px;height: 45px;">通讯地址</a></li>
	<!-- <li class="sd-hidden3" id="mmmmm06"><a href="behaviorControl.shtml" target="infomationleft" style="color: black;display: block;width: 230px;height: 45px;">行为限制</a></li> -->
	<!-- <li class="sd-hidden3" id="mmmmm07"><a href="passwordSafe_safePassword.shtml" target="infomationleft" style="color: black;display: block;width: 230px;height: 45px;">安全密码</a></li> -->
</ul>
