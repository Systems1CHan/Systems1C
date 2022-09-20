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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
	public List<Integer> check(Compensation com) {

		List<Integer> num = new ArrayList<Integer>();

		if(Objects.equals(com.getMaker(), null) || com.getMaker().isEmpty()) {
			num.add(1);
		}else {
			num.add(0);
		}if(Objects.equals(com.getCarName(), null) || com.getCarName().isEmpty()) {
			num.add(1);
		}else {
			num.add(0);
		}if(Objects.equals(com.getLicenseNo(), null) || com.getLicenseNo().isEmpty()) {
			num.add(1);
		}else {
			num.add(0);
		}if(com.getVehiclePrice() == null || String.valueOf(com.getVehiclePrice()).isEmpty()){
			num.add(1);
		}else {
			num.add(0);
		}if(Objects.equals(com.getVehicleRates(), null) || com.getVehicleRates().isEmpty()) {
			num.add(1);
		}else {
			num.add(0);
		}if(Objects.equals(com.getBodilyRates(), null) || com.getBodilyRates().isEmpty()) {
			num.add(1);
		}else {
			num.add(0);
		}if(Objects.equals(com.getPropertyDamageRates(), null) || com.getPropertyDamageRates().isEmpty()){
			num.add(1);
		}else {
			num.add(0);
		}if(Objects.equals(com.getAccidentRates(), null) || com.getAccidentRates().isEmpty()) {
			num.add(1);
		}else {
			num.add(0);
		}if(Objects.equals(com.getLicenseColor(), null) || com.getLicenseColor().isEmpty()) {
			num.add(1);
		}else {
			num.add(0);
		}if(Objects.equals(com.getAgeLimit(), null) || com.getAgeLimit().isEmpty()) {
			num.add(1);
		}else {
			num.add(0);
		}if(com.getPremiumAmount() == null || String.valueOf(com.getPremiumAmount()).isEmpty()) {
			num.add(1);
		}else {
			num.add(0);
		}if(com.getPremiumInstallment() == null || String.valueOf(com.getPremiumInstallment()).isEmpty()) {
			num.add(1);
		}else {
			num.add(0);
		}
			//チェックがOKの場合、nullを戻り値として返す
			return num;

	}
}
