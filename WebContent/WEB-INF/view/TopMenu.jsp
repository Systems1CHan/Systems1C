<!-----------------------------------------------
演習番号	：総合演習
プログラム名：TOPメニュー画面
作成日		：2022/09/07
作成者		：NarimichiHenmi/SYS
-------------------------------------------------
修正履歴(修正日：担当者；修正内容)
------------------------------------------------->
<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TOPメニュー</title>
<%-- css用 リンクはheadに格納 --%>
<link rel="stylesheet" href="./static/css/Layout.css">
<link rel="stylesheet" href="./static/css/Button.css">
<link rel="stylesheet" href="./static/css/phone.css">
<%-- JavaScript用 --%>
<script type="text/javascript" src="./static/js/check.js"></script>
<script type="text/javascript" src="./static/js/transition.js"></script>
</head>

<body>
	<header>
		<div class="header_title">契約管理・事故受付システム ハンディー</div>
	</header>
	<main>
		<article>
			<div class="main_roundedConer_loginTop">
				<div class="main_subTitle">TOPメニュー</div>
				<div class="button_center">
					<button type="button" onclick="toTopNew();" class="button_design_topMenu">新規試算</button>
				</div>
				<div class="button_center">
					<button type="button" onclick="toTopRecording();" class="button_design_topMenu">計上</button>
				</div>
				<div class="button_center">
					<button type="button" onclick="toTopInquiry();" class="button_design_topMenu">契約内容照会</button>
				</div>
				<div class="button_center">
					<button type="button" onclick="toTopCancel();" class="button_design_topMenu">解約</button>
				</div>
				<div class="button_center">
					<button type="button" onclick="toTopAccept();" class="button_design_topMenu_last">事故受付</button>
				</div>
			</div>
		</article>
	</main>
	<footer>
		<div class="footer_title">Handy</div>
	</footer>
</body>

</html>