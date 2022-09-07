package TS_Net.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToQueryConfirmServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO 自動生成されたメソッド・スタブ

		/* TOPメニューJSPへforwardする。*/
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/QueryConfirm.jsp");
		rd.forward(request, response);

	}

}


