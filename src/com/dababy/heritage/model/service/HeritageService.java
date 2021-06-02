package com.dababy.heritage.model.service;

import static com.dababy.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.dababy.heritage.model.dao.HeritageDAO;
import com.dababy.heritage.model.vo.Heritage;

public class HeritageService {

		private Connection con;
		private HeritageDAO dao = new HeritageDAO();
		
		
		// 공공데이터 DB 저장
		public int insertHeritage(Heritage heri) {
			con = getConnection();
			
			
		
			// insert Heritage
			int result = dao.insertHeritage(con, heri);
			
		
			
			if( result > 0) {
				commit(con);
			} else {    // result의 결과값이 0이라면 rollback
					rollback(con); 
			} 

			close(con);
			
			return result;

		}

	}



