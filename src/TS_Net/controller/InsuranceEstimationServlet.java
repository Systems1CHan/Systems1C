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

		String insuredKbn = request.getParameter("insuredKbn");
		request.setAttribute("radioButtonValue", insuredKbn);

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



		if (insuredKbn.equals("1")) {
			System.out.println("個人");
			String inceptionDate = request.getParameter("inceptionDate");
			String inceptionTime = request.getParameter("inceptionTime");
			String conclusionDate = request.getParameter("conclusionDate");
			String conclusionTime = request.getParameter("conclusionTime");
			String paymentMethod = request.getParameter("paymentMethod");
			String installment = request.getParameter("installment");
			String insuredKbn2 = request.getParameter("insuredKbn");
			String nameKana1 = request.getParameter("nameKana1");
			String nameKana2 = request.getParameter("nameKana2");
			String nameKanji1 = request.getParameter("nameKanji1");
			String nameKanji2= request.getParameter("nameKanji2");
			String postcode = request.getParameter("postcode");
			String addressKana1 = request.getParameter("addressKana1");
			String addressKana2 = request.getParameter("addressKana2");
			String addressKanji1 = request.getParameter("addressKanji1");
			String addressKanji2 = request.getParameter("addressKanji2");
			String birthday = request.getParameter("birthday").replace("-", "");
			String gender = request.getParameter("gender");
			String telephoneNo= request.getParameter("telephoneNo");
			String mobilephoneNo = request.getParameter("mobilephoneNo");
			String faxNo = request.getParameter("faxNo");

			contractInfo.setInceptionDate(inceptionDate.replace("-", ""));
			contractInfo.setInceptionTime(inceptionTime);
			contractInfo.setConclusionDate(conclusionDate.replace("-", ""));
			contractInfo.setConclusionTime(conclusionTime);
			contractInfo.setPaymentMethod(paymentMethod);
			contractInfo.setInstallment(check(installment));
			contractInfo.setInsuredKbn(insuredKbn2);
			contractInfo.setNameKana1(nameKana1);
			contractInfo.setNameKana2(nameKana2);
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

		}else if(insuredKbn.equals("2")) {
			System.out.println("法人");

			String inceptionDate = request.getParameter("inceptionDate1");
			String inceptionTime = request.getParameter("inceptionTime1");
			String conclusionDate = request.getParameter("conclusionDate1");
			String conclusionTime = request.getParameter("conclusionTime1");
			String paymentMethod = request.getParameter("paymentMethod1");
			String installment = request.getParameter("installment1");
			String insuredKbn2 = request.getParameter("insuredKbn");
			String nameKana1 = request.getParameter("nameKana11");
			String nameKana2 = request.getParameter("nameKana21");
			String nameKanji1 = request.getParameter("nameKanji11");
			String nameKanji2= request.getParameter("nameKanji21");
			String postcode = request.getParameter("postcode1");
			String addressKana1 = request.getParameter("addressKana11");
			String addressKana2 = request.getParameter("addressKana21");
			String addressKanji1 = request.getParameter("addressKanji11");
			String addressKanji2 = request.getParameter("addressKanji21");
			String telephoneNo= request.getParameter("telephoneNo1");
			String mobilephoneNo = request.getParameter("mobilephoneNo1");
			String faxNo = request.getParameter("faxNo1");

			contractInfo.setInceptionDate(inceptionDate.replace("-", ""));
			contractInfo.setInceptionTime(inceptionTime);
			contractInfo.setConclusionDate(conclusionDate.replace("-", ""));
			contractInfo.setConclusionTime(conclusionTime);
			contractInfo.setPaymentMethod(paymentMethod);
			contractInfo.setInstallment(check(installment));
			contractInfo.setInsuredKbn(insuredKbn2);
			contractInfo.setNameKana1(nameKana1);
			contractInfo.setNameKana2(nameKana2);
			contractInfo.setNameKanji1(nameKanji1);
			contractInfo.setNameKanji2(nameKanji2);
			contractInfo.setPostcode(postcode);
			contractInfo.setAddressKana1(addressKana1);
			contractInfo.setAddressKana2(addressKana2);
			contractInfo.setAddressKanji1(addressKanji1);
			contractInfo.setAddressKanji2(addressKanji2);
			contractInfo.setTelephoneNo(telephoneNo);
			contractInfo.setMobilephoneNo(mobilephoneNo);
			contractInfo.setFaxNo(faxNo);

		}

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
		if(insuredKbn.equals("1")) {
			if(cfc.checkKozin(contractInfo).contains(1)) {
				request.setAttribute("checkKozin", cfc.checkKozin(contractInfo));
				request.setAttribute("tabpage", "1");
			}else if(comfc.check2(compensation).contains(1)) {
				request.setAttribute("check2", comfc.check2(compensation));
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
		}else if(insuredKbn.equals("2")) {
			if(cfc.checkHouzin(contractInfo).contains(1)) {
				request.setAttribute("checkHouzin", cfc.checkHouzin(contractInfo));
				request.setAttribute("tabpage", "1");
			}else if(comfc.check2(compensation).contains(1)) {
				request.setAttribute("check2", comfc.check2(compensation));
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
