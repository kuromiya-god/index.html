<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>クイズ</title>
</head>
<body>
    <h1>クイズ</h1>
    <form action="QuizServlet" method="post">
        <%-- 問題文を出力 --%>
        <p>${question.getText()}</p>
        
        <%-- 選択肢を出力 --%>
        <% for (Choice choice : question.getChoices()) { %>
            <p>
                <input type="radio" name="choiceId" value="<%= choice.getId() %>">
                <%= choice.getText() %>
            </p>
        <% } %>
        
        <%-- hidden要素で問題IDを送信する --%>
        <input type="hidden" name="questionId" value="${question.getId()}">
        <input type="submit" value="回答する">
    </form>
</body>
</html>