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
import TS_Net.model.data.Compensation;
import TS_Net.model.data.ContractInfo;

/**
 * 証券番号データチェッククラス。
 * <p>
 * 証券番号をチェックする。
 * </p>
 * @author TooruNakaya/SYS 2022/08/09
 */
public class InsatsuRenbanChecker {

	/**
	 * 印刷連番存在チェック(0004)メソッド。
	 * <p>
	 *このメソッドが呼び出された場合、以下の処理を行う。
	 *1. 契約情報テーブルの証券番号のカラムに該当印刷連番があるかを調べる
	 *2. 該当印刷連番があった場合、"1"が、ない場合"0"を返す
	 *3. ある場合はnullを戻り値として返す
	 *4. ない場合は、エラーメッセージを戻り値として返す
	 * </p>
	 */
	public String insatusRenbanExistenceCheck(Compensation compensation) {


		if((compensation.getInsatsuRenban() == null) || ("".equals(compensation.getInsatsuRenban()))){

			return ErrorMsgConst.FORM_ERROR0004;

		}else {
		return null;
		}
	}

	/**
	 * 印刷連番計上済みチェック(0005)メソッド。
	 * <p>
	 *このメソッドが呼び出された場合、以下の処理を行う。
	 *1. 契約情報テーブルの該当印刷連番と一致する行を探す
	 *2. 一致した行の状態フラグの値を取り出す
	 *3. 取り出した値が"0"（計上済み）の場合、エラーメッセージを戻り値として返す
	 *4. 取り出した値が"０"以外場合、nullを返す
	 * </p>
	 */
	public String polNoCancelledCheck(ContractInfo contractInfo) {


		if(contractInfo.getStatusFlg() == "0"){

			return ErrorMsgConst.FORM_ERROR0005;

		}else {
		return null;

		}
	}




}
