package model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Bean.Advertisement;
import model.Bean.Category;
import model.Bean.News;
import model.Bean.Rank;
import model.Bean.User;
import util.DBConnectionUtil;

public class IndexPublicDao {
	private Statement st;
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pst;

	public ArrayList<News> getItemSlide() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		ArrayList<News> items = new ArrayList<News>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT news.id,news.name,news.preview,news.detail,news.date_create,news.create_by,news.picture,news.is_slide,news.count_number,cat_list.id,cat_list.name,cat_list.parent_id,user.id,user.username,user.fullname "
				+ "FROM news " + "INNER JOIN cat_list " + "ON news.cat_id = cat_list.id " + "INNER JOIN user "
				+ "ON news.create_by = user.id " + "WHERE news.is_slide > 0" + " ORDER BY news.id DESC LIMIT 1 ,5";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id_News = rs.getInt("news.id");
				String name_News = rs.getString("news.name");
				String preview = "";
				String preview_News = rs.getString("news.preview");
				preview = preview_News.substring(0, 35) + "...";
				String detail_News = rs.getString("news.detail");
				String date_Create = "";
				Date tempDate = rs.getDate("news.date_create");
				date_Create = sdf.format(tempDate);
				int create_By = rs.getInt("news.create_by");
				String picture_News = rs.getString("news.picture");
				int id_Slide = rs.getInt("news.is_slide");
				int count_Number = rs.getInt("news.count_number");
				int id_User = rs.getInt("user.id");
				String name_Username = rs.getString("user.username");
				String name_Fullname = rs.getString("user.fullname");
				int id_Cat = rs.getInt("cat_list.id");
				String name_Cat = rs.getString("cat_list.name");
				int id_Parent = rs.getInt("cat_list.parent_id");
				News item = new News(id_News, name_News, preview, detail_News, date_Create, create_By, picture_News,
						id_Cat, id_Slide, count_Number,
						new User(id_User, name_Username, null, name_Fullname, null, new Rank(0, null), 0),
						new Category(id_Cat, name_Cat, 0));
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

	public News getItemSlideMain() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		News item = null;
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT news.id,news.name,news.preview,news.detail,news.date_create,news.create_by,news.picture,news.is_slide,news.count_number,cat_list.id,cat_list.name,cat_list.parent_id,user.id,user.username,user.fullname FROM news INNER JOIN cat_list ON news.cat_id = cat_list.id INNER JOIN user ON news.create_by = user.id WHERE news.is_slide > 0 ORDER BY news.id DESC LIMIT 1";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs.next()) {
				int id_News = rs.getInt("news.id");
				String name_News = rs.getString("news.name");

				String preview = "";
				String preview_News = rs.getString("news.preview");
				int count = preview_News.length();
				if (count <= 50) {
					preview = rs.getString("news.preview");
				} else {
					preview = preview_News.substring(0, 50) + "...";
				}

