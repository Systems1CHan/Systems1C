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

@WebServlet("/ToTerminationApplication")
public class ToTerminationApplicationServlet extends  HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//文字化けを防止する。
		request.setCharacterEncoding(SystemConst.CHAR_SET);
		String page = "/WEB-INF/view/TerminationFinish.jsp";
		//dataオブジェクトを生成する。
		ContractInfo contractInfo = null;

		//DAOを生成する。
		ContractInfoDao contractInfoDao = new ContractInfoDao();

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
		contractInfo = (ContractInfo) session.getAttribute("contractInfo");

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
			//証券番号に合致する契約情報を取得し、オブジェクトに格納する。
			contractInfoDao. terminationAppCompletion(contractInfo.getPolNo());
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
