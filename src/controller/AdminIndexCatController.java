package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bean.Category;
import model.Dao.CategoryDao;
import util.AuthUtil;
import util.DeFine;

public class AdminIndexCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDao categoryDao;

	public AdminIndexCatController() {
		super();
		categoryDao = new CategoryDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if (!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/auth/login");
			return;
		}
		String search = "";
		if (!"".equals(request.getParameter("search"))) {
			search = request.getParameter("search");
		} else {
			search = "";
		}
		int sumCat = categoryDao.countCat();
		int sumPage = (int) Math.ceil((float) sumCat / DeFine.ROW_COUNT_PUBLIC);
		int current_Page = 1;
		if (request.getParameter("page") != null) {
			current_Page = Integer.parseInt(request.getParameter("page"));
		}
		int offset = (current_Page - 1) * DeFine.ROW_COUNT_PUBLIC;
		ArrayList<Category> categories = null;
		if (search == null) {
			categories = categoryDao.getItemPaination(offset);
		} else {
			categories = categoryDao.getItemSearch(search, offset);
		}
		request.setAttribute("categories", categories);
		request.setAttribute("sumPage", sumPage);
		request.setAttribute("current_Page", current_Page);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/cat/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
