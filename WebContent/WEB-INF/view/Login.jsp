<!-----------------------------------------------
演習番号	：siyousho_1-1
プログラム名：契約内容入力画面
作成日		：2022/08/05
作成者		：NarimichiHenmi/SYS
-------------------------------------------------
修正履歴(修正日：担当者；修正内容)
(2022/08/10：NarimichiHenmi；ご出発日のinputタグのtypeが"data"になっていたので、"date"に変更した。)
(2022/08/10：NarimichiHenmi；出発地と目的地のinputタグのtypeに"select"が設定されていたので、両方とも削除した。)
(2022/08/19：NarimichiHenmi；出発地と目的地のプルダウンの表示順を東京、福岡、札幌、沖縄に変更。)
(2022/08/19：NarimichiHenmi；ご出発日～携行品保険の項目までをテーブルに変更。)
------------------------------------------------->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<%-- css用 リンクはheadに格納 --%>
<link rel="stylesheet" href="./static/css/CommonHeader.css">
<link rel="stylesheet" href="./static/css/CommonMain.css">
<link rel="stylesheet" href="./static/css/CommonFooter.css">
<link rel="stylesheet" href="./static/css/HenmiLogin.css">
<%-- JavaScript用 --%>
<script type="text/javascript" src="./static/js/login.js"></script>
</head>

<body>
	<header>
		<div class="header_title">契約管理・事故受付システム ハンディー</div>
	</header>
	<main>
		<article>
			<div class="roundedConer">
				<div class="subTitle">ログイン</div>
				<form action="" id="login_process" method="post">
					<table class="IDpass_table">
						<tr>
							<!-- 入力フォーム（お名前） -->
							<th class="ID_string">ID</th>
							<td><input type="text" maxlength="30" class="ID_form" /></td>
						</tr>
						<tr>
							<!-- 入力フォーム（電話番号） -->
							<th class="password_string">パスワード</th>
							<td><input type="password" maxlength="30"
								class="password_form" /></td>
						</tr>
					</table>

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