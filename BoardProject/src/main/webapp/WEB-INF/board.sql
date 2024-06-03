--------------------------------------------------------
--  파일이 생성됨 - 월요일-6월-03-2024   
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
