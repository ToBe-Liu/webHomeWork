<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.hemi.service.*,com.hemi.model.*" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	td{width: 200px}	
	</style>
	
  </head>
  
  <body>
  
  <!-- ------------------------------------------jsp准备区--------------------------------------------- -->
	<%!
		int curPage = 1;
		int pageSize = 5;
		int pageCount;
		int rowCount;
	%>
	<%
		request.setCharacterEncoding("utf-8");
   		response.setCharacterEncoding("utf-8");
   		EmpService empService = new EmpServiceImpl();
		List<Emp> emps1 = empService.query(new Emp(curPage, pageSize));	
		rowCount = Integer.parseInt(empService.getTotal(new Emp()).toString()); 		
		pageCount = (rowCount+pageSize-1)/pageSize;		
		if (request.getParameter("curPage") == null) {
			curPage = 1;
		} else {
			curPage = Integer.parseInt(request.getParameter("curPage"));
		}
		if (curPage < 1) {
			curPage = 1;
		}
		if (curPage > pageCount) {
			curPage = pageCount;
		}
		
	%>
	<!-- ----------------------------------------------内容区---------------------------------------------- -->
	<h3>员工列表</h3>
	<a href="edit?modify=0">新增</a>
	<form action="query.jsp" method="post">
    	编号：<input type="text" name="empno" >
    	姓名：<input type="text" name="ename" >
    	<input type="submit" value="查询">
	</form>
	<table>
		<thead>
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>操作</td>
			</tr>
		</thead>
		<tbody>
			<%
				List<Emp> emps = null;
				Object query = session.getAttribute("query");
				if(query!=null){
					if(!query.equals("false")){
						emps = (List<Emp>)query;
						curPage = 1;
						pageCount = 1;
						session.removeAttribute("query");
					}else{
						emps = empService.query(new Emp(curPage, pageSize));
					}
				}else{
					
					emps = empService.query(new Emp(curPage, pageSize));
				}
				request.setAttribute("emps", emps);	
				//for (Emp e : emps) {
				
			%>
			<c:forEach var="emp" items="${emps }">
			<tr>
				<td>${emp.id }</td>
				<td>${emp.name }</td>
				<td><a
					href="edit?modify=1&empno=${emp.id }&ename=${emp.name }">修改</a>&nbsp;<a
					id="del" href="del?id=${emp.id }" onclick="check()">删除</a>
				</td>
			</tr>
		</tbody>
		</c:forEach>
		<%-- <%
			}
		%> --%>
	</table>
	<br>
	<br>
	<a href="index.jsp?curPage=1">首页</a>
	<a href="index.jsp?curPage=<%=curPage - 1%>" onclick="check1()">上一页</a>
	<a href="index.jsp?curPage=<%=curPage + 1%>" onclick="check2()">下一页</a>
	<a href="index.jsp?curPage=<%=pageCount%>">尾页</a>
	共<%=rowCount %>条记录 <%=curPage %>/<%=pageCount %>页
	<!-- -------------------------------------------------jsp判断区----------------------------------------- -->
	<%
		if(session.getAttribute("del") != null) {
			if (session.getAttribute("del").equals("true")) {
				out.print("<script type='text/javascript'>alert('删除成功！');</script>");
			}
			session.removeAttribute("del");
		}

		if (session.getAttribute("modifyResult") != null) {
			if (session.getAttribute("modifyResult").equals("true")) {
				out.print("<script type='text/javascript'>alert('修改成功！');</script>");
			} else {
				out.print("<script type='text/javascript'>alert('修改失败！');</script>");
			}
			session.removeAttribute("modifyResult");
		}
		Object addResult = session.getAttribute("addResult");
		if (session.getAttribute("addResult") != null) {
			if (session.getAttribute("addResult").equals("true")) {
				out.print("<script type='text/javascript'>alert('增加成功！');</script>");
			} else {
				out.print("<script type='text/javascript'>alert('添加失败！');</script>");
			}
			session.removeAttribute("addResult");
		}
		if(query!=null&&query.equals("false")){
			out.print("<script type='text/javascript'>alert('查询失败！');</script>");
			session.removeAttribute("query");
		}
	%>
	<!-- --------------------------------------------------------js区--------------------------------------- -->
	<script type="text/javascript">
		function check() {
			if (!confirm("确认要删除？")) {
				window.event.returnValue = false;
			}

		}
		function check1() {
			if (<%=curPage%>== 1) {
				alert("已经是第一页了！");
				window.event.returnValue = false;
			}
		}
		function check2() {
			if (<%=curPage%>==<%=pageCount%>) {
				alert("已经是最后一页了！");
				window.event.returnValue = false;
			}
		}
	</script>
</body>
</html>
