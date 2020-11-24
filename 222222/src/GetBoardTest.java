import java.sql.*;

public class GetBoardTest {
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
            String sql = "select * from board where seq = 1";
            rs = stmt.executeQuery(sql); // 해당 명령어를 전송한다.

            // 5.검색 결과 처리(select 구문에만 해당된다)
            if(rs.next()){
                System.out.println("게시글 상세 정보");
                System.out.println("번호 : " + rs.getInt("SEQ"));
                System.out.println("제목 : " + rs.getString("TITLE"));
                System.out.println("작성자 : " + rs.getString("WRITER"));
                System.out.println("내용 : " + rs.getString("CONTENT"));
                System.out.println("등록일 : " + rs.getDate("REGDATE"));
                System.out.println("조회수 : " + rs.getInt("CNT"));
            }
            // 검색 결과가 하나밖에 없다면 굳이 while을 안돌려도 된다.
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
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
