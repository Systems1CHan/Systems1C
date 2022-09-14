/*-----------------------------------------------------
 * 演習番号：総合演習
 * クラス名:[ToRecordCompleteServlet]
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

import TS_Net.model.constant.ErrorMsgConst;
import TS_Net.model.constant.SystemConst;
import TS_Net.model.dao.ContractInfoDao;
import TS_Net.model.data.Compensation;
import TS_Net.model.data.ContractInfo;

/**
 * Servlet implementation class ToRecordCompleteServlet
 */
@WebServlet("/ToRecordComplete")
public class ToRecordCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	/**
	 * POST処理。
	 * <p>
	 * 受け取った入力内容（印刷連番）に対しての処理を行う。
	 * </p>
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//文字化けを防止する。
		request.setCharacterEncoding(SystemConst.CHAR_SET);
	/*
	 * 「代理店計上」ボタン押下時に以下の処理を行う。
	１．契約情報クラスのオブジェクトをセッション領域から取得する。*/

		/* ContractInfo型のcontractを生成 */
		ContractInfo contract = new ContractInfo();

		/*Compensation型のcompensationを生成 */
		Compensation compensation = new Compensation();

		/*２．セッション領域からの取得に失敗した場合、エラーメッセージをrequest領域へ設定した上で、エラーページへ遷移。*/
		HttpSession session = request.getSession();
		if (session == null) {
			request.setAttribute("message", ErrorMsgConst.SESSION_ERROR);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
			rd.forward(request, response);
			return;


	/*３．契約情報DAOを用いて、状態フラグと解約フラグをチェックする。*/
			ContractInfoDao ciDao = new ContractInfoDao();

			contract = (ContractInfo) session.getAttribute("ci");

			try {
				ciDao.connect();
				if (contract.getStatusFlg() == 1) {
					ciDao.getPolNumber();
					contract = ciDao.getContractFromRenban(contract.getInsatsuRenban());
					contract.setShowStatus("新規");
				} else if (contract.getStatusFlg() == 5) {
					contract.setShowStatus("変更");
				} else if (contract.getStatusFlg() == 9) {
					contract.setShowStatus("解約");
					ciDao.changeCancel_flg(contract.getInsatsuRenban());
				}
				contract.setStatusFlg(0);
				ciDao.changeStatus_flg(contract.getInsatsuRenban(), contract.getStatusFlg());
				session.setAttribute("Contract", contract);

			} catch (SQLException e) {

			} catch (ClassNotFoundException e) {

			} finally {
				try {
					if (ciDao != null) {
						ciDao.close();
					}
				} catch (SQLException e) {
					request.setAttribute("message", ErrorMsgConst.SYSTEM_ERROR);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/RecordStart.jsp");
					rd.forward(request, response);
					return;
				}
			}

			//２．計上完了画面へforwardする。
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/RecordComplete.jsp");
			rd.forward(request, response);
			return;
		}






	//}
//		try {
	//			ciDao.connect();
		//		InsatsuRenbanChecker irc = new InsatsuRenbanChecker();
			//	String errmsg = irc.insatusRenbanExistenceCheck(compensation);
//
	//			/*３－１．エラーメッセージが返却された場合、エラーメッセージをrequest領域へ設定した上で、計上開始画面JSPへforwardする。*/
		//		if (errmsg != null) {
			//		request.setAttribute("message",  ErrorMsgConst.SYSTEM_ERROR);
				//	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/RecordStart.jsp");
					//rd.forward(request, response);
			//	} else {
				//	/*４．契約情報オブジェクトの解約フラグと状態フラグを更新する。
					// * （状態フラグが９の場合は解約フラグを１に、状態フラグを計上済み状態の０にする。）
//					 * （状態フラグが１または５の時は、状態フラグを０に書き換える。）*/
//
//
	//				/*５．DAOの処理を用いて必要な情報をセットする。（取り出したセッションスコープの値をリクエスト領域に設定する。）*/
	//				ciDao. appropriationCompletion(contract.getInsatsuRenban());
	//				request.setAttribute("contract", contract);
	//				//contract = ciDao.getContractInfo(/*必要な情報*/);

					/*６．計上完了画面JSPへforwardする。*/
//							RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/RecordComplete.jsp");
	//						rd.forward(request, response);

		//				}
			//		} catch (ClassNotFoundException | SQLException e) {

	//				e.printStackTrace();
		//			request.setAttribute("ERROR", ErrorMsgConst.SESSION_ERROR);
					// システムエラー画面を戻り値に設定する。
					//システムエラー画面へforwardする。
		//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
		//			rd.forward(request, response);

		//		} finally {
		//			try {
						/* DAOクローズ */
		//				ciDao.close();

		//			} catch (SQLException e) {
			//			request.setAttribute("message", ErrorMsgConst.SYSTEM_ERROR);
			//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/RecordStart.jsp");
			//			rd.forward(request, response);

			//		}

		//		}
			}
}



