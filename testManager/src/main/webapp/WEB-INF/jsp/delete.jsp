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
<title>Insert title here</title>
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
	<h1>4択クイズ作成</h1>
	<div style="display:flex;">
		<nav>
			<a href="/testManager/UpGo" class="tablinks active" onclick="openTab(event, 'tab1')">試験</a>
			<a href="/testManager/quesMake" class="tablinks active" onclick="openTab(event, 'tab2')">問題作成</a>
			<a href="/testManager/GoEdit" class="tablinks active" onclick="openTab(event, 'tab3')">問題編集</a>
			<a href="/testManager/LogOut" class="tablinks logout" onclick="openTab(event, 'tab4')">ログアウト</a>
		</nav>
		<div style="flex:3;">
			<div id="tab1" class="tabcontent active">
			<%
		// Servletから問題リストを取得する
		questions = (ArrayList<Ques>) session.getAttribute("quesList");
		// 問題リストをループして、各問題を表示する
	%>
	<p style="color: red; font-size: 24px;">削除モード</p>
	<form method="post" action="/testManager/ConfirmDelete">
<%
		for (Ques ques : questions) {
	%>
	<div>
		<p><input type="radio" name="answer" value=<%=ques.getId()%> required>問題文: <%= ques.getQuestion() %></p>
				
	</div>
	<%
		}
	%>
	
	<input type="submit" value="削除"><br>
</form>
	</div>
	</div>
	</div>
</body>
</html>