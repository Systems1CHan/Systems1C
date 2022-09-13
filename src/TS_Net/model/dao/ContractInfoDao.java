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

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import TS_Net.model.constant.SystemConst;
import TS_Net.model.data.ContractInfo;

public class ContractInfoDao {

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
	 * @throws IOException
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
	public void registContractInfo(ContractInfo contractInfo) throws SQLException {

		String sql = "INSERT INTO contractinfo_tbl(insatsu_renban, pol_no, status_flg, cancel_flg, inception_date, inception_time, conclusion_date, conclusion_time, payment_method, installment, insured_kbn, name_kana1, name_kana2, name_kanji1, name_kanji2, postcode, address_kana1, address_kana2, address_kanji1,address_kanji2, birthday, gender, telephone_no, mobilephone_no, fax_no)	"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = null;
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, contractInfo.getInsatsuRenban());
			stmt.setString(2, contractInfo.getPolNo());
			stmt.setString(3, contractInfo.getStatusFlg());
			stmt.setString(4, contractInfo.getCancelFlg());
			stmt.setString(5, contractInfo.getInceptionDate());
			stmt.setString(6, contractInfo.getInceptionTime());
			stmt.setString(7, contractInfo.getConclusionDate());
			stmt.setString(8, contractInfo.getConclusionTime());
			stmt.setString(9, contractInfo.getPaymentMethod());
			stmt.setInt(10, contractInfo.getInstallment());
			stmt.setString(11, contractInfo.getInsuredKbn());
			stmt.setString(12, contractInfo.getNameKana1());
			stmt.setString(13, contractInfo.getNamekana2());
			stmt.setString(14, contractInfo.getNameKanji1());
			stmt.setString(15, contractInfo.getNameKanji2());
			stmt.setString(16, contractInfo.getPostcode());
			stmt.setString(17, contractInfo.getAddressKana1());
			stmt.setString(18, contractInfo.getAddressKana2());
			stmt.setString(19, contractInfo.getAddressKanji1());
			stmt.setString(20, contractInfo.getAddressKanji2());
			stmt.setString(21, contractInfo.getBirthday());
			stmt.setString(22, contractInfo.getGender());
			stmt.setString(23, contractInfo.getTelephoneNo());
			stmt.setString(24, contractInfo.getMobilephoneNo());
			stmt.setString(25, contractInfo.getFaxNo());

