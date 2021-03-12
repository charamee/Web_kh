package com.muldel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.muldel.db.SqlMapConfig;
import com.muldel.dto.MDBoardDto;

public class MDBoardDaoImpl extends SqlMapConfig implements MDBoardDao {
	// 구분자가 있어야해서 마지막에 . 을 넣었다.
	private String namespace = "com.muldel.mapper.";
	
	@Override
	public List<MDBoardDto> selectlist() {
		
		List<MDBoardDto> list = new ArrayList<MDBoardDto>();
		
		SqlSession session = null;
		try {
			// 오토 커밋, 기본값은 true
			session = getSqlSessionFactory().openSession(false);
			list = session.selectList(namespace+"selectList");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public MDBoardDto selectOne(int seq) {
		
		return null;
	}

	@Override
	public int insert(MDBoardDto dto) {
		
		return 0;
	}

	@Override
	public int update(MDBoardDto dto) {
		
		return 0;
	}

	@Override
	public int delete(int seq) {
		
		return 0;
	}

	@Override
	public int multiDelete(String[] seqs) {
		int count = 0 ; 
		
		
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", seqs);
		
		try(SqlSession session = getSqlSessionFactory().openSession(false);) {
			
			count = session.delete(namespace+"multiDelete",map);
			//muldel-mapper.xml의 delete id=multiDelete를 가져와서 map에 담아서 보낸다?
			if(count == seqs.length) {
				session.commit();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
				
		return count;
	}

}
