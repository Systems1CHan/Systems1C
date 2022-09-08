<%------------------------------------------------------------------------------
  演習番号    ：[総合演習]
  プログラム名：ハンディー
  作成日      ：[2022/09/07]
  作成者      ：[Akane Nambu/SYS]
 ------------------------------------------------------------------------------
  修正履歴 (修正日 ： 担当者 ： 修正内容)
 -----------------------------------------------------------------------------%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>計上開始</title>
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
				<form action="" id="@@@@@@@@@" method="post">
					<table class="button_table">
						<tr>
							<!-- 入力フォーム（お名前） -->
							<th><button type="button" onclick="＠＠＠＠＠＠＠JSの関数名を入れる＠＠＠＠＠;"
									class="button_design">トップへ戻る</button></th>
						</tr>
					</table>
				</form>
			<div class="roundedConer">
				<div class="subTitle">計上開始</div>
				<form action="" id="login_process" method="post">
					<table class="IDpass_table">
						<tr>
							<!-- 入力フォーム（印刷連番） -->
							<th class="password_string">印刷連番</th>
							<td><input type="password" maxlength="8"></td>
						</tr>
					</table>

					<table class="button_table">
						<tr>
							<!-- 入力フォーム（お名前） -->
							<th><button type="button" onclick="toQueryConfirm();"
									class="button_design">計上開始</button></th>
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