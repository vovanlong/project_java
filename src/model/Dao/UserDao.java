package model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Bean.Rank;
import model.Bean.User;
import util.DBConnectionUtil;
import util.DeFine;

public class UserDao {
	private Statement st;
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pst;

	public ArrayList<User> getItem() {
		ArrayList<User> items = new ArrayList<User>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT user.id,user.username, user.password,user.fullname,user.active,user.email,user.id_rank,rank.name FROM user INNER JOIN rank ON user.id_rank = rank.id";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("user.id");
				String username = rs.getString("user.username");
				String password = rs.getString("user.password");
				String fullname = rs.getString("user.fullname");
				String email = rs.getString("user.email");
				int id_Rank = rs.getInt("user.id_rank");
				String name_Rank = rs.getString("name");
				int active = rs.getInt("user.active");
				User item = new User(id_Rank, username, password, fullname, email, new Rank(id_Rank, name_Rank),
						active);
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && st != null && conn != null) {
					rs.close();
					st.close();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;
	}

	public int countCat() {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT COUNT(*) AS sumUsers FROM user";

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				result = rs.getInt("sumUsers");
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
		return result;
	}

	public ArrayList<User> getItemPaination(int offset) {
		ArrayList<User> items = new ArrayList<User>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT user.id,user.username, user.password,user.fullname,user.active,user.email,rank.id,rank.name FROM user INNER JOIN rank ON user.id_rank = rank.id LIMIT "
				+ offset + "," + DeFine.ROW_COUNT_PUBLIC;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("user.id");
				String username = rs.getString("user.username");
				String password = rs.getString("user.password");
				String fullname = rs.getString("user.fullname");
				String email = rs.getString("user.email");
				int id_Rank = rs.getInt("rank.id");
				String name_Rank = rs.getString("rank.name");
				int active = rs.getInt("user.active");
				User item = new User(id, username, password, fullname, email, new Rank(id_Rank, name_Rank), active);
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && st != null && conn != null) {
					rs.close();
					st.close();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;
	}

	public ArrayList<User> getItemPaination(String search, int offset) {
		ArrayList<User> items = new ArrayList<User>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT user.id,user.username, user.password,user.fullname,user.active,user.email,user.id_rank,rank.name FROM user INNER JOIN rank ON user.id_rank = rank.id WHERE user.fullname LIKE '%"
				+ search + "%' OR user.username LIKE '%" + search + "%' LIMIT " + offset + ","
				+ DeFine.ROW_COUNT_PUBLIC;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("user.id");
				String username = rs.getString("user.username");
				String password = rs.getString("user.password");
				String fullname = rs.getString("fullname");
				String email = rs.getString("user.email");
				int id_Rank = rs.getInt("user.id_rank");
				String name_Rank = rs.getString("name");
				int active = rs.getInt("user.active");
				User item = new User(id_Rank, username, password, fullname, email, new Rank(id_Rank, name_Rank),
						active);
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && st != null && conn != null) {
					rs.close();
					st.close();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;
	}

	public Object checkUserName(User item) {
		User user = null;
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT id,username,password,active,fullname,email,id_rank FROM user WHERE username = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, item.getUsername());
			rs = pst.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String fullname = rs.getString("fullname");
				String email = rs.getString("email");
				int id_Rank = rs.getInt("id_rank");
				int active = rs.getInt("active");
				user = new User(id, username, password, fullname, email, new Rank(id_Rank, null), active);
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
		return user;
	}

	public int addItemUser(User item) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "INSERT INTO user(username,password,fullname,email,id_rank,active) VALUES (?,?,?,?,?,?); ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, item.getUsername());
			pst.setString(2, item.getPassword());
			pst.setString(3, item.getFullname());
			pst.setString(4, item.getEmail());
			pst.setInt(5, item.getRank().getId());
			pst.setInt(6, item.getActive());
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

	public User getItemOld(int id_User) {
		conn = DBConnectionUtil.getConnection();
		User user = null;
		String sql = "SELECT id,username,password,fullname,email,id_rank,active FROM user WHERE id = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_User);
			rs = pst.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String fullname = rs.getString("fullname");
				String email = rs.getString("email");
				int id_Rank = rs.getInt("id_rank");
				int active = rs.getInt("active");
				user = new User(id, username, password, fullname, email, new Rank(id_Rank, null), active);
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
		return user;
	}

	public int editUser(User objUser) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "UPDATE user SET username = ?, password =?,fullname=?,email=?,id_rank=?,active=? WHERE id=? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objUser.getUsername());
			pst.setString(2, objUser.getPassword());
			pst.setString(3, objUser.getFullname());
			pst.setString(4, objUser.getEmail());
			pst.setInt(5, objUser.getRank().getId());
			pst.setInt(6, objUser.getActive());
			pst.setInt(7, objUser.getId());
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

	public User checkLogin(String username, String password) {
		User objUser = null;
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT user.id,user.username,user.password,user.fullname,user.email,user.id_rank,user.active,rank.name FROM user INNER JOIN rank ON user.id_rank = rank.id WHERE username = ? AND password = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if (rs.next()) {
				objUser = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("fullname"), rs.getString("email"),
						new Rank(rs.getInt("id_rank"), rs.getString("rank.name")), rs.getInt("active"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && pst != null && conn != null) {
					rs.close();
					pst.close();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return objUser;
	}

	public int editActive(int active, int id) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "UPDATE user SET active = ? WHERE id =?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, active);
			pst.setInt(2, id);
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

	public int delItem(int id_del) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "DELETE FROM user WHERE user.id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_del);
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

	/*
	 * public int editActive(int active, int id) { int result = 0; conn =
	 * DBConnectionUtil.getConnection(); String sql =
	 * "UPDATE user SET active=? WHERE id = ?"; try { pst =
	 * conn.prepareStatement(sql); pst.setInt(1, active); pst.setInt(2, id); result
	 * = pst.executeUpdate(); } catch (SQLException e) { e.printStackTrace(); }
	 * catch (NullPointerException e) { e.printStackTrace(); } finally { try { if
	 * (rs != null && pst != null && conn != null) { rs.close(); pst.close();
	 * conn.close(); } } catch (SQLException e) { e.printStackTrace(); } } return
	 * result; }
	 */

}
