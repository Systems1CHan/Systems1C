package TS_Net.model.datacheck;

import TS_Net.model.constant.ErrorMsgConst;

public class BlankChecker {

	/**
	 * 証券番号・事故受付番号入力チェック(0001)メソッド。
	 * <p>
	 *契約情報オブジェクトの証券番号、
	 *事故受付情報オブジェクトの事故受付番号
	 *がともに入力されていた場合、エラーメッセージを返却する。
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
