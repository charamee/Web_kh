package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.db.JDBCTemplate.*;
import static com.mvc.db.JDBCTemplate.commit;

public class BoardDao {
	public int insertBoard() {
		Connection con = getConnection();
		//제목, 작성자,첨부파일,내용
		String sql=" INSERT INTO BOARD "
				+ " VALUES(?,?,?) ";
		PreparedStatement pstm = null;
		int res = 0 ; 
		
		try {
			pstm=con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getWriter());
			pstm.setString(3, dto.getContent());
			
			res = pstm.executeUpdate();
			if(res>0) {
				commit(con);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return res;
		
	}
	

}
