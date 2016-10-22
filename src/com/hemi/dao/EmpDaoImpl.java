package com.hemi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hemi.model.Emp;
import com.hemi.util.JDBCUtil;

public class EmpDaoImpl extends JDBCUtil implements EmpDao {

	@Override
	public List<Emp> query(Emp emp) {
		List<Emp> emps = new ArrayList<Emp>();
		int curPage = emp.getCurPage();
		int pageSize = emp.getPageSize();
		try {
			String sql = "select * from (select p.*,rownum rn from emp p)where rn>(?-1)*? and rn<?*?+1";
			Object [] objs = {curPage,pageSize,curPage,pageSize};
			ResultSet rs = JDBCUtil.query(sql, objs);
			String sql1 = "select * from emp";
			Object [] objs1 = {};
			ResultSet rs1 = JDBCUtil.query(sql1, objs1);
			rs1.last();
			int rowCount = rs1.getRow();
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				Emp emp1 = new Emp();
				emp1.setId(id);
				emp1.setName(name);
				//emp1.setRowCount(rowCount);
				emps.add(emp1);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			JDBCUtil.close();
		}
		
		return emps;
	}

	@Override
	public int save(Emp emp) throws RuntimeException{
		int rs = 0;
		try {
			String sql = "insert into emp(empno,ename) values (?,?) ";
			Object [] objs = {emp.getId(),emp.getName()};
			rs = JDBCUtil.updata(sql, objs);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}finally{
			JDBCUtil.close();
		}
		return rs;
	}

	@Override
	public int modify(Emp emp) {
		int rs = 0;
		try {
			String sql = "update emp set empno=?,ename=? where empno=? ";
			//Object [] objs = {empNew.getId(),empNew.getName(),empOld.getId()};
			//rs = JDBCUtil.updata(sql, objs);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			JDBCUtil.close();
		}
		return rs;
	}

	@Override
	public int delete(Emp emp) {
		int rs = 0;
		try {
			String sql = "delete from emp where empno=? ";
			Object [] objs = {emp.getId()};
			rs = JDBCUtil.updata(sql, objs);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			JDBCUtil.close();
		}
		return rs;
	}

	@Override
	public List<Emp> unionQuery(Emp emp) {
		List<Emp> emps = new ArrayList<Emp>();
		try {
			String sql = "select empno,ename from emp where empno=? and ename=?";
			Object [] objs = {emp.getId(),emp.getName()};
			ResultSet rs = JDBCUtil.query(sql, objs);
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				Emp emp1 = new Emp();
				emp1.setId(id);
				emp1.setName(name);
				emps.add(emp1);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			JDBCUtil.close();
		}
		
		return emps;
	}

	@Override
	public Object getTotal(Emp emp) {
		// TODO Auto-generated method stub
		return null;
	}

}
