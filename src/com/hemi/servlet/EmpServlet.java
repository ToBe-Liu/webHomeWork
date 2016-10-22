package com.hemi.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class EmpServlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		System.out.println("init");
		super.init();
		
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
		System.out.println("service");
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
		super.destroy();
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("doGet");
		
		String[] fav =req.getParameterValues("fav");
		PrintWriter out = resp.getWriter();
		out.print("我的爱好是：");
		for (String string : fav) {
			out.print(" "+string);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		System.out.println("doPost");
	}

	
	
}
