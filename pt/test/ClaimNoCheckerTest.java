package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import TS_Net.model.constant.ErrorMsgConst;
import TS_Net.model.data.AccidentReception;
import TS_Net.model.datacheck.ClaimNoChecker;

public class ClaimNoCheckerTest {


	/** テスト対象のオブジェクト */
	private AccidentReception accidentReception;
	private ClaimNoChecker CNC;

	@Before
	public void setUp() {
		accidentReception = new AccidentReception();
		CNC = new ClaimNoChecker();
	}

	/**
	 * claimNoExistenceCheck()メソッドテスト01
	 * <p>
	 * 正常系<br>
	 * 検証条件：処理対象のメンバ変数がブランクの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 入力された事故受付番号は存在しません。<br>
	 * </p>
	 */
	@Test
	public void testClaimNoExistenceCheck01() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0010;

		/* 入力値の設定 */
		accidentReception.setClaimNo("");

		/* テスト対象メソッドの呼び出し */
		String actual = CNC.claimNoExistenceCheck(accidentReception);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * claimNoExistenceCheck()メソッドテスト02
	 * <p>
	 * 正常系<br>
	 * 検証条件：処理対象のメンバ変数がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 入力された事故受付番号は存在しません。<br>
	 * </p>
	 */
	@Test
	public void testClaimNoExistenceCheck02() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0010;

		/* 入力値の設定 */
		accidentReception.setClaimNo(null);

		/* テスト対象メソッドの呼び出し */
		String actual = CNC.claimNoExistenceCheck(accidentReception);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * claimNoExistenceCheck()メソッドテスト03
	 * <p>
	 * 正常系<br>
	 * 検証条件：処理対象のメンバ変数がブランクまたはnull以外の場合<br>
	 * 想定結果：null値が返却される。<br>
	 * </p>
	 */
	@Test
	public void testClaimNoExistenceCheck03() {

		/* 期待値の定義 */
		String expected = null;

		/* 入力値の設定 */
		accidentReception.setClaimNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = CNC.claimNoExistenceCheck(accidentReception);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * claimNoProcessedCheck()メソッドテスト01
	 * <p>
	 * 正常系<br>
	 * 検証条件：処理対象のメンバ変数がブランクの場合<br>
	 * 想定結果：null値が返却される。<br>
	 * </p>
	 */
	@Test
	public void testClaimNoProcessedCheck01() {

		/* 期待値の定義 */
		String expected = null;

		/* 入力値の設定 */
		accidentReception.setClaimStatus("");

		/* テスト対象メソッドの呼び出し */
		String actual = CNC.claimNoProcessedCheck(accidentReception);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * claimNoProcessedCheck()メソッドテスト02
	 * <p>
	 * 正常系<br>
	 * 検証条件：処理対象のメンバ変数がnullの場合<br>
	 * 想定結果：null値が返却される。<br>
	 * </p>
	 */
	@Test
	public void testClaimNoProcessedCheck02() {

		/* 期待値の定義 */
		String expected = null;

		/* 入力値の設定 */
		accidentReception.setClaimStatus(null);

		/* テスト対象メソッドの呼び出し */
		String actual = CNC.claimNoProcessedCheck(accidentReception);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * claimNoProcessedCheck()メソッドテスト03
	 * <p>
	 * 正常系<br>
	 * 検証条件：処理対象のメンバ変数がブランクの場合<br>
	 * 想定結果：null値が返却される。<br>
	 * </p>
	 */
	@Test
	public void testClaimNoProcessedCheck03() {

		/* 期待値の定義 */
		String expected = null;

		/* 入力値の設定 */
		accidentReception.setClaimStatus("0");

		/* テスト対象メソッドの呼び出し */
		String actual = CNC.claimNoProcessedCheck(accidentReception);

		/* 検証 */
		assertEquals(expected, actual);

	}


	/**
	 * claimNoProcessedCheck()メソッドテスト04
	 * <p>
	 * 正常系<br>
	 * 検証条件：処理対象のメンバ変数がブランクの場合<br>
	 * 想定結果：null値が返却される。<br>
	 * </p>
	 */
	@Test
	public void testClaimNoProcessedCheck04() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0011;

		/* 入力値の設定 */
		accidentReception.setClaimStatus("1");

		/* テスト対象メソッドの呼び出し */
		String actual = CNC.claimNoProcessedCheck(accidentReception);

		/* 検証 */
		assertEquals(expected, actual);

	}

}
