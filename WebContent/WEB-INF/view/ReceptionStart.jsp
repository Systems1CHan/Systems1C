<!-- ---------------------------------------------------------------------------------------
演習番号		：総合演習
プログラム名	：事故受付開始画面
作成日			：2022/09/07
作成者			：SYS KEINA NOGUCHI
--------------------------------------------------------------------------------------------
修正履歴（修正日：担当者：修正内容）
-------------------------------------------------------------------------------------------->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>事故受付開始</title>
<%-- css用 リンクはheadに格納 --%>
<link rel="stylesheet" href="./static/css/CommonHeader.css">
<link rel="stylesheet" href="./static/css/CommonMain.css">
<link rel="stylesheet" href="./static/css/CommonFooter.css">
<link rel="stylesheet" href="./static/css/HenmiLogin.css">
<%-- JavaScript用 --%>
<script type="text/javascript" src="./static/js/transition.js"></script>
</head>

<body>
	<header>
		<div class="header_title">契約管理・事故受付システム ハンディー</div>
	</header>
	<main>
		<article>
			<form action="" id="accident_frm" method="post">
				<table class="button_table">
					<tr>
						<!-- 入力フォーム（お名前） -->
						<th><button type="button" onclick="toTopMenu();"
								class="button_design">トップへ戻る</button></th>
					</tr>
				</table>
			<div class="roundedConer">
				<div class="subTitle">事故受付開始</div>
					<table class="IDpass_table">
						<tr>
							<!-- 入力フォーム（証券番号） -->
							<th class="password_string">証券番号</th>
							<td><input name="polNo" maxlength="10"></td>
						</tr>
						<tr>
							<!-- 入力フォーム（証券番号） -->
							<th class="password_string">受付番号</th>
							<td><input name="claimNo" maxlength="10"></td>
						</tr>
					</table>
					<!-- エラーメッセージ -->
				<div align="center" id="FORM_ERROR">
  			    	<c:out value="${requestScope.FORM_ERROR }" />
				</div>
					<table class="button_table">
						<tr>
							<!-- 入力フォーム（お名前） -->
							<th><button type="button" onclick="toTypeAccidentPage();"
									class="button_design">受付開始</button></th>
						</tr>
					</table>
				</div>
			</form>
		</article>
	</main>
	<footer>
		<div class="footer_title">Handy</div>
	</footer>
</body>
</html>
