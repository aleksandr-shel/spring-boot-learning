use linkedinlearning;

CREATE TABLE ROOM(
  ROOM_ID BIGINT PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(16) NOT NULL,
  ROOM_NUMBER CHAR(2) NOT NULL UNIQUE,
  BED_INFO CHAR(2) NOT NULL
);

CREATE TABLE GUEST(
  GUEST_ID BIGINT PRIMARY KEY AUTO_INCREMENT,
  FIRST_NAME VARCHAR(64),
  LAST_NAME VARCHAR(64),
  EMAIL_ADDRESS VARCHAR(64),
  ADDRESS VARCHAR(64),
  COUNTRY VARCHAR(32),
  STATE VARCHAR(12),
  PHONE_NUMBER VARCHAR(24)
);

CREATE TABLE RESERVATION(
  RESERVATION_ID BIGINT PRIMARY KEY AUTO_INCREMENT,
  ROOM_ID BIGINT NOT NULL,
  GUEST_ID BIGINT NOT NULL,
  RES_DATE DATE
);

ALTER TABLE RESERVATION ADD FOREIGN KEY (ROOM_ID) REFERENCES ROOM(ROOM_ID);
ALTER TABLE RESERVATION ADD FOREIGN KEY (GUEST_ID) REFERENCES GUEST(GUEST_ID);
CREATE INDEX IDX_RES_DATE_ ON RESERVATION(RES_DATE);
