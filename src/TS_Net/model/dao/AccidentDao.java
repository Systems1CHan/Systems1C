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
import TS_Net.model.data.AccidentReception;

/**
 * 予約テーブルDAOクラス。（スタブ）
 * <p>
 * 予約テーブルに対するSQL操作を行う。
 * </p>
 * @author K.Ogawa/SYS 2019/07/03
 */
public class AccidentDao {

	/** データベースの接続 */
	private Connection con;
	/**
	 * 予約テーブルDAOクラス。（スタブ）
	 * <p>
	 * 予約テーブルに対するSQL操作を行う。
	 * </p>
	 * @author K.Ogawa/SYS 2019/07/03
	 */


	/**
	 * DB接続メソッド。
	 * <p>
	 * メンバ変数のコネクションオブジェクトを用いて、DBと接続する。
	 * </p>
	 * @throws SQLException SQL実行例外
	 * @throws ClassNotFoundException クラスロード例外
	 */
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
	 * 事故受付取得メソッド。
	 * <p>
	 * 予約テーブルから、すべての予約情報を取得する。
	 * </p>
	 * @return entityList 予約情報リスト
	 * @throws SQLException SQL実行例外
	 */
	public AccidentReception getAccidentReceptionByCN(String claimNo) throws SQLException {

		String sql = "SELECT * FROM claim_tbl WHERE claim_no = ?";
		PreparedStatement stmt = null;
		ResultSet res =  null;
		AccidentReception accidentReception = new AccidentReception();

		try {	stmt=con.prepareStatement(sql);
				stmt.setString(1, claimNo);
				res=stmt.executeQuery();

		if (res.next()) {
			accidentReception.setClaimNo(res.getString("claim_no"));
			accidentReception.setCoverId(res.getInt("cover_id"));
			accidentReception.setClaimStatus(res.getString("claim_status"));
			accidentReception.setPaymentPrice(res.getInt("payment_price"));
			accidentReception.setAccidentLocationKana1(res.getString("accident_location_kana1"));
			accidentReception.setAccidentLocationKana2(res.getString("accident_location_kana2"));
			accidentReception.setAccidentLocationKanji1(res.getString("accident_location_kanji1"));
			accidentReception.setAccidentLocationKanji2(res.getString("accident_location_kanji2"));
			accidentReception.setAccidentDate(res.getString("accident_date"));
			accidentReception.setAccidentSituation(res.getString("accident_situation"));
			accidentReception.setRatingBlameMyself(res.getInt("rating_blame_myself"));
			accidentReception.setRatingBlameYourself(res.getInt("rating_blame_yourself"));
			accidentReception.setDamageCarPrice(res.getInt("damage_car_price"));
			accidentReception.setDamageBodilyPrice(res.getInt("damage_bodily_price"));
			accidentReception.setDamagePropertyPrice(res.getInt("damage_property_price"));
			accidentReception.setDamageAccidentPrice(res.getInt("damage_accident_price"));
			accidentReception.setDamageCarState(res.getString("damage_car_state"));
			accidentReception.setDamageBodilyState(res.getString("damage_bodily_state"));
			accidentReception.setDamagePropertyState(res.getString("damage_property_state"));
			accidentReception.setDamageAccidentState(res.getString("damage_accident_state"));
			accidentReception.setPaymentPrice(res.getInt("payment_price"));
		}

		}finally {
			if(res != null) {
				res.close();
			}
			if(stmt != null) {
				stmt.close();
			}
		}


//		AccidentReception accidentReception = new AccidentReception();
//		accidentReception.setClaimNo("C0000001");
//		accidentReception.setCoverId(00000001);
//		accidentReception.setClaimStatus("1");
//		accidentReception.setPaymentPrice(10000);
//		accidentReception.setAccidentLocationKana1("トウキョウトタマシ");
//		accidentReception.setAccidentLocationKana2("オチアイ");
//		accidentReception.setAccidentLocationKanji1("東京都多摩市");
//		accidentReception.setAccidentLocationKanji2("落合");
//		accidentReception.setAccidentDate("20220909");
//		accidentReception.setRatingBlameMyself(20);
//		accidentReception.setRatingBlameYourself(80);
//		accidentReception.setDamageCarPrice(100000);
//		accidentReception.setDamageBodilyPrice(100000);
//		accidentReception.setDamagePropertyPrice(100000);
//		accidentReception.setDamageAccidentPrice(100000);
//		accidentReception.setDamageCarState("全損");
//		accidentReception.setDamageBodilyState("２週間入院");
//		accidentReception.setDamagePropertyState("建物損壊");
//		accidentReception.setDamageAccidentState("骨折");


		return accidentReception;

	}

