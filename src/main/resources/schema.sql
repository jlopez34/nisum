DROP TABLE IF EXISTS CLIENT;

CREATE TABLE CLIENT(
  ID_CLIENT UUID PRIMARY KEY,
  NAME VARCHAR(50) NOT NULL,
  EMAIL VARCHAR(100) NOT NULL,
  PASSWORD VARCHAR(50) NOT NULL,
  CREATED DATE NOT NULL,
  MODIFIED DATE NOT NULL,
  LAST_LOGIN DATE NOT NULL,
  TOKEN VARCHAR(200) NOT NULL,
  ACTIVE CHAR(1) NOT NULL
);
DROP TABLE IF EXISTS PHONE;

CREATE TABLE PHONE(
    ID_PHONE INT AUTO_INCREMENT  PRIMARY KEY,
    NUMBER VARCHAR(50) NOT NULL,
    CITY_CODE VARCHAR(2) NOT NULL,
    COUNTRY_CODE VARCHAR(2) NOT NULL
 );

DROP TABLE IF EXISTS CLIENT_PHONE;

CREATE TABLE CLIENT_PHONE(
  ID_CLIENT_PHONE INT AUTO_INCREMENT,
  ID_CLIENT UUID NOT NULL,
  ID_PHONE INT NOT NULL,
  PRIMARY KEY (ID_CLIENT_PHONE,ID_CLIENT, ID_PHONE),
  CONSTRAINT FK_CLIENT FOREIGN KEY (ID_CLIENT) REFERENCES CLIENT (ID_CLIENT),
  CONSTRAINT FK_PHONE FOREIGN KEY (ID_PHONE) REFERENCES PHONE(ID_PHONE)
 );