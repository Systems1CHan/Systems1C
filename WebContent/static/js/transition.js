/*------------------------------------------------------
 * 演習番号      :仕様書演習
 *プログラム名   :transition
 *作成日         :2022/09/08
 *作成者         :KouYamada/SYS
 *------------------------------------------------------
 * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
 * (2022/09/13 ： NarimichiHenmi/SYS ：入力フォームのチェック機能を追加。現在はログイン、計上、照会、解約)
 * (2022/09/13 ： NarimichiHenmi/SYS ：ログインからTOPメニューへの遷移の関数をlogin.jsからtransition.jsに移動)
 * (2022/09/20 ： NarimichiHenmi/SYS ：クライアントチェックの実装（新規試算以外）)
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
	formElement.action="./ToPrintingConfirm"
	//submit関数を呼び出す。
	formElement.submit();
}

/**
 *------------------------------------------------------
 *関数名        :戻るボタン押下後の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :新規試算入力画面へ遷移する。
 *------------------------------------------------------
*/

function toNewEstimationEntryPage() {
	//１．フォーム要素を取得する。
	var formElement = document.getElementById("finishprint_frm");
	//２．フォーム要素のaction属性に、
	//要求『顧客情報入力画面へ』のURLをセットした上で、
	formElement.action="./ToNewEstimation"
	//submit関数を呼び出す。
	formElement.submit();
}

/**
 *------------------------------------------------------
 *関数名        :保険料試算ボタン押下後の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :保険料試算後画面へ遷移する。
 *------------------------------------------------------
*/

