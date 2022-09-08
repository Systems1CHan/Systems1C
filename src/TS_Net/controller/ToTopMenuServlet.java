/*------------------------------------------------------------------------------
 * 演習番号：[総合演習]
 * クラス名：[ToTopMenuServlet]
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

		/* １．セッション領域から予約情報オブジェクトを除去する。 */
		HttpSession session = request.getSession();
		if (session.getAttribute("ContractInfo") != null) {
			session.removeAttribute("ContractInfo");
		}

		if (session.getAttribute("Compensation") != null) {
			session.removeAttribute("Compensation");
		}

		if (session.getAttribute("AccidentReception") != null) {
			session.removeAttribute("AccidentReception");
		}

		/* ２．契約内容入力ページJSPへforwardする。 */
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/TopMenu.jsp");
		rd.forward(request, response);

	}

}
