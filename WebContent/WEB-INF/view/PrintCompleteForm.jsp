<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>申込書印刷完了画面</title>
<%-- css(共通) --%>
<link rel="stylesheet" href="./static/css/Button.css">
<link rel="stylesheet" href="./static/css/Layout.css">
<link rel="stylesheet" href="./static/css/Parts.css">
<link rel="stylesheet" href="./static/css/phone2.css">
<%-- JavaScript用 --%>
<script type="text/javascript" src="./static/js/transition.js"></script>
</head>
<body>
	<header>
		<div class="header_title">契約管理・事故受付システム ハンディー</div>
	</header>
	<main>
		<form action="" method="post">
			<button type="button" onclick="toTopMenu();" class="button_design_top">トップへ戻る</button>
			<table class="confirm_table" border="1"
				style="border-collapse: collapse">
				<tbody>
					<tr>
						<td class="confirm_table_headline" colspan="2">申込書印刷完了</td>
					</tr>
					<tr>
						<td class="confirm_table_left">印刷連番</td>
						<td><c:out
								value="${sessionScope.contractInfo.insatsuRenban }" /></td>
					</tr>
					<tr>
						<td class="confirm_table_left">契約者名</td>
						<td><c:out
								value="${sessionScope.contractInfo.getNameForLabel()}" /></td>
					</tr>
				</tbody>
			</table>
		</form>
	</main>
</body>
</html>