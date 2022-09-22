/*------------------------------------------------------------------------------
 * 演習番号：[総合演習]
 * クラス名：[ToTopMenuServlet]
 * 作成日  ：[2022/09/07]
 * 作成者  ：[NarimichiHenmi/SYS]
 *------------------------------------------------------------------------------
 * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
 * (2022/09/22 ： NarimichiHenmi/SYS ：getSessionとremoveSessionに用いる名前の頭文字を大文字から小文字に変更)
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
 * TOPメニューへコントローラ
 * <p>
 * 要求『TOPメニューへ』に対する処理を行う。
 * </p>
 * @author NarimichiHenmi/SYS 2022/09/08
 */

@WebServlet("/toTopMenu")
public class ToTopMenuServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		//セッションの生成
		HttpSession session = request.getSession(false);

		//セッションがない場合、エラーページに遷移
		if(session == null) {
			request.setAttribute("message", ErrorMsgConst.SESSION_ERROR);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/Login.jsp");
			rd.forward(request, response);
			return;
		}
		/* １-１．セッション領域から契約情報オブジェクトを除去する。 */
		if (session.getAttribute("contractInfo") != null) {
			session.removeAttribute("contractInfo");
		}
		/* １-２．セッション領域から補償情報オブジェクトを除去する。 */
		if (session.getAttribute("compensation") != null) {
			session.removeAttribute("compensation");
		}
		/* １-３．セッション領域から事故受付情報オブジェクトを除去する。 */
		if (session.getAttribute("accidentReception") != null) {
			session.removeAttribute("accidentReception");
		}

		/* ２．契約内容入力ページJSPへforwardする。 */
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/TopMenu.jsp");
		rd.forward(request, response);

	}

}
