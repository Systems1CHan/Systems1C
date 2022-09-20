<%------------------------------------------------------------------------------
  演習番号    ：[総合演習]
  プログラム名：ハンディー
  作成日      ：[2022/09/07]
  作成者      ：[Akane Nambu/SYS]
 ------------------------------------------------------------------------------
  修正履歴 (修正日 ： 担当者 ：南部朱音
 -----------------------------------------------------------------------------%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>計上開始画面</title>
<%-- css(共通) --%>
<link rel="stylesheet" href="./static/css/Button.css">
<link rel="stylesheet" href="./static/css/Layout.css">
<link rel="stylesheet" href="./static/css/Parts.css">
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
			</form>
			<div class="main_roundedConer">
				<div class="main_subTitle">計上開始</div>
				<form action="" id="recording_frm" method="post">
					<table class="form_table">
						<tr>
							<!-- 入力フォーム（印刷連番） -->
							<th class="form_table_left">印刷連番</th>
							<td><input class="form_table_right" id="insatsuRenban" name="insatsuRenban"
								maxlength="8"></td>
						</tr>
					</table>
					<!-- エラーメッセージ -->
					<div class="error" id="FORM_ERROR">
						<c:out value="${requestScope.message}" />
					</div>
					<div class="button_center">
						<!-- 入力フォーム（お名前） -->
						<button type="button" onclick="toRecordingPage();"
							class="button_design">計上開始</button>
					</div>
				</form>
			</div>
		</article>
	</main>
	<footer>
		<div class="footer_title">Handy</div>
	</footer>

</body>
</html>