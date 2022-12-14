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

		//セッションの生成
		HttpSession session = request.getSession(false);

		//セッションがない場合、エラーページに遷移
		if(session == null) {
			request.setAttribute("message", ErrorMsgConst.SESSION_ERROR);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/Login.jsp");
			rd.forward(request, response);
			return;
		}

		//契約情報オブジェクトを生成
		ContractInfo contractInfo;

		//セッションに契約情報がない場合、新規生成し、セッションにセット
		if(session.getAttribute("contractInfo") == null) {
			contractInfo = new ContractInfo();
			session.setAttribute("contractInfo", contractInfo);

		}else {
			contractInfo = (ContractInfo) session.getAttribute("contractInfo");
		}

		//補償情報オブジェクトを生成
		Compensation compensation;

		//セッションに補償情報がない場合、新規生成し、セッションにセット
		if(session.getAttribute("compensation") == null) {
			compensation = new Compensation();
			session.setAttribute("compensation", compensation);

		}else {
			compensation = (Compensation) session.getAttribute("compensation");
		}

		//印刷連番、証券番号の生成
		String insatsuRenban = null;
		String polNo = null;

		//契約情報DAOの生成
		ContractInfoDao contractInfoDao = new ContractInfoDao();

		try {
			//DAOの接続
			contractInfoDao.connect();

			//DAOの印刷連番、証券番号オートインクリメント処理を実施
			insatsuRenban = contractInfoDao.getMaxInsatsuRenban();
			polNo = contractInfoDao.getMaxPolNo();

			//印刷連番、証券番号を契約情報オブジェクトにセット
			contractInfo.setInsatsuRenban(insatsuRenban);
			contractInfo.setPolNo(polNo);
			System.out.println(insatsuRenban);
			System.out.println(polNo);

			//状態フラグ、解約フラグの更新
			contractInfo.setStatusFlg("1");
			contractInfo.setCancelFlg("0");

			//セッション領域に格納
			session.setAttribute("contractInfo", contractInfo);

			//DAOの処理を用いて、DBにINSERT
			contractInfoDao.registContractInfo(contractInfo);

		//例外処理
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			request.setAttribute("message", ErrorMsgConst.SESSION_ERROR);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
			rd.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("message", ErrorMsgConst.SESSION_ERROR);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
			rd.forward(request, response);

		} finally {
			try {
				contractInfoDao.close();
			} catch(SQLException e) {
				e.printStackTrace();
				request.setAttribute("message", ErrorMsgConst.SESSION_ERROR);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
				rd.forward(request, response);
			}
		}

		//補償情報DAOの生成
		CompensationDao compensationDao = new CompensationDao();

		try {
			//DAOの接続
			compensationDao.connect();

			//補償情報オブジェクトに印刷連番をセット
			compensation.setInsatsuRenban(insatsuRenban);

			//補償情報オブジェクトの情報をINSERT
			compensationDao.registCompensation(compensation);

		//例外処理
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			request.setAttribute("message", ErrorMsgConst.SESSION_ERROR);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
			rd.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("message", ErrorMsgConst.SESSION_ERROR);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
			rd.forward(request, response);

		} finally {
			try {
				contractInfoDao.close();
			} catch(SQLException e) {
				e.printStackTrace();
				request.setAttribute("message", ErrorMsgConst.SESSION_ERROR);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
				rd.forward(request, response);
			}
		}

		//申込書印刷完了画面へforwardする
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/PrintCompleteForm.jsp");
		rd.forward(request, response);
	}

}
