package com.hemi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hemi.model.Emp;
import com.hemi.service.EmpService;
import com.hemi.service.EmpServiceImpl;

public class DelServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 HttpSession session = req.getSession();
		 String id = req.getParameter("id");
	     EmpService empService = new EmpServiceImpl();
	     int del = empService.delete(new Emp(Integer.parseInt(id),""));
	     if(del>0){
	     session.setAttribute("del", "true");
	     }    
	     resp.sendRedirect("index.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	  
		
	}
}