	public AccidentReception getAccidentReceptionByCI(Integer coverId) throws SQLException {

//		/* 以下はスタブ用変数のため必ず除去すること */
//		/* 返却用スタブデータの生成 */
//
//		AccidentReception accidentReception = new AccidentReception();
//		accidentReception.setClaimNo("C0000001");
//		accidentReception.setCoverId(00000001);
//		accidentReception.setClaimStatus("1");
//		accidentReception.setPaymentPrice(10000);
//		accidentReception.setAccidentLocationKana1("トウキョウトタマシ");
//		accidentReception.setAccidentLocationKana2("オチアイ");
//		accidentReception.setAccidentLocationKanji1("東京都多摩市");
//		accidentReception.setAccidentLocationKanji2("落合");
//		accidentReception.setAccidentDate("20220909");
//		accidentReception.setRatingBlameMyself(20);
//		accidentReception.setRatingBlameYourself(80);
//		accidentReception.setDamageCarPrice(100000);
//		accidentReception.setDamageBodilyPrice(100000);
//		accidentReception.setDamagePropertyPrice(100000);
//		accidentReception.setDamageAccidentPrice(100000);
//		accidentReception.setDamageCarState("全損");
//		accidentReception.setDamageBodilyState("２週間入院");
//		accidentReception.setDamagePropertyState("建物損壊");
//		accidentReception.setDamageAccidentState("骨折");



		String sql = "SELECT * FROM claim_tbl WHERE cover_id = ?";
		PreparedStatement stmt = null;
		ResultSet res =  null;
		AccidentReception accidentReception = new AccidentReception();

		try {	stmt=con.prepareStatement(sql);
				stmt.setInt(1, coverId);
				res=stmt.executeQuery();

		if (res.next()) {
			accidentReception.setClaimNo(res.getString("claim_no"));
			accidentReception.setCoverId(res.getInt("cover_id"));
			accidentReception.setClaimStatus(res.getString("claim_status"));
			accidentReception.setPaymentPrice(res.getInt("payment_price"));
			accidentReception.setAccidentLocationKana1(res.getString("accident_location_kana1"));
			accidentReception.setAccidentLocationKana2(res.getString("accident_location_kana2"));
			accidentReception.setAccidentLocationKanji1(res.getString("accident_location_kanji1"));
			accidentReception.setAccidentLocationKanji2(res.getString("accident_location_kanji2"));
			accidentReception.setAccidentDate(res.getString("accident_date"));
			accidentReception.setRatingBlameMyself(res.getInt("accident_situation"));
			accidentReception.setRatingBlameYourself(res.getInt("rating_blame_myself"));
			accidentReception.setDamageCarPrice(res.getInt("rating_blame_yourself"));
			accidentReception.setDamageBodilyPrice(res.getInt("damage_car_price"));
			accidentReception.setDamagePropertyPrice(res.getInt("damage_bodily_price"));
			accidentReception.setDamageAccidentPrice(res.getInt("damage_property_price"));
			accidentReception.setDamageCarState(res.getString("damage_accident_price"));
			accidentReception.setDamageBodilyState(res.getString("damage_car_state"));
			accidentReception.setDamagePropertyState(res.getString("damage_bodily_state"));
			accidentReception.setDamageAccidentState(res.getString("damage_property_state"));
			accidentReception.setPaymentPrice(res.getInt("damage_accident_state"));
		}





		}finally {
			if(res != null) {
				res.close();
			}
			if(stmt != null) {
				stmt.close();
			}
		}
		return accidentReception;

	}



