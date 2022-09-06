/**
 *
 */

function loginProcess(){

	/* 1.フォーム要素を取得する。 */
	var formElement = document.getElementById("login_process");

	/*
	 * 2.フォーム要素のaction属性に
	 * 要求「顧客情報入力画面へ」のurlをセットしたうえで
	 */
	formElement.action = "./loginProcess"

	/* submit関数を呼び出す。 */
	formElement.submit();
}

function toContractForm(){

	/* 1.フォーム要素を取得する。 */
	var formElement = document.getElementById("result_frm");

	/*
	 *	2.フォーム要素のaction属性に
	 *	要求「契約情報入力画面へ」のurlをセットしたうえで
	 */
	formElement.action = "./toContractForm"

	/* submit関数を呼び出す。 */
	formElement.submit();

}

function reserve(){

	/* 1.フォーム要素を取得する。 */
	var formElement = document.getElementById("result_frm");

	/*
	 *	2.フォーム要素のaction属性に
	 *	要求「予約情報一覧画面へ」のurlをセットしたうえで
	 */
	formElement.action = "./resultPage"

	/* submit関数を呼び出す。 */
	formElement.submit();

}


function toStartPage(){

	location.href = "./toStartPage";

}