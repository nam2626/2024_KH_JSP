--------------------------------------------------------
--게시글 목록을 조회
--	글번호, 제목, 내용, 조회수, 작성일, 작성자(ID), 좋아요, 싫어요
--게시글 목록을 조회
--	글번호, 제목, 내용, 조회수, 작성일, 작성자(ID), 좋아요, 싫어요
SELECT B.*, BM.BOARD_MEMBER_NICK  FROM BOARD B JOIN BOARD_MEMBER BM 
ON B.BOARD_MEMBER_ID = BM.BOARD_MEMBER_ID ;

--좋아요/싫어요
SELECT COUNT(*) FROM BOARD_CONTENT_LIKE BCL WHERE BCL.BOARD_NO = ?;
SELECT COUNT(*) FROM BOARD_CONTENT_HATE BCH WHERE BCH.BOARD_NO = ?;

SELECT B.* , BM.BOARD_MEMBER_NICK ,
(SELECT COUNT(*) FROM BOARD_CONTENT_LIKE BCL WHERE BCL.BOARD_NO = B.BOARD_NO) AS BOARD_CONTENT_LIKE,
(SELECT COUNT(*) FROM BOARD_CONTENT_HATE BCH WHERE BCH.BOARD_NO = B.BOARD_NO) AS BOARD_CONTENT_HATE
FROM BOARD B JOIN BOARD_MEMBER BM 
ON B.BOARD_MEMBER_ID = BM.BOARD_MEMBER_ID ;

CREATE OR REPLACE VIEW BOARD_VIEW 
AS 
SELECT B.* , BM.BOARD_MEMBER_NICK ,
(SELECT COUNT(*) FROM BOARD_CONTENT_LIKE BCL WHERE BCL.BOARD_NO = B.BOARD_NO) AS BOARD_CONTENT_LIKE,
(SELECT COUNT(*) FROM BOARD_CONTENT_HATE BCH WHERE BCH.BOARD_NO = B.BOARD_NO) AS BOARD_CONTENT_HATE
FROM BOARD B JOIN BOARD_MEMBER BM 
ON B.BOARD_MEMBER_ID = BM.BOARD_MEMBER_ID ;

SELECT * FROM BOARD_VIEW;


SELECT BOARD_SEQ.currval FROM dual;

ALTER TABLE BOARD_CONTENT_LIKE 
ADD CONSTRAINT PK_BOARD_CONTENT_LIKE PRIMARY KEY(BOARD_NO, BOARD_MEMBER_ID);
ALTER TABLE BOARD_CONTENT_HATE 
ADD CONSTRAINT PK_BOARD_CONTENT_HATE PRIMARY KEY(BOARD_NO, BOARD_MEMBER_ID);

--------------------------------------------------------
--페이지 번호와 한페이지당 보여줄 게시글 개수를 이용해서 게시글 목록을 출력
--페이지 번호 : 1, 한페이지당 보여줄 게시글 개수 : 20;
--최근에 쓴 글이 맨 앞에 나오게끔 처리
SELECT * FROM BOARD_VIEW;

SELECT * FROM
(SELECT CEIL(ROW_NUMBER() OVER(ORDER BY B.BOARD_NO DESC) / 20) AS PAGE_NO,
B.* FROM BOARD_VIEW B) WHERE PAGE_NO = 1;

--전체 게시글 개수
SELECT COUNT(*) FROM BOARD_VIEW;


--------------------------------------------------------
--  ������ ������ - ������-6��-03-2024   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BOARD
--------------------------------------------------------

  CREATE TABLE "BOARD" 
   (	"BOARD_NO" NUMBER, 
	"BOARD_MEMBER_ID" VARCHAR2(50 BYTE), 
	"BOARD_TITLE" VARCHAR2(300 BYTE), 
	"BOARD_CONTENT" VARCHAR2(3000 BYTE), 
	"BOARD_COUNT" NUMBER DEFAULT 0, 
	"BOARD_WRITE_DATE" DATE DEFAULT SYSDATE
   ) ;
--------------------------------------------------------
--  DDL for Table BOARD_COMMENT
--------------------------------------------------------

  CREATE TABLE "BOARD_COMMENT" 
   (	"BOARD_COMMENT_NO" NUMBER, 
	"BOARD_MEMBER_ID" VARCHAR2(50 BYTE), 
	"BOARD_NO" NUMBER, 
	"BOARD_COMMENT_CONTENT" VARCHAR2(1000 BYTE), 
	"BOARD_COMMENT_WRITE_DATE" DATE DEFAULT SYSDATE
   ) ;
