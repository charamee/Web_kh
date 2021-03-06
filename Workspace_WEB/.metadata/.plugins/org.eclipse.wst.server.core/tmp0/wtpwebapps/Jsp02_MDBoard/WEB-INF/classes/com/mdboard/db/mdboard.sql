
DROP SEQUENCE MDBOARDSEQ;
DROP TABLE MDBOARD;

CREATE SEQUENCE MDBOARDSEQ;

CREATE TABLE MDBOARD(
	SEQ NUMBER PRIMARY KEY,
	WRITER VARCHAR2(100) NOT NULL,
	TITLE VARCHAR2(1000) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	REGDATE DATE NOT NULL
);

INSERT INTO MDBOARD
VALUES(MDBOARDSEQ.NEXTVAL,'관리자','멀티딜리트 테스트','삭제하고 다시 만들었어요',SYSDATE);

INSERT INTO MDBOARD
VALUES(MDBOARDSEQ.NEXTVAL,'차라미','공부하기','싫어요',SYSDATE);

SELECT SEQ,WRITER,TITLE,CONTENT,REGDATE
FROM MDBOARD
ORDER BY  SEQ DESC;