				String detail_News = rs.getString("news.detail");
				String date_Create = "";
				Date tempDate = rs.getDate("news.date_create");
				date_Create = sdf.format(tempDate);
				int create_By = rs.getInt("news.create_by");
				String picture_News = rs.getString("news.picture");
				int id_Slide = rs.getInt("news.is_slide");
				int count_Number = rs.getInt("news.count_number");
				int id_User = rs.getInt("user.id");
				String name_Username = rs.getString("user.username");
				String name_Fullname = rs.getString("user.fullname");
				int id_Cat = rs.getInt("cat_list.id");
				String name_Cat = rs.getString("cat_list.name");
				int id_Parent = rs.getInt("cat_list.parent_id");
				item = new News(id_News, name_News, preview, detail_News, date_Create, create_By, picture_News, id_Cat,
						id_Slide, count_Number,
						new User(id_User, name_Username, null, name_Fullname, null, new Rank(0, null), 0),
						new Category(id_Cat, name_Cat, 0));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			if (rs != null && pst != null && conn != null) {
				try {
					rs.close();
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return item;
	}

	public ArrayList<News> getItemTwoNews() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		ArrayList<News> items = new ArrayList<News>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT news.id,news.name,news.preview,news.detail,news.date_create,news.create_by,news.picture,news.is_slide,news.count_number,cat_list.id,cat_list.name,cat_list.parent_id,user.id,user.username,user.fullname "
				+ "FROM news " + "INNER JOIN cat_list " + "ON news.cat_id = cat_list.id " + "INNER JOIN user "
				+ "ON news.create_by = user.id  ORDER BY news.id DESC LIMIT 0 ,2";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id_News = rs.getInt("news.id");
				String name_News = rs.getString("news.name");

				String previews = "";
				String preview_News = rs.getString("news.preview");
				int count = preview_News.length();
				if (count <= 50) {
					previews = rs.getString("news.preview");
					;
				} else {
					previews = preview_News.substring(0, 50) + "...";
				}

				String detail_News = rs.getString("news.detail");

				String date_Create = "";
				Date tempDate = rs.getDate("news.date_create");
				date_Create = sdf.format(tempDate);

				int create_By = rs.getInt("news.create_by");
				String picture_News = rs.getString("news.picture");
				int id_Slide = rs.getInt("news.is_slide");
				int count_Number = rs.getInt("news.count_number");
				int id_User = rs.getInt("user.id");
				String name_Username = rs.getString("user.username");
				String name_Fullname = rs.getString("user.fullname");
				int id_Cat = rs.getInt("cat_list.id");
				String name_Cat = rs.getString("cat_list.name");
				int id_Parent = rs.getInt("cat_list.parent_id");
				News item = new News(id_News, name_News, previews, detail_News, date_Create, create_By, picture_News,
						id_Cat, id_Slide, count_Number,
						new User(id_User, name_Username, null, name_Fullname, null, new Rank(0, null), 0),
						new Category(id_Cat, name_Cat, id_Parent));
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

	/*
	 * public ArrayList<Category> getItemCatParent() { ArrayList<Category> items =
	 * new ArrayList<Category>(); conn = DBConnectionUtil.getConnection(); String
	 * sql = "SELECT id,name,parent_id FROM cat_list WHERE parent_id = 0"; try { st
	 * = conn.createStatement(); rs = st.executeQuery(sql); while (rs.next()) { int
	 * id = rs.getInt("id"); String name = rs.getString("name"); int id_Parent =
	 * rs.getInt("parent_id"); IndexPublicDao indexPublicDao = new IndexPublicDao();
	 * ArrayList<News> itemNews = indexPublicDao.getItemNewsByCat(id); Category item
	 * = new Category(id, name, id_Parent, null, itemNews); items.add(item); } }
	 * catch (SQLException e) { e.printStackTrace(); } catch (NullPointerException
	 * e) { e.printStackTrace(); } finally { if (rs != null && st != null && conn !=
	 * null) { try { rs.close(); st.close(); conn.close(); } catch (SQLException e)
	 * { e.printStackTrace(); } } } return items; }
	 */

	public ArrayList<News> getItemNewsByCat(int id) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		ArrayList<News> items = new ArrayList<News>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT news.id,news.name,news.preview,news.detail,news.date_create,news.create_by,news.picture,news.cat_id,"
				+ "news.is_slide,news.count_number,cat_list.id,cat_list.name,cat_list.parent_id,user.id,user.username,user.fullname,user.active,user.id_rank "
				+ "FROM news " + "INNER JOIN cat_list ON cat_list.id = news.cat_id "
				+ "INNER JOIN user ON news.create_by = user.id " + "WHERE cat_list.parent_id =" + id;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
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
				int id_Cat = rs.getInt("cat_list.id");
				String name_Cat = rs.getString("cat_list.name");
				int id_Parent = rs.getInt("cat_list.parent_id");
				int id_User = rs.getInt("user.id");
				String username = rs.getString("user.username");
				String fullname = rs.getString("user.fullname");
				int id_Active = rs.getInt("user.active");
				int id_Rank = rs.getInt("user.id_rank");
				News item = new News(id_News, name_News, preview, detail, date_Create, Create_By, picture, cat_Id,
						id_slide, count_number,
						new User(id_User, username, null, fullname, null, new Rank(id_Rank, null), id_Active),
						new Category(id_Cat, name_Cat, id_Parent));
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

	public ArrayList<Category> getItemCatgory() {
		ArrayList<Category> items = new ArrayList<Category>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT id,name,parent_id FROM cat_list WHERE parent_id = 0";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int id_Parent = rs.getInt("parent_id");
				Category item = new Category(id, name, id_Parent);
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

	public Category getItemNewsByCat() {
		Category item = null;
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT id,name,parent_id FROM cat_list WHERE parent_id = 0";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				IndexPublicDao indexPublicDao = new IndexPublicDao();
				News itemNews = indexPublicDao.getItemNewsMain(rs.getInt("id"));
				item = new Category(rs.getInt("id"), rs.getString("name"), rs.getInt("parent_id"), itemNews, null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return item;
	}

	private News getItemNewsMain(int id) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		News item = null;
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT news.id,news.name,news.preview,news.detail,news.date_create,news.create_by,news.picture,news.cat_id,news.is_slide,news.count_number,cat_list.id,cat_list.name,cat_list.parent_id,user.id,user.username,user.fullname,user.active,user.id_rank FROM news  INNER JOIN cat_list ON cat_list.id = news.cat_id INNER JOIN user ON news.create_by = user.id  WHERE cat_list.parent_id ="
				+ id + " LIMIT 1";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				int id_News = rs.getInt("news.id");
				String name_News = rs.getString("news.name");
				String main_Previews = "";
				String preview = rs.getString("news.preview");
				main_Previews = preview.substring(0, 100) + "...";
				String detail = rs.getString("news.detail");
				String date_Create = "";
				Date tempDate = rs.getDate("news.date_create");
				date_Create = sdf.format(tempDate);
				int Create_By = rs.getInt("news.create_by");
				String picture = rs.getString("news.picture");
				int cat_Id = rs.getInt("news.cat_id");
				int id_slide = rs.getInt("news.is_slide");
				int count_number = rs.getInt("count_number");
				int id_Cat = rs.getInt("cat_list.id");
				String name_Cat = rs.getString("cat_list.name");
				int id_Parent = rs.getInt("cat_list.parent_id");
				int id_User = rs.getInt("user.id");
				String username = rs.getString("user.username");
				String fullname = rs.getString("user.fullname");
				int id_Active = rs.getInt("user.active");
				int id_Rank = rs.getInt("user.id_rank");
				item = new News(id_News, name_News, main_Previews, detail, date_Create, Create_By, picture, cat_Id,
						id_slide, count_number,
						new User(id_User, username, null, fullname, null, new Rank(id_Rank, null), id_Active),
						new Category(id_Cat, name_Cat, id_Parent));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	public ArrayList<Category> getItemCatNews() {
		ArrayList<Category> items = new ArrayList<Category>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT id,name,parent_id FROM cat_list WHERE parent_id = 0";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int id_Parent = rs.getInt("parent_id");
				IndexPublicDao indexPublicDao = new IndexPublicDao();
				News newsMain = new News();
				if (indexPublicDao.CheckChild(id) > 0) {
					newsMain = indexPublicDao.getItemNewsMain(id);
				} else {
					newsMain = indexPublicDao.getItemNewsMainById(id);
				}
				ArrayList<News> itemFourNews = new ArrayList<News>();
				if (indexPublicDao.CheckChild(id) > 0) {
					itemFourNews = indexPublicDao.getItemFourNewsChildByID(id);
				} else {
					itemFourNews = indexPublicDao.getItemFourNewsParentByID(id);
				}
				/* ArrayList<News> fourNews = indexPublicDao.getItemNewsByCat(id); */
				Category itemNewsByCat = new Category(id, name, id_Parent, newsMain, itemFourNews);
				items.add(itemNewsByCat);

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

	private ArrayList<News> getItemFourNewsParentByID(int id) {
		ArrayList<News> items = new ArrayList<News>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT news.id,news.name,news.preview,news.detail,news.date_create,news.create_by,news.picture,news.cat_id,news.is_slide,news.count_number,cat_list.id,cat_list.name,cat_list.parent_id,user.id,user.username,user.fullname,user.active,user.id_rank FROM news  INNER JOIN cat_list ON cat_list.id = news.cat_id INNER JOIN user ON news.create_by = user.id  WHERE news.cat_id ="
				+ id + "  LIMIT 4";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id_News = rs.getInt("news.id");
				String name_News = rs.getString("news.name");
				String preview_Main = "";
				String preview = rs.getString("news.preview");
				int count = preview.length();
				if (count <= 40) {
					preview_Main = preview;
				} else {
					preview_Main = preview.substring(0, 40) + "...";
				}

				String detail = rs.getString("news.detail");
				String date_Create = "";
				Date tempDate = rs.getDate("news.date_create");
				date_Create = sdf.format(tempDate);
				int Create_By = rs.getInt("news.create_by");
				String picture = rs.getString("news.picture");
				int cat_Id = rs.getInt("news.cat_id");
				int id_slide = rs.getInt("news.is_slide");
				int count_number = rs.getInt("count_number");
				int id_Cat = rs.getInt("cat_list.id");
				String name_Cat = rs.getString("cat_list.name");
				int id_Parent = rs.getInt("cat_list.parent_id");
				int id_User = rs.getInt("user.id");
				String username = rs.getString("user.username");
				String fullname = rs.getString("user.fullname");
				int id_Active = rs.getInt("user.active");
				int id_Rank = rs.getInt("user.id_rank");
				News item = new News(id_News, name_News, preview_Main, detail, date_Create, Create_By, picture, cat_Id,
						id_slide, count_number,
						new User(id_User, username, null, fullname, null, new Rank(id_Rank, null), id_Active),
						new Category(id_Cat, name_Cat, id_Parent));
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return items;
	}

	private ArrayList<News> getItemFourNewsChildByID(int id) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		ArrayList<News> items = new ArrayList<News>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT news.id,news.name,news.preview,news.detail,news.date_create,news.create_by,news.picture,news.cat_id,news.is_slide,news.count_number,cat_list.id,cat_list.name,cat_list.parent_id,user.id,user.username,user.fullname,user.active,user.id_rank FROM news  INNER JOIN cat_list ON cat_list.id = news.cat_id INNER JOIN user ON news.create_by = user.id  WHERE cat_list.parent_id ="
				+ id + " LIMIT 4";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id_News = rs.getInt("news.id");
				String name_News = rs.getString("news.name");
				String preview_Main = "";
				String preview = rs.getString("news.preview");
				int count = preview.length();
				if (count <= 40) {
					preview_Main = preview;
				} else {
					preview_Main = preview.substring(0, 40) + "...";
				}

				String detail = rs.getString("news.detail");
				String date_Create = "";
				Date tempDate = rs.getDate("news.date_create");
				date_Create = sdf.format(tempDate);
				int Create_By = rs.getInt("news.create_by");
				String picture = rs.getString("news.picture");
				int cat_Id = rs.getInt("news.cat_id");
				int id_slide = rs.getInt("news.is_slide");
				int count_number = rs.getInt("count_number");
				int id_Cat = rs.getInt("cat_list.id");
				String name_Cat = rs.getString("cat_list.name");
				int id_Parent = rs.getInt("cat_list.parent_id");
				int id_User = rs.getInt("user.id");
				String username = rs.getString("user.username");
				String fullname = rs.getString("user.fullname");
				int id_Active = rs.getInt("user.active");
				int id_Rank = rs.getInt("user.id_rank");
				News item = new News(id_News, name_News, preview_Main, detail, date_Create, Create_By, picture, cat_Id,
						id_slide, count_number,
						new User(id_User, username, null, fullname, null, new Rank(id_Rank, null), id_Active),
						new Category(id_Cat, name_Cat, id_Parent));
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

	private News getItemNewsMainById(int id) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		News item = null;
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT news.id,news.name,news.preview,news.detail,news.date_create,news.create_by,news.picture,news.cat_id,news.is_slide,news.count_number,cat_list.id,cat_list.name,cat_list.parent_id,user.id,user.username,user.fullname,user.active,user.id_rank FROM news  INNER JOIN cat_list ON cat_list.id = news.cat_id INNER JOIN user ON news.create_by = user.id  WHERE news.cat_id = "
				+ id + " LIMIT 1";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				int id_News = rs.getInt("news.id");
				String name_News = rs.getString("news.name");
				String priview_Main = "";
				String preview = rs.getString("news.preview");
				priview_Main = preview.substring(0, 100) + "...";
				String detail = rs.getString("news.detail");
				String date_Create = "";
				Date tempDate = rs.getDate("news.date_create");
				date_Create = sdf.format(tempDate);
				int Create_By = rs.getInt("news.create_by");
				String picture = rs.getString("news.picture");
				int cat_Id = rs.getInt("news.cat_id");
				int id_slide = rs.getInt("news.is_slide");
				int count_number = rs.getInt("count_number");
				int id_Cat = rs.getInt("cat_list.id");
				String name_Cat = rs.getString("cat_list.name");
				int id_Parent = rs.getInt("cat_list.parent_id");
				int id_User = rs.getInt("user.id");
				String username = rs.getString("user.username");
				String fullname = rs.getString("user.fullname");
				int id_Active = rs.getInt("user.active");
				int id_Rank = rs.getInt("user.id_rank");
				item = new News(id_News, name_News, priview_Main, detail, date_Create, Create_By, picture, cat_Id,
						id_slide, count_number,
						new User(id_User, username, null, fullname, null, new Rank(id_Rank, null), id_Active),
						new Category(id_Cat, name_Cat, id_Parent));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
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

	public ArrayList<News> getItemMostNews() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		ArrayList<News> items = new ArrayList<News>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT news.id,news.name,news.preview,news.detail, news.date_create, news.create_by,news.picture,news.cat_id,news.is_slide,"
				+ "news.count_number,cat_list.name,cat_list.parent_id,user.username,user.fullname,user.active,user.id_rank "
				+ "FROM news INNER JOIN cat_list ON cat_list.id = news.cat_id "
				+ "INNER JOIN user ON user.id = news.create_by LIMIT 6";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id_News = rs.getInt("news.id");
				String name_News = rs.getString("news.name");
				String preview_Sub = "";
				String preview = rs.getString("news.preview");
				preview_Sub = preview.substring(0, 10) + "...";
				String detail = rs.getString("news.detail");
				String date_Create = "";
				Date tempDate = rs.getDate("news.date_create");
				date_Create = sdf.format(tempDate);
				int create_ByID = rs.getInt("news.create_by");
				String picture = rs.getString("news.picture");
				int id_Cat = rs.getInt("news.cat_id");
				int id_slide = rs.getInt("news.is_slide");
				int count_number = rs.getInt("news.count_number");
				String name_Cat = rs.getString("cat_list.name");
				int id_Parent = rs.getInt("cat_list.parent_id");
				String username = rs.getString("user.username");
				String fullname = rs.getString("user.fullname");
				int id_Active = rs.getInt("user.active");
				int id_Rank = rs.getInt("user.id_rank");
				News item = new News(id_News, name_News, preview_Sub, detail, date_Create, create_ByID, picture, id_Cat,
						id_slide, count_number,
						new User(create_ByID, username, null, fullname, null, new Rank(id_Rank, null), id_Active),
						new Category(id_Cat, name_Cat, id_Parent));
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

	public Advertisement getItemMainAdv() {
		Advertisement item = new Advertisement();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT id,name,picture,active,link FROM adtech LIMIT 1";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				int id_Adv = rs.getInt("id");
				String name_Adv = rs.getString("name");
				String picture_Adv = rs.getString("picture");
				int id_Active = rs.getInt("active");
				String link = rs.getString("link");
				item = new Advertisement(id_Adv, name_Adv, picture_Adv, id_Active, link);
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

	public ArrayList<Advertisement> getItemFourAdv() {
		ArrayList<Advertisement> items = new ArrayList<Advertisement>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT id,name,picture,active,link FROM adtech LIMIT 0,4";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String picture = rs.getString("picture");
				int active = rs.getInt("active");
				String link = rs.getString("link");
				Advertisement item = new Advertisement(id, name, picture, active, link);
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

	public News getItemDetail(int id_News) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		News item = new News();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT news.id,news.name,news.preview,news.detail,news.date_create,news.create_by,news.picture,news.cat_id,news.is_slide,news.count_number,cat_list.name,cat_list.parent_id,user.username,user.fullname,user.active,user.id_rank FROM news  INNER JOIN cat_list ON cat_list.id = news.cat_id INNER JOIN user ON news.create_by = user.id  WHERE news.id = "
				+ id_News;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				int id = rs.getInt("news.id");
				String name_News = rs.getString("news.name");
				String preview_News = rs.getString("news.preview");
				String detail_News = rs.getString("news.detail");
				String date_Create = "";
				Date tempDate = rs.getDate("news.date_create");
				date_Create = sdf.format(tempDate);
				int Create_By = rs.getInt("news.create_by");
				String picture = rs.getString("news.picture");
				int cat_Id = rs.getInt("news.cat_id");
				int id_slide = rs.getInt("news.is_slide");
				int count_number = rs.getInt("count_number");
				String name_Cat = rs.getString("cat_list.name");
				int id_Parent = rs.getInt("cat_list.parent_id");
				String username = rs.getString("user.username");
				String fullname = rs.getString("user.fullname");
				int id_Active = rs.getInt("user.active");
				int id_Rank = rs.getInt("user.id_rank");
				item = new News(id, name_News, preview_News, detail_News, date_Create, Create_By, picture, cat_Id,
						id_slide, count_number,
						new User(Create_By, username, null, fullname, null, new Rank(id_Rank, null), id_Active),
						new Category(cat_Id, name_Cat, id_Parent));
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

	public ArrayList<News> getItemRelatedNews(int id_Cat, int id_News) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		ArrayList<News> items = new ArrayList<News>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT news.id,news.name,news.preview,news.detail, news.date_create, news.create_by,news.picture,news.cat_id,news.is_slide,news.count_number,cat_list.name,cat_list.parent_id,user.username,user.fullname,user.active,user.id_rank FROM news INNER JOIN cat_list ON cat_list.id = news.cat_id INNER JOIN user ON user.id = news.create_by WHERE cat_list.id = "
				+ id_Cat + " && news.id!=" + id_News + " ORDER BY news.id DESC LIMIT 3";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("news.id");

				String name = rs.getString("news.name");
				String preview_Main = "";
				String preview = rs.getString("news.preview");
				int count = preview.length();
				System.out.println(count);
				if (count <= 50) {
					preview_Main = preview;
				} else {
					preview_Main = preview.substring(0,50) + "...";
				}
				String detail = rs.getString("news.detail");
				String date_create = "";
				Date tempDate = rs.getDate("news.date_create");
				date_create = sdf.format(tempDate);
				int create_by = rs.getInt("news.create_by");
				String picture = rs.getString("news.picture");
				int cat_Id = rs.getInt("news.cat_id");
				int id_Slide = rs.getInt("news.is_slide");
				int count_Views = rs.getInt("news.count_number");
				String name_Cat = rs.getString("cat_list.name");
				int id_Parent = rs.getInt("cat_list.parent_id");
				String username = rs.getString("user.username");
				String fullname = rs.getString("user.fullname");
				int id_Active = rs.getInt("user.active");
				int id_Rank = rs.getInt("user.id_rank");
				News item = new News(id, name, preview_Main, detail, date_create, create_by, picture, cat_Id, id_Slide,
						count_Views,
						new User(create_by, username, null, fullname, null, new Rank(id_Rank, null), id_Active),
						new Category(cat_Id, name_Cat, id_Parent));
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
