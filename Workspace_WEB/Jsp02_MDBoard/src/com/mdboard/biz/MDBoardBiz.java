package com.mdboard.biz;

import java.util.List;

import com.mdboard.dto.MDBoardDto;

public interface MDBoardBiz {

	public List<MDBoardDto> list();
	public MDBoardDto selectOne(int seq);
	public int insert(MDBoardDto dto);
	public int update(MDBoardDto dto);
	public int delete(int seq);
	
	public int muldel(String[] seqs);
}
