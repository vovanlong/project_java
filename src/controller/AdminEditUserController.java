package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bean.Rank;
import model.Bean.User;
import model.Dao.RankDao;
import model.Dao.UserDao;
import util.AuthUtil;
import util.StringUtil;

public class AdminEditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RankDao rankDao;
	private UserDao userDao;

	public AdminEditUserController() {
		super();
		rankDao = new RankDao();
		userDao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/auth/login");
			return;
		}
		int id_User = 0;

		try {
			id_User = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		System.out.println("rhymastic" + id_User);
		User objUser = null;
		objUser = userDao.getItemOld(id_User);
		ArrayList<Rank> itemsRank = rankDao.getItems();
		request.setAttribute("objUser", objUser);
		request.setAttribute("itemsRank", itemsRank);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/user/edit.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if (!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/auth/login");
			return;
		}
		int id_User = 0;
		try {
			id_User = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		String userName = request.getParameter("username");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		if (!repassword.equals(password)) {
			response.sendRedirect(request.getContextPath() + "/admin/users/edit?msg=-8 ");
			return;
		}
		int id_Rank = 0;
		try {
			id_Rank = Integer.parseInt(request.getParameter("id_rank"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		String email = request.getParameter("email");
		if ("".equals(password)) {
			password = userDao.getItemOld(id_User).getPassword();
		} else {
			password = StringUtil.md5(password);
		}
		User objUser = new User(id_User, userName, password, fullName, email, new Rank(id_Rank, null), 0);
		if (userDao.editUser(objUser) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/users?msg=2");
			return;
		} else {
			request.setAttribute("objUser", objUser);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/user/edit.jsp?msg=-2");
			rd.forward(request, response);
			return;
		}
	}
}
