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
import TS_Net.model.data.ContractInfo;

/**
 * 日付データチェッククラス。
 * <p>
 * 入力された日付をチェックする。
 * </p>
 * @author RyoIsogami/SYS 2022/09/12
 */
public class DateChecker {
	/**
	 * 保険期間始期日、満期日、生年月日チェックメソッド。
	 * <p>
	 * 引数で渡されたオブジェクトに対してチェックを行い、エラーメッセージを返却する。
	 * チェック結果がOKであれば、null値を返却する。
	 * </p>
	 * @param contractInfo 契約情報オブジェクト
	 * @return ErrorMagConst.FORM_ERROR0014 日付が不適切である場合のエラーメッセージ
	 * @return null null値
	 */
	public String inceptionDateCheck(ContractInfo ci) {

		//保険期間始期日の取得
		int inceptionDate = Integer.parseInt(ci.getInceptionDate());
		int conclusionDate = Integer.parseInt(ci.getConclusionDate());
		int birthday = Integer.parseInt(ci.getBirthday());

		//現在日時の取得
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		int nowTime = Integer.parseInt(sdf.format(calendar.getTime()));

		if(inceptionDate < nowTime) {
			return ErrorMsgConst.FORM_ERROR0014;
		}else if(conclusionDate < nowTime || conclusionDate < inceptionDate){
			return ErrorMsgConst.FORM_ERROR0015;
		}else if(birthday > nowTime) {
			return ErrorMsgConst.FORM_ERROR0016;
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
