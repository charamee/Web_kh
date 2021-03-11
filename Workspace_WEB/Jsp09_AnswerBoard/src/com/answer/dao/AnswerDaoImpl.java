package com.answer.dao;
import static com.answer.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.answer.dto.AnswerDto;

public class AnswerDaoImpl implements AnswerDao {

	@Override
	public List<AnswerDto> selectList() {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<AnswerDto> list = new ArrayList<AnswerDto>();
		
		try {
			////BOARDNO GROUPNO GROUPSEQ TITLETAB  TITLE CONTENT WRITER REGDATE
			pstm=con.prepareStatement(SELECT_LIST_SQL);
			System.out.println("3. query 준비: "+SELECT_LIST_SQL);
			rs = pstm.executeQuery();
			while(rs.next()) {
				AnswerDto dto = new AnswerDto(rs.getInt(1),rs.getInt(2),rs.getInt(3),
						rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8));
				
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
	public AnswerDto selectOne(int boardno) {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		AnswerDto dto = new AnswerDto(); 
		
		try {
			pstm = con.prepareStatement(SELECT_ONT_SQL);
			pstm.setInt(1, boardno);
			System.out.println("3. query 준비: "+SELECT_ONT_SQL);
			
			rs=pstm.executeQuery();
			System.out.println("4.query 실행 및 리턴");
		////BOARDNO GROUPNO GROUPSEQ TITLETAB  TITLE CONTENT WRITER REGDATE
			while(rs.next()) {
				dto.setBoardno(rs.getInt(1));
				dto.setGroupno(rs.getInt(2));
				dto.setGroupseq(rs.getInt(3));
				dto.setTitletab(rs.getInt(4));
				dto.setTitle(rs.getString(5));
				dto.setContent(rs.getString(6));
				dto.setWriter(rs.getString(7));
				dto.setRegdate(rs.getDate(8));
				
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
	public int boardInsert(AnswerDto dto) {
		
		return 0;
	}

	@Override
	public int boardUpdate(AnswerDto dto) {
		
		return 0;
	}

	@Override
	public int boardDelete(int boardno) {
		
		return 0;
	}

	@Override
	public int answerUpdate(int parentBoardNo) {
		Connection con = getConnection(); 
		PreparedStatement pstm = null;
		int res = 0 ; 
		
		try {
			pstm = con.prepareStatement(ANSWER_UPDATE_SQL);
			pstm.setInt(1, parentBoardNo);
			pstm.setInt(2, parentBoardNo);
			System.out.println("3. query 준비: "+ ANSWER_UPDATE_SQL);
			
			 res = pstm.executeUpdate();
			 if(res>0) {
				 commit(con);
			 }
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			System.out.println("5.끝!");
		}
		
		return res;
	}

	@Override
	public int answerInsert(AnswerDto dto) {
		Connection con = getConnection(); 
		PreparedStatement pstm = null;
		int res = 0 ; 
		
		try {
			pstm = con.prepareStatement(ANSWER_INSERT_SQL);
			pstm.setInt(1, dto.getBoardno());
			pstm.setInt(2, dto.getBoardno());
			pstm.setInt(3, dto.getBoardno());
			pstm.setString(4, dto.getTitle());
			pstm.setString(5, dto.getContent());
			pstm.setString(6, dto.getWriter());
			System.out.println("3. query 준비  : "+ ANSWER_INSERT_SQL);
			res = pstm.executeUpdate();
			if(res>0) {
				commit(con);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			System.out.println("5.끝!");
		}
		
		return res;
	}

}
