package com.login.biz;

import java.util.List;

import com.login.dao.MyMemberDao;
import com.login.dto.MyMemberDto;

public class MyMemberBiz {
	
	MyMemberDao dao = new MyMemberDao();
	

	//1.전체 정보 
	 public List<MyMemberDto> selectAllUser(){
		 return dao.selectAllUser();
	 }
	 //2. 전체 정보(탈퇴안한) 
	 public List<MyMemberDto> selectEnabledUser(){
		 return dao.selectEnabledUser();
	 }
	 
	 //3. 회원 등급 조정 
	 public int updateRole(int myno, String myrole) {
		 return dao.updateRole(myno, myrole);
	 }
	 
	 //1. 로그인 
	 public MyMemberDto login(String myid,String mypw) {
		 return dao.login(myid, mypw);
	 }
	 
	 //2. 중복 체크 
	 public MyMemberDto idCheck(String myid) {
		 return dao.idCheck(myid);
	 }
	 //3. 회원 가입 
	 public int insertUser(MyMemberDto dto) {
		return dao.insertUser(dto);
		 
	 }
	 //4. 정보조회 
	 public MyMemberDto selectUser(int myno) {
		 return dao.selectUser(myno);
	 }
	 
	 //5. 정보 수정 
	 public int updateUser(MyMemberDto dto) {
		 return dao.updateUser(dto);
	 }
	 //6. 회원 탈퇴 (update) 
	 public int deleteUser(int myno) {
		 return dao.deleteUser(myno) ;
	 }

}
