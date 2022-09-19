/*-----------------------------------------------------
 * 演習番号：総合演習
 * クラス名:[ContractInfoTest]
 * 作成日：[2022/09/07]
 * 作成者：[Akane Nambu/SYS]
 * ----------------------------------------------------
 * 修正履歴（発注No.：修正日：担当者：）
 *------------------------------------------------------------------------------
 *
 */
package test;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import TS_Net.model.data.ContractInfo;


public class ContractInfoTest {

	/** テスト対象のオブジェクト */
	private ContractInfo CI;

	@Before
	public void setUp() {
		CI = new ContractInfo();
	}

	/**
	 * getStatusFlgForLabel()メソッドテスト01
	 * <p>
	 * 正常系<br>
	 * 検証条件：契約状態を取得し、リターンできるかの検証<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 解約済<br>
	 * </p>
	 */
	@Test
	public void testgetStatusFlgForLabel01() {
		/* 期待値の定義 */
		String expected = "解約済";

		/* 入力値の設定 */
		CI.setStatusFlg("0");

		/* テスト対象メソッドの呼び出し */
		String actual = CI.getStatusFlgForLabel();

		/* 検証 */
		assertEquals(expected, actual);
	}

	/**
	 * getStatusFlgForLabel()メソッドテスト02
	 * <p>
	 * 正常系<br>
	 * 検証条件：契約状態を取得し、リターンできるかの検証<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 契約中<br>
	 * </p>
	 */
	@Test
	public void testgetStatusFlgForLabel02() {
		/* 期待値の定義 */
		String expected = "契約中";

		/* 入力値の設定 */
		CI.setStatusFlg("1");

		/* テスト対象メソッドの呼び出し */
		String actual = CI.getStatusFlgForLabel();

		/* 検証 */
		assertEquals(expected, actual);
	}

	/**
	 * getPaymentMethodForLabel()メソッドテスト01
	 * <p>
	 * 正常系<br>
	 * 検証条件：払込方法を取得し、リターンできるかの検証<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 直接集金<br>
	 * </p>
	 */
	@Test
	public void testgetPaymentMethodForLabel01() {
		/* 期待値の定義 */
		String expected = "直接集金";

		/* 入力値の設定 */
		CI.setPaymentMethod("1");

		/* テスト対象メソッドの呼び出し */
		String actual = CI.getPaymentMethodForLabel();

		/* 検証 */
		assertEquals(expected, actual);
	}

	/**
	 * getPaymentMethodForLabel()メソッドテスト02
	 * <p>
	 * 正常系<br>
	 * 検証条件：払込方法を取得し、リターンできるかの検証<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 口座振替<br>
	 * </p>
	 */
	@Test
	public void testgetPaymentMethodForLabel02() {
		/* 期待値の定義 */
		String expected = "口座振替";

		/* 入力値の設定 */
		CI.setPaymentMethod("2");

		/* テスト対象メソッドの呼び出し */
		String actual = CI.getPaymentMethodForLabel();

		/* 検証 */
		assertEquals(expected, actual);
	}

	/**
	 * getPaymentMethodForLabel()メソッドテスト03
	 * <p>
	 * 正常系<br>
	 * 検証条件：払込方法を取得し、リターンできるかの検証<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * クレジットカード<br>
	 * </p>
	 */
	@Test
	public void testgetPaymentMethodForLabel03() {
		/* 期待値の定義 */
		String expected = "クレジットカード";

		/* 入力値の設定 */
		CI.setPaymentMethod("3");

		/* テスト対象メソッドの呼び出し */
		String actual = CI.getPaymentMethodForLabel();

		/* 検証 */
		assertEquals(expected, actual);
	}

	/**
	 * getGenderForLabel()メソッドテスト01
	 * <p>
	 * 正常系<br>
	 * 検証条件：性別を取得し、リターンできるかの検証<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 男<br>
	 * </p>
	 */
	@Test
	public void testgetGenderForLabel01() {
		/* 期待値の定義 */
		String expected = "男";

		/* 入力値の設定 */
		CI.setGender("1");

		/* テスト対象メソッドの呼び出し */
		String actual = CI.getGenderForLabel();

		/* 検証 */
		assertEquals(expected, actual);
	}

