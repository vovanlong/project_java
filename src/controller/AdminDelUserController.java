package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao.UserDao;
import util.AuthUtil;

public class AdminDelUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	public AdminDelUserController() {
		super();
		userDao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/auth/login");
			return;
		}
		int id_del = 0;
		try {
			id_del = Integer.parseInt(request.getParameter("did"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (userDao.delItem(id_del) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/users?msg=1");
			return;
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/users?msg=-1");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
