package com.rubypaper.biz.board;
import java.sql.*;

public class GetBoardListTest {
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
            String sql = "select * from board order by seq desc";
            rs = stmt.executeQuery(sql); // ?΄?Ή λͺλ Ή?΄λ₯? ? ?‘??€.

            // 5.κ²?? κ²°κ³Ό μ²λ¦¬(select κ΅¬λ¬Έ?λ§? ?΄?Ή??€)
            while(rs.next()){
                System.out.print(rs.getInt("SEQ") + " : ");
                System.out.print(rs.getString("TITLE") + " : ");
                System.out.print(rs.getString("WRITER") + " : ");
                System.out.print(rs.getString("CONTENT") + " : ");
                System.out.print(rs.getDate("REGDATE") + " : ");
                System.out.println(rs.getInt("CNT"));
            }
            // rs? κ°??₯ ?? Before First, κ·Έλ€? μΏΌλ¦¬λ¬Έμ ?΄?Ή?? ?°?΄?°κ°? ?κ³?, λ§μ?λ§μ After Lastκ°? ??€.
            // rs.next()λ‘? before fisrtλ₯? μ§??? ?°?΄?°? ? κ·Όνκ²? ?κ³?, ?½? ?°?΄?°κ°? ??Όλ©? trueλ₯? return ??¬ λ°λ³΅λ¬Έμ΄ ?€???€.
            // ?΄λ₯? λ°λ³΅??¬ After Last? ? κ·Όνλ©? falseλ₯? returnλ°κ³  while? λ²μ΄??€.
            // μ΅μ΄? rs? before first? ? κ·Όνλ―?λ‘? rs.next()λ°λ? ?λ²? ?΄μ€μΌ ?°?΄?°? ? κ·Όμ΄ κ°??₯??€.\
            // column? ? κ·Όν ?? indexλ²νΈλ‘λ ? κ·Όν  ? ?μ§?λ§? κ°???±? κ³ λ €??¬ name?Όλ‘? ?΄μ£Όλ κ²μ΄ μ’λ€.
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
