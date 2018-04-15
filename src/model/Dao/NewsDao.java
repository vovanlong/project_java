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
import util.DeFine;

public class NewsDao {
	private Statement st;
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pst;

	public ArrayList<News> getItems() {
		ArrayList<News> items = new ArrayList<News>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT news.id,news.name,news.preview,news.detail,news.date_create,news.create_by,news.picture,news.is_slide,news.count_number,cat_list.id,cat_list.name,cat_list.parent_id,user.id,user.username,user.fullname "
				+ "FROM news INNER JOIN cat_list ON news.cat_id = cat_list.id INNER JOIN user ON news.create_by = user.id";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id_News = rs.getInt("news.id");
				String name_News = rs.getString("news.name");
				String preview_News = rs.getString("news.preview");
				String detail_News = rs.getString("news.detail");
				String date_Create = rs.getString("news.date_create");
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
				News item = new News(id_News, name_News, preview_News, detail_News, date_Create, create_By,
						picture_News, id_Cat, id_Slide, count_Number,
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

	public int countNews() {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT COUNT(*) AS countnews FROM news INNER JOIN user ON user.id = news.create_by INNER JOIN cat_list ON cat_list.id = news.cat_id";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				result = rs.getInt("countnews");
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
		return result;
	}

	public ArrayList<News> getItemsPagination(int offset) {
		ArrayList<News> items = new ArrayList<News>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT news.id,news.name,news.preview,news.detail,news.date_create,news.create_by,news.picture,news.is_slide,news.count_number,cat_list.id,cat_list.name,cat_list.parent_id,user.id,user.username,user.fullname "
				+ "FROM news INNER JOIN cat_list ON news.cat_id = cat_list.id INNER JOIN user ON news.create_by = user.id ORDER BY news.id DESC LIMIT "
				+ offset + "," + DeFine.ROW_COUNT_PUBLIC;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id_News = rs.getInt("news.id");
				String name_News = rs.getString("news.name");
				String preview_News = rs.getString("news.preview");
				String detail_News = rs.getString("news.detail");
				String date_Create = rs.getString("news.date_create");
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
				News item = new News(id_News, name_News, preview_News, detail_News, date_Create, create_By,
						picture_News, id_Cat, id_Slide, count_Number,
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

	public ArrayList<News> getItemsBySearch(String search) {
		ArrayList<News> items = new ArrayList<News>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT news.id,news.name,news.preview,news.detail,news.date_create,news.create_by,news.picture,news.is_slide,news.count_number,cat_list.id,cat_list.name,cat_list.parent_id,user.id,user.username,user.fullname FROM news INNER JOIN cat_list ON news.cat_id = cat_list.id INNER JOIN user ON news.create_by = user.id WHERE news.name LIKE '%"
				+ search + "%' ";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id_News = rs.getInt("news.id");
				String name_News = rs.getString("news.name");
				String preview_News = rs.getString("news.preview");
				String detail_News = rs.getString("news.detail");
				String date_Create = rs.getString("news.date_create");
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
				News item = new News(id_News, name_News, preview_News, detail_News, date_Create, create_By,
						picture_News, id_Cat, id_Slide, count_Number,
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

	public int addItem(News objNews) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "INSERT INTO news(name,preview,detail,date_create,create_by,picture,cat_id,is_slide,count_number) VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objNews.getName());
			pst.setString(2, objNews.getPreview());
			pst.setString(3, objNews.getDetail());
			pst.setString(4, objNews.getDate_create());
			pst.setInt(5, objNews.getCreate_by());
			pst.setString(6, objNews.getPicture());
			pst.setInt(7, objNews.getId_Cat());
			pst.setInt(8, objNews.getId_Slide());
			pst.setInt(9, objNews.getCount_number());
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

	public News getItemById(int id_Edit) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		News item = null;
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT news.id,news.name,news.preview,news.detail,news.date_create,news.create_by,news.picture,news.is_slide,news.count_number,cat_list.id,cat_list.name,cat_list.parent_id,user.id,user.username,user.fullname "
				+ "	FROM news INNER JOIN cat_list ON news.cat_id = cat_list.id INNER JOIN user ON news.create_by = user.id WHERE news.id = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_Edit);
			rs = pst.executeQuery();
			if (rs.next()) {
				int id_News = rs.getInt("news.id");
				String name_News = rs.getString("news.name");
				String preview_News = rs.getString("news.preview");
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
				item = new News(id_News, name_News, preview_News, detail_News, date_Create, create_By, picture_News,
						id_Cat, id_Slide, count_Number,
						new User(id_User, name_Username, null, name_Fullname, null, new Rank(0, null), 0),
						new Category(id_Cat, name_Cat, id_Parent));
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

	public int editItem(News news) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "UPDATE news SET name=?,preview=?,detail=?,date_create=?,create_by=?,picture=?,cat_id=?,is_slide=?,count_number=? WHERE news.id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, news.getName());
			pst.setString(2, news.getPreview());
			pst.setString(3, news.getDetail());
			pst.setString(4, news.getDate_create());
			pst.setInt(5, news.getCreate_by());
			pst.setString(6, news.getPicture());
			pst.setInt(7, news.getId_Cat());
			pst.setInt(8, news.getId_Slide());
			pst.setInt(9, news.getCount_number());
			pst.setInt(10, news.getId());
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

	public int delItem(int id_Del) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "DELETE FROM news WHERE news.id =?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_Del);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		if (pst != null && conn != null) {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
