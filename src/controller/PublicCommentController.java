package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bean.Comment;
import model.Dao.CommentDao;

public class PublicCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentDao commentDao;

	public PublicCommentController() {
		super();
		commentDao = new CommentDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email_comment = request.getParameter("email");
		String content_comment = request.getParameter("content");
		int detail_id = 0;
		try {
			detail_id = Integer.parseInt(request.getParameter("deid"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		System.out.println("id comment" + detail_id);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date_Create = sdf.format(new Date());
		String result = "";
		System.out.println("tin comment" + detail_id + email_comment);
		Comment cmt = new Comment(0, content_comment, email_comment, date_Create, 0, detail_id, 0);
		if (commentDao.addComment(cmt) > 0) {
			ArrayList<Comment> cmts = commentDao.getItems(detail_id);
			for (Comment item : cmts) {
				result += "<div class='media'>" + "<div class='media-left'>"
						+ "<a href='#'> <img alt='64x64' class='media-object'"
						+ "data-src='<%=request.getContextPath()%>/templates/public/img/img-author1.jpg'"
						+ "src='<%=request.getContextPath()%>/templates/public/img/img-author1.jpg'"
						+ "data-holder-rendered='true'>" + "</a>" + "</div>" + "<div class='media-body'>"
						+ "<h2 class='media-heading'>" + item.getEmail() + "</h2>" + item.getContent() +

						"<div class='comment_article_social'>"
						+ "<a href='#'><i class='fa fa-thumbs-o-up' aria-hidden='true'></i></a>"
						+ "<a href='#'><i class='fa fa-thumbs-o-down'"
						+ "aria-hidden='true'></i></a> <a href='#'><span class='reply_ic'>" + "Reply </span></a>"
						+ "</div>" + "</div>" + "</div>";
			}
			out.println(result);
		}
	}

}