	/**
	 * 登録メソッド。
	 * <p>
	 * 引数で渡された予約情報を、予約テーブルへINSERTする。
	 * </p>
	 * @param contractInfo 契約情報オブジェクト
	 * @throws SQLException SQL実行例外
	 */
	public void registAccidentReception(AccidentReception accidentReception) throws SQLException {


		String sql = "INSERT INTO claim_tbl(   claim_no  , cover_id  , claim_status  , payment_price  , accident_location_kana1  , accident_location_kana2  , accident_location_kanji1  , accident_location_kanji2    , accident_situation  , rating_blame_myself  , rating_blame_yourself  , damage_car_price  , damage_bodily_price  , damage_property_price  , damage_accident_price  , damage_car_state  , damage_bodily_state  , damage_property_state  , damage_accident_state, accident_date)"
				+ " VALUES (?, ?,  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = null;


		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "C0000005");
			stmt.setInt(2, accidentReception.getCoverId());
			stmt.setString(3, "1");
			stmt.setInt(4, 0);
			stmt.setString(5, "" );
			stmt.setString(6, "" );
			stmt.setString(7, "" );
			stmt.setString(8, "" );
			stmt.setString(9, "" );
			stmt.setInt(10, 0);
			stmt.setInt(11, 0);
			stmt.setInt(12, 0);
			stmt.setInt(13, 0);
			stmt.setInt(14, 0);
			stmt.setInt(15, 0);
			stmt.setString(16, "" );
			stmt.setString(17, "" );
			stmt.setString(18, "" );
			stmt.setString(19, "" );
			stmt.setString(20, "" );

			//SQL文を実行する。
			stmt.executeUpdate();

		} finally {
			//接続を閉じる。
			if (stmt != null) {
				stmt.close();
			}
		}




	}



	/**
	 *状態フラグ(計上)変更メソッド。
	 * <p>
	 * 契約情報テーブル内の状態フラグを計上済みに変更。
	 * </p>
	 * @return
	 * @return polNo 証券番号
	 * @throws SQLException SQL実行例外
	 */
	public void updateAccidentReception(AccidentReception accidentReception) throws SQLException {

		String sql = "UPDATE claim_tbl SET damage_accident_state =?, damage_property_state=?, damage_bodily_state=?, damage_car_state=?, damage_accident_price=?, damage_property_price=?, damage_bodily_price=?, damage_car_price=?, rating_blame_yourself=?, rating_blame_myself=?, accident_situation=?, accident_location_kanji2=?, accident_location_kanji1=?, accident_location_kana2=?, accident_location_kana1=?, payment_price=?, claim_status=?  WHERE claim_no = ?";



		PreparedStatement stmt = null;
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, accidentReception.getDamageAccidentState());
			stmt.setString(2, accidentReception.getDamagePropertyState());
			stmt.setString(3, accidentReception.getDamageBodilyState());
			stmt.setString(4, accidentReception.getDamageCarState());
			stmt.setInt(5, accidentReception.getDamageAccidentPrice());
			stmt.setInt(6, accidentReception.getDamagePropertyPrice() );
			stmt.setInt(7, accidentReception.getDamageBodilyPrice());
			stmt.setInt(8, accidentReception.getDamageCarPrice() );
			stmt.setInt(9, accidentReception.getRatingBlameYourself());
			stmt.setInt(10, accidentReception.getRatingBlameMyself());
			stmt.setString(11, accidentReception.getAccidentSituation());
			stmt.setString(12, accidentReception.getAccidentLocationKanji2());
			stmt.setString(13, accidentReception.getAccidentLocationKanji2());
			stmt.setString(14, accidentReception.getAccidentLocationKanji2());
			stmt.setString(15, accidentReception.getAccidentLocationKanji2());
			stmt.setInt(16, accidentReception.getPaymentPrice());
			stmt.setString(17, accidentReception.getClaimStatus());