	/**
	 * getGenderForLabel()メソッドテスト02
	 * <p>
	 * 正常系<br>
	 * 検証条件：性別を取得し、リターンできるかの検証<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 女<br>
	 * </p>
	 */
	@Test
	public void testgetGenderForLabel02() {
		/* 期待値の定義 */
		String expected = "女";

		/* 入力値の設定 */
		CI.setGender("2");

		/* テスト対象メソッドの呼び出し */
		String actual = CI.getGenderForLabel();

		/* 検証 */
		assertEquals(expected, actual);
	}

	/**
	 * getInsuredKbnForLabel()メソッドテスト01
	 * <p>
	 * 正常系<br>
	 * 検証条件：被保険者区分を取得し、リターンできるかの検証<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 個人<br>
	 * </p>
	 */
	@Test
	public void testgetInsuredKbnForLabel01(){
		/* 期待値の定義 */
		String expected = "個人";

		/* 入力値の設定 */
		CI.setInsuredKbn("1");

		/* テスト対象メソッドの呼び出し */
		String actual = CI.getInsuredKbnForLabel();

		/* 検証 */
		assertEquals(expected, actual);
	}

	/**
	 * getInsuredKbnForLabel()メソッドテスト02
	 * <p>
	 * 正常系<br>
	 * 検証条件：被保険者区分を取得し、リターンできるかの検証<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 法人<br>
	 * </p>
	 */
	@Test
	public void testgetInsuredKbnForLabel02(){
		/* 期待値の定義 */
		String expected = "法人";

		/* 入力値の設定 */
		CI.setInsuredKbn("2");

		/* テスト対象メソッドの呼び出し */
		String actual = CI.getInsuredKbnForLabel();

		/* 検証 */
		assertEquals(expected, actual);
	}

	/**
	 * getNameForLabel()メソッドテスト
	 * <p>
	 * 正常系<br>
	 * 検証条件：契約者氏名を取得し、様をつけてリターンできるかの検証<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 東海太郎<br>
	 * </p>
	 */
	@Test
	public void testgetNameForLabel(){
		/* 期待値の定義 */
		String expected = "東海太郎様";

		/* 入力値の設定 */
		CI.setNameKanji1("東海");
		CI.setNameKanji2("太郎");

		/* テスト対象メソッドの呼び出し */
		String actual = CI.getNameForLabel();

		/* 検証 */
		assertEquals(expected, actual);
	}

	/**
	 * getkanaNameForLabel()メソッドテスト
	 * <p>
	 * 正常系<br>
	 * 検証条件：カナ契約者氏名を取得し、様をつけてリターンできるかの検証<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * トウカイタロウ<br>
	 * </p>
	 */
	@Test
	public void testgetkanaNameForLabel(){
		/* 期待値の定義 */
		String expected = "トウカイタロウ様";

		/* 入力値の設定 */
		CI.setNameKana1("トウカイ");
		CI.setNameKana2("タロウ");

		/* テスト対象メソッドの呼び出し */
		String actual = CI.getkanaNameForLabel();

		/* 検証 */
		assertEquals(expected, actual);
	}

	/**
	 * getKanjiAddressForLabel()メソッドテスト
	 * <p>
	 * 正常系<br>
	 * 検証条件：漢字住所を取得し、リターンできるかの検証<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * トウカイタロウ<br>
	 * </p>
	 */
	@Test
	public void testgetKanjiAddressForLabel(){
		/* 期待値の定義 */
		String expected = "島根県 益田市 高津町 １－２－１２３";

		/* 入力値の設定 */
		CI.setAddressKanji1("島根県 益田市 高津町");
		CI.setAddressKanji2("１－２－１２３");

		/* テスト対象メソッドの呼び出し */
		String actual = CI.getKanjiAddressForLabel();

		/* 検証 */
		assertEquals(expected, actual);
	}

