package useDao;
import java.sql.*;

public class GetBoardTest {
    public static void main(String[] args) {
    	BoardDAO boardDAO = new BoardDAO();
    	BoardVO vo = new BoardVO();
    	vo.setSeq(2);
    	BoardVO board = boardDAO.getBoard(vo);
    	System.out.println(board.getSeq() + " �� �Խñ��� �� ����");
    	System.out.println("���� : " + board.getTitle());
    	System.out.println("�ۼ��� : " + board.getWriter());
    	System.out.println("���� : " + board.getContent());
    	System.out.println("����� : " + board.getRegDate());
    	System.out.println("��ȸ�� : " + board.getCnt());
    	    
    }
}
