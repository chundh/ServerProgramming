package useDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteBoardTest {
    public static void main(String[] args) {
    	BoardDAO boardDAO = new BoardDAO();
//    	boardDAO.deleteBoard(2);
    	BoardVO boardVO = new BoardVO();
    	boardVO.setSeq(2);
    	boardDAO.deleteBoard(boardVO);
    	// 2. 글 목록 검색 기능 처리
    	boardDAO.getBoardList();
    }
}
