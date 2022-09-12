/*------------------------------------------------------------------------------
 * 演習番号：[総合演習]
 * クラス名：[Compensation]
 * 作成日  ：[2022/09/08]
 * 作成者  ：[RyoIsogami/SYS]
 *------------------------------------------------------------------------------
 * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
 *------------------------------------------------------------------------------
 */

package TS_Net.model.data;

import java.io.Serializable;

/**
 * 補償情報クラス。
 * <p>
 * 補償情報を保持する。
 * </p>
 * @author RyoIsogami/SYS 2022/09/08
 */
public class Compensation implements Serializable {

	/* 補償ID*/
	private Integer coverId;
	/* メーカー*/
	private String maker;
	/* 車名*/
	private String carName;
	/* 車のナンバー*/
	private String licenseNo;
	/* 車両保険金額*/
	private Integer vehiclePrice;
	/* 料率・車両*/
	private String vehicleRates;
	/* 料率・対人*/
	private String bodilyRates;
	/* 料率・対物*/
	private String propertyDamageRates;
	/* 料率・傷害*/
	private String accidentRates;
	/* 免許証の色*/
	private String licenseColor;
	/* 年齢条件*/
	private String ageLimit;
	/* 総額保険料*/
	private Integer premiumAmount;
	/* 一回分保険料*/
	private Integer premiumInstallment;

	/* 印刷連番*/
	ContractInfo contractInf = new ContractInfo();
	private String insatsuRenban = contractInf.getInsatsuRenban();


	/**
	 * 車両料率取得メソッド。
	 * <p>
	 * 画面に表示させるための車両料率を取得する。
	 * </p>
	 * @return 車両料率
	 */
	public String getVehicleRatesForLabel() {
		if(vehicleRates.equals("0")) {
			return "0.0倍";
		}else if(vehicleRates.equals("1")){
			return "1.0倍";
		}else if(vehicleRates.equals("2")){
			return "1.2倍";
		}else if(vehicleRates.equals("3")) {
			return "1.4倍";
		}else if(vehicleRates.equals("4")) {
			return "1.6倍";
		}else {
			return "1.9倍";
		}
	}

	/**
	 * 対人料率取得メソッド。
	 * <p>
	 * 画面に表示させるための対人料率を取得する。
	 * </p>
	 * @return 対人料率
	 */
	public String getBodilyRatesForLabel() {
		if(bodilyRates.equals("0")) {
			return "0.0倍";
		}else if(bodilyRates.equals("1")){
			return "1.0倍";
		}else if(bodilyRates.equals("2")){
			return "1.2倍";
		}else if(bodilyRates.equals("3")) {
			return "1.4倍";
		}else if(bodilyRates.equals("4")) {
			return "1.6倍";
		}else {
			return "1.9倍";
		}
	}

	/**
	 * 対物料率取得メソッド。
	 * <p>
	 * 画面に表示させるための対物料率を取得する。
	 * </p>
	 * @return 対物料率
	 */
	public String getPropertyDamageRatesForLabel() {
		if(propertyDamageRates.equals("0")) {
			return "0.0倍";
		}else if(propertyDamageRates.equals("1")){
			return "1.0倍";
		}else if(propertyDamageRates.equals("2")){
			return "1.2倍";
		}else if(propertyDamageRates.equals("3")) {
			return "1.4倍";
		}else if(propertyDamageRates.equals("4")) {
			return "1.6倍";
		}else {
			return "1.9倍";
		}
	}

	/**
	 * 傷害料率取得メソッド。
	 * <p>
	 * 画面に表示させるための傷害料率を取得する。
	 * </p>
	 * @return 傷害料率
	 */
	public String getAccidentRatesForLabel() {
		if(accidentRates.equals("0")) {
			return "0.0倍";
		}else if(accidentRates.equals("1")){
			return "1.0倍";
		}else if(accidentRates.equals("2")){
			return "1.2倍";
		}else if(accidentRates.equals("3")) {
			return "1.4倍";
		}else if(accidentRates.equals("4")) {
			return "1.6倍";
		}else {
			return "1.9倍";
		}
	}

	/**
	 * 免許証の色取得メソッド。
	 * <p>
	 * 画面に表示させるための免許証の色を取得する。
	 * </p>
	 * @return 免許証の色
	 */
	public String getLicenseColorForLabel() {
		if(licenseColor.equals("1")) {
			return "ブルー";
		}else if(vehicleRates.equals("2")){
			return "グリーン";
		}else {
			return "ゴールド";
		}
	}

	/**
	 * 年齢条件取得メソッド。
	 * <p>
	 * 画面に表示させるための年齢条件を取得する。
	 * </p>
	 * @return 年齢条件
	 */
	public String getAgeLimitForLabel() {
		if(ageLimit.equals("1")) {
			return "無制限";
		}else if(ageLimit.equals("2")){
			return "21歳以上";
		}else {
			return "26歳以上";
		}
	}

