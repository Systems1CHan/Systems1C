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
<title>計上完了完了画面</title>
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
		<form action="" id="@@@@@@@@@" method="post">
			<table class="button_table">
				<tr>
				<!-- 入力フォーム（お名前） -->
					<th><button type="button" onclick="toTopMenu();"
					class="button_design">トップへ戻る</button></th>
				</tr>
			</table>
		</form>
		<article>
			<div class="subTitle">計上完了</div>
				<table border="1" style="border-collapse: collapse">
					<tr>
 						<td colspan="2">計上完了</td>
 					</tr>
					<tr>
   						<td>印刷連番</td><td><c:out value="${sessionScope.contractInfo.insatsuRenban}"/></td>
  					</tr>
 					<tr>
   						<td>証券番号</td><td><c:out value="${sessionScope.contractInfo.polNo}"/></td>
  					</tr>
  					<tr>
   						<td>契約者名</td><td><c:out value="${sessionScope.contractInfo.getNameForLabel()}"/></td>
  					</tr>
				</table>
		</article>
	</main>
	<footer>
		<div class="footer_title">Handy</div>
	</footer>
</body>
</html>
