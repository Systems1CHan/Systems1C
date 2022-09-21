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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>照会開始画面</title>
<%-- css(共通) --%>
<link rel="stylesheet" href="./static/css/Button.css">
<link rel="stylesheet" href="./static/css/Layout.css">
<link rel="stylesheet" href="./static/css/Parts.css">
<link rel="stylesheet" href="./static/css/phone.css">
<%-- JavaScript用 --%>
<script type="text/javascript" src="./static/js/transition.js"></script>
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
						<th><button type="button" onclick="toTopMenu();"
								class="button_design_top">トップへ戻る</button></th>
					</tr>
				</table>
			<div class="main_roundedConer">
				<div class="main_subTitle">契約内容照会開始</div>
					<table class="form_table">
						<tr>
							<!-- 入力フォーム（証券番号） -->
							<th class="form_table_left">証券番号</th>
							<td><input class="form_table_right" id="polNo" name="polNo" maxlength="10"></td>

						</tr>6
					</table>
				<!-- エラーメッセージ -->
				<div class="error" id="FORM_ERROR">
  			    	<c:out value="${requestScope.FORM_ERROR }" />
				</div>
					<table class="button_center_parallel">
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