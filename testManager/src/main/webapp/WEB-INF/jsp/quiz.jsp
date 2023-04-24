<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Ques" %>
<%    // ArrayListの宣言
    ArrayList<Ques> questions = new ArrayList<Ques>();
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz</title>
<style>
/* タブのスタイル */
nav {
  background-color: #f1f1f1;
  border: 1px solid #ccc;
  border-radius: 5px;
  margin-right: 10px;
  padding: 10px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

/* ボタンのスタイル */
nav a {
  background-color: #ddd;
  color: #333;
  padding: 10px;
  margin: 5px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  font-size: 18px;
}

/* アクティブなボタンのスタイル */
nav a.active {
  background-color: #555;
  color: #fff;
}

/* タブのコンテンツのスタイル */
.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

/* アクティブなタブのコンテンツのスタイル */
.tabcontent.active {
  display: block;
}

nav a.logout {
  font-size: 12px; /* ログアウトリンクのテキストのフォントサイズを14pxに設定 */
  padding: 5px; /* ログアウトリンクを囲む要素のパディングを5pxに設定 */
}
</style>
</head>
<body>
	<div style="display: flex;">
		<nav>
			<a href="/testManager/UpGo" class="tablinks active"	onclick="openTab(event, 'tab1')">試験</a> 
			<a href="/testManager/quesMake"	class="tablinks active" onclick="openTab(event, 'tab2')">問題作成</a>
			<a href="/testManager/GoEdit" class="tablinks active" onclick="openTab(event, 'tab3')">問題編集</a>
			<a href="/testManager/LogOut" class="tablinks logout" onclick="openTab(event, 'tab4')">ログアウト</a>
		</nav>
		<div style="flex: 3;">
			<div id="tab1" class="tabcontent active">
				<%
		// Servletから問題リストを取得する
		questions = (ArrayList<Ques>) session.getAttribute("question");
		// 問題リストをループして、各問題を表示する
	%>
	<form method="post" action="/testManager/Scoring">
<%
		for (Ques ques : questions) {
	%>
	<div>
		<p>問題文: <%= ques.getQuestion() %></p>
		
			<input type="hidden" name="id" value="<%= ques.getId() %>">
        	<input type="radio" name="answer_<%=ques.getId()%>" value="1"><%= ques.getOption1() %><br>
        	<input type="radio" name="answer_<%=ques.getId()%>" value="2"><%= ques.getOption2() %><br>
        	<input type="radio" name="answer_<%=ques.getId()%>" value="3"><%= ques.getOption3() %><br>
        	<input type="radio" name="answer_<%=ques.getId()%>" value="4"><%= ques.getOption4() %><br>
			
	</div>
	<%
		}
	%>
	
	<input type="submit" value="回答する">
		</form>
	</div>
	</div>
	</div>
</body>
</html>