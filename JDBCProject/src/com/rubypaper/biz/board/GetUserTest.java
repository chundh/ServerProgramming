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
		PreparedStatement stmt = null; // Statement보다 속도가 훨씬 빠르다.
		ResultSet rs = null;
		try {
			// 1. 드라이버 객체를 메모리에 로딩한다.
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
			
			// ?는 파라미터다. 해당 파라미터에 해당하는 데이터를 넣어줘야한다.
			stmt = conn.prepareStatement(sql);	
			stmt.setString(1,  "admin");
			stmt.setString(2,  "admin");
			rs = stmt.executeQuery();

			while (rs.next()) {
				System.out.println("아이디 : " + rs.getString("ID"));
				System.out.println("비번 : " + rs.getString("PASSWORD"));
				System.out.println("이름 : " + rs.getString("NAME"));
				System.out.println("권한 : " + rs.getString("ROLE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
	}
}
