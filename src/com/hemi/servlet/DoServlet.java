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

public class DoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	  	int isSave = 0;
		HttpSession session = request.getSession();
	    EmpService empService = new EmpServiceImpl();
		int empno = Integer.parseInt(request.getParameter("empno")); 
		String ename = request.getParameter("ename");
		int modify = Integer.parseInt(request.getParameter("modify")); 
		if(modify==1){
			empService.modify(new Emp(empno,ename));
			session.setAttribute("modifyResult", "true");
		}else{
			try{
			isSave = empService.save(new Emp(empno,ename));
			if(isSave!=0){
				session.setAttribute("addResult", "true");
			}
			}catch(Exception e){
				session.setAttribute("addResult", e.getMessage());
			}
		} 
		
		response.sendRedirect("index.jsp");
		
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
