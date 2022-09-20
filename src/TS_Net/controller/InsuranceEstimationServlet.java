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

		//リクエストパラメータを取得し、契約情報オブジェクトにセット
		String inceptionDate = request.getParameter("inceptionDate").replace("-", "");
		String conclusionDate = request.getParameter("conclusionDate").replace("-", "");
		String birthday = request.getParameter("birthday").replace("-", "");
		contractInfo.setInceptionDate(inceptionDate);
		contractInfo.setConclusionDate(conclusionDate);
		contractInfo.setBirthday(birthday);
		//contractInfo.setInceptionDate(request.getParameter("inceptionDate"));
		contractInfo.setInceptionTime(request.getParameter("inceptionTime"));
		//contractInfo.setConclusionDate(request.getParameter("conclusionDate"));
		contractInfo.setConclusionTime(request.getParameter("conclusionTime"));
		contractInfo.setPaymentMethod(request.getParameter("paymentMethod"));
		contractInfo.setInstallment(check(request.getParameter("installment")));
		contractInfo.setInsuredKbn(request.getParameter("insuredKbn"));
		contractInfo.setNameKana1(request.getParameter("nameKana1"));
		contractInfo.setNameKana2(request.getParameter("nameKana2"));
		contractInfo.setNameKanji1(request.getParameter("nameKanji1"));
		contractInfo.setNameKanji2(request.getParameter("nameKanji2"));
		contractInfo.setPostcode(request.getParameter("postcode"));
		contractInfo.setAddressKana1(request.getParameter("addressKana1"));
		contractInfo.setAddressKana2(request.getParameter("addressKana2"));
		contractInfo.setAddressKanji1(request.getParameter("addressKanji1"));
		contractInfo.setAddressKanji2(request.getParameter("addressKanji2"));
		//contractInfo.setBirthday(request.getParameter("birthday"));
		contractInfo.setGender(request.getParameter("gender"));
		contractInfo.setTelephoneNo(request.getParameter("telephoneNo"));
		contractInfo.setMobilephoneNo(request.getParameter("mobilephoneNo"));
		contractInfo.setFaxNo(request.getParameter("faxNo"));

		//リクエストパラメータを取得し、補償情報オブジェクトにセット
		compensation.setMaker(request.getParameter("maker"));
		compensation.setCarName(request.getParameter("carName"));
		compensation.setLicenseNo(request.getParameter("licenseNo"));
		compensation.setVehiclePrice(check(request.getParameter("vehiclePrice")));
		compensation.setVehicleRates(request.getParameter("vehicleRates"));
		compensation.setBodilyRates(request.getParameter("bodilyRates"));
		compensation.setPropertyDamageRates(request.getParameter("propertyDamageRates"));
		compensation.setAccidentRates(request.getParameter("accidentRates"));
		compensation.setLicenseColor(request.getParameter("licenseColor"));
		compensation.setAgeLimit(request.getParameter("ageLimit"));
		compensation.setPremiumAmount(check(request.getParameter("premiumAmount")));
		compensation.setPremiumInstallment(check(request.getParameter("premiumInstallment")));

		//総額保険料、一回分保険料の算出メソッドの呼び出し
		Integer premiumAmount = compensation.getPremiumAmountForLabel();
		Integer premiumInstallment = premiumAmount/contractInfo.getInstallment();

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

		//契約情報、補償情報オブジェクトをデータチェッククラスに渡してチェックを実施
		if(cfc.check(contractInfo).contains(1)) {
			request.setAttribute("message", cfc.check(contractInfo));
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
			rd.forward(request, response);
		}else if(comfc.check(compensation).contains(1)) {
			request.setAttribute("message", comfc.check(compensation));
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
			rd.forward(request, response);
		}else if(dc.inceptionDateCheck(inceptionDate) != null) {
			request.setAttribute("message", dc.inceptionDateCheck(inceptionDate));
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
			rd.forward(request, response);
		}else if(dc.conclusionDateCheck(conclusionDate) != null) {
			request.setAttribute("message", dc.conclusionDateCheck(conclusionDate));
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
			rd.forward(request, response);
		}else if(dc.birthdayCheck(birthday) != null) {
			request.setAttribute("message", dc.birthdayCheck(birthday));
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/NewEstimationEntry.jsp");
			rd.forward(request, response);
		}else {
			//申込書印刷確認画面に遷移する
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/AfterInsuranceEstimation.jsp");
			rd.forward(request, response);
		}
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
