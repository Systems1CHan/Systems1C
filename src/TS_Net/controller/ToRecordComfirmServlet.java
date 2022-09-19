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

import TS_Net.model.constant.ErrorMsgConst;
import TS_Net.model.constant.SystemConst;
import TS_Net.model.dao.CompensationDao;
import TS_Net.model.dao.ContractInfoDao;
import TS_Net.model.data.Compensation;
import TS_Net.model.data.ContractInfo;
import TS_Net.model.datacheck.BlankChecker;

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
     *@throws SQLException SQL実行例外
     *@throws ClassNotFoundException クラスロード例外
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //文字化けを防止する。
        request.setCharacterEncoding(SystemConst.CHAR_SET);

        /*「計上開始」ボタン押下時に以下の処理を行う。*/
        /*１-1．契約情報クラスのオブジェクトを生成する。（既にセッションに存在する場合は、それを利用する。存在しない場合、セッション領域に格納する。）
         */

        /* ContractInfo型のcontractを生成 */
        ContractInfo contract = new ContractInfo();

        /*Compensation型のcompensationを生成 */
        Compensation compensation = new Compensation();

        /* セッションの生成 */
//		HttpSession session = request.getSession();
//		session.setAttribute("contract"/*キー*/, contract);
//		session.setAttribute("compensation", compensation);

        /*２．要求パラメータを受け取り、契約情報オブジェクト・補償オブジェクトそれぞれにセットする。*/

        String insatsuRenban = request.getParameter("insatsuRenban");

        contract.setInsatsuRenban(insatsuRenban);
        compensation.setInsatsuRenban(insatsuRenban);


        /*
        ３．印刷連番データチェッククラスに契約情報オブジェクトを渡し、チェックを依頼する。*/
        // 空白、nullチェック
        BlankChecker bc = new BlankChecker();
        if(bc.blankCheck(insatsuRenban) != null) {
            request.setAttribute("message", bc.blankCheck(insatsuRenban));
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/RecordStart.jsp");
            rd.forward(request, response);

        }



        /*４．契約情報テーブルDAOの処理を用いて、印刷連番に合致した契約情報を取得し、契約情報オブジェクトにセットする。
         *
         */
        /* 契約情報テーブルDAOオブジェクト生成。*/
        ContractInfoDao ciDao = new ContractInfoDao();
        try {
            /* 契約テーブルDAOの処理を用いて、印刷連番に合致した契約情報を取得し、契約情報オブジェクトにセット。*/
            ciDao.connect();
            contract = ciDao.getContractInfoByIR(insatsuRenban);

            System.out.println(contract.getAddressKana1());


            /*３－１．エラーメッセージが返却された場合、エラーメッセージをrequest領域へ設定した上で、計上開始画面JSPへforwardする。*/
            if ("".equals(contract.getPolNo())) {
                request.setAttribute("message", ErrorMsgConst.FORM_ERROR0006);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/RecordStart.jsp");
                rd.forward(request, response);
            } else {

                //オブジェクト内の法人個人区分をチェックし、法人である２が格納されている場合は法人ページをセットする。
                if(contract.getInsuredKbn() == "2") {
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/RecordCheckCompany.jsp");
                    rd.forward(request, response);
                }

                // 印刷連番が補償TBLに存在したら、印刷連番に合致した契約情報をオブジェクトに格納する。
                HttpSession session = request.getSession();
                session.setAttribute("contractInfo", contract);



            }

         } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
            request.setAttribute("ERROR", ErrorMsgConst.SESSION_ERROR);
            // システムエラー画面を戻り値に設定する。
            //システムエラー画面へforwardする。
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
            rd.forward(request, response);
        } finally {
            try {
                /* DAOクローズ */
                ciDao.close();

            } catch (SQLException e) {
                request.setAttribute("message", ErrorMsgConst.SYSTEM_ERROR);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/RecordStart.jsp");
                rd.forward(request, response);

            }
        }

        //補償クラスも同じように生成
        //補償オブジェクトDAO生成
        CompensationDao cpDao = new CompensationDao();

        try {
            cpDao.connect();
            //印刷連番に合致する補償情報を取得し、オブジェクトに格納する。
            compensation = cpDao.getCompensationByIR(insatsuRenban);
            //リクエスト領域に格納する。
            HttpSession session = request.getSession();
            session.setAttribute("compensation", compensation);

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
            request.setAttribute("ERROR", ErrorMsgConst.SESSION_ERROR);
            // システムエラー画面を戻り値に設定する。
            //システムエラー画面へforwardする。
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
            rd.forward(request, response);

        }

        finally {
            try {
                cpDao.close();

            } catch (SQLException e) {
                request.setAttribute("message", ErrorMsgConst.SYSTEM_ERROR);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/RecordStart.jsp");
                rd.forward(request, response);
            }

        }

        /*７．計上確認画面JSPへforwardする。 */
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/RecordCheck.jsp");
        rd.forward(request, response);


    }
}
