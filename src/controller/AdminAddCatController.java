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

public class AdminAddCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDao categoryDao;

	public AdminAddCatController() {
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
		ArrayList<Category> items = null;
		items = categoryDao.getItem();
		request.setAttribute("category", items);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/cat/add.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if (!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/auth/login");
			return;
		}
		String name_Cat = request.getParameter("category");
		int id_Parent = 0;
		try {
			id_Parent = Integer.parseInt(request.getParameter("parent_id"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		Category category = new Category(0, name_Cat, id_Parent);
		
		if (categoryDao.checkCategory(name_Cat,id_Parent) != null ) {
			response.sendRedirect(request.getContextPath() + "/admin/cat/add?msg=-9");
		} else {
			if (categoryDao.addItemCat(category) > 0) {
				System.out.println("Thêm thành Công");
				response.sendRedirect(request.getContextPath()+"/admin/cats?msg=3");
			}else {
				System.out.println("Thêm thất bại");
				RequestDispatcher rd = request.getRequestDispatcher("/admin/cat/add.jsp?msg=-3");
				rd.forward(request, response);
			}
		}
	}

}