--------------------------------------------------------
--  DDL for Table BOARD_COMMENT_HATE
--------------------------------------------------------

  CREATE TABLE "BOARD_COMMENT_HATE" 
   (	"BOARD_MEMBER_ID" VARCHAR2(50 BYTE), 
	"BOARD_COMMENT_NO" NUMBER
   ) ;
--------------------------------------------------------
--  DDL for Table BOARD_COMMENT_LIKE
--------------------------------------------------------

  CREATE TABLE "BOARD_COMMENT_LIKE" 
   (	"BOARD_MEMBER_ID" VARCHAR2(50 BYTE), 
	"BOARD_COMMENT_NO" NUMBER
   ) ;
--------------------------------------------------------
--  DDL for Table BOARD_CONTENT_HATE
--------------------------------------------------------

  CREATE TABLE "BOARD_CONTENT_HATE" 
   (	"BOARD_MEMBER_ID" VARCHAR2(50 BYTE), 
	"BOARD_NO" NUMBER
   ) ;
--------------------------------------------------------
--  DDL for Table BOARD_CONTENT_LIKE
--------------------------------------------------------

  CREATE TABLE "BOARD_CONTENT_LIKE" 
   (	"BOARD_MEMBER_ID" VARCHAR2(50 BYTE), 
	"BOARD_NO" NUMBER
   ) ;
--------------------------------------------------------
--  DDL for Table BOARD_FILE
--------------------------------------------------------

  CREATE TABLE "BOARD_FILE" 
   (	"BOARD_FILE_NO" CHAR(10 BYTE), 
	"BOARD_NO" NUMBER, 
	"BOARD_FILE_URL" VARCHAR2(100 BYTE)
   ) ;
--------------------------------------------------------
--  DDL for Table BOARD_LOG
--------------------------------------------------------

  CREATE TABLE "BOARD_LOG" 
   (	"LOG_ID" NUMBER GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE , 
	"ACTION_TYPE" VARCHAR2(10 BYTE), 
	"USER_ID" VARCHAR2(50 BYTE), 
	"BOARD_NO" NUMBER, 
	"POST_TITLE" VARCHAR2(150 BYTE), 
	"POST_CONTENT" VARCHAR2(3000 BYTE), 
	"BEFORE_TITLE" VARCHAR2(150 BYTE), 
	"BEFORE_CONTENT" VARCHAR2(3000 BYTE), 
	"ACTION_TIMESTAMP" TIMESTAMP (6) DEFAULT SYSTIMESTAMP
   ) ;
--------------------------------------------------------
--  DDL for Table BOARD_MEMBER
--------------------------------------------------------

  CREATE TABLE "BOARD_MEMBER" 
   (	"BOARD_MEMBER_ID" VARCHAR2(50 BYTE), 
	"BOARD_MEMBER_NAME" VARCHAR2(50 BYTE), 
	"BOARD_MEMBER_PASSWD" CHAR(128 BYTE), 
	"BOARD_MEMBER_NICK" VARCHAR2(50 BYTE), 
	"BOARD_MEMBER_GRADE" NUMBER(38,0) DEFAULT 1
   ) ;
--------------------------------------------------------
--  DDL for Index PK_BOARD_NO
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_BOARD_NO" ON "BOARD" ("BOARD_NO") 
  ;
--------------------------------------------------------
--  DDL for Index PK_BOARD_COMMENT_NO
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_BOARD_COMMENT_NO" ON "BOARD_COMMENT" ("BOARD_COMMENT_NO") 
  ;
--------------------------------------------------------
--  DDL for Index PK_BOARD_FILE_NO
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_BOARD_FILE_NO" ON "BOARD_FILE" ("BOARD_FILE_NO") 
  ;
--------------------------------------------------------
--  DDL for Index SYS_C008412
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C008412" ON "BOARD_LOG" ("LOG_ID") 
  ;
--------------------------------------------------------
--  DDL for Index PK_MEMBER_ID
--------------------------------------------------------

  CREATE UNIQUE INDEX "PK_MEMBER_ID" ON "BOARD_MEMBER" ("BOARD_MEMBER_ID") 
  ;
--------------------------------------------------------
--  DDL for Trigger TRG_BOARD_ACTIONS
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "TRG_BOARD_ACTIONS" 
AFTER INSERT OR UPDATE OR DELETE ON BOARD
FOR EACH ROW
DECLARE
    V_USER_ID VARCHAR2(50);
