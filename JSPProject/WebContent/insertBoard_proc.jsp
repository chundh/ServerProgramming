<%@page import="com.rubypaper.biz.board.BoardDAOJDBC"%>
<%@page import="com.rubypaper.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
    	// 1. ����� �Է����� ����
    	String title = request.getParameter("title");
    	String writer = request.getParameter("writer");
    	String content = request.getParameter("content");
    	
    	// 2. DB ���� ó��
    	BoardVO vo = new BoardVO();
    	vo.setTitle(title);
    	vo.setWriter(writer);
    	vo.setContent(content);
    	
    	BoardDAOJDBC boardDAO = new BoardDAOJDBC();
    	boardDAO.insertBoard(vo);
    	
    	// 3. ȭ�� �׺���̼�
    	response.sendRedirect("getBoardList.jsp");
    %>
    

    
    
    
    
    