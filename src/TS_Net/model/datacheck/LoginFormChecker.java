/*------------------------------------------------------------------------------
 * 演習番号：[総合演習]
 * クラス名：[LoginFormChecker]
 * 作成日  ：[2022/09/08]
 * 作成者  ：[NarimichiHenmi/SYS]
 *------------------------------------------------------------------------------
 * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
 *------------------------------------------------------------------------------
 */

package TS_Net.model.datacheck;

/**
 * ログインフォーム項目チェッククラス
 * <p>
 * ログイン項目をチェックする。チェック内容は以下の通り
 * ・空欄チェック
 * ・IDとパスワードが正しいかチェック
 * </p>
 * @author NarimichiHenmi/SYS 2022/09/08
 *
 */

public class LoginFormChecker {

	/** 引数なしコンストラクタ */
	public LoginFormChecker() {
	};

	/**
	 * 空白チェックメソッド
	 * <p>
	 * IDとパスワードのうち、どちらか一つでも未入力の場合は、「未入力の項目があります。入力内容をご確認ください。」を返す
	 * </p>
	 * @param iD  ID
	 * @param password  パスワード
	 * @return エラーメッセージ。未入力がなければnullを、未入力があれば「未入力の項目が・・・」
	 */
	public String emptyCheck(String iD, String password) {
		// TODO 自動生成されたメソッド・スタブ
		String msg = "";

		if (iD == null || iD.length() == 0) {
			msg = "IDまたはパスワードが未入力です。";
		} else if (password == null || password.length() == 0) {
			msg = "IDまたはパスワードが未入力です。";
		} else {
			msg = null;
		}

		return msg;
	}

	/**
	 * アカウントチェックメソッド
	 * <p>
	 * IDとパスワードの組がDBに存在するかをチェック
	 * IDとパスワードの組が存在しない場合、「未入力の項目があります。入力内容をご確認ください。」を返す
	 * </p>
	 * @param iD  ID
	 * @param password  パスワード
	 * @return エラーメッセージ。未入力がなければnullを、未入力があれば「未入力の項目が・・・」
	 */
	public String accountCheck(boolean loginState) {
		// TODO 自動生成されたメソッド・スタブ
		String msg = "";

		if(loginState == false) {
			msg = "IDまたはパスワードに誤りがあります。";
		}else {
			msg = null;
		}

		return msg;
	}
}
