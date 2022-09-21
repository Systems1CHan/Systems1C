<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>申込書印刷確認画面</title>
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
		<button type="button" onclick="toTopMenu();" class="button_design_top">トップへ戻る</button>
		<div class="main_roundedConer">
			<form action="" id="finishprint_frm" method="get">
				<table class="confirm_table" border="1"
					style="border-collapse: collapse">
					<tbody>
						<tr>
							<td class="confirm_table_headline" colspan="2">申込書印刷確認</td>
						</tr>
						<tr>
							<th class="confirm_table_left">契約者名</th>
							<td><c:out
									value="${sessionScope.contractInfo.getkanaNameForLabel()}" /></td>
						</tr>
						<tr>
							<th class="confirm_table_left">払込方法</th>
							<td><c:out
									value="${sessionScope.contractInfo.getPaymentMethodForLabel()}" /></td>
						</tr>
						<tr>
							<th class="confirm_table_left">払込回数</th>
							<td><c:out value="${sessionScope.contractInfo.installment}" /></td>
						</tr>
						<tr>
							<th class="confirm_table_left">総払込保険料</th>
							<td><c:out
									value="${sessionScope.compensation.getPremiumAmountForLabel()}" /></td>
						</tr>
						<tr>
							<th class="confirm_table_left">一回分保険料</th>
							<td><c:out
									value="${sessionScope.compensation.getPremiumInstallmentForLabel()}" /></td>
						</tr>
					</tbody>
				</table>
				<table class="button_center_parallel">
					<tr>
						<td>
							<button type="button" class="button_design"
								onclick="toNewEstimationEntryPage()">戻る</button>
						</td>
						<td>
							<button type="button" class="button_design"
								onclick="toFinishPrintPage()">印刷</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</main>
	<footer>
		<div class="footer_title">Handy</div>
	</footer>
</body>
</html>