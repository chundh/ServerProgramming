package com.rubypaper.biz.board;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("business-layer.xml");
		
		BoardService service = (BoardService) container.getBean("service");
		if(service != null) {
			System.out.println(service + " : lookup ¼º°ø");
		}
		BoardVO vo = new BoardVO();
		vo.setSeq(11);
		vo.setTitle("title");
		vo.setWriter("writer");
		vo.setContent("content");
		service.insertBoard(vo);
		
//		vo.setSearchCondition("TITLE");
//		vo.setSearchKeyword("");
//		List<BoardVO> boardList = service.getBoardList(vo);
//		System.out.println("[ BOARD LIST ]");
//		for(BoardVO board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//		container.close();
	}
}
