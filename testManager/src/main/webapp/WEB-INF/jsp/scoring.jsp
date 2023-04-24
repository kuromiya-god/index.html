<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Ques" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
ArrayList<Ques> questions = (ArrayList<Ques>) request.getAttribute("resultList");
float acc = (float)request.getAttribute("accuracy");
		for (Ques ques : questions) {
	%>
	<div>
		<% if(ques.isCheckAns()){ %>
			〇
			<%}else{ %>
			×
			<%} %><br>
		<p>問題文: <%= ques.getQuestion() %></p>
		
			<input type="hidden" name="id" value="<%= ques.getId() %>">
        	1.<%= ques.getOption1() %>
        	2.<%= ques.getOption2() %>
        	3.<%= ques.getOption3() %>
        	4.<%= ques.getOption4() %><br>
			回答：<%= ques.getResult() %>
			正解：<%= ques.getAnswer() %><br>
			解説：<%= ques.getExplanation() %><br>
	</div>
	<%
		}
	%>
	正解率：<%= acc %>%
</body>
</html>