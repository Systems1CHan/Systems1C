package TS_Net.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TS_Net.model.constant.ErrorMsgConst;
import TS_Net.model.constant.SystemConst;
import TS_Net.model.dao.ContractInfoDao;
import TS_Net.model.data.ContractInfo;
import TS_Net.model.datacheck.BlankChecker;

@WebServlet("/ToQueryConfirm")
public class ToQueryConfirmServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//文字化けを防止する。
		request.setCharacterEncoding(SystemConst.CHAR_SET);
		String page = "/WEB-INF/view/QueryConfirm.jsp";

		ContractInfo contractInfo = null;
		//DAOを生成する。
		ContractInfoDao dao = new ContractInfoDao();

		//contractFormCheckerオブジェクトを生成。
		BlankChecker blankChecker = new BlankChecker();

		//チェック結果がnull出ない場合はリクエストスコープのエラーメッセージをセットし、契約内容入力画面を返す。
		if (blankChecker.blankCheck(request.getParameter("polNo")) != null) {

			request.setAttribute("FORM_ERROR", contractFormChecker.check(rsv));

			page ="/WEB-INF/view/ContractFormPage.jsp";
			//契約内容入力画面へforwardする。
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			return;

		}

		try {
			dao.connect();
			rsv.setAmount(dao.getPrice(request.getParameter("comeFrom"), request.getParameter("comeTo")));
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
				dao.close();

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


