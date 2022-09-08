/*------------------------------------------------------------------------------
 * 演習番号：[総合演習]
 * クラス名：[ToTopRecordingServlet]
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

/**
 * 計上へコントローラ
 * <p>
 * 要求『計上へ』に対する処理を行う。
 * </p>
 * @author NarimichiHenmi/SYS 2022/09/07
 */
@WebServlet("/toTopRecording")
public class ToTopRecordingServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO 自動生成されたメソッド・スタブ

		/* １．計上開始ページJSPへforwardする。 */
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/RecordStart.jsp");
		rd.forward(request, response);

	}

}
