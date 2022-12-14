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
	 * 引数で渡された補償情報を、補償テーブルへINSERTする。
	 * </p>
	 * @param compensation 予約対象オブジェクトCOVER_TBL
	 * @throws SQLException SQL実行例外
	 */
	public void registCompensation(Compensation compensation) throws SQLException {

		String sql = "INSERT INTO COVER_TBL(cover_id, insatsu_renban, premium_amount, premium_installment, maker, car_name, license_no, vehicle_price, vehicle_rates, bodily_rates, property_damage_rates, accident_rates, license_color, age_limit)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = null;

		try {

			stmt=con.prepareStatement(sql);
			stmt.setInt(1, compensation.getCoverId());
			stmt.setString(2, compensation.getInsatsuRenban());
			stmt.setInt(3, compensation.getPremiumAmount());
			stmt.setInt(4, compensation.getPremiumInstallment());
			stmt.setString(5, compensation.getMaker());
			stmt.setString(6, compensation.getCarName());
			stmt.setString(7, compensation.getLicenseNo());
			stmt.setInt(8, compensation.getVehiclePrice());
			stmt.setString(9, compensation.getVehicleRates());
			stmt.setString(10, compensation.getBodilyRates());
			stmt.setString(11, compensation.getPropertyDamageRates());
			stmt.setString(12, compensation.getAccidentRates());
			stmt.setString(13, compensation.getLicenseColor());
			stmt.setString(14, compensation.getAgeLimit());

			stmt.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) {
				try {
					stmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}


	/**
	 * 印刷連番で補償情報取得メソッド。
	 * <p>
	 * 補償情報テーブルから、印刷連番が一致する補償情報を取得する。
	 * </p>
	 * @return
	 * @return compensation 予約情報リスト
	 * @throws SQLException SQL実行例外
	 */
	public Compensation getCompensationByIR(String insatsuRenban) throws SQLException {

		/* 以下はスタブ用変数のため必ず除去すること */
		/* 返却用スタブデータの生成 */

		String sql = "SELECT * FROM COVER_TBL WHERE insatsu_renban = ?";
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

	/**
	 *補償IDで補償情報取得メソッド。
	 * <p>
	 * 補償テーブルから、補償IDが一致する補償情報を取得する。
	 *
	 * </p>
	 * @return
	 * @return compensation 予約情報リスト
	 * @throws SQLException SQL実行例外
	 */
	public Compensation getCompensationByCI(Integer coverId) throws SQLException {

		/* 以下はスタブ用変数のため必ず除去すること */
		/* 返却用スタブデータの生成 */

		String sql = "SELECT * FROM COVER_TBL WHERE cover_id = ?";
		PreparedStatement stmt = null;
		ResultSet res =  null;
		Compensation compensation = new Compensation();
//		insatsuRenban = "A0000001";

		try {	stmt=con.prepareStatement(sql);
				stmt.setInt(1, coverId);
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
