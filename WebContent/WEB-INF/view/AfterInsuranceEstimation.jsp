<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>保険料試算後画面</title>
		<style type="text/css">
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
        	<form action="" method="post" id="application_frm2">
        	<button type="button" onclick="toTopMenu();" class="btn">トップへ戻る</button>
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
                                    	<c:out value="${compensation.maker}" />
                                    </td>
                                </tr>

                                <tr>
                                    <th>車名</th>
                                    <td>
                                    	<c:out value="${compensation.carName}" />
                                    </td>
                                </tr>
                                <tr>
                                    <th>車両保険金額</th>
                                    <td>
                                        <c:out value="${compensation.vehiclePrice}" />
                                    </td>
                                </tr>
                                <tr>
                                    <th>料率・車両</th>
                                    <td>
                                        <c:out value="${compensation.getVehicleRatesForLabel()}" />
                                    </td>
                                </tr>
                                <tr>
                                    <th>料率・対人</th>
                                    <td>
                                        <c:out value="${compensation.getBodilyRatesForLabel()}" />
                                    </td>
                                </tr>
                                <tr>
                                    <th>料率・対物</th>
                                    <td>
                                        <c:out value="${compensation.getPropertyDamageRatesForLabel()}" />
                                    </td>
                                </tr>
                                <tr>
                                    <th>料率・車両</th>
                                    <td>
                                        <c:out value="${compensation.getAccidentRatesForLabel()}" />
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="licenseNo">車のナンバー</label>
                                    </th>
                                    <td>
                                        <c:out value="${compensation.licenseNo}" />
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="licenseColor">免許証の色</label>
                                    </th>
                                    <td>
                                    	<c:out value="${compensation.getLicenseColorForLabel()}" />
                                    </td>
                                </tr>
                                <tr>
                                    <th scope="row">
                                        <label for="ageLimit">年齢条件</label>
                                    </th>
                                    <td>
                                    	<c:out value="${compensation.getAgeLimitForLabel()}" />
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <table align="center">
                            <tr>
                                <td>
                                    <button type="button" class="btn">保険料試算</button>
                                </td>
                                <td>
                                    <button type="button" class="btn" onclick="toApplicationConfirmPage();">申込書印刷</button>
                                </td>
                            </tr>
                        </table>
        	</form>
        </main>
	</body>
</html>