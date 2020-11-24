package useDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateBoardTest {
    public static void main(String[] args) {
    	// 1. 글 수정 기능 처리
    	BoardDAO boarddao = new BoardDAO();
//    	boarddao.updateBoard("---수정제목", "---수정내용", 1);
    	BoardVO boardVO = new BoardVO();
    	boardVO.setTitle("수정제목");
    	boardVO.setContent("수정제목");
    	boardVO.setSeq(1);
    	boarddao.updateBoard(boardVO);
    	
    	boarddao.getBoard(boardVO);
    }
}
