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
import TS_Net.model.data.Compensation;
import TS_Net.model.datacheck.CompensationFormChecker;

public class CompensationFormCheckerTest {

	/** テスト対象のオブジェクト */
	private Compensation Com;
	private CompensationFormChecker CFC;

	@Before
	public void setUp() {
		Com = new Compensation();
		CFC = new CompensationFormChecker();
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
		Com.setMaker("test");
		Com.setCarName("test");
		Com.setLicenseNo("test");
		Com.setVehiclePrice(0);
		Com.setVehicleRates("test");
		Com.setBodilyRates("test");
		Com.setPropertyDamageRates("test");
		Com.setAccidentRates("test");
		Com.setLicenseColor("test");
		Com.setAgeLimit("test");
		Com.setPremiumAmount(0);
		Com.setPremiumInstallment(0);

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(Com);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト02
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「marker」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck02() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		Com.setMaker("");
		Com.setCarName("test");
		Com.setLicenseNo("test");
		Com.setVehiclePrice(0);
		Com.setVehicleRates("test");
		Com.setBodilyRates("test");
		Com.setPropertyDamageRates("test");
		Com.setAccidentRates("test");
		Com.setLicenseColor("test");
		Com.setAgeLimit("test");
		Com.setPremiumAmount(0);
		Com.setPremiumInstallment(0);

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(Com);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト03
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「marker」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck03() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		Com.setMaker(null);
		Com.setCarName("test");
		Com.setLicenseNo("test");
		Com.setVehiclePrice(0);
		Com.setVehicleRates("test");
		Com.setBodilyRates("test");
		Com.setPropertyDamageRates("test");
		Com.setAccidentRates("test");
		Com.setLicenseColor("test");
		Com.setAgeLimit("test");
		Com.setPremiumAmount(0);
		Com.setPremiumInstallment(0);

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(Com);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト04
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「carName」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck04() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		Com.setMaker("test");
		Com.setCarName("");
		Com.setLicenseNo("test");
		Com.setVehiclePrice(0);
		Com.setVehicleRates("test");
		Com.setBodilyRates("test");
		Com.setPropertyDamageRates("test");
		Com.setAccidentRates("test");
		Com.setLicenseColor("test");
		Com.setAgeLimit("test");
		Com.setPremiumAmount(0);
		Com.setPremiumInstallment(0);

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(Com);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト05
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「carName」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck05() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		Com.setMaker("test");
		Com.setCarName(null);
		Com.setLicenseNo("test");
		Com.setVehiclePrice(0);
		Com.setVehicleRates("test");
		Com.setBodilyRates("test");
		Com.setPropertyDamageRates("test");
		Com.setAccidentRates("test");
		Com.setLicenseColor("test");
		Com.setAgeLimit("test");
		Com.setPremiumAmount(0);
		Com.setPremiumInstallment(0);

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(Com);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト06
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「licenseNo」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck06() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		Com.setMaker("test");
		Com.setCarName("test");
		Com.setLicenseNo("");
		Com.setVehiclePrice(0);
		Com.setVehicleRates("test");
		Com.setBodilyRates("test");
		Com.setPropertyDamageRates("test");
		Com.setAccidentRates("test");
		Com.setLicenseColor("test");
		Com.setAgeLimit("test");
		Com.setPremiumAmount(0);
		Com.setPremiumInstallment(0);

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(Com);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト07
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「licenseNo」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck07() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		Com.setMaker("test");
		Com.setCarName("test");
		Com.setLicenseNo(null);
		Com.setVehiclePrice(0);
		Com.setVehicleRates("test");
		Com.setBodilyRates("test");
		Com.setPropertyDamageRates("test");
		Com.setAccidentRates("test");
		Com.setLicenseColor("test");
		Com.setAgeLimit("test");
		Com.setPremiumAmount(0);
		Com.setPremiumInstallment(0);

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(Com);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト08
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「vehiclePrice」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck08() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		Com.setMaker("test");
		Com.setCarName("test");
		Com.setLicenseNo("test");
		Com.setVehiclePrice(null);
		Com.setVehicleRates("test");
		Com.setBodilyRates("test");
		Com.setPropertyDamageRates("test");
		Com.setAccidentRates("test");
		Com.setLicenseColor("test");
		Com.setAgeLimit("test");
		Com.setPremiumAmount(0);
		Com.setPremiumInstallment(0);

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(Com);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト09
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「vehicleRates」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck09() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		Com.setMaker("test");
		Com.setCarName("test");
		Com.setLicenseNo("test");
		Com.setVehiclePrice(0);
		Com.setVehicleRates("");
		Com.setBodilyRates("test");
		Com.setPropertyDamageRates("test");
		Com.setAccidentRates("test");
		Com.setLicenseColor("test");
		Com.setAgeLimit("test");
		Com.setPremiumAmount(0);
		Com.setPremiumInstallment(0);

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(Com);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト10
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「vehicleRates」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck10() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		Com.setMaker("test");
		Com.setCarName("test");
		Com.setLicenseNo("test");
		Com.setVehiclePrice(0);
		Com.setVehicleRates(null);
		Com.setBodilyRates("test");
		Com.setPropertyDamageRates("test");
		Com.setAccidentRates("test");
		Com.setLicenseColor("test");
		Com.setAgeLimit("test");
		Com.setPremiumAmount(0);
		Com.setPremiumInstallment(0);

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(Com);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト11
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「bodilyRates」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck11() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		Com.setMaker("test");
		Com.setCarName("test");
		Com.setLicenseNo("test");
		Com.setVehiclePrice(0);
		Com.setVehicleRates("test");
		Com.setBodilyRates("");
		Com.setPropertyDamageRates("test");
		Com.setAccidentRates("test");
		Com.setLicenseColor("test");
		Com.setAgeLimit("test");
		Com.setPremiumAmount(0);
		Com.setPremiumInstallment(0);

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(Com);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト12
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「bodilyRates」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck12() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		Com.setMaker("test");
		Com.setCarName("test");
		Com.setLicenseNo("test");
		Com.setVehiclePrice(0);
		Com.setVehicleRates("test");
		Com.setBodilyRates(null);
		Com.setPropertyDamageRates("test");
		Com.setAccidentRates("test");
		Com.setLicenseColor("test");
		Com.setAgeLimit("test");
		Com.setPremiumAmount(0);
		Com.setPremiumInstallment(0);

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(Com);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト13
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「propertyDamageRates」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck13() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		Com.setMaker("test");
		Com.setCarName("test");
		Com.setLicenseNo("test");
		Com.setVehiclePrice(0);
		Com.setVehicleRates("test");
		Com.setBodilyRates("test");
		Com.setPropertyDamageRates("");
		Com.setAccidentRates("test");
		Com.setLicenseColor("test");
		Com.setAgeLimit("test");
		Com.setPremiumAmount(0);
		Com.setPremiumInstallment(0);

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(Com);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト14
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「propertyDamageRates」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck14() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		Com.setMaker("test");
		Com.setCarName("test");
		Com.setLicenseNo("test");
		Com.setVehiclePrice(0);
		Com.setVehicleRates("test");
		Com.setBodilyRates("test");
		Com.setPropertyDamageRates(null);
		Com.setAccidentRates("test");
		Com.setLicenseColor("test");
		Com.setAgeLimit("test");
		Com.setPremiumAmount(0);
		Com.setPremiumInstallment(0);

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(Com);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト15
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「accidentRates」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck15() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		Com.setMaker("test");
		Com.setCarName("test");
		Com.setLicenseNo("test");
		Com.setVehiclePrice(0);
		Com.setVehicleRates("test");
		Com.setBodilyRates("test");
		Com.setPropertyDamageRates("test");
		Com.setAccidentRates("");
		Com.setLicenseColor("test");
		Com.setAgeLimit("test");
		Com.setPremiumAmount(0);
		Com.setPremiumInstallment(0);

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(Com);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト16
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「accidentRates」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck16() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		Com.setMaker("test");
		Com.setCarName("test");
		Com.setLicenseNo("test");
		Com.setVehiclePrice(0);
		Com.setVehicleRates("test");
		Com.setBodilyRates("test");
		Com.setPropertyDamageRates("test");
		Com.setAccidentRates(null);
		Com.setLicenseColor("test");
		Com.setAgeLimit("test");
		Com.setPremiumAmount(0);
		Com.setPremiumInstallment(0);

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(Com);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト17
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「licenseColor」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck17() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		Com.setMaker("test");
		Com.setCarName("test");
		Com.setLicenseNo("test");
		Com.setVehiclePrice(0);
		Com.setVehicleRates("test");
		Com.setBodilyRates("test");
		Com.setPropertyDamageRates("test");
		Com.setAccidentRates("test");
		Com.setLicenseColor("");
		Com.setAgeLimit("test");
		Com.setPremiumAmount(0);
		Com.setPremiumInstallment(0);

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(Com);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト18
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「licenseColor」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck18() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		Com.setMaker("test");
		Com.setCarName("test");
		Com.setLicenseNo("test");
		Com.setVehiclePrice(0);
		Com.setVehicleRates("test");
		Com.setBodilyRates("test");
		Com.setPropertyDamageRates("test");
		Com.setAccidentRates("test");
		Com.setLicenseColor(null);
		Com.setAgeLimit("test");
		Com.setPremiumAmount(0);
		Com.setPremiumInstallment(0);

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(Com);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト19
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「ageLimit」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck19() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		Com.setMaker("test");
		Com.setCarName("test");
		Com.setLicenseNo("test");
		Com.setVehiclePrice(0);
		Com.setVehicleRates("test");
		Com.setBodilyRates("test");
		Com.setPropertyDamageRates("test");
		Com.setAccidentRates("test");
		Com.setLicenseColor("test");
		Com.setAgeLimit("");
		Com.setPremiumAmount(0);
		Com.setPremiumInstallment(0);

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(Com);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト20
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「ageLimit」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck20() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		Com.setMaker("test");
		Com.setCarName("test");
		Com.setLicenseNo("test");
		Com.setVehiclePrice(0);
		Com.setVehicleRates("test");
		Com.setBodilyRates("test");
		Com.setPropertyDamageRates("test");
		Com.setAccidentRates("test");
		Com.setLicenseColor("test");
		Com.setAgeLimit(null);
		Com.setPremiumAmount(0);
		Com.setPremiumInstallment(0);

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(Com);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト21
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「premiumAmount」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck23() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		Com.setMaker("test");
		Com.setCarName("test");
		Com.setLicenseNo("test");
		Com.setVehiclePrice(0);
		Com.setVehicleRates("test");
		Com.setBodilyRates("test");
		Com.setPropertyDamageRates("test");
		Com.setAccidentRates("test");
		Com.setLicenseColor("test");
		Com.setAgeLimit("test");
		Com.setPremiumAmount(null);
		Com.setPremiumInstallment(0);

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(Com);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト22
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「premiumInstallment」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck25() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		Com.setMaker("test");
		Com.setCarName("test");
		Com.setLicenseNo("test");
		Com.setVehiclePrice(0);
		Com.setVehicleRates("test");
		Com.setBodilyRates("test");
		Com.setPropertyDamageRates("test");
		Com.setAccidentRates("test");
		Com.setLicenseColor("test");
		Com.setAgeLimit("test");
		Com.setPremiumAmount(0);
		Com.setPremiumInstallment(null);

		/* テスト対象メソッドの呼び出し */
		String actual = CFC.check(Com);

		/* 検証 */
		assertEquals(expected, actual);

	}

}
