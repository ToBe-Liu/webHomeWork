<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h3>登录</h3>
    <form action="login" method="post">
    	<input type="text" name="username"><br>
    	<input type="password" name="pwd"><br>
    	<input type="submit" value="提交">
    </form>
    <%
    	Object login = session.getAttribute("login");
		if (session.getAttribute("login") != null) {
			if (session.getAttribute("login").equals("true")) {
				out.print("<script type='text/javascript'>alert('成功！');</script>");
			} else {
				out.print("<script type='text/javascript'>alert('登录失败！');</script>");
			}
			session.removeAttribute("login");
		}
     %>
  </body>
</html>
