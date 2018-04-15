package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bean.Advertisement;
import model.Dao.AdvertisementDao;

public class AdminDelAdvController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdvertisementDao advertisementDao;

	public AdminDelAdvController() {
		super();
		advertisementDao = new AdvertisementDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id_del = 0;
		try {
			id_del = Integer.parseInt(request.getParameter("did"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return;
		}
		Advertisement adv = advertisementDao.getItemById(id_del);
		if (advertisementDao.delItem(id_del) > 0) {
			String path = request.getServletContext().getRealPath("/files-adv");
			String picture = adv.getPicture();
			String filePath = path + File.separator + picture;
			File file = new File(filePath);
			if (file.exists()) {
				file.delete();
			}
			response.sendRedirect(request.getContextPath() + "/admin/advs?msg=1");
			return;
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/advs?msg=-1");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
