package useDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import useDao.JDBCUtil;

/**
 * DAO를 구성해서 쿼리를 호출하는 클라이언트의 코드량을 줄일 수 있다.
 * 파라미터에 정확한 데이터가 나오게 하기 위해서 VO를 구성하게 된다면 어느정도 규격에 맞는 데이터를 사용자에게 알려줄 수 있다.
 * 
 * @author Chun
 *
 */

public class BoardDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	// Board 테이블 관련 명령어
	private static final String BOARD_INSERT =  "insert into board(seq, title, writer, content) " + 
												"values((select nvl(max(seq), 0)+1 from board), ?, ?, ?)";
	private static final String BOARD_UPDATE = "update board set title = ?, content = ? where seq = ?";
	private static final String BOARD_DELETE = "delete board where seq = ?";
	private static final String BOARD_GET = "SELECT * FROM BOARD WHERE SEQ = ?";
	private static final String BOARD_LIST = "select * from board order by seq desc";
	private static final String BOARD_UPDATECNT = "update board set cnt = cnt+1 where seq = ?";
	
	//BORAD 테이블 관련 CRUD 기능의 메소드
	// 글 등록
	public void insertBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1,  vo.getTitle());
			stmt.setString(2,  vo.getWriter());
			stmt.setString(3,  vo.getContent());
			stmt.executeUpdate();
		} catch(Exception e) {
			
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	// 글 수정
	public void updateBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3,  vo.getSeq());
			System.out.println(vo.getCnt());
			stmt.executeUpdate();
		} catch(Exception e) {
			
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	// 글 삭제
	// 사실상 seq하나를 받기 위해 객체를 받아오는 것이 낭비처럼 보일 수 있지만 
	// 나중에 기능추가로 인해 데이터를 추가로 필요하게 될 수 있기 때문에 전혀 낭비가 아니다.
	public void deleteBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1,  vo.getSeq());
			stmt.executeUpdate();
		} catch(Exception e) {
			
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	// 상세보기
	public BoardVO getBoard(BoardVO vo) {
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1,  vo.getSeq());
			rs = stmt.executeQuery();
			if(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("DATE"));
				board.setCnt(rs.getInt("CNT"));
				// 매핑된 객체를 list에 넣는다.
				
				//검색결과가 존재하는 경우 조회수를 증가시킨다.
				stmt = conn.prepareStatement(BOARD_UPDATECNT);
				stmt.setInt(1,  vo.getSeq());
				stmt.executeUpdate();
			}
		} catch(Exception e) {
			
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return board;
	}
	// 전체보기
	public List<BoardVO> getBoardList() {
		// 비어있는 list 생성
		List<BoardVO> boardlist = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				// 검색 결과 row당 하나의 BoardVO 객체에 매핑한다.
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				// 매핑된 객체를 list에 넣는다.
				boardlist.add(board);
			}
		} catch(Exception e) {
			
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return boardlist;
	}
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		
	}
}
