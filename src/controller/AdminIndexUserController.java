package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bean.User;
import model.Dao.UserDao;
import util.AuthUtil;
import util.DeFine;

public class AdminIndexUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	public AdminIndexUserController() {
		super();
		userDao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		System.out.println(search);
		int sumUser = userDao.countCat();
		int sumPage = (int) Math.ceil((float) sumUser / DeFine.ROW_COUNT_PUBLIC);
		int current_Page = 1;
		if (request.getParameter("page") != null) {
			current_Page = Integer.parseInt(request.getParameter("page"));
		}
		int offset = (current_Page - 1) * DeFine.ROW_COUNT_PUBLIC;
		ArrayList<User> items = null;
		if (search == null) {
			items = userDao.getItemPaination(offset);
		} else {
			items = userDao.getItemPaination(search, offset);
		}

		request.setAttribute("items", items);
		request.setAttribute("sumPage", sumPage);
		request.setAttribute("current_Page", current_Page);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/user/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		int id = 0;
		int aactive = 0;
		int active = 0;
		try {
			id = Integer.parseInt(request.getParameter("uid"));
			aactive = Integer.parseInt(request.getParameter("uactive"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/users?msg=1");
			return;
		}
		System.out.println(id + " " + aactive);
		PrintWriter out = response.getWriter();
		if (aactive == 0) {
			active = 1;
			userDao.editActive(active, id);
			out.println("<a href='javascript:void(0)' onclick='return changeActive(" + id + "," + active
					+ ")'><input type='checkbox' id='id_slide' name='id_slide' checked></a>");
			System.out.println("Mở");
		} else if (aactive == 1) {
			active = 0;
			userDao.editActive(active, id);
			out.println("<a href='javascript:void(0)' onclick='return changeActive(" + id + "," + active
					+ ")'><input type='checkbox' id='id_slide' name='id_slide'></a>");
			System.out.println("Đóng");

		}
	}

}
