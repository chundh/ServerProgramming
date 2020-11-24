import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertBoardTest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 1.드라이버 객체를 메모리에 할당한다.
//            DriverManager.registerDriver(new org.h2.Driver());
            // 이 객체는 DB마다 다르며 사용하려는 DB에 따라 알맞게 구현객체를 넣어줘야한다.
            // java.sql api를 사용하면서 interface를 활용하기 때문에 구현객체가 다르지만 동일한 메소드로 사용가능하다.
            Class.forName("org.h2.Driver");
            // 위의 로직과 같은 로직을 수행한다. 간결해서 많이 쓰인다.
            // 위의 로직은 객체를 파라미터로 할당하기 때문에 컴파일 단계에서 에러를 잡아내지만
            // 밑의 로직은 문자열로 파라미터를 넘기므로 컴파일 단계에서는 에러를 발생하지 않는다.
            // sql에 할당되는 드라이버 객체는 DriverManager에 모두 등록이 된다.
            // 위의 로직은 DriverManager에 바로 등록이 되고
            // 밑의 로직은 해당 객체가 생성이 안되어있는 경우, DriverManager를 획득하여 해당 객체를 등록해준다.
            

            // 2.커넥션을 획득한다.
            String url = "jdbc:h2:tcp://localhost/~/test";
            conn = DriverManager.getConnection(url, "sa", "");
            // h2 드라이버가 메모리에 할당되어있으므로 conn에는 h2의 연결이 들어온다.
            // 파라미터로는 url, id, pw가 들어온다.


            // 3.sql 전달 객체를 생성한다.
            stmt = conn.createStatement();
            // 3번까지의 과정은 변화가 없다. 로직에 따라서 sql문만 변경해주면 된다.


            // 4.sql을 전달한다.
            String sql = "insert into board(seq, title, writer, content) values((select nvl(max(seq), 0)+1 from board), '테스트 제목', '테스터', '테스트내용')";
            int cnt = stmt.executeUpdate(sql); // 해당 명령어를 전송한다.
            System.out.println(cnt + "건의 데이터 처리 성공!!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
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
