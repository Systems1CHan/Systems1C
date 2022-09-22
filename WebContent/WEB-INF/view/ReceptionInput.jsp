<!-- ---------------------------------------------------------------------------------------
演習番号		：総合演習
プログラム名	：事故受付入力画面
作成日			：2022/09/07
作成者			：SYS KEINA NOGUCHI
--------------------------------------------------------------------------------------------
修正履歴（修正日：担当者：修正内容）
(2022/09/22 ： NarimichiHenmi/SYS ：契約条件タブに保険期間が表示されるように変更)
-------------------------------------------------------------------------------------------->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="TS_Net.model.data.AccidentReception"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<%-- css(共通) --%>
<link rel="stylesheet" href="./static/css/Button.css">
<link rel="stylesheet" href="./static/css/Layout.css">
<link rel="stylesheet" href="./static/css/Parts.css">
<link rel="stylesheet" href="./static/css/Tab.css">
<link rel="stylesheet" href="./static/css/phone.css">
<%-- JavaScript用 --%>
<script type="text/javascript" src="./static/js/transition.js"></script>
</head>
<body>
	<header>
		<div class="header_title">契約管理・事故受付システム ハンディー</div>
	</header>
	<main>
		<form action="" id="update_frm" method="post">
			<table class="button_table">
				<tr>
					<!-- 入力フォーム（お名前） -->
					<th><button type="button" onclick="toTopMenu();"
							class="button_design_top">トップへ戻る</button></th>
				</tr>
			</table>
			<div class="sample-area">
				<p id="tabcontrol">
					<a href="#tabpage1">事故受付</a> <a href="#tabpage2">契約条件</a> <a
						href="#tabpage3">補償</a>
				</p>
				<div id="tabbody">
					<div id="tabpage1">
						<p class="main_subTitle">事故受付入力(事故受付タブ)</p>
						<table class="confirm_table" border="1"
							style="border-collapse: collapse">
							<tr>
								<td class="confirm_table_headline" colspan="2">お客様情報</td>
							</tr>
							<tr>
								<td class="confirm_table_left">事故受付番号</td>
								<td><c:out
										value="${sessionScope.accidentReception.claimNo}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">証券番号</td>
								<td><c:out value="${sessionScope.contractInfo.polNo}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">契約者名</td>
								<td><c:out
										value="${sessionScope.contractInfo.getNameForLabel()}" /></td>
							</tr>
						</table>
						<table class="form_table">
							<tr>
							<%AccidentReception ar = (AccidentReception)session.getAttribute("accidentReception");%>
							<%String value = ar.getAccidentDateForLabel(); %>
							<%value = value.replace("年","-"); %>
							<%value = value.replace("月","-"); %>
							<%value = value.replace("日",""); %>
								<th class="form_table_left">事故日</th>
								<td><input type="date" id="accidentdate"
									name="accidentdate" placeholder="YYYY/MM/DD"
									value="<%=value%>">
								</td>
								<td class="error" id="Form_accidentdate"><c:if
										test="${requestScope.check.get(0) == 1}">
										<td class="error"><c:out
												value="未入力の項目があります。入力内容をご確認ください。" />
										<td />
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left">事故現場住所1-漢字</th>
								<td><input type="text" id="accidentlocationkanji1"
									name="accidentlocationkanji1" placeholder="東京都多摩市"
									maxlength="48"
									value="${sessionScope.accidentReception.getAccidentLocationKanji1()}">
								</td>

								<td class="error" id="Form_accidentlocationkanji1"><c:if
										test="${requestScope.check.get(1) == 1}">
										<td class="error"><c:out
												value="未入力の項目があります。入力内容をご確認ください。" /></td>
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left">事故現場住所1-カナ</th>
								<td><input type="text" id="accidentlocationkana1"
									name="accidentlocationkana1" placeholder="トウキョウトタマシ"
									maxlength="48"
									value="${sessionScope.accidentReception.getAccidentLocationKana1()}">
								</td>
								<td class="error" id="Form_accidentlocationkana1"><c:if
										test="${requestScope.check.get(2) == 1}">
										<td class="error"><c:out
												value="未入力の項目があります。入力内容をご確認ください。" />
										<td />
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left">事故現場住所2-漢字</th>
								<td><input type="text" id="accidentlocationkanji2"
									name="accidentlocationkanji2" placeholder="○○町○○番地"
									maxlength="48"
									value="${sessionScope.accidentReception.getAccidentLocationKanji2()}">
								</td>
								<td class="error" id="Form_accidentlocationkanji2"><c:if
										test="${requestScope.check.get(3) == 1}">
										<td class="error"><c:out
												value="未入力の項目があります。入力内容をご確認ください。" />
										<td />
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left">事故現場住所2-カナ</th>
								<td><input type="text" id="accidentlocationkana2"
									name="accidentlocationkana2" placeholder="○○チョウ○○バンチ"
									maxlength="48"
									value="${sessionScope.accidentReception.getAccidentLocationKana2()}">
								</td>
								<td class="error" id="Form_accidentlocationkana2"><c:if
										test="${requestScope.check.get(4) == 1}">
										<td class="error"><c:out
												value="未入力の項目があります。入力内容をご確認ください。" />
										<td />
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left">相手の状況（被害者側）</th>
								<td><input type="text" placeholder="相手にケガはなし"
									id="accidentsituation" name="accidentsituation" maxlength="48"
									value="${sessionScope.accidentReception.getAccidentSituation()}">
								</td>
								<td class="error" id="Form_accidentsituation"><c:if
										test="${requestScope.check.get(5) == 1}">
										<td class="error"><c:out
												value="未入力の項目があります。入力内容をご確認ください。" />
										<td />
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left">過失割合（被保険者方）</th>
								<td><input type="text" placeholder="20"
									id="ratingblamemyself" name="ratingblamemyself" maxlength="48"
									value="${sessionScope.accidentReception.getRatingBlameMyself()}">
								</td>
								<td class="error" id="Form_ratingblamemyself"><c:if
										test="${requestScope.check.get(6) == 1}">
										<td class="error"><c:out
												value="未入力の項目があります。入力内容をご確認ください。" />
										<td />
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left">過失割合（相手方）</th>
								<td><input type="text" placeholder="80"
									id="ratingblameyourself" name="ratingblameyourself"
									maxlength="48"
									value="${sessionScope.accidentReception.getRatingBlameYourself()}">
								</td>
								<td class="error" id="Form_ratingblameyourself"><c:if
										test="${requestScope.check.get(7) == 1}">
										<td class="error"><c:out
												value="未入力の項目があります。入力内容をご確認ください。" />
										<td />
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left">損害額・車両</th>
								<td><input type="text" placeholder="A0000001"
									id="damagecarprice" name="damagecarprice" maxlength="48"
									value="${sessionScope.accidentReception.getDamageCarPrice()}">(円)
								</td>
								<td class="error" id="Form_damagecarprice"><c:if
										test="${requestScope.check.get(8) == 1}">
										<td class="error"><c:out
												value="未入力の項目があります。入力内容をご確認ください。" />
										<td />
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left">損害状況・車両</th>
								<td><input type="text" placeholder="一部あり"
									id="damagecarstate" name="damagecarstate" maxlength="48"
									value="${sessionScope.accidentReception.getDamageCarState()}">
								</td>
								<td class="error" id="Form_damagecarstate"><c:if
										test="${requestScope.check.get(9) == 1}">
										<td class="error"><c:out
												value="未入力の項目があります。入力内容をご確認ください。" />
										<td />
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left">損害額・対人</th>
								<td><input type="text" placeholder="A0000001"
									id="damagebodilyprice" name="damagebodilyprice" maxlength="48"
									value="${sessionScope.accidentReception.getDamageBodilyPrice()}">(円)
								</td>
								<td class="error" id="Form_damagebodilyprice"><c:if
										test="${requestScope.check.get(10) == 1}">
										<td class="error"><c:out
												value="未入力の項目があります。入力内容をご確認ください。" />
										<td />
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left">損害状況・対人</th>
								<td><input type="text" placeholder="なし"
									id="damagebodilystate" name="damagebodilystate" maxlength="48"
									value="${sessionScope.accidentReception.getDamageBodilyState()}">
								</td>
								<td class="error" id="Form_damagebodilystate"><c:if
										test="${requestScope.check.get(11) == 1}">
										<td class="error"><c:out
												value="未入力の項目があります。入力内容をご確認ください。" />
										<td />
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left">損害額・対物</th>
								<td><input type="text" placeholder="A0000001"
									id="damagepropertyprice" name="damagepropertyprice"
									maxlength="48"
									value="${sessionScope.accidentReception.getDamagePropertyPrice()}">(円)
								</td>
								<td class="error" id="Form_damagepropertyprice"><c:if
										test="${requestScope.check.get(12) == 1}">
										<td class="error"><c:out
												value="未入力の項目があります。入力内容をご確認ください。" />
										<td />
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left">損害状況・対物</th>
								<td><input type="text" placeholder="あり"
									id="damagepropertystate" name="damagepropertystate"
									maxlength="48"
									value="${sessionScope.accidentReception.getDamagePropertyState()}">
								</td>
								<td class="error" id="Form_damagepropertystate"><c:if
										test="${requestScope.check.get(13) == 1}">
										<td class="error"><c:out
												value="未入力の項目があります。入力内容をご確認ください。" />
										<td />
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left">損害額・傷害</th>
								<td><input type="text" placeholder="4000円"
									id="damageaccidentprice" name="damageaccidentprice"
									maxlength="48"
									value="${sessionScope.accidentReception.getDamageAccidentPrice()}">(円)
								</td>
								<td class="error" id="Form_damageaccidentprice"><c:if
										test="${requestScope.check.get(14) == 1}">
										<td class="error"><c:out
												value="未入力の項目があります。入力内容をご確認ください。" />
										<td />
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left">損害状況・傷害</th>
								<td><input type="text" placeholder="左脚捻挫"
									id="damageaccidentstate" name="damageaccidentstate"
									maxlength="48"
									value="${sessionScope.accidentReception.getDamageAccidentState()}">
								</td>
								<td class="error" id="Form_damageaccidentstate"><c:if
										test="${requestScope.check.get(15) == 1}">
										<td class="error"><c:out
												value="未入力の項目があります。入力内容をご確認ください。" />
										<td />
									</c:if></td>
							</tr>
						</table>
						<!-- エラーメッセージ -->
						<p class="error" id="FORM_ERROR">
							<c:out value="${requestScope.FORM_ERROR }" />
						</p>
						<table class="button_center_parallel">
							<tr>
								<!-- 入力フォーム（お名前） -->
								<td>
									<button type="button" onclick="toFinishUpdatePage()"
										class="button_design">状況更新</button>
								</td>
								<td>
									<button type="button" onclick="toFinishAcceptPage()"
										class="button_design">受付完了</button>
								</td>
						</table>
					</div>
					<div id="tabpage2">
						<p class="main_subTitle">事故受付入力(契約条件タブ)</p>
						<table class="confirm_table" border="1"
							style="border-collapse: collapse">
							<tr>
								<td class="confirm_table_headline" colspan="2">事故受付入力</td>
							</tr>
							<tr>
								<td class="confirm_table_left">保険期間</td>
								<td class="b"><c:out
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
								<td class="confirm_table_left">氏名-カナ</td>
								<td><c:out
										value="${sessionScope.contractInfo.getkanaNameForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">性別</td>
								<td><c:out
										value="${sessionScope.contractInfo.getGenderForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">氏名-漢字</td>
								<td><c:out
										value="${sessionScope.contractInfo.getNameForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">生年月日</td>
								<td><c:out
										value="${sessionScope.contractInfo.getBirthdayForLabel()}" /></td>
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
						<table class="button_center_parallel">
							<tr>
								<!-- 入力フォーム（お名前） -->
								<td>
									<button type="button" onclick="toFinishUpdatePage()"
										class="button_design">更新完了</button>
								</td>
								<td>
									<button type="button" onclick="toFinishAcceptPage()"
										class="button_design">受付完了</button>
								</td>
						</table>
					</div>
					<div id="tabpage3">
						<p class="main_subTitle">事故受付入力(補償タブ)</p>
						<table class="confirm_table" border="1"
							style="border-collapse: collapse">
							<tr>
								<td class="confirm_table_headline" colspan="3">事故受付入力</td>
							</tr>
							<tr>
								<td class="confirm_table_left">保険料</td>
								<td><c:out
										value="${sessionScope.compensation.premiumAmountForLabel2()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">メーカー</td>
								<td><c:out value="${sessionScope.compensation.getMaker()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">車名</td>
								<td><c:out
										value="${sessionScope.compensation.getCarName()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">車のナンバー</td>
								<td><c:out
										value="${sessionScope.compensation.getCarNameForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">車両保険金額</td>
								<td><c:out
										value="${sessionScope.compensation.vehiclePriceForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">免許証の色</td>
								<td><c:out
										value="${sessionScope.compensation.getLicenseColorForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">車両料率</td>
								<td><c:out
										value="${sessionScope.compensation.getVehicleRatesForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">対人料率</td>
								<td><c:out
										value="${sessionScope.compensation.getBodilyRatesForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">対物料率</td>
								<td><c:out
										value="${sessionScope.compensation.getPropertyDamageRatesForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">障害料率</td>
								<td><c:out
										value="${sessionScope.compensation.getAccidentRatesForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">年齢条件</td>
								<td><c:out
										value="${sessionScope.compensation.getAgeLimitForLabel()}" /></td>
							</tr>
							<tr>
								<td class="confirm_table_left">１回分保険料</td>
								<td><c:out
										value="${sessionScope.compensation.premiumInstallmentForLabel()}" /></td>
							</tr>
						</table>
						<table class="button_center_parallel">
							<tr>
								<!-- 入力フォーム（お名前） -->
								<td>
									<button type="button" onclick="toFinishUpdatePage()"
										class="button_design">更新完了</button>
								</td>
								<td>
									<button type="button" onclick="toFinishAcceptPage()"
										class="button_design">受付完了</button>
								</td>
						</table>
					</div>
				</div>
			</div>

			<button type="button" onclick="toreturnReceptionPage()"
				class="button_design">前の画面へ戻る</button>
		</form>
		<script type="text/javascript">
			// 対象の要素を得る
			var tabs = document.getElementById('tabcontrol')
					.getElementsByTagName('a');
			var pages = document.getElementById('tabbody')
					.getElementsByTagName('div');

			function changeTab() {
				// ▼href属性値から対象のid名を抜き出す
				var targetid = this.href.substring(this.href.indexOf('#') + 1,
						this.href.length);

				// ▼指定のページだけを表示する
				for (var i = 0; i < pages.length; i++) {
					if (pages[i].id != targetid) {
						pages[i].style.display = "none";
					} else {
						pages[i].style.display = "block";
					}
				}

				// ▼クリックされたタブを前面に表示する
				for (var i = 0; i < tabs.length; i++) {
					tabs[i].style.zIndex = "0";
				}
				this.style.zIndex = "10";

				// ▼ページ遷移しないようにfalseを返す
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