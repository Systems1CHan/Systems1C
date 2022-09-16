	/*------------------------------------------------------------------------------
	 * 演習番号：[総合演習]
	 * クラス名：[ClaimNoCheckerTest]
	 * 作成日  ：[2022/09/15]
	 * 作成者  ：[KeinaNoguchi/SYS]
	 *------------------------------------------------------------------------------
	 * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
	 * (2022/09/15 ： KeinaNoguchi/SYS ：コメントの追加)
	 *------------------------------------------------------------------------------
	 */
package test;


	import static org.junit.Assert.*;

	import org.junit.Before;
	import org.junit.Test;

	import TS_Net.model.constant.ErrorMsgConst;
	import TS_Net.model.data.AccidentReception;
	import TS_Net.model.datacheck.DateChecker;

	public class DateCheckerTest {


		/** テスト対象のオブジェクト */
		private DateChecker DC;

		@Before
		public void setUp() {
			DC = new DateChecker();
		}

		/**
		 * InceptionDateCheck()メソッドテスト01
		 * <p>
		 * 正常系<br>
		 * 検証条件：処理対象のメンバ変数がnullの場合<br>
		 * 想定結果：以下の文字列が返却される。<br>
		 * 入力された日時は適切ではありません。<br>
		 * </p>
		 */
		@Test
		public void testInceptionDateCheck01() {

			/* 期待値の定義 */
			String expected = ErrorMsgConst.FORM_ERROR0014;

			/* テスト対象メソッドの呼び出し */
			String actual = DC.inceptionDateCheck("20210815");

			/* 検証 */
			assertEquals(expected, actual);

		}

		/**
		 * InceptionDateCheck()メソッドテスト02
		 * <p>
		 * 正常系<br>
		 * 検証条件：処理対象のメンバ変数がnull以外の場合<br>
		 * 想定結果：null値が返却される。<br>
		 *
		 * </p>
		 */
		@Test
		public void testInceptionDateCheck02() {

			/* 期待値の定義 */
			String expected = null;

			/* テスト対象メソッドの呼び出し */
			String actual = DC.inceptionDateCheck("20230505");

			/* 検証 */
			assertEquals(expected, actual);


		}

		/**
		 * ConclusionDateCheck()メソッドテスト01
		 * <p>
		 * 正常系<br>
		 * 検証条件：処理対象のメンバ変数がnullの場合<br>
		 * 想定結果：以下の文字列が返却される。<br>
		 * 入力された日時は適切ではありません。<br>
		 * </p>
		 */
		@Test
		public void testConclusionDateCheck01() {

			/* 期待値の定義 */
			String expected = ErrorMsgConst.FORM_ERROR0014;

			/* テスト対象メソッドの呼び出し */
			String actual = DC.conclusionDateCheck("20210909");

			/* 検証 */
			assertEquals(expected, actual);

		}

		/**
		 * ConclusionDateCheck()メソッドテスト02
		 * <p>
		 * 正常系<br>
		 * 検証条件：処理対象のメンバ変数がnull以外の場合<br>
		 * 想定結果：null値が返却される。<br>
		 *
		 * </p>
		 */
		@Test
		public void testConclusionDateCheck02() {

			/* 期待値の定義 */
			String expected = null;

			/* テスト対象メソッドの呼び出し */
			String actual = DC.conclusionDateCheck("20230606");

			/* 検証 */
			assertEquals(expected, actual);


		}

		/**
		 * BirthdayCheck()メソッドテスト01
		 * <p>
		 * 正常系<br>
		 * 検証条件：処理対象のメンバ変数がnullの場合<br>
		 * 想定結果：以下の文字列が返却される。<br>
		 * 入力された日時は適切ではありません。<br>
		 * </p>
		 */
		@Test
		public void testBirthdayCheck01() {

			/* 期待値の定義 */
			String expected = ErrorMsgConst.FORM_ERROR0014;

			/* テスト対象メソッドの呼び出し */
			String actual = DC.birthdayCheck("20230505");

			/* 検証 */
			assertEquals(expected, actual);
		}

		/**
		 * BirthdayCheck()メソッドテスト02
		 * <p>
		 * 正常系<br>
		 * 検証条件：処理対象のメンバ変数がnull以外の場合<br>
		 * 想定結果：null値が返却される。<br>
		 *
		 * </p>
		 */
		@Test
		public void testBirthdayCheck02() {

			/* 期待値の定義 */
			String expected = null;

			/* テスト対象メソッドの呼び出し */
			String actual = DC.birthdayCheck("19990909");

			/* 検証 */
			assertEquals(expected, actual);


		}


		/**
		 * AccidentDateCheck()メソッドテスト01
		 * <p>
		 * 正常系<br>
		 * 検証条件：処理対象のメンバ変数がnullの場合<br>
		 * 想定結果：null値が返却される。<br>
		 * </p>
		 */
		@Test
		public void testAccidentDateCheck01() {

			/* 期待値の定義 */
			String expected = ErrorMsgConst.FORM_ERROR0014;

			/* テスト対象メソッドの呼び出し */
			String actual = DC.accidentDateCheck("19990808", "20220909", "20230909");

			/* 検証 */
			assertEquals(expected, actual);

		}

			/**
			 * AccidentDateCheck()メソッドテスト02
			 * <p>
			 * 正常系<br>
			 * 検証条件：処理対象のメンバ変数がnull以外の場合<br>
			 * 想定結果：null値が返却される。<br>
			 *
			 * </p>
			 */
		@Test
		public void testAccidentDateCheck02() {

			/* 期待値の定義 */
			String expected = null;

			/* テスト対象メソッドの呼び出し */
			String actual = DC.accidentDateCheck("20220901", "19990606","20230909" );

			/* 検証 */
			assertEquals(expected, actual);


		}

	}
