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

public class AdminEditCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDao categoryDao;

	public AdminEditCatController() {
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
		int id_Cat = 0;
		try {
			id_Cat = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		Category getItem = null;
		getItem = categoryDao.getItem(id_Cat);
		ArrayList<Category> getItems = null;
		getItems = categoryDao.getItem();
		request.setAttribute("getItems", getItems);
		request.setAttribute("getItem", getItem);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/cat/edit.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id_Cat = 0;
		try {
			id_Cat = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		String nameCat = request.getParameter("nameCat");
		int id_Parent = 0;
		try {
			id_Parent = Integer.parseInt(request.getParameter("category"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		Category item = new Category(id_Cat, nameCat, id_Parent);
		if (categoryDao.editItem(item) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/cats?msg=2");
			return;
		} else {
			request.setAttribute("item", item);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/cat/edit.jsp?msg=-2");
			rd.forward(request, response);
		}

	}

}
