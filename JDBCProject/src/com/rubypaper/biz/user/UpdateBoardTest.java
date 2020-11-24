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
            // 1.?“œ?¼?´ë²? ê°ì²´ë¥? ë©”ëª¨ë¦¬ì— ?• ?‹¹?•œ?‹¤.
            Class.forName("org.h2.Driver");

            // 2.ì»¤ë„¥?…˜?„ ?š?“?•œ?‹¤.
            String url = "jdbc:h2:tcp://localhost/~/test";
            conn = DriverManager.getConnection(url, "sa", "");

            // 3.sql ? „?‹¬ ê°ì²´ë¥? ?ƒ?„±?•œ?‹¤.
            stmt = conn.createStatement();

            // 4.sql?„ ? „?‹¬?•œ?‹¤.
            String sql = "update board set title = '? œëª©ìˆ˜? •', content = '?‚´?š© ?ˆ˜? •' where seq = 1";
            int cnt = stmt.executeUpdate(sql); // ?•´?‹¹ ëª…ë ¹?–´ë¥? ? „?†¡?•œ?‹¤.
            System.out.println(cnt + "ê±´ì˜ ?°?´?„° ì²˜ë¦¬ ?„±ê³?!!");
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
                if(!conn.isClosed() && conn != null) // connection?? ?´ë¯? ?‹«?˜”?Š”ì§? ?™•?¸?•˜?Š” ë¡œì§?„ ì¶”ê??•´?•¼?•œ?‹¤.
                    conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                conn = null;
            }
        }
    }
}
