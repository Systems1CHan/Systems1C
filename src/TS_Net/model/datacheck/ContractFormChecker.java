package TS_Net.model.datacheck;

import java.util.Objects;

import TS_Net.model.constant.ErrorMsgConst;
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
	public String check(ContractInfo ci) {
		if(Objects.equals(ci.getInsatsuRenban(), null) || ci.getInsatsuRenban().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(ci.getInceptionDate(), null) || ci.getInceptionDate().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(ci.getInceptionTime(), null) || ci.getInceptionTime().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(ci.getConclusionDate(), null) || ci.getConclusionDate().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(ci.getConclusionTime(), null) || ci.getConclusionTime().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(ci.getPaymentMethod(), null) || ci.getPaymentMethod().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(ci.getInstallment(), null)){
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(ci.getInsuredKbn(), null) || ci.getInsuredKbn().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(ci.getNameKana1(), null) || ci.getNameKana1().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(ci.getNamekana2(), null) || ci.getNamekana2().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(ci.getNameKanji1(), null) || ci.getNameKanji1().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(ci.getNameKanji2(), null) || ci.getNameKanji2().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(ci.getPostcode(), null) || ci.getPostcode().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(ci.getAddressKana1(), null) || ci.getAddressKana1().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(ci.getAddressKana2(), null) || ci.getAddressKana2().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(ci.getAddressKanji1(), null) || ci.getAddressKanji1().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(ci.getAddressKanji2(), null) || ci.getAddressKanji2().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(ci.getBirthday(), null) || ci.getBirthday().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(ci.getGender(), null) || ci.getGender().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(ci.getTelephoneNo(), null) || ci.getTelephoneNo().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(ci.getMobilephoneNo(), null) || ci.getMobilephoneNo().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else if(Objects.equals(ci.getFaxNo(), null) || ci.getFaxNo().isEmpty()) {
			return ErrorMsgConst.FORM_ERROR0002;
		}else {

			//チェックがOKの場合、nullを戻り値として返す
			return null;
		}
	}
}
