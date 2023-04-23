<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</style>
</head>
<body>
	<h1>4択クイズ作成</h1>
	<div style="display:flex;">
		<nav>
			<a href="/testManager/UpGo" class="tablinks active" onclick="openTab(event, 'tab1')">試験</a>
			<a href="/testManager/quesMake" class="tablinks active" onclick="openTab(event, 'tab2')">問題作成</a>
			<a href="/testManager/UpGo" class="tablinks active" onclick="openTab(event, 'tab3')">問題編集</a>
		</nav>
		<div style="flex:3;">
			<div id="tab1" class="tabcontent active">
	<form method="post" action="/testManager/QuizServlet">
		<label for="answer">問題の番号:</label>
		 <input type="text" name="ids" required><br>
		<input type="submit" value="試験開始">
	</form>
	</div>
	</div>
	</div>
</body>
</html>