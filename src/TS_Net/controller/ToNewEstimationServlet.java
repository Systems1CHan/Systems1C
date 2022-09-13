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


/**
 * 新規試算入力画面へコントローラ
 * <p>
 * 要求「新規試算入力画面へ」に対する処理を行う。
 * </p>
 * @author RyoIsogami/SYS 2022/09/12
 */
@WebServlet("/ToNewEstimation")
public class ToNewEstimationServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding(SystemConst.CHAR_SET);

		HttpSession session = request.getSession(false);
		ContractInfo contractInfo = null;
		Compensation compensation = null;

		if(session == null) {
			request.setAttribute("message", ErrorMsgConst.SESSION_ERROR);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
			rd.forward(request, response);
		}else {
			contractInfo = (ContractInfo) session.getAttribute("contractInfo");
			compensation = (Compensation) session.getAttribute("compensation");
			if(contractInfo == null || compensation == null) {
				request.setAttribute("message", ErrorMsgConst.SESSION_ERROR);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
				rd.forward(request, response);
			    }
		}

		//リクエストパラメータを取得する（契約情報）
		String insatsuRenban = request.getParameter("insatsuRenban");
		String inceptionDate = request.getParameter("inceptionDate");
		String inceptionTime = request.getParameter("inceptionTime");
		String conclusionDate = request.getParameter("conclusionDate");
		String conclusionTime = request.getParameter("conclusionTime");
		String paymentMethod = request.getParameter("paymentMethod");
		Integer installment = Integer.parseInt(request.getParameter("insatallment"));
		String insuredKbn = request.getParameter("insuredKbn");
		String nameKana1 = request.getParameter("nameKana1");
		String nameKana2 = request.getParameter("nameKana2");
		String nameKanji1 = request.getParameter("nameKanji1");
		String nameKanji2 = request.getParameter("nameKanji2");
		String postcode = request.getParameter("postcode");
		String addressKana1 = request.getParameter("addressKana1");
		String addressKana2 = request.getParameter("addressKana2");
		String addressKanji1 = request.getParameter("addressKanji1");
		String addressKanji2 = request.getParameter("addressKanji2");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String telephoneNo = request.getParameter("telephoneNo");
		String mobilephoneNo = request.getParameter("mobilephoneNo");
		String faxNo = request.getParameter("faxNo");

		//契約情報オブジェクトにセット
		contractInfo.setInsatsuRenban(insatsuRenban);
		contractInfo.setInceptionDate(inceptionDate);
		contractInfo.setInceptionTime(inceptionTime);
		contractInfo.setConclusionDate(conclusionDate);
		contractInfo.setConclusionTime(conclusionTime);
		contractInfo.setPaymentMethod(paymentMethod);
		contractInfo.setInstallment(installment);
		contractInfo.setInsuredKbn(insuredKbn);
		contractInfo.setNameKana1(nameKana1);
		contractInfo.setNamekana2(nameKana2);
		contractInfo.setNameKanji1(nameKanji1);
		contractInfo.setNameKanji2(nameKanji2);
		contractInfo.setPostcode(postcode);
		contractInfo.setAddressKana1(addressKana1);
		contractInfo.setAddressKana2(addressKana2);
		contractInfo.setAddressKanji1(addressKanji1);
		contractInfo.setAddressKanji2(addressKanji2);
		contractInfo.setBirthday(birthday);
		contractInfo.setGender(gender);
		contractInfo.setTelephoneNo(telephoneNo);
		contractInfo.setMobilephoneNo(mobilephoneNo);
		contractInfo.setFaxNo(faxNo);

		//リクエストパラメータを取得（補償情報）
		String maker = request.getParameter("maker");
		String carName = request.getParameter("carName");
		String licenseNo = request.getParameter("licenseNo");
		Integer vehiclePrice = Integer.parseInt (request.getParameter("vehiclePrice"));
		String vehicleRates = request.getParameter("vehicleRates");
		String bodilyRates = request.getParameter("bodilyRates");
		String propertyDamageRates = request.getParameter("propertyDamageRates");
		String accidentRates = request.getParameter("accidentRates");
		String licenseColor = request.getParameter("licenseColor");
		String ageLimit = request.getParameter("ageLimit");
		Integer premiumAmount = Integer.parseInt(request.getParameter("premiumAmount"));
		Integer premiumInstallment = Integer.parseInt(request.getParameter("premiumInstallment"));

		//補償情報オブジェクトにセット
		compensation.setMaker(maker);
		compensation.setCarName(carName);
		compensation.setLicenseNo(licenseNo);
		compensation.setVehiclePrice(vehiclePrice);
		compensation.setVehicleRates(vehicleRates);
		compensation.setBodilyRates(bodilyRates);
		compensation.setPropertyDamageRates(propertyDamageRates);
		compensation.setAccidentRates(accidentRates);
		compensation.setLicenseColor(licenseColor);
		compensation.setAgeLimit(ageLimit);
		compensation.setPremiumAmount(premiumAmount);
		compensation.setPremiumInstallment(premiumInstallment);

		session.setAttribute("contractInfo", contractInfo);
		session.setAttribute("compensation", compensation);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
		rd.forward(request, response);

	}
}
