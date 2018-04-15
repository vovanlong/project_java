package model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Bean.Advertisement;
import util.DBConnectionUtil;

public class AdvertisementDao {
	private Statement st;
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pst;

	public ArrayList<Advertisement> getItem() {
		ArrayList<Advertisement> items = new ArrayList<Advertisement>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT id,name,picture,active,link FROM adtech";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Advertisement adv = new Advertisement(rs.getInt("id"), rs.getString("name"), rs.getString("picture"),
						rs.getInt("active"), rs.getString("link"));
				items.add(adv);
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

	public int editActive(int id, int active) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "UPDATE adtech SET active = ? WHERE id = ?";
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

	public int addItem(Advertisement adv) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "INSERT INTO adtech(name,picture,active,link) VALUES(?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, adv.getName());
			pst.setString(2, adv.getPicture());
			pst.setInt(3, adv.getActive());
			pst.setString(4, adv.getLink());
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

	public Advertisement getItemById(int id_Adv) {
		Advertisement objAdv = null;
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT id,name,picture,active,link FROM adtech WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_Adv);
			rs = pst.executeQuery();
			if (rs.next()) {
				objAdv = new Advertisement(rs.getInt("id"), rs.getString("name"), rs.getString("picture"),
						rs.getInt("active"), rs.getString("link"));
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
		return objAdv;
	}

	public int editItem(Advertisement oldAdv) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "UPDATE adtech SET name =?, picture =?, active=?, link=? WHERE id = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, oldAdv.getName());
			pst.setString(2, oldAdv.getPicture());
			pst.setInt(3, oldAdv.getActive());
			pst.setString(4, oldAdv.getLink());
			pst.setInt(5, oldAdv.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null && conn != null) {
					pst.close();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int delItem(int id_del) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String sql = "DELETE FROM adtech WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id_del);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null && conn != null) {
					pst.close();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
