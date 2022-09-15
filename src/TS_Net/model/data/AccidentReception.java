/*------------------------------------------------------------------------------
 * 演習番号：[総合演習]
 * クラス名：[AccidentReception]
 * 作成日  ：[2022/09/08]
 * 作成者  ：[RyoIsogami/SYS]
 *------------------------------------------------------------------------------
 * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
 * 2022/09/12 磯上：支払金額取得メソッドの修正
 *------------------------------------------------------------------------------
 */

package TS_Net.model.data;

import java.io.Serializable;


/**
 * 事故受付情報クラス。
 * <p>
 * 事故受付情報を保持する。
 * </p>
 * @author RyoIsogami/SYS 2022/09/08
 */
public class AccidentReception implements Serializable {

	/* 事故受付番号*/
	private String claimNo;
	/* 事故受付フラグ*/
	private String claimStatus;
	/* 事故発生現場カナ１*/
	private String accidentLocationKana1;
	/* 事故発生現場カナ２*/
	private String accidentLocationKana2;
	/* 事故発生現場漢字１*/
	private String accidentLocationKanji1;
	/* 事故発生現場漢字２*/
	private String accidentLocationKanji2;
	/* 事故発生日付*/
	private String accidentDate;
	/* 事故状況*/
	private String accidentSituation;
	/* 過失割合・被保険者*/
	private Integer ratingBlameMyself;
	/* 過失割合・相手方*/
	private Integer ratingBlameYourself;
	/* 損害額・車両*/
	private Integer damageCarPrice;
	/* 損害額・対人*/
	private Integer damageBodilyPrice;
	/* 損害額・対物*/
	private Integer damagePropertyPrice;
	/* 損害額・傷害*/
	private Integer damageAccidentPrice;
	/* 損害状況・車両*/
	private String damageCarState;
	/* 損害状況・対人*/
	private String damageBodilyState;
	/* 損害状況・対物*/
	private String damagePropertyState;
	/* 損害状況・傷害*/
	private String damageAccidentState;
	/* 支払金額*/
	private Integer paymentPrice;




public AccidentReception() {

	claimNo = "";
	/* 事故受付フラグ*/
	claimStatus = "";
	/* 事故発生現場カナ１*/
	accidentLocationKana1 = "";
	/* 事故発生現場カナ２*/
	accidentLocationKana2 = "";
	/* 事故発生現場漢字１*/
	accidentLocationKanji1 = "";
	/* 事故発生現場漢字２*/
	accidentLocationKanji2 = "";
	/* 事故発生日付*/
	accidentDate = "00000000";
	/* 事故状況*/
	accidentSituation = "";
	/* 過失割合・被保険者*/
	ratingBlameMyself = 0;
	/* 過失割合・相手方*/
	ratingBlameYourself = 0;
	/* 損害額・車両*/
	damageCarPrice = 0;
	/* 損害額・対人*/
	damageBodilyPrice = 0;
	/* 損害額・対物*/
	damagePropertyPrice = 0;
	/* 損害額・傷害*/
	damageAccidentPrice = 0;
	/* 損害状況・車両*/
	damageCarState = "";
	/* 損害状況・対人*/
	damageBodilyState = "";
	/* 損害状況・対物*/
	damagePropertyState = "";
	/* 損害状況・傷害*/
	damageAccidentState = "";
	/* 支払金額*/
	paymentPrice = 0;

}










	/* 補償情報クラスの補償IDを取得*/
	Compensation compensation = new Compensation();
	private Integer coverId = compensation.getCoverId();

	/**
	 * 事故受付フラグ取得メソッド。
	 * <p>
	 * 画面に表示させるための事故受付フラグを取得する。
	 * </p>
	 * @return 事故受付フラグ
	 */
	public String getAccidentReceptionFlagForLabel() {
		if(claimStatus.equals("1")) {
			return "事故受付中";
		}else {
			return "受付完了済み";
		}
	}

	/**
	 * 支払金額取得メソッド。
	 * <p>
	 * 画面に表示させるための支払金額を取得する。
	 * 過失割合・被保険者に、損害額の合計をかけることで算出する。
	 * </p>
	 * @param accidentReception 事故受付情報オブジェクト
	 * @return 支払金額
	 */
	public String getPaymentPriceForlabel(AccidentReception accidentReception) {
		Integer damageSumPrice = accidentReception.getDamageCarPrice() + accidentReception.getDamageBodilyPrice() + accidentReception.getDamagePropertyPrice() + accidentReception.getDamageAccidentPrice();
		paymentPrice = accidentReception.getPaymentPrice() * damageSumPrice;
		return paymentPrice + "円";
	}

	/**
	 * 損害額・車両円表示メソッド
	 * <p>
	 * 画面に表示させるための損害額・車両を取得する。
	 * また損害額・車両は「円」をつけてリターンする。
	 * </p>
	 * @return 損害額・車両
	 */
	public String getDamageCarPriceForLabel() {
		return this.damageCarPrice + "円";
	}

	/**
	 * 損害額・対人円表示メソッド
	 * <p>
	 * 画面に表示させるための損害額・対人を取得する。
	 * また損害額・対人は「円」をつけてリターンする。
	 * </p>
	 * @return 損害額・対人
	 */
	public String getDamageBodilyPriceForLabel() {
		return this.damageBodilyPrice + "円";
	}

