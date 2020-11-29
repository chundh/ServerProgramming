package com.rubypaper.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.rubypaper.biz.common.JDBCUtil;

// 2. DAO(Data Access Object) Ŭ����
//@Component("dao")
// ������ ���Ǵ� ������ ���� service�� repository�� ������ ���� ������ ��� ����.
// DB������ respository�� �ַ� ����Ѵ�.
//@Repository
public class BoardDAOSpring {
	
	@Autowired // JdbcTemplate�� ���� ���� Ŭ������ �ƴϹǷ� ���� ��ü ������ �� �� ����. �׷��� xml�� bean����ؼ� �޸𸮿� ��ü�� ��� �� spring�� ��ü�� �Ҵ��Ѵ�.
	private JdbcTemplate spring; // spring �����ӿ�ũ���� jdbctemplate ��ü�� �������ش�.
	
	// BOARD ���̺� ���� SQL ��ɾ�
	private static final String BOARD_INSERT     = "INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) " + 
											       "VALUES((SELECT NVL(MAX(SEQ), 0) + 1 FROM BOARD), ?, ?, ?)";
	private static final String BOARD_UPDATE     = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE SEQ=?";
	private static final String BOARD_UPDATE_CNT = "UPDATE BOARD SET CNT=CNT + 1 WHERE SEQ=?";
	private static final String BOARD_DELETE     = "DELETE BOARD WHERE SEQ=?";
	private static final String BOARD_GET        = "SELECT * FROM BOARD WHERE SEQ=?";
	private static final String BOARD_LIST_TITLE   = "SELECT * FROM BOARD WHERE TITLE LIKE '%'||?||'%' ORDER BY SEQ DESC";
	private static final String BOARD_LIST_CONTENT = "SELECT * FROM BOARD WHERE CONTENT LIKE '%'||?||'%' ORDER BY SEQ DESC";
		
	// BOARD ���̺� ���� CRUD ����� �޼ҵ�
	// �� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("==> Spring ������� insertBoard() ó��");
		spring.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("==> Spring ������� updateBoard() ó��");
		spring.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("==> Spring ������� deleteBoard() ó��");
		spring.update(BOARD_DELETE, vo.getSeq());
	}
	
	// �� �� ��ȸ
//	public BoardVO getBoard(BoardVO vo) {
//		System.out.println("==> Spring ������� getBoard() ó��");
//		spring.update(BOARD_GET);
//		BoardVO board = null;
//		return board;
//	}
	
	public Map<String, Object> getBoard(BoardVO vo){
		System.out.println("==> spring ������� getBoard() ó��");
		Object[] args = {vo.getSeq()};
		return spring.queryForMap(BOARD_GET, args);
	}
	
	// �� ��� �˻�
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("==> Spring ������� getBoardList() ó��");
		spring.update(BOARD_LIST_CONTENT);
		// ����ִ� ����Ʈ �÷����� �����Ѵ�. 
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		return boardList;
	}
}