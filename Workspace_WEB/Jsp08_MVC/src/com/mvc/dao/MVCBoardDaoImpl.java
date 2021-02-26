package com.mvc.dao;

import static com.mvc.db.JDBCTemplate.close;
import static com.mvc.db.JDBCTemplate.commit;
import static com.mvc.db.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.dto.MVCBoardDto;

public class MVCBoardDaoImpl implements MVCBoardDao {

	@Override
	public List<MVCBoardDto> selectlist() {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<MVCBoardDto> list = new ArrayList<MVCBoardDto>();
		
		try {
			pstm = con.prepareStatement(SELECT_LIST_SQL);
			
			rs=pstm.executeQuery();
			while(rs.next()) {
				MVCBoardDto dto = new MVCBoardDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5));
			
			list.add(dto);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
			close(con);
		}
				

		return list;
	}

	@Override
	public MVCBoardDto selectOne(int seq) {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MVCBoardDto dto = new MVCBoardDto();
		
		try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);
			pstm.setInt(1, seq);
			
			rs = pstm.executeQuery();
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

	@Override
	public int insert(MVCBoardDto dto) {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0 ; 
		
		try {
			pstm = con.prepareStatement(INSERT_SQL);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			
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

	@Override
	public int update(MVCBoardDto dto) {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res= 0 ; 
		
		try {
			pstm = con.prepareStatement(UPDATE_SQL);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			
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

	@Override
	public int delete(int seq) {
		
		Connection con = getConnection();
		PreparedStatement pstm = null; 
		int res = 0 ; 
		
		try {
			pstm = con.prepareStatement(DELETE_SQL);
			pstm.setInt(1, seq);
			
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

	@Override
	public int muldelete(String[] seqs) {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0 ; 
		int[] cnt; 
		
		try {
			pstm= con.prepareStatement(DELETE_SQL);
			for(int i= 0 ; i<seqs.length;i++) {
				pstm.setString(1, seqs[i]);
				pstm.addBatch();
			}
			
			cnt = pstm.executeBatch();
			
			for(int i=0; i<cnt.length;i++) {
				if(cnt[i]==-2) {
					res++;
				}
			}
			if(cnt.length==res) {
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
