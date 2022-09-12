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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import TS_Net.model.constant.SystemConst;
import TS_Net.model.data.Compensation;

/**
 * 予約テーブルDAOクラス。（スタブ）
 * <p>
 * 予約テーブルに対するSQL操作を行う。
 * </p>
 * @author K.Ogawa/SYS 2019/07/03
 */
public class CompensationDao {

	/**
	 * DB接続メソッド。
	 * <p>
	 * メンバ変数のコネクションオブジェクトを用いて、DBと接続する。
	 * </p>
	 * @throws SQLException SQL実行例外
	 * @throws ClassNotFoundException クラスロード例外
	 */
	/** データベースの接続 */
	private Connection con;

	public void connect() throws SQLException, ClassNotFoundException {

		//DriveManagerクラスのgetConnectionメソッドを用いて、DBに接続する。
		Class.forName(SystemConst.JDBC_DRIVER_NAME);
		con = DriverManager.getConnection(SystemConst.JDBC_URL, SystemConst.USER, SystemConst.PASSWORD);
	}

	/**
	 * DB切断メソッド。
	 * <p>
	 * メンバ変数のコネクションオブジェクトを用いて、DB接続を切断する。
	 * </p>
	 * @throws SQLException SQL実行例外
	 */
	public void close() throws SQLException {
		//DB切断
		con.close();
	}

	/**
	 * 登録メソッド。
	 * <p>
	 * 引数で渡された予約情報を、予約テーブルへINSERTする。
	 * </p>
	 * @param entity 予約対象オブジェクト
	 * @throws SQLException SQL実行例外
	 */
//	public void registCompensation(Compensation conpensation) throws SQLException {
//
//		String sql = "INSERT INTO cover_tbl(cover_id, insatsu_renban, premium_amount, premium_installment, maker, car_name, license_no, vehicle_price, vehicle_rates, bodily_rates, property_damage_rates, accident_rates, license_color, age_limit)"
//				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//		PreparedStatement stmt = null;
//		try {
//			stmt=con.prepareStatement(sql);
//			stmt.setString(1, contractInfo.getInsatsuRenban());
//			stmt.setString(2, contractInfo.getPolNo());
//			stmt.setString(3, contractInfo.getStatusFlg());
//			stmt.setString(4, contractInfo.getCancelFlg());
//			stmt.setString(5, contractInfo.getInceptionDate());
//			stmt.setString(6, contractInfo.getInceptionTime());
//			stmt.setString(7, contractInfo.getConclusionDate());
//			stmt.setString(8, contractInfo.getConclusionTime());
//			stmt.setString(9, contractInfo.getPaymentMethod());
//			stmt.setInt(10, contractInfo.getInstallment());
//			stmt.setString(11, contractInfo.getInsuredKbn());
//			stmt.setString(12, contractInfo.getNameKana1());
//			stmt.setString(13, contractInfo.getNamekana2());
//			stmt.setString(14, contractInfo.getNameKanji1());
//
//
//			stmt.executeUpdate();
//		}finally {
//
//			if(stmt != null) {
//				stmt.close();
//			}
//		}
//
//	}


	/**
	 * 全件取得メソッド。
	 * <p>
	 * 予約テーブルから、すべての予約情報を取得する。
	 * </p>
	 * @return
	 * @return entityList 予約情報リスト
	 * @throws SQLException SQL実行例外
	 */
	public Compensation getCompensation(String insatsuRenban) throws SQLException {

		/* 以下はスタブ用変数のため必ず除去すること */
		/* 返却用スタブデータの生成 */

		String sql = "SELECT * FROM cover_tbl WHERE insatsu_renban = ?";
		PreparedStatement stmt = null;
		ResultSet res =  null;
		Compensation compensation = new Compensation();
//		insatsuRenban = "A0000001";

		try {	stmt=con.prepareStatement(sql);
				stmt.setString(1, insatsuRenban);
				res=stmt.executeQuery();



		if (res.next()) {
			compensation.setCoverId(res.getInt("cover_id"));
			compensation.setInsatsuRenban(res.getString("insatsu_renban"));
			compensation.setPremiumAmount(res.getInt("premium_amount"));
			compensation.setPremiumInstallment(res.getInt("premium_installment"));
			compensation.setMaker(res.getString("maker"));
			compensation.setCarName(res.getString("car_name"));
			compensation.setLicenseNo(res.getString("license_no"));
			compensation.setVehiclePrice(res.getInt("vehicle_price"));
			compensation.setVehicleRates(res.getString("vehicle_rates"));
			compensation.setBodilyRates(res.getString("bodily_rates"));
			compensation.setPropertyDamageRates(res.getString("property_damage_rates"));
			compensation.setAccidentRates(res.getString("accident_rates"));
			compensation.setLicenseColor(res.getString("license_color"));
			compensation.setAgeLimit(res.getString("age_limit"));
		}

		}finally {
			if(res != null) {
				res.close();
			}
			if(stmt != null) {
				stmt.close();
			}
		}

//		Compensation compensation = new Compensation();
//		compensation.setCoverId(00000001);
//		compensation.setInsatsuRenban("A0000001");
//		compensation.setMaker("TOYOTA");
//		compensation.setCarName("レクサス");
//		compensation.setLicenseNo("多摩500さ4649");
//		compensation.setVehiclePrice(1000000);
//		compensation.setVehicleRates("3");
//		compensation.setBodilyRates("3");
//		compensation.setPropertyDamageRates("3");
//		compensation.setAccidentRates("3");
//		compensation.setLicenseColor("2");
//		compensation.setAgeLimit("3");
//		compensation.setPremiumAmount(1000000);
//		compensation.setPremiumInstallment(1000000);


		return compensation;

	}










}
