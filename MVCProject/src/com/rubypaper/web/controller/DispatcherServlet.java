package com.rubypaper.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rubypaper.biz.board.BoardDAO;
import com.rubypaper.biz.board.BoardVO;
import com.rubypaper.biz.user.UserDAO;
import com.rubypaper.biz.user.UserVO;

/**
 * 1. 사용자가 입력한 정보 추출
 * 2. DB연동
 * 3. 화면이동
 * 
 * 위 세가지의 controller 역할을 DispatcherServlet이 한다.
 * view는 jsp가 담당한다.
 * model은 각 db의 dao, vo가 담당한다.
 * 
 * spring에서는 이 controller를 제공해준다.
 * @author Chun
 *
 */

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        System.out.println("--> DispatcherServlet 생성");
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 요청 path 정보를 추출한다.
		String uri = request.getRequestURI();
		System.out.println(uri);
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		// 2. 추출된 path에 따라 요청을 분기처리한다.
		if(path.equals("/login.do")) {
			
			System.out.println("로그인 기능 처리");
			// 1. 사용자 입력정보 추출
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			// 2. DB 연동 처리
			UserVO vo = new UserVO(); 
			vo.setId(id);             
			vo.setPassword(password);
			
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			
			// 3. 화면 네비게이션
			if(user != null) {
				// 로그인 성공 시, 세션(내장 객체)에 상태정보를 저장한다.
				HttpSession session = request.getSession();
				session.setAttribute("user", user);		
				response.sendRedirect("getBoardList.do");
				// jsp실행전에  session에 boardlist를 넣어줘야하므로 .do를 호출한다.
			} else {
				response.sendRedirect("login.html");
			}
			
		}else if(path.equals("/logout.do")) {
			System.out.println("로그아웃 기능 처리");
			
			HttpSession session = request.getSession();
			session.invalidate();
			
			response.sendRedirect("login.html");
		}else if(path.equals("/insertBoard.do")) {
			
			System.out.println("게시 글 등록 기능 처리");
			// 1. 사용자 입력정보 추출
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);
			
			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");
			
		}else if(path.equals("/updateBoard.do")) {
			
			System.out.println("게시 글 수정 기능 처리");
			// 1. 사용자 입력정보 추출
			String title = request.getParameter("title");
			String seq = request.getParameter("seq");
			String content = request.getParameter("content");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setSeq(Integer.parseInt(seq));
			vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.updateBoard(vo);
			
			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");
			
		}else if(path.equals("/deleteBoard.do")) {
			
			System.out.println("게시 글 삭제 기능 처리");
			// 1. 사용자 입력정보 추출
			String seq = request.getParameter("seq");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.deleteBoard(vo);
			
			// 3. 화면 네비게이션
			response.sendRedirect("getBoardList.do");
			
		}else if(path.equals("/getBoard.do")) {
			
			System.out.println("게시 글 상세 조회 기능 처리");
			// 1. 사용자 입력정보 추출
			String seq = request.getParameter("seq");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDAO = new BoardDAO();
			BoardVO board = boardDAO.getBoard(vo);
			// 3. 검색 결과를 session 에 넣는다.
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			
			response.sendRedirect("getBoard.jsp");
			
		}else if(path.equals("/getBoardList.do")) {
			System.out.println("게시 글 목록 검색 기능 처리");
			// 1. 사용자 입력정보 추출
			String searchCondition = request.getParameter("searchCondition");
			String searchKeyword = request.getParameter("searchKeyword");
			
			// Null Check
			if(searchCondition == null) searchCondition = "TITLE";
			if(searchKeyword == null) searchKeyword = "";
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSearchCondition(searchCondition);
			vo.setSearchKeyword(searchKeyword);
			
			BoardDAO boardDAO = new BoardDAO();
			List<BoardVO> boardList = boardDAO.getBoardList(vo);
			
			// 3. 검색 결과를 화면(JSP)에서 사용할 수 있도록 세션에 등록한다.
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			
			// 글 목록 화면(getBoardList.jsp)로 이동한다.
			response.sendRedirect("getBoardList.jsp");
			
		}else {
			System.out.println("URL을 다시 확인해주세요");
		}
		
	}
}