function toAfterEstimationPage(param1) {
	//１．フォーム要素を取得する。
	var formElement = document.getElementById("application_frm");

	var names = document.getElementsByName("buttonValue");
	names[0].value = param1;
	//２．フォーム要素のaction属性に、
	//要求『顧客情報入力画面へ』のURLをセットした上で、
	formElement.action="./InsuranceEstimation"
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
	formElement.action="./ToPrintingComplete"
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
	//１．messageを宣言
	var message = "";

	//２．証券番号の入力値を格納
	var polNo = document.getElementById("polNo").value;

	//３．IDまたはパスワードが未入力の場合、messageに以下を格納
	if (polNo.length == 0) {
		message += "<p>必須項目が未入力です。</p>";
	}

	//４．messageが設定された場合、messageを表示し、送信中止
	if (message != "") {
		var targetDiv = document.getElementById("FORM_ERROR");
		targetDiv.innerHTML = message;
		return false;
	}

	//５．フォーム要素を取得する。
	var formElement = document.getElementById("cancel_frm");

	//６．フォーム要素のaction属性に、
	//要求『解約確認画面へ』のURLをセットした上で、
	formElement.action = "./ToTerminationConfirm"

	//submit関数を呼び出す。
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
	formElement.action="./ToTerminationApplication"
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
	//１．messageを宣言する。
	var message = "";

	//２．証券番号の入力値を格納する。
	var polNo = document.getElementById("polNo").value;

	//３．IDまたはパスワードが未入力の場合、messageに以下を格納する。
	if (polNo.length == 0) {
		message += "<p>必須項目が未入力です。</p>";
	}

	//４．messageが設定された場合、messageを表示し、送信中止する。
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

	//submit関数を呼び出す。
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
	//１．messageを宣言
	var message = "";

	//２．証券番号の入力値を格納
	var polNo = document.getElementById("polNo").value;

	//３．証券番号の入力値を格納
	var claimNo = document.getElementById("claimNo").value;

	//４．証券番号と受付番号の両方が未入力の場合、messageに以下を格納
	if (polNo.length == 0 && claimNo.length == 0) {
		message += "<p>証券番号または受付番号が未入力です。</p>";
	}

	//５．messageが設定された場合、messageを表示し、送信中止
	if (message != "") {
		var targetDiv = document.getElementById("FORM_ERROR");
		targetDiv.innerHTML = message;
		return false;
	}

	//６．フォーム要素を取得する。
	var formElement = document.getElementById("accident_frm");

	//７．フォーム要素のaction属性に、
	//要求『事故受付入力画面へ』のURLをセットした上で、
	formElement.action = "./ToReceptionInput"

	//submit関数を呼び出す。
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
	formElement.action="./ToUpdateForm"
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
	//１．messageを宣言
	var message = "";

	//２．事故受付入力(事故受付タブ)の入力値をすべて格納
	var accidentdate = document.getElementById("accidentdate").value;
	var accidentlocationkanji1 = document.getElementById("accidentlocationkanji1").value;
	var accidentlocationkana1 = document.getElementById("accidentlocationkana1").value;
	var accidentlocationkanji2 = document.getElementById("accidentlocationkanji2").value;
	var accidentlocationkana2 = document.getElementById("accidentlocationkana2").value;
	var accidentsituation = document.getElementById("accidentsituation").value;
	var ratingblamemyself = document.getElementById("ratingblamemyself").value;
	var ratingblameyourself = document.getElementById("ratingblameyourself").value;
	var damagecarprice = document.getElementById("damagecarprice").value;
	var damagecarstate = document.getElementById("damagecarstate").value;
	var damagebodilyprice = document.getElementById("damagebodilyprice").value;
	var damagebodilystate = document.getElementById("damagebodilystate").value;
	var damagepropertyprice = document.getElementById("damagepropertyprice").value;
	var damagepropertystate = document.getElementById("damagepropertystate").value;
	var damageaccidentprice = document.getElementById("damageaccidentprice").value;
	var damageaccidentstate = document.getElementById("damageaccidentstate").value;


	//３．入力フォームが空白の場所を判定する。
	if (accidentdate.length == 0) {
		message = "<p>必須項目が未入力です。</p>";
		var Form_accidentdate = document.getElementById("Form_accidentdate");
		Form_accidentdate.innerHTML = message;
	}

	if (accidentlocationkanji1.length == 0) {
		message = "<p>必須項目が未入力です。</p>";
		var Form_accidentlocationkanji1 = document.getElementById("Form_accidentlocationkanji1");
		Form_accidentlocationkanji1.innerHTML = message;
	}


	if (accidentlocationkana1.length == 0) {
		message = "<p>必須項目が未入力です。</p>";
		var Form_accidentlocationkana1 = document.getElementById("Form_accidentlocationkana1");
		Form_accidentlocationkana1.innerHTML = message;
	}

	if (accidentlocationkanji2.length == 0) {
		message = "<p>必須項目が未入力です。</p>";
		var Form_accidentlocationkanji2 = document.getElementById("Form_accidentlocationkanji2");
		Form_accidentlocationkanji2.innerHTML = message;
	}

	if (accidentlocationkana2.length == 0) {
		message = "<p>必須項目が未入力です。</p>";
		var Form_accidentlocationkana2 = document.getElementById("Form_accidentlocationkana2");
		Form_accidentlocationkana2.innerHTML = message;
	}

	if (accidentsituation.length == 0) {
		message = "<p>必須項目が未入力です。</p>";
		var Form_accidentsituation = document.getElementById("Form_accidentsituation");
		Form_accidentsituation.innerHTML = message;

	}

	if (ratingblamemyself.length == 0) {
		message = "<p>必須項目が未入力です。</p>";
		var Form_ratingblamemyself = document.getElementById("Form_ratingblamemyself");
		Form_ratingblamemyself.innerHTML = message;
	}

	if (ratingblameyourself.length == 0) {
		message = "<p>必須項目が未入力です。</p>";
		var Form_ratingblameyourself = document.getElementById("Form_ratingblameyourself");
		Form_ratingblameyourself.innerHTML = message;
	}

	if (damagecarprice.length == 0) {
		message = "<p>必須項目が未入力です。</p>";
		var Form_damagecarprice = document.getElementById("Form_damagecarprice");
		Form_damagecarprice.innerHTML = message;
	}

	if (damagecarstate.length == 0) {
		message = "<p>必須項目が未入力です。</p>";
		var Form_damagecarstate = document.getElementById("Form_damagecarstate");
		Form_damagecarstate.innerHTML = message;
	}

	if (damagebodilyprice.length == 0) {
		message = "<p>必須項目が未入力です。</p>";
		var Form_damagebodilyprice = document.getElementById("Form_damagebodilyprice");
		Form_damagebodilyprice.innerHTML = message;
	}

	if (damagebodilystate.length == 0) {
		message = "<p>必須項目が未入力です。</p>";
		var Form_damagebodilystate = document.getElementById("Form_damagebodilystate");
		Form_damagebodilystate.innerHTML = message;
	}

	if (damagepropertyprice.length == 0) {
		message = "<p>必須項目が未入力です。</p>";
		var Form_damagepropertyprice = document.getElementById("Form_damagepropertyprice");
		Form_damagepropertyprice.innerHTML = message;
	}

	if (damagepropertystate.length == 0) {
		message = "<p>必須項目が未入力です。</p>";
		var Form_damagepropertystate = document.getElementById("Form_damagepropertystate");
		Form_damagepropertystate.innerHTML = message;
	}

	if (damageaccidentprice.length == 0) {
		message = "<p>必須項目が未入力です。</p>";
		var Form_damageaccidentprice = document.getElementById("Form_damageaccidentprice");
		Form_damageaccidentprice.innerHTML = message;
	}

	if (damageaccidentstate.length == 0) {
		message = "<p>必須項目が未入力です。</p>";
		var Form_damageaccidentstate = document.getElementById("Form_damageaccidentstate");
		Form_damageaccidentstate.innerHTML = message;
	}

	//４．messageが設定された場合、messageを表示し、送信中止
	if (message != "") {
		return false;
	}


	//５．フォーム要素を取得する。
	var formElement = document.getElementById("update_frm");

	//６．フォーム要素のaction属性に、
	//要求『顧客情報入力画面へ』のURLをセットした上で、
	formElement.action = "./ToReceptionForm"
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
	//１．messageを宣言する。
	var message = "";

	//２．印刷連番の入力値を格納する。
	var insatsuRenban = document.getElementById("insatsuRenban").value;

	//３．印刷連番が未入力の場合、メッセージに以下を格納する。
	if (insatsuRenban.length == 0) {
		message += "<p>必須項目が未入力です。</p>";
	}

	//４．messageが設定された場合、messageを表示し、送信中止する。
	if (message != "") {
		var targetDiv = document.getElementById("FORM_ERROR");
		targetDiv.innerHTML = message;
		return false;
	}

	//５．フォーム要素を取得する。
	var formElement = document.getElementById("recording_frm");

	//６．フォーム要素のaction属性に、
	//要求『計上画面へ』のURLをセットした上で、
	formElement.action = "./ToRecordComfirm"

	//submit関数を呼び出す。
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
 *関数名        :新規試算ボタン押下時の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :新規試算入力画面に遷移
 *------------------------------------------------------
*/
function toTopNew(){
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
 function toTopRecording(){
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
 function toTopInquiry(){
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
 function toTopCancel(){
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
 function toTopAccept(){
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
function toTopMenu(){
	location.href = "./toTopMenu"
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

	//１．messageを宣言する。
	var message = "";

	//２．IDとパスワードの入力値を格納する。
	var iD = document.getElementById("iD").value;
	var password = document.getElementById("password").value;


	//３．IDまたはパスワードが未入力の場合、messageに以下を格納する。
	if (iD.length == 0 || password.length == 0) {
		message += "<p>IDまたはパスワードが未入力です。</p>";
	}

	//４．messageが設定された場合、messageを表示し、送信中止する。
	if (message != "") {
		var targetDiv = document.getElementById("FORM_ERROR");
		targetDiv.innerHTML = message;
		return false;
	}

	//５．フォーム要素を取得する。
	var formElement = document.getElementById("login_process");

	//６．フォーム要素のaction属性に、
	//要求『TOPメニュー画面へ』のURLをセットした上で、
	formElement.action = "./loginProcess"

	//submit関数を呼び出す。
	formElement.submit();

}