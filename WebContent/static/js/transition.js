/*------------------------------------------------------
 * 演習番号      :仕様書演習
 *プログラム名   :transition
 *作成日         :2022/09/08
 *作成者         :KouYamada/SYS
 *------------------------------------------------------
 * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
 * (2022/09/13 ： NarimichiHenmi/SYS ：入力フォームのチェック機能を追加。現在はログイン、計上、照会、解約)
 * (2022/09/13 ： NarimichiHenmi/SYS ：ログインからTOPメニューへの遷移の関数をlogin.jsからtransition.jsに移動)
 *------------------------------------------------------
*/


/**
 *------------------------------------------------------
 *関数名        :申込書印刷ボタン押下時の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :申し込み印刷確認画面に遷移する。
 *------------------------------------------------------
*/
function toApplicationConfirmPage() {
	//１．フォーム要素を取得する。
	var formElement = document.getElementById("application_frm");
	//２．フォーム要素のaction属性に、
	//要求『顧客情報入力画面へ』のURLをセットした上で、
	formElement.action = "./ToPrintingConfirm"
	//submit関数を呼び出す。
	formElement.submit();
}

/**
 *------------------------------------------------------
 *関数名        :印刷ボタン押下後の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :申込書印刷完了画面へ遷移する。
 *------------------------------------------------------
*/

function toFinishPrintPage() {
	//１．フォーム要素を取得する。
	var formElement = document.getElementById("finishprint_frm");
	//２．フォーム要素のaction属性に、
	//要求『顧客情報入力画面へ』のURLをセットした上で、
	formElement.action =  "./ToPrintingComplete"
	//submit関数を呼び出す。
	formElement.submit();
}
/**
 *------------------------------------------------------
 *関数名        :次へボタン押下時の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :解約確認画面に遷移
 *------------------------------------------------------
*/
function toNextPage() {
	//１．メッセージを宣言
	var message = "";

	//２．証券番号の入力値を格納
	var polNo = document.getElementById("polNo").value;

	//３．IDまたはパスワードが未入力の場合、メッセージに以下を格納
	if (polNo.length == 0) {
		message += "<p>必須項目が未入力です。</p>";
	}

	//４．メッセージが設定された場合、メッセージを表示し、送信中止
	if (message != "") {
		var targetDiv = document.getElementById("FORM_ERROR");
		targetDiv.innerHTML = message;
		return false;
	}

	//５．フォーム要素を取得する。
	var formElement = document.getElementById("cancel_frm");

	//６．フォーム要素のaction属性に、
	//要求『解約確認画面へ』のURLをセットした上で、
	formElement.action =  "./ToTerminationConfirm"

	//７．submit関数を呼び出す。
	formElement.submit();
}
/**
 *------------------------------------------------------
 *関数名        :解約申込書印刷ボタン押下時の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :解約申込書印刷完了画面に遷移
 *------------------------------------------------------
*/
function toFinishPrintCancelPage() {
	//１．フォーム要素を取得する。
	var formElement = document.getElementById("cancelconfirm_frm");
	//２．フォーム要素のaction属性に、
	//要求『顧客情報入力画面へ』のURLをセットした上で、
	formElement.action =  "./ToTerminationApplication"
	//submit関数を呼び出す。
	formElement.submit();
}
/**
 *------------------------------------------------------
 *関数名        :照会検索ボタン押下時の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :契約内容照会画面へ遷移
 *------------------------------------------------------
*/
function toInquiryconfirmPage() {
	//１．メッセージを宣言する。
	var message = "";

	//２．証券番号の入力値を格納する。
	var polNo = document.getElementById("polNo").value;

	//３．IDまたはパスワードが未入力の場合、以下を格納する。
	if (polNo.length == 0) {
		message += "<p>必須項目が未入力です。</p>";
	}

	//４．メッセージが設定された場合、メッセージを表示し、送信中止する。
	if (message != "") {
		var targetDiv = document.getElementById("FORM_ERROR");
		targetDiv.innerHTML = message;
		return false;
	}

	//５．フォーム要素を取得する。
	var formElement = document.getElementById("inquiry_frm");

	//６．フォーム要素のaction属性に、
	//要求『契約内容照会画面へ』のURLをセットした上で、
	formElement.action = "./ToQueryConfirm"

	//７．submit関数を呼び出す。
	formElement.submit();
}

