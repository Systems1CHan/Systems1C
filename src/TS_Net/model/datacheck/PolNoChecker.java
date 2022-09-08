/*----------------------------------------------------------------------
 * 演習番号	：総合演習
 * クラス名	：PolNoChecker
 * 作成日	：2022/08/09
 * 作成者	：TooruNakaya/SYS
 * ----------------------------------------------------------------------
 *修正履歴（修正日：担当者：修正内容）
 *2022/08/09:仲矢透:個別でチェックする方式に変更。
 *2022/08/09:仲矢透:ブランクチェックはisEmpty()を用いて実行。
 *2022/08/09:仲矢透:エラー文は定数クラスを利用。
 * ----------------------------------------------------------------------
 */
package TS_Net.model.datacheck;

import TS_Net.model.constant.ErrorMsgConst;

/**
 * 証券番号データチェッククラス。
 * <p>
 * 証券番号をチェックする。
 * </p>
 * @author TooruNakaya/SYS 2022/08/09
 */
public class PolNoChecker {

	/**
	 * チェックメソッド。
	 * <p>
	 *契約情報オブジェクトの証券番号、
	 *事故受付情報オブジェクトの事故受付番号
	 *がともに入力されていた場合、エラーメッセージを返却する。
	 * </p>
	 */
	public String polNoInputCheck(Reservation rsv, ) {


		if((rsv.getDepartureDate() == null) || ("".equals(rsv.getDepartureDate()))){

			return ErrorMsgConst.FORM_ERROR;

		}else if((rsv.getComeTo() == null) || ("".equals(rsv.getComeTo()))){

			return ErrorMsgConst.FORM_ERROR;

		}else if((rsv.getComeFrom() == null) || ("".equals(rsv.getComeFrom()))) {

			return ErrorMsgConst.FORM_ERROR;

		}

		return null;

	}



}
