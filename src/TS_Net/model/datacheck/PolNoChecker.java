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
import TS_Net.model.data.ContractInfo;

/**
 * 証券番号データチェッククラス。
 * <p>
 * 証券番号をチェックする。
 * </p>
 * @author TooruNakaya/SYS 2022/08/09
 */
public class PolNoChecker {

	/**
	 * 証券番号・事故受付番号入力チェック(0001)メソッド。
	 * <p>
	 *契約情報オブジェクトの証券番号、
	 *事故受付情報オブジェクトの事故受付番号
	 *がともに入力されていた場合、エラーメッセージを返却する。
	 * </p>
	 */
	public String polNoInputCheck(ContractInfo contractInfo) {


		if(((contractInfo.getPolNo() != null) || (contractInfo.getPolNo().length() != 0)) && ((contractInfo.getClaimNo() != null) || (contractInfo.getClaimNo().length() != 0))){

			return ErrorMsgConst.FORM_ERROR0001;

		}else {
		return null;
		}
	}


	/**
	 * 証券番号・事故受付番号入力チェック(0018)メソッド。
	 * <p>
	 *契約情報オブジェクトの証券番号、
	 *事故受付情報オブジェクトの事故受付番号がともに未入力の場合、
	 *エラーメッセージを返却する。
	 * </p>
	 */
	public String polNoNotInputCheck(ContractInfo contractInfo) {


		if(((contractInfo.getPolNo() == null) || ("".equals(contractInfo.getPolNo()))) && ((contractInfo.getClaimNo() == null) || ("".equals(contractInfo.getClaimNo())))){

			return ErrorMsgConst.FORM_ERROR0018;

		}else {
		return null;
		}
	}

	/**
	 * 証券番号存在チェック(0006)メソッド。
	 * <p>
	 *このメソッドが呼び出された場合、以下の処理を行う。
	 *1. 契約情報テーブルの証券番号のカラムに該当証券番号があるかを調べる
	 *2. 該当証券番号があった場合、"1"が、ない場合"0"を返す
	 *3. ある場合はnullを戻り値として返す
	 *4. ない場合は、エラーメッセージを戻り値として返す
	 * </p>
	 */
	public String polNoExistenceCheck(ContractInfo contractInfo) {


		if((contractInfo.getPolNo() == null) || ("".equals(contractInfo.getPolNo()))){

			return ErrorMsgConst.FORM_ERROR0006;

		}else {
		return null;
		}
	}

	/**
	 * 証券番号解約済みチェック(0007)メソッド。
	 * <p>
	 *このメソッドが呼び出された場合、以下の処理を行う。
	 *1. 契約情報テーブルの該当印刷連番と一致する行を探す
	 *2. 一致した行の解約フラグの値を取り出す
	 *3. 取り出した値が"0"（通常）の場合、nullを返す
	 *4. 取り出した値が"1"（解約）の場合、エラーメッセージを戻り値として返す
	 * </p>
	 */
	public String polNoCancelledCheck(ContractInfo contractInfo) {


		if(contractInfo.getCancelFlg() == "1"){

			return ErrorMsgConst.FORM_ERROR0007;

		}else {
		return null;

		}
	}



}
