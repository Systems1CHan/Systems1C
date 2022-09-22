/*------------------------------------------------------------------------------
 * 演習番号：[総合演習]
 * クラス名：[LoginDAO]
 * 作成日  ：[2022/09/07]
 * 作成者  ：[NarimichiHenmi/SYS]
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

/**
 * ログインDAOクラス
 * <p>
 * ログインユーザーテーブルにおけるSQL操作を行う
 * </p>
 * @author NarimichiHenmi/SYS 2022/09/08
 */

public class LoginDAO {

	/** 引数なしコンストラクタ */
	public LoginDAO() {};

	/** データベースの接続 */
	private Connection con;

	/**
	 * DB接続メソッド。
	 * <p>
	 * メンバ変数のコネクションオブジェクトを用いて、DBと接続する。
	 * </p>
	 * @throws SQLException SQL実行例外
	 * @throws ClassNotFoundException クラスロード例外
	 */
	public void connect() throws SQLException, ClassNotFoundException {
		/* JDBCドライバをロード */
		try {
			Class.forName(SystemConst.JDBC_DRIVER_NAME);
		} catch (ClassNotFoundException e) {
		}

		/* DBへの接続 */
		try {
			con = DriverManager.getConnection(SystemConst.JDBC_URL, SystemConst.USER, SystemConst.PASSWORD);
			/* 自動コミットはオフ */
			con.setAutoCommit(true);
		} catch (SQLException e) {
		}
	}

	/**
	 * DB切断メソッド。
	 * <p>
	 * メンバ変数のコネクションオブジェクトを用いて、DB接続を切断する。
	 * </p>
	 * @throws SQLException SQL実行例外
	 */
	public void close() throws SQLException {
		/* DBの切断 */
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
		}
	}

	/**
	 * ログイン情報を検索する。
	 *
	 * @param iD  従業員番号
	 * @param password  パスワード
	 * @return  検索結果
	 * @throws  SQLException  データベースエラーが発生した場合LOGIN_USER
	 */
	public boolean findAccount(String iD, String password) throws SQLException {
		String sql = "SELECT * FROM login_user WHERE user = ? and pass = ?";
		PreparedStatement stmt = null;
		ResultSet res = null;
		boolean result = false;

		try {
			// PreparedStatementの作成
			stmt = con.prepareStatement(sql);
			// パラメータの設定
			stmt.setString(1, iD);
			stmt.setString(2, password);
			// SQL文の実行
			res = stmt.executeQuery();
			// 結果セットの確認
			if (res.next()) {
				result = true;
			}
		} finally {
			// クローズ処理
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return result;
	}
}