package com.rubypaper.biz.user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateBoardTest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 1.?��?��?���? 객체�? 메모리에 ?��?��?��?��.
            Class.forName("org.h2.Driver");

            // 2.커넥?��?�� ?��?��?��?��.
            String url = "jdbc:h2:tcp://localhost/~/test";
            conn = DriverManager.getConnection(url, "sa", "");

            // 3.sql ?��?�� 객체�? ?��?��?��?��.
            stmt = conn.createStatement();

            // 4.sql?�� ?��?��?��?��.
            String sql = "update board set title = '?��목수?��', content = '?��?�� ?��?��' where seq = 1";
            int cnt = stmt.executeUpdate(sql); // ?��?�� 명령?���? ?��?��?��?��.
            System.out.println(cnt + "건의 ?��?��?�� 처리 ?���?!!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt != null)
                    stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                stmt = null;
            }try {
                if(!conn.isClosed() && conn != null) // connection?? ?���? ?��?��?���? ?��?��?��?�� 로직?�� 추�??��?��?��?��.
                    conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                conn = null;
            }
        }
    }
}
