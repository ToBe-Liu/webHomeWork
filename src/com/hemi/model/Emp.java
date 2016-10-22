package com.hemi.model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.hemi.util.Constants;

public class Emp extends Base implements HttpSessionBindingListener{
	private int id;
	private String name;
	private Double salary;
	private Dept dept;
	/*private int rowCount;
	
	
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}*/
	
	public int getId() {
		return id;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", salary=" + salary
				+ ", dept=" + dept + "]";
	}
	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Emp(String name) {
		super();
		this.name = name;
	}
	
	/*public Emp(int id, String name, Dept dept) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
	}*/
	public Emp() {
		super();
	}
	public Emp(int curPage, int pageSize) {
		super.setCurPage(curPage);
		super.setPageSize(pageSize);
		
	}
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		Constants.ONLINE_COUNT++;
		
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		 Constants.ONLINE_COUNT--;
	}
	
}
