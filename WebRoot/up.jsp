<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.apache.commons.fileupload.servlet.*" %>
<%@page import="org.apache.commons.fileupload.disk.*" %>
<%@page import="org.apache.commons.fileupload.*" %>
<%@page import="java.io.*" %>

<%-- <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> --%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <%-- <base href="<%=basePath%>"> --%>
    
    <title>My JSP 'up.jsp' starting page</title>
    
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
   //构建上传路径
   /* String path1 = session.getServletContext().getRealPath("/upload/");
   //判断是否为多表单
   boolean isMultipart = ServletFileUpload.isMultipartContent(request);
   if(isMultipart){
   		FileItemFactory fac =  new DiskFileItemFactory();//获取工厂
   		ServletFileUpload upload = new ServletFileUpload(fac);//获取核心类
   		List<FileItem> list =  upload.parseRequest(request);//获取表单对象
   		for(FileItem f : list){//遍历表单
   			if(!f.isFormField()){//判断该表单是否为普通类型（true为普通表单，false为file表单）
   				//上传标签
   				String fname = f.getName();//获取文件名
   				System.out.print(fname);
   				//上传文件
   				File file = new File(path1,fname);
   				f.write(file);
   				//out.print("上传成功！");
   				//session.setAttribute("upload", "true");
   				//返回重定向
   				//response.sendRedirect("upload.jsp");
   				//request.getRequestDispatcher("upload.jsp").include(request, response); */
   				out.print("<script type='text/javascript'>alert('上传成功！');</script>");
   				
   			/* } */
   		/* } */
/*    }    */
   
   
   %>
   
  </body>
</html>
