package com.board02.dao;

import static com.board02.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.board02.dto.Board02Dto;

public class Board02Dao {
	
	public static List<Board02Dto> mylist(){
		
		Connection con = getConnection();
		String sql = " SELECT SQL, WRITER, TITLE, CONTENT, REGDATE"
				+ " FROM BOARD02"
				+ " ORDER BY SQL DESC ";
		
		Statement stmt = null;
		ResultSet rs = null; 
		
		List<Board02Dto> list = new ArrayList<Board02Dto>();
		
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Board02Dto dto = new Board02Dto();
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
			close(con);
		}
		
		return list;
		
	}
	
	public Board02Dto selectOne(int seq) {
		
		Connection con = getConnection();
		 String sql = " SELECT SEQ,WRITER,TITLE,CONTENT,REGDATE "
		 		+ " FROM BOARD02 "
		 		+ " WHERE SEQ = ?";
		 
		 PreparedStatement pstm = null;
		 ResultSet rs = null;
		 Board02Dto dto = new Board02Dto();
		 
		 try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1,seq);
			
			rs=pstm.executeQuery();
			while(rs.next()) {
				
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
			close(con);
		}
		 
		return dto;
	}

	
	public int insert(Board02Dto dto) {
		
		Connection con = getConnection();
		String sql = " INSERT INTO BOARD02 "
				+ " VALUES(BOARDSEQ02.NEXTVAL,?,?,?,SYSDATE) ";
		
		PreparedStatement pstm = null; 
		int res = 0 ; 
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			
			res= pstm.executeUpdate();
			
			if(res>0) {
				commit(con);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}
	
	public int update(Board02Dto dto) {
		Connection con = getConnection();
		String sql = " UPDATE BOARD02 "
				+ " SET WRITER = ? , TITLE=? , CONTENT = ? "
				+ " WHERE SEQ = ? ";
		
		PreparedStatement pstm = null;
		int res= 0 ; 
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			pstm.setInt(4, dto.getSeq());
			
			res = pstm.executeUpdate();
			if(res>0) {
				commit(con);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		return res ; 
	}
	
	public int delete(int seq) {
		Connection con = getConnection();
		String sql = " DELETE FROM BOARD02 "
				+ " WHERE SEQ = ? ";
		PreparedStatement pstm = null;
		int res = 0 ; 
		
		try {
			pstm= con.prepareStatement(sql);
			pstm.setInt(1, seq);
			
			res = pstm.executeUpdate();
			if(res>0) {
				commit(con);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		}
		
		return res; 
	}
}
