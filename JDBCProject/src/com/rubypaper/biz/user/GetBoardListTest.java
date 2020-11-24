package com.rubypaper.biz.user;
import java.sql.*;

public class GetBoardListTest {
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
            String sql = "select * from board order by seq desc";
            rs = stmt.executeQuery(sql); // ?•´?‹¹ ëª…ë ¹?–´ë¥? ? „?†¡?•œ?‹¤.

            // 5.ê²??ƒ‰ ê²°ê³¼ ì²˜ë¦¬(select êµ¬ë¬¸?—ë§? ?•´?‹¹?œ?‹¤)
            while(rs.next()){
                System.out.print(rs.getInt("SEQ") + " : ");
                System.out.print(rs.getString("TITLE") + " : ");
                System.out.print(rs.getString("WRITER") + " : ");
                System.out.print(rs.getString("CONTENT") + " : ");
                System.out.print(rs.getDate("REGDATE") + " : ");
                System.out.println(rs.getInt("CNT"));
            }
            // rs?Š” ê°??¥ ?œ„?— Before First, ê·¸ë‹¤?Œ ì¿¼ë¦¬ë¬¸ì— ?•´?‹¹?•˜?Š” ?°?´?„°ê°? ?ˆê³?, ë§ˆì?ë§‰ì— After Lastê°? ?ˆ?‹¤.
            // rs.next()ë¡? before fisrtë¥? ì§??‚˜?„œ ?°?´?„°?— ? ‘ê·¼í•˜ê²? ?˜ê³?, ?½?„ ?°?´?„°ê°? ?ˆ?œ¼ë©? trueë¥? return ?•˜?—¬ ë°˜ë³µë¬¸ì´ ?‹¤?–‰?œ?‹¤.
            // ?´ë¥? ë°˜ë³µ?•˜?—¬ After Last?— ? ‘ê·¼í•˜ë©? falseë¥? returnë°›ê³  while?„ ë²—ì–´?‚œ?‹¤.
            // ìµœì´ˆ?— rs?Š” before first?— ? ‘ê·¼í•˜ë¯?ë¡? rs.next()ë°˜ë“œ?‹œ ?•œë²? ?•´ì¤˜ì•¼ ?°?´?„°?— ? ‘ê·¼ì´ ê°??Š¥?•˜?‹¤.\
            // column?— ? ‘ê·¼í• ?•Œ?Š” indexë²ˆí˜¸ë¡œë„ ? ‘ê·¼í•  ?ˆ˜ ?ˆì§?ë§? ê°??…?„±?„ ê³ ë ¤?•˜?—¬ name?œ¼ë¡? ?•´ì£¼ëŠ” ê²ƒì´ ì¢‹ë‹¤.
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
