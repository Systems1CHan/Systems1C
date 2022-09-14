<!-- ---------------------------------------------------------------------------------------
演習番号		：総合演習
プログラム名	：事故受付入力画面
作成日			：2022/09/07
作成者			：SYS KEINA NOGUCHI
--------------------------------------------------------------------------------------------
修正履歴（修正日：担当者：修正内容）
-------------------------------------------------------------------------------------------->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

            /* タブ領域全体 */
            #tabcontrol {
                margin: 0;
            }

            /* タブ */
            #tabcontrol a {
                display: inline-block; /* インラインブロック化 */
                border-width: 1px 1px 0px 1px; /* 下以外の枠線を引く */
                border-style: solid; /* 枠線の種類：実線 */
                border-color: black; /* 枠線の色：黒色 */
                border-radius: 0.75em 0.75em 0px 0px; /* 枠線の左上角と右上角だけを丸く */
                padding: 0.75em 1em; /* 内側の余白 */
                text-decoration: none; /* リンクの下線を消す */
                color: black; /* 文字色：黒色 */
                background-color: white; /* 背景色：白色 */
                font-weight: bold; /* 太字 */
                position: relative; /* JavaScriptでz-indexを調整するために必要 */
            }

            /* タブにマウスポインタが載った際（任意） */
            #tabcontrol a:hover {
                text-decoration: underline; /* リンクの下線を引く */
            }

            /* タブの中身 */
            #tabbody div {
                border: 1px solid black; /* 黒色の実線を1pxの太さで引く */
                margin-top: -1px; /* 上側にあるタブと1pxだけ重ねるために「-1px」を指定 */
                padding: 1em; /* 内側の余白 */
                background-color: white; /* 背景色：白色 */
                position: relative; /* z-indexを調整するために必要 */
                z-index: 0; /* 重なり順序を「最も背面」にするため */
                min-height: 5em; /* 最低の高さが必要なら指定(不要なら省略可) */
            }

            /* タブの配色 */
            #tabcontrol a:nth-child(1), #tabbody div:nth-child(1) {
                background-color: #ffffdd;
            } /* 1つ目のタブとその中身用の配色 */
            #tabcontrol a:nth-child(2), #tabbody div:nth-child(2) {
                background-color: #ddffdd;
            } /* 2つ目のタブとその中身用の配色 */
            #tabcontrol a:nth-child(3), #tabbody div:nth-child(3) {
            background-color: #ddffdd;
            } /* 3つ目のタブとその中身用の配色 */
            </style>
             <script type="text/javascript">
                        function entryChange1(){
                            radio = document.getElementsByName('insuredKbn')
                            if(radio[0].checked) {
                                document.getElementById('個人').style.display = "";
                                document.getElementById('法人').style.display = "none";
                            }else if(radio[1].checked) {
                                document.getElementById('個人').style.display = "none";
                                document.getElementById('法人').style.display = "";
                            }
                        }
                        window.onload = entryChange1;
                    </script>
            <script type="text/javascript" src="./static/js/transition.js"></script>
            </head>
            <body>
                <header>
                    <table>
                        <tr>
                            <td>
                                <h1>契約管理・事故受付システム ハンディー</h1>
                            </td>
                        </tr>
                    </table>
                </header>
                <main>
                    <form action="" id="update_frm" method="post">
                        <table class="button_table">
                            <tr>
                                <!-- 入力フォーム（お名前） -->
                                <th><button type="button"
                                        class="button_design">トップへ戻る</button></th>
                            </tr>
                        </table>
                    <div class="sample-area">
                        <p id="tabcontrol">
                            <a href="#tabpage1">事故受付</a>
                            <a href="#tabpage2">契約条件</a>
                            <a href="#tabpage3">補償</a>
                        </p>
                        <div id="tabbody">
                            <div id="tabpage1">
                                <table border="1" width="80%">
                                    <tr>
                                        <td colspan="2">お客様情報</td>
                                    </tr>
                                    <tr>
                                        <td>事故受付番号</td>
                                        <td>11111</td>
                                    </tr>
                                    <tr>
                                        <td>証券番号</td>
                                        <td><c:out value="${sessionScope.contractInfo.polNo}"/></td>
                                    </tr>
                                    <tr>
                                        <td>契約者名</td>
                                        <td><c:out value="${sessionScope.contractInfo.getNameForLabel()}"/></td>
                                    </tr>
                                </table>
                                <table>
                                    <tr>
                                        <th>
                                            事故日
                                        </th>
                                        <td>
                                            <input type="date" name = "accidentdate" size="60" placeholder="YYYY/MM/DD" value="${sessionScope.accidentUpdateReception.getAccidentDateForLabel()}">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                            事故現場住所1-漢字
                                        </th>
                                        <td>
                                            <input type="text" placeholder="東京都多摩市"value="${sessionScope.accidentUpdateReception.getAccidentLocationKanji1()}" >
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                            事故現場住所1-カナ
                                        </th>
                                        <td>
                                            <input type="text" placeholder="トウキョウトタマシ" value="${sessionScope.accidentUpdateReception.getAccidentLocationKana1()}" >
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                            事故現場住所2-漢字
                                        </th>
                                        <td>
                                            <input type="text" placeholder="○○町○○番地" value="${sessionScope.accidentUpdateReception.getAccidentLocationKanji2()}">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                            事故現場住所2-カナ
                                        </th>
                                        <td>
                                            <input type="text" placeholder="○○チョウ○○バンチ" value="${sessionScope.accidentUpdateReception.getAccidentLocationKana1()}">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                            相手の状況（被害者側）
                                        </th>
                                        <td>
                                            <input type="text" placeholder="相手にケガはなし">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                            過失割合（非保険者方）
                                        </th>
                                        <td>
                                            <input type="text" placeholder="20" value="${sessionScope.accidentUpdateReception.getRatingBlameMyself()}">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                            過失割合（相手方）
                                        </th>
                                        <td>
                                            <input type="text" placeholder="80" value="${sessionScope.accidentUpdateReception.getRatingBlameYourself()}">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                            損害額・車両
                                        </th>
                                        <td>
                                            <input type="text" placeholder="A0000001" value="${sessionScope.accidentUpdateReception.getDamageCarPriceForLabel()}">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                            損害状況・車両
                                        </th>
                                        <td>
                                            <input type="text" placeholder="一部あり">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                            損害額・対人
                                        </th>
                                        <td>
                                            <input type="text" placeholder="A0000001">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                            損害状況・対人
                                        </th>
                                        <td>
                                            <input type="text" placeholder="なし">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                            損害額・対物
                                        </th>
                                        <td>
                                            <input type="text" placeholder="A0000001">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                            損害状況・対物
                                        </th>
                                        <td>
                                            <input type="text" placeholder="あり">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                            損害額・傷害
                                        </th>
                                        <td>
                                            <input type="text" placeholder="A0000001">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th>
                                            損害状況・傷害
                                        </th>
                                        <td>
                                            <input type="text" placeholder="なし">
                                        </td>
                                    </tr>
                                </table>
                            </div>
                            <div id="tabpage2">
                                <table border="1" style="border-collapse: collapse">
                                    <tr>
                                        <td colspan="2">事故受付入力</td>
                                    </tr>
 <tr>
   								 <td>証券番号</td><td><c:out value="${sessionScope.contractInfo.polNo}"/></td>
  							</tr>
  							 <tr>
   								 <td>印刷連番</td><td><c:out value="${sessionScope.contractInfo.insatsuRenban}"/></td>
  							</tr>
  							 <tr>
   								 <td>契約状態</td><td><c:out value="${sessionScope.contractInfo.getStatusFlgForLabel()}"/></td>
  							</tr>
  							 <tr>
   								 <td>被保険者の個人法人区分</td><td><c:out value="${sessionScope.contractInfo.getInsuredKbnForLabel()}"/></td>
  							</tr>
  							 <tr>
   								 <td>払込方法</td><td><c:out value="${sessionScope.contractInfo.getPaymentMethodForLabel()}"/></td>
  							</tr>
  							 <tr>
   								 <td>氏名-カナ</td><td><c:out value="${sessionScope.contractInfo.getkanaNameForLabel()}"/></td>
  							</tr>
  							 <tr>
   								 <td>性別</td><td><c:out value="${sessionScope.contractInfo.getGenderForLabel()}"/></td>
  							</tr>
  							 <tr>
   								 <td>氏名-漢字</td><td><c:out value="${sessionScope.contractInfo.getNameForLabel()}"/></td>
  							</tr>
  							 <tr>
   								 <td>生年月日</td><td><c:out value="${sessionScope.contractInfo.getBirthdayForLabel()}"/></td>
  							</tr>
  							 <tr>
   								 <td>住所-カナ</td><td><c:out value="${sessionScope.contractInfo.getKanaAddressForLabel()}"/></td>
  							</tr>
  							 <tr>
   								 <td>郵便番号</td><td><c:out value="${sessionScope.contractInfo.getPostcodeForLabel()}"/></td>
  							</tr>
  							 <tr>
   								 <td>住所-漢字</td><td><c:out value="${sessionScope.contractInfo.getKanjiAddressForLabel()}"/></td>
  							</tr>
  							 <tr>
   								 <td>電話番号</td><td><c:out value="${sessionScope.contractInfo.getTelephoneNoForLabel()}"/></td>
  							</tr>
  							 <tr>
   								 <td>携帯電話番号</td><td><c:out value="${sessionScope.contractInfo.getMobilePhoneNoForLabel()}"/></td>
  							</tr>
  							 <tr>
   								 <td>FAX番号</td><td><c:out value="${sessionScope.contractInfo.getFaxNoForLabel()}"/></td>
  							</tr>
  						</table>
                            </div>
                            <div id="tabpage3">
                                <table border="1" style="border-collapse: collapse">
                                    <tr>
                                        <td colspan="3">事故受付入力</td>
                                    </tr>
                                    <tr>
   								 <td>保険料</td><td><c:out value="${sessionScope.compensation.getPremiumAmountForLabel()}"/></td>
  							 </tr>
 							 <tr>
   								 <td>メーカー</td><td><c:out value="${sessionScope.compensation.getCarName()}"/></td>
  							 </tr>
  							 <tr>
   								 <td>車名</td><td><c:out value="${sessionScope.compensation.getCarName()}"/></td>
  							 </tr>
  							 <tr>
   								 <td>車のナンバー</td><td><c:out value="${sessionScope.compensation.getCarNameForLabel()}"/></td>
  							 </tr>
  							 <tr>
   								 <td>車両保険金額</td><td><c:out value="${sessionScope.compensation.getVehiclePrice()}"/></td>
  							 </tr>
  							 <tr>
   								 <td>免許証の色</td><td><c:out value="${sessionScope.compensation.getLicenseColorForLabel()}"/></td>
  							 </tr>
  							 <tr>
   								 <td>車両料率</td><td><c:out value="${sessionScope.compensation.getVehicleRatesForLabel()}"/></td>
  							 </tr>
  							 <tr>
   								 <td>対人料率</td><td><c:out value="${sessionScope.compensation.getBodilyRatesForLabel()}"/></td>
  							 </tr>
  							 <tr>
   								 <td>対物料率</td><td><c:out value="${sessionScope.compensation.getPropertyDamageRatesForLabel()}"/></td>
  							 </tr>
  							 <tr>
   								 <td>障害料率</td><td><c:out value="${sessionScope.compensation.getAccidentRatesForLabel()}"/></td>
  							 </tr>
  							 <tr>
   								 <td>年齢条件</td><td><c:out value="${sessionScope.compensation.getAgeLimitForLabel()}"/></td>
  							 </tr>
  							 <tr>
   								 <td>１回分保険料</td><td><c:out value="${sessionScope.compensation.getPremiumInstallment()}"/></td>
  							</tr>
                                </table>
                            </div>
                        </div>
                    </div>
                    <table class="button_table">
                        <tr>
                            <!-- 入力フォーム（お名前） -->
                            <td>
                                <button type="button" onclick="toFinishAcceptPage();" class="button_design">更新完了</button>
                            </td>
                            <td>
                                <button type="button" onclick="toFinishAcceptPage();" class="button_design">事故受付完了</button>
                            </td>
                            <td>
                                <button type="button" class="button_design">前の画面へ戻る</button>
                            </td>
                        </tr>
                    </table>
                    </form>
                    <script type="text/javascript">
		<div class="sample-area">
			<p id="tabcontrol">
				<a href="#tabpage1">事故受付</a> <a href="#tabpage2">契約条件</a> <a
					href="#tabpage3">補償</a>
			</p>
			<div id="tabbody">
				<div id="tabpage1">
					<table border="1" width="80%">
						<tr>
							<td colspan="2">お客様情報</td>
						</tr>
						<tr>
							<td>事故受付番号</td>
							<td>11111</td>
						</tr>
						<tr>
							<td>証券番号</td>
							<td>11111</td>
						</tr>
						<tr>
							<td>契約者名</td>
							<td>東海 太郎</td>
						</tr>
					</table>
					<table>
						<tr>
							<th scope="row"><label for="accidentDate">事故日</label></th>
							<td><span class="form-require">必須</span> <input type="date"
								id="accidentDate" name="accidentDate" size="60"
								placeholder="YYYY/MM/DD" required></td>
							<!-- エラーメッセージ -->
								<c:out value="${requestScope.FORM_ERROR }" />
						</tr>
						<tr>
							<th scope="row"><label for="accidentLocationKanji1">事故現場住所1-漢字</label>
							</th>
							<td><span class="form-require">必須</span> <input type="text"
								id="accidentLocationKanji1" name="accidentLocationKanji1"
								size="60" placeholder="（例）東京都多摩市" required></td>

								<!-- エラーメッセージ -->
									<c:out value="${requestScope.FORM_ERROR }" />
						</tr>
						<tr>
							<th scope="row"><label for="accidentLocationKana1">事故現場住所1-カナ</label>
							</th>
							<td><span class="form-require">必須</span> <input type="text"
								id="accidentLocationKana1" name="accidentLocationKana1"
								size="60" placeholder="（例）トウキョウトタマシ" required></td>
						</tr>
						<tr>
							<th scope="row"><label for="accidentLocationKanji2">事故現場住所2-漢字</label>
							</th>
							<td><span class="form-require">必須</span> <input type="text"
								id="accidentLocationKanji2" name="accidentLocationKanji2"
								size="60" placeholder="（例）○○町○○番地" required></td>
						</tr>
						<tr>
							<th scope="row"><label for="accidentLocationKana2">事故現場住所2-カナ</label>
							</th>
							<td><span class="form-require">必須</span> <input type="text"
								id="accidentLocationKana2" name="accidentLocationKana2"
								size="60" placeholder="（例）○○チョウ○○バンチ" required></td>
						</tr>
						<tr>
							<th scope="row"><label for="ratingBlameMyself">過失割合（被保険者）</label>
							</th>
							<td><span class="form-require">必須</span> <input type="text"
								id="ratingBlameMyself" name="ratingBlameMyself"
								size="60" placeholder="（例）2割" required></td>
						</tr>
						<tr>
							<th scope="row"><label for="ratingBlameYourself">過失割合（相手方）</label>
							</th>
							<td><span class="form-require">必須</span> <input type="text"
								id="ratingBlameYourself" name="ratingBlameYourself" size="60"
								placeholder="（例）8割" required></td>
						</tr>
						<tr>
							<th scope="row"><label for="damageCarPrice">損害額・車両</label></th>
							<td><span class="form-require">必須</span> <input type="text"
								id="damageCarPrice" name="damageCarPrice" size="60"
								placeholder="（例）100000" required></td>
						</tr>
						<tr>
							<th scope="row"><label for="damageCarState">損害状況・車両</label>
							</th>
							<td><span class="form-require">必須</span> <input type="text"
								id="damageCarState" name="damageCarState" size="60"
								placeholder="（例）一部あり" required></td>
						</tr>
						<tr>
							<th scope="row"><label for="damageBodilyPrice">損害額・対人</label>
							</th>
							<td><span class="form-require">必須</span> <input type="text"
								id="damageBodilyPrice" name="damageBodilyPrice" size="60"
								placeholder="（例）0" required></td>
						</tr>
						<tr>
							<th scope="row"><label for="damageBodilyState">損害状況・対人</label>
							</th>
							<td><span class="form-require">必須</span> <input type="text"
								id="damageBodilyState" name="damageBodilyState" size="60"
								placeholder="（例）なし" required></td>
						</tr>
						<tr>
							<th scope="row"><label for="damagePropertyPrice">損害額・対物</label>
							</th>
							<td><span class="form-require">必須</span> <input type="text"
								id="damagePropertyPrice" name="damagePropertyPrice" size="60"
								placeholder="（例）0" required></td>
						</tr>
						<tr>
							<th scope="row"><label for="damagePropertyState">損害状況・対物</label>
							</th>
							<td><span class="form-require">必須</span> <input type="text"
								id="damagePropertyState" name="damagePropertyState" size="60"
								placeholder="（例）なし" required></td>
						</tr>
						<tr>
							<th scope="row"><label for="damageAccidentPrice">損害額・傷害</label>
							</th>
							<td><span class="form-require">必須</span> <input type="text"
								id="damageAccidentPrice" name="damageAccidentPrice" size="60"
								placeholder="（例）0" required></td>
						</tr>
						<tr>
							<th scope="row"><label for="damageAccidentState">損害状況・傷害</label>
							</th>
							<td><span class="form-require">必須</span> <input type="text"
								id="damageAccidentState" name="damageAccidentState" size="60"
								placeholder="（例）なし" required></td>
						</tr>
						<table>
							<tr>
								<td>
									<button type="button" onclick="ToUpdateForm();" class="btn">更新完了</button>
								</td>
								<td>
									<button type="button" onclick="ToReceptionForm();" class="btn">事故受付完了</button>
								</td>
							</tr>
						</table>
					</table>
				</div>
				<div id="tabpage2">
					<table border="1" style="border-collapse: collapse">
						<tr>
							<td colspan="2">事故受付入力</td>
						</tr>
						<tr>
							<td>保険期間</td>
							<td><c:out
									value="${requestScope.contractInfo.getInsureanceIntervalForLabel()}" /></td>
						</tr>
						<tr>
							<td>証券番号</td>
							<td><c:out value="${requestScope.contractInfo.polNo}" /></td>
						</tr>
						<tr>
							<td>印刷連番</td>
							<td><c:out
									value="${requestScope.contractInfo.insatsuRenban}" /></td>
						</tr>
						<tr>
							<td>契約状態</td>
							<td><c:out
									value="${requestScope.contractInfo.getStatusFlgForLabel()}" /></td>
						</tr>
						<tr>
							<td>被保険者の個人法人区分</td>
							<td><c:out
									value="${requestScope.contractInfo.getInsuredKbnForLabel()}" /></td>
						</tr>
						<tr>
							<td>払込方法</td>
							<td><c:out
									value="${requestScope.contractInfo.getPaymentMethodForLabel()}" /></td>
						</tr>
						<tr>
							<td>会社名-カナ</td>
							<td><c:out
									value="${requestScope.contractInfo.getkanaNameForLabel()}" /></td>
						</tr>
						<tr>
							<td>会社名-漢字</td>
							<td><c:out
									value="${requestScope.contractInfo.getNameForLabel()}" /></td>
						</tr>
						<tr>
							<td>住所-カナ</td>
							<td><c:out
									value="${requestScope.contractInfo.getKanaAddressForLabel()}" /></td>
						</tr>
						<tr>
							<td>郵便番号</td>
							<td><c:out
									value="${requestScope.contractInfo.getPostcodeForLabel()}" /></td>
						</tr>
						<tr>
							<td>住所-漢字</td>
							<td><c:out
									value="${requestScope.contractInfo.getKanjiAddressForLabel()}" /></td>
						</tr>
						<tr>
							<td>電話番号</td>
							<td><c:out
									value="${requestScope.contractInfo.getTelephoneNoForLabel()}" /></td>
						</tr>
						<tr>
							<td>携帯電話番号</td>
							<td><c:out
									value="${requestScope.contractInfo.getMobilePhoneNoForLabel()}" /></td>
						</tr>
						<tr>
							<td>FAX番号</td>
							<td><c:out
									value="${requestScope.contractInfo.getFaxNoForLabel()}" /></td>
						</tr>
						<table>
							<tr>
								<td>
									<button type="button" onclick="ToUpdateForm();" class="btn">更新完了</button>
								</td>
								<td>
									<button type="button" onclick="ToReceptionForm();" class="btn">事故受付完了</button>
								</td>
							</tr>
						</table>
					</table>
				</div>

				<div id="tabpage3">
					<table border="1" style="border-collapse: collapse">
						<tr>
							<td colspan="3">自動車保険料試算結果</td>
						</tr>
						<tr>
							<td>保険料</td>
							<td><c:out
									value="${requestScope.compensation.getPremiumAmountForLabel()}" /></td>
						</tr>
						<tr>
							<td>メーカー</td>
							<td><c:out value="${requestScope.compensation.getCarName()}" /></td>
						</tr>
						<tr>
							<td>車名</td>
							<td><c:out value="${requestScope.compensation.getCarName()}" /></td>
						</tr>
						<tr>
							<td>車のナンバー</td>
							<td><c:out
									value="${requestScope.compensation.getCarNameForLabel()}" /></td>
						</tr>
						<tr>
							<td>車両保険金額</td>
							<td><c:out
									value="${requestScope.compensation.getPremiumAmountForLabel()}" /></td>
						</tr>
						<tr>
							<td>免許証の色</td>
							<td><c:out
									value="${requestScope.compensation.getPremiumAmountForLabel()}" /></td>
						</tr>
						<tr>
							<td>車両料率</td>
							<td><c:out
									value="${requestScope.compensation.getPremiumAmountForLabel()}" /></td>
						</tr>
						<tr>
							<td>退陣料率</td>
							<td><c:out
									value="${requestScope.compensation.getPremiumAmountForLabel()}" /></td>
						</tr>
						<tr>
							<td>対物料率</td>
							<td><c:out
									value="${requestScope.compensation.getPremiumAmountForLabel()}" /></td>
						</tr>
						<tr>
							<td>障害料率</td>
							<td><c:out
									value="${requestScope.compensation.getPremiumAmountForLabel()}" /></td>
						</tr>
						<tr>
							<td>年齢条件</td>
							<td><c:out
									value="${requestScope.compensation.getPremiumAmountForLabel()}" /></td>
						</tr>
						<tr>
							<td>１回分保険料</td>
							<td><c:out
									value="${requestScope.compensation.getPremiumAmountForLabel()}" /></td>
						</tr>
						<table>
							<tr>
								<td>
									<button type="button" onclick="toFinishUpdatePage();" class="btn">更新完了</button>
								</td>
								<td>
									<button type="button" onclick="toFinishAcceptPage();" class="btn">事故受付完了</button>
								</td>
							</tr>
						</table>
					</table>
				</div>
			</div>
		</div>
		<table>
			<tr>
				<td>
					<button type="button" onclick="toReceptionStart();" class="btn">前の画面へ戻る</button>
				</td>
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
</body>
</html>