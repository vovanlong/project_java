package model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Bean.Category;
import model.Bean.News;
import model.Bean.Rank;
import model.Bean.User;
import util.DBConnectionUtil;

public class CategoryPublicDao {
	private Statement st;
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pst;

	public News getItemOneNewsMainParent(int id_Cat) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		News item = new News();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT news.id,news.name,news.preview,news.detail, news.date_create, news.create_by,news.picture,news.cat_id,news.is_slide,news.count_number,cat_list.name,cat_list.parent_id,user.username,user.fullname,user.active,user.id_rank FROM news INNER JOIN cat_list ON cat_list.id = news.cat_id INNER JOIN user ON user.id = news.create_by WHERE cat_list.parent_id = "
				+ id_Cat + " LIMIT 1";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				int id_News = rs.getInt("news.id");
				String name_News = rs.getString("news.name");
				String preview = rs.getString("news.preview");
				String detail = rs.getString("news.detail");
				String date_Create = "";
				Date tempDate = rs.getDate("news.date_create");
				date_Create = sdf.format(tempDate);
				int Create_By = rs.getInt("news.create_by");
				String picture = rs.getString("news.picture");
				int cat_Id = rs.getInt("news.cat_id");
				int id_slide = rs.getInt("news.is_slide");
				int count_number = rs.getInt("count_number");
				int id_Category = rs.getInt("news.cat_id");
				String name_Cat = rs.getString("cat_list.name");
				int id_Parent = rs.getInt("cat_list.parent_id");
				int id_User = rs.getInt("news.create_by");
				String username = rs.getString("user.username");
				String fullname = rs.getString("user.fullname");
				int id_Active = rs.getInt("user.active");
				int id_Rank = rs.getInt("user.id_rank");
				item = new News(id_News, name_News, preview, detail, date_Create, Create_By, picture, cat_Id, id_slide,
						count_number,
						new User(id_User, username, null, fullname, null, new Rank(id_Rank, null), id_Active),
						new Category(id_Category, name_Cat, id_Parent));
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
		return item;
	}

	public News getItemOneNewsMainChild(int id_Cat) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		News item = new News();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT news.id,news.name,news.preview,news.detail, news.date_create, news.create_by,news.picture,news.cat_id,news.is_slide,news.count_number,cat_list.name,cat_list.parent_id,user.username,user.fullname,user.active,user.id_rank FROM news INNER JOIN cat_list ON cat_list.id = news.cat_id INNER JOIN user ON user.id = news.create_by WHERE news.cat_id = "
				+ id_Cat + " LIMIT 1";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				int id_News = rs.getInt("news.id");
				String name_News = rs.getString("news.name");
				String preview = rs.getString("news.preview");
				String detail = rs.getString("news.detail");
				String date_Create = "";
				Date tempDate = rs.getDate("news.date_create");
				date_Create = sdf.format(tempDate);
				int Create_By = rs.getInt("news.create_by");
				String picture = rs.getString("news.picture");
				int cat_Id = rs.getInt("news.cat_id");
				int id_slide = rs.getInt("news.is_slide");
				int count_number = rs.getInt("count_number");
				int id_Category = rs.getInt("news.cat_id");
				String name_Cat = rs.getString("cat_list.name");
				int id_Parent = rs.getInt("cat_list.parent_id");
				int id_User = rs.getInt("news.create_by");
				String username = rs.getString("user.username");
				String fullname = rs.getString("user.fullname");
				int id_Active = rs.getInt("user.active");
				int id_Rank = rs.getInt("user.id_rank");
				item = new News(id_News, name_News, preview, detail, date_Create, Create_By, picture, cat_Id, id_slide,
						count_number,
						new User(id_User, username, null, fullname, null, new Rank(id_Rank, null), id_Active),
						new Category(id_Category, name_Cat, id_Parent));
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
		return item;
	}

	public int CheckChild(int id) {
		int resutl = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT COUNT(*) AS sumchild FROM cat_list WHERE parent_id = " + id;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				resutl = rs.getInt("sumchild");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			if (st != null && rs != null && conn != null) {
				try {
					st.close();
					rs.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return resutl;
	}

	public ArrayList<News> getItemCatByIdParent(int id_Cat) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		ArrayList<News> items = new ArrayList<News>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT news.id,news.name,news.preview,news.detail, news.date_create, news.create_by,news.picture,news.cat_id,news.is_slide,news.count_number,cat_list.name,cat_list.parent_id,user.username,user.fullname,user.active,user.id_rank FROM news INNER JOIN cat_list ON cat_list.id = news.cat_id INNER JOIN user ON user.id = news.create_by WHERE cat_list.parent_id = "
				+ id_Cat;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id_News = rs.getInt("news.id");
				String name = rs.getString("news.name");
				String preview = "";
				String preview_News = rs.getString("news.preview");
				if (preview_News.length() < 50) {
					preview = rs.getString("news.preview");
				} else {
					preview = preview_News.substring(0, 50) + "...";
				}
				String detail = rs.getString("news.detail");
				String date_Create = "";
				Date tempDate = rs.getDate("news.date_create");
				date_Create = sdf.format(tempDate);
				int create_By = rs.getInt("news.create_by");
				String picture = rs.getString("news.picture");
				int id_Category = rs.getInt("news.cat_id");
				int id_Slide = rs.getInt("news.is_slide");
				int count_Views = rs.getInt("news.count_number");
				String name_Cat = rs.getString("cat_list.name");
				int id_Parent = rs.getInt("cat_list.parent_id");
				String username = rs.getString("user.username");
				String fullname = rs.getString("user.fullname");
				int id_Active = rs.getInt("user.active");
				int id_Rank = rs.getInt("user.id_rank");
				News item = new News(id_News, name, preview, detail, date_Create, create_By, picture, id_Category,
						id_Slide, count_Views,
						new User(create_By, username, null, fullname, null, new Rank(id_Rank, null), id_Active),
						new Category(id_Category, name_Cat, id_Parent));
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

	public ArrayList<News> getItemCatByIdChild(int id_Cat) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		ArrayList<News> items = new ArrayList<News>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT news.id,news.name,news.preview,news.detail, news.date_create, news.create_by,news.picture,news.cat_id,news.is_slide,news.count_number,cat_list.name,cat_list.parent_id,user.username,user.fullname,user.active,user.id_rank FROM news INNER JOIN cat_list ON cat_list.id = news.cat_id INNER JOIN user ON user.id = news.create_by WHERE  news.cat_id = "
				+ id_Cat;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id_News = rs.getInt("news.id");
				String name = rs.getString("news.name");
				String preview = "";
				String preview_News = rs.getString("news.preview");
				if (preview_News.length() < 50) {
					preview = rs.getString("news.preview");
				} else {
					preview = preview_News.substring(0, 50) + "...";
				}
				String detail = rs.getString("news.detail");
				String date_Create = "";
				Date tempDate = rs.getDate("news.date_create");
				date_Create = sdf.format(tempDate);
				int create_By = rs.getInt("news.create_by");
				String picture = rs.getString("news.picture");
				int id_Category = rs.getInt("news.cat_id");
				int id_Slide = rs.getInt("news.is_slide");
				int count_Views = rs.getInt("news.count_number");
				String name_Cat = rs.getString("cat_list.name");
				int id_Parent = rs.getInt("cat_list.parent_id");
				String username = rs.getString("user.username");
				String fullname = rs.getString("user.fullname");
				int id_Active = rs.getInt("user.active");
				int id_Rank = rs.getInt("user.id_rank");
				News item = new News(id_News, name, preview, detail, date_Create, create_By, picture, id_Category,
						id_Slide, count_Views,
						new User(create_By, username, null, fullname, null, new Rank(id_Rank, null), id_Active),
						new Category(id_Category, name_Cat, id_Parent));
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
