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
import java.util.ArrayList;
import java.util.List;

/**
 * 予約テーブルDAOクラス。（スタブ）
 * <p>
 * 予約テーブルに対するSQL操作を行う。
 * </p>
 * @author K.Ogawa/SYS 2019/07/03
 */
public class AccidentDao {


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
		public void insert(Reservation entity) throws SQLException {

			/* 登録データ : スタブ用変数のため必ず除去すること */
			insertData = entity;

		}

		/**
		 * 全件取得メソッド。
		 * <p>
		 * 予約テーブルから、すべての予約情報を取得する。
		 * </p>
		 * @return entityList 予約情報リスト
		 * @throws SQLException SQL実行例外
		 */
		public List<Reservation> selectAll() throws SQLException {

			/* 以下はスタブ用変数のため必ず除去すること */
			/* 返却用スタブデータの生成 */
			List<Reservation> entityList = new ArrayList<>();

			Reservation rsv1 = new Reservation();
			rsv1.setNo(1);
			rsv1.setDepartureDate("2016-06-20");
			rsv1.setComeFrom("haneda");
			rsv1.setComeTo("fukuoka");
			rsv1.setBaggageComp("1");
			rsv1.setCustomerName("テスト　太郎");
			rsv1.setCustomerPhoneNo("080-5555-4444");
			rsv1.setAmount(12000);
			entityList.add(rsv1);

			Reservation rsv2 = new Reservation();
			rsv2.setNo(2);
			rsv2.setDepartureDate("2016-06-21");
			rsv2.setComeFrom("chitose");
			rsv2.setComeTo("naha");
			rsv2.setBaggageComp("0");
			rsv2.setCustomerName("高橋　テス子");
			rsv2.setCustomerPhoneNo("0430-1234-1234");
			rsv2.setAmount(44000);
			entityList.add(rsv2);

			Reservation rsv3 = new Reservation();
			rsv3.setNo(3);
			rsv3.setDepartureDate("2016-06-25");
			rsv3.setComeFrom("naha");
			rsv3.setComeTo("haneda");
			rsv3.setCustomerName("打鍵　孝");
			rsv3.setCustomerPhoneNo("03-3333-3333");
			rsv3.setAmount(32000);
			entityList.add(rsv3);

			// Insertにて登録したデータの格納
			insertData.setNo(4);
			entityList.add(insertData);

			return entityList;

		}
	}

}
