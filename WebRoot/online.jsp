<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.hemi.util.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'online.jsp' starting page</title>
    
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
    <h3>统计在线人数</h3>
     在线人数<%=Constants.ONLINE_COUNT %><br>
  SESSION<%=Constants.SESSION_COUNT %><br>
     登录用户名：${emp.name}<br>
  <a href="login">注销</a>
  </body>
</html>
