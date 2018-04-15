package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bean.News;
import model.Dao.NewsDao;
import util.AuthUtil;

public class AdminDelNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NewsDao newsDao;

	public AdminDelNewsController() {
		super();
		newsDao = new NewsDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/auth/login");
			return;
		}
		int id_Del = 0;
		try {
			id_Del = Integer.parseInt(request.getParameter("did"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return;
		}
		News objNews = newsDao.getItemById(id_Del);
		if (newsDao.delItem(id_Del) > 0) {
			String path = request.getServletContext().getRealPath("/files");
			String picture = objNews.getPicture();
			String filePath = path + File.separator + picture;
			File file = new File(filePath);
			if (file.exists()) {
				file.delete();
			}
			response.sendRedirect(request.getContextPath() + "/admin/news?msg=1");
			return;
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/news?msg=-1");
			return;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
