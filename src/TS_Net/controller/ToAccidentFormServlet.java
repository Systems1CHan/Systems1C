/*------------------------------------------------------------------------------
 * 演習番号：[総合演習]
 * クラス名：[ToAccidentFormServlet]入力画面
 * 作成日  ：[2022/09/07]
 * 作成者  ：[KeinaNoguchi/SYS]
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

import TS_Net.model.constant.SystemConst;

	/**
	 * 事故受付入力画面へコントローラ
	 * <p>
	 * 要求「事故受付入力画面へ」に対する処理を行う。
	 * </p>
	 * @author KeinaNoguchi/SYS 2022/09/12
	 */
	@WebServlet("/ToStartAccidentForm")
	public class ToAccidentFormServlet extends HttpServlet {

		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			request.setCharacterEncoding(SystemConst.CHAR_SET);

			/* １-１．セッション領域から契約情報オブジェクトを除去する。 */
			HttpSession session = request.getSession();
			if (session.getAttribute("ContractInfo") != null) {
				session.removeAttribute("ContractInfo");
			}
			/* １-２．セッション領域から補償情報オブジェクトを除去する。 */
			if (session.getAttribute("Compensation") != null) {
				session.removeAttribute("Compensation");
			}
			/* １-３．セッション領域から事故受付情報オブジェクトを除去する。 */
			if (session.getAttribute("AccidentReception") != null) {
				session.removeAttribute("AccidentReception");
			}

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ReceptionStart.jsp");
			rd.forward(request, response);

		}
	}