	/**
	 * getKanaAddressForLabel()メソッドテスト
	 * <p>
	 * 正常系<br>
	 * 検証条件：カナ住所を取得し、リターンできるかの検証<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * シマネケン マスダシ タカツチョウ １－２－１２３<br>
	 * </p>
	 */
	@Test
	public void testgetKanaAddressForLabel() {
		String expected = "シマネケン マスダシ タカツチョウ １－２－１２３";

		/* 入力値の設定 */
		CI.setAddressKana1("シマネケン マスダシ タカツチョウ");
		CI.setAddressKana2("１－２－１２３");

		/* テスト対象メソッドの呼び出し */
		String actual = CI.getKanaAddressForLabel();

		/* 検証 */
		assertEquals(expected, actual);
	}

	/**
	 * getPostcodeForLabel()メソッドテスト
	 * <p>
	 * 正常系<br>
	 * 検証条件：郵便番号を取得し、〒をつけてリターンできるかの検証<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 〒698-0041<br>
	 * </p>
	 */
	@Test
	public void testgetPostcodeForLabel() {
		String expected = "〒698-0041";

		/* 入力値の設定 */
		CI.setPostcode("6980041");

		/* テスト対象メソッドの呼び出し */
		String actual = CI.getPostcodeForLabel();

		/* 検証 */
		assertEquals(expected, actual);
	}

	/**
	 * getBirthdayForLabel()メソッドテスト
	 * <p>
	 * 正常系<br>
	 * 検証条件：生年月日を取得し、西暦でリターンできるかの検証<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 〒698-0041<br>
	 * </p>
	 */
	@Test
	public void testgetBirthdayForLabel(){
		String expected = "1980年12月23日";

		/* 入力値の設定 */
		CI.setBirthday("19801223");

		/* テスト対象メソッドの呼び出し */
		String actual = CI.getBirthdayForLabel();

		/* 検証 */
		assertEquals(expected, actual);
	}

	/**
	 * getInsureanceIntervalForLabel()メソッドテスト
	 * <p>
	 * 正常系<br>
	 * 検証条件：保険期間を取得し、西暦でリターンできるかの検証<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 〒698-0041<br>
	 * </p>
	 */
	@Test
	public void testgetInsureanceIntervalForLabel(){
		String expected = "2016年07月05日から2017年07月05日まで";

		/* 入力値の設定 */
		CI.setInceptionDate("20160705");
		CI.setConclusionDate("20170705");

		/* テスト対象メソッドの呼び出し */
		String actual = CI.getInsureanceIntervalForLabel();

		/* 検証 */
		assertEquals(expected, actual);
	}


	/**
	 * getTelephoneNoForLabel()メソッドテスト
	 * <p>
	 * 正常系<br>
	 * 検証条件：電話番号を取得し、リターンできるかの検証<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 012-3789-456<br>
	 * </p>
	 * @throws ParseException
	 */
	@Test
	public void testgetTelephoneNoForLabel() throws ParseException{
		String expected = "012-3789-456";

		/* 入力値の設定 */
		CI.setTelephoneNo("0123789456");

		/* テスト対象メソッドの呼び出し */
		String actual = CI.getTelephoneNoForLabel();

		/* 検証 */
		assertEquals(expected, actual);
	}

	/**
	 * getFaxNoForLabel()メソッドテスト
	 * <p>
	 * 正常系<br>
	 * 検証条件：電話番号を取得し、リターンできるかの検証<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 033-9873-214<br>
	 * </p>
	 * @throws ParseException
	 */
	@Test
	public void testgetFaxNoForLabel() throws ParseException{
		String expected = "033-9873-214";

		/* 入力値の設定 */
		CI.setFaxNo("0339873214");

		/* テスト対象メソッドの呼び出し */
		String actual = CI.getFaxNoForLabel();

		/* 検証 */
		assertEquals(expected, actual);
	}

	/**
	 * getMobilePhoneNoForLabel()メソッドテスト
	 * <p>
	 * 正常系<br>
	 * 検証条件：電話番号を取得し、リターンできるかの検証<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 090-6789-1234<br>
	 * </p>
	 * @throws ParseException
	 */
	@Test
	public void testgetMobilePhoneNoForLabel() throws ParseException{
		String expected = "090-6789-1234";

		/* 入力値の設定 */
		CI.setMobilephoneNo("09067891234");

		/* テスト対象メソッドの呼び出し */
		String actual = CI.getMobilePhoneNoForLabel();

		/* 検証 */
		assertEquals(expected, actual);
	}

}
