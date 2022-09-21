/*------------------------------------------------------------------------------
 * 演習番号：[仕様書演習]
 * クラス名：[DaoConst]
 * 作成日  ：[2019/07/21]
 * 作成者  ：[K.Ogawa/SYS]
 *------------------------------------------------------------------------------
 * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
 *------------------------------------------------------------------------------
 */
package TS_Net.model.constant;

/**
 * システム関連情報を定義する定数クラス。
 * <p>
 * システム関連情報を定義する。
 * </p>
 * @author K.Ogawa/SYS 2019/07/21
 */
public class SystemConst {


	/** ドライバー名 */
	public static final String JDBC_DRIVER_NAME = "com.mysql.jdbc.Driver";

	/** JDBC接続文字列 */
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/final_exercise_db?allowPublicKeyRetrieval=true&useSSL=false";

	/** ユーザー名 */
	public static final String USER = "user_name";

	/** パスワード */
	public static final String PASSWORD = "mysql";

	/** 文字コード */
	public static final String CHAR_SET = "UTF-8";


}

//	//aws用
//	/** ドライバー名 */
//	public static final String JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
//
//	/** JDBC接続文字列 */
//	public static final String JDBC_URL = "jdbc:mysql://kouyamada085-dbserver1.cdipzmdeylgh.ap-northeast-1.rds.amazonaws.com:3306/final_exercise_db?allowPublicKeyRetrieval=true&useSSL=false";
//
//	/** ユーザー名 */
//	public static final String USER = "admin";
//
//	/** パスワード */
//	public static final String PASSWORD = "ha1cndyni";
//
//	/** 文字コード */
//	public static final String CHAR_SET = "UTF-8";
//
//}
