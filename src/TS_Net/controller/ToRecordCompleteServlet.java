/*-----------------------------------------------------
 * 演習番号：総合演習
 * クラス名:[ToRecordCompleteServlet]
 * 作成日：[2022/09/07]
 * 作成者：[Akane Nambu/SYS]
 * ----------------------------------------------------
 * 修正履歴（発注No.：修正日：担当者：）
 *------------------------------------------------------------------------------
 *
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
import TS_Net.model.constant.SystemConst;
import TS_Net.model.dao.ContractInfoDao;
import TS_Net.model.data.ContractInfo;

/**
 * Servlet implementation class ToRecordCompleteServlet
 */
@WebServlet("/ToRecordComplete")
public class ToRecordCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	/**
	 * POST処理。
	 * <p>
	 * 受け取った入力内容（印刷連番）に対しての処理を行う。
	 * </p>
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		//文字化けを防止する。
		request.setCharacterEncoding(SystemConst.CHAR_SET);
		String page = "/WEB-INF/view/RecordComplete.jsp";
		//dataオブジェクトを生成する。
		ContractInfo contractInfo = null;

		//DAOを生成する。
		ContractInfoDao contractInfoDao = new ContractInfoDao();

		//セッションを生成する。
		HttpSession session = request.getSession(false);

		//セッションがnullの場合はエラーを表示する。
		if (session == null) {

			request.setAttribute("ERROR", ErrorMsgConst.SESSION_ERROR);
			// システムエラー画面を戻り値に設定する。
			page = "/WEB-INF/view/ErrorPage.jsp";
			//システムエラー画面へforwardする。
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			return;
		}
		//セッションから契約情報オブジェクトを取り出す。
		contractInfo = (ContractInfo) session.getAttribute("contractInfo");
		//オブジェクトが空の場合はエラーを表示する。
		if(contractInfo == null) {
			request.setAttribute("ERROR", ErrorMsgConst.SESSION_ERROR);
			// システムエラー画面を戻り値に設定する。
			page = "/WEB-INF/view/ErrorPage.jsp";
			//システムエラー画面へforwardする。
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			return;
		}


		try {
			contractInfoDao.connect();
			//計上フラグを計上済みに変更する。
			contractInfoDao. appropriationCompletion(contractInfo.getInsatsuRenban());
			//契約情報オブジェクトをリクエスト領域に格納する。
			request.setAttribute("contractInfo", contractInfo);


		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
			request.setAttribute("ERROR", ErrorMsgConst.SESSION_ERROR);
			// システムエラー画面を戻り値に設定する。
			page = "/WEB-INF/view/ErrorPage.jsp";
			//システムエラー画面へforwardする。
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);

		}

		finally {
			try {
				contractInfoDao.close();

			} catch(SQLException e) {
				request.setAttribute("ERROR", ErrorMsgConst.SYSTEM_ERROR);
				// システムエラー画面を戻り値に設定する。
				page = "/WEB-INF/view/ErrorPage.jsp";
			}

		}


		/* TOPメニューJSPへforwardする。*/
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);

	}


}



