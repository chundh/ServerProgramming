package useDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {

	public static Connection getConnection() {
		try {
			Class.forName("org.h2.Driver");
			return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		// TODO Auto-generated method stub
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			rs = null;
		}
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			stmt = null;
		}
		try {
			if (!conn.isClosed() && conn != null) //
				conn.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			conn = null;
		}
	}
	public static void close(PreparedStatement stmt, Connection conn) {
		// TODO Auto-generated method stub
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			stmt = null;
		}
		try {
			if (!conn.isClosed() && conn != null) //
				conn.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			conn = null;
		}
	}

}
