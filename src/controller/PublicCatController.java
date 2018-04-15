package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bean.News;
import model.Dao.CategoryPublicDao;

public class PublicCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryPublicDao categoryPublicDao;

	public PublicCatController() {
		super();
		categoryPublicDao = new CategoryPublicDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id_Cat = 0;
		try {
			id_Cat = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		News itemNewsMainByCat = new News();
		if (categoryPublicDao.CheckChild(id_Cat) > 0) {
			itemNewsMainByCat = categoryPublicDao.getItemOneNewsMainParent(id_Cat);
		} else {
			itemNewsMainByCat = categoryPublicDao.getItemOneNewsMainChild(id_Cat);
		}
		ArrayList<News> itemNewsByIdCat = new ArrayList<News>();
		if (categoryPublicDao.CheckChild(id_Cat) > 0) {
			itemNewsByIdCat = categoryPublicDao.getItemCatByIdParent(id_Cat);
			return;
		} else {
			itemNewsByIdCat = categoryPublicDao.getItemCatByIdChild(id_Cat);
		}
		request.setAttribute("itemNewsByIdCat", itemNewsByIdCat);
		request.setAttribute("itemOneNewsMain", itemNewsMainByCat);
		RequestDispatcher rd = request.getRequestDispatcher("/category.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
