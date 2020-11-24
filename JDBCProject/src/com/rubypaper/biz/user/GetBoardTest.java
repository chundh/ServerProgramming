package com.rubypaper.biz.user;
import java.sql.*;

public class GetBoardTest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            // 1.?“œ?¼?´ë²? ê°ì²´ë¥? ë©”ëª¨ë¦¬ì— ?• ?‹¹?•œ?‹¤.
            Class.forName("org.h2.Driver");

            // 2.ì»¤ë„¥?…˜?„ ?š?“?•œ?‹¤.
            String url = "jdbc:h2:tcp://localhost/~/test";
            conn = DriverManager.getConnection(url, "sa", "");

            // 3.sql ? „?‹¬ ê°ì²´ë¥? ?ƒ?„±?•œ?‹¤.
            stmt = conn.createStatement();

            // 4.sql?„ ? „?‹¬?•œ?‹¤.
            String sql = "select * from board where seq = 1";
            rs = stmt.executeQuery(sql); // ?•´?‹¹ ëª…ë ¹?–´ë¥? ? „?†¡?•œ?‹¤.

            // 5.ê²??ƒ‰ ê²°ê³¼ ì²˜ë¦¬(select êµ¬ë¬¸?—ë§? ?•´?‹¹?œ?‹¤)
            if(rs.next()){
                System.out.println("ê²Œì‹œê¸? ?ƒ?„¸ ? •ë³?");
                System.out.println("ë²ˆí˜¸ : " + rs.getInt("SEQ"));
                System.out.println("? œëª? : " + rs.getString("TITLE"));
                System.out.println("?‘?„±? : " + rs.getString("WRITER"));
                System.out.println("?‚´?š© : " + rs.getString("CONTENT"));
                System.out.println("?“±ë¡ì¼ : " + rs.getDate("REGDATE"));
                System.out.println("ì¡°íšŒ?ˆ˜ : " + rs.getInt("CNT"));
            }
            // ê²??ƒ‰ ê²°ê³¼ê°? ?•˜?‚˜ë°–ì— ?—†?‹¤ë©? êµ³ì´ while?„ ?•ˆ?Œ? ¤?„ ?œ?‹¤.
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            // ê°ì±„ ?ƒ?„±?´ conn -> stmt -> rs ?ˆœ?œ¼ë¡? ?ƒ?„±?˜ë¯?ë¡? close?Š” ?—­?ˆœ?œ¼ë¡? ?´ë£¨ì–´? ¸?•¼?•œ?‹¤.
//            rs.close();
//            stmt.close();
//            conn.close(); ?´ì²˜ëŸ¼ close?•˜ë©? rs?—?„œ ?—?Ÿ¬ê°? ë°œìƒ?•  ê²½ìš° ë°‘ì˜ ë¡œì§?´ ?‹¤?–‰?˜ì§? ?•Š?Š”?‹¤.
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
