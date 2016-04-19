<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="first.css" type="text/css">
		<script type="text/javascript">
			var f="visible";
			rec2();
			
			function rec(){
				if(f=="visible"){
					f="hidden";
				}
				return f;
			}

			
		</script>
	</head>
	<body background="../image/11.jpg">
		<div class="out">
			<div class="touxiang">
				<table cellspacing="0">
				  <tr>
					<%String username = (String)session.getAttribute("name");
					  //String im = (String) session.getAttribute("id");
					%>
				    <td rowspan="2"><image alt="" src="../image/1.jpg" width = "60px" hight = "60px"></td>
				    <td height="50%"><strong><b><%=username%></b></strong><br></td>
				  </tr>
				  <tr>
				    <td height="50%"></td>
				  </tr>
				</table>
			</div>
			<div style="height: 15px"></div>
			<div class="main">
				<div class="left">
				<table width="100%" height="100%" cellspacing="0">
					<tr height="10%">
					
						<td colspan="3" bgcolor="#7A8792" align="center">
							<font color="#ffffff"><a><%=username%></a></font>
						</td>
					</tr>
					<tr bgcolor="#ffffff" height="78%">
						<td colspan="3">
						<iframe width='100%' height='100%' frameborder='0' src='friendlist.jsp' name="myiframe2" ></iframe>
						</td>
					</tr>
					<tr height="12%" align="center" bgcolor="#7A8792">
						
						<td width="30%"> <a href="friendlist.jsp" target="myiframe2"><font color="#ffffff">找外教</font></a></td>
						<td width="30%"> <a href="message.html" target="myiframe2"><font color="#ffffff"> 消息 </font></a></td>
						<td width="30%"> <a href="user.html" target="myiframe2"><font color="#ffffff"> 我  </font></a></td>
					</tr>
				</table>
				
				
				</div>
				<div class="right" style="visibility: f;" >
						<table width="100%" height="500px" cellspacing="0">
							<tr height="10%">
								<td valign="middle" align="center" bgcolor="#7A8792">
									<table border="0"width="100%" height="100%">
										<tr>
											<td width="10%" align="center">
											<!-- <a href="../indexV.html" target="myiframe">马上趣聊 </a></td> -->
											<!-- 新页面打开 -->
											<a href="../indexV.html">马上趣聊 </a></td>
											
											<td width="10%" align="center"></td>
										</tr>
									</table>
								</td>
							</tr>
							<tr  height=78%>
								<td style="background-color:#336699;filter:Alpha(opacity=50)">
								<iframe width='100%' height='100%' frameborder='0' name="myiframe"></iframe>
								
								</td>
							</tr>
							<tr height="12%" bgcolor="#7A8792"><td>
								<table border="0"width="100%" height="100%">
										<tr >
											<td width="10%" align="center"></td>
											<td width="80%" align="center"><input type="text" size="80%"/></td>
											<td width="10%" align="center"><input type="button" value="发送" ></td>
										</tr>
									</table>
							</td></tr>
						</table>
				</div>
			</div>
		</div>
	</body>
</html>