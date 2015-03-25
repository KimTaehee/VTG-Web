package com.videothegathering.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.videogathering.dao.Initialize;
import com.videogathering.dao.VtgDAO;
import com.videothegathering.parser.DaumURLParser;
import com.videothegathering.parser.VimeoURLParser;
import com.videothegathering.vo.PlayitemVO;

/**
 * Servlet implementation class Servlet
 */
public class URLHandlingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public URLHandlingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String par = request.getParameter("user_URL");
		String title = request.getParameter("user_title");
		System.out.println(par); // ��� ����Ʈ�� ���Դ°�?

		String mp4addr = null;

		// ����Ʈ �м�
		if (par.contains("tvpot.daum.net"))
			mp4addr = new DaumURLParser().getDaumMovieURL(par);

		else if (par.contains("vimeo.com"))
			mp4addr = new VimeoURLParser().getVimeoMovieURL(par);

		else if (par.contains("youtube.com/watch"))
			mp4addr = par;
		
		else {
			System.out.println("Error! This is wrong URL.");
			return;
		} // �� �ƴ� ��� ����ó��
		
		System.out.println(mp4addr);
		
		PlayitemVO item = new PlayitemVO(0, par, title, mp4addr, null);
		
		VtgDAO daovtg = new VtgDAO();

		Connection conn = Initialize.getConnection();
		
		daovtg.setConnection(conn);
		
		try {
			daovtg.insertPlayitem(item);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("Playlist.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
	}
}
