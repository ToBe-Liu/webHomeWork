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
		// ���裺1 ��ȡ���� 2 �������� 3 ��ȡsession 4 �ر�session
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
			//���Ų�ѯ
			String hql = "FROM Dept";
			List<Dept> depts = session.createQuery(hql).list();
			for (Dept dept : depts) {
				System.out.println("���ţ�"+dept.getDname());
				
				/*for (Emp emp:dept.getEmps()) {
					System.out.println("Ա��:"+emp);
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
