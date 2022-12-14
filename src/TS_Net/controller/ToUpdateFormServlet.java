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
import TS_Net.model.datacheck.AccidentReceptionFormChecker;
import TS_Net.model.datacheck.TextTypeCheker;
        @WebServlet("/ToUpdateForm")
        public class ToUpdateFormServlet extends HttpServlet {

            public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                request.setCharacterEncoding(SystemConst.CHAR_SET);
                //セッションの生成
                HttpSession session = request.getSession(false);

                //セッションがない場合、エラーページに遷移
                if(session == null) {
                    request.setAttribute("message", ErrorMsgConst.SESSION_ERROR);
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/Login.jsp");
                    rd.forward(request, response);
                    return;
                }
                String page = "/WEB-INF/view/ReceptionUpdate.jsp";
                /* 事故受付完了JSPへforwardする。*/

            //dataオブジェクトを生成する。
            ContractInfo contractInfo = null;
            AccidentReception accidentReception = null;

            //DAOを生成する。
            AccidentDao accidentDao = new AccidentDao();
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
            accidentReception.setAccidentDate(request.getParameter("accidentdate").replace("-",""));
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

            //被保険者の過失割合半角数字チェック
            if(0 > accidentReception.getRatingBlameMyself()) {
                request.setAttribute("FORM_ERROR", ErrorMsgConst.FORM_ERROR0021);
                accidentReception.setRatingBlameMyself(0);
                page ="/WEB-INF/view/ReceptionInput.jsp";
                //契約内容入力画面へforwardする。
                RequestDispatcher rd = request.getRequestDispatcher(page);
                rd.forward(request, response);
                return;

            }

            //被害者の過失割合半角数字チェック
            if(0 > accidentReception.getRatingBlameYourself()) {
                request.setAttribute("FORM_ERROR", ErrorMsgConst.FORM_ERROR0021);
                accidentReception.setRatingBlameYourself(0);
                page ="/WEB-INF/view/ReceptionInput.jsp";
                //契約内容入力画面へforwardする。
                RequestDispatcher rd = request.getRequestDispatcher(page);
                rd.forward(request, response);
                return;

            }

            //損害額・車両半角数字チェック
            if(0 > accidentReception.getDamageCarPrice()) {
                request.setAttribute("FORM_ERROR", ErrorMsgConst.FORM_ERROR0022);
                accidentReception.setDamageCarPrice(0);
                page ="/WEB-INF/view/ReceptionInput.jsp";
                //契約内容入力画面へforwardする。
                RequestDispatcher rd = request.getRequestDispatcher(page);
                rd.forward(request, response);
                return;

            }

            //損害額・対人半角数字チェック
            if(0 > accidentReception.getDamageBodilyPrice()) {
                request.setAttribute("FORM_ERROR", ErrorMsgConst.FORM_ERROR0022);
                accidentReception.setDamageBodilyPrice(0);
                page ="/WEB-INF/view/ReceptionInput.jsp";
                //契約内容入力画面へforwardする。
                RequestDispatcher rd = request.getRequestDispatcher(page);
                rd.forward(request, response);
                return;

            }

            //損害額・対物半角数字チェック
            if(0 > accidentReception.getDamagePropertyPrice()) {
                request.setAttribute("FORM_ERROR", ErrorMsgConst.FORM_ERROR0022);
                accidentReception.setDamagePropertyPrice(0);
                page ="/WEB-INF/view/ReceptionInput.jsp";
                //契約内容入力画面へforwardする。
                RequestDispatcher rd = request.getRequestDispatcher(page);
                rd.forward(request, response);
                return;

            }

            //損害額・傷害半角数字チェック
            if(0 > accidentReception.getDamageAccidentPrice()) {
                request.setAttribute("FORM_ERROR", ErrorMsgConst.FORM_ERROR0022);
                accidentReception.setDamageAccidentPrice(0);
                page ="/WEB-INF/view/ReceptionInput.jsp";
                //契約内容入力画面へforwardする。
                RequestDispatcher rd = request.getRequestDispatcher(page);
                rd.forward(request, response);
                return;

            }


            //損害額が1000円単位で入力されているか調べる機能。
            String damageCarPrice =request.getParameter("damagecarprice");
            String damageBodilyPrice =request.getParameter("damagebodilyprice");
            String damagePropertyPrice =request.getParameter("damagepropertyprice");
            String damageAccidentPrice =request.getParameter("damageaccidentprice");





            AccidentReceptionFormChecker checker = new AccidentReceptionFormChecker();

            if(checker.digitCheck( damageCarPrice) != null) {
                request.setAttribute("FORM_ERROR", ErrorMsgConst.FORM_ERROR0020);

                                    page ="/WEB-INF/view/ReceptionInput.jsp";
                                    //契約内容入力画面へforwardする。
                                    RequestDispatcher rd = request.getRequestDispatcher(page);
                                    rd.forward(request, response);
                                    return;
            }

            if(checker.digitCheck(damageBodilyPrice) != null) {
                request.setAttribute("FORM_ERROR", ErrorMsgConst.FORM_ERROR0020);

                                    page ="/WEB-INF/view/ReceptionInput.jsp";
                                    //契約内容入力画面へforwardする。
                                    RequestDispatcher rd = request.getRequestDispatcher(page);
                                    rd.forward(request, response);
                                    return;
            }

            if(checker.digitCheck(damagePropertyPrice) != null) {
                request.setAttribute("FORM_ERROR", ErrorMsgConst.FORM_ERROR0020);

                                    page ="/WEB-INF/view/ReceptionInput.jsp";
                                    //契約内容入力画面へforwardする。
                                    RequestDispatcher rd = request.getRequestDispatcher(page);
                                    rd.forward(request, response);
                                    return;
            }

            if(checker.digitCheck(damageAccidentPrice) != null) {
                request.setAttribute("FORM_ERROR", ErrorMsgConst.FORM_ERROR0020);

                                    page ="/WEB-INF/view/ReceptionInput.jsp";
                                    //契約内容入力画面へforwardする。
                                    RequestDispatcher rd = request.getRequestDispatcher(page);
                                    rd.forward(request, response);
                                    return;
            }


            //カナチェック
//            TextTypeCheker textTypeCheker = new TextTypeCheker();
//
//            if(accidentReception.getAccidentLocationKana1() == null || accidentReception.getAccidentLocationKana1().equals("")) {
//
//            }
//            if(textTypeCheker.textFullwidthCheck(accidentReception.getAccidentLocationKana1()) != null && (accidentReception.getAccidentLocationKana1() != null || !(accidentReception.getAccidentLocationKana1().equals("")))) {
//
//                request.setAttribute("FORM_ERROR", ErrorMsgConst.FORM_ERROR0013);
//
//                page ="/WEB-INF/view/ReceptionInput.jsp";
//                //契約内容入力画面へforwardする。
//                RequestDispatcher rd = request.getRequestDispatcher(page);
//                rd.forward(request, response);
//                return;
//
//            }
//            if(textTypeCheker.textFullwidthCheck(accidentReception.getAccidentLocationKana2()) != null && (accidentReception.getAccidentLocationKana1() != null || !(accidentReception.getAccidentLocationKana1().equals("")))) {
//
//                request.setAttribute("FORM_ERROR", ErrorMsgConst.FORM_ERROR0013);
//
//                page ="/WEB-INF/view/ReceptionInput.jsp";
//                //契約内容入力画面へforwardする。
//                RequestDispatcher rd = request.getRequestDispatcher(page);
//                rd.forward(request, response);
//                return;
//
//            }

            //支払金額計算部分
            Integer damageSumPrice = Integer.parseInt(damageCarPrice) + Integer.parseInt(damageBodilyPrice) + Integer.parseInt(damagePropertyPrice) + Integer.parseInt(damageAccidentPrice);
            Integer paymentPrice = check(request.getParameter("ratingblamemyself")) * damageSumPrice/100;
            accidentReception.setPaymentPrice(paymentPrice);



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

        //数字かどうかチェックする。
        TextTypeCheker textTypeCheker = new TextTypeCheker();

        if(str == null) {
            return 0;
        }else if(str.equals("")) {
            return 0;
        }else if(textTypeCheker.digitCheck(str) !=null){
            return -1;
        }else
            return Integer.parseInt(str);
        }



}




