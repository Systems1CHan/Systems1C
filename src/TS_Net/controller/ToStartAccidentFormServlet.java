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
import java.util.Objects;

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


@WebServlet("/ToReceptionInput")
public class ToStartAccidentFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //文字化けを防止する。
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
        String page = "/WEB-INF/view/ReceptionInput.jsp";

        //dataオブジェクトを定義する。
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

        //証券番号と事故受け付け番号が両方とも入力されている場合エラーを返す。
        if (polNoChecker.polNoInputCheck(polNo, claimNo) != null) {
//			request.setAttribute("FORM_ERROR", polNoChecker.polNoInputCheck(polNo, claimNo));
            request.setAttribute("FORM_ERROR", polNoChecker.polNoInputCheck(polNo, claimNo));

            page ="/WEB-INF/view/ReceptionStart.jsp";
            //契約内容入力画面へforwardする。
            RequestDispatcher rd = request.getRequestDispatcher(page);
            rd.forward(request, response);
            return;


        }
        //証券番号と事故受け付け番号がともに空白の場合エラーを返す。
        if (polNoChecker.polNoNotInputCheck(polNo, claimNo) != null) {
//			request.setAttribute("FORM_ERROR", polNo, claimNo));
            request.setAttribute("FORM_ERROR", polNoChecker.polNoNotInputCheck(polNo, claimNo));

            page ="/WEB-INF/view/ReceptionStart.jsp";
            //契約内容入力画面へforwardする。
            RequestDispatcher rd = request.getRequestDispatcher(page);
            rd.forward(request, response);
            return;


        }else {


            try {
                accidentDao.connect();
                compensationDao.connect();
                contractInfoDao.connect();

                //事故受け付け番号が入力されていた場合
                if(!(Objects.equals(claimNo, null)) && claimNo.length() > 0) {

                    //更新事故受け付けオブジェクトを生成
//					AccidentReception accidentUpdateReception = new AccidentReception();

                //事故受け付け番号に合致する事故受付情報を取得し、オブジェクトに格納する。
                    accidentReception = accidentDao.getAccidentReceptionByCN(claimNo);

                //取得した事故受付情報の受付番号が存在しない時、エラーを出す。
                if ("".equals(accidentReception.getClaimNo())) {
                    request.setAttribute("FORM_ERROR", ErrorMsgConst.FORM_ERROR0010);

                    page ="/WEB-INF/view/ReceptionStart.jsp";
                    //契約内容入力画面へforwardする。
                    RequestDispatcher rd = request.getRequestDispatcher(page);
                    rd.forward(request, response);
                    return;

                }


                //取得した事故受付情報の事故受け付けフラグが受付済になっていたら、エラーを出す。
                if ("9".equals(accidentReception.getClaimStatus())) {
                    request.setAttribute("FORM_ERROR", ErrorMsgConst.FORM_ERROR0011);

                    page ="/WEB-INF/view/ReceptionStart.jsp";
                    //契約内容入力画面へforwardする。
                    RequestDispatcher rd = request.getRequestDispatcher(page);
                    rd.forward(request, response);
                    return;

                }

                //事故受付情報の中から補償IDを取り出す。
                Integer coverId = accidentReception.getCoverId();
                //補償IDを用いて補償情報を取り出す。
                compensation = compensationDao.getCompensationByCI(coverId);


                //補償情報の印刷連番を取り出す。
                String InsatsuRenban = compensation.getInsatsuRenban();

                //印刷連番を用いて契約情報を取り出す。
                contractInfo = contractInfoDao.getContractInfoByIR(InsatsuRenban);

                //オブジェクト内の法人個人区分をチェックし、法人である２が格納されている場合は法人ページをセットする。
                if("2".equals(contractInfo.getInsuredKbn())) {
                    page = "/WEB-INF/view/ReceptionInputCompany.jsp";
                }


                //セッションを生成する。

                session.setAttribute("accidentReception", accidentReception);
                session.setAttribute("compensation", compensation);
                session.setAttribute("contractInfo", contractInfo);


                //証券番号が入力された場合
                }else {
                //証券番号と一致している契約情報を取り出す。
                contractInfo = contractInfoDao.getContractInfoByPN(polNo);

                //証券番号が存在しない場合はエラー
                if ("".equals(contractInfo.getPolNo())) {
                    request.setAttribute("FORM_ERROR", ErrorMsgConst.FORM_ERROR0006);

                    page ="/WEB-INF/view/ReceptionStart.jsp";
                    //契約内容入力画面へforwardする。
                    RequestDispatcher rd = request.getRequestDispatcher(page);
                    rd.forward(request, response);
                    return;

                }


                //証券番号が解約済みの場合はエラー
                if (contractInfo.getCancelFlg().equals("1") && contractInfo.getStatusFlg().equals("0") ) {
                    request.setAttribute("FORM_ERROR", ErrorMsgConst.FORM_ERROR0007);

                    page ="/WEB-INF/view/ReceptionStart.jsp";
                    //契約内容入力画面へforwardする。
                    RequestDispatcher rd = request.getRequestDispatcher(page);
                    rd.forward(request, response);
                    return;

                }



                //オブジェクト内の法人個人区分をチェックし、法人である２が格納されている場合は法人ページをセットする。
                if("2".equals(contractInfo.getInsuredKbn())) {
                    page = "/WEB-INF/view/ReceptionInputCompany.jsp";
                }

                //印刷連番を取り出す。
                String insatsuRenban = contractInfo.getInsatsuRenban();
                //印刷連番に合致する補償情報を取得し、オブジェクトに格納する。
                compensation = compensationDao.getCompensationByIR(insatsuRenban);

                //補償IDを取得する。
                Integer coverId = compensation.getCoverId();
                //事故情報オブジェクトに補償IDをセットする。。
                accidentReception.setCoverId(coverId);
                //事故受け付け番号を連番でとってくる。
                String claimno = accidentDao.getMaxClaimNo();
                accidentReception.setClaimNo(claimno);


                //※補償IDのみなので事故情報は別の名前でセッションにセットする。
                session.setAttribute("accidentReception", accidentReception);
                session.setAttribute("compensation", compensation);
                session.setAttribute("contractInfo", contractInfo);

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
                    accidentDao.close();

                } catch(SQLException e) {
                    request.setAttribute("ERROR", ErrorMsgConst.SYSTEM_ERROR);
                    // システムエラー画面を戻り値に設定する。
                    page = "/WEB-INF/view/ErrorPage.jsp";
                }

            }

        /* TOPメニューJSPへforwardする。*/
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);

    }


}
}