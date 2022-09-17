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
                                        class="button_design" onclick=toTopMenu()>トップへ戻る</button></th>
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
                                        <td><c:out value="${sessionScope.accidentReception.claimNo}"/></td>
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
                                            <input type="date" name = "accidentdate" size="60" placeholder="YYYY/MM/DD" value="${sessionScope.accidentReception.getAccidentDate()}">
                                        </td>
                                        <c:if test="${requestScope.check.get(0) == 1}">
                                        	<td><c:out value="未入力です。" /><td/>
                                        </c:if>
                                    </tr>
                                    <tr>
                                        <th>
                                            事故現場住所1-漢字
                                        </th>
                                        <td>
                                            <input type="text" name = "accidentlocationkanji1" placeholder="東京都多摩市"value="${sessionScope.accidentReception.getAccidentLocationKanji1()}" >
                                        </td>
                                        <c:if test="${requestScope.check.get(1) == 1}">
                                        	<td><c:out value="未入力です。" /><td/>
                                        </c:if>
                                    </tr>
                                    <tr>
                                        <th>
                                            事故現場住所1-カナ
                                        </th>
                                        <td>
                                            <input type="text" name = "accidentlocationkana1" placeholder="トウキョウトタマシ" value="${sessionScope.accidentReception.getAccidentLocationKana1()}" >
                                        </td>
                                        <c:if test="${requestScope.check.get(2) == 1}">
                                        	<td><c:out value="未入力です。" /><td/>
                                        </c:if>
                                    </tr>
                                    <tr>
                                        <th>
                                            事故現場住所2-漢字
                                        </th>
                                        <td>
                                            <input type="text" name = "accidentlocationkanji2" placeholder="○○町○○番地" value="${sessionScope.accidentReception.getAccidentLocationKanji2()}">
                                        </td>
                                        <c:if test="${requestScope.check.get(3) == 1}">
                                        	<td><c:out value="未入力です。" /><td/>
                                        </c:if>
                                    </tr>
                                    <tr>
                                        <th>
                                            事故現場住所2-カナ
                                        </th>
                                        <td>
                                            <input type="text" name = "accidentlocationkana2" placeholder="○○チョウ○○バンチ" value="${sessionScope.accidentReception.getAccidentLocationKana1()}">
                                        </td>
                                        <c:if test="${requestScope.check.get(4) == 1}">
                                        	<td><c:out value="未入力です。" /><td/>
                                        </c:if>
                                    </tr>
                                    <tr>
                                        <th>
                                            相手の状況（被害者側）
                                        </th>
                                        <td>
                                            <input type="text" placeholder="相手にケガはなし" name = "accidentsituation" value="${sessionScope.accidentReception.getAccidentSituation()}">
                                        </td>
                                        <c:if test="${requestScope.check.get(5) == 1}">
                                        	<td><c:out value="未入力です。" /><td/>
                                        </c:if>
                                    </tr>
                                    <tr>
                                        <th>
                                            過失割合（非保険者方）
                                        </th>
                                        <td>
                                            <input type="text" placeholder="20" name = "ratingblamemyself" value="${sessionScope.accidentReception.getRatingBlameMyself()}">
                                        </td>
                                        <c:if test="${requestScope.check.get(6) == 1}">
                                        	<td><c:out value="未入力です。" /><td/>
                                        </c:if>
                                    </tr>
                                    <tr>
                                        <th>
                                            過失割合（相手方）
                                        </th>
                                        <td>
                                            <input type="text" placeholder="80" name = "ratingblameyourself" value="${sessionScope.accidentReception.getRatingBlameYourself()}">
                                        </td>
                                        <c:if test="${requestScope.check.get(7) == 1}">
                                        	<td><c:out value="未入力です。" /><td/>
                                        </c:if>
                                    </tr>
                                    <tr>
                                        <th>
                                            損害額・車両
                                        </th>
                                        <td>
                                            <input type="text" placeholder="A0000001" name = "damagecarprice" value="${sessionScope.accidentReception.getDamageCarPrice()}">(円)
                                        </td>
                                        <c:if test="${requestScope.check.get(8) == 1}">
                                        	<td><c:out value="未入力です。" /><td/>
                                        </c:if>
                                    </tr>
                                    <tr>
                                        <th>
                                            損害状況・車両
                                        </th>
                                        <td>
                                            <input type="text" placeholder="一部あり" name = "damagecarstate" value="${sessionScope.accidentReception.getDamageCarState()}">
                                        </td>
                                        <c:if test="${requestScope.check.get(9) == 1}">
                                        	<td><c:out value="未入力です。" /><td/>
                                        </c:if>
                                    </tr>
                                    <tr>
                                        <th>
                                            損害額・対人
                                        </th>
                                        <td>
                                            <input type="text" placeholder="A0000001" name = "damagebodilyprice" value="${sessionScope.accidentReception.getDamageBodilyPrice()}">(円)
                                        </td>
                                        <c:if test="${requestScope.check.get(10) == 1}">
                                        	<td><c:out value="未入力です。" /><td/>
                                        </c:if>
                                    </tr>
                                    <tr>
                                        <th>
                                            損害状況・対人
                                        </th>
                                        <td>
                                            <input type="text" placeholder="なし" name = "damagebodilystate" value="${sessionScope.accidentReception.getDamageBodilyState()}">
                                        </td>
                                        <c:if test="${requestScope.check.get(11) == 1}">
                                        	<td><c:out value="未入力です。" /><td/>
                                        </c:if>
                                    </tr>
                                    <tr>
                                        <th>
                                            損害額・対物
                                        </th>
                                        <td>
                                            <input type="text" placeholder="A0000001" name = "damagepropertyprice" value="${sessionScope.accidentReception.getDamagePropertyPrice()}">(円)
                                        </td>
                                        <c:if test="${requestScope.check.get(12) == 1}">
                                        	<td><c:out value="未入力です。" /><td/>
                                        </c:if>
                                    </tr>
                                    <tr>
                                        <th>
                                            損害状況・対物
                                        </th>
                                        <td>
                                            <input type="text" placeholder="あり" name = "damagepropertystate" value="${sessionScope.accidentReception.getDamagePropertyState()}">
                                        </td>
                                        <c:if test="${requestScope.check.get(13) == 1}">
                                        	<td><c:out value="未入力です。" /><td/>
                                        </c:if>
                                    </tr>
                                    <tr>
                                        <th>
                                            損害額・傷害
                                        </th>
                                        <td>
                                            <input type="text" placeholder="4000円" name = "damageaccidentprice" value="${sessionScope.accidentReception.getDamageAccidentPrice()}">(円)
                                        </td>
                                        <c:if test="${requestScope.check.get(14) == 1}">
                                        	<td><c:out value="未入力です。" /><td/>
                                        </c:if>
                                    </tr>
                                    <tr>
                                        <th>
                                            損害状況・傷害
                                        </th>
                                        <td>
                                            <input type="text" placeholder="左脚捻挫" name = "damageaccidentstate" value="${sessionScope.accidentReception.getDamageAccidentState()}">
                                        </td>
                                        <c:if test="${requestScope.check.get(15) == 1}">
                                        	<td><c:out value="未入力です。" /><td/>
                                        </c:if>
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
                                <button type="button" onclick="toFinishUpdatePage()" class="button_design">更新完了</button>
                            </td>
                            <td>
                                <button type="button" onclick="toFinishAcceptPage()" class="button_design">受付完了</button>
                            </td>
                            <td>
                                <button type="button" onclick="toreturnReceptionPage()" class="button_design">前の画面へ戻る</button>
                            </td>
                        </tr>
                    </table>
                    </form>
                    <script type="text/javascript">

                        // 対象の要素を得る
                        var tabs = document.getElementById('tabcontrol').getElementsByTagName('a');
                        var pages = document.getElementById('tabbody').getElementsByTagName('div');

                        function changeTab() {
                            // ▼href属性値から対象のid名を抜き出す
                            var targetid = this.href.substring(this.href.indexOf('#')+1,this.href.length);

                            // ▼指定のページだけを表示する
                            for(var i=0; i<pages.length; i++) {
                                if( pages[i].id != targetid ) {
                                    pages[i].style.display = "none";
                                }
                                else {
                                    pages[i].style.display = "block";
                                }
                            }

                            // ▼クリックされたタブを前面に表示する
                            for(var i=0; i<tabs.length; i++) {
                                tabs[i].style.zIndex = "0";
                            }
                            this.style.zIndex = "10";

                            // ▼ページ遷移しないようにfalseを返す
                            return false;
                        }

                        // すべてのタブに対して、クリック時にchangeTab関数が実行されるよう指定する
                        for(var i=0; i<tabs.length; i++) {
                            tabs[i].onclick = changeTab;
                        }

                        // 最初は先頭のタブを選択
                        tabs[0].onclick();

                    </script>
                </main>
            </body>
</html>