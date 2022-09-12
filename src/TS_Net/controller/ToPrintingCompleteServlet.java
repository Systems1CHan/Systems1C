package TS_Net.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TS_Net.model.constant.SystemConst;

/**
 * Servlet implementation class ToPrintingCompleteServlet
 */
@WebServlet("/ToPrintingCompleteServlet")
public class ToPrintingCompleteServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(SystemConst.CHAR_SET);
	}

}
