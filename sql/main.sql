CREATE TABLE IF NOT EXISTS AUTHORS (
	ID INT NOT NULL AUTO_INCREMENT,
	NAME VARCHAR (500),
	PRIMARY KEY (ID),
	UNIQUE (NAME )
	);
CREATE TABLE IF NOT EXISTS CLIENTS (
  ID INT NOT NULL AUTO_INCREMENT,
  NAME VARCHAR (500),
  PRIMARY KEY (ID)
) ;

CREATE TABLE IF NOT EXISTS CATEGORIES (
  ID INT NOT NULL AUTO_INCREMENT,
  NAME VARCHAR (20),
  PRIMARY KEY (ID)
);

CREATE TABLE IF NOT EXISTS BOOKS (
  ID INT NOT NULL AUTO_INCREMENT,
  NAME VARCHAR (300),
  AUTHOR_ID INT NOT NULL,
  ISBN VARCHAR (500),
  CATEGORY_ID INT NOT NULL,
  UNIT_PRICE NUMERIC (15,2),
  PRIMARY KEY (ID),
  FOREIGN KEY (AUTHOR_ID) REFERENCES AUTHORS(ID),
  FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORIES(ID)
);

CREATE TABLE IF NOT EXISTS ORDERS (
  ID INT NOT NULL AUTO_INCREMENT,
  CLIENT_ID INT NOT NULL ,
  BOOK_ID INT NOT NULL ,
  QUANTITY INT NOT NULL ,
  AMOUNT NUMERIC (15,2),
  PRIMARY KEY (ID),
  FOREIGN KEY (BOOK_ID) REFERENCES BOOKS(ID),
  FOREIGN KEY (CLIENT_ID) REFERENCES CLIENTS(ID)
);

