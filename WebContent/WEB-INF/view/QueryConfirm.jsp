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
	<title>予約情報一覧画面</title>
	<script type="text/javascript" src="./static/js/common.js"></script>
</head>
<body>
	<header>
			<!-- タイトルと画像  -->
		<h1>
			<img src="./static/img/airplane_logo.gif" alt="logo">
			契約管理・事故受付システム　ハンディー
		</h1>

		<button type="button" onclick="toStartPage()">新規手続きを開始</button>

		<!-- 表題 -->
		<h2>
			契約内容照会確認(契約条件タブ)(個人)
		</h2>
		<h3>
			現在までに申し込みをされた予約情報の一覧を表示します。
		</h3>
	</header>
	<main>
			<!-- お名前フォーム -->
		<article>
			<form action="" id="result_frm" method="post">

		<!-- 次画面ID用フィールド -->
		<input type="hidden" name="BUTTON_ID" value="">
		<div align="center">
			<!-- 予約結果表示テーブル -->
			<table border="1">
				<tr>
					<th nowrap align="center" width="100">予約番号</th>
					<th nowrap align="center" width="100">ご出発日</th>
					<th nowrap align="center" width="100">経路</th>
					<th nowrap align="center" width="100">携行品保険への加入</th>
					<th nowrap align="center" width="100">ご請求金額</th>
					<th nowrap align="center" width="100">氏名</th>
					<th nowrap align="center" width="100">電話番号</th>
				</tr>
					<c:forEach items="${entityList}" var="x">
						<tr>
							<th nowrap align="center" width="100"><c:out value="${x.getNo()}" /></th>
							<th nowrap align="center" width="100"><c:out value="${x.getDepartureDate()}" /></th>
							<th nowrap align="center" width="100"><c:out value="${x.getRoute()}" /></th>
							<th nowrap align="center" width="100"><c:out value="${x.getBaggageCompForLabel()}" /></th>
							<th nowrap align="center" width="100"><c:out value="${x.getAmountForLabel()}" /></th>
							<th nowrap align="center" width="100"><c:out value="${x.getCustomerNameForLabel()}" /></th>
							<th nowrap align="center" width="100"><c:out value="${x.getCustomerPhoneNo()}" /></th>
						</tr>
					</c:forEach>
			</table>
		</div>

				<!-- onclick でボタンが押された際に実行する関数を指定する -->
				<button type="button" onclick="toStartPage()">新規手続きを開始</button>

			</form>
		</article>
	</main>
</body>
</html>