package TS_Net.model.datacheck;

import java.util.Objects;

import TS_Net.model.constant.ErrorMsgConst;
import TS_Net.model.data.Compensation;

/**
 * 補償情報項目データチェッククラス。
 * <p>
 * 補償情報項目をチェックする。
 * </p>
 * @author RyoIsogami/SYS 2022/09/12
 */
public class CompensationFormChecker {

	/**
	 * チェックメソッド。
	 * <p>
	 * 引数で渡された補償情報に対してチェックを行い、エラーメッセージを返却する。
	 * チェック結果がOKであれば、null値を返却する。
	 * </p>
	 * @param ci 補償情報
	 * @return ErrorMagConst.FORM_ERROR0002 フォームに未入力項目がある場合のエラーメッセージ
	 * @return null null値
	 */
	public String check(Compensation com) {
		if(Objects.equals(com.getMaker(), null) || com.getMaker().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(com.getCarName(), null) || com.getCarName().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(com.getLicenseNo(), null) || com.getLicenseNo().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(com.getVehiclePrice(), null)) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(com.getVehicleRates(), null) || com.getVehicleRates().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(com.getBodilyRates(), null) || com.getBodilyRates().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(com.getPropertyDamageRates(), null) || com.getPropertyDamageRates().isEmpty()){
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(com.getAccidentRates(), null) || com.getAccidentRates().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(com.getLicenseColor(), null) || com.getLicenseColor().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(com.getAgeLimit(), null) || com.getAgeLimit().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(com.getPremiumAmount(), null)) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(com.getPremiumInstallment(), null)) {
			return ErrorMsgConst.FORM_ERROR0002;

		}else {

			//チェックがOKの場合、nullを戻り値として返す
			return null;
		}
	}
}
