package TS_Net.model.data;

import java.io.Serializable;
import java.util.Objects;

public class ContractInfo implements Serializable {

	/* 印刷連番*/
    private String insatsuRenban;
    /* 証券番号*/
    private String polNo;
    /* 状態フラグ*/
    private String statusFlg;
    /* 解約フラグ*/
    private String cancelFlg;
    /* 保険期間始期日*/
    private String inceptionDate;
    /* 保険期間始期時刻*/
    private String inceptionTime;
    /* 保険期間満期日*/
    private String conclusionDate;
    /* 保険期間満期時刻*/
    private String conclusionTime;
    /* 払込方法*/
    private String paymentMethod;
    /* 払込回数*/
    private String installment;
    /* 被保険者区分*/
    private String insuredKbn;
    /* 氏名カナ１*/
    private String nameKana1;
    /* 氏名カナ２*/
    private String namekana2;
    /* 氏名漢字１*/
    private String nameKanji1;
    /* 氏名漢字２*/
    private String nameKanji2;
    /* 郵便番号*/
    private String postcode;
    /* 住所カナ１*/
    private String addressKana1;
    /* 住所カナ２*/
    private String addressKana2;
    /* 住所漢字１*/
    private String addressKanji1;
    /* 住所漢字２*/
    private String addressKanji2;
    /* 生年月日*/
    private String birthday;
    /* 性別*/
    private String gender;
    /* 電話番号*/
    private String telephoneNo;
    /* 携帯電話番号*/
    private String mobilephoneNo;
    /* FAX番号*/
    private String faxNo;
    
    /**
	 * 契約状態取得メソッド。
	 * <p>
	 * 画面に表示させるための契約状態を取得する
	 * </p>
	 * @return 契約状態
	 */
	public String getStatusFlgForLabel() {
		if(statusFlg.equals("0")) {
			return "解約済";
		}else {
			return "契約中";
		}
	}

    /*
     * 以下各メンバ変数のゲッター・セッター
     */
	public String getInsatsuRenban() {
		return insatsuRenban;
	}
	
	public void setInsatsuRenban(String insatsuRenban) {
		this.insatsuRenban = insatsuRenban;
	}
	
	public String getPolNo() {
		return polNo;
	}
	
	public void setPolNo(String polNo) {
		this.polNo = polNo;
	}
	
	public String getStatusFlg() {
		return statusFlg;
	}
	
	public void setStatusFlg(String statusFlg) {
		this.statusFlg = statusFlg;
	}
	
	public String getCancelFlg() {
		return cancelFlg;
	}
	
	public void setCancelFlg(String cancelFlg) {
		this.cancelFlg = cancelFlg;
	}
	
	public String getInceptionDate() {
		return inceptionDate;
	}
	
	public void setInceptionDate(String inceptionDate) {
		this.inceptionDate = inceptionDate;
	}
	
	public String getInceptionTime() {
		return inceptionTime;
	}
	
	public void setInceptionTime(String inceptionTime) {
		this.inceptionTime = inceptionTime;
	}
	
	public String getConclusionDate() {
		return conclusionDate;
	}
	
	public void setConclusionDate(String conclusionDate) {
		this.conclusionDate = conclusionDate;
	}
	
	public String getConclusionTime() {
		return conclusionTime;
	}
	
	public void setConclusionTime(String conclusionTime) {
		this.conclusionTime = conclusionTime;
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}
	
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	public String getInstallment() {
		return installment;
	}
	
	public void setInstallment(String installment) {
		this.installment = installment;
	}
	
	public String getInsuredKbn() {
		return insuredKbn;
	}
	
	public void setInsuredKbn(String insuredKbn) {
		this.insuredKbn = insuredKbn;
	}
	
	public String getNameKana1() {
		return nameKana1;
	}
	
	public void setNameKana1(String nameKana1) {
		this.nameKana1 = nameKana1;
	}
	
	public String getNamekana2() {
		return namekana2;
	}
	
	public void setNamekana2(String namekana2) {
		this.namekana2 = namekana2;
	}
	
	public String getNameKanji1() {
		return nameKanji1;
	}
	
	public void setNameKanji1(String nameKanji1) {
		this.nameKanji1 = nameKanji1;
	}
	
	public String getNameKanji2() {
		return nameKanji2;
	}
	
	public void setNameKanji2(String nameKanji2) {
		this.nameKanji2 = nameKanji2;
	}
	
	public String getPostcode() {
		return postcode;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public String getAddressKana1() {
		return addressKana1;
	}
	
	public void setAddressKana1(String addressKana1) {
		this.addressKana1 = addressKana1;
	}
	
	public String getAddressKana2() {
		return addressKana2;
	}
	
	public void setAddressKana2(String addressKana2) {
		this.addressKana2 = addressKana2;
	}
	
	public String getAddressKanji1() {
		return addressKanji1;
	}
	
	public void setAddressKanji1(String addressKanji1) {
		this.addressKanji1 = addressKanji1;
	}
	
	public String getAddressKanji2() {
		return addressKanji2;
	}
	
	public void setAddressKanji2(String addressKanji2) {
		this.addressKanji2 = addressKanji2;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getTelephoneNo() {
		return telephoneNo;
	}
	
	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}
	
	public String getMobilephoneNo() {
		return mobilephoneNo;
	}
	
	public void setMobilephoneNo(String mobilephoneNo) {
		this.mobilephoneNo = mobilephoneNo;
	}
	
	public String getFaxNo() {
		return faxNo;
	}
	
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
}
