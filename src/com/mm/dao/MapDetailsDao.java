package com.mm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mm.model.mapping_details;

public class MapDetailsDao {
	static Statement stmt;
	static Connection con;

	ResourceBundle bundle = ResourceBundle.getBundle("TopScoreAccess");
	String conURL = bundle.getString("conURL");
	String userName = bundle.getString("userName");
	String password = bundle.getString("password");
	String driver = bundle.getString("driver");

	public void createConnection() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(conURL, userName, password);
			stmt = con.createStatement();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<HashMap> getSmallCarouselDetails() {
		createConnection();
		ArrayList<HashMap> al = new ArrayList<HashMap>();
		String sql = "select * from mapping_details";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				HashMap hm = new HashMap();
				hm.put("sl_no", "" + rs.getInt("sl_no"));
				hm.put("state", "" + rs.getString("state"));
				hm.put("state_id", rs.getString("state_id"));
				hm.put("state_colour", rs.getString("state_colour"));
				hm.put("contestant_1", rs.getString("contestant_1"));
				hm.put("contestant_2", rs.getString("contestant_2"));
				hm.put("contestant_3", rs.getString("contestant_3"));
				hm.put("contestant_1_percent",
						rs.getString("contestant_1_percent"));
				hm.put("contestant_2_percent",
						rs.getString("contestant_2_percent"));
				hm.put("contestant_3_percent",
						rs.getString("contestant_3_percent"));
				hm.put("winner", rs.getString("winner"));
				hm.put("electoral", rs.getString("electoral"));
				al.add(hm);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					con.close();
			} catch (SQLException se) {
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return al;
	}

	public boolean MappingUpdate(String[] state_id, String[] state_colour,
			String[] contestant_1, String[] contestant_2,
			String[] contestant_3, String[] contestant_percent_1,
			String[] contestant_percent_2, String[] contestant_percent_3,
			String[] electoral) {
		// TODO Auto-generated method stub
		boolean updation_status = true;
		for (int i = 0; i < state_id.length; i++) {

			updation_status = update_mapping_entry(state_id[i],
					state_colour[i], contestant_1[i], contestant_2[i],
					contestant_3[i], contestant_percent_1[i],
					contestant_percent_2[i], contestant_percent_3[i],
					electoral[i]);
		}

		return updation_status;
	}

	private boolean update_mapping_entry(String state_id, String state_colour,
			String contestant_1, String contestant_2, String contestant_3,
			String contestant_percent_1, String contestant_percent_2,
			String contestant_percent_3, String electoral) {

		createConnection();
		boolean updation_status = true;
		// java.util.Date today = new java.util.Date();
		// return new java.sql.Date(today.getTime());
		try {
			PreparedStatement updateemp = con
					.prepareStatement("UPDATE mapping_details SET state_colour=? , contestant_1=?, contestant_2=? , contestant_3=? , contestant_1_percent=?, contestant_2_percent=?, contestant_3_percent=? , electoral=? WHERE state_id=?");

			updateemp.setString(1, state_colour);
			updateemp.setString(2, contestant_1);
			updateemp.setString(3, contestant_2);
			updateemp.setString(4, contestant_3);
			updateemp.setString(5, contestant_percent_1);
			updateemp.setString(6, contestant_percent_2);
			updateemp.setString(7, contestant_percent_3);
			updateemp.setString(8, electoral);
			updateemp.setString(9, state_id);
			int status = updateemp.executeUpdate();

			if (status != 1) {
				// System.out.println("inserted successfully");
				updation_status = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					con.close();
			} catch (SQLException se) {
			}// do nothing
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return updation_status;

	}

	

}
