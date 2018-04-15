package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Bean.Category;
import model.Bean.News;
import model.Bean.Rank;
import model.Bean.User;
import model.Dao.CategoryDao;
import model.Dao.NewsDao;
import util.AuthUtil;
import util.FileUtil;

@MultipartConfig
public class AdminEditNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDao categoryDao;
	private NewsDao newsDao;

	public AdminEditNewsController() {
		super();
		categoryDao = new CategoryDao();
		newsDao = new NewsDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/auth/login");
			return;
		}
		int id_Edit = 0;
		try {
			id_Edit = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		ArrayList<Category> itemCategories = categoryDao.getItem();
		News getItemNews = newsDao.getItemById(id_Edit);
		request.setAttribute("getItemNews", getItemNews);
		request.setAttribute("itemCategories", itemCategories);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/news/edit.jsp");
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
		HttpSession session = request.getSession();
		int id_Edit = 0;
		try {
			id_Edit = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		String name_News = request.getParameter("namenews");
		int id_Categoy = 0;
		try {
			id_Categoy = Integer.parseInt(request.getParameter("id_category"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		System.out.println(id_Categoy);
		int id_silde = 0;
		String slide = request.getParameter("slide");
		if (slide != null) {
			id_silde = 1;
		} else {
			id_silde = 0;
		}
		User objUser = (User) session.getAttribute("userLogin");
		int id_User = objUser.getId();
		String preview = request.getParameter("preview");
		String detail = request.getParameter("detail");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date_Create = sdf.format(new Date());
		Part file = request.getPart("picture");
		String picture = "";
		String filename = FileUtil.getName(file);
		final String path = request.getServletContext().getRealPath("/files");
		System.out.println(path);
		File dirPath = new File(path);
		if (!dirPath.exists()) {
			dirPath.mkdir();
		}
		if (!"".equals(filename)) {
			if (!"".equals(newsDao.getItemById(id_Edit).getPicture())) {
				String urlFileDel = path + File.separator + newsDao.getItemById(id_Edit).getPicture();
				File delFile = new File(urlFileDel);
				delFile.delete();
			}
			picture = FileUtil.rename(filename);
			String filePath = path + File.separator + picture;
			file.write(filePath);
		} else {
			picture = newsDao.getItemById(id_Edit).getPicture();
		}
		News news = new News(id_Edit, name_News, preview, detail, date_Create, id_User, picture, id_Categoy, id_silde,
				0, new User(id_User, null, null, null, null, new Rank(0, null), 0), new Category(id_Categoy, null, 0));
		if (newsDao.editItem(news) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/news?msg=2");
			return;
		} else {
			ArrayList<Category> itemCategories = categoryDao.getItem();
			request.setAttribute("itemCategories", itemCategories);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/news/edit.jsp?msg=-2");
			rd.forward(request, response);
			return;
		}
	}

}
