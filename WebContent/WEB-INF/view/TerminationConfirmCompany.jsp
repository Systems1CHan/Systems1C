<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>解約確認</title>
<%-- css(共通) --%>
<link rel="stylesheet" href="./static/css/Button.css">
<link rel="stylesheet" href="./static/css/Layout.css">
<link rel="stylesheet" href="./static/css/Parts.css">
<link rel="stylesheet" href="./static/css/Tab.css">
<link rel="stylesheet" href="./static/css/phone.css">
<script type="text/javascript" src="./static/js/transition.js"></script>
</head>
<body>
	<header>
		<div class="header_title">契約管理・事故受付システム ハンディー</div>
	</header>
	<main>
		<form action="" id="cancelconfirm_frm" method="post">
			<table class="button_table">
				<tr>
					<!-- 入力フォーム（お名前） -->
					<th><button type="button" onclick="toTopMenu();"
							class="button_design_top">トップへ戻る</button></th>
				</tr>
			</table>

			<div class="sample-area">
				<p id="tabcontrol">
					<a href="#tabpage1">契約条件</a> <a href="#tabpage2">補償</a>
				</p>
				<div id="tabbody">
					<div id="tabpage1">
						<p class="main_subTitle">解約確認(契約条件タブ)</p>
						<table class="confirm_table" border="1" style="border-collapse: collapse">
							<tr>
								<td class="confirm_table_headline" colspan="2">契約内容照会確認</td>
							</tr>
							<tr>
								<td class="confirm_table_left">保険期間</td>
								<td><c:out
										value="${sessionScope.contractInfo.getInsureanceIntervalForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">証券番号</td>
								<td><c:out value="${sessionScope.contractInfo.polNo}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">印刷連番</td>
								<td><c:out
										value="${sessionScope.contractInfo.insatsuRenban}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">契約状態</td>
								<td><c:out
										value="${sessionScope.contractInfo.getStatusFlgForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">被保険者の個人法人区分</td>
								<td><c:out
										value="${sessionScope.contractInfo.getInsuredKbnForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">払込方法</td>
								<td><c:out
										value="${sessionScope.contractInfo.getPaymentMethodForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">会社名-カナ</td>
								<td><c:out
										value="${sessionScope.contractInfo.getkanaNameForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">会社名-漢字</td>
								<td><c:out
										value="${sessionScope.contractInfo.getNameForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">住所-カナ</td>
								<td><c:out
										value="${sessionScope.contractInfo.getKanaAddressForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">郵便番号</td>
								<td><c:out
										value="${sessionScope.contractInfo.getPostcodeForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">住所-漢字</td>
								<td><c:out
										value="${sessionScope.contractInfo.getKanjiAddressForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">電話番号</td>
								<td><c:out
										value="${sessionScope.contractInfo.getTelephoneNoForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">携帯電話番号</td>
								<td><c:out
										value="${sessionScope.contractInfo.getMobilePhoneNoForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">FAX番号</td>
								<td><c:out
										value="${sessionScope.contractInfo.getFaxNoForLabel()}" /></td>
							</tr>
						</table>
					</div>
					<div id="tabpage2">
						<p class="main_subTitle">解約確認(補償タブ)</p>
						<table class="confirm_table" border="1" style="border-collapse: collapse">
							<tr>
								<td class="confirm_table_headline" colspan="2">契約内容照会確認</td>
							</tr>
							<tr>
								<td class="confirm_table_left">保険料</td>
								<td class="b"><c:out
										value="${requestScope.compensation.getPremiumAmountForLabel()}" />円</td>
							</tr>
							<tr>
								<td class="confirm_table_left">メーカー</td>
								<td><c:out
										value="${requestScope.compensation.getCarName()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">車名</td>
								<td><c:out value="${requestScope.compensation.getMaker()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">車のナンバー</td>
								<td><c:out
										value="${requestScope.compensation.getCarNameForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">車両保険金額</td>
								<td><c:out
										value="${requestScope.compensation.getVehiclePrice()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">免許証の色</td>
								<td><c:out
										value="${requestScope.compensation.getLicenseColorForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">車両料率</td>
								<td><c:out
										value="${requestScope.compensation.getVehicleRatesForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">対人料率</td>
								<td><c:out
										value="${requestScope.compensation.getBodilyRatesForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">対物料率</td>
								<td><c:out
										value="${requestScope.compensation.getPropertyDamageRatesForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">障害料率</td>
								<td><c:out
										value="${requestScope.compensation.getAccidentRatesForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">年齢条件</td>
								<td><c:out
										value="${requestScope.compensation.getAgeLimitForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">１回分保険料</td>
								<td><c:out
										value="${requestScope.compensation.premiumInstallmentForLabel()}" /></td>
							</tr>
						</table>
					</div>
				</div>

			</div>
			<table class="button_table">
				<tr>
					<!-- 入力フォーム（お名前） -->
					<th><button type="button" onclick="toFinishPrintCancelPage();"
							class="button_design">解約申込書印刷</button></th>
				</tr>
			</table>
		</form>

		<script type="text/javascript">
			// 対象の要素を得る
			var tabs = document.getElementById('tabcontrol')
					.getElementsByTagName('a');
			var pages = document.getElementById('tabbody')
					.getElementsByTagName('div');

			function changeTab() {
				// href属性値から対象のid名を抜き出す
				var targetid = this.href.substring(this.href.indexOf('#') + 1,
						this.href.length);

				// 指定のページだけを表示する
				for (var i = 0; i < pages.length; i++) {
					if (pages[i].id != targetid) {
						pages[i].style.display = "none";
					} else {
						pages[i].style.display = "block";
					}
				}

				// クリックされたタブを前面に表示する
				for (var i = 0; i < tabs.length; i++) {
					tabs[i].style.zIndex = "0";
				}
				this.style.zIndex = "10";

				// ページ遷移しないようにfalseを返す
				return false;
			}

			// すべてのタブに対して、クリック時にchangeTab関数が実行されるよう指定する
			for (var i = 0; i < tabs.length; i++) {
				tabs[i].onclick = changeTab;
			}

			// 最初は先頭のタブを選択
			tabs[0].onclick();
		</script>
	</main>
	<footer>
		<div class="footer_title_button">Handy</div>
	</footer>
</body>
</html>