package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Bean.Comment;
import model.Bean.News;
import model.Dao.CommentDao;
import model.Dao.IndexPublicDao;
import model.Dao.NewsDao;

public class PublicDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IndexPublicDao indexPublicDao;
	private NewsDao newsDao;
	private CommentDao commentDao;

	public PublicDetailController() {
		super();
		indexPublicDao = new IndexPublicDao();
		newsDao = new NewsDao();
		commentDao = new CommentDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id_News = 0;
		try {
			id_News = Integer.parseInt(request.getParameter("did"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/page_500.jsp");
			return;
		}
		News itemDetail = indexPublicDao.getItemDetail(id_News);
		News objNews = newsDao.getItemById(id_News);
		ArrayList<Comment> itemComments = commentDao.getItems(id_News);
		ArrayList<News> itemRelatedNews = indexPublicDao.getItemRelatedNews(objNews.getCategory().getId(), id_News);
		request.setAttribute("itemDetail", itemDetail);
		request.setAttribute("itemComments", itemComments);
		request.setAttribute("itemRelatedNews", itemRelatedNews);
		RequestDispatcher rd = request.getRequestDispatcher("/detail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
