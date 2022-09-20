/*------------------------------------------------------------------------------
 * 演習番号：[総合演習]
 * クラス名：[ToTopCancelServlet]
 * 作成日  ：[2022/09/07]
 * 作成者  ：[NarimichiHenmi/SYS]
 *------------------------------------------------------------------------------
 * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
 *------------------------------------------------------------------------------
 */
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

/**
 * 解約へコントローラ
 * <p>
 * 要求『解約へ』に対する処理を行う。
 * </p>
 * @author NarimichiHenmi/SYS 2022/09/07
 */
@WebServlet("/toTopCancel")
public class ToTopCancelServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションの生成
		HttpSession session = request.getSession(false);

		//セッションがない場合、エラーページに遷移
		if(session == null) {
			request.setAttribute("message", ErrorMsgConst.SESSION_ERROR);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/Login.jsp");
			rd.forward(request, response);
			return;
		}

		/* １．解約開始ページJSPへforwardする。 */
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/TerminationStart.jsp");
		rd.forward(request, response);

	}

}