//			stmt.setString(18, accidentReception.getAccidentDate());

			stmt.setString(18, accidentReception.getClaimNo());

			stmt.executeUpdate();



		}finally {

			if(stmt != null) {
				stmt.close();
			}
		}


		}







	/**
	 *最大証券番号取得メソッド。
	 * <p>
	 * 契約情報テーブル内の最大証券番号を取得する。
	 * </p>
	 * @return
	 * @return polNo 証券番号
	 * @throws SQLException SQL実行例外
	 */
	public String getMaxClaimNo() throws SQLException {

		String sql = "SELECT claim_No FROM claim_tbl ORDER BY claim_No DESC LIMIT 1";
		PreparedStatement stmt = null;
		ResultSet res =  null;
		String claimNo = null;

		try {	stmt=con.prepareStatement(sql);
				res=stmt.executeQuery();

			if (res.next()) {
				claimNo = res.getString("claim_No");
			}

			String eigo = claimNo.substring(0,1);
			String suuji = claimNo.substring(1, 8);

			try {
				int incri = Integer.parseInt(suuji);
				int afterIncri = incri + 1;

				int keta = Integer.toString(afterIncri).length();

				claimNo = eigo + claimNo.substring(1, 8-keta) + afterIncri;

			}catch(NumberFormatException e) {
				e.printStackTrace();
			}


		}finally {
			if(res != null) {
				res.close();
			}
			if(stmt != null) {
				stmt.close();
			}
		}
		return claimNo;

	}










//	public void registAccidentInsert(AccidentReception accidentReception) throws SQLException {
//
//		String sql = "INSERT INTO claim_tbl(   claim_no  , cover_id  , claim_status  , payment_price  , accident_location_kana1  , accident_location_kana2  , accident_location_kanji1  , accident_location_kanji2  , accident_date  , accident_situation  , rating_blame_myself  , rating_blame_yourself  , damage_car_price  , damage_bodily_price  , damage_property_price  , damage_accident_price  , damage_car_state  , damage_bodily_state  , damage_property_state  , damage_accident_state)"
//				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//		PreparedStatement stmt = null;
//
////		String changeAccidentDate = accidentReception.getAccidentDate().replace("-", "");
//
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, accidentReception.getClaimNo());
//			stmt.setInt(2, accidentReception.getCoverId());
//			stmt.setString(3, accidentReception.getClaimStatus() );
//			stmt.setInt(4, accidentReception.getPaymentPrice());
//			stmt.setString(5, accidentReception.getAccidentLocationKana1());
//			stmt.setString(6, accidentReception.getAccidentLocationKana2());
//			stmt.setString(7, accidentReception.getAccidentLocationKanji1());
//			stmt.setString(8, accidentReception.getAccidentLocationKanji2());
//			stmt.setString(9, accidentReception.getAccidentDate());
//			stmt.setString(10, accidentReception.getAccidentSituation());
//			stmt.setInt(11, accidentReception.getRatingBlameMyself());
//			stmt.setInt(12, accidentReception.getRatingBlameYourself());
//			stmt.setInt(13, accidentReception.getDamageCarPrice() );
//			stmt.setInt(14, accidentReception.getDamageBodilyPrice());
//			stmt.setInt(15, accidentReception.getDamagePropertyPrice() );
//			stmt.setInt(16, accidentReception.getDamageAccidentPrice());
//			stmt.setString(17, accidentReception.getDamageCarState());
//			stmt.setString(18, accidentReception.getDamageBodilyState());
//			stmt.setString(19, accidentReception.getDamagePropertyState());
//			stmt.setString(20, accidentReception.getDamageAccidentState());
//			//SQL文を実行する。
//			stmt.executeUpdate();
//
//		} finally {
//			//接続を閉じる。
//			if (stmt != null) {
//				stmt.close();
//			}
//		}
//	}





}
































