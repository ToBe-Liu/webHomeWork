<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jstl.jsp' starting page</title>
    
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
  		List list1 = new ArrayList();
    	list1.add("苹果");
    	list1.add("葡萄");
    	list1.add("梨子");
    	list1.add("苹果");
    	list1.add("葡萄");
    	list1.add("梨子");
    	pageContext.setAttribute("list", list1);
   %>
  	<c:out value="第一个jstl输出"></c:out>
  	<c:set scope="request" var="uname" value="林正英"></c:set><!-- 在作用域存值 -->
	1-${uname}<br>
	<c:remove var="uname"/>
	2-${uname}<br>
	<c:forEach var="f" items="${list}" varStatus="s">
		<%-- <c:if test="${s.count%2==0 }"> --%>
			${s.count}-${f}<br>
		<%-- </c:if> --%>
	</c:forEach>
	<% Date date = new Date();
		request.setAttribute("now", date);	
	%>
	${now}
	<c:set scope="request" var="date" value="<%=new Date() %>"></c:set>
	<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss"/>
	<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
  </body>
</html>
