<!-----------------------------------------------
演習番号	：総合演習
プログラム名：ログイン画面
作成日		：2022/09/07
作成者		：NarimichiHenmi/SYS
-------------------------------------------------
修正履歴(修正日：担当者；修正内容)
(2022/09/08 ： NarimichiHenmi/SYS ：パスワードフォームに目玉を追加)
(2022/09/09 ： NarimichiHenmi/SYS ：目玉のコードを変更)
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
<%-- css(共通) --%>
<link rel="stylesheet" href="./static/css/Button.css">
<link rel="stylesheet" href="./static/css/Layout.css">
<link rel="stylesheet" href="./static/css/Parts.css">
<%-- css(個別) --%>
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	rel="stylesheet">
<%-- JavaScript用 --%>
<script type="text/javascript" src="./static/js/login.js"></script>
<script type="text/javascript" src="./static/js/transition.js"></script>
</head>

<body>

	<header>
		<div class="header_title">契約管理・事故受付システム ハンディー</div>
	</header>

	<main>
		<article>
			<div class="main_roundedConer_loginTop">
				<div class="main_subTitle">ログイン</div>
				<form action="" id="login_process" method="post">

					<!-- ID・パスワードフォームのテーブル -->
					<table class="form_table">
						<tr>
							<!-- 入力フォーム（ID） -->
							<td class="ID_string">ID</td>
							<td class="ID_form"><input type="text" name="iD" id="iD"
								class="ID_form_default" maxlength="30">
						</tr>
						<tr>
							<!-- 入力フォーム（パスワード） -->
							<td class="password_string">パスワード</td>
							<td class="password_form"><input type="password"
								name="password" id="password" class="password_form_default"
								maxlength="30"> <span id="buttonEye"
								class="fa fa-eye-slash" onclick="pushHideButton()"></span></td>
						</tr>
					</table>

					<!-- エラーメッセージ表示場所 -->
					<div id="FORM_ERROR" class="error">
						<c:out value="${requestScope.errorMsg}" />
					</div>

					<!-- ログイン・リセットボタンのテーブル -->
					<table class="button_center_parallel">
						<tr>
							<th><button type="button" onclick="loginProcess();"
									class="button_design">ログイン</button></th>
							<td><input type="reset" value="リセット" class="button_design"></td>
						</tr>
					</table>
					<table class="button_center_parallel">
						<tr>
							<td><c:out value="${requestScope.message}" /></td>
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