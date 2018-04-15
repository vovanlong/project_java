package model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Bean.Category;
import util.DBConnectionUtil;
import util.DeFine;

public class CategoryDao {
	private Statement st;
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pst;

	public ArrayList<Category> getItem() {
		ArrayList<Category> items = new ArrayList<Category>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT id,name,parent_id FROM cat_list";
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

	public ArrayList<Category> getParentCategory() {
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
				CategoryDao categoryDao = new CategoryDao();
				ArrayList<Category> subCategories = categoryDao.getChildCategory(id);
				Category item = new Category(id, name, id_Parent, subCategories);
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

	public ArrayList<Category> getChildCategory(int parent_id) {
		ArrayList<Category> items = new ArrayList<Category>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT id,name,parent_id FROM cat_list where parent_id = " + parent_id;
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

	public int countCat() {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT COUNT(*) AS sumCats FROM cat_list";

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				result = rs.getInt("sumCats");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null && rs != null && conn != null) {
					st.close();
					rs.close();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public ArrayList<Category> getItemPaination(int offset) {
		ArrayList<Category> items = new ArrayList<Category>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT id,name,parent_id FROM cat_list LIMIT " + offset + "," + DeFine.ROW_COUNT_PUBLIC;
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

	public ArrayList<Category> getItemSearch(String search, int offset) {
		ArrayList<Category> items = new ArrayList<Category>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT id,name,parent_id FROM cat_list WHERE name LIKE '%" + search + "%' LIMIT " + offset + ","
				+ DeFine.ROW_COUNT_PUBLIC;
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

	public Object checkCategory(String name_Cat, int id_Parent) {
		conn = DBConnectionUtil.getConnection();
		Category categoy = null;
		String sql = "SELECT id,name,parent_id FROM cat_list WHERE name = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name_Cat);
			rs = pst.executeQuery();
			if (rs.next()) {
				categoy = new Category(0, rs.getString("name"), 0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			if (pst != null && rs != null && conn != null) {
				try {
					pst.close();
					rs.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return categoy;
	}

	public int addItemCat(Category category) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "INSERT INTO cat_list (name,parent_id) VALUES(?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, category.getName());
			pst.setInt(2, category.getId_Parent());
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

	public Category getItem(int id_Cat) {
		conn = DBConnectionUtil.getConnection();
		Category categoy = null;
		String sql = "SELECT id,name,parent_id FROM cat_list WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_Cat);
			rs = pst.executeQuery();
			if (rs.next()) {
				categoy = new Category(id_Cat, rs.getString("name"), rs.getInt("parent_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			if (pst != null && rs != null && conn != null) {
				try {
					pst.close();
					rs.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return categoy;
	}

	public int editItem(Category item) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "UPDATE cat_list SET name = ? , parent_id =? WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, item.getName());
			pst.setInt(2, item.getId_Parent());
			pst.setInt(3, item.getId());
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

	public int delItem(int idDel) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "DELETE FROM cat_list WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idDel);
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

}
