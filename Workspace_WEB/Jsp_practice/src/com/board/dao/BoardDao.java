package com.board.dao;

import static com.board.db.JDBCTemplate.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.board.dto.BoardDto;

public class BoardDao {
	
	public List<BoardDto> mylist(){
		
		Connection con = getConnection();
		
		String sql=" SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE "
				+ " FROM BOARD "
				+ " ORDER BY SEQ DESC ";
		
		Statement stmt = null;
		ResultSet rs =null;
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BoardDto dto = new BoardDto();
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
	
	public BoardDto selectOne(int seq) {
		Connection con = getConnection();
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE "
				+ " FROM BOARD "
				+ " WHERE SEQ = ? ";
		
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		BoardDto dto= new BoardDto();
		
		
		try {
			pstm= con.prepareStatement(sql);
			pstm.setInt(1, seq);
			
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
	
	public int insert(BoardDto dto) {
		
		Connection con = getConnection();
		String sql=" INSERT INTO BOARD "
				+ " VALUES(BOARDSEQ.NEXTVAL,?,?,?,SYSDATE)";
		
		PreparedStatement pstm = null;
		int res = 0 ;
		
		try {
			pstm= con.prepareStatement(sql);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			
			res=pstm.executeUpdate();
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
	
	public int myupdate(BoardDto dto) {
		
		Connection con= getConnection();
		String sql=" UPDATE BOARD "
				+ " SET TITLE=? , CONTENT=? "
				+ " WHERE SEQ= ? ";
		
		PreparedStatement pstm = null;
		int res = 0;
		 
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			
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
	
	public int mydelete(BoardDto dto) {
		
		Connection con = getConnection();
		String sql=" DELETE FROM BOARD"
				+ " WHERE SEQ= ? ";
		
		PreparedStatement pstm = null;
		int res= 0 ; 
		try {
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, dto.getSeq());
			
			res=pstm.executeUpdate();
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
