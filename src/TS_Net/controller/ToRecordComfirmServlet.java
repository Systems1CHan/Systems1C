/*-----------------------------------------------------
 * 演習番号：総合演習
 * クラス名:[ToRecordComfirmServlet]
 * 作成日：[2022/09/07]
 * 作成者：[Akane Nambu/SYS]
 * ----------------------------------------------------
 * 修正履歴（発注No.：修正日：担当者：）
 *------------------------------------------------------------------------------
 *
 */
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

import TS_Net.model.constant.SystemConst;
import TS_Net.model.constant.ErrorMsgConst;
import TS_Net.model.data.ContractInfo;
import TS_Net.model.data.Compensation;
import TS_Net.model.datacheck.PolNoChecker;
import TS_Net.model.dao.CompensationDao;
import TS_Net.model.dao.ContractInfoDao;


/**
 * Servlet implementation class ToRecordComfirmServlet
 */
@WebServlet("/ToRecordComfirm")
public class ToRecordComfirmServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	/**
	 * POST処理。
	 * <p>
	 * 受け取った入力内容（印刷連番）に対しての処理を行う。
	 * </p>
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(SystemConst.CHAR_SET);


		/*「計上開始」ボタン押下時に以下の処理を行う。*/
		/*１-1．契約情報クラスのオブジェクトを生成する。（既にセッションに存在する場合は、それを利用する。存在しない場合、セッション領域に格納する。）
		*/


		/* ContractInfo型のcontractを生成 */
		ContractInfo contract = null;

		/* セッションの生成 */
		HttpSession session = request.getSession();

		/* セッションに存在する契約情報オブジェクトを利用 */
		contract = (ContractInfo) session.getAttribute("contract");

		if (contract == null) {
			contract = new ContractInfo();
			session.setAttribute("contract", contract);
		}


		/* 補償クラスのオブジェクトを作っておく。 */
		getCompensation compensation = null;
		/* 遷移先jspのURL(デフォルトはnull) */
		String jsp = null;


		/*１-２．補償クラスのオブジェクトを生成する。（既にセッションに存在する場合は、それを利用する。存在しない場合、セッション領域に格納する。）
		 *
		 */
		/*Compensation型のcompensationを生成 */
		Compensation compensation = null;

		/* セッションの生成 */
		HttpSession session = request.getSession();

		/* セッションに存在する契約情報オブジェクトを利用 */
		compensation = (Compensation) session.getAttribute("compensation");

		if (compensation == null) {
			compensation = new Compensation();
			session.setAttribute("compensation", compensation);
		}

		/*２．要求パラメータを受け取り、契約情報オブジェクト・補償オブジェクトそれぞれにセットする。*/

		String polNo = request.getParameter("polNo");

		contract.setpolNo(polNo);
		compensation.setpolNo(polNo);


		/*
		３．印刷連番データチェッククラスに契約情報オブジェクトを渡し、チェックを依頼する。*/
		PolNoChecker irc = new PolNoChecker();
		String errmsg = irc.check(contract);

		/*３－１．falseが返却された場合、エラーメッセージをrequest領域へ設定した上で、計上開始画面JSPへforwardする。*/
		if (errmsg != null) {
			request.setAttribute("message", errmsg);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/RecordStart.jsp");
			rd.forward(request, response);
		} else {


		/*４．契約情報テーブルDAOの処理を用いて、印刷連番に合致した契約情報を取得し、契約情報オブジェクトにセットする。
		 *
		 */
		/* 契約情報テーブルDAOオブジェクト生成。*/
		ContractInfoDao ciDao = new ContractInfoDao();
		try {
			 /* 契約テーブルDAOの処理を用いて、印刷連番に合致した契約情報を取得し、契約情報オブジェクトにセット。*/
			ciDao.connect();
			int price = ciDao.getPrice(contract.getComeFrom(), contract.getComeTo());
			contract.setAmount(price);
		} catch (SQLException e) {

		}


		/*４－１．nullが返却された場合、エラーメッセージをrequest領域に設定した上で、計上開始画面JSPへforwardする。*/

		/* SQLExceptionが発生した場合。 */
			request.setAttribute("message", e.getMessage());
			jsp = "/WEB-INF/view/RecordStart.jsp";
		} catch (ClassNotFoundException e) {
			/* ClassNotFoundExceptionが発生した場合。 */
			request.setAttribute("message", e.getMessage());
			jsp ="/WEB-INF/view/RecordStart.jsp";

		} finally {
			try {
				/* DAOクローズ */
				ciDao.close();

			} catch (SQLException e) {
				/* SQLExceptionが発生した場合。 */
				request.setAttribute("message", e.getMessage());
				jsp = "/WEB-INF/view/RecordStart.jsp";
			}
		}


		/*５．契約情報オブジェクトの状態フラグが０でない（計上済みでない）こと、また解約フラグが１でない（解約済み）でないことを確認。*/


		/*６．補償DAOの処理を用いて、印刷連番に合致した補償を取得し、補償オブジェクトにセットする。*/

		/* 補償テーブルDAOオブジェクト生成。*/
		CompensationDao cDao = new CompensationDao();
		try {
			 /* 補償テーブルDAOの処理を用いて、印刷連番に合致した補償を取得し、補償オブジェクトにセット。*/
			cDao.connect();
			int price = cDao.getPrice(compensation.getComeFrom(), compensation.getComeTo());
			contract.setAmount(price);
		} catch (SQLException e) {

		}



		/*６－１．nullが返却された場合、エラーメッセージをrequest領域に設定した上で、計上開始画面JSPへforwardする。*/
	 	request.setAttribute(polNo, compensation);/*()内エラーメッセージ書き方やる*/
	 	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/RecordStart.jsp");
		rd.forward(request, response);



		/*７．計上確認画面JSPへforwardする。 */
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/RecordCheck.jsp");
		rd.forward(request, response);


	}

}
