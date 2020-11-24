package useDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import useDao.JDBCUtil;

/**
 * DAO�� �����ؼ� ������ ȣ���ϴ� Ŭ���̾�Ʈ�� �ڵ差�� ���� �� �ִ�.
 * �Ķ���Ϳ� ��Ȯ�� �����Ͱ� ������ �ϱ� ���ؼ� VO�� �����ϰ� �ȴٸ� ������� �԰ݿ� �´� �����͸� ����ڿ��� �˷��� �� �ִ�.
 * 
 * @author Chun
 *
 */

public class BoardDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	// Board ���̺� ���� ���ɾ�
	private static final String BOARD_INSERT =  "insert into board(seq, title, writer, content) " + 
												"values((select nvl(max(seq), 0)+1 from board), ?, ?, ?)";
	private static final String BOARD_UPDATE = "update board set title = ?, content = ? where seq = ?";
	private static final String BOARD_DELETE = "delete board where seq = ?";
	private static final String BOARD_GET = "SELECT * FROM BOARD WHERE SEQ = ?";
	private static final String BOARD_LIST = "select * from board order by seq desc";
	private static final String BOARD_UPDATECNT = "update board set cnt = cnt+1 where seq = ?";
	
	//BORAD ���̺� ���� CRUD ����� �޼ҵ�
	// �� ���
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
	// �� ����
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
	// �� ����
	// ��ǻ� seq�ϳ��� �ޱ� ���� ��ü�� �޾ƿ��� ���� ����ó�� ���� �� ������ 
	// ���߿� ����߰��� ���� �����͸� �߰��� �ʿ��ϰ� �� �� �ֱ� ������ ���� ���� �ƴϴ�.
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
	// �󼼺���
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
				// ���ε� ��ü�� list�� �ִ´�.
				
				//�˻������ �����ϴ� ��� ��ȸ���� ������Ų��.
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
	// ��ü����
	public List<BoardVO> getBoardList() {
		// ����ִ� list ����
		List<BoardVO> boardlist = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				// �˻� ��� row�� �ϳ��� BoardVO ��ü�� �����Ѵ�.
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				// ���ε� ��ü�� list�� �ִ´�.
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