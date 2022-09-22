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
import TS_Net.model.datacheck.DateChecker;
import TS_Net.model.datacheck.TextTypeCheker;

/**
 * 保険料試算後画面へコントローラ
 * <p>
 * 要求「保険料試算後画面へ」に対する処理を行う。
 * </p>
 * @author RyoIsogami/SYS 2022/09/14
 */
@WebServlet("/InsuranceEstimation")
public class InsuranceEstimationServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding(SystemConst.CHAR_SET);

		String insuredKbn2 = request.getParameter("insuredKbn");
		request.setAttribute("radioButtonValue", insuredKbn2);

		//セッションの生成
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

		String[] inceptionDate = request.getParameterValues("inceptionDate");
		String[] inceptionTime = request.getParameterValues("inceptionTime");
		String[] conclusionDate = request.getParameterValues("conclusionDate");
		String[] conclusionTime = request.getParameterValues("conclusionTime");
		String[] paymentMethod = request.getParameterValues("paymentMethod");
		String[] installment = request.getParameterValues("installment");
		String insuredKbn = request.getParameter("insuredKbn");
		String[] nameKana1 = request.getParameterValues("nameKana1");
		String[] nameKana2 = request.getParameterValues("nameKana2");
		String[] nameKanji1 = request.getParameterValues("nameKanji1");
		String[] nameKanji2= request.getParameterValues("nameKanji2");
		String[] postcode = request.getParameterValues("postcode");
		String[] addressKana1 = request.getParameterValues("addressKana1");
		String[] addressKana2 = request.getParameterValues("addressKana2");
		String[] addressKanji1 = request.getParameterValues("addressKanji1");
		String[] addressKanji2 = request.getParameterValues("addressKanji2");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String[] telephoneNo= request.getParameterValues("telephoneNo");
		String[] mobilephoneNo = request.getParameterValues("mobilephoneNo");
		String[] faxNo = request.getParameterValues("faxNo");

		for (String str: inceptionDate){
			  System.out.println(str);
		}

		int index = 0;
		if (insuredKbn2.equals("1")) {
			System.out.println("個人");
		}else if(insuredKbn2.equals("2")) {
			System.out.println("法人");
			index = 1;
			if (birthday.equals(null)  || birthday.isEmpty())
				birthday ="20000101";
		}

		//リクエストパラメータを取得し、契約情報オブジェクトにセット
		contractInfo.setInceptionDate(inceptionDate[index]);
		contractInfo.setInceptionTime(inceptionTime[index]);
		contractInfo.setConclusionDate(conclusionDate[index]);
		contractInfo.setConclusionTime(conclusionTime[index]);
		contractInfo.setPaymentMethod(paymentMethod[index]);
		contractInfo.setInstallment(check(installment[index]));
		contractInfo.setInsuredKbn(insuredKbn);
		contractInfo.setNameKana1(nameKana1[index]);
		contractInfo.setNameKana2(nameKana2[index]);
		contractInfo.setNameKanji1(nameKanji1[index]);
		contractInfo.setNameKanji2(nameKanji2[index]);
		contractInfo.setPostcode(postcode[index]);
		contractInfo.setAddressKana1(addressKana1[index]);
		contractInfo.setAddressKana2(addressKana2[index]);
		contractInfo.setAddressKanji1(addressKanji1[index]);
		contractInfo.setAddressKanji2(addressKanji2[index]);
		contractInfo.setBirthday(birthday);
		if (gender==null)
			contractInfo.setGender("0");// 未選択
		else
			contractInfo.setGender(gender);
		contractInfo.setTelephoneNo(telephoneNo[index]);
		contractInfo.setMobilephoneNo(mobilephoneNo[index]);
		contractInfo.setFaxNo(faxNo[index]);

		//リクエストパラメータを取得し、補償情報オブジェクトにセット
		String maker = request.getParameter("maker");
		String carName = request.getParameter("carName");
		String licenseNo = request.getParameter("licenseNo");
		String vehiclePrice = request.getParameter("vehiclePrice");
		String vehicleRates = request.getParameter("vehicleRates");
		String bodilyRates = request.getParameter("bodilyRates");
		String propertyDamageRates =request.getParameter("propertyDamageRates");
		String accidentRates = request.getParameter("accidentRates");
		String licenseColor = request.getParameter("licenseColor");
		String ageLimit = request.getParameter("ageLimit");

		compensation.setMaker(maker);
		compensation.setCarName(carName);
		compensation.setLicenseNo(licenseNo);
		compensation.setVehiclePrice(check(vehiclePrice));
		compensation.setVehicleRates(vehicleRates);
		compensation.setBodilyRates(bodilyRates);
		compensation.setPropertyDamageRates(propertyDamageRates);
		compensation.setAccidentRates(accidentRates);
		compensation.setLicenseColor(licenseColor);
		compensation.setAgeLimit(ageLimit);

		//総額保険料、一回分保険料の算出メソッドの呼び出し
		Integer premiumAmount = compensation.getPremiumAmountForLabel();
		Integer premiumInstallment = 0;

		if(contractInfo.getInstallment() != 0) {
			premiumInstallment = premiumAmount/contractInfo.getInstallment();
		}

		System.out.println(premiumAmount);
		System.out.println(premiumInstallment);

		//算出した総額保険料と一回分保険料を補償情報オブジェクトにセット
		compensation.setPremiumAmount(premiumAmount);
		compensation.setPremiumInstallment(premiumInstallment);

		//セッション領域にオブジェクトの情報を格納する
		session.setAttribute("contractInfo", contractInfo);
		session.setAttribute("compensation", compensation);


		//データチェッククラスの生成
		ContractFormChecker cfc = new ContractFormChecker();
		CompensationFormChecker comfc = new CompensationFormChecker();
		DateChecker dc = new DateChecker();
		TextTypeCheker ttc = new TextTypeCheker();

		//契約情報、補償情報オブジェクトをデータチェッククラスに渡してチェックを実施
		if(cfc.check(contractInfo).contains(1)) {
			request.setAttribute("check", cfc.check(contractInfo));
			request.setAttribute("tabpage", "1");
		}else if(comfc.check(compensation).contains(1)) {
			request.setAttribute("check", comfc.check(compensation));
			request.setAttribute("tabpage", "2");
		}else if(dc.inceptionDateCheck(contractInfo) != null) {
			request.setAttribute("message", dc.inceptionDateCheck(contractInfo));
			request.setAttribute("tabpage", "1");
		}else if(ttc.textHalfwidthCheck(contractInfo) != null) {
			request.setAttribute("message", ttc.textHalfwidthCheck(contractInfo));
			request.setAttribute("tabpage", "1");
		}else if(ttc.textFullwidthCheck(contractInfo) != null) {
			request.setAttribute("message", ttc.textFullwidthCheck(contractInfo));
			request.setAttribute("tabpage", "1");
		}else {
			request.setAttribute("message", "全ての項目が入力されています。申込書印刷ボタンを押してください。");
			request.setAttribute("tabpage", "2");
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
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
