/*------------------------------------------------------------------------------
 * 演習番号：[総合演習]
 * クラス名：[ToStartAccidentFormServlet]
 * 作成日  ：[2022/09/07]
 * 作成者  ：[KeinaNoguchi/SYS]
 *------------------------------------------------------------------------------
 * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
 *------------------------------------------------------------------------------
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
import TS_Net.model.dao.AccidentDao;
import TS_Net.model.dao.CompensationDao;
import TS_Net.model.dao.ContractInfoDao;
import TS_Net.model.data.AccidentReception;
import TS_Net.model.data.Compensation;
import TS_Net.model.data.ContractInfo;
import TS_Net.model.datacheck.PolNoChecker;


@WebServlet("/ToStartAccidentForm")
public class ToStartAccidentFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//文字化けを防止する。
		request.setCharacterEncoding(SystemConst.CHAR_SET);
		String page = "/WEB-INF/view/ReceptionInput.jsp";
		//dataオブジェクトを生成する。
		AccidentReception accidentReception = new AccidentReception();
		ContractInfo contractInfo = null;
		Compensation compensation = null;
		//DAOを生成する。
		AccidentDao accidentDao = new AccidentDao();
		ContractInfoDao contractInfoDao = new ContractInfoDao();
		CompensationDao compensationDao = new CompensationDao();

		//証券番号と事故受け付け番号について空白チェックと両方が記入されていないかチェックを行う。
		String claimNo = request.getParameter("claimNo");
		String polNo = request.getParameter("polNo");
		PolNoChecker polNoChecker = new PolNoChecker();

//		if (polNoChecker.polNoInputCheck(polNo, claimNo) != null) {
//
//			request.setAttribute("FORM_ERROR", polNoChecker.polNoInputCheck(polNo, claimNo));
//
//			page ="/WEB-INF/view/ReceptionStart.jsp";
//			//契約内容入力画面へforwardする。
//			RequestDispatcher rd = request.getRequestDispatcher(page);
//			rd.forward(request, response);
//			return;
//		}
//
//		if (polNoChecker.polNoNotInputCheck(polNo, claimNo) != null) {
//
//			request.setAttribute("FORM_ERROR", polNoChecker.polNoNotInputCheck(polNo, claimNo));
//
//			page ="/WEB-INF/view/ReceptionStart.jsp";
//			//契約内容入力画面へforwardする。
//			RequestDispatcher rd = request.getRequestDispatcher(page);
//			rd.forward(request, response);
//			return;
//		}


			try {
				accidentDao.connect();
				compensationDao.connect();
				contractInfoDao.connect();

				if(polNo == null && claimNo != null) {
				//証券番号に合致する契約情報を取得し、オブジェクトに格納する。
				accidentReception = accidentDao.getAccidentReceptionByCN(claimNo);

				if (accidentReception.getClaimNo() == null) {
					request.setAttribute("FORM_ERROR", ErrorMsgConst.FORM_ERROR0006);

					page ="/WEB-INF/view/ReceptionStart.jsp";
					//契約内容入力画面へforwardする。
					RequestDispatcher rd = request.getRequestDispatcher(page);
					rd.forward(request, response);
					return;

				}
				//証券番号に合致する契約情報を取得し、オブジェクトに格納する。
				Integer coverId = accidentReception.getDamageAccidentPrice();
				compensation = compensationDao.getCompensationByCI(coverId);

				//証券番号に合致する契約情報を取得し、オブジェクトに格納する。
				String InsatsuRenban = compensation.getInsatsuRenban();
				contractInfo = contractInfoDao.getContractInfoByIR(InsatsuRenban);

				}
				else if(polNo != null && claimNo == null){
				contractInfo = contractInfoDao.getContractInfoByPN(polNo);

				if (contractInfo.getPolNo() == null) {
					request.setAttribute("FORM_ERROR", ErrorMsgConst.FORM_ERROR0006);

					page ="/WEB-INF/view/ReceptionStart.jsp";
					//契約内容入力画面へforwardする。
					RequestDispatcher rd = request.getRequestDispatcher(page);
					rd.forward(request, response);
					return;
				}
				//証券番号に合致する契約情報を取得し、オブジェクトに格納する。
				String insatsuRenban = contractInfo.getInsatsuRenban();
				compensation = compensationDao.getCompensationByIR(insatsuRenban);

				//証券番号に合致する契約情報を取得し、オブジェクトに格納する。
				Integer coverId = compensation.getCoverId();
				accidentReception.setCoverId(coverId);

				}

				//セッションを生成する。
				HttpSession session = request.getSession(true);

				session.setAttribute("accidentReception", accidentReception);
				session.setAttribute("compensation", compensation);
				session.setAttribute("contractInfo", contractInfo);

			} catch (ClassNotFoundException | SQLException e) {

				e.printStackTrace();
				request.setAttribute("ERROR", ErrorMsgConst.SESSION_ERROR);
				// システムエラー画面を戻り値に設定する。
				page = "/WEB-INF/view/ErrorPage.jsp";
				//システムエラー画面へforwardする。
				RequestDispatcher rd = request.getRequestDispatcher(page);
				rd.forward(request, response);

			}

			finally {
				try {
					accidentDao.close();

				} catch(SQLException e) {
					request.setAttribute("ERROR", ErrorMsgConst.SYSTEM_ERROR);
					// システムエラー画面を戻り値に設定する。
					page = "/WEB-INF/view/ErrorPage.jsp";
				}

			}






//		//セッションを生成する。
//		HttpSession session = request.getSession(false);
//
//		if (session == null) {
//			session = request.getSession(true);
//			accidentReception = new AccidentReception();
//			session.setAttribute("accidentReception", accidentReception);
//		}else {
//			accidentReception = (AccidentReception) session.getAttribute("accidentReception");
//			if(accidentReception == null) {
//				accidentReception  = new AccidentReception();
//				session.setAttribute("accidentReception",accidentReception);
//			}
//
//		}



//
//
//		try {
//			accidentDao.connect();
//			//証券番号に合致する契約情報を取得し、オブジェクトに格納する。
//			accidentDao. updateAccidentReception(accidentReception.getclaimNo());
//			request.setAttribute("accidentreception", accidentReception);
//
//
//		} catch (ClassNotFoundException | SQLException e) {
//
//			e.printStackTrace();
//			request.setAttribute("ERROR", ErrorMsgConst.SESSION_ERROR);
//			// システムエラー画面を戻り値に設定する。
//			page = "/WEB-INF/view/ErrorPage.jsp";
//			//システムエラー画面へforwardする。
//			RequestDispatcher rd = request.getRequestDispatcher(page);
//			rd.forward(request, response);
//
//		}
//
//		finally {
//			try {
//				accidentDao.close();
//				contractInfoDao.close();
//
//			} catch(SQLException e) {
//				request.setAttribute("ERROR", ErrorMsgConst.SYSTEM_ERROR);
//				// システムエラー画面を戻り値に設定する。
//				page = "/WEB-INF/view/ErrorPage.jsp";
//			}
//
//		}


		/* TOPメニューJSPへforwardする。*/
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);

	}


}