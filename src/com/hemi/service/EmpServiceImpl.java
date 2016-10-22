package com.hemi.service;

import java.util.List;

import com.hemi.dao.EmpDao;
import com.hemi.dao.EmpDaoImpl;
import com.hemi.dao.EmpDaoImplHibernate;
import com.hemi.model.Emp;

public class EmpServiceImpl implements EmpService{
	//EmpDao empdao = new EmpDaoImpl();
	EmpDao empdao = new EmpDaoImplHibernate();
	
	@Override
	public List<Emp> query(Emp emp) {
		return empdao.query(emp);
	}

	@Override
	public int save(Emp emp) {
		return empdao.save(emp);
	}

	@Override
	public int modify(Emp emp) {
		return empdao.modify(emp);
	}

	@Override
	public int delete(Emp emp) {
		return empdao.delete(emp);
	}

	@Override
	public List<Emp> unionQuery(Emp emp) {
		return empdao.unionQuery(emp);
	}

	@Override
	public Object getTotal(Emp emp) {
		return empdao.getTotal(emp);
	}

}
