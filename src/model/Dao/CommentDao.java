package model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Bean.Comment;
import util.DBConnectionUtil;

public class CommentDao {
	private Statement st;
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pst;

	public int addComment(Comment cmt) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "INSERT INTO comments(content,email,date_create,id_commentparent,news_id,lock_id)"
				+ "VALUES (?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, cmt.getContent());
			pst.setString(2, cmt.getEmail());
			pst.setString(3, cmt.getDate_create());
			pst.setInt(4, cmt.getId_commentparent());
			pst.setInt(5, cmt.getNews_id());
			pst.setInt(6, cmt.getLock());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			if (pst != null && conn != null) {
				try {
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public ArrayList<Comment> getItems(int detail_id) {
		ArrayList<Comment> items = new ArrayList<Comment>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT id, content,email,date_create,id_commentparent,news_id,lock_id " + "FROM comments "
				+ "WHERE news_id = " + detail_id;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String content = rs.getString("content");
				String email = rs.getString("email");
				int id_commentparent = rs.getInt("id_commentparent");
				int news_id = rs.getInt("news_id");
				int lock_id = rs.getInt("lock_id");
				Comment item = new Comment(id, content, email, null, id_commentparent, news_id, lock_id);
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			if (rs != null && st != null && conn != null) {
				try {
					rs.close();
					st.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return items;

	}

}
