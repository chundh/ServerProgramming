package useDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateBoardTest {
    public static void main(String[] args) {
    	// 1. �� ���� ��� ó��
    	BoardDAO boarddao = new BoardDAO();
//    	boarddao.updateBoard("---��������", "---��������", 1);
    	BoardVO boardVO = new BoardVO();
    	boardVO.setTitle("��������");
    	boardVO.setContent("��������");
    	boardVO.setSeq(1);
    	boarddao.updateBoard(boardVO);
    	
    	boarddao.getBoard(boardVO);
    }
}
