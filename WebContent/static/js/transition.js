/*------------------------------------------------------
 * 演習番号      :仕様書演習
 *プログラム名   :transition
 *作成日         :2022/09/08
 *作成者         :KouYamada/SYS
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
 *関数名        :戻るボタン押下時の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :新規試算入力画面に遷移する。
 *------------------------------------------------------
*/
function toNewEstimationEntryPage() {
	//１．フォーム要素を取得する。
	var formElement = document.getElementById("estimation_frm");
	//２．フォーム要素のaction属性に、
	//要求『顧客情報入力画面へ』のURLをセットした上で、
	formElement.action="./ToNewEstimation"
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
	//１．フォーム要素を取得する。
	var formElement = document.getElementById("cancel_frm");
	//２．フォーム要素のaction属性に、
	//要求『顧客情報入力画面へ』のURLをセットした上で、
	formElement.action="./ToTerminationConfirm"
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
	//１．フォーム要素を取得する。
	var formElement = document.getElementById("inquiry_frm");
	//２．フォーム要素のaction属性に、
	//要求『顧客情報入力画面へ』のURLをセットした上で、
	formElement.action="./ToQueryConfirm"
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
	//１．フォーム要素を取得する。
	var formElement = document.getElementById("accident_frm");
	//２．フォーム要素のaction属性に、
	//要求『顧客情報入力画面へ』のURLをセットした上で、
	formElement.action="./ToAccidentForm"
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
	//１．フォーム要素を取得する。
	var formElement = document.getElementById("accept_frm");
	//２．フォーム要素のaction属性に、
	//要求『顧客情報入力画面へ』のURLをセットした上で、
	formElement.action="./ToReceptionForm"
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
	//１．フォーム要素を取得する。
	var formElement = document.getElementById("recording_frm");
	//２．フォーム要素のaction属性に、
	//要求『顧客情報入力画面へ』のURLをセットした上で、
	formElement.action="./ToRecordComfirm"
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
