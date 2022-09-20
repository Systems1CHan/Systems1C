package TS_Net.model.datacheck;

import TS_Net.model.data.AccidentReception;
import TS_Net.model.data.ContractInfo;
import TS_Net.model.constant.ErrorMsgConst;

/**
 * チェックメソッド。
 * <p>
 * 引数で渡された入力情報に対してチェックを行い、エラーメッセージを返却する。
 * チェック結果がOKであれば、null値を返却する。
 * </p>
 * @param ci 契約情報
 * @return ErrorMsgConst.FORM_ERROR0002 フォームに未入力項目がある場合のエラーメッセージ
 * @return null null値
 */
public class TextTypeCheker {

	/*
	 * 半角数字のはずが、全角で入力されている（各データクラス）
	 * 全角カナ→半角になっている（契約情報）
	 * 半角英数→全角（契約情報）
	 */

	/**
	 * 半角英数字チェックメソッド（契約情報）。
	 * <p>
	 * 引数で渡された入力情報に対してチェックを行い、エラーメッセージを返却する。
	 * チェック結果がOKであれば、null値を返却する。
	 * </p>
	 * @param contractInfo 契約情報オブジェクト
	 * @return ErrorMagConst.FORM_ERROR0014 日付が不適切である場合のエラーメッセージ
	 * @return null null値
	 */
	public String textHalfwidthCheck(ContractInfo ci) {
		//正規表現(半角英数字)
		final String HAS_HALF_ALPHANUMERIC = "^[0-9a-zA-Z]+$";

		if(!(ci.getPostcode().matches(HAS_HALF_ALPHANUMERIC))) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(!(ci.getTelephoneNo().matches(HAS_HALF_ALPHANUMERIC))) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(!(ci.getMobilephoneNo().matches(HAS_HALF_ALPHANUMERIC))) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(!(ci.getFaxNo().matches(HAS_HALF_ALPHANUMERIC))) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else {
			return null;
		}
	}

	/**
	 * 半角英数字チェックメソッド（補償情報）。
	 * <p>
	 * 引数で渡された入力情報に対してチェックを行い、エラーメッセージを返却する。
	 * チェック結果がOKであれば、null値を返却する。
	 * </p>
	 * @param compensation 補償情報オブジェクト
	 * @return ErrorMagConst.FORM_ERROR0014 日付が不適切である場合のエラーメッセージ
	 * @return null null値
	 */
	public String textHalfwidthCheck(Integer vehiclePrice) {

		String value = String.valueOf(vehiclePrice);

		int len = value.length();
		byte[] bytes = value.getBytes();

		if( len != bytes.length) {
			return ErrorMsgConst.FORM_ERROR0003;
		}else {
			return null;
		}
	}

	/**
	 * 半角英数字チェックメソッド（事故受付情報）。
	 * <p>
	 * 引数で渡された入力情報に対してチェックを行い、エラーメッセージを返却する。
	 * チェック結果がOKであれば、null値を返却する。
	 * </p>
	 * @param accidentReception 事故受付情報オブジェクト
	 * @return ErrorMagConst.FORM_ERROR0014 日付が不適切である場合のエラーメッセージ
	 * @return null null値
	 */
	public String textHalfwidthCheck(AccidentReception ac) {

		//損害額・車両
		String value1 = String.valueOf(ac.getDamageCarPrice());
		int len1 = value1.length();
		byte[] bytes1 = value1.getBytes();

		//損害額・対人
		String value2 = String.valueOf(ac.getDamageBodilyPrice());
		int len2 = value2.length();
		byte[] bytes2 = value2.getBytes();

		//損害額・対物
		String value3 = String.valueOf(ac.getDamagePropertyPrice());
		int len3 = value3.length();
		byte[] bytes3 = value3.getBytes();

		//損害額・傷害
		String value4 = String.valueOf(ac.getDamageAccidentPrice());
		int len4 = value4.length();
		byte[] bytes4 = value4.getBytes();

		if(len1 != bytes1.length) {
			return ErrorMsgConst.FORM_ERROR0003;
		}else if(len2 != bytes2.length) {
			return ErrorMsgConst.FORM_ERROR0003;
		}else if(len3 != bytes3.length) {
			return ErrorMsgConst.FORM_ERROR0003;
		}else if(len4 != bytes4.length) {
			return ErrorMsgConst.FORM_ERROR0003;
		}else {
			return null;
		}
	}

	/**
	 * 全角カナチェックメソッド（契約情報）。
	 * <p>
	 * 引数で渡された入力情報に対してチェックを行い、エラーメッセージを返却する。
	 * チェック結果がOKであれば、null値を返却する。
	 * </p>
	 * @param contractInfo 契約情報オブジェクト
	 * @return ErrorMagConst.FORM_ERROR0014 日付が不適切である場合のエラーメッセージ
	 * @return null null値
	 */
	public String textFullwidthCheck(ContractInfo ci) {
		//全て全角カナかどうか
		final String IS_FULL_KANA = "^[\\u30A0-\\u30FF]+$";

		if(!(ci.getNameKana1().matches(IS_FULL_KANA))) {
			return ErrorMsgConst.FORM_ERROR0013;
		}else if(!(ci.getNameKana2().matches(IS_FULL_KANA))) {
			return ErrorMsgConst.FORM_ERROR0013;
		}else if(!(ci.getAddressKana1().matches(IS_FULL_KANA))) {
			return ErrorMsgConst.FORM_ERROR0013;
		}else if(!(ci.getAddressKana2().matches(IS_FULL_KANA))) {
			return ErrorMsgConst.FORM_ERROR0013;
		}else {
			return null;
		}
	}

	/**
	 * 半角英数字チェックメソッド（番号系）。
	 * <p>
	 * 引数で渡された入力情報に対してチェックを行い、エラーメッセージを返却する。
	 * チェック結果がOKであれば、null値を返却する。
	 * </p>
	 * @param contractInfo 契約情報オブジェクト
	 * @return ErrorMagConst.FORM_ERROR0014 日付が不適切である場合のエラーメッセージ
	 * @return null null値
	 */
	public String textHalfwidthCheck(String str) {
		final String HAS_HALF_ALPHANUMERIC = "^[0-9a-zA-Z]+$";

		if(!(str.matches(HAS_HALF_ALPHANUMERIC))) {
			return ErrorMsgConst.FORM_ERROR0003;
		}else {
			return null;
		}
	}
}
