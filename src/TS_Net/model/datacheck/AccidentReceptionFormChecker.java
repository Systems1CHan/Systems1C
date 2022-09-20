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

import java.util.ArrayList;
import java.util.List;
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
	public List<Integer> check(AccidentReception rp) {
		List<Integer> num = new ArrayList<Integer>();

		if(Objects.equals(rp.getAccidentDate(), null) || rp.getAccidentDate().isEmpty()) {
			num.add(1);
		}else {
			num.add(0);
		}if(Objects.equals(rp.getAccidentLocationKanji1(), null) || rp.getAccidentLocationKanji1().isEmpty()) {
			num.add(1);
			}else {
				num.add(0);
		}if(Objects.equals(rp.getAccidentLocationKana1(), null) || rp.getAccidentLocationKana1().isEmpty()) {
			num.add(1);
		}else {
			num.add(0);
		}if(Objects.equals(rp.getAccidentLocationKanji2(), null) || rp.getAccidentLocationKanji2().isEmpty()) {
			num.add(1);
		}else {
			num.add(0);
		}if(Objects.equals(rp.getAccidentLocationKana2(), null) || rp.getAccidentLocationKana2().isEmpty()) {
			num.add(1);
		}else {
			num.add(0);
		}if(Objects.equals(rp.getAccidentSituation(), null)|| rp.getAccidentSituation().isEmpty()){
			num.add(1);
		}else {
			num.add(0);
		}if(Objects.equals(rp.getRatingBlameMyself(), null)) {
			num.add(1);
		}else {
			num.add(0);
		}if(Objects.equals(rp.getRatingBlameYourself(), null)) {
			num.add(1);
		}else {
			num.add(0);
		}if(Objects.equals(rp.getDamageCarPrice(), null)) {
			num.add(1);
		}else {
			num.add(0);
		}if(Objects.equals(rp.getDamageCarState(), null) || rp.getDamageCarState().isEmpty()) {
			num.add(1);
		}else {
			num.add(0);
		}if(Objects.equals(rp.getDamageBodilyPrice(), null)) {
			num.add(1);
		}else {
			num.add(0);
		}if(Objects.equals(rp.getDamageBodilyState(), null) || rp.getDamageBodilyState().isEmpty()) {
			num.add(1);
		}else {
			num.add(0);
		}if(Objects.equals(rp.getDamagePropertyPrice(), null)) {
			num.add(1);
		}else {
			num.add(0);
		}if(Objects.equals(rp.getDamagePropertyState(), null) || rp.getDamagePropertyState().isEmpty()) {
			num.add(1);
		}else {
			num.add(0);
		}if(Objects.equals(rp.getDamageAccidentPrice(), null)) {
			num.add(1);
		}else {
			num.add(0);
		}if(Objects.equals(rp.getDamageAccidentState(), null) || rp.getDamageAccidentState().isEmpty()) {
			num.add(1);
		}else {
			num.add(0);
		}

			//チェックがOKの場合、nullを戻り値として返す
			return num;

	}

	public String digitCheck(String price){

		if(Objects.equals(price, "0")) {

			return null;



		}else if((price.length() < 4)) {
			return ErrorMsgConst.FORM_ERROR0020;

		}else if(!("000".equals(price.substring(price.length() - 3, price.length())))) {
			return ErrorMsgConst.FORM_ERROR0020;

		}

		return null;
	}


}
