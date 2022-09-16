<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>保険料試算後画面</title>
		<style type="text/css">
			/* タブ領域全体 */
            #tabcontrol {
                margin: 0;
                width: 300;
            }

            /* タブ */
            #tabcontrol a {
                display: inline-block;                /* インラインブロック化 */
                border-width: 1px 1px 0px 1px;        /* 下以外の枠線を引く */
                border-style: solid;                  /* 枠線の種類：実線 */
                border-color: black;                  /* 枠線の色：黒色 */
                border-radius: 0.75em 0.75em 0px 0px; /* 枠線の左上角と右上角だけを丸く */
                padding: 0.75em 1em;                  /* 内側の余白 */
                text-decoration: none;                /* リンクの下線を消す */
                color: black;                         /* 文字色：黒色 */
                background-color: white;              /* 背景色：白色 */
                font-weight: bold;                    /* 太字 */
                position: relative;                   /* JavaScriptでz-indexを調整するために必要 */
            }

            /* タブにマウスポインタが載った際（任意） */
            #tabcontrol a:hover {
                text-decoration: underline;   /* リンクの下線を引く */
            }

            /* タブの中身 */
            #tabbody div {
                border: 1px solid black; /* 黒色の実線を1pxの太さで引く */
                margin-top: -1px;        /* 上側にあるタブと1pxだけ重ねるために「-1px」を指定 */
                padding: 1em;            /* 内側の余白 */
                background-color: white; /* 背景色：白色 */
                position: relative;      /* z-indexを調整するために必要 */
                z-index: 0;              /* 重なり順序を「最も背面」にするため */
                min-height: 5em;         /* 最低の高さが必要なら指定(不要なら省略可) */
            }

            /* タブの配色 */
            #tabcontrol a:nth-child(1), #tabbody div:nth-child(1) { background-color: #ffffdd; }	/* 1つ目のタブとその中身用の配色 */
            #tabcontrol a:nth-child(2), #tabbody div:nth-child(2) { background-color: #ddffdd; }	/* 2つ目のタブとその中身用の配色 */

            .btn {
                    position: relative;
                    display: flex;
                    justify-content: space-around;
                    align-items: center;
                    max-width: 240px;
                    padding: 10px 25px;
                    color: #FFF;
                    transition: 0.3s ease-in-out;
                    font-weight: 600;
                    background: #6bb6ff;
                    border-radius: 8px;
                    border-bottom: solid 5px #1d7fde;
                    margin-bottom: 15px;
                    margin-top: 25px;
                    display: inline-block;
                }
                .btn:hover {
                    border-bottom: solid 2px #1d7fde;
                    transform: translateY(3px);
                }

                table{
                    width: 100%;
                    border-collapse: collapse;
                }

                table tr{
                    border-bottom: solid 2px white;
                }

                table tr:last-child{
                    border-bottom: none;
                }

                table th{
                    position: relative;
                    text-align: left;
                    width: 30%;
                    background-color: #52c2d0;
                    color: white;
                    text-align: center;
                    padding: 10px 0;
                }

                table th:after{
                    display: block;
                    content: "";
                    width: 0px;
                    height: 0px;
                    position: absolute;
                    top:calc(50% - 10px);
                    right:-10px;
                    border-left: 10px solid #52c2d0;
                    border-top: 10px solid transparent;
                    border-bottom: 10px solid transparent;
                }

                table td{
                    text-align: left;
                    width: 70%;
                    text-align: center;
                    background-color: #eee;
                    padding: 10px 0;
                }
        </style>


        <script type="text/javascript" src="./static/js/transition.js"></script>

	</head>
	<body>
		<header>
            <h1>契約管理・事故受付システム　ハンディー</h1>
        </header>
        <main>
        	<form action="" method="post" class="radiochange" id="application_frm2">
                <button type="button" onclick="toTopMenu();" class="btn">トップへ戻る</button>


            <div class="sample-area">

                <p id="tabcontrol">
                    <a href="#tabpage1">契約条件</a>
                    <a href="#tabpage2">補償</a>
                </p>
                <div id="tabbody">
                    <div id="tabpage1">
                            <table>
                                <tr>
                                    <td align="center">
                                    <h1>新規試算入力（契約条件タブ）</h1>
                                    </td>
                                </tr>
                            </table>
                            <table width="2500">
                            <tbody>

								<tr>
                                    <th scope="row">
                                        <label for="insuredKbn">被保険者の個人・法人区分</label>
                                    </th>
                                    <td>
                                        <c:out value="${contractInfo.getInsuredKbnForLabel() }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="inceptionDate">保険期間始期日</label>
                                    </th>
                                    <td>
                                        <c:out value="${contractInfo.inceptionDate }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="inceptionTime">保険期間始期時刻</label>
                                    </th>
                                    <td>
                                        <c:out value="${contractInfo.inceptionTime }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="conclusionDate">保険期間満期日</label>
                                    </th>
                                    <td>
                                        <c:out value="${contractInfo.conclusionDate }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="conclusionTime">保険期間満期時刻</label>
                                    </th>
                                    <td>
                                        <c:out value="${contractInfo.conclusionTime }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="paymentMethod">払込方法</label>
                                    </th>
                                    <td>
                                        <c:out value="${contractInfo.getPaymentMethodForLabel() }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="installment">払込回数</label>
                                    </th>
                                    <td>
                                        <c:out value="${contractInfo.installment }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="nameKana1">氏名（会社名）カナ１</label>
                                    </th>
                                    <td>
                                        <c:out value="${contractInfo.nameKana1 }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="nameKana2">氏名（会社名）カナ２</label>
                                    </th>
                                    <td>
                                        <c:out value="${contractInfo.nameKana2 }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="nameKanji1">氏名（会社名）漢字１</label>
                                    </th>
                                    <td>
                                        <c:out value="${contractInfo.nameKanji1 }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="nameKanji2">氏名（会社名）漢字２</label>
                                    </th>
                                    <td>
                                        <c:out value="${contractInfo.nameKanji2 }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="postcode">郵便番号</label>
                                    </th>
                                    <td>
                                        <c:out value="${contractInfo.postcode }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="addressKana1">住所カナ１</label>
                                    </th>
                                    <td>
                                        <c:out value="${contractInfo.addressKana1 }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="addressKana2">住所カナ２</label>
                                    </th>
                                    <td>
                                        <c:out value="${contractInfo.addressKana2 }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="addressKanji1">住所漢字１</label>
                                    </th>
                                    <td>
                                        <c:out value="${contractInfo.addressKanji1 }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="addressKanji2">住所漢字２</label>
                                    </th>
                                    <td>
                                        <c:out value="${contractInfo.addressKanji1 }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="birthday">生年月日</label>
                                    </th>
                                    <td>
                                        <c:out value="${contractInfo.birthday }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="gender">性別</label>
                                    </th>
                                    <td>
                                        <c:out value="${contractInfo.getGenderForLabel() }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="telephoneNo">電話番号</label>
                                    </th>
                                    <td>
                                        <c:out value="${contractInfo.getTelephoneNoForLabel() }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="mobliephoneNo">携帯電話番号</label>
                                    </th>
                                    <td>
                                        <c:out value="${contractInfo.getMobilePhoneNoForLabel() }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="faxNo">FAX番号</label>
                                    </th>
                                    <td>
                                        <c:out value="${contractInfo.getFaxNoForLabel() }"></c:out>
                                    </td>
                                </tr>
                            </tbody>
                            </table>

                    </div>
                    <div id="tabpage2">

                        <h1>新規試算入力（補償タブ）</h1>
                        <table border="1" width="80%">
                            <tbody>
                                <tr>
                                    <td colspan="2">自動車保険料試算結果</td>
                                </tr>
                                <tr>
                                    <td>総額保険料</td>
                                    <td>
                                    	<c:out value="${compensation.getPremiumAmountForLabel()}"/>（万円）
                                    </td>
                                </tr>
                                <tr>
                                    <td>一回分保険料</td>
                                    <td>
                                    	<c:out value="${compensation.premiumInstallment}" />（万円）
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <table id="secondBox" width="2500">
                            <tbody>
                                <tr>
                                    <th>メーカー</th>
                                    <td>
                                    	<c:out value="${compensation.maker }"></c:out>
                                    </td>
                                </tr>

                                <tr>
                                    <th>車名</th>
                                    <td>
                                        <c:out value="${compensation.carName }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th>車両保険金額</th>
                                    <td>
                                        <c:out value="${compensation.vehiclePrice }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th>料率・車両</th>
                                    <td>
                                        <c:out value="${compensation.getVehicleRatesForLabel() }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th>料率・対人</th>
                                    <td>
                                        <c:out value="${compensation.getBodilyRatesForLabel() }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th>料率・対物</th>
                                    <td>
                                        <c:out value="${compensation.getPropertyDamageRatesForLabel() }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th>料率・車両</th>
                                    <td>
                                        <c:out value="${compensation.getAccidentRatesForLabel() }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="licenseNo">車のナンバー</label>
                                    </th>
                                    <td>
                                        <c:out value="${compensation.licenseNo }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="licenseColor">免許証の色</label>
                                    </th>
                                    <td>
                                        <c:out value="${compensation.getLicenseColorForLabel() }"></c:out>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="ageLimit">年齢条件</label>
                                    </th>
                                    <td>
                                        <c:out value="${compensation.getAgeLimitForLabel() }"></c:out>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <table align="center">
                            <tr>
                                <td>
                                    <button type="button" class="btn" onclick="toAfterEstimationPage();">保険料試算</button>
                                </td>
                                <td>
                                    <button type="button" class="btn" onclick="toApplicationConfirmPage();">申込書印刷</button>
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
                    var targetid = this.href.substring(this.href.indexOf('#')+1,this.href.length);

                    // 指定のページだけを表示する
                    for(var i=0; i<pages.length; i++) {
                        if( pages[i].id != targetid ) {
                            pages[i].style.display = "none";
                        }
                        else {
                            pages[i].style.display = "block";
                        }
                    }

                    // クリックされたタブを前面に表示する
                    for(var i=0; i<tabs.length; i++) {
                        tabs[i].style.zIndex = "0";
                    }
                    this.style.zIndex = "10";

                    // ページ遷移しないようにfalseを返す
                    return false;
                }

                // すべてのタブに対して、クリック時にchangeTab関数が実行されるよう指定する
                for(var i=0; i<tabs.length; i++) {
                    tabs[i].onclick = changeTab;
                }

                // 最初は先頭のタブを選択
                tabs[1].onclick();

            </script>
            <div align="center" id="MESSAGE">
			    <c:out value="${requestScope.message }" />
			</div>
		</main>
	</body>
</html>