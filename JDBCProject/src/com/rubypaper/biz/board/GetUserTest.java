package com.rubypaper.biz.board;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import useDao.JDBCUtil;

public class GetUserTest {
	public static void main(String[] args) {
		Connection conn = null;
//		Statement stmt = null;
		PreparedStatement stmt = null; // Statement���� �ӵ��� �ξ� ������.
		ResultSet rs = null;
		try {
			// 1. ����̹� ��ü�� �޸𸮿� �ε��Ѵ�.
			Class.forName("org.h2.Driver");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
//			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			conn = JDBCUtil.getConnection();
			
			String sql = "Select * from users where id = ? and password = ?";
//			stmt = conn.createStatement();
			
			// ?�� �Ķ���ʹ�. �ش� �Ķ���Ϳ� �ش��ϴ� �����͸� �־�����Ѵ�.
			stmt = conn.prepareStatement(sql);	
			stmt.setString(1,  "admin");
			stmt.setString(2,  "admin");
			rs = stmt.executeQuery();

			while (rs.next()) {
				System.out.println("���̵� : " + rs.getString("ID"));
				System.out.println("��� : " + rs.getString("PASSWORD"));
				System.out.println("�̸� : " + rs.getString("NAME"));
				System.out.println("���� : " + rs.getString("ROLE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
	}
}