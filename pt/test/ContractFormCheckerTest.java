/*------------------------------------------------------------------------------
 * 演習番号：[総合演習]
 * クラス名：[LoginProcessServlet]
 * 作成日  ：[2022/09/15]
 * 作成者  ：[NarimichiHenmi/SYS]
 *------------------------------------------------------------------------------
 * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
 *------------------------------------------------------------------------------
 */

package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import TS_Net.model.constant.ErrorMsgConst;
import TS_Net.model.data.ContractInfo;
import TS_Net.model.datacheck.ContractFormChecker;

public class ContractFormCheckerTest {
	/** テスト対象のオブジェクト */
	private ContractInfo CI;
	private ContractFormChecker CFC;

	@Before
	public void setUp() {
		CI = new ContractInfo();
		CFC = new ContractFormChecker();
	}

	/**
	 * Check()メソッドテスト01
	 * <p>
	 * 正常系<br>
	 * 検証条件：処理対象のメンバ変数がすべてブランクまたはnull以外の場合<br>
	 * 想定結果：null値が返却される。<br>
	 * </p>
	 */
	@Test
	public void testCheck01() {

		/* 期待値の定義 */
		String expected = null;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト02
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「insatsuRenban」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck02() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト03
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「insatsuRenban」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck03() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban(null);
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト04
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「inceptionDate」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck04() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト05
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「inceptionDate」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck05() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate(null);
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト06
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「inceptionTime」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck06() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト07
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「inceptionTime」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck07() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime(null);
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト08
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「conclusionDate」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck08() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト09
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「conclusionDate」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck09() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate(null);
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト10
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「conclusionTime」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck10() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト11
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「conclusionTime」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck11() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime(null);
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト12
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「paymentMethod」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck12() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト13
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「paymentMethod」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck13() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod(null);
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト14
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「installment」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck14() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(null);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト15
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「insuredKbn」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck15() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト16
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「insuredKbn」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck16() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn(null);
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト17
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「nameKana1」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck17() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト18
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「nameKana1」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck18() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1(null);
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト19
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「nameKana2」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck19() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト20
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「nameKana2」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck20() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2(null);
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト21
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「nameKanji1」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck21() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト22
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「nameKanji1」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck22() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1(null);
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト23
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「nameKanji2」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck23() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト24
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「NameKanji2」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck24() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2(null);
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト25
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「postcode」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck25() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト26
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「postcode」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck26() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode(null);
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト27
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「addressKana1」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck27() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト28
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「addressKana1」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck28() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1(null);
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト29
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「addressKana2」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck29() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト30
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「addressKana2」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck30() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2(null);
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト31
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「addressKanji1」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck31() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト32
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「addressKanji1」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck32() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1(null);
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト33
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「addressKanji2」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck33() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト34
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「addressKanji2」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck34() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2(null);
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト35
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「birthday」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck35() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト36
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「birthday」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck36() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday(null);
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト37
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「gender」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck37() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト38
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「gender」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck38() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender(null);
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト39
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「telephoneNo」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck39() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト40
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「telephoneNo」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck40() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo(null);
		CI.setMobilephoneNo("test");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト41
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「mobilephoneNo」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck41() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("");
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト42
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「mobilephoneNo」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck42() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo(null);
		CI.setFaxNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト43
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「faxNo」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck43() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo("");

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト44
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「faxNo」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck44() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		CI.setInsatsuRenban("test");
		CI.setInceptionDate("test");
		CI.setInceptionTime("test");
		CI.setConclusionDate("test");
		CI.setConclusionTime("test");
		CI.setPaymentMethod("test");
		CI.setInstallment(0);
		CI.setInsuredKbn("test");
		CI.setNameKana1("test");
		CI.setNamekana2("test");
		CI.setNameKanji1("test");
		CI.setNameKanji2("test");
		CI.setPostcode("test");
		CI.setAddressKana1("test");
		CI.setAddressKana2("test");
		CI.setAddressKanji1("test");
		CI.setAddressKanji2("test");
		CI.setBirthday("test");
		CI.setGender("test");
		CI.setTelephoneNo("test");
		CI.setMobilephoneNo("test");
		CI.setFaxNo(null);

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}


}
