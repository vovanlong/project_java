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
public class AdminEditAdvController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdvertisementDao advertisementDao;

	public AdminEditAdvController() {
		super();
		advertisementDao = new AdvertisementDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id_Adv = 0;
		try {
			id_Adv = Integer.parseInt(request.getParameter("uid"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return;
		}
		Advertisement adv_Old = advertisementDao.getItemById(id_Adv);
		request.setAttribute("adv_Old", adv_Old);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/adv/edit.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id_Adv = 0;

		try {
			id_Adv = Integer.parseInt(request.getParameter("uid"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return;
		}

		Advertisement oldAdv = advertisementDao.getItemById(id_Adv);
		oldAdv.setId(id_Adv);
		String nameAdv = request.getParameter("nameAdv");
		String nameLink = request.getParameter("nameLink");
		Part file = request.getPart("picture");
		String delPic = request.getParameter("delpicture");
		String fileName = FileUtil.getName(file);
		System.out.println(fileName);
		String picture = "";
		// kiểm tra nameAdv và nameLink rỗng
		if ("".equals(nameAdv) || "".equals(nameLink)) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/adv/edit.jsp?msg=-7");
			rd.forward(request, response);
		}

		final String path = request.getServletContext().getRealPath("/files");
		System.out.println(path);
		File dirPath = new File(path);
		if (!dirPath.exists()) {
			dirPath.mkdir();
		}
		picture = FileUtil.rename(fileName);
		String oldPic = oldAdv.getPicture();
		oldAdv.setName(nameAdv);
		oldAdv.setLink(nameLink);
		if (!picture.isEmpty() || delPic != null) {
			oldAdv.setPicture(picture);
		}
		if (advertisementDao.editItem(oldAdv) > 0) {
			if (!picture.isEmpty() || delPic != null) {
				String urlFile = path + File.separator + oldPic;
				File delFile = new File(urlFile);
				if (delFile.exists()) {
					delFile.delete();
				}
				if (!picture.isEmpty()) {
					String filepath = path + File.separator + picture;
					file.write(filepath);
				}
			}
			response.sendRedirect(request.getContextPath() + "/admin/advs?msg=2");
			return;
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/adv/edit.jsp?msg=-2");
			rd.forward(request, response);
			return;
		}
	}

}
