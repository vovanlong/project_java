package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bean.Advertisement;
import model.Dao.AdvertisementDao;
import util.AuthUtil;

public class AdminIndexAdvController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdvertisementDao advertisementDao;

	public AdminIndexAdvController() {
		super();
		advertisementDao = new AdvertisementDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/auth/login");
			return;
		}
		ArrayList<Advertisement> itemAdv = null;
		itemAdv = advertisementDao.getItem();
		request.setAttribute("itemAdv", itemAdv);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/adv/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/auth/login");
			return;
		}
		response.setContentType("text/html");
		int id = 0;
		int aActive = 0;
		int active = 0;
		try {
			id = Integer.parseInt(request.getParameter("uid"));
			aActive = Integer.parseInt(request.getParameter("uactive"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return;
		}
		System.out.println(id + " " + aActive);
		PrintWriter out = response.getWriter();
		if (aActive == 0) {
			active = 1;
			advertisementDao.editActive(id, active);
			out.println("<a href='javascript:void(0)' onclick='return changeActive(" + id + "," + active
					+ ")'><input type='checkbox' id='id_slide' name='id_slide' checked></a>");
			System.out.println("mở");
		} else if (aActive == 1) {
			active = 0;
			advertisementDao.editActive(id, active);
			out.println("<a href='javascript:void(0)' onclick='return changeActive(" + id + "," + active
					+ ")'><input type='checkbox' id='id_slide' name='id_slide'></a>");
			System.out.println("đóng");
		}
	}

}
