<!-----------------------------------------------
演習番号	：総合演習
プログラム名：エラーページ
作成日		：2022/09/08
作成者		：NarimichiHenmi/SYS
-------------------------------------------------
修正履歴(修正日：担当者；修正内容)
------------------------------------------------->

<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL用 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>エラーページ</title>
</head>
<body>
	<%-- エラーメッセージを表示 --%>
	<c:out value="${requestScope.errorMsg}" />
</body>
</html>