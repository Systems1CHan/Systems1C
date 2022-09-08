<!-----------------------------------------------
演習番号	：総合演習
プログラム名：ログイン画面
作成日		：2022/09/07
作成者		：NarimichiHenmi/SYS
-------------------------------------------------
修正履歴(修正日：担当者；修正内容)
------------------------------------------------->

<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL用 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<%-- css用 --%>
<link rel="stylesheet" href="./static/css/Common.css">
<link rel="stylesheet" href="./static/css/Login.css">
<%-- JavaScript用 --%>
<script type="text/javascript" src="./static/js/login.js"></script>
</head>

<body>
	<header>
		<div class="header_title">契約管理・事故受付システム ハンディー</div>
	</header>
	<main>
		<article>
			<div class="body_roundedConer">
				<div class="body_subTitle">ログイン</div>
				<form action="" id="login_process" method="post">
					<table class="IDpass_table">
						<tr>
							<!-- 入力フォーム（お名前） -->
							<th class="ID_string">ID</th>
							<td><input type="text" name="iD" maxlength="30"
								class="ID_form" /></td>
						</tr>
						<tr>
							<!-- 入力フォーム（電話番号） -->
							<th class="password_string">パスワード</th>
							<td><input type="password" name="password" maxlength="30"
								class="password_form" /></td>
						</tr>
					</table>

					<div class="error">
						<!-- エラーメッセージ表示場所 -->
						<c:out value="${requestScope.errorMsg}" />
					</div>

					<table class="button_table">
						<tr>
							<!-- 入力フォーム（お名前） -->
							<th><button type="button" onclick="loginProcess();"
									class="button_design">ログイン</button></th>
							<td><input type="reset" value="リセット" class="button_design"></td>
						</tr>
					</table>
				</form>
			</div>
		</article>
	</main>
	<footer>
		<div class="footer_title">Handy</div>
	</footer>
</body>
</html>