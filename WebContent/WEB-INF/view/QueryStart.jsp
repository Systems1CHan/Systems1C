<!-- ---------------------------------------------------------------------------------------
演習番号		：仕様書演習
プログラム名	：予約情報一覧画面
作成日			：2022/08/09
作成者			：SYS TOORU NAKAYA
--------------------------------------------------------------------------------------------
修正履歴（修正日：担当者：修正内容）
-------------------------------------------------------------------------------------------->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>照会開始画面</title>
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
			<form action="" id="inquiry_frm" method="post">
				<table class="button_table">
					<tr>
						<!-- 入力フォーム（お名前） -->
						<th><button type="button" onclick="＠＠＠＠＠＠＠JSの関数名を入れる＠＠＠＠＠;"
								class="button_design">トップへ戻る</button></th>
					</tr>
				</table>
			<div class="roundedConer">
				<div class="subTitle">契約内容照会開始</div>
					<table class="IDpass_table">
						<tr>
							<!-- 入力フォーム（証券番号） -->
							<th class="password_string">証券番号</th>
							<td><input maxlength="10"></td>
						</tr>
					</table>
					<table class="button_table">
						<tr>
							<!-- 入力フォーム（お名前） -->
							<th><button type="button" onclick="toInquiryconfirmPage();"
									class="button_design">照会検索</button></th>
							<td><input type="reset" value="リセット" class="button_design"></td>
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