<!-- ---------------------------------------------------------------------------------------
演習番号		：総合演習
プログラム名	：事故受付完了画面
作成日			：2022/09/07
作成者			：SYS KEINA NOGUCHI
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
<title>Insert title here</title>
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
		<div class="sample-area">
			<div id="tabbody">
				<div id="tabpage1">
				<tr>
						<th><button type="button" onclick="toTopMenu();">トップへ戻る</button></th>
					</tr>
					<form id="mailformpro" action="mailformpro/mailformpro.cgi"
						method="POST">
						<table border="0" cellspacing="0" cellpadding="0">
							<tr>
								 <div id="tabpage2">
									<h1>事故受付完了</h1>
									<table border="1" width="80%">
										<tr>
											<td colspan="2">事故受付完了</td>
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
										<tr>
											<td>支払金額</td>
											<td>10,000円</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</main>
</body>
</html>