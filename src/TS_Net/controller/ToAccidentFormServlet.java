///*------------------------------------------------------------------------------
// * 演習番号：[総合演習]
// * クラス名：[ToAccidentFormServlet]入力画面
// * 作成日  ：[2022/09/07]
// * 作成者  ：[KeinaNoguchi/SYS]
// *------------------------------------------------------------------------------
// * 修正履歴 (発注No. ： 修正日 ： 担当者 ： 修正内容)
// *------------------------------------------------------------------------------
// */
//package TS_Net.controller;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import TS_Net.model.constant.ErrorMsgConst;
//import TS_Net.model.constant.SystemConst;
//import TS_Net.model.data.AccidentReception;
//import TS_Net.model.data.Compensation;
//import TS_Net.model.data.ContractInfo;
//
//	/**
//	 * 事故受付入力画面へコントローラ
//	 * <p>
//	 * 要求「事故受付入力画面へ」に対する処理を行う。
//	 * </p>
//	 * @author KeinaNoguchi/SYS 2022/09/12
//	 */
//	@WebServlet("/ToAccidentForm")
//	public class ToAccidentFormServlet extends HttpServlet {
//
//		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//			request.setCharacterEncoding(SystemConst.CHAR_SET);
//
//			HttpSession session = request.getSession(false);
//			ContractInfo contractInfo = null;
//			Compensation compensation = null;
//			AccidentReception accidentReception = null;
//
//			if(session == null) {
//				request.setAttribute("message", ErrorMsgConst.SESSION_ERROR);
//				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
//				rd.forward(request, response);
//			}else {
//				contractInfo = (ContractInfo) session.getAttribute("contractInfo");
//				compensation = (Compensation) session.getAttribute("compensation");
//				accidentReception = (AccidentReception) session.getAttribute("accidentReception");
//
//				if(contractInfo == null || compensation == null || accidentReception == null) {
//					request.setAttribute("message", ErrorMsgConst.SESSION_ERROR);
//					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ErrorPage.jsp");
//					rd.forward(request, response);
//				    }
//			}
//
//			//リクエストパラメータを取得する（事故受付情報）
//			String claimNo = request.getParameter("claimNo");
//			String claimStatus = request.getParameter("claimStatus");
//			String accidentLocationKana1 = request.getParameter("accidentLocationKana1");
//			String accidentLocationKana2 = request.getParameter("accidentLocationKana2");
//			String accidentLocationKanji1 = request.getParameter("accidentLocationKanji1");
//			String accidentLocationKanji2 = request.getParameter("accidentLocationKanji2");
//			String accidentDate = request.getParameter("accidentDate");
//			Integer ratingBlameMyself = Integer.parseInt(request.getParameter("ratingBlameMyself"));
//			Integer ratingBlameYourself = Integer.parseInt(request.getParameter("ratingBlameYourself"));
//			Integer damageCarPrice = Integer.parseInt(request.getParameter("damageCarPrice"));
//			Integer damageBodilyPrice = Integer.parseInt(request.getParameter("damageBodilyPrice"));
//			Integer damagePropertyPrice = Integer.parseInt(request.getParameter("damagePropertyPrice"));
//			Integer damageAccidentPrice = Integer.parseInt(request.getParameter("damageAccidentPrice"));
//			String damageCarState = request.getParameter("damageCarState");
//			String damageBodilyState = request.getParameter("damageBodilyState");
//			String damagePropertyState = request.getParameter("damagePropertyState");
//			String damageAccidentState = request.getParameter("damageAccidentState");
//			Integer paymentPrice = Integer.parseInt(request.getParameter("paymentPrice"));
//
//			//契約情報オブジェクトにセット
//			accidentReception.setClaimNo(claimNo);
//			accidentReception.setClaimStatus(claimStatus);
//			accidentReception.setAccidentLocationKana1(accidentLocationKana1);
//			accidentReception.setAccidentLocationKana2(accidentLocationKana2);
//			accidentReception.setAccidentLocationKanji1(accidentLocationKanji1);
//			accidentReception.setAccidentLocationKanji2(accidentLocationKanji2);
//			accidentReception.setAccidentDate(accidentDate);
//			accidentReception.setRatingBlameMyself(ratingBlameMyself);
//			accidentReception.setRatingBlameYourself(ratingBlameYourself);
//			accidentReception.setDamageCarPrice(damageCarPrice);
//			accidentReception.setDamageBodilyPrice(damageBodilyPrice);
//			accidentReception.setDamagePropertyPrice(damagePropertyPrice);
//			accidentReception.setDamageAccidentPrice(damageAccidentPrice);
//			accidentReception.setDamageCarState(damageCarState);
//			accidentReception.setDamageBodilyState(damageBodilyState);
//			accidentReception.setDamagePropertyState(damagePropertyState);
//			accidentReception.setDamageAccidentState(damageAccidentState);
//			accidentReception.setPaymentPrice(paymentPrice);
//
//
//			//リクエストパラメータを取得する（契約情報）
//			String insatsuRenban = request.getParameter("insatsuRenban");
//			String inceptionDate = request.getParameter("inceptionDate");
//			String inceptionTime = request.getParameter("inceptionTime");
//			String conclusionDate = request.getParameter("conclusionDate");
//			String conclusionTime = request.getParameter("conclusionTime");
//			String paymentMethod = request.getParameter("paymentMethod");
//			Integer installment = Integer.parseInt(request.getParameter("insatallment"));
//			String insuredKbn = request.getParameter("insuredKbn");
//			String nameKana1 = request.getParameter("nameKana1");
//			String nameKana2 = request.getParameter("nameKana2");
//			String nameKanji1 = request.getParameter("nameKanji1");
//			String nameKanji2 = request.getParameter("nameKanji2");
//			String postcode = request.getParameter("postcode");
//			String addressKana1 = request.getParameter("addressKana1");
//			String addressKana2 = request.getParameter("addressKana2");
//			String addressKanji1 = request.getParameter("addressKanji1");
//			String addressKanji2 = request.getParameter("addressKanji2");
//			String birthday = request.getParameter("birthday");
//			String gender = request.getParameter("gender");
//			String telephoneNo = request.getParameter("telephoneNo");
//			String mobilephoneNo = request.getParameter("mobilephoneNo");
//			String faxNo = request.getParameter("faxNo");
//
//			//契約情報オブジェクトにセット
//			contractInfo.setInsatsuRenban(insatsuRenban);
//			contractInfo.setInceptionDate(inceptionDate);
//			contractInfo.setInceptionTime(inceptionTime);
//			contractInfo.setConclusionDate(conclusionDate);
//			contractInfo.setConclusionTime(conclusionTime);
//			contractInfo.setPaymentMethod(paymentMethod);
//			contractInfo.setInstallment(installment);
//			contractInfo.setInsuredKbn(insuredKbn);
//			contractInfo.setNameKana1(nameKana1);
//			contractInfo.setNamekana2(nameKana2);
//			contractInfo.setNameKanji1(nameKanji1);
//			contractInfo.setNameKanji2(nameKanji2);
//			contractInfo.setPostcode(postcode);
//			contractInfo.setAddressKana1(addressKana1);
//			contractInfo.setAddressKana2(addressKana2);
//			contractInfo.setAddressKanji1(addressKanji1);
//			contractInfo.setAddressKanji2(addressKanji2);
//			contractInfo.setBirthday(birthday);
//			contractInfo.setGender(gender);
//			contractInfo.setTelephoneNo(telephoneNo);
//			contractInfo.setMobilephoneNo(mobilephoneNo);
//			contractInfo.setFaxNo(faxNo);
//
//			//リクエストパラメータを取得（補償情報）
//			String maker = request.getParameter("maker");
//			String carName = request.getParameter("carName");
//			String licenseNo = request.getParameter("licenseNo");
//			Integer vehiclePrice = Integer.parseInt (request.getParameter("vehiclePrice"));
//			String vehicleRates = request.getParameter("vehicleRates");
//			String bodilyRates = request.getParameter("bodilyRates");
//			String propertyDamageRates = request.getParameter("propertyDamageRates");
//			String accidentRates = request.getParameter("accidentRates");
//			String licenseColor = request.getParameter("licenseColor");
//			String ageLimit = request.getParameter("ageLimit");
//			Integer premiumAmount = Integer.parseInt(request.getParameter("premiumAmount"));
//			Integer premiumInstallment = Integer.parseInt(request.getParameter("premiumInstallment"));
//
//			//補償情報オブジェクトにセット
//			compensation.setMaker(maker);
//			compensation.setCarName(carName);
//			compensation.setLicenseNo(licenseNo);
//			compensation.setVehiclePrice(vehiclePrice);
//			compensation.setVehicleRates(vehicleRates);
//			compensation.setBodilyRates(bodilyRates);
//			compensation.setPropertyDamageRates(propertyDamageRates);
//			compensation.setAccidentRates(accidentRates);
//			compensation.setLicenseColor(licenseColor);
//			compensation.setAgeLimit(ageLimit);
//			compensation.setPremiumAmount(premiumAmount);
//			compensation.setPremiumInstallment(premiumInstallment);
//
//			session.setAttribute("contractInfo", contractInfo);
//			session.setAttribute("compensation", compensation);
//			session.setAttribute("accidentReception", accidentReception);
//
//			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/ReceptionInput.jsp");
//			rd.forward(request, response);
//
//		}
//	}