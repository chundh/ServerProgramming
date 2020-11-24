package com.rubypaper.biz.user;
import java.sql.*;

public class GetBoardTest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            // 1.?��?��?���? 객체�? 메모리에 ?��?��?��?��.
            Class.forName("org.h2.Driver");

            // 2.커넥?��?�� ?��?��?��?��.
            String url = "jdbc:h2:tcp://localhost/~/test";
            conn = DriverManager.getConnection(url, "sa", "");

            // 3.sql ?��?�� 객체�? ?��?��?��?��.
            stmt = conn.createStatement();

            // 4.sql?�� ?��?��?��?��.
            String sql = "select * from board where seq = 1";
            rs = stmt.executeQuery(sql); // ?��?�� 명령?���? ?��?��?��?��.

            // 5.�??�� 결과 처리(select 구문?���? ?��?��?��?��)
            if(rs.next()){
                System.out.println("게시�? ?��?�� ?���?");
                System.out.println("번호 : " + rs.getInt("SEQ"));
                System.out.println("?���? : " + rs.getString("TITLE"));
                System.out.println("?��?��?�� : " + rs.getString("WRITER"));
                System.out.println("?��?�� : " + rs.getString("CONTENT"));
                System.out.println("?��록일 : " + rs.getDate("REGDATE"));
                System.out.println("조회?�� : " + rs.getInt("CNT"));
            }
            // �??�� 결과�? ?��?��밖에 ?��?���? 굳이 while?�� ?��?��?��?�� ?��?��.
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            // 객채 ?��?��?�� conn -> stmt -> rs ?��?���? ?��?��?���?�? close?�� ?��?��?���? ?��루어?��?��?��?��.
//            rs.close();
//            stmt.close();
//            conn.close(); ?��처럼 close?���? rs?��?�� ?��?���? 발생?�� 경우 밑의 로직?�� ?��?��?���? ?��?��?��.
            try {
                if(rs != null)
                    rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                rs = null;
            }try {
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
