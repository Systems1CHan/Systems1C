package TS_Net.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TS_Net.model.constant.ErrorMsgConst;
import TS_Net.model.constant.SystemConst;
import TS_Net.model.data.Compensation;
import TS_Net.model.data.ContractInfo;


/**
 * 新規試算入力画面へコントローラ
 * <p>
 * 要求「新規試算入力画面へ」に対する処理を行う。
 * </p>
 * @author RyoIsogami/SYS 2022/09/12
 */
@WebServlet("/ToNewEstimation")
public class ToNewEstimationServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding(SystemConst.CHAR_SET);

		//セッションの生成
		HttpSession session = request.getSession(false);

		//セッションがない場合、エラーページに遷移
		if(session == null) {
			request.setAttribute("message", ErrorMsgConst.SESSION_ERROR);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
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

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
		rd.forward(request, response);

	}

	public Integer check(String str) {
		if(str == null) {
			return 0;
		}else if(str.equals("")) {
			return 0;
		}else {
			return Integer.parseInt(str);
		}
	}
}
