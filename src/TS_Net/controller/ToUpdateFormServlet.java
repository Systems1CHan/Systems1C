/*------------------------------------------------------------------------------
 * 演習番号：[総合演習]
 * クラス名：[ToUpdateFormServlet]更新完了
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
import TS_Net.model.dao.ContractInfoDao;
import TS_Net.model.data.AccidentReception;
import TS_Net.model.data.Compensation;
import TS_Net.model.data.ContractInfo;
import TS_Net.model.datacheck.AccidentReceptionFormChecker;
import TS_Net.model.datacheck.ClaimNoChecker;
import TS_Net.model.datacheck.ContractFormChecker;
import TS_Net.model.datacheck.InsatsuRenbanChecker;
import TS_Net.model.dao.AccidentDao;
		/**
		 * 更新完了画面へコントローラ
		 * <p>
		 * 要求「状況更新完了画面へ」に対する処理を行う。
		 * </p>
		 * @author 	KeinaNoguchi/SYS 2022/09/12
		 */
		@WebServlet("/ToUpdateForm")
		public class ToUpdateFormServlet extends HttpServlet {

			public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding(SystemConst.CHAR_SET);

				HttpSession session = request.getSession(false);
				ContractInfo contractInfo = null;
				AccidentReception accidentReception = null;

				if(session == null) {
					request.setAttribute("message", ErrorMsgConst.SESSION_ERROR);
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
					rd.forward(request, response);
				}else {
					contractInfo = (ContractInfo) session.getAttribute("contractInfo");
					accidentReception = (AccidentReception) session.getAttribute("accidentReception");

					if(contractInfo == null || accidentReception == null) {
						request.setAttribute("message", ErrorMsgConst.SESSION_ERROR);
						RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
						rd.forward(request, response);
					}
				}

				String claimNo = request.getParameter("claimNo");
				String polNo = request.getParameter("polNo");
				String nameKanji1 = request.getParameter("nameKanji1");
				String nameKanji2 = request.getParameter("nameKanji2");
				Integer paymentPrice = Integer.parseInt(request.getParameter("paymentPrice"));

				accidentReception.setClaimNo(claimNo);
				contractInfo.setPolNo(polNo);
				contractInfo.setNameKanji1(nameKanji1);
				contractInfo.setNameKanji2(nameKanji2);
				accidentReception.setPaymentPrice(paymentPrice);

				ContractFormChecker cfc = new ContractFormChecker();
				AccidentReceptionFormChecker arf = new AccidentReceptionFormChecker();

				if(cfc.check(contractInfo) != null) {
					request.setAttribute("message", cfc.check(contractInfo));
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/CustomerFormPage.jsp");
					rd.forward(request, response);

				}else if(arf.check(accidentReception) != null) {
					request.setAttribute("message", arf.check(accidentReception));
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/CustomerFormPage.jsp");
					rd.forward(request, response);

				}else {

					AccidentDao accidentDao = new AccidentDao();

					try {

						accidentDao.connect();
						//証券番号に合致する契約情報を取得し、オブジェクトに格納する。
						accidentDao.updateAccidentReception(0/*accidentReception.getClaimNo()*/);
						ClaimNoChecker cnc = new ClaimNoChecker();
						String errmsg = cnc.claimNoExistenceCheck(accidentReception);

						request.setAttribute("contractInfo", contractInfo);
						request.setAttribute("accidentReception", accidentReception);

					} catch (ClassNotFoundException | SQLException e) {

						e.printStackTrace();
						request.setAttribute("ERROR", ErrorMsgConst.SESSION_ERROR);
						// システムエラー画面を戻り値に設定する。
						RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
						rd.forward(request, response);

					}

					finally {
						try {
							accidentDao.close();
						} catch(SQLException e) {
							request.setAttribute("ERROR", ErrorMsgConst.SYSTEM_ERROR);
							// システムエラー画面を戻り値に設定する。
							RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
							rd.forward(request, response);
						}

					}


					/* 更新完了JSPへforwardする。*/
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ReceptionUpdate.jsp");
					rd.forward(request, response);


				}
}
		}

