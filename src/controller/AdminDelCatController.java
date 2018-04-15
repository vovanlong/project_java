package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao.CategoryDao;
import util.AuthUtil;

public class AdminDelCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDao categoryDao;

	public AdminDelCatController() {
		super();
		categoryDao = new CategoryDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/auth/login");
			return;
		}
		int idDel = 0;
		try {
			idDel = Integer.parseInt(request.getParameter("did"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (categoryDao.delItem(idDel) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/cats?msg=1");
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/cats?msg=-1");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
