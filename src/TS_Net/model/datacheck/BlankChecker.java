/*----------------------------------------------------------------------
 * 演習番号	：総合演習
 * クラス名	：PolNoChecker
 * 作成日	：2022/08/09
 * 作成者	：TooruNakaya/SYS
 * ----------------------------------------------------------------------
 *修正履歴（修正日：担当者：修正内容）
 * ----------------------------------------------------------------------
 */
package TS_Net.model.datacheck;

import TS_Net.model.constant.ErrorMsgConst;

public class BlankChecker {

	/**
	 * ブランクチェック(0002)メソッド。
	 * <p>
	 *引数で渡された文字列が空文字またはnullの場合に
	 *エラーメッセージを返す。
	 *そうでない場合はNullを返す。
	 * </p>
	 */
	public String blankCheck(String string) {

		if((string == null) || ("".equals(string))){

			return ErrorMsgConst.FORM_ERROR0002;

		}else {
		return null;
		}
	}


}
