package com.rubypaper.biz.user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteBoardTest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 1.??Ό?΄λ²? κ°μ²΄λ₯? λ©λͺ¨λ¦¬μ ? ?Ή??€.
            Class.forName("org.h2.Driver");

            // 2.μ»€λ₯?? ????€.
            String url = "jdbc:h2:tcp://localhost/~/test";
            conn = DriverManager.getConnection(url, "sa", "");

            // 3.sql ? ?¬ κ°μ²΄λ₯? ??±??€.
            stmt = conn.createStatement();

            // 4.sql? ? ?¬??€.
            String sql = "delete board where seq = 3";
            int cnt = stmt.executeUpdate(sql); // ?΄?Ή λͺλ Ή?΄λ₯? ? ?‘??€.
            System.out.println(cnt + "κ±΄μ ?°?΄?° μ²λ¦¬ ?±κ³?!!");
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
