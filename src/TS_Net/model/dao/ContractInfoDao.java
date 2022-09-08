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

import TS_Net.model.data.ContractInfo;

public class ContractInfoDao {

	/* 登録データ : スタブ用変数のため必ず除去すること */
ContractInfo insertData = new ContractInfo();

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
	public void registContractInfo(ContractInfo conInf) throws SQLException {

		/* 登録データ : スタブ用変数のため必ず除去すること */
		insertData = conInf;

	}

	/**
	 * 全件取得メソッド。
	 * <p>
	 * 予約テーブルから、すべての予約情報を取得する。
	 * </p>
	 * @return entityList 予約情報リスト
	 * @throws SQLException SQL実行例外
	 */
	public getContractInfo(Integer polNo) throws SQLException {

		/* 以下はスタブ用変数のため必ず除去すること */
		/* 返却用スタブデータの生成 */

		ContractInfo contractInfo = new ContractInfo();
		contractInfo.setInsatsuRenban("A0000001");
		contractInfo.setPolNo("B000000001");
		contractInfo.setStatusFlg(1);
		contractInfo.setCancelFlg(0);
		contractInfo.setInceptionDate("20220909");
		contractInfo.setInceptionTime("16");
		contractInfo.setConclusionDate("20230909");
		contractInfo.setConclusionTime("16");
		contractInfo.setPaymentMethod(1);
		contractInfo.setInstallment(1);
		contractInfo.setInsuredKbn(1);
		contractInfo.setNameKana1("ムナカタ");
		contractInfo.setNameKana2("レン");
		contractInfo.setNameKanji1("宗形");
		contractInfo.setNameKanji2("鎌");
		contractInfo.setPostcode(1234567);
		contractInfo.setAddressKana1("トウキョウトタマシ");
		contractInfo.setAddressKana2("オチアイ");
		contractInfo.setAddressKanji1("東京都多摩市");
		contractInfo.setAddressKanji2("落合");
		contractInfo.setBirthday("11111111");
		contractInfo.setGender(1);
		contractInfo.setTelephoneNo("1234567890");
		contractInfo.setMobilephoneNo("12345678901");
		contractInfo.setFaxNo("1234567890");

		return contractInfo;

	}

	public void terminationAppCompletion(Integer polNo) throws SQLException {

		/* 以下はスタブ用変数のため必ず除去すること */
		/* 返却用スタブデータの生成 */
		//update文でCancelFlgを0にする。
	}

	public void appropriationCompletion(Integer insatsuRenban) throws SQLException {

		/* 以下はスタブ用変数のため必ず除去すること */
		/* 返却用スタブデータの生成 */
		//update文でStatusFlgを0にする。
	}







}
