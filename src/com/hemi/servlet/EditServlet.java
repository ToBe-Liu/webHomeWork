package com.hemi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//
		String empno = req.getParameter("empno");
	   	String ename = req.getParameter("ename");
	   	empno = empno == null ? "":empno;
	   	String modify = req.getParameter("modify");
	   	ename = ename == null ? "":ename;
	   	HttpSession session = req.getSession();
	   	session.setAttribute("modify", modify);
	   	session.setAttribute("empno", empno);
	   	session.setAttribute("ename", ename);
	   	//System.out.print(ename);
	   	//resp.sendRedirect("edit.jsp?modify="+modify+"&ename="+ename+"&empno="+empno);
	   	resp.sendRedirect("edit.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	

}
