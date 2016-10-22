<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    
    <title>My JSP 'upload.jsp' starting page</title>
    
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
  	
    <!-- <form action="up.jsp" method="post" enctype="multipart/form-data" > -->
	<!-- <input type="file" name="uploadFile" > -->
    <input type="submit" value="上传" onclick="check()">
    <!-- </form>  -->
    <%-- <%
  		Object upload = session.getAttribute("upload");
  		if(upload!=null&&upload.equals("true")){
  			out.print("<script type='text/javascript'>alert('上传成功！');</script>");
  			session.removeAttribute("upload");
  		}
  	 %> --%>
  	 <script type="text/javascript">
  	 	function check(){
  	 	 <jsp:include page="up.jsp"></jsp:include>
  	 	}
  	 </script>
  	 
  </body>
</html>
