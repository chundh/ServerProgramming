package useDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetBoardListTest {
    public static void main(String[] args) {
    	BoardDAO boardDAO = new BoardDAO();
    	// return 한 글 형태를 원하는 형태로 사용할 수 있다.
    	List<BoardVO> list = boardDAO.getBoardList();
    	
    	// 1. CASE
//    	System.out.println("[ BOARD LIST ]");
//    	for(BoardVO vo: list) {
//    		System.out.println("--->" + vo.toString());
//    	}
    	
    	// 2.CASE
    	System.out.println("검색된 게시글 수: " + list.size());
    	
    }
}
