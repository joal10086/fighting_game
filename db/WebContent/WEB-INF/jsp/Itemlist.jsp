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

<s:form action="Item_changeFlag" namespace="/" theme="simple" name="setInforForm" id="setInforForm">
		<s:hidden name="updateId" id="updateId" ></s:hidden>
		<s:hidden name="updateflag" id="updateflag" ></s:hidden>
</s:form>
<s:form action="Dept_delete" namespace="/" name="deleteForm" id="deleteForm" theme="simple" >
		<s:hidden name="deleteid" id="deleteid"></s:hidden>
</s:form>
<div> 
		<div>Item List</div>
 
			<form action="Item_getItemList.shtml" namespace="/" name="searchForm" id="searchForm">
				<input type="text" name="i_text" id="i_text" >
				<select name="i_type" id="i_type">
       			 <option value="0" selected="selected">name</option>
       			 <option value="1">location</option>
       			</select>	
				<Button name="submit"  style="width:100px;height:22px;">Search</Button>
			</form>
			<div style="">
			<table width="100%" border="0" cellspacing="10" cellpadding="50" class="table-main" >
				<tr class="">	
					<td align="left" width="10" valign="middle" style="padding-right:15px;">
						No
					</td>				
					<td align="left" width="130" valign="middle">
						Name
					</td>	
					<td align="left" width="200" valign="middle">
						description
					</td>
					<td align="left" width="120" valign="middle">
						department
					</td>
					<td align="left" width="120" valign="middle">
						Create time
					</td>
					<td align="left" width="40" valign="middle" style="padding-right:10px;">
						delete
					</td>					
					<td align="left" width="40" valign="middle">
						modify
					</td>																						
				</tr>
				</table>
				</div>
				<div  style="height:360px; width:100%;OVERFLOW-Y: auto;">
				<table width="100%" border="0" cellspacing="10" cellpadding="50" class="table-main">
				<!-- Iteration -->
				<c:set var="total" value="0" />
				<c:forEach items="${page.contents}" var="infor">
				<tr   style="background-color: #FFE7A5; cursor: pointer;" >
					<td align="left" width="50" valign="middle"> <c:out value="${total}"/><c:set var="total" value="${total+1}" /></td> 						
					<td align="left" width="150" valign="middle"> <c:out value="${infor.iname}"/></td> 						
					<td align="left" width="200" valign="middle"><c:out value="${infor.description}"/></td>
					<td align="left" width="100" valign="middle"><c:out value="${infor.dname}"/></td>
					<td align="left" width="180" valign="middle"><c:out value="${infor.createtime}"/></td>
					<td align="left" width="60" valign="middle">	
						<input type="button" value="delete"  class="updateButton" newflag="0" buttonId="${infor.dept_id}" />
					</td>
					<td align="left" valign="middle"  >
						<a class="showDetail" href="Item_add.do?i_mid=${infor.item_id}">
						<input type="button" value="modify" class="modifyBtn" buttonId="${infor.dept_id}" id="modifyBtn">
						</a>
					</td>					
				</tr>
				</c:forEach>                   
               <!-- End Iteration -->
		

				<!-- Pagination -->
				<%-- <c:if test="${not empty page.contents}">							
				<tr>      	 	
					<td colspan="19" align="right" valign="middle" class="bg-table-bottom">
						
						<c:if test="${page.currentPage gt 1}">
							<img src="<c:url value="/images/previous_2.jpg"/>" align="absmiddle"
								style="cursor: pointer;" onclick="pagination('1')">
                       	 	<img src="<c:url value="/images/previous.jpg"/>" align="absmiddle"
								style="cursor: pointer;" onclick="pagination('<c:out value="${page.currentPage-1}"/>')">
                             	 </c:if>
						<c:if test="${page.totalPages gt 1}">
							<select style="text-align:center;" name="pageNo" onchange="pagination(this.value)" >
								<c:forEach begin="1" end="${page.totalPages}" var="count">
									<option <c:if test="${page.currentPage eq count}">selected="selected"</c:if> value="<c:out value="${count}"/>"><c:out value="${count}"/>
									</option>
								</c:forEach>
							</select>
						</c:if>
						<c:if test="${page.currentPage ne page.totalPages}">
							<img src="<c:url value="/images/next.jpg"/>" align="absmiddle"
								style="cursor: pointer;" onclick="pagination('<c:out value="${page.currentPage+1}"/>')">
							<img src="<c:url value="/images/next_2.jpg"/>"  
								style="cursor: pointer;" onclick="pagination('<c:out value="${page.totalPages}"/>')">
						</c:if>
						total records:<c:out value="${page.totalSize}" />, total pages: <c:out value="${page.totalPages}" />
					</td>
				</tr> 
				</c:if>
				<c:if test="${empty page.contents}">
					<tr>
						<td style="color: #23659A; font-weight: bold;" align="center" colspan="19" class="td-white">
							no data
						</td>
					</tr>
				</c:if> --%>
				<!-- End Pagination -->
				
			</table>	
			</div>					
</div>
</div>
</div>
<script type="text/javascript">
$(".updateButton").click(function(){		
	var buttonId = $(this).attr("buttonId");
	var newflag = $(this).attr("newflag");
	  if (newflag=='0'){
		if(confirm("Are you sure to delete this record?")){
			$('#updateId').val(buttonId);
			$('#updateflag').val(0);
		    $('#setInforForm').submit();	
		    return true;	    
		}else{
			return false;
		}	
	} 
});

$(function(){
	//style="height:400px;OVERFLOW-Y: auto;"
	/* $("#contentId").css("height","100px");
	$("#contentId").css("OVERFLOW-Y","auto"); */
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