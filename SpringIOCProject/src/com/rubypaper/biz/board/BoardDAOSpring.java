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

// 2. DAO(Data Access Object) 클래스
//@Component("dao")
// 실제로 사용되는 목적에 따라 service와 repository로 나누는 것이 가독성 향상에 좋다.
// DB연동은 respository를 주로 사용한다.
//@Repository
public class BoardDAOSpring {
	
	@Autowired // JdbcTemplate는 내가 만든 클래스가 아니므로 따로 객체 생성을 할 수 없다. 그래서 xml에 bean등록해서 메모리에 객체를 띄운 후 spring에 객체를 할당한다.
	private JdbcTemplate spring; // spring 프레임워크에서 jdbctemplate 객체를 제공해준다.
	
	// BOARD 테이블 관련 SQL 명령어
	private static final String BOARD_INSERT     = "INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) " + 
											       "VALUES((SELECT NVL(MAX(SEQ), 0) + 1 FROM BOARD), ?, ?, ?)";
	private static final String BOARD_UPDATE     = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE SEQ=?";
	private static final String BOARD_UPDATE_CNT = "UPDATE BOARD SET CNT=CNT + 1 WHERE SEQ=?";
	private static final String BOARD_DELETE     = "DELETE BOARD WHERE SEQ=?";
	private static final String BOARD_GET        = "SELECT * FROM BOARD WHERE SEQ=?";
	private static final String BOARD_LIST_TITLE   = "SELECT * FROM BOARD WHERE TITLE LIKE '%'||?||'%' ORDER BY SEQ DESC";
	private static final String BOARD_LIST_CONTENT = "SELECT * FROM BOARD WHERE CONTENT LIKE '%'||?||'%' ORDER BY SEQ DESC";
		
	// BOARD 테이블 관련 CRUD 기능의 메소드
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("==> Spring 기반으로 insertBoard() 처리");
		spring.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("==> Spring 기반으로 updateBoard() 처리");
		spring.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}
	
	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("==> Spring 기반으로 deleteBoard() 처리");
		spring.update(BOARD_DELETE, vo.getSeq());
	}
	
	// 글 상세 조회
//	public BoardVO getBoard(BoardVO vo) {
//		System.out.println("==> Spring 기반으로 getBoard() 처리");
//		spring.update(BOARD_GET);
//		BoardVO board = null;
//		return board;
//	}
	
	public Map<String, Object> getBoard(BoardVO vo){
		System.out.println("==> spring 기반으로 getBoard() 처리");
		Object[] args = {vo.getSeq()};
		return spring.queryForMap(BOARD_GET, args);
	}
	
	// 글 목록 검색
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("==> Spring 기반으로 getBoardList() 처리");
		spring.update(BOARD_LIST_CONTENT);
		// 비어있는 리스트 컬렉션을 생성한다. 
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		return boardList;
	}
}