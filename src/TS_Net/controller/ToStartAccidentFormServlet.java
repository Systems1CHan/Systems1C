/*------------------------------------------------------------------------------
 * 演習番号：[総合演習]
 * クラス名：[ToStartAccidentFormServlet]
 * 作成日  ：[2022/09/07]
 * 作成者  ：[KeinaNoguchi/SYS]
 *------------------------------------------------------------------------------
 * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
 *------------------------------------------------------------------------------
 */
package TS_Net.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TS_Net.model.dao.AccidentDao;
import TS_Net.model.dao.ContractInfoDao;
import TS_Net.model.data.AccidentReception;
import TS_Net.model.data.Compensation;
import TS_Net.model.data.ContractInfo;
import TS_Net.model.datacheck.BlankChecker;
import TS_Net.model.datacheck.InsatsuRenbanChecker;
import TS_Net.model.constant.ErrorMsgConst;
import TS_Net.model.constant.SystemConst;


@WebServlet("/ToStartAccidentForm")
public class ToStartAccidentFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//文字化けを防止する。
		request.setCharacterEncoding(SystemConst.CHAR_SET);
		String page = "/WEB-INF/view/ReceptionStart.jsp";
		//dataオブジェクトを生成する。
		AccidentReception accidentReception = null;

		//DAOを生成する。
		AccidentDao accidentDao = new AccidentDao();

		//セッションを生成する。
		HttpSession session = request.getSession(false);

		if (session == null) {

			request.setAttribute("ERROR", ErrorMsgConst.SESSION_ERROR);
			// システムエラー画面を戻り値に設定する。
			page = "/WEB-INF/view/ErrorPage.jsp";
			//システムエラー画面へforwardする。
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			return;
		}
		accidentReception = (AccidentReception) session.getAttribute("accidentReception");

		if(accidentReception == null) {
			request.setAttribute("ERROR", ErrorMsgConst.SESSION_ERROR);
			// システムエラー画面を戻り値に設定する。
			page = "/WEB-INF/view/ErrorPage.jsp";
			//システムエラー画面へforwardする。
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			return;
		}


		try {
			accidentDao.connect();
			//証券番号に合致する契約情報を取得し、オブジェクトに格納する。
			accidentDao. updateAccidentReception(accidentReception.getclaimNo());
			request.setAttribute("accidentreception", accidentReception);


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
				accidentDao.close();
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