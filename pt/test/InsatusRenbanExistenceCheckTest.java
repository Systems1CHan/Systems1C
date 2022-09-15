package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import TS_Net.model.constant.ErrorMsgConst;
import TS_Net.model.data.Compensation;
import TS_Net.model.data.ContractInfo;
import TS_Net.model.datacheck.InsatsuRenbanChecker;

public class InsatusRenbanExistenceCheckTest {


	/** テスト対象のオブジェクト */
	private Compensation compensation;
	private ContractInfo contractInfo;
	private InsatsuRenbanChecker IRC;

	@Before
	public void setUp() {
		compensation = new Compensation();
		contractInfo = new ContractInfo();
		IRC = new InsatsuRenbanChecker();
	}

	/**
	 * claimNoExistenceCheck()メソッドテスト01
	 * <p>
	 * 正常系<br>
	 * 検証条件：処理対象のメンバ変数がブランクの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 入力された印刷連番は存在しません。<br>
	 * </p>
	 */
	@Test
	public void testClaimNoExistenceCheck01() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0004;

		/* 入力値の設定 */
		compensation.setInsatsuRenban("");

		/* テスト対象メソッドの呼び出し */
		String actual = IRC.insatusRenbanExistenceCheck(compensation);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * claimNoExistenceCheck()メソッドテスト02
	 * <p>
	 * 正常系<br>
	 * 検証条件：処理対象のメンバ変数がnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 入力された印刷連番は存在しません。<br>
	 * </p>
	 */
	@Test
	public void testClaimNoExistenceCheck02() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0004;

		/* 入力値の設定 */
		compensation.setInsatsuRenban(null);

		/* テスト対象メソッドの呼び出し */
		String actual = IRC.insatusRenbanExistenceCheck(compensation);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * claimNoExistenceCheck()メソッドテスト03
	 * <p>
	 * 正常系<br>
	 * 検証条件：処理対象のメンバ変数がブランクの場合<br>
	 * 想定結果：null値が返却される。<br>
	 * </p>
	 */
	@Test
	public void testClaimNoExistenceCheck03() {

		/* 期待値の定義 */
		String expected = null;

		/* 入力値の設定 */
		compensation.setInsatsuRenban("test");

		/* テスト対象メソッドの呼び出し */
		String actual = IRC.insatusRenbanExistenceCheck(compensation);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * polNoCancelledCheck()メソッドテスト01
	 * <p>
	 * 正常系<br>
	 * 検証条件：処理対象のメンバ変数がブランクの場合<br>
	 * 想定結果：null値が返却される。<br>
	 * </p>
	 */
	@Test
	public void testPolNoCancelledCheck01() {

		/* 期待値の定義 */
		String expected = null;

		/* 入力値の設定 */
		contractInfo.setStatusFlg("");

		/* テスト対象メソッドの呼び出し */
		String actual = IRC.polNoCancelledCheck(contractInfo);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * polNoCancelledCheck()メソッドテスト02
	 * <p>
	 * 正常系<br>
	 * 検証条件：処理対象のメンバ変数がnullの場合<br>
	 * 想定結果：null値が返却される。<br>
	 * </p>
	 */
	@Test
	public void testPolNoCancelledCheck02() {

		/* 期待値の定義 */
		String expected = null;

		/* 入力値の設定 */
		contractInfo.setStatusFlg(null);

		/* テスト対象メソッドの呼び出し */
		String actual = IRC.polNoCancelledCheck(contractInfo);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * polNoCancelledCheck()メソッドテスト03
	 * <p>
	 * 正常系<br>
	 * 検証条件：処理対象のメンバ変数が0以外の場合<br>
	 * 想定結果：null値が返却される。<br>
	 * </p>
	 */
	@Test
	public void testPolNoCancelledCheck03() {

		/* 期待値の定義 */
		String expected = null;

		/* 入力値の設定 */
		contractInfo.setStatusFlg("test");

		/* テスト対象メソッドの呼び出し */
		String actual = IRC.polNoCancelledCheck(contractInfo);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * polNoCancelledCheck()メソッドテスト04
	 * <p>
	 * 正常系<br>
	 * 検証条件：処理対象のメンバ変数が0以外の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 入力された事故受付番号は処理済みです。<br>
	 * </p>
	 */
	@Test
	public void testPolNoCancelledCheck04() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0005;

		/* 入力値の設定 */
		contractInfo.setStatusFlg("0");

		/* テスト対象メソッドの呼び出し */
		String actual = IRC.polNoCancelledCheck(contractInfo);

		/* 検証 */
		assertEquals(expected, actual);

	}

}
