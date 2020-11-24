package useDao;
import java.sql.*;

public class GetBoardTest {
    public static void main(String[] args) {
    	BoardDAO boardDAO = new BoardDAO();
    	BoardVO vo = new BoardVO();
    	vo.setSeq(2);
    	BoardVO board = boardDAO.getBoard(vo);
    	System.out.println(board.getSeq() + " 번 게시글의 상세 정보");
    	System.out.println("제목 : " + board.getTitle());
    	System.out.println("작성자 : " + board.getWriter());
    	System.out.println("내용 : " + board.getContent());
    	System.out.println("등록일 : " + board.getRegDate());
    	System.out.println("조회수 : " + board.getCnt());
    	    
    }
}
