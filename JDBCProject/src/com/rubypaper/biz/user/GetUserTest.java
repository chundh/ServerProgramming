package com.rubypaper.biz.user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import useDao.BoardVO;
import useDao.JDBCUtil;

public class GetUserTest {
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		UserVO vo = new UserVO();
    	vo.setId("guset");
    	vo.setPassword("guset123");
    	vo.setName("방문자");
    	vo.setRole("user");
    	dao.insertUser(vo);
    	UserVO user = dao.getUser(vo);
    	if(user!=null) {
    		System.out.println(user.getName() + " 님 환영합니다.");
    	}
	}
}
