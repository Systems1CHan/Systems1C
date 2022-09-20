/*------------------------------------------------------------------------------
 * 演習番号：[総合演習]
 * クラス名：[ToQueryConfirmServlet]
 * 作成日  ：[2022/09/07]
 * 作成者  ：[ToruNakaya/SYS]
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

import TS_Net.model.constant.ErrorMsgConst;
import TS_Net.model.constant.SystemConst;
import TS_Net.model.dao.CompensationDao;
import TS_Net.model.dao.ContractInfoDao;
import TS_Net.model.data.Compensation;
import TS_Net.model.data.ContractInfo;
import TS_Net.model.datacheck.BlankChecker;

/**
 * 照会確認へコントローラ
 * <p>
 * 要求『照会検索』に対する処理を行う。
 * </p>
 * @author ToruNakaya/SYS 2022/09/07
 */
@WebServlet("/ToQueryConfirm")
public class ToQueryConfirmServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //文字化けを防止する。
        request.setCharacterEncoding(SystemConst.CHAR_SET);
        String page = "/WEB-INF/view/QueryConfirmCompany.jsp";
        //dataオブジェクトを生成する。
        ContractInfo contractInfo = null;
        Compensation compensation = null;
        //DAOを生成する。
        ContractInfoDao contractInfoDao = new ContractInfoDao();
        CompensationDao compensationDao = new CompensationDao();

        //空白チェッククラス生成。
        BlankChecker blankChecker = new BlankChecker();

        String polNo = request.getParameter("polNo");


        //チェック結果がnull出ない場合はリクエストスコープのエラーメッセージをセットし、契約内容入力画面を返す。
        if (blankChecker.blankCheck(polNo) != null) {

            request.setAttribute("FORM_ERROR", blankChecker.blankCheck(polNo));

            page ="/WEB-INF/view/QueryStart.jsp";
            //契約内容入力画面へforwardする。
            RequestDispatcher rd = request.getRequestDispatcher(page);
            rd.forward(request, response);
            return;

        }

        try {
            contractInfoDao.connect();
            //証券番号に合致する契約情報を取得し、オブジェクトに格納する。
            contractInfo = contractInfoDao.getContractInfoByPN(polNo);

            //オブジェクト内の証券番号が存在するかどうかをチェックし、存在しなければエラー文を表示する。
            if ("".equals(contractInfo.getPolNo())) {
                request.setAttribute("FORM_ERROR", ErrorMsgConst.FORM_ERROR0006);
//				request.setAttribute("FORM_ERROR", contractInfoDao.getMaxInsatsuRenban());

                page ="/WEB-INF/view/QueryStart.jsp";
                //契約内容入力画面へforwardする。
                RequestDispatcher rd = request.getRequestDispatcher(page);
                rd.forward(request, response);
                return;

            }
            //リクエスト領域に格納する。
            request.setAttribute("contractInfo", contractInfo);

            //オブジェクト内の法人個人区分をチェックし、法人である２が格納されている場合は法人ページをセットする。
            if("2".equals(contractInfo.getInsuredKbn())) {
                page = "/WEB-INF/view/QueryConfirmCompany.jsp";
            }



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
                contractInfoDao.close();

            } catch(SQLException e) {
                request.setAttribute("ERROR", ErrorMsgConst.SYSTEM_ERROR);
                // システムエラー画面を戻り値に設定する。
                page = "/WEB-INF/view/ErrorPage.jsp";
            }

        }


        try {
            compensationDao.connect();
            //証券番号に合致する契約情報を取得し、オブジェクトに格納する。
            compensation = compensationDao.getCompensationByIR(contractInfo.getInsatsuRenban());
            //リクエスト領域に格納する。
            request.setAttribute("compensation", compensation);

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
                contractInfoDao.close();

            } catch(SQLException e) {
                request.setAttribute("ERROR", ErrorMsgConst.SYSTEM_ERROR);
                // システムエラー画面を戻り値に設定する。
                page = "/WEB-INF/view/ErrorPage.jsp";
            }

        }


        /* セットされたJSPへforwardする。*/
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);

    }

}


