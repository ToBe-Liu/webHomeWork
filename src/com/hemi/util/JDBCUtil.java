package com.hemi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	/**
	 * JDBCUtil������
	 */
	static Connection conn =null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	//��ȡ����
	public static Connection getConnection(){
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "db01", "123");
		} catch (SQLException e) {
				e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	//��ѯ
	public static ResultSet query(String sql,Object[] objs){
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			for (int i = 0; i < objs.length; i++) {
				ps.setObject(i+1, objs[i]);
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return rs;
	}
	//���� �޸� ɾ��
	public static int updata(String sql,Object[] objs){
		int rs = 0;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < objs.length; i++) {
				ps.setObject(i+1, objs[i]);
			}
			rs = ps.executeUpdate();
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return rs;
	}
	//�ر���Դ
	public static void close(){
		try {
			if(conn!=null){
			conn.close();
			System.out.println("�ر�JDBC���ӳɹ���");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	
}
