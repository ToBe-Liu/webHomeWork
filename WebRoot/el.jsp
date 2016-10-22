<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.hemi.model.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'el.jsp' starting page</title>
    
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
    <h1>EL表达式-语法</h1>
    <%
    	List list = new ArrayList();
    	list.add("苹果");
    	list.add("葡萄");
    	list.add("梨子");
    	pageContext.setAttribute("list", list);
    	Emp emp = new Emp(8001,"小明");
    	request.setAttribute("emp", emp);
    	
    	
     %>
     <h3>结果显示</h3>
     ${list}<br>
     ${emp}
     ${emp.id}
     ${emp.name}
     ${(1+2)*3}
     ${true||false}
     ${empty uname}
     ${param.fav}
     ${paramValues.fav[0]}
     ${paramValues.fav[1]}
     ${param.info}
  </body>
</html>
