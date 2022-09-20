/*-----------------------------------------------------
	 * 演習番号：総合演習
	 * クラス名:[AccidentReceptionTest]
	 * 作成日：[2022/09/20]
	 * 作成者：[KeinaNoguchi/SYS]
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

import TS_Net.model.data.AccidentReception;
import TS_Net.model.data.ContractInfo;


	public class AccidentReceptionTest {

		/** テスト対象のオブジェクト */
		private AccidentReception AR;

		@Before
		public void setUp() {
			AR = new AccidentReception();
		}

		/**
		 * getAccidentReceptionFlagForLabel()メソッドテスト01
		 * <p>
		 * 正常系<br>
		 * 検証条件：事故受付フラグを取得し、リターンできるかの検証<br>
		 * 想定結果：以下の文字列が返却される。<br>
		 * 事故受付中<br>
		 * </p>
		 */
		@Test
		public void testgetAccidentReceptionFlagForLabel01() {
			/* 期待値の定義 */
			String expected = "事故受付中";

			/* 入力値の設定 */
			AR.setClaimStatus("1");

			/* テスト対象メソッドの呼び出し */
			String actual = AR.getAccidentReceptionFlagForLabel();

			/* 検証 */
			assertEquals(expected, actual);
		}

		/**
		 * getAccidentReceptionFlagForLabel()メソッドテスト02
		 * <p>
		 * 正常系<br>
		 * 検証条件：事故受付フラグを取得し、リターンできるかの検証<br>
		 * 想定結果：以下の文字列が返却される。<br>
		 * 受付完了済み<br>
		 * </p>
		 */
		@Test
		public void testgetAccidentReceptionFlagForLabel02() {
			/* 期待値の定義 */
			String expected = "受付完了済み";

			/* 入力値の設定 */
			AR.setClaimStatus("2");

			/* テスト対象メソッドの呼び出し */
			String actual = AR.getAccidentReceptionFlagForLabel();

			/* 検証 */
			assertEquals(expected, actual);
		}

		/**
		 * getPaymentPriceForlabel()メソッドテスト
		 * <p>
		 * 正常系<br>
		 * 検証条件：支払金額を取得し、リターンできるかの検証<br>
		 * 想定結果：以下の文字列が返却される。<br>
		 * 直接集金<br>
		 * </p>
		 */
		@Test
		public void testgetPaymentPriceForlabel() {
			/* 期待値の定義 */
			String expected ="0円";
		AR.setDamageCarPrice(45000);
			AR.setDamageBodilyPrice(5000);
	       AR.setDamagePropertyPrice(87000);
			AR.setDamageAccidentPrice(4000);
			AR.setRatingBlameMyself(0);
			AR.setPaymentPrice(186000);

			/* 入力値の設定 */
			String actual = AR.getPaymentPriceForlabel();

			/* 検証 */
			assertEquals(expected, actual);
		}

		/**
		 * getDamageCarPriceForLabel()メソッドテスト
		 * <p>
		 * 正常系<br>
		 * 検証条件：損害額・車両を取得し、リターンできるかの検証<br>
		 * 想定結果：以下の文字列が返却される。<br>
		 * 口座振替<br>
		 * </p>
		 */
		@Test
		public void testgetDamageCarPriceForLabel() {
			/* 期待値の定義 */
			String expected = "45000円";

			/* 入力値の設定 */
			AR.setDamageCarPrice(45000);

			/* テスト対象メソッドの呼び出し */
			String actual = AR.getDamageCarPriceForLabel();

			/* 検証 */
			assertEquals(expected, actual);
		}

		/**
		 * getDamageBodilyPriceForLabel()メソッドテスト
		 * <p>
		 * 正常系<br>
		 * 検証条件：損害額・対人を取得し、リターンできるかの検証<br>
		 * 想定結果：以下の文字列が返却される。<br>
		 * クレジットカード<br>
		 * </p>
		 */
		@Test
		public void testgetDamageBodilyPriceForLabel() {
			/* 期待値の定義 */
			String expected = "50000円";

			/* 入力値の設定 */
			AR.setDamageBodilyPrice(50000);

			/* テスト対象メソッドの呼び出し */
			String actual = AR.getDamageBodilyPriceForLabel();

			/* 検証 */
			assertEquals(expected, actual);
		}

		/**
		 * getDamagePropertyPriceForLabel()メソッドテスト
		 * <p>
		 * 正常系<br>
		 * 検証条件：損害額・対物を取得し、リターンできるかの検証<br>
		 * 想定結果：以下の文字列が返却される。<br>
		 * 男<br>
		 * </p>
		 */
		@Test
		public void testgetDamagePropertyPriceForLabel() {
			/* 期待値の定義 */
			String expected = "87000円";

			/* 入力値の設定 */
			AR.setDamagePropertyPrice(87000);

			String actual = AR.getDamagePropertyPriceForLabel();

			/* 検証 */
			assertEquals(expected, actual);
		}

		/**
		 * getDamageAccidentPriceForLabel()メソッドテスト
		 * <p>
		 * 正常系<br>
		 * 検証条件：損害額・傷害を取得し、リターンできるかの検証<br>
		 * 想定結果：以下の文字列が返却される。<br>
		 * 女<br>
		 * </p>
		 */
		@Test
		public void testgetDamageAccidentPriceForLabel() {
			/* 期待値の定義 */
			String expected = "4000円";

			/* 入力値の設定 */
			AR.setDamageAccidentPrice(4000);

			/* テスト対象メソッドの呼び出し */
			String actual = AR.getDamageAccidentPriceForLabel();

			/* 検証 */
			assertEquals(expected, actual);
		}

		/**
		 * getAccidentDateForLabel()メソッドテスト
		 * <p>
		 * 正常系<br>
		 * 検証条件：事故発生日を取得し、リターンできるかの検証<br>
		 * 想定結果：以下の文字列が返却される。<br>
		 * 個人<br>
		 * </p>
		 */
		@Test
		public void testgetAccidentDateForLabel(){
			/* 期待値の定義 */
			AR.setAccidentDate("20221009");
			String expected ="2022年10月09日";

			/* テスト対象メソッドの呼び出し */
			String actual = AR.getAccidentDateForLabel();

			/* 検証 */
			assertEquals(expected, actual);


	}

}
