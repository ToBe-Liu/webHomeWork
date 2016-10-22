
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.hemi.service.*,com.hemi.model.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'query.jsp' starting page</title>
    
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
    <%
    	request.setCharacterEncoding("utf-8");
   		response.setCharacterEncoding("utf-8");
   		String empno = request.getParameter("empno");
   		String ename = request.getParameter("ename");
   		EmpService empService = new EmpServiceImpl();
   		List<Emp> emps = null;
   		if((!empno.equals("")&&!ename.equals(""))||(!empno.equals(""))||(!ename.equals(""))){
			if(empno.equals("")){
				empno="-1";
			}
			emps = empService.unionQuery(new Emp(Integer.parseInt(empno),ename));
			if(!emps.isEmpty()){
				session.setAttribute("query", emps);
			}else{
				session.setAttribute("query", "false");
			}
		}else{
   			session.setAttribute("query", "false");
   		}
   		response.sendRedirect("index.jsp");
     %>
  </body>
</html>
