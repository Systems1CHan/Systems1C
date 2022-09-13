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
import TS_Net.model.data.Compensation;
import TS_Net.model.data.ContractInfo;
import TS_Net.model.datacheck.ContractFormChecker;
import TS_Net.model.datacheck.InsatsuRenbanChecker;

/**
 * 申込書印刷完了画面へコントローラ
 * <p>
 * 要求「申込書印刷完了画面へ」に対する処理を行う。
 * </p>
 * @author RyoIsogami/SYS 2022/09/12
 */
@WebServlet("/ToPrintingComplete")
public class ToPrintingCompleteServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(SystemConst.CHAR_SET);

		HttpSession session = request.getSession(false);
		ContractInfo contractInfo = null;
		Compensation compensation = null;

		if(session == null) {
			request.setAttribute("message", ErrorMsgConst.SESSION_ERROR);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
			rd.forward(request, response);
		}else {
			contractInfo = (ContractInfo) session.getAttribute("contractInfo");
			compensation = (Compensation) session.getAttribute("compensation");

			if(contractInfo == null || compensation == null) {
				request.setAttribute("message", ErrorMsgConst.SESSION_ERROR);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
				rd.forward(request, response);
			}
		}

		String insatsuRenban = request.getParameter("insatsuRenban");
		String nameKanji1 = request.getParameter("nameKanji1");
		String nameKanji2 = request.getParameter("nameKanji2");

		contractInfo.setInsatsuRenban(insatsuRenban);
		contractInfo.setNameKanji1(nameKanji1);
		contractInfo.setNameKanji2(nameKanji2);

		ContractFormChecker cfc = new ContractFormChecker();
		InsatsuRenbanChecker irc = new InsatsuRenbanChecker();

		if(cfc.check(contractInfo) != null) {
			request.setAttribute("message", cfc.check(contractInfo));
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/CustomerFormPage.jsp");
			rd.forward(request, response);

		}else if(irc.insatusRenbanExistenceCheck(compensation) != null) {
			request.setAttribute("message", irc.insatusRenbanExistenceCheck(compensation));
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/CustomerFormPage.jsp");
			rd.forward(request, response);

		}else {

			ContractInfoDao contractInfoDao = new ContractInfoDao();

			try {
				contractInfoDao.connect();
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/PrintCompleteForm.jsp");
				rd.forward(request, response);
			}catch(SQLException e){
				request.setAttribute("message", ErrorMsgConst.SYSTEM_ERROR);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
				rd.forward(request, response);

			}catch(ClassNotFoundException e) {
				request.setAttribute("message", ErrorMsgConst.SYSTEM_ERROR);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
				rd.forward(request, response);

			}finally {
				try {
					contractInfoDao.close();
				}catch(SQLException e) {
					request.setAttribute("message", ErrorMsgConst.SYSTEM_ERROR);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
					rd.forward(request, response);
				}
			}
		}
	}

}
