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

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import TS_Net.model.constant.ErrorMsgConst;
import TS_Net.model.data.AccidentReception;
import TS_Net.model.datacheck.AccidentReceptionFormChecker;

public class AccidentReceptionFormCheckerTest {
	/** テスト対象のオブジェクト */
	private AccidentReception AR;
	private AccidentReceptionFormChecker ARFC;

	@Before
	public void setUp() {
		AR = new AccidentReception();
		ARFC = new AccidentReceptionFormChecker();
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
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト02
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「claimNo」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck02() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト03
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「claimNo」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck03() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo(null);
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト04
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「accidentLocationKana1」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck04() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト05
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「accidentLocationKana1」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck05() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1(null);
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト06
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「accidentLocationKana2」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck06() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト07
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「accidentLocationKana2」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck07() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2(null);
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト08
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「accidentLocationKanji1」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck08() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト09
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「accidentLocationKanji1」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck09() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1(null);
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト10
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「accidentLocationKanji2」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck10() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト11
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「accidentLocationKanji2」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck11() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2(null);
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト12
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「accidentDate」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck12() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト13
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「accidentDate」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck13() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate(null);
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト14
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「accidentSituation」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck14() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト15
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「accidentSituation」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck15() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation(null);
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト16
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「ratingBlameMyself」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck16() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(null);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト17
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「ratingBlameYourself」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck17() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(null);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト18
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「damageCarPrice」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck18() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(null);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}


	/**
	 * Check()メソッドテスト19
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「damageBodilyPrice」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck19() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(null);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト20
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「damagePropertyPrice」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck20() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(null);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト21
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「damageAccidentPrice」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck21() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(null);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト22
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「damageCarState」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck22() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト29
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「damageCarState」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck23() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState(null);
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト24
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「damageBodilyState」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck24() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト25
	 * <p>
	 * 正常系<br>
	 * 検証条件：：メンバ変数「damageBodilyState」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck25() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState(null);
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト26
	 * <p>
	 * 正常系<br>
	 * 検証条件：：メンバ変数「damagePropertyState」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck26() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト27
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「damagePropertyState」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck27() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState(null);
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト28
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「damageAccidentState」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck28() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("");
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト29
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「damageAccidentState」が空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck29() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState(null);
		AR.setPaymentPrice(0);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * Check()メソッドテスト30
	 * <p>
	 * 正常系<br>
	 * 検証条件：メンバ変数「paymentPrice」がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testCheck37() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		AR.setClaimNo("test");
		AR.setAccidentLocationKana1("test");
		AR.setAccidentLocationKana2("test");
		AR.setAccidentLocationKanji1("test");
		AR.setAccidentLocationKanji2("test");
		AR.setAccidentDate("test");
		AR.setAccidentSituation("test");
		AR.setRatingBlameMyself(0);
		AR.setRatingBlameYourself(0);
		AR.setDamageCarPrice(0);
		AR.setDamageBodilyPrice(0);
		AR.setDamagePropertyPrice(0);
		AR.setDamageAccidentPrice(0);
		AR.setDamageCarState("test");
		AR.setDamageBodilyState("test");
		AR.setDamagePropertyState("test");
		AR.setDamageAccidentState("test");
		AR.setPaymentPrice(null);

		/* テスト対象メソッドの呼び出し */
		List<Integer> actual = ARFC.check(AR);

		/* 検証 */
		assertEquals(expected, actual);

	}
}
