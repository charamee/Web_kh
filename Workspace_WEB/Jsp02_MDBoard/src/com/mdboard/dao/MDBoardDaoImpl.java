package com.mdboard.dao;
import static com.mdboard.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mdboard.dto.MDBoardDto;

public class MDBoardDaoImpl implements MDBoardDao {

	@Override
	public List<MDBoardDto> list() {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MDBoardDto> list = new ArrayList<MDBoardDto>();
		
		try {
			
			pstm = con.prepareStatement(SELECT_LIST);
			System.out.println("3. query  준비: "+SELECT_LIST);
			rs = pstm.executeQuery();
			while(rs.next()) {
				MDBoardDto dto = new MDBoardDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5));
//				dto.setSeq(rs.getInt(1));
//				dto.setWriter(rs.getString(2));
//				dto.setTitle(rs.getString(3));
//				dto.setContent(rs.getString(4));
//				dto.setRegdate(rs.getDate(5));
				
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
	public MDBoardDto selectOne(int seq) {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MDBoardDto dto = null;
		
		try {
			pstm= con.prepareStatement(SELECT_ONE);
			pstm.setInt(1, seq);
			
			rs=pstm.executeQuery();
			while(rs.next()) {
				dto=new MDBoardDto();
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
	public int insert(MDBoardDto dto) {
		
		Connection con = getConnection();
		PreparedStatement pstm =null;
		int res = 0 ; 
		
		try {
			pstm = con.prepareStatement(INSERT_SQL);
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
	
	@Override
	public int update(MDBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm =null;
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
		int res = 0; 
		
		try {
			pstm = con.prepareStatement(DELETE_SQL);
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

	@Override
	public int muldel(String [] seqs) {
		//한번에 여러개를 받을거기때문에 배열타입으로 파라미터를 받는다 
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0 ; 
		
		int cnt[] ;
		try {
			pstm = con.prepareStatement(DELETE_SQL);
			for(int i = 0 ; i<seqs.length;i++) {
				pstm.setString(1, seqs[i]);
				pstm.addBatch(); // 여러개 전달받은 seqs들을 저장해 놓는다 
				System.out.println("3. qeury 준비 : "+DELETE_SQL+"(삭제할 번호:" + seqs[i] +")");
			}
			cnt=pstm.executeBatch();
			// executeBatch() 명령을 성공하면 -2를 실패하면 -3을 리턴하여 배열로 리턴된다. {-2,-2,-3,-2,-2}
			
			for(int i=0; i<cnt.length;i++) {
				if(cnt[i] ==-2) {
					res++;
				}
				
			}
			if(seqs.length == res) {
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
