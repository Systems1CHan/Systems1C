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
import TS_Net.model.data.ContractInfo;


/**
 * 契約情報項目データチェッククラス。
 * <p>
 * 契約情報項目をチェックする。
 * </p>
 * @author RyoIsogami/SYS 2022/09/12
 */
public class ContractFormChecker {

	/**
	 * チェックメソッド。
	 * <p>
	 * 引数で渡された契約情報に対してチェックを行い、エラーメッセージを返却する。
	 * チェック結果がOKであれば、null値を返却する。
	 * </p>
	 * @param ci 契約情報
	 * @return ErrorMagConst.FORM_ERROR0002 フォームに未入力項目がある場合のエラーメッセージ
	 * @return null null値
	 */
	public List<Integer> check(ContractInfo ci) {

		List<Integer> num = new ArrayList<Integer>();

		if(Objects.equals(ci.getInceptionDate(), null) || ci.getInceptionDate().isEmpty()) {
			num.add(1);
		}else {
				num.add(0);
		}if(Objects.equals(ci.getInceptionTime(), null) || ci.getInceptionTime().isEmpty()) {
			num.add(1);
		}else {
					num.add(0);
		}if(Objects.equals(ci.getConclusionDate(), null) || ci.getConclusionDate().isEmpty()) {
			num.add(1);
		}else {
					num.add(0);
		}if(Objects.equals(ci.getConclusionTime(), null) || ci.getConclusionTime().isEmpty()) {
			num.add(1);
		}else {
					num.add(0);
		}if(Objects.equals(ci.getPaymentMethod(), null) || ci.getPaymentMethod().isEmpty()) {
			num.add(1);
		}else {
					num.add(0);
		}if(ci.getInstallment() == null || String.valueOf(ci.getInstallment()).isEmpty()){
			num.add(1);
		}else {
					num.add(0);;
//		}if(Objects.equals(ci.getInsuredKbn(), null) || ci.getInsuredKbn().isEmpty()) {
//			num.add(1);
//		}else {
//					num.add(0);}
		}if(Objects.equals(ci.getNameKana1(), null) || ci.getNameKana1().isEmpty()) {
			num.add(1);
		}else {
					num.add(0);
		}if(Objects.equals(ci.getNameKana2(), null) || ci.getNameKana2().isEmpty()) {
			num.add(1);
		}else {
					num.add(0);
		}if(Objects.equals(ci.getNameKanji1(), null) || ci.getNameKanji1().isEmpty()) {
			num.add(1);
		}else {
					num.add(0);
		}if(Objects.equals(ci.getNameKanji2(), null) || ci.getNameKanji2().isEmpty()) {
			num.add(1);
		}else {
					num.add(0);
		}if(Objects.equals(ci.getPostcode(), null) || ci.getPostcode().isEmpty()) {
			num.add(1);
		}else {
					num.add(0);
		}if(Objects.equals(ci.getAddressKana1(), null) || ci.getAddressKana1().isEmpty()) {
			num.add(1);
		}else {
					num.add(0);
		}if(Objects.equals(ci.getAddressKana2(), null) || ci.getAddressKana2().isEmpty()) {
			num.add(1);
		}else {
					num.add(0);
		}if(Objects.equals(ci.getAddressKanji1(), null) || ci.getAddressKanji1().isEmpty()) {
			num.add(1);
		}else {
					num.add(0);
		}if(Objects.equals(ci.getAddressKanji2(), null) || ci.getAddressKanji2().isEmpty()) {
			num.add(1);
		}else {
					num.add(0);
		}if(Objects.equals(ci.getBirthday(), null) || ci.getBirthday().isEmpty()) {
			num.add(1);
		}else {
					num.add(0);
		}if(Objects.equals(ci.getGender(), null) || ci.getGender().isEmpty()) {
			num.add(1);
		}else {
					num.add(0);
		}if(Objects.equals(ci.getTelephoneNo(), null) || ci.getTelephoneNo().isEmpty() || Objects.equals(ci.getMobilephoneNo(), null) || ci.getMobilephoneNo().isEmpty() || Objects.equals(ci.getFaxNo(), null) || ci.getFaxNo().isEmpty()) {
			num.add(1);
		}else {
					num.add(0);
		}

			//チェックがOKの場合、nullを戻り値として返す
			return num;

	}
}
