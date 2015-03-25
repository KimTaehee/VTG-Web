package com.videogathering.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.videothegathering.vo.PlayitemVO;


public class VtgDAO {

	Connection connection;
	
	public void setConnection(Connection connection){
		
		this.connection = connection;
	}
	
	public int insertPlayitem(PlayitemVO item) throws Exception {
		Statement stmt = null;
		int result = 0;
		
		
		try {
			stmt = connection.createStatement();
			result = stmt.executeUpdate(
					"INSERT into vtg(URL, Title, realMP4, Date) "
					+ "values('"
					+ item.getURL()
					+ "', '"
					+ item.getTitle()
					+ "', '"
					+ item.getRealMP4()
					+ "', now())");
		
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {if (stmt != null) stmt.close();} catch (Exception e) {}
		}
		return result;
	}
	public List<PlayitemVO> selectList() throws Exception {
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(
					"SELECT id, URL, Title, realMP4, date " +
							"FROM vtg " + 
							"ORDER BY id ASC ");
			
			ArrayList<PlayitemVO> playitem = new ArrayList<PlayitemVO>();
		
			while (rs.next()) {
				playitem.add(new PlayitemVO(rs.getInt("id"), rs.getString("URL"), rs.getString("Title"), rs.getString("realMP4"), rs.getDate("date")));
			}
			return playitem;
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {if (rs != null) rs.close();} catch (Exception e) {}
			try {if (stmt != null) stmt.close();} catch (Exception e) {}
		}
	}
}
	
