<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>老外趣聊注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
  		function changeImg(img){
  			img.src = img.src+"?time="+new Date().getTime();
  		}
  	</script>
  </head>
  
 <body style="text-align: center;">
  	<h1>老外趣聊注册</h1><hr>
  	<font color="red">${msg }</font>
  	<form action="${pageContext.request.contextPath}/sigin/SigServlet" method="POST" >
  		<table border="1">
  			<tr>
  				<td>用户名</td>
  				<td><input type="text" name="username" value="${param.username }" /></td>
  			</tr>
  			<tr>
  				<td>密码</td>
  				<td><input type="password" name="password" /></td>
  			</tr>
  			<tr>
  				<td>确认密码</td>
  				<td><input type="password" name="password2" /></td>
  			</tr>
  			<tr>
  				<td>邮箱</td>
  				<td><input type="text" name="email" value="${param.email }" /></td>
  			</tr>
  			<tr>
  				<td>手机号</td>
  				<td><input type="text" name="phone" /></td>
  			</tr>
  			<tr>
  				<td>性别</td>
  				<td><input type="text" name="gender" /></td>
  			</tr>
  			<tr>
  				<td colspan = "2" align="center"><input type="submit" value="确认注册" /></td>
  			</tr>
  			<tr>
  				<td colspan = "2" align="center">注册即可获赠15元</td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>
