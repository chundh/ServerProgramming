package useDao;

public class InsertBoardTest {
    public static void main(String[] args) {
    	// 1. 글 등록 기능 처리
    	BoardDAO boardDAO = new BoardDAO();
    	
    	BoardVO boardVO = new BoardVO();
    	boardVO.setTitle("DAO제목");
    	boardVO.setWriter("작성자");
    	boardVO.setContent("내용");
    	
    	boardDAO.insertBoard(boardVO);
    	
    	// 2. 글 목록 검색 기능 처리
    	boardDAO.getBoardList();
		
    }
}
