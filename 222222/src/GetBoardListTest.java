import java.sql.*;

public class GetBoardListTest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            // 1.드라이버 객체를 메모리에 할당한다.
            Class.forName("org.h2.Driver");

            // 2.커넥션을 획득한다.
            String url = "jdbc:h2:tcp://localhost/~/test";
            conn = DriverManager.getConnection(url, "sa", "");

            // 3.sql 전달 객체를 생성한다.
            stmt = conn.createStatement();

            // 4.sql을 전달한다.
            String sql = "select * from board order by seq desc";
            rs = stmt.executeQuery(sql); // 해당 명령어를 전송한다.

            // 5.검색 결과 처리(select 구문에만 해당된다)
            while(rs.next()){
                System.out.print(rs.getInt("SEQ") + " : ");
                System.out.print(rs.getString("TITLE") + " : ");
                System.out.print(rs.getString("WRITER") + " : ");
                System.out.print(rs.getString("CONTENT") + " : ");
                System.out.print(rs.getDate("REGDATE") + " : ");
                System.out.println(rs.getInt("CNT"));
            }
            // rs는 가장 위에 Before First, 그다음 쿼리문에 해당하는 데이터가 있고, 마지막에 After Last가 있다.
            // rs.next()로 before fisrt를 지나서 데이터에 접근하게 되고, 읽을 데이터가 있으면 true를 return 하여 반복문이 실행된다.
            // 이를 반복하여 After Last에 접근하면 false를 return받고 while을 벗어난다.
            // 최초에 rs는 before first에 접근하므로 rs.next()반드시 한번 해줘야 데이터에 접근이 가능하다.\
            // column에 접근할때는 index번호로도 접근할 수 있지만 가독성을 고려하여 name으로 해주는 것이 좋다.
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 객채 생성이 conn -> stmt -> rs 순으로 생성되므로 close는 역순으로 이루어져야한다.
//            rs.close();
//            stmt.close();
//            conn.close(); 이처럼 close하면 rs에서 에러가 발생할 경우 밑의 로직이 실행되지 않는다.
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
                if(!conn.isClosed() && conn != null) // connection은 이미 닫혔는지 확인하는 로직을 추가해야한다.
                    conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                conn = null;
            }
        }
    }
}
