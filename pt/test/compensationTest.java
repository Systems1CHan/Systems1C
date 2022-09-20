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


import TS_Net.model.data.Compensation;



public class compensationTest {
	/** テスト対象のオブジェクト */
	private Compensation comp;

	@Before
	public void setUp() {
		comp = new Compensation();
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
		String expected = "0.0倍";

		/* 入力値の設定 */
		comp.setVehicleRates("0");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getVehicleRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck02() {

		/* 期待値の定義 */
		String expected = "1.0倍";

		/* 入力値の設定 */
		comp.setVehicleRates("1");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getVehicleRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck03() {

		/* 期待値の定義 */
		String expected = "1.2倍";

		/* 入力値の設定 */
		comp.setVehicleRates("2");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getVehicleRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck04() {

		/* 期待値の定義 */
		String expected = "1.4倍";
		/* 入力値の設定 */
		comp.setVehicleRates("3");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getVehicleRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck05() {

		/* 期待値の定義 */
		String expected = "1.6倍";

		/* 入力値の設定 */
		comp.setVehicleRates("4");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getVehicleRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck06() {

		/* 期待値の定義 */
		String expected = "1.9倍";

		/* 入力値の設定 */
		comp.setVehicleRates("5");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getVehicleRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck07() {

		/* 期待値の定義 */
		String expected = "0.0倍";

		/* 入力値の設定 */
		comp.setBodilyRates("0");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getBodilyRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck08() {

		/* 期待値の定義 */
		String expected = "1.0倍";

		/* 入力値の設定 */
		comp.setBodilyRates("1");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getBodilyRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck09() {

		/* 期待値の定義 */
		String expected = "1.2倍";

		/* 入力値の設定 */
		comp.setBodilyRates("2");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getBodilyRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck10() {

		/* 期待値の定義 */
		String expected = "1.4倍";

		/* 入力値の設定 */
		comp.setBodilyRates("3");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getBodilyRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck11() {

		/* 期待値の定義 */
		String expected = "1.6倍";

		/* 入力値の設定 */
		comp.setBodilyRates("4");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getBodilyRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck12() {

		/* 期待値の定義 */
		String expected = "1.9倍";

		/* 入力値の設定 */
		comp.setBodilyRates("5");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getBodilyRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}

	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck13() {

		/* 期待値の定義 */
		String expected = "1.0倍";

		/* 入力値の設定 */
		comp.setPropertyDamageRates("1");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getPropertyDamageRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck14() {

		/* 期待値の定義 */
		String expected = "1.2倍";

		/* 入力値の設定 */
		comp.setPropertyDamageRates("2");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getPropertyDamageRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck15() {

		/* 期待値の定義 */
		String expected = "1.4倍";

		/* 入力値の設定 */
		comp.setPropertyDamageRates("3");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getPropertyDamageRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck16() {

		/* 期待値の定義 */
		String expected = "1.6倍";

		/* 入力値の設定 */
		comp.setPropertyDamageRates("4");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getPropertyDamageRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck17() {

		/* 期待値の定義 */
		String expected = "1.9倍";

		/* 入力値の設定 */
		comp.setPropertyDamageRates("5");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getPropertyDamageRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck18() {

		/* 期待値の定義 */
		String expected = "0.0倍";

		/* 入力値の設定 */
		comp.setPropertyDamageRates("0");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getPropertyDamageRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck19() {

		/* 期待値の定義 */
		String expected = "0.0倍";

		/* 入力値の設定 */
		comp.setAccidentRates("0");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getAccidentRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck20() {

		/* 期待値の定義 */
		String expected = "1.0倍";

		/* 入力値の設定 */
		comp.setAccidentRates("1");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getAccidentRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck21() {

		/* 期待値の定義 */
		String expected = "1.2倍";

		/* 入力値の設定 */
		comp.setAccidentRates("2");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getAccidentRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck22() {

		/* 期待値の定義 */
		String expected = "1.4倍";

		/* 入力値の設定 */
		comp.setAccidentRates("3");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getAccidentRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck23() {

		/* 期待値の定義 */
		String expected = "1.6倍";

		/* 入力値の設定 */
		comp.setAccidentRates("4");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getAccidentRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck24() {

		/* 期待値の定義 */
		String expected = "1.9倍";

		/* 入力値の設定 */
		comp.setAccidentRates("5");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getAccidentRatesForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck25() {

		/* 期待値の定義 */
		String expected = "ブルー";

		/* 入力値の設定 */
		comp.setLicenseColor("1");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getLicenseColorForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck26() {

		/* 期待値の定義 */
		String expected = "グリーン";

		/* 入力値の設定 */
		comp.setLicenseColor("2");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getLicenseColorForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck27() {

		/* 期待値の定義 */
		String expected = "ゴールド";

		/* 入力値の設定 */
		comp.setLicenseColor("3");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getLicenseColorForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck28() {

		/* 期待値の定義 */
		String expected = "無制限";

		/* 入力値の設定 */
		comp.setAgeLimit("1");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getAgeLimitForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck29() {

		/* 期待値の定義 */
		String expected = "21歳以上";

		/* 入力値の設定 */
		comp.setAgeLimit("2");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getAgeLimitForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck30() {

		/* 期待値の定義 */
		String expected = "26歳以上";

		/* 入力値の設定 */
		comp.setAgeLimit("3");

		/* テスト対象メソッドの呼び出し */
		String actual = comp.getAgeLimitForLabel();

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck31() {

		/* 期待値の定義 */
		Double expected = 0.0;

		/* 入力値の設定 */
		Double actual = comp.rate("0");

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck32() {

		/* 期待値の定義 */
		Double expected = 1.0;

		/* 入力値の設定 */
		Double actual = comp.rate("1");

		/* 検証 */
		assertEquals(expected, actual);

	}	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck33() {

		/* 期待値の定義 */
		Double expected = 1.2;

		/* 入力値の設定 */
		Double actual = comp.rate("2");

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck34() {

		/* 期待値の定義 */
		Double expected = 1.4;

		/* 入力値の設定 */
		Double actual = comp.rate("3");

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck35() {

		/* 期待値の定義 */
		Double expected = 1.6;

		/* 入力値の設定 */
		Double actual = comp.rate("4");

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck36() {

		/* 期待値の定義 */
		Double expected = 1.9;

		/* 入力値の設定 */
		Double actual = comp.rate("5");

		/* 検証 */
		assertEquals(expected, actual);

	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck37() {

		/* 期待値の定義 */
		Double expected = 1.0;

		/* 入力値の設定 */
		Double actual = comp.licenserate("1");

		/* 検証 */
		assertEquals(expected, actual);
	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck38() {

		/* 期待値の定義 */
		Double expected = 1.5;

		/* 入力値の設定 */
		Double actual = comp.licenserate("2");

		/* 検証 */
		assertEquals(expected, actual);
	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck39() {

		/* 期待値の定義 */
		Double expected = 0.7;

		/* 入力値の設定 */
		Double actual = comp.licenserate("3");

		/* 検証 */
		assertEquals(expected, actual);
	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck40() {

		/* 期待値の定義 */
		Double expected = 1.5;

		/* 入力値の設定 */
		Double actual = comp.olderRate("1");

		/* 検証 */
		assertEquals(expected, actual);
	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck41() {

		/* 期待値の定義 */
		Double expected = 1.2;

		/* 入力値の設定 */
		Double actual = comp.olderRate("2");

		/* 検証 */
		assertEquals(expected, actual);
	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck42() {

		/* 期待値の定義 */
		Double expected = 1.0;

		/* 入力値の設定 */
		Double actual = comp.olderRate("3");

		/* 検証 */
		assertEquals(expected, actual);
	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck43() {

		/* 期待値の定義 */
		Integer expected =109;
		comp.setVehiclePrice(1);
		comp.setVehicleRates("2");
        comp.setBodilyRates("3");
		comp.setPropertyDamageRates("4");
		comp.setAccidentRates("5");
		comp.setLicenseColor("1");
		comp.setAgeLimit("1");
		/* 入力値の設定 */
		Integer actual = comp.getPremiumAmountForLabel();

		/* 検証 */
		assertEquals(expected, actual);
	}
	/**
	 * テストメソッド
	 */
	@Test
	public void testCheck44() {

		/* 期待値の定義 */
		comp.setLicenseNo("東京111あ3030");
         String  expected = "東京 111 あ 30-30";
		/* 入力値の設定 */
         String actual = comp.getCarNameForLabel();

		/* 検証 */
		assertEquals(expected, actual);
	}
}