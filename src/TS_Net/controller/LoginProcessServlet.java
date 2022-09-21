/*------------------------------------------------------------------------------
 * 演習番号：[総合演習]
 * クラス名：[LoginProcessServlet]
 * 作成日  ：[2022/09/07]
 * 作成者  ：[NarimichiHenmi/SYS]
 *------------------------------------------------------------------------------
 * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
 *------------------------------------------------------------------------------
 */
package TS_Net.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TS_Net.model.constant.ErrorMsgConst;
import TS_Net.model.dao.LoginDAO;
import TS_Net.model.datacheck.LoginFormChecker;

/**
 * ログイン処理コントローラ
 * <p>
 * 要求『ログイン処理を行い、TOPメニューへ』に対する処理を行う。
 * </p>
 * @author NarimichiHenmi/SYS 2022/09/07
 */
@WebServlet("/loginProcess")
public class LoginProcessServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ

		/* １．ID・Password・ログイン状態の変数を生成する。 */
		/** ID */
		String iD = null;
		/** パスワード */
		String password = null;
		/** ログイン状態判定 */
		boolean loginState = false;
		/** エラーメッセージ */
		String errorMsg = null;

		/* ２．入力フォームから受け取った情報をIDとPasswordにそれぞれ格納する。 */
		iD = request.getParameter("iD");
		password = request.getParameter("password");

		/* ３．ログイン項目チェッククラスの生成を行い、IDとPasswordをログイン項目チェッククラスに渡し、未入力チェックを依頼する。 */
		LoginFormChecker LFC = new LoginFormChecker();
		errorMsg = LFC.emptyCheck(iD, password);

		/*
		 * ３－１ エラーメッセージが返却された場合、
		 * エラーメッセージをrequest領域へ設定した上で、ログインページJSPへforwardする。
		 */
		if (errorMsg != null) {
			/* セッションスコープにエラーメッセージをセットする。 */
			request.setAttribute("errorMsg", errorMsg);
			/* 契約内容入力ページ（今操作してるページと同じページ）に遷移 */
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/Login.jsp");
			rd.forward(request, response);
			return;
		}

		/* ４．ログインDAOクラスの生成を行い、DBと接続する。 */
		LoginDAO LDAO = new LoginDAO();

		try {
			/* DB接続 */
			LDAO.connect();

			/*
			 * 	５．DB内のログインユーザーテーブルにID・Passwordの組があるか検索し、検索結果をboolean型で返却する。
			 */
			loginState = LDAO.findAccount(iD, password);

		} catch (SQLException | ClassNotFoundException e) {
			/* セッションスコープにエラーメッセージをセットする。 */
			e.printStackTrace();
			request.setAttribute("errorMsg", ErrorMsgConst.SYSTEM_ERROR);
			/* 契約内容入力ページ（今操作してるページと同じページ）に遷移 */
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
			rd.forward(request, response);
		} finally {
			try {
				/* DB切断 */
				LDAO.close();
			} catch (SQLException e) {
				e.printStackTrace();
				/* セッションスコープにエラーメッセージをセットする。 */
				request.setAttribute("errorMsg", ErrorMsgConst.SYSTEM_ERROR);
				/* 契約内容入力ページ（今操作してるページと同じページ）に遷移 */
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
				rd.forward(request, response);
			}
		}

		/* ６．検索結果をログイン項目チェッククラスに渡し、チェックを依頼する。 */
		errorMsg = LFC.accountCheck(loginState);

		/* ６－１．エラーメッセージが返却された場合、エラーメッセージをrequest領域へ設定した上で、ログインページJSPへforwardする。 */
		if (errorMsg != null) {
			/* セッションスコープにエラーメッセージをセットする。 */
			request.setAttribute("errorMsg", errorMsg);
			/* 契約内容入力ページ（今操作してるページと同じページ）に遷移 */
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/Login.jsp");
			rd.forward(request, response);
			return;
		}

		/* ７．のちの処理で用いるため、検索結果をセッション領域に格納する。 */
		HttpSession session = request.getSession();
		session.setAttribute("loginState", loginState);

		/* ８．TOPメニューページJSPへforwardする。 */
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/TopMenu.jsp");
		rd.forward(request, response);

	}

}
