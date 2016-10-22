<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</style>
  </head>
  <body>
  		<form action="do" method="post">
    	编号：<input type="text" name="empno" value="${empno }"><span id = "empno1"></span><br>
    	姓名：<input type="text" name="ename" value="${ename }"><span id = "empno2"></span><br>
   		<input type="hidden" name="modify" value="${modify }">
    	<input type="submit" value="提交">
	    <input type="reset" value="重置">
	    </form>
  </body>
</html>
