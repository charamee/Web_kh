package com.answer.dao;

import java.util.List;

import com.answer.dto.AnswerDto;

public interface AnswerDao {
	
	String SELECT_LIST_SQL=" SELECT BOARDNO,GROUPNO,GROUPSEQ,TITLETAB,DELFLAG,TITLE,CONTENT, WRITER, REGDATE "
			+ " FROM ANSWERBOARD2 "
			+ " ORDER BY GROUPNO DESC, GROUPSEQ ";
	
	String SELECT_ONT_SQL=" SELECT BOARDNO,GROUPNO,GROUPSEQ,TITLETAB,DELFLAG,TITLE,CONTENT, WRITER, REGDATE "
			+ " FROM ANSWERBOARD2 "
			+ " WHERE BOARDNO = ? ";
	
	String BOARD_INSERT_SQL=" INSERT INTO ANSWERBOARD2 "
			+ " VALUES(BOARDNOSEQ2.NEXTVAL,GROUPNOSEQ2.NEXTVAL,1,0,'N',?,?,?,SYSDATE ) ";
	
	String BOARD_UPDATE_SQL=" UPDATE ANSWERBOARD2 "
							+ " SET TITLE=? , CONTENT=? "
							+ " WHERE BOARDNO= ? ";
	
	String BOARD_DELETE_SQL=" UPDATE ANSWERBOARD2 SET DELFLAG ='Y' WHERE BOARDNO = ? ";
	
	
	String ANSWER_UPDATE_SQL=" UPDATE ANSWERBOARD2 "
							+ " SET GROUPSEQ = GROUPSEQ+1 "
							+ " WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD2 WHERE BOARDNO =?) "
							+ " AND GROUPSEQ > (SELECT GROUPSEQ FROM ANSWERBOARD2 WHERE BOARDNO = ?) ";
	
	String ANSWER_INSERT_SQL=" INSERT INTO ANSWERBOARD2 "
							+ " VALUES (BOARDNOSEQ2.NEXTVAL,"
							+ "(SELECT GROUPNO FROM ANSWERBOARD2 WHERE BOARDNO =?),"
							+ "(SELECT GROUPSEQ FROM ANSWERBOARD2 WHERE BOARDNO =?) +1,"
							+ " (SELECT TITLETAB FROM ANSWERBOARD2 WHERE BOARDNO=?) +1,"
							+ " 'N',?,?,?,SYSDATE "
							+ " )";

public List<AnswerDto> selectList();
public AnswerDto selectOne(int boardno);
public boolean boardInsert(AnswerDto dto);
public boolean boardUpdate(AnswerDto dto);
public boolean boardDelete(int boardno);

public int answerUpdate(int parentBoardNo);
public int answerInsert(AnswerDto dto);

}