//
//String sql = "INSERT INTO claim_tbl(claim_no, cover_id, claim_status, payment_price, accident_location_kana1, accident_location_kana2, accident_location_kanji1, accident_location_kanji2, accident_date, accident_situation, rating_blame_myself, rating_blame_yourself, damage_car_price, damage_bodily_price, damage_property_price, damage_accident_price, damage_car_state, damage_bodily_state, damage_property_state,damage_accident_state,)	"
//		+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//		String sql = "INSERT INTO final_exercise_db.claim_tbl(   claim_no  , cover_id  , claim_status  , payment_price  , accident_location_kana1  , accident_location_kana2  , accident_location_kanji1  , accident_location_kanji2  , accident_date  , accident_situation  , rating_blame_myself  , rating_blame_yourself  , damage_car_price  , damage_bodily_price  , damage_property_price  , damage_accident_price  , damage_car_state  , damage_bodily_state  , damage_property_state  , damage_accident_state)"
//					+ " VALUES (   'C0000004'  , 00000004  , 1  , 111600  , 'トウキョウトタマシツルマキ'  , '２－１－１タマトウキョウカ イジョウニチドウビル'  , '東京都多摩市鶴牧'  , '２－１－１多摩東京海上日動ビル'  , '20160805'  , '多摩病院に入院。後遺症は無し。'  , 60  , 40  , 45000  , 50000  , 87000  , 4000  , '走行不能'  , '右足首骨折'  , '電信柱全壊'  , '左脚捻挫')";
//
//
//PreparedStatement stmt = null;
//try {
//	stmt=con.prepareStatement(sql);
//	stmt.setString(1, accidentReception.getClaimNo());
//	stmt.setInt(2, accidentReception.getCoverId());
//	stmt.setString(3, accidentReception.getClaimStatus());
//
//	//			stmt.setInt(4, accidentReception.getPaymentPrice());
//	stmt.setInt(4, 1);
//
//	stmt.setString(5, accidentReception.getAccidentLocationKana1());
//	stmt.setString(6, accidentReception.getAccidentLocationKana2());
//	stmt.setString(7, accidentReception.getAccidentLocationKanji1());
//	stmt.setString(8, accidentReception.getAccidentLocationKanji2());
//	stmt.setString(9, accidentReception.getAccidentDate());
//	stmt.setString(10, accidentReception.getAccidentSituation());
////	stmt.setInt(11, accidentReception.getRatingBlameMyself());
//	stmt.setInt(11, 11);
//
//	stmt.setInt(12, 1);
//	stmt.setInt(13, 1);
//	stmt.setInt(14, 1);
//	stmt.setInt(15, 1);
//	stmt.setInt(16, 1);
//
//
//	stmt.setInt(12, accidentReception.getRatingBlameYourself());
//	stmt.setInt(13, accidentReception.getDamageCarPrice());
//	stmt.setInt(14, accidentReception.getDamageBodilyPrice());
//	stmt.setInt(15, accidentReception.getDamagePropertyPrice());
//	stmt.setInt(16, accidentReception.getDamageAccidentPrice());
//	stmt.setString(17, accidentReception.getDamageCarState());
//	stmt.setString(18, accidentReception.getDamageBodilyState());
//	stmt.setString(19, accidentReception.getDamagePropertyState());
//	stmt.setString(20, accidentReception.getDamageAccidentState());
//
//
//	stmt.setString(17, "a");
//	stmt.setString(18, "a");
//	stmt.setString(19, "a");
//	stmt.setString(20, "a");
//
//
//	stmt.executeUpdate();
//}finally {
//
//	if(stmt != null) {
//		stmt.close();
//	}
//}

