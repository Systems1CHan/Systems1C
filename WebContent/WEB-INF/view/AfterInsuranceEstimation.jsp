<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>保険料試算後画面</title>
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
        	<form action="" method="get" name="hoshoForm" id="application_frm">
                        <h1>新規試算入力（補償タブ）</h1>
                        <table border="1" width="80%">
                            <tbody>
                                <tr>
                                    <td colspan="2">自動車保険料試算結果</td>
                                </tr>
                                <tr>
                                    <td>総額保険料</td>
                                    <td>
                                    	<c:out value="${sessionScope.compensation.getPremiumAmountForLabel()}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td>一回分保険料</td>
                                    <td>
                                    	<c:out value="${sessionScope.compensation.getPremiumInstallmentForLabel()}" />
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <table id="secondBox" width="2500">
                            <tbody>
                                <tr>
                                    <th>メーカー</th>
                                    <td>
                                    	<c:out value="${sessionScope.compensation.maker}" />
                                    </td>
                                </tr>

                                <tr>
                                    <th>車名</th>
                                    <td>
                                    	<c:out value="${sessionScope.compensation.carName}" />
                                    </td>
                                </tr>
                                <tr>
                                    <th>車両保険金額</th>
                                    <td>
                                        <c:out value="${sessionScope.compensation.vehiclePrice}" />
                                    </td>
                                </tr>
                                <tr>
                                    <th>料率・車両</th>
                                    <td>
                                        <c:out value="${sessionScope.compensation.getVehicleRatesForLabel()}" />
                                    </td>
                                </tr>
                                <tr>
                                    <th>料率・対人</th>
                                    <td>
                                        <c:out value="${sessionScope.compensation.getBodilyRatesForLabel()}" />
                                    </td>
                                </tr>
                                <tr>
                                    <th>料率・対物</th>
                                    <td>
                                        <c:out value="${sessionScope.compensation.getPropertyDamageRatesForLabel()}" />
                                    </td>
                                </tr>
                                <tr>
                                    <th>料率・車両</th>
                                    <td>
                                        <c:out value="${sessionScope.compensation.getAccidentRatesForLabel()}" />
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="licenseNo">車のナンバー</label>
                                    </th>
                                    <td>
                                        <c:out value="${sessionScope.compensation.licenseNo}" />
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="licenseColor">免許証の色</label>
                                    </th>
                                    <td>
                                    	<c:out value="${sessionScope.compensation.getLicenseColorForLabel()}" />
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="ageLimit">年齢条件</label>
                                    </th>
                                    <td>
                                    	<c:out value="${sessionScope.compensation.getAgeLimitForLabel()}" />
                                    </td>
                                </tr>
                            </tbody>
                        </table>
        	</form>
        </main>
	</body>
</html>