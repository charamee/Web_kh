package com.mdboard.biz;

import java.util.List;

import com.mdboard.dao.MDBoardDao;
import com.mdboard.dao.MDBoardDaoImpl;
import com.mdboard.dto.MDBoardDto;

public class MDBoardBizImpl implements MDBoardBiz {

	MDBoardDao dao = new MDBoardDaoImpl();
	@Override
	public List<MDBoardDto> list() {

		return dao.list();
	}

	@Override
	public MDBoardDto selectOne(int seq) {

		return dao.selectOne(seq);
	}

	@Override
	public int insert(MDBoardDto dto) {

		return dao.insert(dto);
	}

	@Override
	public int update(MDBoardDto dto) {

		return dao.update(dto);
	}

	@Override
	public int delete(int seq) {

		return dao.delete(seq);
	}

	@Override
	public int muldel(String[] seqs) {

		return dao.muldel(seqs);
	}

}