BEGIN
	SELECT SYS_CONTEXT('USERENV','SESSION_USER') INTO V_USER_ID FROM DUAL;

    IF INSERTING THEN
        INSERT INTO BOARD_LOG (
            ACTION_TYPE, USER_ID, BOARD_NO, POST_TITLE, POST_CONTENT, ACTION_TIMESTAMP
        ) VALUES (
            'INSERT', V_USER_ID, :NEW.BOARD_NO, :NEW.BOARD_TITLE, :NEW.BOARD_CONTENT, SYSTIMESTAMP
        );
    ELSIF UPDATING THEN
        INSERT INTO BOARD_LOG (
            ACTION_TYPE, USER_ID, BOARD_NO, POST_TITLE, POST_CONTENT, BEFORE_TITLE, BEFORE_CONTENT, ACTION_TIMESTAMP
        ) VALUES (
            'UPDATE', V_USER_ID, :NEW.BOARD_NO, :NEW.BOARD_TITLE, :NEW.BOARD_CONTENT, :OLD.BOARD_TITLE, :OLD.BOARD_CONTENT, SYSTIMESTAMP
        );
    ELSIF DELETING THEN
        INSERT INTO BOARD_LOG (
            ACTION_TYPE, USER_ID, BOARD_NO, ACTION_TIMESTAMP
        ) VALUES (
            'DELETE', V_USER_ID, :OLD.BOARD_NO, SYSTIMESTAMP
        );
    END IF;
END;
/
ALTER TRIGGER "TRG_BOARD_ACTIONS" ENABLE;
--------------------------------------------------------
--  Constraints for Table BOARD
--------------------------------------------------------

  ALTER TABLE "BOARD" MODIFY ("BOARD_NO" NOT NULL ENABLE);
  ALTER TABLE "BOARD" MODIFY ("BOARD_MEMBER_ID" NOT NULL ENABLE);
  ALTER TABLE "BOARD" ADD CONSTRAINT "PK_BOARD_NO" PRIMARY KEY ("BOARD_NO")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table BOARD_COMMENT
--------------------------------------------------------

  ALTER TABLE "BOARD_COMMENT" MODIFY ("BOARD_COMMENT_NO" NOT NULL ENABLE);
  ALTER TABLE "BOARD_COMMENT" MODIFY ("BOARD_MEMBER_ID" NOT NULL ENABLE);
  ALTER TABLE "BOARD_COMMENT" MODIFY ("BOARD_NO" NOT NULL ENABLE);
  ALTER TABLE "BOARD_COMMENT" ADD CONSTRAINT "PK_BOARD_COMMENT_NO" PRIMARY KEY ("BOARD_COMMENT_NO")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table BOARD_COMMENT_HATE