/**
 *------------------------------------------------------
 *関数名        :受付開始ボタン押下時の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :事故受け付け入力画面に遷移。
 *------------------------------------------------------
*/
function toTypeAccidentPage() {
	//１．メッセージを宣言
	var message = "";

	//２．証券番号の入力値を格納
	var polNo = document.getElementById("polNo").value;

	//３．証券番号の入力値を格納
	var claimNo = document.getElementById("claimNo").value;

	//４．IDまたはパスワードが未入力の場合、メッセージに以下を格納
	if (polNo.length == 0 && claimNo.length == 0) {
		message += "<p>証券番号または受付番号が未入力です。</p>";
	}

	//５．メッセージが設定された場合、メッセージを表示し、送信中止
	if (message != "") {
		var targetDiv = document.getElementById("FORM_ERROR");
		targetDiv.innerHTML = message;
		return false;
	}

	//６．フォーム要素を取得する。
	var formElement = document.getElementById("accident_frm");

	//７．フォーム要素のaction属性に、
	//要求『顧客情報入力画面へ』のURLをセットした上で、
	formElement.action = "./ToAccidentForm"

	//８．submit関数を呼び出す。
	formElement.submit();
}
/**
 *------------------------------------------------------
 *関数名        :状況更新ボタン押下時の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :状況更新完了画面に遷移
 *------------------------------------------------------
*/
function toFinishUpdatePage() {
	//１．フォーム要素を取得する。
	var formElement = document.getElementById("update_frm");
	//２．フォーム要素のaction属性に、
	//要求『顧客情報入力画面へ』のURLをセットした上で、
	formElement.action =  "./ToUpdateForm"
	//submit関数を呼び出す。
	formElement.submit();
}
/**
 *------------------------------------------------------
 *関数名        :事故受付完了ボタン押下時の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :事故受付完了画面へ遷移。
 *------------------------------------------------------
*/
function toFinishAcceptPage() {
	//１．フォーム要素を取得する。
	var formElement = document.getElementById("accept_frm");
	//２．フォーム要素のaction属性に、
	//要求『顧客情報入力画面へ』のURLをセットした上で、
	formElement.action  = "./ToReceptionForm"
	//submit関数を呼び出す。
	formElement.submit();
}
/**
 *------------------------------------------------------
 *関数名        :前の画面へ戻るボタン押下時の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :事故受付開始画面に遷移。
 *------------------------------------------------------
*/
function toreturnReceptionPage() {
	//TODO
	location.href = "./ToStartAccidentForm"
}
/**
 *------------------------------------------------------
 *関数名        :計上開始ボタン押下時の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :計上確認画面に遷移。
 *------------------------------------------------------
*/
function toRecordingPage() {
	//１．メッセージを宣言する。
	var message = "";
	//２．証券番号の入力値を格納する。
	var insatsuRenban = document.getElementById("insatsuRenban").value;

	//３．IDまたはパスワードが未入力の場合、以下を格納する。
	if (insatsuRenban.length == 0) {
		message += "<p>必須項目が未入力です。</p>";
	}

	//４．メッセージが設定された場合、メッセージを表示し、送信中止する。
	if (message != "") {
		var targetDiv = document.getElementById("FORM_ERROR");
		targetDiv.innerHTML = message;
		return false;
	}

	//５．フォーム要素を取得する。
	var formElement = document.getElementById("recording_frm");

	//６．フォーム要素のaction属性に、
	//要求『顧客情報入力画面へ』のURLをセットした上で、
	formElement.action = "./ToRecordComfirm"

	//７．submit関数を呼び出す。
	formElement.submit();
}
/**
 *------------------------------------------------------
 *関数名        :代理店計上ボタン押下時の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :計上完了画面へ遷移。
 *------------------------------------------------------
*/
function toFinishRecordPage() {
	//TODO
	location.href = "./ToRecordComplete"
}
/**
 *------------------------------------------------------
 *関数名        :ログインボタン押下時の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :TOPメニュー画面に遷移する。
 *------------------------------------------------------
*/

function loginProcess() {
	//１．メッセージを宣言する。
	var message = "";
	//２．IDの入力値を格納する
	var iD = document.getElementById("iD").value;
	//３．パスワードの入力値を格納する。
	var password = document.getElementById("password").value;


	//４．IDまたはパスワードが未入力の場合、メッセージに以下を格納する。
	if (iD.length == 0 || password.length == 0) {
		message += "<p>IDまたはパスワードが未入力です。</p>";
	}

	//５．メッセージが設定された場合、メッセージを表示し、送信中止する。
	if (message != "") {
		var targetDiv = document.getElementById("FORM_ERROR");
		targetDiv.innerHTML = message;
		return false;
	}

	/* ６．フォーム要素を取得する。 */
	var formElement = document.getElementById("login_process");

	/*
	 * ７．フォーム要素のaction属性に
	 * 要求「TOPメニューへ」のurlをセットしたうえで
	 */
	formElement.action = "./loginProcess"

	/* ８．submit関数を呼び出す。 */
	formElement.submit();
}
/**
 *------------------------------------------------------
 *関数名        :新規試算ボタン押下時の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :新規試算入力画面に遷移
 *------------------------------------------------------
*/
function toTopNew() {
	location.href = "./toTopNew"
}
/**
 *------------------------------------------------------
 *関数名        :計上へボタン押下時の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :計上開始画面に遷移
 *------------------------------------------------------
*/
function toTopRecording() {
	location.href = "./toTopRecording"
}
/**
 *------------------------------------------------------
 *関数名        :契約内容照会へボタン押下時の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :照会画面に遷移
 *------------------------------------------------------
*/
function toTopInquiry() {
	location.href = "./toTopInquiry"
}
/**
 *------------------------------------------------------
 *関数名        :解約へボタン押下時の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :解約開始画面に遷移
 *------------------------------------------------------
*/
function toTopCancel() {
	location.href = "./toTopCancel"

}
/**
 *------------------------------------------------------
 *関数名        :事故受付へボタン押下時の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :事故受け付け画面に遷移
 *------------------------------------------------------
*/
function toTopAccept() {
	location.href = "./toTopAccept"
}
/**
 *------------------------------------------------------
 *関数名        :TOPメニューへボタン押下時の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :TOPメニュー画面に遷移
 *------------------------------------------------------
*/
function toTopMenu() {
	location.href = "./toTopMenu"
}