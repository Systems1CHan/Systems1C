	/*------------------------------------------------------------------------------
	 * 演習番号：[仕様書演習]
	 * クラス名：[ReservationsDao]
	 * 作成日  ：[2019/07/04]
	 * 作成者  ：[K.Ogawa/SYS]
	 *------------------------------------------------------------------------------
	 * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
	 *------------------------------------------------------------------------------
	 */
package TS_Net.model.dao;

import java.sql.SQLException;

/**
 * 予約テーブルDAOクラス。（スタブ）
 * <p>
 * 予約テーブルに対するSQL操作を行う。
 * </p>
 * @author K.Ogawa/SYS 2019/07/03
 */
public class CompensationDao {

	/* 登録データ : スタブ用変数のため必ず除去すること */
	CompensationInf insertData = new CompensationInf();

	/**
	 * DB接続メソッド。
	 * <p>
	 * メンバ変数のコネクションオブジェクトを用いて、DBと接続する。
	 * </p>
	 * @throws SQLException SQL実行例外
	 * @throws ClassNotFoundException クラスロード例外
	 */
	public void connect() throws SQLException, ClassNotFoundException {

		/* 空実装 */
	}

	/**
	 * DB切断メソッド。
	 * <p>
	 * メンバ変数のコネクションオブジェクトを用いて、DB接続を切断する。
	 * </p>
	 * @throws SQLException SQL実行例外
	 */
	public void close() throws SQLException {

		/* 空実装 */
	}

	/**
	 * 登録メソッド。
	 * <p>
	 * 引数で渡された予約情報を、予約テーブルへINSERTする。
	 * </p>
	 * @param entity 予約対象オブジェクト
	 * @throws SQLException SQL実行例外
	 */
	public void registCompensation(CompensationInf comInf) throws SQLException {

		/* 登録データ : スタブ用変数のため必ず除去すること */
		insertData = comInf;

	}

	/**
	 * 全件取得メソッド。
	 * <p>
	 * 予約テーブルから、すべての予約情報を取得する。
	 * </p>
	 * @return entityList 予約情報リスト
	 * @throws SQLException SQL実行例外
	 */
	public getCompensation(Integer insatsuRenban) throws SQLException {

		/* 以下はスタブ用変数のため必ず除去すること */
		/* 返却用スタブデータの生成 */

		CompensationInf compensationInf = new CompensationInf();
		compensationInf.setComcoverId(00000001);
		compensationInf.setInsatsuRenban(A0000001);
		compensationInf.setMaker("TOYOTA");
		compensationInf.setCarName("レクサス");
		compensationInf.setLicenseNo("多摩500さ4649");
		compensationInf.setVehiclePrice(1000000);
		compensationInf.setVehicleRates(3);
		compensationInf.setBodilyRates(3);
		compensationInf.setPropertyDamageRates(3);
		compensationInf.setAccidentRates(3);
		compensationInf.setLicenseColor(2);
		compensationInf.setAgeLimit(3);
		compensationInf.setPremiumAmount(1000000);
		compensationInf.setPremiumInstallment(1000000);


		contractInfo.setFaxNo("1234567890");

		return contractInfo;

	}










}
