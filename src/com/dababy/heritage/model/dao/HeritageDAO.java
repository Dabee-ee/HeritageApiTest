package com.dababy.heritage.model.dao;

import static com.dababy.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.dababy.heritage.model.vo.Heritage;

public class HeritageDAO {
	
		private Properties prop;
		
		public HeritageDAO() {

			prop = new Properties();
			
			String filePath = HeritageDAO.class
					          .getResource("/config/heritage.properties")
					          .getPath();
			
			try {
				prop.load( new FileReader(filePath));
				
			} catch (IOException e) {
			
				e.printStackTrace();
			} 
		}
		
		
		
		public int insertHeritage(Connection con, Heritage heri) {
			
			int result = 0;
			PreparedStatement ps = null;
			
			String sql = prop.getProperty("insertHeritage");
			
			try {
				
				ps = con.prepareStatement(sql);
				
				ps.setString(1, heri.getName());
				ps.setString(2, heri.getEvents());
				ps.setString(3, heri.getSerial());
				ps.setString(4, heri.getZipcode());
				ps.setString(5, heri.getLng());
				ps.setString(6, heri.getLat());
				
				
				result = ps.executeUpdate();
			
			} catch (SQLException e) {
			
				e.printStackTrace();
				
			} finally {
				close(ps);
			}
				
			return result;
		}

		
		
}


