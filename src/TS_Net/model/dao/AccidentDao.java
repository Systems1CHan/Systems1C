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
public class AccidentDao {


	/**
	 * 予約テーブルDAOクラス。（スタブ）
	 * <p>
	 * 予約テーブルに対するSQL操作を行う。
	 * </p>
	 * @author K.Ogawa/SYS 2019/07/03
	 */
	/* 登録データ : スタブ用変数のため必ず除去すること */
	AccidentReception insertData = new AccidentReception();

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
	 * 事故受付取得メソッド。
	 * <p>
	 * 予約テーブルから、すべての予約情報を取得する。
	 * </p>
	 * @return entityList 予約情報リスト
	 * @throws SQLException SQL実行例外
	 */
	public getAccidentReception(Integer claimNo) throws SQLException {

		/* 以下はスタブ用変数のため必ず除去すること */
		/* 返却用スタブデータの生成 */

		AccidentReception accidentReception = new AccidentReception();
		accidentReception.setClaimNo("C0000001");
		accidentReception.setCoverId(00000001);
		accidentReception.setClaimStatu(1);
		accidentReception.setPaymentPrice(10000);
		accidentReception.setAccidentLocationKana1("トウキョウトタマシ");
		accidentReception.setAccidentLocationKana("オチアイ");
		accidentReception.setAccidentLocationKanji1("東京都多摩市");
		accidentReception.setAccidentLocationKanji2("落合");
		accidentReception.setAccidentDate(20220909);
		accidentReception.setRatingBlameMyself(20);
		accidentReception.setRatingBlameYourself(80);
		accidentReception.setDamageCarPrice(100000);
		accidentReception.setDamageBodilyPrice(100000);
		accidentReception.setDamagePropertyPrice(100000);
		accidentReception.setDamageAccidentPrice(100000);
		accidentReception.setDamageCarState("全損");
		accidentReception.setDamageBodilyState("２週間入院");
		accidentReception.setDamagePropertyState("建物損壊");
		accidentReception.setDamageAccidentState("骨折");


		return accidentReception;

	}

	/**
	 * 事故受付更新メソッド。
	 * <p>
	 * 事故受け付けを更新する。
	 * </p>
	 * @return entityList 予約情報リスト
	 * @throws SQLException SQL実行例外
	 */
	public void updateAccidentReception(Integer claimNo) throws SQLException {

		/* 以下はスタブ用変数のため必ず除去すること */
		/* 返却用スタブデータの生成 */
		//update文でCancelFlgを0にする。
	}

	/**
	 *事故受付完了メソッド。
	 * <p>
	 * 事故受付を完了する。
	 * </p>
	 * @return entityList 予約情報リスト
	 * @throws SQLException SQL実行例外
	 */
	public void completionAccidentReception(Integer claimNo) throws SQLException {

		/* 以下はスタブ用変数のため必ず除去すること */
		/* 返却用スタブデータの生成 */
		//update文でStatusFlgを0にする。
	}




}
