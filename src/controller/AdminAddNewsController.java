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
public class AdminAddNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDao categoryDao;
	private NewsDao newsDao;

	public AdminAddNewsController() {
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
		ArrayList<Category> itemCategories = categoryDao.getItem();
		request.setAttribute("itemCategories", itemCategories);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/news/add.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if (!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/auth/login");
			return;
		}
		HttpSession session = request.getSession();
		String name_News = request.getParameter("namenews");
		int id_Cat = 0;
		try {
			id_Cat = Integer.parseInt(request.getParameter("id_category"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (id_Cat == -100) {
			response.sendRedirect(request.getContextPath() + "/admin/news/add?msg=-100");
			return;
		}
		int id_slide = 0;
		String slide = request.getParameter("slide");
		if (slide != null) {
			id_slide = 1;
		} else {
			id_slide = 0;
		}
		User objUser = (User) session.getAttribute("userLogin");
		int id_User = objUser.getId();
		System.out.println("idusser" + id_User);

		String preview = request.getParameter("preview");
		String detail = request.getParameter("detail");
		Part file = request.getPart("picture");
		String picture = "";
		// lấy tên file
		String filename = FileUtil.getName(file);

		final String path = request.getServletContext().getRealPath("/files");
		System.out.println(path);
		File dirPath = new File(path);
		if (!dirPath.exists()) {
			dirPath.mkdir();
		}
		// có tên file mới
		picture = FileUtil.rename(filename);
		String filePath = path + File.separator + picture;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date_Create = sdf.format(new Date());
		News objNews = new News(0, name_News, preview, detail, date_Create, id_User, picture, id_Cat, id_slide, 0,
				new User(id_User, null, null, null, null, new Rank(0, null), 0), new Category(id_Cat, null, 0));
		if (newsDao.addItem(objNews) > 0) {
			if (!picture.isEmpty()) {
				file.write(filePath);
			}
			response.sendRedirect(request.getContextPath() + "/admin/news?msg=3");
			return;
		} else {

			request.setAttribute("categories", categoryDao.getItem());
			RequestDispatcher rd = request.getRequestDispatcher("/admin/news/add.jsp?msg=-3");
			rd.forward(request, response);
			return;
		}
	}

}
