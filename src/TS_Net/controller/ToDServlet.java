package TS_Net.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class toAServlet
 */
@WebServlet("/toD")
public class ToDServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO 自動生成されたメソッド・スタブ

		/* 解約ページJSPへforwardする。*/
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/d.jsp");
		rd.forward(request, response);

	}

}
