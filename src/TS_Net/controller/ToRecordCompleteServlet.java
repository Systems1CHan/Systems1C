/*-----------------------------------------------------
 * 演習番号：総合演習
 * クラス名:[ToRecordCompleteServlet]
 * 作成日：[2022/09/07]
 * 作成者：[Akane Nambu/SYS]
 * ----------------------------------------------------
 * 修正履歴（発注No.：修正日：担当者：）
 *------------------------------------------------------------------------------
 *
 */
package TS_Net.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToRecordCompleteServlet
 */
@WebServlet("/ToRecordCompleteServlet")
public class ToRecordCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/*
	 * 「代理店計上」ボタン押下時に以下の処理を行う。
	１．契約情報クラスのオブジェクトをセッション領域から取得する。
	２．セッション領域からの取得に失敗した場合、エラーメッセージをrequest領域へ設定した上で、エラーページへ遷移。
	３．契約情報DAOを用いて、状態フラグと解約フラグをチェックする。
	４．契約情報オブジェクトの解約フラグと状態フラグを更新する。（状態フラグが９の場合は解約フラグを１に、状態フラグを計上済み状態の０にする。）（申込書DBの契約種類区分の数字を０に書き換える。）
	５．DAOの処理を用いて必要な情報をセットする。（取り出したセッションスコープの値をリクエスト領域に設定する。）
	６．計上完了画面JSPへforwardする。

	 */

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToRecordCompleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
