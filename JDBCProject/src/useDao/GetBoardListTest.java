package useDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetBoardListTest {
    public static void main(String[] args) {
    	BoardDAO boardDAO = new BoardDAO();
    	// return �� �� ���¸� ���ϴ� ���·� ����� �� �ִ�.
    	List<BoardVO> list = boardDAO.getBoardList();
    	
    	// 1. CASE
//    	System.out.println("[ BOARD LIST ]");
//    	for(BoardVO vo: list) {
//    		System.out.println("--->" + vo.toString());
//    	}
    	
    	// 2.CASE
    	System.out.println("�˻��� �Խñ� ��: " + list.size());
    	
    }
}