			stmt.executeUpdate();
		}finally {

			if(stmt != null) {
				stmt.close();
			}
		}

	}

	/**
	 * 全件取得メソッド。
	 * <p>
	 * 予約テーブルから、すべての予約情報を取得する。
	 * </p>
	 * @return
	 * @return entityList 予約情報リスト
	 * @throws SQLException SQL実行例外
	 */
	public ContractInfo getContractInfoByPN(String polNo) throws SQLException {

		String sql = "SELECT * FROM contractinfo_tbl WHERE pol_no = ?";
		PreparedStatement stmt = null;
		ResultSet res =  null;
		ContractInfo contractInfo = new ContractInfo();

		try {	stmt=con.prepareStatement(sql);
				stmt.setString(1, polNo);
				res=stmt.executeQuery();

//				contractInfo.setInsatsuRenban("A0000001");
//				contractInfo.setPolNo("B000000001");
//				contractInfo.setStatusFlg("1");
//				contractInfo.setCancelFlg("0");
//				contractInfo.setInceptionDate("20220909");
//				contractInfo.setInceptionTime("16");
//				contractInfo.setConclusionDate("20230909");
//				contractInfo.setConclusionTime("16");
//				contractInfo.setPaymentMethod("1");
//				contractInfo.setInstallment(2);
//				contractInfo.setInsuredKbn("1");
//				contractInfo.setNameKana1("ムナカタ");
//				contractInfo.setNamekana2("レン");
//				contractInfo.setNameKanji1("宗形");
//				contractInfo.setNameKanji2("鎌");
//				contractInfo.setPostcode("1234567");
//				contractInfo.setAddressKana1("トウキョウトタマシ");
//				contractInfo.setAddressKana2("オチアイ");
//				contractInfo.setAddressKanji1("東京都多摩市");
//				contractInfo.setAddressKanji2("落合");
//				contractInfo.setBirthday("11111111");
//				contractInfo.setGender("1");
//				contractInfo.setTelephoneNo("1234567890");
//				contractInfo.setMobilephoneNo("12345678901");
//				contractInfo.setFaxNo("1234567890");

		if (res.next()) {
			contractInfo.setInsatsuRenban(res.getString("insatsu_renban"));
			contractInfo.setPolNo(res.getString("pol_no"));
			contractInfo.setStatusFlg(res.getString("status_flg"));
			contractInfo.setCancelFlg(res.getString("cancel_flg"));
			contractInfo.setInceptionDate(res.getString("inception_date"));
			contractInfo.setInceptionTime(res.getString("inception_time"));
			contractInfo.setConclusionDate(res.getString("conclusion_date"));
			contractInfo.setConclusionTime(res.getString("conclusion_time"));
			contractInfo.setPaymentMethod(res.getString("payment_method"));
			contractInfo.setInstallment(res.getInt("installment"));
			contractInfo.setInsuredKbn(res.getString("insured_kbn"));
			contractInfo.setNameKana1(res.getString("name_kana1"));
			contractInfo.setNamekana2(res.getString("name_kana2"));
			contractInfo.setNameKanji1(res.getString("name_kanji1"));
			contractInfo.setNameKanji2(res.getString("name_kanji2"));
			contractInfo.setPostcode(res.getString("postcode"));
			contractInfo.setAddressKana1(res.getString("address_kana1"));
			contractInfo.setAddressKana2(res.getString("address_kana2"));
			contractInfo.setAddressKanji1(res.getString("address_kanji1"));
			contractInfo.setAddressKanji2(res.getString("address_kanji2"));
			contractInfo.setBirthday(res.getString("birthday"));
			contractInfo.setGender(res.getString("gender"));
			contractInfo.setTelephoneNo(res.getString("telephone_no"));
			contractInfo.setMobilephoneNo(res.getString("mobilephone_no"));
			contractInfo.setFaxNo(res.getString("fax_no"));
		}

		}finally {
			if(res != null) {
				res.close();
			}
			if(stmt != null) {
				stmt.close();
			}
		}
		return contractInfo;

	}

	public ContractInfo getContractInfoByIR(String insatsuRenban) throws SQLException {

		String sql = "SELECT * FROM contractinfo_tbl WHERE insatsu_renban = ?";
		PreparedStatement stmt = null;
		ResultSet res =  null;
		ContractInfo contractInfo = new ContractInfo();

		try {	stmt=con.prepareStatement(sql);
				stmt.setString(1, insatsuRenban);
				res=stmt.executeQuery();


		if (res.next()) {
			contractInfo.setInsatsuRenban(res.getString("insatsu_renban"));
			contractInfo.setPolNo(res.getString("pol_no"));
			contractInfo.setStatusFlg(res.getString("status_flg"));
			contractInfo.setCancelFlg(res.getString("cancel_flg"));
			contractInfo.setInceptionDate(res.getString("inception_date"));
			contractInfo.setInceptionTime(res.getString("inception_time"));
			contractInfo.setConclusionDate(res.getString("conclusion_date"));
			contractInfo.setConclusionTime(res.getString("conclusion_time"));
			contractInfo.setPaymentMethod(res.getString("payment_method"));
			contractInfo.setInstallment(res.getInt("installment"));
			contractInfo.setInsuredKbn(res.getString("insured_kbn"));
			contractInfo.setNameKana1(res.getString("name_kana1"));
			contractInfo.setNamekana2(res.getString("name_kana2"));
			contractInfo.setNameKanji1(res.getString("name_kanji1"));
			contractInfo.setNameKanji2(res.getString("name_kanji2"));
			contractInfo.setPostcode(res.getString("postcode"));
			contractInfo.setAddressKana1(res.getString("address_kana1"));
			contractInfo.setAddressKana2(res.getString("address_kana2"));
			contractInfo.setAddressKanji1(res.getString("address_kanji1"));
			contractInfo.setAddressKanji2(res.getString("address_kanji2"));
			contractInfo.setBirthday(res.getString("birthday"));
			contractInfo.setGender(res.getString("gender"));
			contractInfo.setTelephoneNo(res.getString("telephone_no"));
			contractInfo.setMobilephoneNo(res.getString("mobilephone_no"));
			contractInfo.setFaxNo(res.getString("fax_no"));
		}

		}finally {
			if(res != null) {
				res.close();
			}
			if(stmt != null) {
				stmt.close();
			}
		}
		return contractInfo;

	}



	public String getMaxPolNo() throws SQLException {

		String sql = "SELECT pol_No FROM contractinfo_tbl ORDER BY pol_No DESC LIMIT 1";
		PreparedStatement stmt = null;
		ResultSet res =  null;
		String polNo = null;

		try {	stmt=con.prepareStatement(sql);
				res=stmt.executeQuery();

			if (res.next()) {
				polNo = res.getString("pol_No");
			}


		}finally {
			if(res != null) {
				res.close();
			}
			if(stmt != null) {
				stmt.close();
			}
		}
		return polNo;

	}

	public String getMaxInsatsuRenban() throws SQLException {

		String sql = "SELECT insatsu_renban FROM contractinfo_tbl ORDER BY pol_No DESC LIMIT 1";
		PreparedStatement stmt = null;
		ResultSet res =  null;
		String insatsuRenban = null;

		try {	stmt=con.prepareStatement(sql);
				res=stmt.executeQuery();

			if (res.next()) {
				insatsuRenban = res.getString("insatsu_renban");
			}

			String eigo = insatsuRenban.substring(0);
			String suuji = insatsuRenban.substring(1, 9);

			try {
				int incri = Integer.parseInt(suuji);
				int afterIncri = incri + 1;
				String insatsu = Integer.valueOf(afterIncri).toString();
				insatsuRenban = eigo + insatsu;
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
		return insatsuRenban;

	}


	public void terminationAppCompletion(String polNo) throws SQLException {

		/* 以下はスタブ用変数のため必ず除去すること */
		/* 返却用スタブデータの生成 */
		//update文でCancelFlgを0にする。

		String sql = "UPDATE contractinfo_tbl SET cancel_flg = '1' WHERE pol_no = ?";

		PreparedStatement stmt = null;
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, polNo);
			stmt.executeUpdate();
		}finally {

			if(stmt != null) {
				stmt.close();
			}
		}
	}

	public void appropriationCompletion(String insatsuRenban) throws SQLException {

		String sql = "UPDATE contractinfo_tbl SET status_flg = '0' WHERE insatsu_renban = ?";

		PreparedStatement stmt = null;
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, insatsuRenban);
			stmt.executeUpdate();
		}finally {

			if(stmt != null) {
				stmt.close();
			}
		}
	}









}
