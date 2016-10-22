package com.hemi.test;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hemi.model.Dept;
import com.hemi.model.Emp;

public class TestHibernate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 步骤：1 获取配置 2 创建工厂 3 获取session 4 关闭session
		Configuration conf = null;
		SessionFactory sessionFactory = null;
		Session session = null;	
		Transaction ts = null;
		try {
			conf = new Configuration().configure();
			sessionFactory = conf.buildSessionFactory();
			/*session =  sessionFactory.getCurrentSession();
			ts = session.beginTransaction();*/
			session = sessionFactory.openSession();
			//部门查询
			String hql = "FROM Dept";
			List<Dept> depts = session.createQuery(hql).list();
			for (Dept dept : depts) {
				System.out.println("部门："+dept.getDname());
				
				/*for (Emp emp:dept.getEmps()) {
					System.out.println("员工:"+emp);
				}*/
			}
			//ts.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			/*if(ts!=null){
				ts.rollback();
			}*/
		}finally{
			/*if(session!=null&&session.isOpen()){
				session.close();
			}*/
		}
		
		
	}

}
