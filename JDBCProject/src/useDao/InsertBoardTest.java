package useDao;

public class InsertBoardTest {
    public static void main(String[] args) {
    	// 1. �� ��� ��� ó��
    	BoardDAO boardDAO = new BoardDAO();
    	
    	BoardVO boardVO = new BoardVO();
    	boardVO.setTitle("DAO����");
    	boardVO.setWriter("�ۼ���");
    	boardVO.setContent("����");
    	
    	boardDAO.insertBoard(boardVO);
    	
    	// 2. �� ��� �˻� ��� ó��
    	boardDAO.getBoardList();
		
    }
}
