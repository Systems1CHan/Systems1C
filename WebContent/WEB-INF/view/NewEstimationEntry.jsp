<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="TS_Net.model.data.ContractInfo"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>新規試算入力画面</title>
<%-- css(共通) --%>
<link rel="stylesheet" href="./static/css/Button.css">
<link rel="stylesheet" href="./static/css/Layout.css">
<link rel="stylesheet" href="./static/css/Parts.css">
<link rel="stylesheet" href="./static/css/Tab.css">
<link rel="stylesheet" href="./static/css/phone2.css">
<%-- JavaScript用 --%>
<script type="text/javascript" src="./static/js/transition.js"></script>
<script type="text/javascript">
	function entryChange1() {
		//radio = document.getElementsByName('insuredKbn')
		if (radio[0].checked) {
			document.getElementById('個人').style.display = "";
			document.getElementById('法人').style.display = "none";
		} else if (radio[1].checked) {
			document.getElementById('個人').style.display = "none";
			document.getElementById('法人').style.display = "";
		}
	}
	window.onload = entryChange1;
</script>
</head>
<body>
	<header>
		<div class="header_title">契約管理・事故受付システム ハンディー</div>
	</header>
	<main>
		<form action="" method="post" class="radiochange" id="application_frm">
			<button type="button" onclick="toTopMenu();"
				class="button_design_top">トップへ戻る</button>

			<input type="hidden" name="buttonValue" value="">
		<div>
			<p id="tabcontrol" >
				<a href="#tabpage1">契約条件</a> <a href="#tabpage2">補償</a>
			</p>
			<div id="tabbody" class="aa">
				<div id="tabpage1">
					<p class="main_subTitle">新規試算入力（契約条件タブ）</p>
					<table class="form_table_newEstimate">
						<tr>
							<td class=>
	                           <h3>
									被保険者の個人・法人区分<br> <label> <input type="radio"
										name="insuredKbn" value="1" onclick="entryChange1();"
										checked="checked" class="new_top"
										<c:if test="${sessionScope.contractInfo.insuredKbn == '1'}"></c:if>>個人
									</label> <label> <input type="radio" name="insuredKbn"
										value="2" onclick="entryChange1();" class = "new_top"
										<c:if test="${sessionScope.contractInfo.insuredKbn == '2'}"></c:if>>法人
									</label>
								</h3>
							</td>
						</tr>
					</table>

					<table id="個人" class="form_table">
						<tbody>

							<tr>
								<th class="form_table_left" scope="row"><label
									for="inceptionDate">保険期間始期日</label></th>
								<td> <input type="text"
									id="inceptionDate" name="inceptionDate" size="60"
									placeholder="YYYYMMDD"
									value="${sessionScope.contractInfo.inceptionDate}" required class="new_right"></td><td class="error_side" id="Form_">
									<c:if test="${requestScope.checkKozin.get(0) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="inceptionTime">保険期間始期時刻</label></th>
								<td><select
									name="inceptionTime" id="inceptionTime" required>
										<option value="">保険期間始期時刻を選択してください</option>
										<option value="0"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '0'}">selected="selected"</c:if>>午前0時</option>
										<option value="1"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '1'}">selected="selected"</c:if>>午前1時</option>
										<option value="2"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '2'}">selected="selected"</c:if>>午前2時</option>
										<option value="3"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '3'}">selected="selected"</c:if>>午前3時</option>
										<option value="4"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '4'}">selected="selected"</c:if>>午前4時</option>
										<option value="5"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '5'}">selected="selected"</c:if>>午前5時</option>
										<option value="6"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '6'}">selected="selected"</c:if>>午前6時</option>
										<option value="7"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '7'}">selected="selected"</c:if>>午前7時</option>
										<option value="8"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '8'}">selected="selected"</c:if>>午前8時</option>
										<option value="9"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '9'}">selected="selected"</c:if>>午前9時</option>
										<option value="10"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '10'}">selected="selected"</c:if>>午前10時</option>
										<option value="11"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '11'}">selected="selected"</c:if>>午前11時</option>
										<option value="12"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '12'}">selected="selected"</c:if>>正午</option>
										<option value="13"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '13'}">selected="selected"</c:if>>午後1時</option>
										<option value="14"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '14'}">selected="selected"</c:if>>午後2時</option>
										<option value="15"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '15'}">selected="selected"</c:if>>午後3時</option>
										<option value="16"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '16'}">selected="selected"</c:if>>午後4時</option>
										<option value="17"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '17'}">selected="selected"</c:if>>午後5時</option>
										<option value="18"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '18'}">selected="selected"</c:if>>午後6時</option>
										<option value="19"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '19'}">selected="selected"</c:if>>午後7時</option>
										<option value="20"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '20'}">selected="selected"</c:if>>午後8時</option>
										<option value="21"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '21'}">selected="selected"</c:if>>午後9時</option>
										<option value="22"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '22'}">selected="selected"</c:if>>午後10時</option>
										<option value="23"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '23'}">selected="selected"</c:if>>午後11時</option>
								</select></td><td class="error_side" id="Form_"> <c:if test="${requestScope.checkKozin.get(1) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="conclusionDate">保険期間満期日</label></th>
								<td> <input type="text"
									id="conclusionDate" name="conclusionDate" size="60"
									placeholder="YYYYMMDD"
									value="${sessionScope.contractInfo.conclusionDate}" required class="new_right"></td><td class="error_side" id="Form_">
									<c:if test="${requestScope.checkKozin.get(2) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="conclusionTime">保険期間満期時刻</label></th>
								<td><select
									name="conclusionTime" id="conclusionTime" required>
										<option value="">保険期間満期時刻を選択してください</option>
										<option value="0"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '0'}">selected="selected"</c:if>>午前0時</option>
										<option value="1"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '1'}">selected="selected"</c:if>>午前1時</option>
										<option value="2"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '2'}">selected="selected"</c:if>>午前2時</option>
										<option value="3"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '3'}">selected="selected"</c:if>>午前3時</option>
										<option value="4"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '4'}">selected="selected"</c:if>>午前4時</option>
										<option value="5"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '5'}">selected="selected"</c:if>>午前5時</option>
										<option value="6"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '6'}">selected="selected"</c:if>>午前6時</option>
										<option value="7"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '7'}">selected="selected"</c:if>>午前7時</option>
										<option value="8"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '8'}">selected="selected"</c:if>>午前8時</option>
										<option value="9"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '9'}">selected="selected"</c:if>>午前9時</option>
										<option value="10"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '10'}">selected="selected"</c:if>>午前10時</option>
										<option value="11"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '11'}">selected="selected"</c:if>>午前11時</option>
										<option value="12"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '12'}">selected="selected"</c:if>>正午</option>
										<option value="13"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '13'}">selected="selected"</c:if>>午後1時</option>
										<option value="14"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '14'}">selected="selected"</c:if>>午後2時</option>
										<option value="15"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '15'}">selected="selected"</c:if>>午後3時</option>
										<option value="16"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '16'}">selected="selected"</c:if>>午後4時</option>
										<option value="17"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '17'}">selected="selected"</c:if>>午後5時</option>
										<option value="18"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '18'}">selected="selected"</c:if>>午後6時</option>
										<option value="19"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '19'}">selected="selected"</c:if>>午後7時</option>
										<option value="20"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '20'}">selected="selected"</c:if>>午後8時</option>
										<option value="21"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '21'}">selected="selected"</c:if>>午後9時</option>
										<option value="22"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '22'}">selected="selected"</c:if>>午後10時</option>
										<option value="23"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '23'}">selected="selected"</c:if>>午後11時</option>
								</select></td><td class="error_side" id="Form_"> <c:if test="${requestScope.checkKozin.get(3) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="paymentMethod">払込方法</label></th>
								<td> <select
									name="paymentMethod" id="paymentMethod" required>
										<option value="">以下の払込方法から選択してください</option>
										<option value="1"
											<c:if test="${sessionScope.contractInfo.paymentMethod == '1'}">selected="selected"</c:if>>直接集金</option>
										<option value="2"
											<c:if test="${sessionScope.contractInfo.paymentMethod == '2'}">selected="selected"</c:if>>口座振替</option>
										<option value="3"
											<c:if test="${sessionScope.contractInfo.paymentMethod == '3'}">selected="selected"</c:if>>クレジットカード</option>
								</select></td><td class="error_side" id="Form_"> <c:if test="${requestScope.checkKozin.get(4) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="installment">払込回数</label></th>
								<td><select
									name="installment" id="installment" required>
										<option value="">以下の払込回数から選択してください</option>
										<option value="1"
											<c:if test="${sessionScope.contractInfo.installment == '1'}">selected="selected"</c:if>>1</option>
										<option value="2"
											<c:if test="${sessionScope.contractInfo.installment == '2'}">selected="selected"</c:if>>2</option>
										<option value="3"
											<c:if test="${sessionScope.contractInfo.installment == '3'}">selected="selected"</c:if>>3</option>
										<option value="4"
											<c:if test="${sessionScope.contractInfo.installment == '4'}">selected="selected"</c:if>>4</option>
										<option value="6"
											<c:if test="${sessionScope.contractInfo.installment == '6'}">selected="selected"</c:if>>6</option>
										<option value="12"
											<c:if test="${sessionScope.contractInfo.installment == '12'}">selected="selected"</c:if>>12</option>
								</select> </td><td class="error_side" id="Form_"><c:if test="${requestScope.checkKozin.get(5) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="nameKana1">氏名カナ１</label></th>
								<td><input type="text"
									id="nameKana1" name="nameKana1" size="60" placeholder="（例）トウカイ"
									maxlength="48" value="${sessionScope.contractInfo.nameKana1}"
									required class="new_right"></td> <td class="error_side" id="Form_nameKana1"> <c:if
										test="${requestScope.checkKozin.get(6) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if>
									</td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="nameKana2">氏名カナ２</label></th>
								<td><input type="text"
									id="nameKana2" name="nameKana2" size="60" placeholder="（例）タロウ"
									maxlength="48" value="${sessionScope.contractInfo.nameKana2}"
									required class="new_right"></td><td class="error_side" id="Form_nameKana2"> <c:if
										test="${requestScope.checkKozin.get(7) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if>
									</td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="nameKanji1">氏名漢字１</label></th>
								<td><input type="text"
									id="nameKanji1" name="nameKanji1" size="60" placeholder="（例）東海"
									maxlength="48" value="${sessionScope.contractInfo.nameKanji1}"
									required class="new_right"></td><td class="error_side" id="Form_nameKanji1"> <c:if
										test="${requestScope.checkKozin.get(8) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if>
									</td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="nameKanji2">氏名漢字２</label></th>
								<td><input type="text"
									id="nameKanji2" name="nameKanji2" size="60" placeholder="（例）太郎"
									maxlength="48" value="${sessionScope.contractInfo.nameKanji2}"
									required class="new_right"></td><td class="error_side" id="Form_nameKanji2"> <c:if
										test="${requestScope.checkKozin.get(9) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
										</c:if>
								</td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="postcode">郵便番号</label></th>
								<td><input type="text"
									id="postcode" name="postcode" size="60"
									placeholder="（例）1111111" maxlength="7"
									value="${sessionScope.contractInfo.postcode}" required class="new_right"></td><td class="error_side" id="Form_postcode">
									<c:if test="${requestScope.checkKozin.get(10) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if>
									</td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="addressKana1">住所カナ１</label></th>
								<td><input type="text"
									id="addressKana1" name="addressKana1" size="60"
									placeholder="（例）トウキョウトタマシオチアイ" maxlength="48"
									value="${sessionScope.contractInfo.addressKana1}" required class="new_right"></td><td class="error_side" id="Form_addressKana1">
									<c:if test="${requestScope.checkKozin.get(11) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if>
								</td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="addressKana2">住所カナ２</label></th>
								<td><input type="text"
									id="addressKana2" name="addressKana2" size="60"
									placeholder="（例）12-34" maxlength="48"
									value="${sessionScope.contractInfo.addressKana2}" required class="new_right"></td><td class="error_side" id="Form_addressKana2">
									<c:if test="${requestScope.checkKozin.get(12) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if>
									</td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="addressKanji1">住所漢字１</label></th>
								<td><input type="text"
									id="addressKanji1" name="addressKanji1" size="60"
									placeholder="（例）東京都多摩市落合" maxlength="48"
									value="${sessionScope.contractInfo.addressKanji1 }" required class="new_right"></td><td class="error_side" id="Form_addressKanji1">
									<c:if test="${requestScope.checkKozin.get(13) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if>
									</td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="addressKanji2">住所漢字２</label></th>
								<td><input type="text"
									id="addressKanji2" name="addressKanji2" size="60"
									placeholder="（例）12-34" maxlength="48"
									value="${sessionScope.contractInfo.addressKanji2 }" required class="new_right"></td><td class="error_side" id="Form_addressKanji2">
									<c:if test="${requestScope.checkKozin.get(14) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if>
								</td>
							</tr>
   							<tr>
								<th class="form_table_left" scope="row"><label
									for="birthday">生年月日</label></th>
								<td><input type="text"
									id="birthday" name="birthday" size="60"
									placeholder="YYYYMMDD"
									value="${sessionScope.contractInfo.birthday}" required class="new_right"></td><td class="error_side" id="Form_">
									<c:if test="${requestScope.checkKozin.get(15) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if>
								</td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label for="gender">性別</label>
								</th>
								<td><label> <input
										type="radio" id="gender" name="gender" value="1"
										<c:if test="${sessionScope.contractInfo.gender == '1'}">checked="checked"</c:if>>男
										<input type="radio" id="gender" name="gender" value="2"
										<c:if test="${sessionScope.contractInfo.gender == '2'}">checked="checked"</c:if>>女
								</label></td><td class="error_side" id="Form_"> <c:if test="${requestScope.checkKozin.get(16) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="telephoneNo">電話番号</label></th>
								<td><input type="text"
									id="telephoneNo" name="telephoneNo" size="60"
									placeholder="（例）0123456789" maxlength="10"
									value="${sessionScope.contractInfo.telephoneNo }" required class="new_right"></td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="mobilephoneNo">携帯電話番号</label></th>
								<td><input type="text"
									id="mobilephoneNo" name="mobilephoneNo" size="60"
									placeholder="（例）08012345678" maxlength="11"
									value="${sessionScope.contractInfo.mobilephoneNo }" required class="new_right"></td><td class="error_side" id="Form_mobilephoneNo">
									<c:if test="${requestScope.checkKozin.get(17) == 1 }">
										<p><c:out value="番号は1つ以上入力必須です。入力内容をご確認ください。" /></p>
									</c:if>
									</td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label for="faxNo">FAX番号</label>
								</th>
								<td><input type="text"
									id="faxNo" name="faxNo" size="60" placeholder="（例）123456789"
									maxlength="10" value="${sessionScope.contractInfo.faxNo }"
									required class="new_right"></td>
							</tr>
						</tbody>
					</table>

					<table id="法人" class="form_table">
						<tbody>

							<tr>
								<th class="form_table_left" scope="row"><label
									for="inceptionDate">保険期間始期日</label></th>
								<td><input type="text"
									id="inceptionDate" name="inceptionDate" size="60"
									placeholder="YYYYMMDD"  value="${sessionScope.contractInfo.inceptionDate}"
									required class="new_right"></td><td class="error_side" id="Form_"> <c:if
										test="${requestScope.checkHouzin.get(0) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if></td>
							</tr>

							<tr>
								<th class="form_table_left" scope="row"><label
									for="inceptionTime">保険期間始期時刻</label></th>
								<td><select
									name="inceptionTime" id="inceptionTime" required>
										<option value="">保険期間始期時刻を選択してください</option>
										<option value="0"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '0'}">selected="selected"</c:if>>午前0時</option>
										<option value="1"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '1'}">selected="selected"</c:if>>午前1時</option>
										<option value="2"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '2'}">selected="selected"</c:if>>午前2時</option>
										<option value="3"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '3'}">selected="selected"</c:if>>午前3時</option>
										<option value="4"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '4'}">selected="selected"</c:if>>午前4時</option>
										<option value="5"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '5'}">selected="selected"</c:if>>午前5時</option>
										<option value="6"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '6'}">selected="selected"</c:if>>午前6時</option>
										<option value="7"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '7'}">selected="selected"</c:if>>午前7時</option>
										<option value="8"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '8'}">selected="selected"</c:if>>午前8時</option>
										<option value="9"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '9'}">selected="selected"</c:if>>午前9時</option>
										<option value="10"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '10'}">selected="selected"</c:if>>午前10時</option>
										<option value="11"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '11'}">selected="selected"</c:if>>午前11時</option>
										<option value="12"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '12'}">selected="selected"</c:if>>正午</option>
										<option value="13"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '13'}">selected="selected"</c:if>>午後1時</option>
										<option value="14"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '14'}">selected="selected"</c:if>>午後2時</option>
										<option value="15"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '15'}">selected="selected"</c:if>>午後3時</option>
										<option value="16"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '16'}">selected="selected"</c:if>>午後4時</option>
										<option value="17"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '17'}">selected="selected"</c:if>>午後5時</option>
										<option value="18"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '18'}">selected="selected"</c:if>>午後6時</option>
										<option value="19"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '19'}">selected="selected"</c:if>>午後7時</option>
										<option value="20"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '20'}">selected="selected"</c:if>>午後8時</option>
										<option value="21"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '21'}">selected="selected"</c:if>>午後9時</option>
										<option value="22"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '22'}">selected="selected"</c:if>>午後10時</option>
										<option value="23"
											<c:if test="${sessionScope.contractInfo.inceptionTime == '23'}">selected="selected"</c:if>>午後11時</option>
								</select></td><td class="error_side" id="Form_"> <c:if test="${requestScope.checkHouzin.get(1) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="conclusionDate">保険期間満期日</label></th>
								<td><input type="text"
									id="conclusionDate" name="conclusionDate" size="60"
									placeholder="YYYYMMDD"
									value="${sessionScope.contractInfo.conclusionDate}" required class="new_right"></td><td class="error_side" id="Form_"> <c:if
										test="${requestScope.checkHouzin.get(2) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="conclusionTime">保険期間満期時刻</label></th>
								<td><select
									name="conclusionTime" id="conclusionTime" required>
										<option value="">保険期間満期時刻を選択してください</option>
										<option value="0"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '0'}">selected="selected"</c:if>>午前0時</option>
										<option value="1"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '1'}">selected="selected"</c:if>>午前1時</option>
										<option value="2"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '2'}">selected="selected"</c:if>>午前2時</option>
										<option value="3"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '3'}">selected="selected"</c:if>>午前3時</option>
										<option value="4"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '4'}">selected="selected"</c:if>>午前4時</option>
										<option value="5"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '5'}">selected="selected"</c:if>>午前5時</option>
										<option value="6"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '6'}">selected="selected"</c:if>>午前6時</option>
										<option value="7"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '7'}">selected="selected"</c:if>>午前7時</option>
										<option value="8"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '8'}">selected="selected"</c:if>>午前8時</option>
										<option value="9"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '9'}">selected="selected"</c:if>>午前9時</option>
										<option value="10"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '10'}">selected="selected"</c:if>>午前10時</option>
										<option value="11"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '11'}">selected="selected"</c:if>>午前11時</option>
										<option value="12"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '12'}">selected="selected"</c:if>>正午</option>
										<option value="13"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '13'}">selected="selected"</c:if>>午後1時</option>
										<option value="14"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '14'}">selected="selected"</c:if>>午後2時</option>
										<option value="15"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '15'}">selected="selected"</c:if>>午後3時</option>
										<option value="16"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '16'}">selected="selected"</c:if>>午後4時</option>
										<option value="17"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '17'}">selected="selected"</c:if>>午後5時</option>
										<option value="18"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '18'}">selected="selected"</c:if>>午後6時</option>
										<option value="19"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '19'}">selected="selected"</c:if>>午後7時</option>
										<option value="20"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '20'}">selected="selected"</c:if>>午後8時</option>
										<option value="21"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '21'}">selected="selected"</c:if>>午後9時</option>
										<option value="22"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '22'}">selected="selected"</c:if>>午後10時</option>
										<option value="23"
											<c:if test="${sessionScope.contractInfo.conclusionTime == '23'}">selected="selected"</c:if>>午後11時</option>
								</select></td><td class="error_side" id="Form_"> <c:if test="${requestScope.checkHouzin.get(3) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="paymentMethod">払込方法</label></th>
								<td><select
									name="paymentMethod" id="paymentMethod" required>
										<option value="">以下の払込方法から選択してください</option>
										<option value="1"
											<c:if test="${sessionScope.contractInfo.paymentMethod == '1'}">selected="selected"</c:if>>直接集金</option>
										<option value="2"
											<c:if test="${sessionScope.contractInfo.paymentMethod == '2'}">selected="selected"</c:if>>口座振替</option>
										<option value="3"
											<c:if test="${sessionScope.contractInfo.paymentMethod == '3'}">selected="selected"</c:if>>クレジットカード</option>
								</select> </td><td class="error_side" id="Form_"><c:if test="${requestScope.checkHouzin.get(4) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="installment">払込回数</label></th>
								<td><select
									name="installment" id="installment" required>
										<option value="">以下の払込回数から選択してください</option>
										<option value="1"
											<c:if test="${sessionScope.contractInfo.installment == '1'}">selected="selected"</c:if>>1</option>
										<option value="2"
											<c:if test="${sessionScope.contractInfo.installment == '2'}">selected="selected"</c:if>>2</option>
										<option value="3"
											<c:if test="${sessionScope.contractInfo.installment == '3'}">selected="selected"</c:if>>3</option>
										<option value="4"
											<c:if test="${sessionScope.contractInfo.installment == '4'}">selected="selected"</c:if>>4</option>
										<option value="6"
											<c:if test="${sessionScope.contractInfo.installment == '6'}">selected="selected"</c:if>>6</option>
										<option value="12"
											<c:if test="${sessionScope.contractInfo.installment == '12'}">selected="selected"</c:if>>12</option>
								</select></td><td class="error_side" id="Form_"> <c:if test="${requestScope.checkHouzin.get(5) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="nameKana1">会社名カナ１</label></th>
								<td><input type="text"
									id="nameKana1" name="nameKana1" size="60"
									placeholder="（例）タマホケン" maxlength="48"
									value="${sessionScope.contractInfo.nameKana1 }" required class="new_right"></td><td class="error_side" id="Form_"> <c:if
										test="${requestScope.checkHouzin.get(6) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="nameKana2">会社名カナ２</label></th>
								<td><input type="text"
									id="nameKana2" name="nameKana2" size="60"
									placeholder="（例）カブシキガイシャ" maxlength="48"
									value="${sessionScope.contractInfo.nameKana2 }" required class="new_right"></td><td class="error_side" id="Form_"> <c:if
										test="${requestScope.checkHouzin.get(7) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="nameKanji1">会社名漢字１</label></th>
								<td><input type="text"
									id="nameKanji1" name="nameKanji1" size="60"
									placeholder="（例）多摩保険" maxlength="48"
									value="${sessionScope.contractInfo.nameKanji1 }" required class="new_right"></td><td class="error_side" id="Form_"> <c:if
										test="${requestScope.checkHouzin.get(8) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="nameKanji2">会社名漢字２</label></th>
								<td><input type="text"
									id="nameKanji2" name="nameKanji2" size="60"
									placeholder="（例）株式会社" maxlength="48"
									value="${sessionScope.contractInfo.nameKanji2 }" required class="new_right"></td><td class="error_side" id="Form_"> <c:if
										test="${requestScope.checkHouzin.get(9) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="postcode">郵便番号</label></th>
								<td><input type="text"
									id="postcode" name="postcode" size="60"
									placeholder="（例）1111111" maxlength="7"
									value="${sessionScope.contractInfo.postcode }" required class="new_right"></td><td class="error_side" id="Form_postcode"> <c:if
										test="${requestScope.checkHouzin.get(10) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if>
									</td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="addressKana1">住所カナ１</label></th>
								<td><input type="text"
									id="addressKana1" name="addressKana1" size="60"
									placeholder="（例）トウキョウトタマシオチアイ" maxlength="48"
									value="${sessionScope.contractInfo.addressKana1 }" required class="new_right"></td><td class="error_side" id="Form_addressKana1"> <c:if
										test="${requestScope.checkHouzin.get(11) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if>
									</td>

							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="addressKana2">住所カナ２</label></th>
								<td><input type="text"
									id="addressKana2" name="addressKana2" size="60"
									placeholder="（例）12-34" maxlength="48"
									value="${sessionScope.contractInfo.addressKana2 }" required class="new_right"></td><td class="error_side" id="Form_addressKana2"> <c:if
										test="${requestScope.checkHouzin.get(12) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="addressKanji1">住所漢字１</label></th>
								<td><input type="text"
									id="addressKanji1" name="addressKanji1" size="60"
									placeholder="（例）東京都多摩市落合" maxlength="48"
									value="${sessionScope.contractInfo.addressKanji1 }" required class="new_right"></td><td class="error_side" id="Form_addressKanji1"> <c:if
										test="${requestScope.checkHouzin.get(13) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if>
									</td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="addressKanji2">住所漢字２</label></th>
								<td><input type="text"
									id="addressKanji2" name="addressKanji2" size="60"
									placeholder="（例）12-34" maxlength="48"
									value="${sessionScope.contractInfo.addressKanji2 }" required class="new_right"></td><td class="error_side" id="Form_addressKanji2"> <c:if
										test="${requestScope.checkHouzin.get(14) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if>
									</td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="telephoneNo">電話番号</label></th>
								<td><input type="text"
									id="telephoneNo" name="telephoneNo" size="60"
									placeholder="（例）0123456789" maxlength="10"
									value="${sessionScope.contractInfo.telephoneNo }" required class="new_right"></td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="mobilephoneNo">携帯電話番号</label></th>
								<td><input type="text"
									id="mobilephoneNo" name="mobilephoneNo" size="60"
									placeholder="（例）08012345678" maxlength="11"
									value="${sessionScope.contractInfo.mobilephoneNo }" required class="new_right"></td><td class="error_side" id="Form_mobliephoneNo"> <c:if
										test="${requestScope.checkHouzin.get(15) == 1 }">
										<p><c:out value="番号は1つ以上入力必須です。入力内容をご確認ください。" /></p>
									</c:if>
									</td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label for="faxNo">FAX番号</label>
								</th>
								<td><input type="text"
									id="faxNo" name="faxNo" size="60" placeholder="（例）123456789"
									maxlength="10" value="${sessionScope.contractInfo.faxNo }" required class="new_right"></td>
							</tr>
						</tbody>
					</table>
					<table class="button_center_parallel">
						<tr>
							<td>
								<button type="button" class="button_design"
									onclick="toAfterEstimationPage(1);">保険料試算</button>
							</td>
							<td>
								<button type="button" class="button_design"
									onclick="toApplicationConfirmPage();">申込書印刷</button>
							</td>
						</tr>
					</table>

				</div>
				<div id="tabpage2">

					<p class="main_subTitle">新規試算入力（補償タブ）</p>
					<table class="confirm_table" border="1"
						style="border-collapse: collapse">
						<tbody>
							<tr>
								<td class="confirm_table_headline" colspan="2">自動車保険料試算結果</td>
							</tr>
							<tr>
								<td class="confirm_table_left">総額保険料</td>
								<td><fmt:formatNumber value="${sessionScope.compensation.premiumAmount}" />（円）</td>
							</tr>
							<tr>
								<td class="confirm_table_left">一回分保険料</td>
								<td><fmt:formatNumber value="${sessionScope.compensation.premiumInstallment}" />（円）
								</td>
							</tr>
						</tbody>
					</table>
					<table id="secondBox" class="form_table">
						<tbody>
							<tr>
								<th class="form_table_left">メーカー</th>
								<td><select
									name="maker" id="maker" required>
										<option value="">以下のメーカーから選択してください</option>
										<option value="lexus"
											<c:if test="${sessionScope.compensation.maker == 'lexus'}">selected="selected"</c:if>>レクサス</option>
										<option value="matsuda"
											<c:if test="${sessionScope.compensation.maker == 'matsuda'}">selected="selected"</c:if>>マツダ</option>
										<option value="honda"
											<c:if test="${sessionScope.compensation.maker == 'honda'}">selected="selected"</c:if>>ホンダ</option>
										<option value="nissan"
											<c:if test="${sessionScope.compensation.maker == 'nissan'}">selected="selected"</c:if>>ニッサン</option>
										<option value="toyota"
											<c:if test="${sessionScope.compensation.maker == 'toyota'}">selected="selected"</c:if>>トヨタ</option>
										<option value="subaru"
											<c:if test="${sessionScope.compensation.maker == 'subaru'}">selected="selected"</c:if>>スバル</option>
										<option value="suzuki"
											<c:if test="${sessionScope.compensation.maker == 'suzuki'}">selected="selected"</c:if>>スズキ</option>
										<option value="mitsubishi"
											<c:if test="${sessionScope.compensation.maker == 'mitsubishi'}">selected="selected"</c:if>>三菱</option>
								</select> </td><td class="error_side" id="Form_"><c:if test="${requestScope.check2.get(0) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if></td>
							</tr>

							<tr>
								<th class="form_table_left">車名</th>
								<td><select
									name="carName" id="carName">
										<option value="">以下の車名から選択してください</option>
										<option value="LS"
											<c:if test="${sessionScope.compensation.carName == 'LS'}">selected="selected"</c:if>>（レクサス）LS</option>
										<option value="GS"
											<c:if test="${sessionScope.compensation.carName == 'GS'}">selected="selected"</c:if>>（レクサス）GS</option>
										<option value="IS"
											<c:if test="${sessionScope.compensation.carName == 'IS'}">selected="selected"</c:if>>（レクサス）IS</option>
										<option value="デミオ"
											<c:if test="${sessionScope.compensation.carName == 'デミオ'}">selected="selected"</c:if>>（マツダ）デミオ</option>
										<option value="アクセラ"
											<c:if test="${sessionScope.compensation.carName == 'アクセラ'}">selected="selected"</c:if>>（マツダ）アクセラ</option>
										<option value="アテンザ"
											<c:if test="${sessionScope.compensation.carName == 'アテンザ'}">selected="selected"</c:if>>（マツダ）アテンザ</option>
										<option value="インテグラ"
											<c:if test="${sessionScope.compensation.carName == 'インテグラ'}">selected="selected"</c:if>>（ホンダ）インテグラ</option>
										<option value="ステップワゴン"
											<c:if test="${sessionScope.compensation.carName == 'ステップワゴン'}">selected="selected"</c:if>>（ホンダ）ステップワゴン</option>
										<option value="アコードハイブリッド"
											<c:if test="${sessionScope.compensation.carName == 'アコードハイブリッド'}"></c:if>>（ホンダ）アコードハイブリッド</option>
										<option value="フーガ"
											<c:if test="${sessionScope.compensation.carName == 'フーガ'}">selected="selected"</c:if>>（ニッサン）フーガ</option>
										<option value="マーチ"
											<c:if test="${sessionScope.compensation.carName == 'マーチ'}">selected="selected"</c:if>>（ニッサン）マーチ</option>
										<option value="セレナ"
											<c:if test="${sessionScope.compensation.carName == 'セレナ'}">selected="selected"</c:if>>（ニッサン）セレナ</option>
										<option value="スカイライン"
											<c:if test="${sessionScope.compensation.carName == 'スカイライン'}">selected="selected"</c:if>>（ニッサン）スカイライン</option>
										<option value="カローラアクシオ"
											<c:if test="${sessionScope.compensation.carName == 'カローラアクシオ'}">selected="selected"</c:if>>（トヨタ）カローラアクシオ</option>
										<option value="アクア"
											<c:if test="${sessionScope.compensation.carName == 'アクア'}">selected="selected"</c:if>>（トヨタ）アクア</option>
										<option value="クラウン"
											<c:if test="${sessionScope.compensation.carName == 'クラウン'}">selected="selected"</c:if>>（トヨタ）クラウン</option>
										<option value="レガシィ"
											<c:if test="${sessionScope.compensation.carName == 'レガシィ'}">selected="selected"</c:if>>（スバル）レガシィ</option>
										<option value="WRX"
											<c:if test="${sessionScope.compensation.carName == 'WRX'}">selected="selected"</c:if>>（スバル）WRX</option>
										<option value="レヴォーグ"
											<c:if test="${sessionScope.compensation.carName == 'レヴォーグ'}">selected="selected"</c:if>>（スバル）レヴォーグ</option>
										<option value="スイフト"
											<c:if test="${sessionScope.compensation.carName == 'スイフト'}">selected="selected"</c:if>>（スズキ）スイフト</option>
										<option value="キザシ"
											<c:if test="${sessionScope.compensation.carName == 'キザシ'}">selected="selected"</c:if>>（スズキ）キザシ</option>
										<option value="エスクード"
											<c:if test="${sessionScope.compensation.carName == 'エスクード'}">selected="selected"</c:if>>（スズキ）エスクード</option>
										<option value="アウトラウンダーPHEV"
											<c:if test="${sessionScope.compensation.carName == 'アウトラウンダーPHEV'}">selected="selected"</c:if>>（三菱）アウトラウンダーPHEV</option>
										<option value="デリカD:5"
											<c:if test="${sessionScope.compensation.carName == 'デリカD:5'}">selected="selected"</c:if>>（三菱）デリカD:5</option>
								</select> </td><td class="error_side" id="Form_"><c:if test="${requestScope.check2.get(1) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if>
									</td>
							</tr>
							<tr>
								<th class="form_table_left">車両保険金額</th>
								<td><input type="text" name="vehiclePrice"
									id="vehiclePrice"
									value="${sessionScope.compensation.vehiclePrice }" required class="new_right">（万円）</td><td class="error_side" id="Form_">
									<c:if test="${requestScope.check2.get(2) == 1 }">
										<p>入力必須項目です。</p>
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left">料率・車両</th>
								<td><input type="text" name="vehicleRates"
									id="vehicleRates"
									value="${sessionScope.compensation.vehicleRates }" required class="new_right"></td><td class="error_side" id="Form_">
									<c:if test="${requestScope.check2.get(3) == 1 }">
										<p>入力必須項目です。</p>
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left">料率・対人</th>
								<td><input type="text" name="bodilyRates"
									id="bodilyRates"
									value="${sessionScope.compensation.bodilyRates }" required class="new_right"></td><td class="error_side" id="Form_">
									<c:if test="${requestScope.check2.get(4) == 1 }">
										<p>入力必須項目です。</p>
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left">料率・対物</th>
								<td><input type="text" name="propertyDamageRates"
									id="propertyDamageRates"
									value="${sessionScope.compensation.propertyDamageRates }"
									required class="new_right"></td><td class="error_side" id="Form_"> <c:if
										test="${requestScope.check2.get(5) == 1 }">
										<p>入力必須項目です。</p>
									</c:if></td>
							</tr>
							<tr>
								<th class="form_table_left">料率・車両</th>
								<td><input type="text" name="accidentRates"
									id="accidentRates"
									value="${sessionScope.compensation.accidentRates }" required class="new_right"></td><td class="error_side" id="Form_">
									<c:if test="${requestScope.check2.get(6) == 1 }">
										<p>入力必須項目です。</p>
									</c:if></td>
							</tr>
							<script>
								document.getElementById("carName").onchange = function() {
									var carName = document
											.getElementById("carName");
									var vehiclePrice = '';
									var vehicleRates = '';
									var bodilyRates = '';
									var propertyDamageRates = '';
									var accidentRates = '';

									switch (carName.value) {
									case 'manual':
										vehiclePrice = '';
										vehicleRates = '';
										bodilyRates = '';
										propertyDamageRates = '';
										accidentRates = '';
										break;
									case 'LS':
										vehiclePrice = 1090;
										vehicleRates = 5;
										bodilyRates = 5;
										propertyDamageRates = 5;
										accidentRates = 4;
										break;
									case 'GS':
										vehiclePrice = 425;
										vehicleRates = 5;
										bodilyRates = 5;
										propertyDamageRates = 5;
										accidentRates = 4;
										break;
									case 'IS':
										vehiclePrice = 305;
										vehicleRates = 5;
										bodilyRates = 4;
										propertyDamageRates = 4;
										accidentRates = 4;
										break;
									case 'デミオ':
										vehiclePrice = 140;
										vehicleRates = 4;
										bodilyRates = 3;
										propertyDamageRates = 5;
										accidentRates = 4;
										break;
									case 'アクセラ':
										vehiclePrice = 210;
										vehicleRates = 5;
										bodilyRates = 4;
										propertyDamageRates = 5;
										accidentRates = 4;
										break;
									case 'アテンザ':
										vehiclePrice = 300;
										vehicleRates = 5;
										bodilyRates = 4;
										propertyDamageRates = 3;
										accidentRates = 4;
										break;
									case 'インテグラ':
										vehiclePrice = 125;
										vehicleRates = 5;
										bodilyRates = 5;
										propertyDamageRates = 5;
										accidentRates = 5;
										break;
									case 'ステップワゴン':
										vehiclePrice = 340;
										vehicleRates = 4;
										bodilyRates = 4;
										propertyDamageRates = 3;
										accidentRates = 4;
										break;
									case 'アコードハイブリッド':
										vehiclePrice = 400;
										vehicleRates = 5;
										bodilyRates = 4;
										propertyDamageRates = 4;
										accidentRates = 4;
										break;
									case 'フーガ':
										vehiclePrice = 470;
										vehicleRates = 5;
										bodilyRates = 5;
										propertyDamageRates = 5;
										accidentRates = 4;
										break;
									case 'マーチ':
										vehiclePrice = 70;
										vehicleRates = 3;
										bodilyRates = 4;
										propertyDamageRates = 4;
										accidentRates = 4;
										break;
									case 'セレナ':
										vehiclePrice = 145;
										vehicleRates = 4;
										bodilyRates = 4;
										propertyDamageRates = 4;
										accidentRates = 4;
										break;
									case 'スカイライン':
										vehiclePrice = 215;
										vehicleRates = 5;
										bodilyRates = 5;
										propertyDamageRates = 4;
										accidentRates = 4;
										break;
									case 'カローラアクシオ':
										vehiclePrice = 160;
										vehicleRates = 4;
										bodilyRates = 4;
										propertyDamageRates = 4;
										accidentRates = 4;
										break;
									case 'アクア':
										vehiclePrice = 195;
										vehicleRates = 4;
										bodilyRates = 4;
										propertyDamageRates = 4;
										accidentRates = 4;
										break;
									case 'クラウン':
										vehiclePrice = 350;
										vehicleRates = 5;
										bodilyRates = 4;
										propertyDamageRates = 4;
										accidentRates = 4;
										break;
									case 'レガシィ':
										vehiclePrice = 280;
										vehicleRates = 5;
										bodilyRates = 4;
										propertyDamageRates = 4;
										accidentRates = 4;
										break;
									case 'WRX':
										vehiclePrice = 265;
										vehicleRates = 5;
										bodilyRates = 4;
										propertyDamageRates = 4;
										accidentRates = 4;
										break;
									case 'レヴォーグ':
										vehiclePrice = 250;
										vehicleRates = 5;
										bodilyRates = 4;
										propertyDamageRates = 5;
										accidentRates = 4;
										break;
									case 'スイフト':
										vehiclePrice = 145;
										vehicleRates = 4;
										bodilyRates = 4;
										propertyDamageRates = 4;
										accidentRates = 4;
										break;
									case 'キザシ':
										vehiclePrice = 170;
										vehicleRates = 5;
										bodilyRates = 4;
										propertyDamageRates = 4;
										accidentRates = 4;
										break;
									case 'エスクード':
										vehiclePrice = 155;
										vehicleRates = 4;
										bodilyRates = 4;
										propertyDamageRates = 5;
										accidentRates = 4;
										break;
									case 'アウトラウンダーPHEV':
										vehiclePrice = 210;
										vehicleRates = 5;
										bodilyRates = 4;
										propertyDamageRates = 4;
										accidentRates = 4;
										break;
									case 'デリカD:5':
										vehiclePrice = 250;
										vehicleRates = 5;
										bodilyRates = 4;
										propertyDamageRates = 4;
										accidentRates = 4;
										break;
									}

									document.getElementById("vehiclePrice").value = vehiclePrice;
									document.getElementById("vehicleRates").value = vehicleRates;
									document.getElementById("bodilyRates").value = bodilyRates;
									document
											.getElementById("propertyDamageRates").value = propertyDamageRates;
									document.getElementById("accidentRates").value = accidentRates;
								};
							</script>

							<tr>
								<th class="form_table_left" scope="row"><label
									for="licenseNo">車のナンバー</label></th>
								<td><input type="text"
									id="licenseNo" name="licenseNo"
									placeholder="（例）多摩 ま 400 12-34" maxlength="24"
									value="${sessionScope.compensation.licenseNo }" required class="new_right"></td><td class="error_side" id="Form_"> <c:if
										test="${requestScope.check2.get(7) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if>
									</td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="licenseColor">免許証の色</label></th>
								<td><select
									name="licenseColor" id="licenseColor">
										<option value="">以下の免許証の色から選択してください</option>
										<option value="1"
											<c:if test="${sessionScope.compensation.licenseColor == '1'}">selected="selected"</c:if>>ブルー</option>
										<option value="2"
											<c:if test="${sessionScope.compensation.licenseColor == '2'}">selected="selected"</c:if>>グリーン</option>
										<option value="3"
											<c:if test="${sessionScope.compensation.licenseColor == '3'}">selected="selected"</c:if>>ゴールド</option>
								</select></td><td class="error_side" id="Form_">  <c:if test="${requestScope.check2.get(8) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if>
								</td>
							</tr>
							<tr>
								<th class="form_table_left" scope="row"><label
									for="ageLimit">年齢条件</label></th>
								<td><select
									name="ageLimit" id="ageLimit">
										<option value="">以下の年齢条件から選択してください</option>
										<option value="1"
											<c:if test="${sessionScope.compensation.ageLimit == '1'}">selected="selected"</c:if>>無条件</option>
										<option value="2"
											<c:if test="${sessionScope.compensation.ageLimit == '2'}">selected="selected"</c:if>>21歳以上</option>
										<option value="3"
											<c:if test="${sessionScope.compensation.ageLimit == '3'}">selected="selected"</c:if>>26歳以上</option>
								</select> </td><td class="error_side" id="Form_"> <c:if test="${requestScope.check2.get(9) == 1 }">
										<p><c:out value="未入力の項目があります。入力内容をご確認ください。" /></p>
									</c:if></td>
							</tr>
						</tbody>
					</table>
					<table class="button_center_parallel">
						<tr>
							<td>
								<button type="button" class="button_design"
									onclick="toAfterEstimationPage(2);">保険料試算</button>
							</td>
							<td>
								<button type="button" class="button_design"
									onclick="toApplicationConfirmPage();">申込書印刷</button>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		</form>


		<script type="text/javascript">
			// 対象の要素を得る
			var tabs = document.getElementById('tabcontrol').getElementsByTagName('a');
			var pages = document.getElementById('tabbody').getElementsByTagName('div');

			function changeTab() {
				// href属性値から対象のid名を抜き出す
				var targetid = this.href.substring(this.href.indexOf('#') + 1,this.href.length);

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

			var val = <%= (String)request.getAttribute("tabpage") %>

            if (val=="1"){
            	tabs[0].onclick();
            }else if (val=="2"){
            	tabs[1].onclick();
            }else{
            	tabs[0].onclick();
            }

             radio = document.getElementsByName('insuredKbn')
             var val = <%= (String)request.getAttribute("radioButtonValue") %>

             if (val=="1"){
                 radio[0].checked=true;
             }else if (val=="2"){
                  radio[1].checked=true;
             }else{
                 radio[0].checked=true;
             }
		</script>
		<div class="error" id="MESSAGE">
			    <c:out value="${requestScope.message }" />
		</div>
	</main>
	<footer>
		<div class="footer_title">Handy</div>
	</footer>
</body>
</html>