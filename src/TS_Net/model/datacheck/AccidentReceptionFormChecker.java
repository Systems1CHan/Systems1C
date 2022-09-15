/*----------------------------------------------------------------------
 * 演習番号	：総合演習
 * クラス名	：PolNoChecker
 * 作成日	：2022/08/09
 * 作成者	：TooruNakaya/SYS
 * ----------------------------------------------------------------------
 *修正履歴（修正日：担当者：修正内容）
 *(2022/09/15 ： NarimichiHenmi/SYS ：AccidentReceptionFormChecker内のcheckメソッド。AccidentSituationに関するブランク＆nullチェックを実装)
 * ----------------------------------------------------------------------
 */
package TS_Net.model.datacheck;

import java.util.Objects;

import TS_Net.model.constant.ErrorMsgConst;
import TS_Net.model.data.AccidentReception;

/**
 * 事故受付情報項目データチェッククラス。
 * <p>
 * 事故受付情報項目をチェックする。
 * </p>
 * @author RyoIsogami/SYS 2022/09/12
 */
public class AccidentReceptionFormChecker {

	/**
	 * チェックメソッド。
	 * <p>
	 * 引数で渡された事故受け付け情報に対してチェックを行い、エラーメッセージを返却する。
	 * チェック結果がOKであれば、null値を返却する。
	 * </p>
	 * @param rp 事故情報
	 * @return null null値
	 */
	public String check(AccidentReception rp) {
		if(Objects.equals(rp.getClaimNo(), null) || rp.getClaimNo().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(rp.getAccidentLocationKana1(), null) || rp.getAccidentLocationKana1().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(rp.getAccidentLocationKana2(), null) || rp.getAccidentLocationKana2().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(rp.getAccidentLocationKanji1(), null) || rp.getAccidentLocationKanji1().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(rp.getAccidentLocationKanji2(), null) || rp.getAccidentLocationKanji2().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(rp.getAccidentDate(), null) || rp.getAccidentDate().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(rp.getAccidentSituation(), null)){
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(rp.getRatingBlameMyself(), null)) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(rp.getRatingBlameYourself(), null)) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(rp.getDamageCarPrice(), null)) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(rp.getDamageBodilyPrice(), null)) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(rp.getDamagePropertyPrice(), null)) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(rp.getDamageAccidentPrice(), null)) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(rp.getDamageCarState(), null) || rp.getDamageCarState().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(rp.getDamageBodilyState(), null) || rp.getDamageBodilyState().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(rp.getDamagePropertyState(), null) || rp.getDamagePropertyState().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(rp.getDamageAccidentState(), null) || rp.getDamageAccidentState().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(rp.getPaymentPrice(), null)) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else {

			//チェックがOKの場合、nullを戻り値として返す
			return null;
		}
	}
}
