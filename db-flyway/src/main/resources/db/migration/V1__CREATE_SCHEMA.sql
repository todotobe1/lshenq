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
   BOOKING_NO           VARCHAR(128) NOT NULL,
   APPOINT_TIME         DATETIME NOT NULL,
   STARTING_POINT       VARCHAR(128) NOT NULL,
   DESTINATION          VARCHAR(128) NOT NULL,
   CRT_TIME             DATETIME,
   UPD_TIME             DATETIME,
   PRIMARY KEY (BOOKING_ID),
   UNIQUE KEY BOOKING_NO_UNIQUE (BOOKING_NO)
);

/*==============================================================*/
/* Table: T_DRIVER                                              */
/*==============================================================*/
CREATE TABLE T_DRIVER
(
   DRIVER_ID            INT NOT NULL AUTO_INCREMENT,
   DRIVER_GROUP_NO      VARCHAR(128),
   DRIVER_CODE          VARCHAR(128) NOT NULL,
   DRIVER_NAME          VARCHAR(128),
   DRIVER_SEX           INT,
   DRIVER_BIRTHDATE     DATETIME,
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
   DRIVER_GROUP_NO      VARCHAR(128) NOT NULL,
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
   DRIVER_NO            VARCHAR(128),
   BUY_ID               VARCHAR(128) NOT NULL,
   BOOKING_NO           VARCHAR(128) NOT NULL,
   AMOUNT               VARCHAR(12),
   ORDER_STATE          CHAR(1),
   PAY_STATE            CHAR(1),
   DATA_STATE           CHAR(1),
   CRT_TIME             DATETIME,
   UPD_TIME             DATETIME,
   PRIMARY KEY (ORDER_ID),
   UNIQUE KEY ORDER_NO_UNIQUE (ORDER_NO)
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
   BIRTHDATE			DATETIME,
   PASSWORD             VARCHAR(128),
   EMAIL				VARCHAR(128),
   CRT_TIME             DATETIME,
   UPD_TIME             DATETIME,
   PRIMARY KEY (USER_ID)
);
