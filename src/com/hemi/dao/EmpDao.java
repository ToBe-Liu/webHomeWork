package com.hemi.dao;

import java.util.List;

import com.hemi.model.Emp;

public interface EmpDao {
	public List<Emp> query(Emp emp);
	public List<Emp> unionQuery(Emp emp);
	public int save(Emp emp);
	public int modify(Emp emp);
	public int delete(Emp emp);
	public Object getTotal(Emp emp);
}
