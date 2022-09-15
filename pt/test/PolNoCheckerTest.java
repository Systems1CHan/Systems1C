/*------------------------------------------------------------------------------
 * 演習番号：[総合演習]
 * クラス名：[PolNoCheckerTest]
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
import TS_Net.model.datacheck.PolNoChecker;

public class PolNoCheckerTest {

	/** テスト対象のオブジェクト */
	private ContractInfo CI;
	private PolNoChecker PNC;

	@Before
	public void setUp() {
		CI = new ContractInfo();
		PNC = new PolNoChecker();
	}

	/**
	 * polNoInputCheck()メソッドテスト01
	 * <p>
	 * 正常系<br>
	 * 検証条件：polNoが空文字の場合<br>
	 * 想定結果：null値が返却される。<br>
	 * </p>
	 */
	@Test
	public void testPolNoInputCheck01() {

		/* 期待値の定義 */
		String expected = null;

		/* 入力値の設定 */
		String polNo = "";
		String claimNo = "test";

		/* テスト対象メソッドの呼び出し */
		String actual = PNC.polNoInputCheck(polNo, claimNo);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * polNoInputCheck()メソッドテスト02
	 * <p>
	 * 正常系<br>
	 * 検証条件：polNoが空文字の場合<br>
	 * 想定結果：null値が返却される。<br>
	 * </p>
	 */
	@Test
	public void testPolNoInputCheck02() {

		/* 期待値の定義 */
		String expected = null;

		/* 入力値の設定 */
		String polNo = null;
		String claimNo = "test";

		/* テスト対象メソッドの呼び出し */
		String actual = PNC.polNoInputCheck(polNo, claimNo);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * polNoInputCheck()メソッドテスト03
	 * <p>
	 * 正常系<br>
	 * 検証条件：polNoが空文字の場合<br>
	 * 想定結果：null値が返却される。<br>
	 * </p>
	 */
	@Test
	public void testPolNoInputCheck03() {

		/* 期待値の定義 */
		String expected = null;

		/* 入力値の設定 */
		String polNo = "test";
		String claimNo = "";

		/* テスト対象メソッドの呼び出し */
		String actual = PNC.polNoInputCheck(polNo, claimNo);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * polNoInputCheck()メソッドテスト04
	 * <p>
	 * 正常系<br>
	 * 検証条件：polNoが空文字の場合<br>
	 * 想定結果：null値が返却される。<br>
	 * </p>
	 */
	@Test
	public void testPolNoInputCheck04() {

		/* 期待値の定義 */
		String expected = null;

		/* 入力値の設定 */
		String polNo = "test";
		String claimNo = null;

		/* テスト対象メソッドの呼び出し */
		String actual = PNC.polNoInputCheck(polNo, claimNo);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * polNoInputCheck()メソッドテスト05
	 * <p>
	 * 正常系<br>
	 * 検証条件：polNoが空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 新規事故受付の場合は証券番号、事故状況更新の場合は事故受付番号のどちらか一方を入力してください。<br>
	 * </p>
	 */
	@Test
	public void testPolNoInputCheck05() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0001;

		/* 入力値の設定 */
		String polNo = "test";
		String claimNo = "test";

		/* テスト対象メソッドの呼び出し */
		String actual = PNC.polNoInputCheck(polNo, claimNo);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * polNoNotInputCheck()メソッドテスト01
	 * <p>
	 * 正常系<br>
	 * 検証条件：polNoが空文字、claimNoが空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。証券番号または事故受け付け番号を入力してください。<br>
	 * </p>
	 */
	@Test
	public void testPolNoNotInputCheck01() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0018;

		/* 入力値の設定 */
		String polNo = "";
		String claimNo = "";

		/* テスト対象メソッドの呼び出し */
		String actual = PNC.polNoNotInputCheck(polNo, claimNo);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * polNoNotInputCheck()メソッドテスト02
	 * <p>
	 * 正常系<br>
	 * 検証条件：polNoが空文字、claimNoがnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。証券番号または事故受け付け番号を入力してください。<br>
	 * </p>
	 */
	@Test
	public void testPolNoNotInputCheck02() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0018;

		/* 入力値の設定 */
		String polNo = "";
		String claimNo = null;

		/* テスト対象メソッドの呼び出し */
		String actual = PNC.polNoNotInputCheck(polNo, claimNo);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * polNoNotInputCheck()メソッドテスト03
	 * <p>
	 * 正常系<br>
	 * 検証条件：polNoが空文字、claimNoが空文字でなくnullでもない場合<br>
	 * 想定結果：nullが返却される。<br>
	 * </p>
	 */
	@Test
	public void testPolNoNotInputCheck03() {

		/* 期待値の定義 */
		String expected = null;

		/* 入力値の設定 */
		String polNo = "";
		String claimNo = "test";

		/* テスト対象メソッドの呼び出し */
		String actual = PNC.polNoNotInputCheck(polNo, claimNo);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * polNoNotInputCheck()メソッドテスト04
	 * <p>
	 * 正常系<br>
	 * 検証条件：polNoがnull、claimNoが空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。証券番号または事故受け付け番号を入力してください。<br>
	 * </p>
	 */
	@Test
	public void testPolNoNotInputCheck04() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0018;

		/* 入力値の設定 */
		String polNo = null;
		String claimNo = "";

		/* テスト対象メソッドの呼び出し */
		String actual = PNC.polNoNotInputCheck(polNo, claimNo);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * polNoNotInputCheck()メソッドテスト05
	 * <p>
	 * 正常系<br>
	 * 検証条件：polNoがnull、claimNoがnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。証券番号または事故受け付け番号を入力してください。<br>
	 * </p>
	 */
	@Test
	public void testPolNoNotInputCheck05() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0018;

		/* 入力値の設定 */
		String polNo = null;
		String claimNo = null;

		/* テスト対象メソッドの呼び出し */
		String actual = PNC.polNoNotInputCheck(polNo, claimNo);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * polNoNotInputCheck()メソッドテスト06
	 * <p>
	 * 正常系<br>
	 * 検証条件：polNoがnull、claimNoが空文字でなくnullでもない場合<br>
	 * 想定結果：null値が返却される。<br>
	 * </p>
	 */
	@Test
	public void testPolNoNotInputCheck06() {

		/* 期待値の定義 */
		String expected = null;

		/* 入力値の設定 */
		String polNo = null;
		String claimNo = "test";

		/* テスト対象メソッドの呼び出し */
		String actual = PNC.polNoNotInputCheck(polNo, claimNo);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * polNoNotInputCheck()メソッドテスト07
	 * <p>
	 * 正常系<br>
	 * 検証条件：polNoとclaimNoの両方がが空文字でなくnullでもない場合<br>
	 * 想定結果：null値が返却される。<br>
	 * </p>
	 */
	@Test
	public void testPolNoNotInputCheck07() {

		/* 期待値の定義 */
		String expected = null;

		/* 入力値の設定 */
		String polNo = "test";
		String claimNo = "test";

		/* テスト対象メソッドの呼び出し */
		String actual = PNC.polNoNotInputCheck(polNo, claimNo);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * polNoExistenceCheck()メソッドテスト01
	 * <p>
	 * 正常系<br>
	 * 検証条件：polNoがnull、claimNoがnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。証券番号または事故受け付け番号を入力してください。<br>
	 * </p>
	 */
	@Test
	public void testPolNoExistenceCheck01() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0006;

		/* 入力値の設定 */
		CI.setPolNo("");

		/* テスト対象メソッドの呼び出し */
		String actual = PNC.polNoExistenceCheck(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * polNoExistenceCheck()メソッドテスト02
	 * <p>
	 * 正常系<br>
	 * 検証条件：polNoがnull、claimNoがnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。証券番号または事故受け付け番号を入力してください。<br>
	 * </p>
	 */
	@Test
	public void testPolNoExistenceCheck02() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0006;

		/* 入力値の設定 */
		CI.setPolNo(null);

		/* テスト対象メソッドの呼び出し */
		String actual = PNC.polNoExistenceCheck(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * polNoExistenceCheck()メソッドテスト03
	 * <p>
	 * 正常系<br>
	 * 検証条件：polNoがnull、claimNoがnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。証券番号または事故受け付け番号を入力してください。<br>
	 * </p>
	 */
	@Test
	public void testPolNoExistenceCheck03() {

		/* 期待値の定義 */
		String expected = null;

		/* 入力値の設定 */
		CI.setPolNo("test");

		/* テスト対象メソッドの呼び出し */
		String actual = PNC.polNoExistenceCheck(CI);

		/* 検証 */
		assertEquals(expected, actual);

	}
}