--------------------------------------------------------

  ALTER TABLE "BOARD_COMMENT_HATE" MODIFY ("BOARD_MEMBER_ID" NOT NULL ENABLE);
  ALTER TABLE "BOARD_COMMENT_HATE" MODIFY ("BOARD_COMMENT_NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table BOARD_COMMENT_LIKE
--------------------------------------------------------

  ALTER TABLE "BOARD_COMMENT_LIKE" MODIFY ("BOARD_MEMBER_ID" NOT NULL ENABLE);
  ALTER TABLE "BOARD_COMMENT_LIKE" MODIFY ("BOARD_COMMENT_NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table BOARD_CONTENT_HATE
--------------------------------------------------------

  ALTER TABLE "BOARD_CONTENT_HATE" MODIFY ("BOARD_MEMBER_ID" NOT NULL ENABLE);
  ALTER TABLE "BOARD_CONTENT_HATE" MODIFY ("BOARD_NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table BOARD_CONTENT_LIKE
--------------------------------------------------------

  ALTER TABLE "BOARD_CONTENT_LIKE" MODIFY ("BOARD_MEMBER_ID" NOT NULL ENABLE);
  ALTER TABLE "BOARD_CONTENT_LIKE" MODIFY ("BOARD_NO" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table BOARD_FILE
--------------------------------------------------------

  ALTER TABLE "BOARD_FILE" MODIFY ("BOARD_FILE_NO" NOT NULL ENABLE);
  ALTER TABLE "BOARD_FILE" MODIFY ("BOARD_NO" NOT NULL ENABLE);
  ALTER TABLE "BOARD_FILE" ADD CONSTRAINT "PK_BOARD_FILE_NO" PRIMARY KEY ("BOARD_FILE_NO")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table BOARD_LOG
--------------------------------------------------------

  ALTER TABLE "BOARD_LOG" MODIFY ("LOG_ID" NOT NULL ENABLE);
  ALTER TABLE "BOARD_LOG" ADD PRIMARY KEY ("LOG_ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Constraints for Table BOARD_MEMBER
--------------------------------------------------------

  ALTER TABLE "BOARD_MEMBER" MODIFY ("BOARD_MEMBER_ID" NOT NULL ENABLE);
  ALTER TABLE "BOARD_MEMBER" MODIFY ("BOARD_MEMBER_PASSWD" NOT NULL ENABLE);
  ALTER TABLE "BOARD_MEMBER" ADD CONSTRAINT "PK_MEMBER_ID" PRIMARY KEY ("BOARD_MEMBER_ID")
  USING INDEX  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BOARD
--------------------------------------------------------

  ALTER TABLE "BOARD" ADD CONSTRAINT "FK_BOARD_MEMBER_ID" FOREIGN KEY ("BOARD_MEMBER_ID")
	  REFERENCES "BOARD_MEMBER" ("BOARD_MEMBER_ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BOARD_COMMENT
--------------------------------------------------------

  ALTER TABLE "BOARD_COMMENT" ADD CONSTRAINT "FK_COMMENT_BOARD_MEMBER_ID" FOREIGN KEY ("BOARD_MEMBER_ID")
	  REFERENCES "BOARD_MEMBER" ("BOARD_MEMBER_ID") ON DELETE CASCADE ENABLE;
  ALTER TABLE "BOARD_COMMENT" ADD CONSTRAINT "FK_COMMENT_BOARD_NO" FOREIGN KEY ("BOARD_NO")
	  REFERENCES "BOARD" ("BOARD_NO") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BOARD_COMMENT_HATE
--------------------------------------------------------

  ALTER TABLE "BOARD_COMMENT_HATE" ADD CONSTRAINT "FK_BCMH_MEMBER_ID" FOREIGN KEY ("BOARD_MEMBER_ID")
	  REFERENCES "BOARD_MEMBER" ("BOARD_MEMBER_ID") ON DELETE CASCADE ENABLE;
  ALTER TABLE "BOARD_COMMENT_HATE" ADD CONSTRAINT "FK_BCMH_BOARD_NO" FOREIGN KEY ("BOARD_COMMENT_NO")
	  REFERENCES "BOARD_COMMENT" ("BOARD_COMMENT_NO") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BOARD_COMMENT_LIKE
--------------------------------------------------------

  ALTER TABLE "BOARD_COMMENT_LIKE" ADD CONSTRAINT "FK_BCML_MEMBER_ID" FOREIGN KEY ("BOARD_MEMBER_ID")
	  REFERENCES "BOARD_MEMBER" ("BOARD_MEMBER_ID") ON DELETE CASCADE ENABLE;
  ALTER TABLE "BOARD_COMMENT_LIKE" ADD CONSTRAINT "FK_BCML_BOARD_NO" FOREIGN KEY ("BOARD_COMMENT_NO")
	  REFERENCES "BOARD_COMMENT" ("BOARD_COMMENT_NO") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BOARD_CONTENT_HATE
--------------------------------------------------------

  ALTER TABLE "BOARD_CONTENT_HATE" ADD CONSTRAINT "FK_BCH_BOARD_NO" FOREIGN KEY ("BOARD_NO")
	  REFERENCES "BOARD" ("BOARD_NO") ON DELETE CASCADE ENABLE;
  ALTER TABLE "BOARD_CONTENT_HATE" ADD CONSTRAINT "FK_BCH_MEMBER_ID" FOREIGN KEY ("BOARD_MEMBER_ID")
	  REFERENCES "BOARD_MEMBER" ("BOARD_MEMBER_ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BOARD_CONTENT_LIKE
--------------------------------------------------------

  ALTER TABLE "BOARD_CONTENT_LIKE" ADD CONSTRAINT "FK_BCL_MEMBER_ID" FOREIGN KEY ("BOARD_MEMBER_ID")
	  REFERENCES "BOARD_MEMBER" ("BOARD_MEMBER_ID") ON DELETE CASCADE ENABLE;
  ALTER TABLE "BOARD_CONTENT_LIKE" ADD CONSTRAINT "FK_BCL_BOARD_NO" FOREIGN KEY ("BOARD_NO")
	  REFERENCES "BOARD" ("BOARD_NO") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BOARD_FILE
--------------------------------------------------------

  ALTER TABLE "BOARD_FILE" ADD CONSTRAINT "FK_BOARD_FILE_BNO" FOREIGN KEY ("BOARD_NO")
	  REFERENCES "BOARD" ("BOARD_NO") ON DELETE CASCADE ENABLE;
