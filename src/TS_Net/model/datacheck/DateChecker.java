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

import java.text.SimpleDateFormat;
import java.util.Calendar;

import TS_Net.model.constant.ErrorMsgConst;

/**
 * 日付データチェッククラス。
 * <p>
 * 入力された日付をチェックする。
 * </p>
 * @author RyoIsogami/SYS 2022/09/12
 */
public class DateChecker {
	/**
	 * 保険期間始期日チェックメソッド。
	 * <p>
	 * 引数で渡された保険期間始期日に対してチェックを行い、エラーメッセージを返却する。
	 * チェック内容は、保険期間始期日が過去の日付ではないかをチェックする。
	 * チェック結果がOKであれば、null値を返却する。
	 * </p>
	 * @param inceptionDate 保険期間始期日
	 * @return ErrorMagConst.FORM_ERROR0014 日付が不適切である場合のエラーメッセージ
	 * @return null null値
	 */
	public String inceptionDateCheck(String inceptionDate) {

		//保険期間始期日の取得
		int id = Integer.parseInt(inceptionDate);

		//現在日時の取得
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		int nowTime = Integer.parseInt(sdf.format(calendar.getTime()));

		if(id < nowTime) {
			return ErrorMsgConst.FORM_ERROR0014;
		}else {
			return null;
		}
	}

	/**
	 * 保険期間満期日チェックメソッド。
	 * <p>
	 * 引数で渡された保険期間満期日に対してチェックを行い、エラーメッセージを返却する。
	 * チェック内容は、保険期間満期日が過去の日付ではないかをチェックする。
	 * チェック結果がOKであれば、null値を返却する。
	 * </p>
	 * @param conclusionDate 保険期間満期日
	 * @return ErrorMagConst.FORM_ERROR0014 日付が不適切である場合のエラーメッセージ
	 * @return null null値
	 */
	public String conclusionDateCheck(String conclusionDate) {

		//保険期間始期日の取得
		int id = Integer.parseInt(conclusionDate);

		//現在日時の取得
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		int nowTime = Integer.parseInt(sdf.format(calendar.getTime()));

		if(id < nowTime) {
			return ErrorMsgConst.FORM_ERROR0014;
		}else {
			return null;
		}
	}

	/**
	 * 生年月日チェックメソッド。
	 * <p>
	 * 引数で渡された生年月日に対してチェックを行い、エラーメッセージを返却する。
	 * チェック内容は、生年月日が過去の日付ではないか、現在18歳以上かをチェックする。
	 * チェック結果がOKであれば、null値を返却する。
	 * </p>
	 * @param birthday 生年月日
	 * @return ErrorMagConst.FORM_ERROR0014 日付が不適切である場合のエラーメッセージ
	 * @return null null値
	 */
	public String birthdayCheck(String bitrhday) {

		//生年月日の取得
		int bd = Integer.parseInt(bitrhday);

		//現在日時の取得
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		int nowTime = Integer.parseInt(sdf.format(calendar.getTime()));

		if(bd > nowTime) {
			return ErrorMsgConst.FORM_ERROR0014;
		}else if((nowTime - bd) < 80000) {
			return ErrorMsgConst.FORM_ERROR0014;
		}else {
			return null;
		}
	}

	/**
	 * 事故発生日時チェックメソッド。
	 * <p>
	 * 引数で渡された事故発生日時に対してチェックを行い、エラーメッセージを返却する。
	 * チェック内容は、事故発生日時が保険期間始期日と保険期間満期日の間にあるかをチェックする。
	 * チェック結果がOKであれば、null値を返却する。
	 * </p>
	 * @param accidentDate 事故発生日時
	 * @param inceptionDate 保険期間始期日
	 * @param conclusionDate 保険期間満期日
	 * @return ErrorMagConst.FORM_ERROR0014 日付が不適切である場合のエラーメッセージ
	 * @return null null値
	 */
	public String accidentDateCheck(String accidentDate, String inceptionDate, String conclusionDate) {

		//事故発生日時の取得
		int ad = Integer.parseInt(accidentDate);
		//保険期間始期日の取得
		int id = Integer.parseInt(inceptionDate);
		//保険期間満期日の取得
		int cd = Integer.parseInt(conclusionDate);

		if(ad > id && cd > id) {
			return null;
		}else {
			return ErrorMsgConst.FORM_ERROR0014;
		}
	}
}
