package TS_Net.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ToTerminationApplication")
public class ToTerminationApplicationServlet extends  HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO 自動生成されたメソッド・スタブ

		/* TOPメニューJSPへforwardする。*/
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/TerminationFinish.jsp");
		rd.forward(request, response);

	}

}