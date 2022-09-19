<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>新規試算入力画面</title>

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

            input:required{
                background: #ffcdd2;
            }
            input:valid{
                background: transparent;
            }
            input:focus{
                background: #DCEDC8;
            }

            .form-require {
                border-radius: 5px;
                margin-right: 10px;
                padding-top: 5px;
                padding-bottom: 5px;
                width: 45px;
                display: inline-block;
                text-align: center;
                background: red;
                color: #fff;
                font-size: 12px;
            }
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
            <h1>契約管理・事故受付システム　ハンディー</h1>
        </header>
        <main>
            <form action="" method="post" class="radiochange" id="application_frm">
                <button type="button" onclick="toTopMenu();" class="btn">トップへ戻る</button>

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
                                    <h2>
                                      被保険者の個人・法人区分&emsp;&emsp;
                                        <label>
                                            <input type="radio" name="insuredKbn" value="1" onclick="entryChange1();"checked="checked" <c:if test="${sessionScope.contractInfo.insuredKbn == '1'}"></c:if>>個人
                                        </label>
                                        <label>
                                            <input type="radio" name="insuredKbn" value="2" onclick="entryChange1();" <c:if test="${sessionScope.contractInfo.insuredKbn == '2'}"></c:if>>法人
                                        </label>
                                    </h2>
                                    </td>
                                </tr>
                            </table>
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
                            <table id="個人" >
                            <tbody>

                                <tr>
                                    <th scope="row">
                                        <label for="inceptionDate">保険期間始期日</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="inceptionDate" name="inceptionDate" size="60" placeholder="YYYY/MM/DD" value="${sessionScope.contractInfo.inceptionDate}" required>
                                        <p><font size="1">契約を開始したい日時を選択してください。</font></p>
                                    	<p><font size="1">現在よりも過去の日時は選択できません。</font></p>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="inceptionTime">保険期間始期時刻</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <select name="inceptionTime" id="inceptionTime"required>
                                            <option value="">保険期間始期時刻を選択してください</option>
                                            <option value="0" <c:if test="${contractInfo.inceptionTime == '0'}">selected="selected"</c:if>>午前0時</option>
                                            <option value="1" <c:if test="${contractInfo.inceptionTime == '1'}">selected="selected"</c:if>>午前1時</option>
                                            <option value="2" <c:if test="${contractInfo.inceptionTime == '2'}">selected="selected"</c:if>>午前2時</option>
                                            <option value="3" <c:if test="${contractInfo.inceptionTime == '3'}">selected="selected"</c:if>>午前3時</option>
                                            <option value="4" <c:if test="${contractInfo.inceptionTime == '4'}">selected="selected"</c:if>>午前4時</option>
                                            <option value="5" <c:if test="${contractInfo.inceptionTime == '5'}">selected="selected"</c:if>>午前5時</option>
                                            <option value="6" <c:if test="${contractInfo.inceptionTime == '6'}">selected="selected"</c:if>>午前6時</option>
                                            <option value="7" <c:if test="${contractInfo.inceptionTime == '7'}">selected="selected"</c:if>>午前7時</option>
                                            <option value="8" <c:if test="${contractInfo.inceptionTime == '8'}">selected="selected"</c:if>>午前8時</option>
                                            <option value="9" <c:if test="${contractInfo.inceptionTime == '9'}">selected="selected"</c:if>>午前9時</option>
                                            <option value="10" <c:if test="${contractInfo.inceptionTime == '10'}">selected="selected"</c:if>>午前10時</option>
                                            <option value="11" <c:if test="${contractInfo.inceptionTime == '11'}">selected="selected"</c:if>>午前11時</option>
                                            <option value="12" <c:if test="${contractInfo.inceptionTime == '12'}">selected="selected"</c:if>>正午</option>
                                            <option value="13" <c:if test="${contractInfo.inceptionTime == '13'}">selected="selected"</c:if>>午後1時</option>
                                            <option value="14" <c:if test="${contractInfo.inceptionTime == '14'}">selected="selected"</c:if>>午後2時</option>
                                            <option value="15" <c:if test="${contractInfo.inceptionTime == '15'}">selected="selected"</c:if>>午後3時</option>
                                            <option value="16" <c:if test="${contractInfo.inceptionTime == '16'}">selected="selected"</c:if>>午後4時</option>
                                            <option value="17" <c:if test="${contractInfo.inceptionTime == '17'}">selected="selected"</c:if>>午後5時</option>
                                            <option value="18" <c:if test="${contractInfo.inceptionTime == '18'}">selected="selected"</c:if>>午後6時</option>
                                            <option value="19" <c:if test="${contractInfo.inceptionTime == '19'}">selected="selected"</c:if>>午後7時</option>
                                            <option value="20" <c:if test="${contractInfo.inceptionTime == '20'}">selected="selected"</c:if>>午後8時</option>
                                            <option value="21" <c:if test="${contractInfo.inceptionTime == '21'}">selected="selected"</c:if>>午後9時</option>
                                            <option value="22" <c:if test="${contractInfo.inceptionTime == '22'}">selected="selected"</c:if>>午後10時</option>
                                            <option value="23" <c:if test="${contractInfo.inceptionTime == '23'}">selected="selected"</c:if>>午後11時</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="conclusionDate">保険期間満期日</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="conclusionDate" name="conclusionDate" size="60" placeholder="YYYY/MM/DD" value="${sessionScope.contractInfo.conclusionDate}" required>
                                        <p><font size="2">契約を終了したい日時を選択してください。</font></p>
                                    	<p><font size="2">現在よりも過去の日時は選択できません。</font></p>
                                    	<p><font size="2">保険期間始期日よりも過去の日時は選択できません。</font></p>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="conclusionTime">保険期間満期時刻</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <select name="conclusionTime" id="conclusionTime"required>
                                            <option value="">保険期間始期時刻を選択してください</option>
                                            <option value="0" <c:if test="${contractInfo.conclusionTime == '0'}">selected="selected"</c:if>>午前0時</option>
                                            <option value="1" <c:if test="${contractInfo.conclusionTime == '1'}">selected="selected"</c:if>>午前1時</option>
                                            <option value="2" <c:if test="${contractInfo.conclusionTime == '2'}">selected="selected"</c:if>>午前2時</option>
                                            <option value="3" <c:if test="${contractInfo.conclusionTime == '3'}">selected="selected"</c:if>>午前3時</option>
                                            <option value="4" <c:if test="${contractInfo.conclusionTime == '4'}">selected="selected"</c:if>>午前4時</option>
                                            <option value="5" <c:if test="${contractInfo.conclusionTime == '5'}">selected="selected"</c:if>>午前5時</option>
                                            <option value="6" <c:if test="${contractInfo.conclusionTime == '6'}">selected="selected"</c:if>>午前6時</option>
                                            <option value="7" <c:if test="${contractInfo.conclusionTime == '7'}">selected="selected"</c:if>>午前7時</option>
                                            <option value="8" <c:if test="${contractInfo.conclusionTime == '8'}">selected="selected"</c:if>>午前8時</option>
                                            <option value="9" <c:if test="${contractInfo.conclusionTime == '9'}">selected="selected"</c:if>>午前9時</option>
                                            <option value="10" <c:if test="${contractInfo.conclusionTime == '10'}">selected="selected"</c:if>>午前10時</option>
                                            <option value="11" <c:if test="${contractInfo.conclusionTime == '11'}">selected="selected"</c:if>>午前11時</option>
                                            <option value="12" <c:if test="${contractInfo.conclusionTime == '12'}">selected="selected"</c:if>>正午</option>
                                            <option value="13" <c:if test="${contractInfo.conclusionTime == '13'}">selected="selected"</c:if>>午後1時</option>
                                            <option value="14" <c:if test="${contractInfo.conclusionTime == '14'}">selected="selected"</c:if>>午後2時</option>
                                            <option value="15" <c:if test="${contractInfo.conclusionTime == '15'}">selected="selected"</c:if>>午後3時</option>
                                            <option value="16" <c:if test="${contractInfo.conclusionTime == '16'}">selected="selected"</c:if>>午後4時</option>
                                            <option value="17" <c:if test="${contractInfo.conclusionTime == '17'}">selected="selected"</c:if>>午後5時</option>
                                            <option value="18" <c:if test="${contractInfo.conclusionTime == '18'}">selected="selected"</c:if>>午後6時</option>
                                            <option value="19" <c:if test="${contractInfo.conclusionTime == '19'}">selected="selected"</c:if>>午後7時</option>
                                            <option value="20" <c:if test="${contractInfo.conclusionTime == '20'}">selected="selected"</c:if>>午後8時</option>
                                            <option value="21" <c:if test="${contractInfo.conclusionTime == '21'}">selected="selected"</c:if>>午後9時</option>
                                            <option value="22" <c:if test="${contractInfo.conclusionTime == '22'}">selected="selected"</c:if>>午後10時</option>
                                            <option value="23" <c:if test="${contractInfo.conclusionTime == '23'}">selected="selected"</c:if>>午後11時</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="paymentMethod">払込方法</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <select name="paymentMethod" id="paymentMethod" required>
                                        	<option value="">以下の払込方法から選択してください</option>
                                            <option value="1"<c:if test="${sessionScope.contractInfo.paymentMethod == '1'}">selected="selected"</c:if>>直接集金</option>
                                            <option value="2"<c:if test="${sessionScope.contractInfo.paymentMethod == '2'}">selected="selected"</c:if>>口座振替</option>
                                            <option value="3"<c:if test="${sessionScope.contractInfo.paymentMethod == '3'}">selected="selected"</c:if>>クレジットカード</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="installment">払込回数</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <select name="installment" id="installment" required>
                                        	<option value="">以下の払込回数から選択してください</option>
                                            <option value="1"<c:if test="${sessionScope.contractInfo.installment == '1'}">selected="selected"</c:if>>1</option>
                                            <option value="2"<c:if test="${sessionScope.contractInfo.installment == '2'}">selected="selected"</c:if>>2</option>
                                            <option value="3"<c:if test="${sessionScope.contractInfo.installment == '3'}">selected="selected"</c:if>>3</option>
                                            <option value="4"<c:if test="${sessionScope.contractInfo.installment == '4'}">selected="selected"</c:if>>4</option>
                                            <option value="6"<c:if test="${sessionScope.contractInfo.installment == '6'}">selected="selected"</c:if>>6</option>
                                            <option value="12"<c:if test="${sessionScope.contractInfo.installment == '12'}">selected="selected"</c:if>>12</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="nameKana1">氏名カナ１</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="nameKana1" name="nameKana1" size="60" placeholder="（例）トウカイ" maxlength="48" value="${sessionScope.contractInfo.nameKana1}" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="nameKana2">氏名カナ２</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="nameKana2" name="nameKana2" size="60" placeholder="（例）タロウ" maxlength="48" value="${sessionScope.contractInfo.nameKana2}" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="nameKanji1">氏名漢字１</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="nameKanji1" name="nameKanji1" size="60" placeholder="（例）東海" maxlength="48" value="${sessionScope.contractInfo.nameKanji1}" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="nameKanji2">氏名漢字２</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="nameKanji2" name="nameKanji2" size="60" placeholder="（例）太郎" maxlength="48" value="${sessionScope.contractInfo.nameKanji2}" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="postcode">郵便番号</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="postcode" name="postcode" size="60" placeholder="（例）1111111" maxlength="7" value="${sessionScope.contractInfo.postcode}" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="addressKana1">住所カナ１</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="addressKana1" name="addressKana1" size="60" placeholder="（例）トウキョウトタマシ" maxlength="48" value="${sessionScope.contractInfo.addressKana1}" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="addressKana2">住所カナ２</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="addressKana2" name="addressKana2" size="60" placeholder="（例）オチアイ12-34" maxlength="48" value="${sessionScope.contractInfo.addressKana2}" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="addressKanji1">住所漢字１</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="addressKanji1" name="addressKanji1" size="60" placeholder="（例）東京都多摩市" maxlength="48" value="${sessionScope.contractInfo.addressKanji1 }" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="addressKanji2">住所漢字２</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="addressKanji2" name="addressKanji2" size="60" placeholder="（例）落合12-34" maxlength="48" value="${sessionScope.contractInfo.addressKanji2 }" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="birthday">生年月日</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="birthday" name="birthday" size="60" placeholder="YYYY/MM/DD" value="${sessionScope.contractInfo.birthday }" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="gender">性別</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <label>
                                            <input type="radio" id="gender" name="gender" value="1"<c:if test="${sessionScope.contractInfo.gender == '1'}">checked="checked"</c:if>>男
                                            <input type="radio" id="gender" name="gender" value="2"<c:if test="${sessionScope.contractInfo.gender == '2'}">checked="checked"</c:if>>女
                                        </label>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="telephoneNo">電話番号</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="telephoneNo" name="telephoneNo" size="60" placeholder="（例）0123456789" maxlength="10" value="${sessionScope.contractInfo.telephoneNo }"required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="mobliephoneNo">携帯電話番号</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="mobilephoneNo" name="mobilephoneNo" size="60" placeholder="（例）08012345678" maxlength="11" value="${sessionScope.contractInfo.mobilephoneNo }" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="faxNo">FAX番号</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="faxNo" name="faxNo" size="60" placeholder="（例）123456789" maxlength="10" value="${sessionScope.contractInfo.faxNo }" required>
                                    </td>
                                </tr>
                            </tbody>
                            </table>

                            <table id="法人" width="2500">
                            <tbody>

                                <tr>
                                    <th scope="row">
                                        <label for="inceptionDate">保険期間始期日</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="inceptionDate" name="inceptionDate" size="60" placeholder="YYYY/MM/DD" value="${contractInfo.inceptionDate }" required>
                                    </td>
                                </tr>

                                <tr>
                                    <th scope="row">
                                        <label for="inceptionTime">保険期間始期時刻</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <select name="inceptionTime" id="inceptionTime"required>
                                            <option value="">保険期間始期時刻を選択してください</option>
                                            <option value="0" <c:if test="${contractInfo.inceptionTime == '0'}">selected="selected"</c:if>>午前0時</option>
                                            <option value="1" <c:if test="${contractInfo.inceptionTime == '1'}">selected="selected"</c:if>>午前1時</option>
                                            <option value="2" <c:if test="${contractInfo.inceptionTime == '2'}">selected="selected"</c:if>>午前2時</option>
                                            <option value="3" <c:if test="${contractInfo.inceptionTime == '3'}">selected="selected"</c:if>>午前3時</option>
                                            <option value="4" <c:if test="${contractInfo.inceptionTime == '4'}">selected="selected"</c:if>>午前4時</option>
                                            <option value="5" <c:if test="${contractInfo.inceptionTime == '5'}">selected="selected"</c:if>>午前5時</option>
                                            <option value="6" <c:if test="${contractInfo.inceptionTime == '6'}">selected="selected"</c:if>>午前6時</option>
                                            <option value="7" <c:if test="${contractInfo.inceptionTime == '7'}">selected="selected"</c:if>>午前7時</option>
                                            <option value="8" <c:if test="${contractInfo.inceptionTime == '8'}">selected="selected"</c:if>>午前8時</option>
                                            <option value="9" <c:if test="${contractInfo.inceptionTime == '9'}">selected="selected"</c:if>>午前9時</option>
                                            <option value="10" <c:if test="${contractInfo.inceptionTime == '10'}">selected="selected"</c:if>>午前10時</option>
                                            <option value="11" <c:if test="${contractInfo.inceptionTime == '11'}">selected="selected"</c:if>>午前11時</option>
                                            <option value="12" <c:if test="${contractInfo.inceptionTime == '12'}">selected="selected"</c:if>>正午</option>
                                            <option value="13" <c:if test="${contractInfo.inceptionTime == '13'}">selected="selected"</c:if>>午後1時</option>
                                            <option value="14" <c:if test="${contractInfo.inceptionTime == '14'}">selected="selected"</c:if>>午後2時</option>
                                            <option value="15" <c:if test="${contractInfo.inceptionTime == '15'}">selected="selected"</c:if>>午後3時</option>
                                            <option value="16" <c:if test="${contractInfo.inceptionTime == '16'}">selected="selected"</c:if>>午後4時</option>
                                            <option value="17" <c:if test="${contractInfo.inceptionTime == '17'}">selected="selected"</c:if>>午後5時</option>
                                            <option value="18" <c:if test="${contractInfo.inceptionTime == '18'}">selected="selected"</c:if>>午後6時</option>
                                            <option value="19" <c:if test="${contractInfo.inceptionTime == '19'}">selected="selected"</c:if>>午後7時</option>
                                            <option value="20" <c:if test="${contractInfo.inceptionTime == '20'}">selected="selected"</c:if>>午後8時</option>
                                            <option value="21" <c:if test="${contractInfo.inceptionTime == '21'}">selected="selected"</c:if>>午後9時</option>
                                            <option value="22" <c:if test="${contractInfo.inceptionTime == '22'}">selected="selected"</c:if>>午後10時</option>
                                            <option value="23" <c:if test="${contractInfo.inceptionTime == '23'}">selected="selected"</c:if>>午後11時</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="conclusionDate">保険期間満期日</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="conclusionDate" name="conclusionDate" size="60" placeholder="YYYY/MM/DD" value="${contractInfo.conclusionDate }" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="conclusionTime">保険期間満期時刻</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <select name="conclusionTime" id="conclusionTime"required>
                                            <option value="">保険期間始期時刻を選択してください</option>
                                            <option value="0" <c:if test="${contractInfo.conclusionTime == '0'}">selected="selected"</c:if>>午前0時</option>
                                            <option value="1" <c:if test="${contractInfo.conclusionTime == '1'}">selected="selected"</c:if>>午前1時</option>
                                            <option value="2" <c:if test="${contractInfo.conclusionTime == '2'}">selected="selected"</c:if>>午前2時</option>
                                            <option value="3" <c:if test="${contractInfo.conclusionTime == '3'}">selected="selected"</c:if>>午前3時</option>
                                            <option value="4" <c:if test="${contractInfo.conclusionTime == '4'}">selected="selected"</c:if>>午前4時</option>
                                            <option value="5" <c:if test="${contractInfo.conclusionTime == '5'}">selected="selected"</c:if>>午前5時</option>
                                            <option value="6" <c:if test="${contractInfo.conclusionTime == '6'}">selected="selected"</c:if>>午前6時</option>
                                            <option value="7" <c:if test="${contractInfo.conclusionTime == '7'}">selected="selected"</c:if>>午前7時</option>
                                            <option value="8" <c:if test="${contractInfo.conclusionTime == '8'}">selected="selected"</c:if>>午前8時</option>
                                            <option value="9" <c:if test="${contractInfo.conclusionTime == '9'}">selected="selected"</c:if>>午前9時</option>
                                            <option value="10" <c:if test="${contractInfo.conclusionTime == '10'}">selected="selected"</c:if>>午前10時</option>
                                            <option value="11" <c:if test="${contractInfo.conclusionTime == '11'}">selected="selected"</c:if>>午前11時</option>
                                            <option value="12" <c:if test="${contractInfo.conclusionTime == '12'}">selected="selected"</c:if>>正午</option>
                                            <option value="13" <c:if test="${contractInfo.conclusionTime == '13'}">selected="selected"</c:if>>午後1時</option>
                                            <option value="14" <c:if test="${contractInfo.conclusionTime == '14'}">selected="selected"</c:if>>午後2時</option>
                                            <option value="15" <c:if test="${contractInfo.conclusionTime == '15'}">selected="selected"</c:if>>午後3時</option>
                                            <option value="16" <c:if test="${contractInfo.conclusionTime == '16'}">selected="selected"</c:if>>午後4時</option>
                                            <option value="17" <c:if test="${contractInfo.conclusionTime == '17'}">selected="selected"</c:if>>午後5時</option>
                                            <option value="18" <c:if test="${contractInfo.conclusionTime == '18'}">selected="selected"</c:if>>午後6時</option>
                                            <option value="19" <c:if test="${contractInfo.conclusionTime == '19'}">selected="selected"</c:if>>午後7時</option>
                                            <option value="20" <c:if test="${contractInfo.conclusionTime == '20'}">selected="selected"</c:if>>午後8時</option>
                                            <option value="21" <c:if test="${contractInfo.conclusionTime == '21'}">selected="selected"</c:if>>午後9時</option>
                                            <option value="22" <c:if test="${contractInfo.conclusionTime == '22'}">selected="selected"</c:if>>午後10時</option>
                                            <option value="23" <c:if test="${contractInfo.conclusionTime == '23'}">selected="selected"</c:if>>午後11時</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="paymentMethod">払込方法</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <select name="paymentMethod" id="paymentMethod" required>
                                        	<option value="">以下の払込方法から選択してください</option>
                                            <option value="1"<c:if test="${contractInfo.paymentMethod == '1'}">selected="selected"</c:if>>直接集金</option>
                                            <option value="2"<c:if test="${contractInfo.paymentMethod == '2'}">selected="selected"</c:if>>口座振替</option>
                                            <option value="3"<c:if test="${contractInfo.paymentMethod == '3'}">selected="selected"</c:if>>クレジットカード</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="installment">払込回数</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <select name="installment" id="installment" required>
                                        	<option value="">以下の払込回数から選択してください</option>
                                            <option value="1"<c:if test="${contractInfo.installment == '1'}">selected="selected"</c:if>>1</option>
                                            <option value="2"<c:if test="${contractInfo.installment == '2'}">selected="selected"</c:if>>2</option>
                                            <option value="3"<c:if test="${contractInfo.installment == '3'}">selected="selected"</c:if>>3</option>
                                            <option value="4"<c:if test="${contractInfo.installment == '4'}">selected="selected"</c:if>>4</option>
                                            <option value="6"<c:if test="${contractInfo.installment == '6'}">selected="selected"</c:if>>6</option>
                                            <option value="12"<c:if test="${contractInfo.installment == '12'}">selected="selected"</c:if>>12</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="nameKana1">会社名カナ１</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="nameKana1" name="nameKana1" size="60" placeholder="（例）タマホケン" maxlength="48" value="${contractInfo.nameKana1 }" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="nameKana2">会社名カナ２</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="nameKana2" name="nameKana2" size="60" placeholder="（例）カブシキガイシャ" maxlength="48" value="${contractInfo.nameKana2 }" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="nameKanji1">会社名漢字１</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="nameKanji1" name="nameKanji1" size="60" placeholder="（例）多摩保険" maxlength="48" value="${contractInfo.nameKanji1 }" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="nameKanji2">会社名漢字２</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="nameKanji2" name="nameKanji2" size="60" placeholder="（例）株式会社" maxlength="48" value="${contractInfo.nameKanji2 }" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="postcode">郵便番号</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="postcode" name="postcode" size="60" placeholder="（例）1111111" maxlength="7" value="${contractInfo.postcode }" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="addressKana1">住所カナ１</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="addressKana1" name="addressKana1" size="60" placeholder="（例）トウキョウトタマシ" maxlength="48" value="${contractInfo.addressKana1 }" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="addressKana2">住所カナ２</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="addressKana2" name="addressKana2" size="60" placeholder="（例）オチアイ12-34" maxlength="48" value="${contractInfo.addressKana2 }" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="addressKanji1">住所漢字１</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="addressKanji1" name="addressKanji1" size="60" placeholder="（例）東京都多摩市" maxlength="48" value="${contractInfo.addressKanji1 }" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="addressKanji2">住所漢字２</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="addressKanji2" name="addressKanji2" size="60" placeholder="（例）落合12-34" maxlength="48" value="${contractInfo.addressKanji2 }" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="telephoneNo">電話番号</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="telephoneNo" name="telephoneNo" size="60" placeholder="（例）0123456789" maxlength="10" value="${contractInfo.telephoneNo }" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="mobliephoneNo">携帯電話番号</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="mobliephoneNo" name="mobliephoneNo" size="60" placeholder="（例）08012345678" maxlength="11" value="${contractInfo.mobilephoneNo }" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="faxNo">FAX番号</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="faxNo" name="faxNo" size="60" placeholder="（例）123456789" maxlength="10" value="${contractInfo.faxNo }" required>
                                    </td>
                                </tr>
                            </tbody>
                            </table>
                            <table>
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
                                    	<c:out value="${compensation.premiumAmount}"/>（万円）
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
                                        <span class="form-require">必須</span>
                                        <select name="maker" id="maker" required>
                                        	<option value="">以下のメーカーから選択してください</option>
                                            <option value="lexus"<c:if test="${compensation.maker == 'lexus'}">selected="selected"</c:if>>レクサス</option>
                                            <option value="matsuda"<c:if test="${compensation.maker == 'matsuda'}">selected="selected"</c:if>>マツダ</option>
                                            <option value="honda"<c:if test="${compensation.maker == 'honda'}">selected="selected"</c:if>>ホンダ</option>
                                            <option value="nissan"<c:if test="${compensation.maker == 'nissan'}">selected="selected"</c:if>>ニッサン</option>
                                            <option value="toyota"<c:if test="${compensation.maker == 'toyota'}">selected="selected"</c:if>>トヨタ</option>
                                            <option value="subaru"<c:if test="${compensation.maker == 'subaru'}">selected="selected"</c:if>>スバル</option>
                                            <option value="suzuki"<c:if test="${compensation.maker == 'suzuki'}">selected="selected"</c:if>>スズキ</option>
                                            <option value="mitsubishi"<c:if test="${compensation.maker == 'mitsubishi'}">selected="selected"</c:if>>三菱</option>
                                        </select>
                                    </td>
                                </tr>

                                <tr>
                                    <th>車名</th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <select name="carName" id="carName">
                                        	<option value="">以下の車名から選択してください</option>
                                            <option value="LS"<c:if test="${compensation.carName == 'LS'}">selected="selected"</c:if>>（レクサス）LS</option>
                                            <option value="GS"<c:if test="${compensation.carName == 'GS'}">selected="selected"</c:if>>（レクサス）GS</option>
                                            <option value="IS"<c:if test="${compensation.carName == 'IS'}">selected="selected"</c:if>>（レクサス）IS</option>
                                            <option value="デミオ"<c:if test="${compensation.carName == 'デミオ'}">selected="selected"</c:if>>（マツダ）デミオ</option>
                                            <option value="アクセラ"<c:if test="${compensation.carName == 'アクセラ'}">selected="selected"</c:if>>（マツダ）アクセラ</option>
                                            <option value="アテンザ"<c:if test="${compensation.carName == 'アテンザ'}">selected="selected"</c:if>>（マツダ）アテンザ</option>
                                            <option value="インテグラ"<c:if test="${compensation.carName == 'インテグラ'}">selected="selected"</c:if>>（ホンダ）インテグラ</option>
                                            <option value="ステップワゴン"<c:if test="${compensation.carName == 'ステップワゴン'}">selected="selected"</c:if>>（ホンダ）ステップワゴン</option>
                                            <option value="アコードハイブリッド"<c:if test="${compensation.carName == 'アコードハイブリッド'}"></c:if>>（ホンダ）アコードハイブリッド</option>
                                            <option value="フーガ"<c:if test="${compensation.carName == 'フーガ'}">selected="selected"</c:if>>（ニッサン）フーガ</option>
                                            <option value="マーチ"<c:if test="${compensation.carName == 'マーチ'}">selected="selected"</c:if>>（ニッサン）マーチ</option>
                                            <option value="セレナ"<c:if test="${compensation.carName == 'セレナ'}">selected="selected"</c:if>>（ニッサン）セレナ</option>
                                            <option value="スカイライン"<c:if test="${compensation.carName == 'スカイライン'}">selected="selected"</c:if>>（ニッサン）スカイライン</option>
                                            <option value="カローラアクシオ"<c:if test="${compensation.carName == 'カローラアクシオ'}">selected="selected"</c:if>>（トヨタ）カローラアクシオ</option>
                                            <option value="アクア"<c:if test="${compensation.carName == 'アクア'}">selected="selected"</c:if>>（トヨタ）アクア</option>
                                            <option value="クラウン"<c:if test="${compensation.carName == 'クラウン'}">selected="selected"</c:if>>（トヨタ）クラウン</option>
                                            <option value="レガシィ"<c:if test="${compensation.carName == 'レガシィ'}">selected="selected"</c:if>>（スバル）レガシィ</option>
                                            <option value="WRX"<c:if test="${compensation.carName == 'WRX'}">selected="selected"</c:if>>（スバル）WRX</option>
                                            <option value="レヴォーグ"<c:if test="${compensation.carName == 'レヴォーグ'}">selected="selected"</c:if>>（スバル）レヴォーグ</option>
                                            <option value="スイフト"<c:if test="${compensation.carName == 'スイフト'}">selected="selected"</c:if>>（スズキ）スイフト</option>
                                            <option value="キザシ"<c:if test="${compensation.carName == 'キザシ'}">selected="selected"</c:if>>（スズキ）キザシ</option>
                                            <option value="エスクード"<c:if test="${compensation.carName == 'エスクード'}">selected="selected"</c:if>>（スズキ）エスクード</option>
                                            <option value="アウトラウンダーPHEV"<c:if test="${compensation.carName == 'アウトラウンダーPHEV'}">selected="selected"</c:if>>（三菱）アウトラウンダーPHEV</option>
                                            <option value="デリカD:5"<c:if test="${compensation.carName == 'デリカD:5'}">selected="selected"</c:if>>（三菱）デリカD:5</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>車両保険金額</th>
                                    <td>
                                        <input type="text" value="" name="vehiclePrice" id="vehiclePrice" value="${sessionScope.compensation.vehiclePrice }" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th>料率・車両</th>
                                    <td>
                                        <input type="text" value="" name="vehicleRates" id="vehicleRates" value="${sessionScope.compensation.vehicleRates }" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th>料率・対人</th>
                                    <td>
                                        <input type="text" value="" name="bodilyRates" id="bodilyRates" value="${sessionScope.compensation.bodilyRates }" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th>料率・対物</th>
                                    <td>
                                        <input type="text" value="" name="propertyDamageRates" id="propertyDamageRates" value="${sessionScope.compensation.propertyDamageRates }" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th>料率・車両</th>
                                    <td>
                                        <input type="text" value="" name="accidentRates" id="accidentRates" value="${sessionScope.compensation.accidentRates }" required>
                                    </td>
                                </tr>

                                            <script>
                                            document.getElementById("carName").onchange = function(){
                                                var carName= document.getElementById("carName");
                                                var vehiclePrice = '';
                                                var vehicleRates = '';
                                                var bodilyRates = '';
                                                var propertyDamageRates = '';
                                                var accidentRates = '';

                                                switch(carName.value){
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
                                                document.getElementById("propertyDamageRates").value = propertyDamageRates;
                                                document.getElementById("accidentRates").value = accidentRates;
                                            };
                                            </script>

                                <tr>
                                    <th scope="row">
                                        <label for="licenseNo">車のナンバー</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <input type="text" id="licenseNo" name="licenseNo" size="60" placeholder="（例）多摩 12-34" maxlength="24" value="${compensation.licenseNo }" required>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="licenseColor">免許証の色</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <select name="licenseColor" id="licenseColor">
                                        	<option value="">以下の免許証の色から選択してください</option>
                                            <option value="1"<c:if test="${compensation.licenseColor == '1'}">selected="selected"</c:if>>ブルー</option>
                                            <option value="2"<c:if test="${compensation.licenseColor == '2'}">selected="selected"</c:if>>グリーン</option>
                                            <option value="3"<c:if test="${compensation.licenseColor == '3'}">selected="selected"</c:if>>ゴールド</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="ageLimit">年齢条件</label>
                                    </th>
                                    <td>
                                        <span class="form-require">必須</span>
                                        <select name="ageLimit" id="ageLimit">
                                        	<option value="">以下の年齢条件から選択してください</option>
                                            <option value="1"<c:if test="${compensation.ageLimit == '1'}">selected="selected"</c:if>>無条件</option>
                                            <option value="2"<c:if test="${compensation.ageLimit == '2'}">selected="selected"</c:if>>21歳以上</option>
                                            <option value="3"<c:if test="${compensation.ageLimit == '3'}">selected="selected"</c:if>>26歳以上</option>
                                        </select>
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
                tabs[0].onclick();

            </script>
            <div align="center" id="MESSAGE">
			    <c:out value="${requestScope.message }" />
			</div>
        </main>
    </body>
</html>