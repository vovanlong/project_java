package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bean.News;
import model.Dao.NewsDao;
import util.AuthUtil;
import util.DeFine;

public class AdminIndexNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsDao newsDao;

	public AdminIndexNewsController() {
		super();
		newsDao = new NewsDao();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		if (!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/auth/login");
			return;
		}
		String search = "";
		if (request.getParameter("search") != null) {
			search = request.getParameter("search");
		} else {
			search = "";
		}
		int sumNews = newsDao.countNews();
		int sumPage = (int) Math.ceil((float) sumNews / DeFine.ROW_COUNT_PUBLIC);
		int curent_Page = 1;
		if (request.getParameter("page") != null) {
			curent_Page = Integer.parseInt(request.getParameter("page"));
		}
		int offset = (curent_Page - 1) * DeFine.ROW_COUNT_PUBLIC;
		ArrayList<News> items = null;
		if ("".equals(search)) {
			items = newsDao.getItemsPagination(offset);
		} else {
			items = newsDao.getItemsBySearch(search);
		}

		request.setAttribute("items", items);
		request.setAttribute("sumPage", sumPage);
		request.setAttribute("curent_Page", curent_Page);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/news/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
