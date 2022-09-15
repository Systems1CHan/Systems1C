/*------------------------------------------------------------------------------
 * 演習番号：[総合演習]
 * クラス名：[LoginProcessServlet]
 * 作成日  ：[2022/09/15]
 * 作成者  ：[NarimichiHenmi/SYS]
 *------------------------------------------------------------------------------
 * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
 * (2022/09/15 ： NarimichiHenmi/SYS ：コメントの追加と変更)
 *------------------------------------------------------------------------------
 */

package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import TS_Net.model.constant.ErrorMsgConst;
import TS_Net.model.datacheck.BlankChecker;

public class BlankCheckerTest {

	/** テスト対象のオブジェクト */
	private BlankChecker BC;

	@Before
	public void setUp() {
		BC = new BlankChecker();
	}

	/**
	 * blankCheck()メソッドテスト01
	 * <p>
	 * 正常系<br>
	 * 検証条件：Stringが空文字の場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testBlankCheck01() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		String String = "";

		/* テスト対象メソッドの呼び出し */
		String actual = BC.blankCheck(String);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * blankCheck()メソッドテスト02
	 * <p>
	 * 正常系<br>
	 * 検証条件：Stringがnullの場合<br>
	 * 想定結果：以下の文字列が返却される。<br>
	 * 未入力の項目があります。入力内容をご確認ください。<br>
	 * </p>
	 */
	@Test
	public void testBlankCheck02() {

		/* 期待値の定義 */
		String expected = ErrorMsgConst.FORM_ERROR0002;

		/* 入力値の設定 */
		String String = null;

		/* テスト対象メソッドの呼び出し */
		String actual = BC.blankCheck(String);

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * blankCheck()メソッドテスト03
	 * <p>
	 * 正常系<br>
	 * 検証条件：Stringが正しく設定されているの場合<br>
	 * 想定結果：null値が返却される。<br>
	 * </p>
	 */
	@Test
	public void testBlankCheck03() {

		/* 期待値の定義 */
		String expected = null;

		/* 入力値の設定 */
		String String = "test";

		/* テスト対象メソッドの呼び出し */
		String actual = BC.blankCheck(String);

		/* 検証 */
		assertEquals(expected, actual);

	}


}
