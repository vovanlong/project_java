package model.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Bean.Rank;
import util.DBConnectionUtil;

public class RankDao {
	private Statement st;
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pst;

	public ArrayList<Rank> getItems() {
		ArrayList<Rank> items = new ArrayList<Rank>();
		conn = DBConnectionUtil.getConnection();
		String sql = "SELECT id,name FROM rank";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Rank item = new Rank(id, name);
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
