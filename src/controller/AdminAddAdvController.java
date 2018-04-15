package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Bean.Advertisement;
import model.Dao.AdvertisementDao;
import util.FileUtil;
@MultipartConfig
public class AdminAddAdvController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdvertisementDao advertisementDao;

	public AdminAddAdvController() {
		super();
		advertisementDao = new AdvertisementDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		RequestDispatcher rd = request.getRequestDispatcher("/admin/adv/add.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String nameAdv = request.getParameter("nameAdv");
		String nameLink = request.getParameter("nameLink");

		Part file = request.getPart("picture");
		String picture = "";
		String filname = FileUtil.getName(file);
		final String path = request.getServletContext().getRealPath("/files");
		System.out.println(path);
		File dirPath = new File(path);
		if (!dirPath.exists()) {
			dirPath.mkdir();
		}
		picture = FileUtil.rename(filname);
		String filePath = path + File.separator + picture;

		Advertisement adv = new Advertisement(0, nameAdv, picture, 1, nameLink);
		if (advertisementDao.addItem(adv) > 0) {
			if (!picture.isEmpty()) {
				file.write(filePath);
			}
			response.sendRedirect(request.getContextPath() + "/admin/advs?msg=3");
			return;
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/adv/add.jsp?msg=-3");
			rd.forward(request, response);
		}
	}

}
