package com.answer.dao;

import java.util.List;

import com.answer.dto.AnswerDto;

public interface AnswerDao {
	//INSERT INTO ANSWERBOARD
	//VALUES(BOARDNOSEQ.NEXTVAL, GROUPNOSEQ.NEXTVAL, 1,0,
		//	'1번글 입니다','1번 글을 썼는데...답변형 어렵다.','강사',SYSDATE);

	String SELECT_LIST_SQL=" ";
	String SELECT_ONT_SQL="  ";
	String BOARD_INSERT_SQL=" INSERT INTO ANSWERBOARD "
			+ " VALUES(BOARDNOSEQ.NEXTVAL,GROUPNOSEQ.NEXTVAL,1,0,?,?,?,SYSDATE ) ";
	String BOARD_UPDATE_SQL=" UPDATE ANSWERBOARD "
			+ " SET TITLE=? , CONTENT=? "
			+ " WHERE BOARDNO= ? ";
	String BOARD_DELETE_SQL=" DELETE FROM ANSWERBOARD WHERE BOARDNO = ? ";
	
	String ANSWER_UPDATE_SQL=" UPDATE ANSWERBOARD "
							+ " SET GROUPSEQ = GROUPSEQ +1 "
							+ "	WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO =?) "
							+ " AND GROUPSEQ > (SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO =?) ";
	
	String ANSWER_INSERT_SQL=" INSERT INTO ANSWERBOARD "
							+ " VALUES("
							+ "			BOARDNOSEQ.NEXTVAL,"
							+ "			(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = ?),"
							+ "			(SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = ?)+1, "
							+ "			(SELECT TITLETAB FROM ANSWERBOARD WHERE BOARDNO = ?)+1,"
							+ " ?,?,?,SYSDATE)";
	
	public List<AnswerDto> selectList();
	public AnswerDto selectOne(int boardno);
	public int boardInsert(AnswerDto dto);
	public int boardUpdate(AnswerDto dto);
	public int boardDelete(int boardno);
	
	public int answerUpdate(int parentBoardNo);
	public int answerInsert(AnswerDto dto);
}
