package TS_Net.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import TS_Net.model.constant.ErrorMsgConst;
import TS_Net.model.constant.SystemConst;
import TS_Net.model.data.Compensation;
import TS_Net.model.data.ContractInfo;
import TS_Net.model.datacheck.CompensationFormChecker;
import TS_Net.model.datacheck.ContractFormChecker;



/**
 * 申込書印刷確認画面へコントローラ
 * <p>
 * 要求「申込書印刷確認画面へ」に対する処理を行う。
 * </p>
 * @author RyoIsogami/SYS 2022/09/12
 */
@WebServlet("/ToPrintingConfirm")
public class ToPrintingConfirmServlet extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(SystemConst.CHAR_SET);

		HttpSession session = request.getSession(false);

		//セッションがない場合、エラーページに遷移
		if(session == null) {
			request.setAttribute("message", ErrorMsgConst.SESSION_ERROR);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/Login.jsp");
			rd.forward(request, response);
			return;
		}

		//契約情報オブジェクトを生成
		ContractInfo contractInfo;

		//セッションに契約情報がない場合、新規生成し、セッションにセット
		if(session.getAttribute("contractInfo") == null) {
			contractInfo = new ContractInfo();
			session.setAttribute("contractInfo", contractInfo);

		}else {
			contractInfo = (ContractInfo) session.getAttribute("contractInfo");
		}

		//補償情報オブジェクトを生成
		Compensation compensation;

		//セッションに補償情報がない場合、新規生成し、セッションにセット
		if(session.getAttribute("compensation") == null) {
			compensation = new Compensation();
			session.setAttribute("compensation", compensation);

		}else {
			compensation = (Compensation) session.getAttribute("compensation");
		}

		//保険料試算がされていないとき、エラーを表示する
		if(compensation.getPremiumAmount() == 0 || compensation.getPremiumInstallment() == 0) {
			request.setAttribute("message", "保険料試算を行ってください。");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
			rd.forward(request, response);
			return;
		}

		String insuredKbn = request.getParameter("insuredKbn");
		request.setAttribute("radioButtonValue", insuredKbn);
		System.out.println(insuredKbn + "が選択されてる。");

		if(insuredKbn.equals("1")) {
			if(!(request.getParameter("inceptionDate").equals(contractInfo.getInceptionDate()))) {
				contractInfo.setInceptionDate(request.getParameter("inceptionDate"));
				request.setAttribute("message", "保険料試算後から保険期間始期日が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("inceptionTime").equals(contractInfo.getInceptionTime()))) {
				contractInfo.setInceptionTime(request.getParameter("inceptionTime"));
				request.setAttribute("message", "保険料試算後から保険期間始期時刻が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("conclusionDate").equals(contractInfo.getConclusionDate()))) {
				contractInfo.setConclusionDate(request.getParameter("conclusionDate"));
				request.setAttribute("message", "保険料試算後から保険期間満期日が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("conclusionTime").equals(contractInfo.getConclusionTime()))) {
				contractInfo.setConclusionTime(request.getParameter("conclusionTime"));
				request.setAttribute("message", "保険料試算後から保険期間満期時刻が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("paymentMethod").equals(contractInfo.getPaymentMethod()))) {
				contractInfo.setPaymentMethod(request.getParameter("paymentMethod"));
				request.setAttribute("message", "保険料試算後から払込方法が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(Integer.parseInt(request.getParameter("installment")) == (contractInfo.getInstallment()))) {
				contractInfo.setInstallment(Integer.parseInt(request.getParameter("installment")));
				request.setAttribute("message", "保険料試算後から払込回数が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("nameKana1").equals(contractInfo.getNameKana1()))) {
				contractInfo.setNameKana1(request.getParameter("nameKana1"));
				request.setAttribute("message", "保険料試算後から氏名カナ１が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("nameKana2").equals(contractInfo.getNameKana2()))) {
				contractInfo.setNameKana2(request.getParameter("nameKana2"));
				request.setAttribute("message", "保険料試算後から氏名カナ２が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("nameKanji1").equals(contractInfo.getNameKanji1()))) {
				contractInfo.setNameKanji1(request.getParameter("nameKanji1"));
				request.setAttribute("message", "保険料試算後から氏名漢字１が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("nameKanji2").equals(contractInfo.getNameKanji2()))) {
				contractInfo.setNameKanji2(request.getParameter("nameKanji2"));
				request.setAttribute("message", "保険料試算後から氏名漢字２が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("postcode").equals(contractInfo.getPostcode()))) {
				contractInfo.setPostcode(request.getParameter("postcode"));
				request.setAttribute("message", "保険料試算後から郵便番号が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("addressKana1").equals(contractInfo.getAddressKana1()))) {
				contractInfo.setAddressKana1(request.getParameter("addressKana1"));
				request.setAttribute("message", "保険料試算後から住所カナ１が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("addressKana2").equals(contractInfo.getAddressKana2()))) {
				contractInfo.setAddressKana2(request.getParameter("addressKana2"));
				request.setAttribute("message", "保険料試算後から住所カナ２が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("addressKanji1").equals(contractInfo.getAddressKanji1()))) {
				contractInfo.setAddressKanji1(request.getParameter("addressKanji1"));
				request.setAttribute("message", "保険料試算後から住所漢字１が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("addressKanji2").equals(contractInfo.getAddressKanji2()))) {
				contractInfo.setAddressKanji2(request.getParameter("addressKanji2"));
				request.setAttribute("message", "保険料試算後から住所漢字２が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("birthday").equals(contractInfo.getBirthday()))) {
				contractInfo.setBirthday(request.getParameter("birthday"));
				request.setAttribute("message", "保険料試算後から生年月日が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("gender").equals(contractInfo.getGender()))) {
				contractInfo.setGender(request.getParameter("gender"));
				request.setAttribute("message", "保険料試算後から性別が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("telephoneNo").equals(contractInfo.getTelephoneNo()))) {
				contractInfo.setTelephoneNo(request.getParameter("telephoneNo"));
				request.setAttribute("message", "保険料試算後から電話番号が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("mobilephoneNo").equals(contractInfo.getMobilephoneNo()))) {
				contractInfo.setMobilephoneNo(request.getParameter("mobilephoneNo"));
				request.setAttribute("message", "保険料試算後から携帯電話番号が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("faxNo").equals(contractInfo.getFaxNo()))) {
				contractInfo.setFaxNo(request.getParameter("faxNo"));
				request.setAttribute("message", "保険料試算後からFAX番号が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("maker").equals(compensation.getMaker()))) {
				compensation.setMaker(request.getParameter("maker"));
				request.setAttribute("message", "保険料試算後からメーカーが変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "2");
				rd.forward(request, response);
			}else if(!(request.getParameter("carName").equals(compensation.getCarName()))) {
				compensation.setCarName(request.getParameter("carName"));
				request.setAttribute("message", "保険料試算後から車名が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "2");
				rd.forward(request, response);
			}else if(!(request.getParameter("licenseNo").equals(compensation.getLicenseNo()))) {
				compensation.setLicenseNo(request.getParameter("licenseNo"));
				request.setAttribute("message", "保険料試算後から車のナンバーが変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "2");
				rd.forward(request, response);
			}else if(!(Integer.parseInt(request.getParameter("vehiclePrice")) == (compensation.getVehiclePrice()))) {
				compensation.setVehiclePrice(Integer.parseInt(request.getParameter("vehiclePrice")));
				request.setAttribute("message", "保険料試算後から車両保険金額が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "2");
				rd.forward(request, response);
			}else if(!(request.getParameter("vehicleRates").equals(compensation.getVehicleRates()))) {
				compensation.setVehicleRates(request.getParameter("vehicleRates"));
				request.setAttribute("message", "保険料試算後から車両料率が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "2");
				rd.forward(request, response);
			}else if(!(request.getParameter("bodilyRates").equals(compensation.getBodilyRates()))) {
				compensation.setBodilyRates(request.getParameter("bodilyRates"));
				request.setAttribute("message", "保険料試算後から対人料率が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "2");
				rd.forward(request, response);
			}else if(!(request.getParameter("propertyDamageRates").equals(compensation.getPropertyDamageRates()))) {
				compensation.setPropertyDamageRates(request.getParameter("popertyDamageRates"));
				request.setAttribute("message", "保険料試算後から対物料率が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "2");
				rd.forward(request, response);
			}else if(!(request.getParameter("accidentRates").equals(compensation.getAccidentRates()))) {
				compensation.setAccidentRates(request.getParameter("accidentRates"));
				request.setAttribute("message", "保険料試算後から傷害料率が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "2");
				rd.forward(request, response);
			}else if(!(request.getParameter("licenseColor").equals(compensation.getLicenseColor()))) {
				compensation.setLicenseColor(request.getParameter("licenseColor"));
				request.setAttribute("message", "保険料試算後から免許書の色が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "2");
				rd.forward(request, response);
			}else if(!(request.getParameter("ageLimit").equals(compensation.getAgeLimit()))) {
				compensation.setAgeLimit(request.getParameter("ageLimit"));
				request.setAttribute("message", "保険料試算後から年齢条件が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "2");
				rd.forward(request, response);
			}else {
				request.setAttribute("message", "全ての項目が入力されています。申込書印刷ボタンを押してください。");
				request.setAttribute("tabpage", "2");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/PrintConfirmationForm.jsp");
				rd.forward(request, response);
			}
//
//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/PrintConfirmationForm.jsp");
//			rd.forward(request, response);

			return;


		}

		if(insuredKbn.equals("2")) {
			if(!(request.getParameter("inceptionDate1").equals(contractInfo.getInceptionDate()))) {
				contractInfo.setInceptionDate(request.getParameter("inceptionDate1"));
				request.setAttribute("message", "保険料試算後から保険期間始期日が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("inceptionTime1").equals(contractInfo.getInceptionTime()))) {
				contractInfo.setInceptionTime(request.getParameter("inceptionTime1"));
				request.setAttribute("message", "保険料試算後から保険期間始期時刻が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("conclusionDate1").equals(contractInfo.getConclusionDate()))) {
				contractInfo.setConclusionDate(request.getParameter("conclusionDate1"));
				request.setAttribute("message", "保険料試算後から保険期間満期日が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("conclusionTime1").equals(contractInfo.getConclusionTime()))) {
				contractInfo.setConclusionTime(request.getParameter("conclusionTime1"));
				request.setAttribute("message", "保険料試算後から保険期間満期時刻が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("paymentMethod1").equals(contractInfo.getPaymentMethod()))) {
				contractInfo.setPaymentMethod(request.getParameter("paymentMethod1"));
				request.setAttribute("message", "保険料試算後から払込方法が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(Integer.parseInt(request.getParameter("installment1")) == (contractInfo.getInstallment()))) {
				contractInfo.setInstallment(Integer.parseInt(request.getParameter("installment1")));
				request.setAttribute("message", "保険料試算後から払込回数が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("nameKana11").equals(contractInfo.getNameKana1()))) {
				contractInfo.setNameKana1(request.getParameter("nameKana11"));
				request.setAttribute("message", "保険料試算後から会社名カナ１が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("nameKana21").equals(contractInfo.getNameKana2()))) {
				contractInfo.setNameKana2(request.getParameter("nameKana21"));
				request.setAttribute("message", "保険料試算後から会社名カナ２が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("nameKanji11").equals(contractInfo.getNameKanji1()))) {
				contractInfo.setNameKanji1(request.getParameter("nameKanji11"));
				request.setAttribute("message", "保険料試算後から会社名漢字１が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("nameKanji21").equals(contractInfo.getNameKanji2()))) {
				contractInfo.setNameKanji2(request.getParameter("nameKanji21"));
				request.setAttribute("message", "保険料試算後から会社名漢字２が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("postcode1").equals(contractInfo.getPostcode()))) {
				contractInfo.setPostcode(request.getParameter("postcode1"));
				request.setAttribute("message", "保険料試算後から郵便番号が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("addressKana11").equals(contractInfo.getAddressKana1()))) {
				contractInfo.setAddressKana1(request.getParameter("addressKana11"));
				request.setAttribute("message", "保険料試算後から住所カナ１が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("addressKana21").equals(contractInfo.getAddressKana2()))) {
				contractInfo.setAddressKana2(request.getParameter("addressKana21"));
				request.setAttribute("message", "保険料試算後から住所カナ２が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("addressKanji11").equals(contractInfo.getAddressKanji1()))) {
				contractInfo.setAddressKanji1(request.getParameter("addressKanji11"));
				request.setAttribute("message", "保険料試算後から住所漢字１が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("addressKanji21").equals(contractInfo.getAddressKanji2()))) {
				contractInfo.setAddressKanji2(request.getParameter("addressKanji21"));
				request.setAttribute("message", "保険料試算後から住所漢字２が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("telephoneNo1").equals(contractInfo.getTelephoneNo()))) {
				contractInfo.setTelephoneNo(request.getParameter("telephoneNo1"));
				request.setAttribute("message", "保険料試算後から電話番号が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("mobilephoneNo1").equals(contractInfo.getMobilephoneNo()))) {
				contractInfo.setMobilephoneNo(request.getParameter("mobilephoneNo1"));
				request.setAttribute("message", "保険料試算後から携帯電話番号が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("faxNo1").equals(contractInfo.getFaxNo()))) {
				contractInfo.setFaxNo(request.getParameter("faxNo1"));
				request.setAttribute("message", "保険料試算後からFAX番号が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "1");
				rd.forward(request, response);
			}else if(!(request.getParameter("maker").equals(compensation.getMaker()))) {
				compensation.setMaker(request.getParameter("maker"));
				request.setAttribute("message", "保険料試算後からメーカーが変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "2");
				rd.forward(request, response);
			}else if(!(request.getParameter("carName").equals(compensation.getCarName()))) {
				compensation.setCarName(request.getParameter("carName"));
				request.setAttribute("message", "保険料試算後から車名が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "2");
				rd.forward(request, response);
			}else if(!(request.getParameter("licenseNo").equals(compensation.getLicenseNo()))) {
				compensation.setLicenseNo(request.getParameter("licenseNo"));
				request.setAttribute("message", "保険料試算後から車のナンバーが変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "2");
				rd.forward(request, response);
			}else if(!(Integer.parseInt(request.getParameter("vehiclePrice")) == (compensation.getVehiclePrice()))) {
				compensation.setVehiclePrice(Integer.parseInt(request.getParameter("vehiclePrice")));
				request.setAttribute("message", "保険料試算後から車両保険金額が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "2");
				rd.forward(request, response);
			}else if(!(request.getParameter("vehicleRates").equals(compensation.getVehicleRates()))) {
				compensation.setVehicleRates(request.getParameter("vehicleRates"));
				request.setAttribute("message", "保険料試算後から車両料率が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "2");
				rd.forward(request, response);
			}else if(!(request.getParameter("bodilyRates").equals(compensation.getBodilyRates()))) {
				compensation.setBodilyRates(request.getParameter("bodilyRates"));
				request.setAttribute("message", "保険料試算後から対人料率が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "2");
				rd.forward(request, response);
			}else if(!(request.getParameter("propertyDamageRates").equals(compensation.getPropertyDamageRates()))) {
				compensation.setPropertyDamageRates(request.getParameter("popertyDamageRates"));
				request.setAttribute("message", "保険料試算後から対物料率が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "2");
				rd.forward(request, response);
			}else if(!(request.getParameter("accidentRates").equals(compensation.getAccidentRates()))) {
				compensation.setAccidentRates(request.getParameter("accidentRates"));
				request.setAttribute("message", "保険料試算後から傷害料率が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "2");
				rd.forward(request, response);
			}else if(!(request.getParameter("licenseColor").equals(compensation.getLicenseColor()))) {
				compensation.setLicenseColor(request.getParameter("licenseColor"));
				request.setAttribute("message", "保険料試算後から免許書の色が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "2");
				rd.forward(request, response);
			}else if(!(request.getParameter("ageLimit").equals(compensation.getAgeLimit()))) {
				compensation.setAgeLimit(request.getParameter("ageLimit"));
				request.setAttribute("message", "保険料試算後から年齢条件が変更されています。新しく保険料試算を行ってください。");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
				request.setAttribute("tabpage", "2");
				rd.forward(request, response);
			}else {
				request.setAttribute("message", "全ての項目が入力されています。申込書印刷ボタンを押してください。");
				request.setAttribute("tabpage", "2");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/PrintConfirmationForm.jsp");
				rd.forward(request, response);
			}
//
//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/PrintConfirmationForm.jsp");
//			rd.forward(request, response);

				return;
			}
		}


//		System.out.println("ここまで来てる。");
//		//データチェッククラスの生成
//		ContractFormChecker cfc = new ContractFormChecker();
//		CompensationFormChecker comfc = new CompensationFormChecker();
//
//		//契約情報、補償情報オブジェクトをデータチェッククラスに渡してチェックを実施
//		if(insuredKbn.equals("1")) {
//			if(cfc.checkKozin(contractInfo).contains(1)) {
//				request.setAttribute("checkKozin", cfc.checkKozin(contractInfo));
//				request.setAttribute("tabpage", "1");
//				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
//				rd.forward(request, response);
//				System.out.println("ここまで来てる1。");
//			}else if(comfc.check2(compensation).contains(1)) {
//				request.setAttribute("errorMessage", comfc.check2(compensation));
//				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
//				rd.forward(request, response);
//				System.out.println("ここまで来てる3。");
//			}else {
//				//申込書印刷確認画面に遷移する
//				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/PrintConfirmationForm.jsp");
//				rd.forward(request, response);
//				System.out.println("ここまで来てる4。");
//			}
//		}
//
//		if(insuredKbn.equals("2")) {
//			if(cfc.checkHouzin(contractInfo).contains(1)) {
//				request.setAttribute("checkHouzin", cfc.checkHouzin(contractInfo));
//				request.setAttribute("tabpage", "1");
//				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
//				rd.forward(request, response);
//				System.out.println("ここまで来てる2。");
//			}else if(comfc.check2(compensation).contains(1)) {
//				request.setAttribute("errorMessage", comfc.check2(compensation));
//				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
//				rd.forward(request, response);
//				System.out.println("ここまで来てる3。");
//			}else {
//				//申込書印刷確認画面に遷移する
//				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/PrintConfirmationForm.jsp");
//				rd.forward(request, response);
//				System.out.println("ここまで来てる4。");
//			}
//		}



	public Integer check(String str) {
		if(str == null) {
			return null;
		}else if(str.equals("")) {
			return null;
		}else {
			return Integer.parseInt(str);
		}
	}

}
