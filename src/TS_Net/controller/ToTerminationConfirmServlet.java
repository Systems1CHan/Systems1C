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
import TS_Net.model.dao.CompensationDao;
import TS_Net.model.dao.ContractInfoDao;
import TS_Net.model.data.Compensation;
import TS_Net.model.data.ContractInfo;
import TS_Net.model.datacheck.BlankChecker;

@WebServlet("/ToTerminationConfirm")
public class ToTerminationConfirmServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//文字化けを防止する。
		request.setCharacterEncoding(SystemConst.CHAR_SET);
		String page = "/WEB-INF/view/TerminationConfirm.jsp";
		//dataオブジェクトを生成する。
		ContractInfo contractInfo = null;
		Compensation compensation = null;
		//DAOを生成する。
		ContractInfoDao contractInfoDao = new ContractInfoDao();
		CompensationDao compensationDao = new CompensationDao();

		//セッションを生成する。
		HttpSession session = request.getSession(true);

		//contractFormCheckerオブジェクトを生成。
		BlankChecker blankChecker = new BlankChecker();

		String polNo = request.getParameter("polNo");

		//チェック結果がnull出ない場合はリクエストスコープのエラーメッセージをセットし、契約内容入力画面を返す。
		if (blankChecker.blankCheck(polNo) != null) {

			request.setAttribute("FORM_ERROR", blankChecker.blankCheck(polNo));

			page ="/WEB-INF/view/TerminationStart.jsp";
			//契約内容入力画面へforwardする。
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);
			return;

		}


		try {
			contractInfoDao.connect();
			//証券番号に合致する契約情報を取得し、オブジェクトに格納する。
			contractInfo = contractInfoDao.getContractInfoByPN(polNo);

			if (contractInfo.getPolNo() == null) {
				request.setAttribute("FORM_ERROR", ErrorMsgConst.FORM_ERROR0006);

				page ="/WEB-INF/view/TerminationStart.jsp";
				//契約内容入力画面へforwardする。
				RequestDispatcher rd = request.getRequestDispatcher(page);
				rd.forward(request, response);
				return;
			}

//			if (contractInfo.getCancelFlg().equals("0")) {
//				request.setAttribute("FORM_ERROR", ErrorMsgConst.FORM_ERROR0007);
//
//				page ="/WEB-INF/view/TerminationStart.jsp";
//				//契約内容入力画面へforwardする。
//				RequestDispatcher rd = request.getRequestDispatcher(page);
//				rd.forward(request, response);
//				return;
//			}
			//リクエスト領域に格納する。
			session.setAttribute("contractInfo", contractInfo);


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


		try {
			compensationDao.connect();
			//証券番号に合致する契約情報を取得し、オブジェクトに格納する。
			compensation = compensationDao.getCompensationByIR(contractInfo.getInsatsuRenban());



			request.setAttribute("compensation", compensation);

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
