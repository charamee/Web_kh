package com.mdboard.dao;


import java.util.List;

import com.mdboard.dto.MDBoardDto;

public interface MDBoardDao {
	
	 String SELECT_LIST = " SELECT SEQ,WRITER,TITLE,CONTENT,REGDATE FROM MDBOARD ORDER BY SEQ DESC ";
	 String SELECT_ONE =" SELECT SEQ,WRITER,TITLE,CONTENT,REGDATE FROM MDBOARD WHERE SEQ=? ";
	 String INSERT_SQL = " INSERT INTO MDBOARD VALUES(MDBOARDSEQ.NEXTVAL,?,?,?,SYSDATE) ";
	 String UPDATE_SQL = " UPDATE MDBOARD SET TITLE=?,CONTENT=? WHERE SEQ= ? ";
	 String DELETE_SQL = " DELETE FROM MDBOARD WHERE SEQ=? ";
	
	
	public List<MDBoardDto> list();
	public MDBoardDto selectOne(int seq);
	public int insert(MDBoardDto dto);
	public int update(MDBoardDto dto);
	public int delete(int seq);
	
	//선택삭제 (여러개 한번에 삭제)
	public int muldel(String [] seqs);
}
