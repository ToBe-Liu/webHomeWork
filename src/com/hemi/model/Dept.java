package com.hemi.model;

import java.util.HashSet;
import java.util.Set;

public class Dept {
	private int deptno;
	private String dname;
	private Set<Emp> emps = new HashSet<Emp>();
	
	public Set<Emp> getEmps() {
		return emps;
	}
	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Dept(int deptno, String dname) {
		super();
		this.deptno = deptno;
		this.dname = dname;
	}
	
	public Dept(int deptno, String dname, Set<Emp> emps) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.emps = emps;
	}
	
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname
				+ "]";
	}
	public Dept() {
		super();
	}
	
}
