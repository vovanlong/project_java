package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bean.Category;
import model.Bean.News;
import model.Dao.IndexPublicDao;

public class PublicIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IndexPublicDao indexPublicDao;

	public PublicIndexController() {
		super();
		indexPublicDao = new IndexPublicDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		News itemSlideMain = indexPublicDao.getItemSlideMain();
		ArrayList<News> itemSlide = indexPublicDao.getItemSlide();
		ArrayList<News> itemTwoNews = indexPublicDao.getItemTwoNews();
		ArrayList<Category> itemOneNewsMain = indexPublicDao.getItemCatNews();

		ArrayList<News> itemMostNews = indexPublicDao.getItemMostNews();
		request.setAttribute("itemMostNews", itemMostNews);
		request.setAttribute("itemOneNewsMain", itemOneNewsMain);
		request.setAttribute("itemTwoNews", itemTwoNews);
		request.setAttribute("itemSlide", itemSlide);
		request.setAttribute("itemSlideMain", itemSlideMain);
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
