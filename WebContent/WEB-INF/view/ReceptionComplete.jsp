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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>事故受付完了画面</title>
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
        <form action="" id="@@@@@@@@@" method="post">
            <table class="button_table">
                <tr>
                    <!-- 入力フォーム（お名前） -->
                    <th><button type="button" onclick="toTopMenu();"
                            class="button_design_top">トップへ戻る</button></th>
                </tr>
            </table>
        </form>
        <article>
            <div class="main_roundedConer">
                <div class="main_subTitle">受付完了</div>
                <table class="confirm_table" border="1"
                    style="border-collapse: collapse">
                    <tr>
                        <td class="confirm_table_headline" colspan="2">受付完了</td>
                    </tr>
                    <tr>
                        <td class="confirm_table_left">事故受付番号</td>
                        <td><c:out
                                value="${requestScope.accidentReception.getClaimNo()}" /></td>
                    </tr>
                    <tr>
                        <td class="confirm_table_left">証券番号</td>
                        <td><c:out value="${requestScope.contractInfo.getPolNo()}" /></td>
                    </tr>
                    <tr>
                        <td class="confirm_table_left">契約者名</td>
                        <td><c:out
                                value="${requestScope.contractInfo.getNameForLabel()}" /></td>
                    </tr>
                    <tr>
                        <td class="confirm_table_left">支払金額</td>
                        <td><c:out
                                value="${requestScope.accidentReception.getPaymentPriceForlabel()}" /></td>
                    </tr>
                </table>
            </div>
        </article>
    </main>
    <footer>
        <div class="footer_title">Handy</div>
    </footer>
</body>
</html>