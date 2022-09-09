/*------------------------------------------------------
 * 演習番号      :仕様書演習
 *プログラム名   :login
 *作成日         :2022/09/07
 *作成者         :NarimichiHenmi/SYS
 *------------------------------------------------------
 * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
 * (2022/09/09 ： NarimichiHenmi/SYS ：IDとパスワードのフォームを変更)
 *------------------------------------------------------
*/

/**
 *------------------------------------------------------
 *関数名        :ログインボタン押下時の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :TOPメニュー画面に遷移する。
 *------------------------------------------------------
*/
function loginProcess() {

	/* 1.フォーム要素を取得する。 */
	var formElement = document.getElementById("login_process");

	/*
	 * 2.フォーム要素のaction属性に
	 * 要求「TOPメニューへ」のurlをセットしたうえで
	 */
	formElement.action = "./loginProcess"

	/* 3.submit関数を呼び出す。 */
	formElement.submit();
}

/**
 *------------------------------------------------------
 *関数名        :パスワードフォーム内の目玉ボタン押下時の処理
 *引数          :なし
 *戻り値        :なし
 *機能          :パスワードフォーム内の文字の見える見えないとそれに対応した目玉の画像をセットする。
 *------------------------------------------------------
*/
function pushHideButton() {

	/* 1.フォーム要素を取得する。 */
	var txtPass = document.getElementById("textPassword");
	var btnEye = document.getElementById("buttonEye");

	/* 2.パスワードのtype属性がtextの場合とそれ以外の場合で、パスワードのtype属性と目玉の画像を切り替える。 */
	if (txtPass.type === "text") {
		txtPass.type = "password";
		btnEye.className = "fa fa-eye-slash";
	} else {
		txtPass.type = "text";
		btnEye.className = "fa fa-eye";
	}
}