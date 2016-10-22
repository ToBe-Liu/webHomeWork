package com.hemi.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hemi.model.Base;

public class HibernateUtil {
	private static Configuration conf; 
	Session session = null;
	Transaction ts = null;
	static{
		conf = new Configuration().configure();
	}
	//��ȡ SessionFactory
	public SessionFactory getSessionFactory (){ 
		return conf.buildSessionFactory();
	}
	//��ȡ Session
	public Session getSession (){ 
		return getSessionFactory().openSession();
	}
	// ����ҳ����:�����������õĲ�ѯ
	public <T> List<T> query (String hql ,Base b){ 
		List<T> list = new ArrayList<T>();
		try {
			session = getSession();
			list = session.createQuery(hql)
					.setProperties(b)
					.setFirstResult((b.getCurPage()-1)*b.getPageSize())
					.setMaxResults(b.getPageSize())
					.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
		return list;
	}
	// ��ռλ��?��ѯ
	public <T> List<T> query (String hql ,Object[] obj){ 
		List<T> list = new ArrayList<T>();
		try {
			session = getSession();
			Query query = session.createQuery(hql);
			for (int i = 0; i < obj.length; i++) {
				query.setParameter(i, obj[i]);
			}
			list = query.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
		return list;
	}
	// ��ѯ
	public <T> List<T> query (String hql){ 
		List<T> list = new ArrayList<T>();
		try {
			session = getSession();
			list = session.createQuery(hql).list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
		return list;
	}
	// ��ռλ��:�������Բ�ѯ
	public <T> List<T> query (String hql ,Object obj){ 
		List<T> list = new ArrayList<T>();
		try {
			session = getSession();
			list = session.createQuery(hql).setProperties(obj).list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
		return list;
	}
	// ��ռλ��:����������ѯ
	public <T> List<T> query (String hql ,Map<String,String> map){ 
		List<T> list = new ArrayList<T>();
		try {
			session = getSession();
			Query query = session.createQuery(hql);
			for (Map.Entry<String,String> entry: map.entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
			list = query.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
		return list;
	}
	// ��ȡһ����¼
	public Object getOne (Object obj ,int id){ 
		Object o =null;
		try {
			session = getSession();
			o = session.get(obj.getClass(), id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
		return o;
	}
	// ��ȡ����
	public int getTotal (Object obj){ 
		Object o = null;
		try {
			session = getSession();
			o = session.createQuery("select count(*) from "+obj.getClass().getSimpleName())
					.uniqueResult();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
		return Integer.parseInt(o.toString());
	}
	// ������޸�
	public int saveOrUpdate (Object obj){ 
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.saveOrUpdate(obj);
			ts.commit();
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if(ts!=null){
				ts.rollback();
			}
			return 0;
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
	}
	//ɾ��
	public int delete (Object obj){ 
		try {
			session = getSession();
			ts = session.beginTransaction();
			session.delete(obj);
			ts.commit();
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if(ts!=null){
				ts.rollback();
			}
			return 0;
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}	
	}
	//��ҳ
	public <T> List<T> paging (String hql,int curPage , int pageSize){
		List<T> list = new ArrayList<T>();
		try {
			session = getSession();
			list = session.createQuery(hql)
					.setFirstResult((curPage-1)*pageSize)
					.setMaxResults(pageSize)
					.list();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
		return list;
	}
	
	
}


