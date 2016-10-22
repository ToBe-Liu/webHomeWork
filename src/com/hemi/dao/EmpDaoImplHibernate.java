package com.hemi.dao;

import java.util.ArrayList;
import java.util.List;

import com.hemi.model.Emp;
import com.hemi.util.HibernateUtil;

public class EmpDaoImplHibernate extends HibernateUtil implements EmpDao {

	@Override
	public List<Emp> query(Emp emp) {
		String hql = "from Emp";
		List<Emp> emps = super.query(hql, emp);
		return emps;
	}

	@Override
	public List<Emp> unionQuery(Emp emp) {
		
		return null;
	}

	@Override
	public int save(Emp emp) {
		return super.saveOrUpdate(emp);
	}

	@Override
	public int modify(Emp emp) {
		return super.saveOrUpdate(emp);
	}

	@Override
	public int delete(Emp emp) {
		return super.delete(emp);
	}

	@Override
	public Object getTotal(Emp emp) {
		return super.getTotal(emp);
	}

}
