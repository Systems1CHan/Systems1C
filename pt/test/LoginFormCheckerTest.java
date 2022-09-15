/*------------------------------------------------------------------------------
 /*------------------------------------------------------------------------------
 * 演習番号：[総合演習]
 * クラス名：[LoginFormCheckerTest]
 * 作成日  ：[2022/09/14]
 * 作成者  ：[NarimichiHenmi/SYS]
 *------------------------------------------------------------------------------
 * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
 *------------------------------------------------------------------------------
 */

package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import TS_Net.model.datacheck.LoginFormChecker;



public class LoginFormCheckerTest {

		/** テスト対象のオブジェクト */
		private LoginFormChecker LFC;

		@Before
		public void setUp() {
			LFC = new LoginFormChecker();
		}

		/**
		 * emptyCheck()メソッドテスト01
		 * <p>
		 * 正常系<br>
		 * 検証条件：iDが空文字の場合<br>
		 * 想定結果：以下の文字列が返却される。<br>
		 * IDまたはパスワードが未入力です。<br>
		 * </p>
		 */
		@Test
		public void testEmptyCheck01() {

			/* 期待値の定義 */
			String expected = "IDまたはパスワードが未入力です。";

			/* 入力値の設定 */
			String iD = "";
			String password = "test";

			/* テスト対象メソッドの呼び出し */
			String actual = LFC.emptyCheck(iD, password);

			/* 検証 */
			assertEquals(expected, actual);

		}

		/**
		 * emptyCheck()メソッドテスト02
		 * <p>
		 * 正常系<br>
		 * 検証条件：passwordが空文字の場合<br>
		 * 想定結果：以下の文字列が返却される。<br>
		 * IDまたはパスワードが未入力です。<br>
		 * </p>
		 */
		@Test
		public void testEmptyCheck02() {

			/* 期待値の定義 */
			String expected = "IDまたはパスワードが未入力です。";

			/* 入力値の設定 */
			String iD = "test";
			String password = "";

			/* テスト対象メソッドの呼び出し */
			String actual = LFC.emptyCheck(iD, password);

			/* 検証 */
			assertEquals(expected, actual);

		}

		/**
		 * emptyCheck()メソッドテスト03
		 * <p>
		 * 正常系<br>
		 * 検証条件：iDが空文字の場合<br>
		 * 想定結果：以下の文字列が返却される。<br>
		 * IDまたはパスワードが未入力です。<br>
		 * </p>
		 */
		@Test
		public void testEmptyCheck03() {

			/* 期待値の定義 */
			String expected = "IDまたはパスワードが未入力です。";

			/* 入力値の設定 */
			String iD = null;
			String password = "test";

			/* テスト対象メソッドの呼び出し */
			String actual = LFC.emptyCheck(iD, password);

			/* 検証 */
			assertEquals(expected, actual);

		}

		/**
		 * emptyCheck()メソッドテスト04
		 * <p>
		 * 正常系<br>
		 * 検証条件：iDが空文字の場合<br>
		 * 想定結果：以下の文字列が返却される。<br>
		 * IDまたはパスワードが未入力です。<br>
		 * </p>
		 */
		@Test
		public void testEmptyCheck04() {

			/* 期待値の定義 */
			String expected = "IDまたはパスワードが未入力です。";

			/* 入力値の設定 */
			String iD = "test";
			String password = null;

			/* テスト対象メソッドの呼び出し */
			String actual = LFC.emptyCheck(iD, password);

			/* 検証 */
			assertEquals(expected, actual);

		}

		/**
		 * emptyCheck()メソッドテスト05
		 * <p>
		 * 正常系<br>
		 * 検証条件：iDが空文字の場合<br>
		 * 想定結果：以下の文字列が返却される。<br>
		 * IDまたはパスワードが未入力です。<br>
		 * </p>
		 */
		@Test
		public void testEmptyCheck05() {

			/* 期待値の定義 */
			String expected = null;

			/* 入力値の設定 */
			String iD = "test";
			String password = "test";

			/* テスト対象メソッドの呼び出し */
			String actual = LFC.emptyCheck(iD, password);

			/* 検証 */
			assertEquals(expected, actual);

		}

		/**
		 * accountCheck()メソッドテスト01
		 * <p>
		 * 正常系<br>
		 * 検証条件：loginStateがfalseの場合<br>
		 * 想定結果：以下の文字列が返却される。<br>
		 * IDまたはパスワードが未入力です。<br>
		 * </p>
		 */
		@Test
		public void testAccountCheck01() {

			/* 期待値の定義 */
			String expected = "IDまたはパスワードに誤りがあります。";

			/* 入力値の設定 */

			/* findAccountの結果を受け取るための変数 */
			boolean loginState = false;

			/* テスト対象メソッドの呼び出し */
			String actual = LFC.accountCheck(loginState);

			/* 検証 */
			assertEquals(expected, actual);

		}

		/**
		 * accountCheck()メソッドテスト02
		 * <p>
		 * 正常系<br>
		 * 検証条件：iDが空文字の場合<br>
		 * 想定結果：null値が返却される。<br>
		 * </p>
		 */
		@Test
		public void testAccountCheck02() {

			/* 期待値の定義 */
			String expected = null;

			/* 入力値の設定 */

			/* findAccountの結果を受け取るための変数 */
			boolean loginState = true;

			/* テスト対象メソッドの呼び出し */
			String actual = LFC.accountCheck(loginState);

			/* 検証 */
			assertEquals(expected, actual);

		}
}
