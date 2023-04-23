<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Ques" %>
<%    // ArrayListの宣言
    ArrayList<Ques> questions = new ArrayList<Ques>();
	
%>
<% // ArrayListの宣言
int[] answers = (int[])session.getAttribute("answers");
boolean[] ansCheck = (boolean[])session.getAttribute("ansCheck");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		// Servletから問題リストを取得する
		questions = (ArrayList<Ques>) session.getAttribute("question");
		// 問題リストをループして、各問題を表示する
	%>
</body>
</html>