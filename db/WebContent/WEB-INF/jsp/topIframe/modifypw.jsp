<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/common.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<title>DB RESOURCE MANAGMENT</title>
</head>
<body>
<c:if test="${empty sessionScope.loginname}">
	<script type="text/javascript">	
	Window.parent.location.href="login.shtml";
	</script>
</c:if>

  
 <div id="changepwForm" >
 <form class="form" action="p_mpdifyPersonalPW.shtml" method="post" id="mpdify" name="mpdify">
	<dl>
					<dd>
						<label>loginname：</label>
						<input type="text" name="loginname" id="loginname" readonly="readonly"  placeholder="loginname" value="${sessionScope.loginname}">
					</dd>
					<dd>
						<label>current password：</label>
						<input type="text" name="password" id="password"  placeholder="password" value="">
					</dd>
					<dd>
						<label>new password：</label>
						<input type="text" name="newpassword" id="newpassword"  placeholder="new password" value="">
					</dd>
					<dd>
						<label>retype new password：</label>
						<input type="text" name="renewpassword" id="renewpassword"  placeholder="retype new password" value="">
					</dd>
				 	
					<dt style="">
						<input style="margin:0 auto;width:80px;" type="submit" name="submit" value="Submit" id="submit" >
					</dt>
				</dl>
				
				</form>
 </div>
<script type="text/javascript">
    $('#submit').click(function(){ 
    	if($('#password').val()==''){
    		alert("Please input current password");
    		return false;
    	}
    	
    	if($('#newpassword').val()==''){
    		alert("Please input new password");
    		return false;
    	}
    	if($('#newpassword').val()!= $('#renewpassword').val()){
    		alert("new password doesn't match");
    		return false;
    	}
    	
    	if(confirm('Are you sure to submit?')){
    		return true;
    		
    		/* var password=$('#password').val()
    		alert(password);
    		$.post("p_mpdifyPersonalPW.shtml",{ loginname:loginname,password:password,newpassword:newpassword,renewpassword:renewpassword } ,function(data)
    		        {	
    					var result = $(data).find("result").text();
    					if(result=="success"){
    						alert("Password successfully changed!");
    						window.parent.location.href="logout.shtml";
    					} 
    		        }); */
    		
    		
		}else{
			return false;
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