package com.hemi.test;

import java.util.List;

import org.hibernate.Session;

import com.hemi.model.Dept;
import com.hemi.model.Emp;
import com.hemi.service.EmpService;
import com.hemi.service.EmpServiceImpl;
import com.hemi.util.HibernateUtil;
import com.hemi.util.JDBCUtilMySQL;

public class Test {
public static void main(String[] args) {
	/*EmpService empService = new EmpServiceImpl();
	
	//增加
	Emp emp = new Emp();
	emp.setId(9001);
	emp.setName("小明");
	int result = empService.save(emp);
	System.out.println(result);*/
	/*//修改
	Emp emp1 = new Emp();
	emp1.setId(9001);
	emp1.setName("小明");
	Emp emp2 = new Emp();
	emp2.setId(9002);
	emp2.setName("大明");
	empService.modify(emp1, emp2);*/
	
	/*//删除
	Emp emp3 = new Emp();
	emp3.setId(9002);
	emp3.setName("大明");
	empService.delete(emp3);*/
	
	//查询
	/*List<Emp> emps = empService.query(new Emp(2,5));*/
	//List<Emp> emps = empService.unionQuery(new Emp(8001,"fds"));
	
	
	//System.out.println(emps.isEmpty());
	/*for (Emp e : emps) {
		System.out.println(e);
	}*/
	/*EmpService empService = new EmpServiceImpl();
	System.out.println(empService.getTotal(new Emp()));
	List<Emp> emps1 = empService.query(new Emp(1, 5));
	for (Emp emp : emps1) {
		System.out.println(emp);
	}*/
	//查询部门
	/*HibernateUtil hi = new HibernateUtil();
	List<Dept> depts = hi.query("from Dept");
	for (Dept dept : depts) {
		System.out.println(dept);
		for (Emp emp : dept.getEmps()) {
			System.out.println(emp);
		}
	}*/
	/*HibernateUtil hi = new HibernateUtil();
	Session session = hi.getSession();
	List<Dept> depts = session.createQuery("from Dept").list();
	for (Dept dept : depts) {
		System.out.println(dept);
		for (Emp emp : dept.getEmps()) {
			System.out.println(emp);
		}
	}
	
	session.close();*/
	/*//查询员工
	HibernateUtil hi = new HibernateUtil();
	List<Emp> emps = hi.query("from Emp");
	for (Emp emp : emps) {
		System.out.println("员工"+emp);
		System.out.println("部门"+emp.getDept());
		
	}*/
/*	//查询部门
	HibernateUtil hi = new HibernateUtil();
	List<Dept> depts = hi.query("from Dept");
	for (Dept dept : depts) {
		System.out.println("部门"+dept);
		for (Emp emp : dept.getEmps()) {
			System.out.println("员工"+emp);
		}
	}*/
	
/*	//级联新增
	HibernateUtil hi = new HibernateUtil();
	Emp emp4 = new Emp(4001,"黄盖");
	Dept dept4 = new Dept(4,"吴国将军");
	dept4.getEmps().add(emp4);
	emp4.setDept(dept4);
	hi.saveOrUpdate(dept4);*/
	/*List<Dept> depts = hi.query("from Dept");
	for (Dept d : depts) {
		System.out.println("部门"+d);
		for (Emp e : dept.getEmps()) {
			System.out.println("员工"+e);
		}
	}*/
/*	//级联更新
	HibernateUtil hi = new HibernateUtil();
	Emp emp3 = new Emp(4001,"黄盖");
	Dept dept3 = new Dept(3,"妖怪组");
	dept3.getEmps().add(emp3);
	emp3.setDept(dept3);
	hi.saveOrUpdate(dept3);*/
	
	//级联删除
	HibernateUtil hi = new HibernateUtil();
	Emp emp3 = new Emp(4001,"黄盖");
	Dept dept3 = new Dept(3,"妖怪组");
	dept3.getEmps().add(emp3);
	emp3.setDept(dept3);
	hi.delete(dept3);
	
	
	//查询部门
	List<Dept> depts = hi.query("from Dept");
	for (Dept dept : depts) {
		System.out.println("部门"+dept);
		for (Emp emp : dept.getEmps()) {
			System.out.println("员工"+emp);
		}
	}
	
}
}
