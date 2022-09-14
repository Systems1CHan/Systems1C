package TS_Net.model.datacheck;

import TS_Net.model.constant.ErrorMsgConst;
import TS_Net.model.data.AccidentReception;

	/**
	 * 受付番号データチェッククラス。
	 * <p>
	 * 受付番号をチェックする。
	 * </p>
	 * @author KeinaNoguchi/SYS 2022/09/08
	 */
	public class ClaimNoChecker {

		/**
		 * 事故受付番号存在チェック(0010)メソッド。
		 * <p>
		 *このメソッドが呼び出された場合、以下の処理を行う。
		 *1. 契約情報テーブルの証券番号のカラムに該当受付番号があるかを調べる
		 *2. 該当受付番号があった場合、"1"が、ない場合"0"を返す
		 *3. ある場合はnullを戻り値として返す
		 *4. ない場合は、エラーメッセージを戻り値として返す
		 * </p>
		 */
		public String claimNoExistenceCheck(AccidentReception accidentReception) {


			if((accidentReception.getClaimNo() == null) || ("".equals(accidentReception.getClaimNo()))){

				return ErrorMsgConst.FORM_ERROR0010;

			}else {
			return null;
			}
		}

		/**
		 * 事故受付番号処理済みチェック(0011)メソッド。
		 * <p>
		 *このメソッドが呼び出された場合、以下の処理を行う。
		 *1. 契約情報テーブルの該当受付番号と一致する行を探す
		 *2. 一致した行の事故受付フラグの値を取り出す
		 *3. 取り出した値が"0"（通常）の場合、nullを返す
		 *4. 取り出した値が"1"（処理済）の場合、エラーメッセージを戻り値として返す
		 * </p>
		 */
		public String claimNoProcessedCheck(AccidentReception accidentReception) {


			if(accidentReception.getClaimStatus() == "1"){

				return ErrorMsgConst.FORM_ERROR0011;

			}else {
			return null;

			}
		}



	}

