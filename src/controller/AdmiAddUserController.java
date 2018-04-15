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

public class AdmiAddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RankDao rankDao;
	private UserDao userDao;

	public AdmiAddUserController() {
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
		ArrayList<Rank> itemsRank = rankDao.getItems();
		request.setAttribute("itemsRank", itemsRank);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/user/add.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if (!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/auth/login");
			return;
		}
		
		String userName = request.getParameter("username");
		String fullName = request.getParameter("fullname");
		int id_Rank = 0;
		try {
			id_Rank = Integer.parseInt(request.getParameter("id_rank"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		if (!password.equals(repassword)) {
			response.sendRedirect(request.getContextPath() + "/admin/user/add?msg=-8");
			return;
		}
		password = StringUtil.md5(request.getParameter("password"));
		String email = request.getParameter("email");
		User item = new User(0, userName, password, fullName, email, new Rank(id_Rank, null), 0);
		if (userDao.checkUserName(item) != null) {
			response.sendRedirect(request.getContextPath() + "/admin/user/add?msg=-9");
		} else {
			if (userDao.addItemUser(item) > 0) {
				response.sendRedirect(request.getContextPath() + "/admin/users?msg=3");
				return;
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/admin/user/add.jsp?msg=-3");
				rd.forward(request, response);
			}
		}
	}

}
