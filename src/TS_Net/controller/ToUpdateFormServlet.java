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
/**
         * 更新完了画面へコントローラ
         * <p>
         * 要求「状況更新完了画面へ」に対する処理を行う。
         * </p>
         * @author 	KeinaNoguchi/SYS 2022/09/12
         */
import TS_Net.model.dao.AccidentDao;
import TS_Net.model.data.AccidentReception;
import TS_Net.model.data.ContractInfo;
        @WebServlet("/ToUpdateForm")
        public class ToUpdateFormServlet extends HttpServlet {

            public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                request.setCharacterEncoding(SystemConst.CHAR_SET);
                String page = "/WEB-INF/view/ReceptionUpdate.jsp";
                /* 事故受付完了JSPへforwardする。*/

            //dataオブジェクトを生成する。
            ContractInfo contractInfo = null;
            AccidentReception accidentReception = null;

            //DAOを生成する。
            AccidentDao accidentDao = new AccidentDao();

            //セッションを生成する。
            HttpSession session = request.getSession(false);

            //セッションがnullの場合はエラーを表示する。
            if (session == null) {

                request.setAttribute("ERROR", ErrorMsgConst.SESSION_ERROR);
                // システムエラー画面を戻り値に設定する。
                page = "/WEB-INF/view/ErrorPage.jsp";
                //システムエラー画面へforwardする。
                RequestDispatcher rd = request.getRequestDispatcher(page);
                rd.forward(request, response);
                return;
            }
            //セッションから契約情報オブジェクトを取り出す。
            contractInfo = (ContractInfo) session.getAttribute("contractInfo");
            //オブジェクトが空の場合はエラーを表示する。
            if(contractInfo == null) {
                request.setAttribute("ERROR", ErrorMsgConst.SESSION_ERROR);
                // システムエラー画面を戻り値に設定する。
                page = "/WEB-INF/view/ErrorPage.jsp";
                //システムエラー画面へforwardする。
                RequestDispatcher rd = request.getRequestDispatcher(page);
                rd.forward(request, response);
                return;
            }

            accidentReception = (AccidentReception) session.getAttribute("accidentReception");
            //オブジェクトが空の場合はエラーを表示する。
            if(accidentReception == null) {
                request.setAttribute("ERROR", ErrorMsgConst.SESSION_ERROR);
                // システムエラー画面を戻り値に設定する。
                page = "/WEB-INF/view/ErrorPage.jsp";
                page = "/WEB-INF/view/ReceptionUpdate.jsp";
                //システムエラー画面へforwardする。
                RequestDispatcher rd = request.getRequestDispatcher(page);
                rd.forward(request, response);
                return;
            }



            // 要求パラメータを受け取り、事故情報オブジェクトにセットする。
            accidentReception.setAccidentLocationKana1(request.getParameter("accidentlocationkana1"));
            accidentReception.setAccidentLocationKana2(request.getParameter("accidentlocationkana2"));
            accidentReception.setAccidentLocationKanji1(request.getParameter("accidentlocationkanji1"));
            accidentReception.setAccidentLocationKanji2(request.getParameter("accidentlocationkanji2"));
            accidentReception.setAccidentDate(request.getParameter("accidentdate"));
            accidentReception.setAccidentSituation(request.getParameter("accidentsituation"));
            accidentReception.setRatingBlameMyself(check(request.getParameter("ratingblamemyself")));
            accidentReception.setRatingBlameYourself(check(request.getParameter("ratingblameyourself")));
            accidentReception.setDamageCarPrice(check(request.getParameter("damagecarprice")));
            accidentReception.setDamageBodilyPrice(check(request.getParameter("damagebodilyprice")));
            accidentReception.setDamagePropertyPrice(check(request.getParameter("damagepropertyprice")));
            accidentReception.setDamageAccidentPrice(check(request.getParameter("damageaccidentprice")));
            accidentReception.setDamageCarState(request.getParameter("damagecarstate"));
            accidentReception.setDamageBodilyState(request.getParameter("damagebodilystate"));
            accidentReception.setDamagePropertyState(request.getParameter("damagepropertystate"));
            accidentReception.setDamageAccidentState(request.getParameter("damageaccidentstate"));
            accidentReception.setPaymentPrice(check(request.getParameter("paymentprice")));
//            accidentReception.setInsatsuRenban(request.getParameter("damageaccidentstate")));
//            accidentReception.setPaymentPrice(check(request.getParameter("paymentprice")));


//            Integer.parseInt(request.getParameter("insatallment"));


            //事故受け付けフラグを1受付中に設定
            accidentReception.setClaimStatus("1");

            //契約情報オブジェクトをリクエスト領域に格納する。
            request.setAttribute("contractInfo", contractInfo);


            try {
                accidentDao.connect();


                //事故受け受け番号が存在しない時、。
                if ("".equals(accidentDao.getAccidentReceptionByCN(accidentReception.getClaimNo()).getClaimNo())) {

                //INSERT文によって事故受け付け番号・補償ID・事故受け付けフラグをDBに登録する。
                accidentDao.registAccidentReception(accidentReception);

                }
                //入力された事故受け付け情報を更新する。
                accidentDao.updateAccidentReception(accidentReception);

                //事故情報オブジェクトをリクエスト領域に格納する。
                request.setAttribute("accidentReception", accidentReception);


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

            RequestDispatcher rd = request.getRequestDispatcher(page);
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




