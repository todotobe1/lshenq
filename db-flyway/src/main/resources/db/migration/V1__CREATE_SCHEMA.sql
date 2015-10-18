/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/10/14 23:19:32                          */
/*==============================================================*/


DROP TABLE IF EXISTS T_DRIVER;

DROP TABLE IF EXISTS T_ORDER;

DROP TABLE IF EXISTS T_USER;

/*==============================================================*/
/* Table: T_DRIVER                                              */
/*==============================================================*/
CREATE TABLE T_DRIVER
(
   DRIVER_ID            INT NOT NULL,
   DRIVER_CODE          VARCHAR(128) NOT NULL,
   DRIVER_NAME          VARCHAR(128),
   DRIVING_NO           VARCHAR(64) NOT NULL,
   ID_CARD_NO           VARCHAR(32) NOT NULL,
   CRT_TIME             DATETIME,
   UPD_TIME             DATETIME,
   PRIMARY KEY (DRIVER_ID)
);

/*==============================================================*/
/* Table: T_ORDER                                               */
/*==============================================================*/
CREATE TABLE T_ORDER
(
   ORDER_ID             INT NOT NULL,
   ORDER_NO             VARCHAR(128) NOT NULL,
   DRIVER_ID            INT,
   BUY_ID               INT NOT NULL,
   AMOUNT               VARCHAR(32),
   ORDER_STATE          CHAR(4),
   CRT_TIME             DATETIME,
   UPD_TIME             DATETIME,
   PRIMARY KEY (ORDER_ID)
);

/*==============================================================*/
/* Table: T_USER                                                */
/*==============================================================*/
CREATE TABLE T_USER
(
   USER_ID              INT NOT NULL,
   USER_CODE            VARCHAR(128) NOT NULL,
   USER_NAME            VARCHAR(128) NOT NULL,
   NICK_NAME            VARCHAR(128),
   MOBIL_NUM            VARCHAR(13) NOT NULL,
   PASSWORD             VARCHAR(128),
   CRT_TIME             DATETIME,
   UPD_TIME             DATETIME,
   PRIMARY KEY (USER_ID)
);