	/**
	 * 損害額・対物円表示メソッド
	 * <p>
	 * 画面に表示させるための損害額・対物を取得する。
	 * また損害額・対物は「円」をつけてリターンする。
	 * </p>
	 * @return 損害額・対物
	 */
	public String getDamagePropertyPriceForLabel() {
		return this.damagePropertyPrice + "円";
	}

	/**
	 * 損害額・傷害円表示メソッド
	 * <p>
	 * 画面に表示させるための損害額・傷害を取得する。
	 * また損害額・傷害は「円」をつけてリターンする。
	 * </p>
	 * @return 損害額・傷害
	 */
	public String getDamageAccidentPriceForLabel() {
		return this.damageAccidentPrice + "円";
	}


	/**
	 * 損害額・傷害円表示メソッド
	 * <p>
	 * 画面に表示させるための損害額・傷害を取得する。
	 * また損害額・傷害は「円」をつけてリターンする。
	 * </p>
	 * @return 損害額・傷害
	 */
	public String getPaymentPriceForLabel() {
		return this.paymentPrice + "円";
	}

	/**
	 * 生年月日メソッド
	 * <p>
	 * 画面に表示させるための生年月日を取得する。
	 * 西暦でリターンする。
	 * </p>
	 * @return 生年月日
	 */
	public String getAccidentDateForLabel() {
//		if(accidentDate == null) {
//			return;
//		}

		return this.accidentDate.substring(0, 4) + "年" + this.accidentDate.substring(4, 6) + "月" + this.accidentDate.substring(6, 8) + "日";
	}

	/*
     * 以下各メンバ変数のゲッター・セッター
     */
	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public String getAccidentLocationKana1() {
		return accidentLocationKana1;
	}

	public void setAccidentLocationKana1(String accidentLocationKana1) {
		this.accidentLocationKana1 = accidentLocationKana1;
	}

	public String getAccidentLocationKana2() {
		return accidentLocationKana2;
	}

	public void setAccidentLocationKana2(String accidentLocationKana2) {
		this.accidentLocationKana2 = accidentLocationKana2;
	}

	public String getAccidentLocationKanji1() {
		return accidentLocationKanji1;
	}

	public void setAccidentLocationKanji1(String accidentLocationKanji1) {
		this.accidentLocationKanji1 = accidentLocationKanji1;
	}

	public String getAccidentLocationKanji2() {
		return accidentLocationKanji2;
	}

	public void setAccidentLocationKanji2(String accidentLocationKanji2) {
		this.accidentLocationKanji2 = accidentLocationKanji2;
	}

	public String getAccidentDate() {
		return accidentDate;
	}

	public void setAccidentDate(String accidentDate) {
		this.accidentDate = accidentDate;
	}

	public Integer getRatingBlameMyself() {
		return ratingBlameMyself;
	}

	public void setRatingBlameMyself(Integer ratingBlameMyself) {
		this.ratingBlameMyself = ratingBlameMyself;
	}

	public Integer getRatingBlameYourself() {
		return ratingBlameYourself;
	}

	public void setRatingBlameYourself(Integer ratingBlameYourself) {
		this.ratingBlameYourself = ratingBlameYourself;
	}

	public Integer getDamageCarPrice() {
		return damageCarPrice;
	}

	public void setDamageCarPrice(Integer damageCarPrice) {
		this.damageCarPrice = damageCarPrice;
	}

	public Integer getDamageBodilyPrice() {
		return damageBodilyPrice;
	}

	public void setDamageBodilyPrice(Integer damageBodilyPrice) {
		this.damageBodilyPrice = damageBodilyPrice;
	}

	public Integer getDamagePropertyPrice() {
		return damagePropertyPrice;
	}

	public void setDamagePropertyPrice(Integer damagePropertyPrice) {
		this.damagePropertyPrice = damagePropertyPrice;
	}

	public Integer getDamageAccidentPrice() {
		return damageAccidentPrice;
	}

	public void setDamageAccidentPrice(Integer damageAccidentPrice) {
		this.damageAccidentPrice = damageAccidentPrice;
	}

	public String getDamageCarState() {
		return damageCarState;
	}

	public void setDamageCarState(String damageCarState) {
		this.damageCarState = damageCarState;
	}

	public String getDamageBodilyState() {
		return damageBodilyState;
	}

	public void setDamageBodilyState(String damageBodilyState) {
		this.damageBodilyState = damageBodilyState;
	}

	public String getDamagePropertyState() {
		return damagePropertyState;
	}

	public void setDamagePropertyState(String damagePropertyState) {
		this.damagePropertyState = damagePropertyState;
	}

	public String getDamageAccidentState() {
		return damageAccidentState;
	}

	public void setDamageAccidentState(String damageAccidentState) {
		this.damageAccidentState = damageAccidentState;
	}

	public Integer getPaymentPrice() {
		return paymentPrice;
	}

	public void setPaymentPrice(Integer paymentPrice) {
		this.paymentPrice = paymentPrice;
	}

	public Integer getCoverId() {
		return coverId;
	}

	public void setCoverId(Integer coverId) {
		this.coverId = coverId;
	}

	public String getAccidentSituation() {
		return accidentSituation;
	}

	public void setAccidentSituation(String accidentSituation) {
		this.accidentSituation = accidentSituation;
	}
}
