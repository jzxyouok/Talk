<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import = "dao.CRUD"%>
<%@page import = "teacher_message.Teacher"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
		</script>
	</head>
	
	<body >
		<%
			CRUD crud = new CRUD();
			ArrayList<Teacher> teachers = crud.selectAll();
			Iterator it = teachers.iterator();

			int a = 1;
			while(it.hasNext()){
				Teacher t = (Teacher) it.next();
				if(a > 6) {
					a = 1;
				} else a++;
		%>
			
			<table>
				<tr>
					<td rowspan = "3" width= "20%"><image src="../image/<%=a%>.jpg" width = "65px" hight = "65px"/></td>
					<td width= "40%" valign = "middle"><image src="../image/z.jpg" width = "13px" hight = "13px"/>
										<%=t.getTeacher_name()%></td>
					<td width= "40%" align = "Right"><%=t.getTeacher_charge()%>元&#47;分钟</td>
				</tr>
				<tr>
					<td valign = "middle"><image src="../image/x.png" width = "15px" hight = "15px"/>
						<%=t.getTeacher_evaluate()%></td>
					<td></td>
				</tr>
				<tr>
					<td valign = "middle"><image src="../image/l.png" width = "15px" hight = "15px"/>
						<%=t.getTeacher_location()%></td>
					<td></td>
				</tr>
			</table><hr>
		<%
			}
		%>
	</body>
</html>