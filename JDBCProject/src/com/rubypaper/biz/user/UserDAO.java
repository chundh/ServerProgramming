package com.rubypaper.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import useDao.JDBCUtil;

/**
 * DAO�� �����ؼ� ������ ȣ���ϴ� Ŭ���̾�Ʈ�� �ڵ差�� ���� �� �ִ�.
 * �Ķ���Ϳ� ��Ȯ�� �����Ͱ� ������ �ϱ� ���ؼ� VO�� �����ϰ� �ȴٸ� ������� �԰ݿ� �´� �����͸� ����ڿ��� �˷��� �� �ִ�.
 * 
 * @author Chun
 *
 */

public class UserDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	// Board ���̺� ���� ���ɾ�
	private static final String USER_INSERT =  "insert into users values(?, ?, ?, ?)";
	private static final String USER_GET = "SELECT * FROM users WHERE id = ? and password = ?";
	
	//BORAD ���̺� ���� CRUD ����� �޼ҵ�
	// �� ���
	public void insertUser(UserVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1,  vo.getId());
			stmt.setString(2,  vo.getPassword());
			stmt.setString(3,  vo.getName());
			stmt.setString(4,  vo.getRole());
			stmt.executeUpdate();
		} catch(Exception e) {
			
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// �󼼺���
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1,  vo.getId());
			stmt.setString(2,  vo.getPassword());
			
			rs = stmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
				// ���ε� ��ü�� list�� �ִ´�.
			}
		} catch(Exception e) {
			
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}
}