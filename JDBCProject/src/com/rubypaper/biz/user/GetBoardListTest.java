package com.rubypaper.biz.user;
import java.sql.*;

public class GetBoardListTest {
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
            String sql = "select * from board order by seq desc";
            rs = stmt.executeQuery(sql); // ?��?�� 명령?���? ?��?��?��?��.

            // 5.�??�� 결과 처리(select 구문?���? ?��?��?��?��)
            while(rs.next()){
                System.out.print(rs.getInt("SEQ") + " : ");
                System.out.print(rs.getString("TITLE") + " : ");
                System.out.print(rs.getString("WRITER") + " : ");
                System.out.print(rs.getString("CONTENT") + " : ");
                System.out.print(rs.getDate("REGDATE") + " : ");
                System.out.println(rs.getInt("CNT"));
            }
            // rs?�� �??�� ?��?�� Before First, 그다?�� 쿼리문에 ?��?��?��?�� ?��?��?���? ?���?, 마�?막에 After Last�? ?��?��.
            // rs.next()�? before fisrt�? �??��?�� ?��?��?��?�� ?��근하�? ?���?, ?��?�� ?��?��?���? ?��?���? true�? return ?��?�� 반복문이 ?��?��?��?��.
            // ?���? 반복?��?�� After Last?�� ?��근하�? false�? return받고 while?�� 벗어?��?��.
            // 최초?�� rs?�� before first?�� ?��근하�?�? rs.next()반드?�� ?���? ?��줘야 ?��?��?��?�� ?��근이 �??��?��?��.\
            // column?�� ?��근할?��?�� index번호로도 ?��근할 ?�� ?���?�? �??��?��?�� 고려?��?�� name?���? ?��주는 것이 좋다.
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
