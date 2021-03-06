package com.rubypaper.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component("service")
// 클래스의 목적에 따라 service와 repository로 나누면서 가독성을 향상시킨다.
@Service("service")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO; // boardDAO의 구현객체가 두개 이상 메모리에 적재되어 있으면 에러가 나므로, boardDAOJDBC, boardDAOSpring의 @repository를 지우고 xml에 bean등록해야한다.
	
//	@Autowired
//	private BoardDAO boardDAO;

	public BoardServiceImpl() {
		System.out.println("==> boardServiceImpl 생성");
	}
	
	@Override
	public void insertBoard(BoardVO vo) {
		if(vo.getSeq()==0) {
			throw new IllegalArgumentException();
		}
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	
}
