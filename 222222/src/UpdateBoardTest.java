import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateBoardTest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 1.드라이버 객체를 메모리에 할당한다.
            Class.forName("org.h2.Driver");

            // 2.커넥션을 획득한다.
            String url = "jdbc:h2:tcp://localhost/~/test";
            conn = DriverManager.getConnection(url, "sa", "");

            // 3.sql 전달 객체를 생성한다.
            stmt = conn.createStatement();

            // 4.sql을 전달한다.
            String sql = "update board set title = '제목수정', content = '내용 수정' where seq = 1";
            int cnt = stmt.executeUpdate(sql); // 해당 명령어를 전송한다.
            System.out.println(cnt + "건의 데이터 처리 성공!!");
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
