/*------------------------------------------------------------------------------
 * 演習番号：[総合演習]
 * クラス名：[ContractInfo]
 * 作成日  ：[2022/09/08]
 * 作成者  ：[RyoIsogami/SYS]
 *------------------------------------------------------------------------------
 * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
 *------------------------------------------------------------------------------
 */

package TS_Net.model.data;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Objects;

import javax.swing.text.MaskFormatter;

/**
 * 契約情報クラス。
 * <p>
 * 契約情報を保持する。
 * </p>
 * @author RyoIsogami/SYS 2022/09/08
 */
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
    private Integer installment;
    /* 被保険者区分*/
    private String insuredKbn;
    /* 氏名カナ１*/
    private String nameKana1;
    /* 氏名カナ２*/
    private String nameKana2;
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

    /* 引数なしコンストラクタ*/
    public ContractInfo(){
    	insatsuRenban = "";
    	polNo = "";
    	statusFlg = "";
    	cancelFlg = "";
    	inceptionDate = "";
    	inceptionTime = "";
    	conclusionDate = "";
    	conclusionTime = "";
    	paymentMethod = "";
    	installment = 0;
    	insuredKbn = "1";
    	nameKana1 = "";
    	nameKana2 = "";
    	nameKanji1 = "";
    	nameKanji2 = "";
    	postcode = "";
    	addressKana1 = "";
    	addressKana2 = "";
    	addressKanji1 = "";
    	addressKanji2 = "";
    	birthday = "";
    	gender = "";
    	telephoneNo = "";
    	mobilephoneNo = "";
    	faxNo = "";
    }

    /**
   	 * 計上状態取得メソッド。
   	 * <p>
   	 * 画面に表示させるための計上状態を取得する
   	 * </p>
   	 * @return 計上状態
   	 */
   	public String getStatusFlgForKeijyou() {
   		if(Objects.equals(statusFlg, "1")) {
   			return "新規";
   		}else if(Objects.equals(statusFlg, "5")){
			return "変更";
   		}else {
   			return "解約";
   		}
   	}


    /**
	 * 契約状態取得メソッド。
	 * <p>
	 * 画面に表示させるための契約状態を取得する
	 * </p>
	 * @return 契約状態
	 */
	public String getStatusFlgForLabel() {
		if(Objects.equals(cancelFlg, "1")) {
			return "解約済";
		}else {
			return "契約中";
		}
	}

	/**
	 * 払込方法取得メソッド。
	 * <p>
	 * 画面に表示させるための払込方法を取得する
	 * </p>
	 * @return 契約状態
	 */
	public String getPaymentMethodForLabel() {
		if(Objects.equals(paymentMethod, "1")) {
			return "直接集金";
		}else if(Objects.equals(paymentMethod, "2")){
			return "口座振替";
		}else {
			return "クレジットカード";
		}
	}

	/**
	 * 性別取得メソッド。
	 * <p>
	 * 画面に表示させるための性別を取得する
	 * </p>
	 * @return 性別
	 */
	public String getGenderForLabel() {
		if(Objects.equals(gender, "1")) {
			return "男";
		}else {
			return "女";
		}
	}

	/**
	 * 被保険者区分取得メソッド。
	 * <p>
	 * 画面に表示させるための被保険者区分を取得する
	 * </p>
	 * @return 被保険者区分
	 */
	public String getInsuredKbnForLabel() {
		if(Objects.equals(insuredKbn, "1")) {
			return "個人";
		}else {
			return "法人";
		}
	}

	/**
	 * 契約者名取得メソッド
	 * <p>
	 * 画面に表示させるための契約者氏名を取得する。
	 * また顧客氏名は敬称をつけてリターンする。
	 * </p>
	 * @return 顧客氏名（敬称つき）
	 */
	public String getNameForLabel() {
		return this.nameKanji1 + this.nameKanji2 + "様";
	}

	/**
	 * 契約者名取得メソッド
	 * <p>
	 * 画面に表示させるためのカナ契約者氏名を取得する。
	 * また顧客氏名は敬称をつけてリターンする。
	 * </p>
	 * @return 顧客カナ氏名（敬称つき）
	 */
	public String getkanaNameForLabel() {
		return this.nameKana1 + this.nameKana2 + "様";
	}

	/**
	 * 契約者漢字住所メソッド
	 * <p>
	 * 画面に表示させるための漢字住所を取得する。
	 * </p>
	 * @return 漢字住所
	 */
	public String getKanjiAddressForLabel() {
		return this.addressKanji1 + this.addressKanji2;
	}

	/**
	 * 契約者カナ住所メソッド
	 * <p>
	 * 画面に表示させるためのカナ住所を取得する。
	 * </p>
	 * @return カナ住所
	 */
	public String getKanaAddressForLabel() {
		return this.addressKana1 + this.addressKana2;
	}



	/**
	 * 郵便番号取得メソッド
	 * <p>
	 * 画面に表示させるための郵便番号を取得する。
	 * また郵便番号は〒をつけてリターンする。
	 * </p>
	 * @return 郵便番号
	 */
	public String getPostcodeForLabel() {
		return "〒" + this.postcode.substring(0, 3) + "-" + this.postcode.substring(3, 6);
	}

	/**
	 * 生年月日メソッド
	 * <p>
	 * 画面に表示させるための生年月日を取得する。
	 * 西暦でリターンする。
	 * </p>
	 * @return 生年月日
	 */
	public String getBirthdayForLabel() {
		return this.birthday.substring(0, 4) + "年" + this.birthday.substring(4, 6) + "月" + this.birthday.substring(6, 8) + "日";
	}

	/**
	 * 保険期間メソッド
	 * <p>
	 * 画面に表示させるための保険期間を取得する。
	 * 西暦でリターンする。＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃＃※作成中
	 * </p>
	 * @return 保険期間
	 */
	public String getInsureanceIntervalForLabel() {
		String inceptionTime24 = null;
		String conclusionTime24 = null;

		if(Integer.parseInt(inceptionTime) <= 12 ) {
			inceptionTime24 = "午前" + inceptionTime + "時";
		} else if (Integer.parseInt(inceptionTime) > 12) {
			int num = Integer.parseInt(inceptionTime) - 12;
			inceptionTime24 = "午後" + Integer.toString(num) + "時";
		}

		if(Integer.parseInt(conclusionTime) <= 12 ) {
			conclusionTime24 = "午前" + inceptionTime + "時";
		} else if (Integer.parseInt(conclusionTime) > 12) {
			int num = Integer.parseInt(conclusionTime) - 12;
			conclusionTime24 = "午後" + Integer.toString(num) + "時";
		}


		return this.inceptionDate.substring(0, 4) + "年" + this.inceptionDate.substring(4, 6) + "月" + this.inceptionDate.substring(6, 8) + "日" + inceptionTime24 + "から" + this.conclusionDate.substring(0, 4) + "年" + this.conclusionDate.substring(4, 6) + "月" + this.conclusionDate.substring(6, 8) + "日" + conclusionTime24 + "まで"   ;
	}




	/**
	 * 電話番号取得メソッド
	 * <p>
	 * 画面に表示させるための電話番号を取得する。
	 * また電話番号は市外局番(3桁)-市内局番(4桁)-番号(4桁)の形で表示する。
	 * </p>
	 * @return 電話番号
	 * @throws ParseException
	 */
	public String getTelephoneNoForLabel() throws ParseException {
		String phoneMask= "###-####-####";
		MaskFormatter maskFormatter= new MaskFormatter(phoneMask);
		maskFormatter.setValueContainsLiteralCharacters(false);
		return maskFormatter.valueToString(this.telephoneNo);
	}

	/**
	 * FAX番号取得メソッド
	 * <p>
	 * 画面に表示させるための電話番号を取得する。
	 * また電話番号は市外局番(3桁)-市内局番(4桁)-番号(4桁)の形で表示する。
	 * </p>
	 * @return FAX番号
	 * @throws ParseException
	 */
	public String getFaxNoForLabel() throws ParseException {
		String phoneMask= "###-####-####";
		MaskFormatter maskFormatter= new MaskFormatter(phoneMask);
		maskFormatter.setValueContainsLiteralCharacters(false);
		return maskFormatter.valueToString(this.faxNo);
	}

	/**
	 * 携帯電話番号取得メソッド
	 * <p>
	 * 画面に表示させるための電話番号を取得する。
	 * また電話番号は市外局番(3桁)-市内局番(4桁)-番号(4桁)の形で表示する。
	 * </p>
	 * @return 携帯電話番号
	 * @throws ParseException
	 */
	public String getMobilePhoneNoForLabel() throws ParseException {
		String phoneMask= "###-####-####";
		MaskFormatter maskFormatter= new MaskFormatter(phoneMask);
		maskFormatter.setValueContainsLiteralCharacters(false);
		return maskFormatter.valueToString(this.mobilephoneNo);
	}





    /*
     * 以下各メンバ変数のゲッター・セッター
     */
	public String  getInsatsuRenban() {
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

	public Integer getInstallment() {
		return installment;
	}

	public void setInstallment(Integer installment) {
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

	public String getNameKana2() {
		return nameKana2;
	}

	public void setNameKana2(String nameKana2) {
		this.nameKana2 = nameKana2;
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
