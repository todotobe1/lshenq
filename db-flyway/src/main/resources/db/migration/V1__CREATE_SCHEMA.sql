DROP TABLE IF EXISTS T_BOOKING;

DROP TABLE IF EXISTS T_DRIVER;

DROP TABLE IF EXISTS T_DRIVER_GROUP;

DROP TABLE IF EXISTS T_ORDER;

DROP TABLE IF EXISTS T_USER;

/*==============================================================*/
/* Table: T_BOOKING                                             */
/*==============================================================*/
CREATE TABLE T_BOOKING
(
   BOOKING_ID           INT NOT NULL AUTO_INCREMENT,
   ORDER_ID             INT NOT NULL,
   BOOKING_NO           VARCHAR(128) NOT NULL,
   TIME                 DATETIME NOT NULL,
   STARTING_POINT       VARCHAR(128) NOT NULL,
   DESTINATION          VARCHAR(128) NOT NULL,
   CRT_TIME             DATETIME,
   UPD_TIME             DATETIME,
   PRIMARY KEY (BOOKING_ID)
);

/*==============================================================*/
/* Table: T_DRIVER                                              */
/*==============================================================*/
CREATE TABLE T_DRIVER
(
   DRIVER_ID            INT NOT NULL AUTO_INCREMENT,
   DRIVER_GROUP_ID      INT,
   DRIVER_CODE          VARCHAR(128) NOT NULL,
   DRIVER_NAME          VARCHAR(128),
   DRIVING_NO           VARCHAR(64) NOT NULL,
   ID_CARD_NO           VARCHAR(32) NOT NULL,
   CRT_TIME             DATETIME,
   UPD_TIME             DATETIME,
   PRIMARY KEY (DRIVER_ID)
);

/*==============================================================*/
/* Table: T_DRIVER_GROUP                                        */
/*==============================================================*/
CREATE TABLE T_DRIVER_GROUP
(
   DRIVER_GROUP_ID      INT NOT NULL AUTO_INCREMENT,
   DRIVER_GROUP_NAME    VARCHAR(64),
   CRT_TIME             DATETIME,
   UPD_TIME             DATETIME,
   PRIMARY KEY (DRIVER_GROUP_ID)
);


/*==============================================================*/
/* Table: T_ORDER                                               */
/*==============================================================*/
CREATE TABLE T_ORDER
(
   ORDER_ID             INT NOT NULL AUTO_INCREMENT,
   ORDER_NO             VARCHAR(128) NOT NULL,
   DRIVER_ID            INT,
   BUY_ID               INT NOT NULL,
   BOOKING_ID           INT NOT NULL,
   AMOUNT               VARCHAR(12),
   ORDER_STATE          CHAR(1),
   PAY_STATE            CHAR(1),
   DATA_STATE           CHAR(1),
   CRT_TIME             DATETIME,
   UPD_TIME             DATETIME,
   PRIMARY KEY (ORDER_ID)
);

/*==============================================================*/
/* Table: T_USER                                                */
/*==============================================================*/
CREATE TABLE T_USER
(
   USER_ID              INT NOT NULL AUTO_INCREMENT,
   USER_CODE            VARCHAR(128) NOT NULL,
   USER_NAME            VARCHAR(128) NOT NULL,
   NICK_NAME            VARCHAR(128),
   MOBIL_NUM            VARCHAR(13) NOT NULL,
   PASSWORD             VARCHAR(128),
   CRT_TIME             DATETIME,
   UPD_TIME             DATETIME,
   PRIMARY KEY (USER_ID)
);