	/**
	 * 各料率変換メソッド。
	 * <p>
	 * 入力された料率を保険料算出用に変換する。
	 * </p>
	 * @return rates 各料率
	 */
	public double rate(String rates) {

		if(rates.equals("0")) {
			return 0.0;
		}else if(rates.equals("1")){
			return 1.0;
		}else if(rates.equals("2")){
			return 1.2;
		}else if(rates.equals("3")) {
			return 1.4;
		}else if(rates.equals("4")) {
			return 1.6;
		}else {
			return 1.9;
		}
	}

	/**
	 * 免許証の色変換メソッド。
	 * <p>
	 * 入力された免許証の色を保険料算出用に変換する。
	 * </p>
	 * @return licenseColor 免許証の色
	 */
	public double licenserate(String licenseColor) {

		if(licenseColor.equals("1")) {
			return 1.3;
		}else if(licenseColor.equals("2")){
			return 1.0;
		}else{
			return 0.7;
		}
	}

	/**
	 * 年齢条件変換メソッド。
	 * <p>
	 * 入力された年齢条件を保険料算出用に変換する。
	 * </p>
	 * @return ageLimit 年齢条件
	 */
	public double olderRate(String ageLimit) {
		if(ageLimit.equals("1")) {
			return 1.5;
		}else if(ageLimit.equals("2")){
			return 1.2;
		}else {
			return 1.0;
		}
	}


	/**
	 * 総額保険料取得メソッド。
	 * <p>
	 * 画面に表示させるための総額保険料を取得する。
	 * 表示させる際は、総額保険料の後ろに「円」をつける。
	 * </p>
	 * @param compensation 補償情報オブジェクト
	 * @return 総額保険料
	 */
	public String getPremiumAmountForLabel() {

		Integer ratesSum =  (int) (this.vehiclePrice * (rate(this.vehicleRates) + rate(this.bodilyRates) + rate(this.propertyDamageRates) + rate(this.accidentRates)));
		Integer dpremiumAmount = (int) ((int) ratesSum * 12 * licenserate(this.licenseColor) * olderRate(this.ageLimit))  ;
		this.premiumAmount = dpremiumAmount;
		return this.premiumAmount + "円";
	}

	/**
	 * 一回分保険料取得メソッド。
	 * <p>
	 * 画面に表示させるための一回分保険料を取得する。
	 * 表示させる際は、一回分保険料の後ろに「円」をつける。
	 * </p>
	 * @param premiumAmount 総額保険料
	 * @param installment 払込回数
	 * @return 一回分保険料
	 */
	public String getPremiumInstallmentForLabel() {

		ContractInfo contractInf = new ContractInfo();
		Integer installment = contractInf.getInstallment();

		this.premiumInstallment = this.premiumAmount / installment;
		return this.premiumInstallment + "円";
	}

	/**
	 * 車ナンバーメソッド
	 * <p>
	 * 画面に表示させるためのナンバーを取得する。
	 * </p>
	 * @return 車のナンバー
	 */
	public String getCarNameForLabel() {
		return this.licenseNo.substring(0, 2) + " " + this.licenseNo.substring(2, 5) + " " + this.licenseNo.substring(5, 6) + " " + this.licenseNo.substring(6, 8) + "-" + this.licenseNo.substring(8, 10) ;
	}

	 /*
     * 以下各メンバ変数のゲッター・セッター
     */
	public Integer getCoverId() {
		return coverId;
	}

	public void setCoverId(Integer coverId) {
		this.coverId = coverId;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public Integer getVehiclePrice() {
		return vehiclePrice;
	}

	public void setVehiclePrice(Integer vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getVehicleRates() {
		return vehicleRates;
	}

	public void setVehicleRates(String vehicleRates) {
		this.vehicleRates = vehicleRates;
	}

	public String getBodilyRates() {
		return bodilyRates;
	}

	public void setBodilyRates(String bodilyRates) {
		this.bodilyRates = bodilyRates;
	}

	public String getPropertyDamageRates() {
		return propertyDamageRates;
	}

	public void setPropertyDamageRates(String propertyDamageRates) {
		this.propertyDamageRates = propertyDamageRates;
	}

	public String getAccidentRates() {
		return accidentRates;
	}

	public void setAccidentRates(String accidentRates) {
		this.accidentRates = accidentRates;
	}

	public String getLicenseColor() {
		return licenseColor;
	}

	public void setLicenseColor(String licenseColor) {
		this.licenseColor = licenseColor;
	}

	public String getAgeLimit() {
		return ageLimit;
	}

	public void setAgeLimit(String ageLimit) {
		this.ageLimit = ageLimit;
	}

	public Integer getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(Integer premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public Integer getPremiumInstallment() {
		return premiumInstallment;
	}

	public void setPremiumInstallment(Integer premiumInstallment) {
		this.premiumInstallment = premiumInstallment;
	}

	public String getInsatsuRenban() {
		return insatsuRenban;
	}

	public void setInsatsuRenban(String insatsuRenban) {
		this.insatsuRenban = insatsuRenban;
	}
}
