<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<meta charset="UTF-8">
<title>TOPメニュー</title>
<%-- css用 リンクはheadに格納 --%>
<link rel="stylesheet" href="./static/css/CommonHeader.css">
<link rel="stylesheet" href="./static/css/CommonMainButton.css">
<link rel="stylesheet" href="./static/css/CommonFooter.css">
<link rel="stylesheet" href="./static/css/HenmiTopMenu.css">
<%-- JavaScript用 --%>
<script type="text/javascript" src="./static/js/topMenu.js"></script>
</head>

<body>
	<header>
		<div class="header_title">契約管理・事故受付システム ハンディー</div>
	</header>
	<main>
		<article>
			<button type="button" onclick="toLogin();"
				class="button_design_logout">ログアウト（仮）</button>

			<div class="roundedConer">
				<div class="subTitle">TOPメニュー</div>
				<div class="button_center">
					<button type="button" onclick="toTopNew();" class="button_design">新規試算</button>
				</div>
				<div class="button_center">
					<button type="button" onclick="toTopRecording();" class="button_design">計上</button>
				</div>
				<div class="button_center">
					<button type="button" onclick="toTopInquiry();" class="button_design">契約内容照会</button>
				</div>
				<div class="button_center">
					<button type="button" onclick="toTopCancel();" class="button_design">解約</button>
				</div>
				<div class="button_center">
					<button type="button" onclick="toTopAccept();" class="button_design_last">事故受付</button>
				</div>
			</div>
		</article>
	</main>
	<footer>
		<div class="footer_title">Handy</div>
	</footer>
</body>

</html>