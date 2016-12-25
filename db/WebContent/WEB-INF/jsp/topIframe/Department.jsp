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
 <%-- <jsp:include page="/WEB-INF/jsp/frame/dept_left.jsp"></jsp:include> --%>
	 <div class="UL">
		 <ul class="">
			<li class="sb" id=""><a href="addDept.shtml" target="deptleft" style="color: black;display: block;width: 230px;height: 45px;">Add Department</a></li>
			<li class="sb" id=""><a href="Dept_getList.shtml?pageSize=50&currentPage=1" target="deptleft" style="color: black;display: block;width: 230px;height: 45px;">Department List</a></li>
		</ul>
	</div>
	 <div class="frameContent">
	 	<iframe width="100%" height="580" scrolling="auto" name="deptleft" frameborder="0"  src="addDept.shtml"></iframe>
		<%-- <c:choose>
		<c:when test="${(sessionScope.cuslevel ge 0 and sessionScope.cuslevel le 3) or (sessionScope.cuslevel ge 7 and sessionScope.cuslevel le 10) or (sessionScope.cuslevel ge 15 and sessionScope.cuslevel le 22) or (sessionScope.cuslevel ge 24)}">
			<iframe width="100%" height="580" scrolling="auto"
				name="deptLeft" frameborder="0" src="applyFHLJ.shtml"></iframe>
		</c:when>
		<c:when test="${sessionScope.cuslevel ne 4 and sessionScope.cuslevel ne 6 and sessionScope.cuslevel ne 5}">
			<iframe width="100%" height="580" scrolling="auto"
				name="deptLeft" frameborder="0" src="applyQQJ.shtml"></iframe>
		</c:when>
		<c:otherwise>
			<iframe width="100%" height="580" scrolling="auto"
				name="deptLeft" frameborder="0" src="exchange.shtml"></iframe>
		</c:otherwise>
		</c:choose> --%>
	</div>
 </div>

</body>
</html>