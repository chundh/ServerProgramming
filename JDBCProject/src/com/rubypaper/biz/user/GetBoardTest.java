package com.rubypaper.biz.user;
import java.sql.*;

public class GetBoardTest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            // 1.??Ό?΄λ²? κ°μ²΄λ₯? λ©λͺ¨λ¦¬μ ? ?Ή??€.
            Class.forName("org.h2.Driver");

            // 2.μ»€λ₯?? ????€.
            String url = "jdbc:h2:tcp://localhost/~/test";
            conn = DriverManager.getConnection(url, "sa", "");

            // 3.sql ? ?¬ κ°μ²΄λ₯? ??±??€.
            stmt = conn.createStatement();

            // 4.sql? ? ?¬??€.
            String sql = "select * from board where seq = 1";
            rs = stmt.executeQuery(sql); // ?΄?Ή λͺλ Ή?΄λ₯? ? ?‘??€.

            // 5.κ²?? κ²°κ³Ό μ²λ¦¬(select κ΅¬λ¬Έ?λ§? ?΄?Ή??€)
            if(rs.next()){
                System.out.println("κ²μκΈ? ??Έ ? λ³?");
                System.out.println("λ²νΈ : " + rs.getInt("SEQ"));
                System.out.println("? λͺ? : " + rs.getString("TITLE"));
                System.out.println("??±? : " + rs.getString("WRITER"));
                System.out.println("?΄?© : " + rs.getString("CONTENT"));
                System.out.println("?±λ‘μΌ : " + rs.getDate("REGDATE"));
                System.out.println("μ‘°ν? : " + rs.getInt("CNT"));
            }
            // κ²?? κ²°κ³Όκ°? ??λ°μ ??€λ©? κ΅³μ΄ while? ??? €? ??€.
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            // κ°μ± ??±?΄ conn -> stmt -> rs ??Όλ‘? ??±?λ―?λ‘? close? ?­??Όλ‘? ?΄λ£¨μ΄? Έ?Ό??€.
//            rs.close();
//            stmt.close();
//            conn.close(); ?΄μ²λΌ close?λ©? rs?? ??¬κ°? λ°μ?  κ²½μ° λ°μ λ‘μ§?΄ ?€??μ§? ???€.
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
                if(!conn.isClosed() && conn != null) // connection?? ?΄λ―? ?«??μ§? ??Έ?? λ‘μ§? μΆκ??΄?Ό??€.
                    conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                conn = null;
            }
        }
    }
}
