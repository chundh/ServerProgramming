<%@page import="com.rubypaper.biz.board.BoardDAOJDBC"%>
<%@page import="com.rubypaper.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
    	// 1. ����� �Է����� ����
    	String title = request.getParameter("title");
    	String seq = request.getParameter("seq");
    	String content = request.getParameter("content");
    	
    	// 2. DB ���� ó��
    	BoardVO vo = new BoardVO();
    	vo.setTitle(title);
    	vo.setSeq(Integer.parseInt(seq));
    	vo.setContent(content);
    	
    	BoardDAOJDBC boardDAO = new BoardDAOJDBC();
    	boardDAO.updateBoard(vo);
    	
    	// 3. ȭ�� �׺���̼�
    	response.sendRedirect("getBoardList.jsp");
    %>
    

    
    
    
    
    