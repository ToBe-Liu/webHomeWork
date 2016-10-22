package com.hemi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hemi.model.Emp;
import com.hemi.service.EmpServiceImpl;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ע��
		req.getSession().invalidate();
		resp.sendRedirect("login.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ���ύ
		
		
		//�Ѽ�������
		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		EmpServiceImpl empService = new EmpServiceImpl();
		List<Emp> emps = empService.unionQuery(new Emp(Integer.parseInt(pwd),username));
		Emp emp = null;
		if(!emps.isEmpty()){
			emp = emps.get(0);
		}
		//����emp����
		
		//���session������
		HttpSession session =  req.getSession();
		if(emp!=null){
			session.setAttribute("emp",emp);
			resp.sendRedirect("online.jsp");
		}else{
			session.setAttribute("login","false");
			resp.sendRedirect("login.jsp");
		}
		//�ض���online.jsp
		
	}
}
