package com.rubypaper.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import useDao.JDBCUtil;

/**
 * DAO를 구성해서 쿼리를 호출하는 클라이언트의 코드량을 줄일 수 있다.
 * 파라미터에 정확한 데이터가 나오게 하기 위해서 VO를 구성하게 된다면 어느정도 규격에 맞는 데이터를 사용자에게 알려줄 수 있다.
 * 
 * @author Chun
 *
 */

public class UserDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	// Board 테이블 관련 명령어
	private static final String USER_INSERT =  "insert into users values(?, ?, ?, ?)";
	private static final String USER_GET = "SELECT * FROM users WHERE id = ? and password = ?";
	
	//BORAD 테이블 관련 CRUD 기능의 메소드
	// 글 등록
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
	
	// 상세보기
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
				// 매핑된 객체를 list에 넣는다.
			}
		} catch(Exception e) {
			
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}
}
