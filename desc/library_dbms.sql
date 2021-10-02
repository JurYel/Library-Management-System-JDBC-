create database lbms_db;
use lbms_db;

create table bookrecords(
	category varchar(65),
	book_id varchar(12) NOT NULL,
	book_title varchar(100) NOT NULL,
	book_author varchar(50) NOT NULL,
	yearpublished int(8),
	quantity int(255),
	PRIMARY KEY(book_id)
);

create table book_location(
	book_id varchar(12) NOT NULL,
	rack int,
	PRIMARY KEY(book_id),
	FOREIGN KEY(book_id) REFERENCES book(book_id)
);

create table accounts(
	userID varchar(20) NOT NULL,
	last_name varchar(50),
	first_name varchar(50),
	position varchar(100),
	password varchar(50),
	status boolean,
	level int,
	PRIMARY KEY(userID)
);

create table account_history(
	acc_history_id int NOT NULL AUTO_INCREMENT,
	user_id varchar(20) NOT NULL,
	action varchar(100),
	admin_id varchar(20) NOT NULL,
	datetime timestamp NOT NULL,
	PRIMARY KEY(acc_history_id),
	FOREIGN KEY(user_id) REFERENCES accounts(userID),
	FOREIGN KEY(admin_id) REFERENCES accounts(userID)
);

create table book_history(
	bk_history_id int NOT NULL AUTO_INCREMENT,
	book_id varchar(12) NOT NULL,
	action varchar(50) NOT NULL,
	admin_id varchar(20) NOT NULL,
	datetime timestamp NOT NULL,
	PRIMARY KEY(bk_history_id),
	FOREIGN KEY(book_id) REFERENCES bookrecords(book_id),
	FOREIGN KEY(admin_id) REFERENCES accounts(admin_id)
);

create table issued_books(
	isbk_id INT NOT NULL AUTO_INCREMENT,
	book_id varchar(12) NOT NULL,
	userID varchar(20) NOT NULL,
	dateBorrowed date NOT NULL,
	duedate date NOT NULL,
	PRIMARY KEY(isbk_id),
	FOREIGN KEY(book_id) REFERENCES bookrecords(book_id),
	FOREIGN KEY(userID) REFERENCES accounts(userID)
);

create table overdued_books(
	od_book_id INT NOT NULL AUTO_INCREMENT,
	user_id varchar(20) NOT NULL,
	overdued varchar(45),
	book_id varchar(12) NOT NULL,
	due_date date NOT NULL,
	date_borrowed date,
	days_due varchar(30),
	PRIMARY KEY(od_book_id),
	FOREIGN KEY(user_id) REFERENCES accounts(userID),
	FOREIGN KEY(book_id) REFERENCES bookrecords(book_id)
);

create table returned_books(
	return_id INT NOT NULL AUTO_INCREMENT,
	user_id varchar(20) NOT NULL,
	book_status varchar(45),
	book_id varchar(12) NOT NULL,
	date_returned date NOT NULL,
	PRIMARY KEY(return_id),
	FOREIGN KEY(user_id) REFERENCES accounts(userID),
	FOREIGN KEY(book_id) REFERENCES bookrecords(book_id)
);

create table transactions(
	trans_id int NOT NULL AUTO_INCREMENT,
	user_id varchar(20) NOT NULL,
	transaction varchar(45),
	book_id varchar(12) NOT NULL,
	admin_id varchar(20) NOT NULL,
	date_transaction timestamp NOT NULL,
	PRIMARY KEY(trans_id),
	FOREIGN KEY(user_id) REFERENCES accounts(userID),
	FOREIGN KEY(book_id) REFERENCES bookrecords(book_id),
	FOREIGN KEY(admin_id) REFERENCES accounts(admin_id)
);

create table login_history(
	userID varchar(20) NOT NULL,
	position varchar(60),
	datetime timestamp NOT NULL,
	FOREIGN KEY(userID) REFERENCES accounts(userID)
);

INSERT INTO accounts (userID,last_name,first_name,position,password,status,level) 
VALUES('18100001156','Botoy','Juriel','Administrator','qwerty182',false,3);

INSERT INTO accounts (userID,last_name,first_name,position,password,status,level) 
VALUES('18100001417','Garbo','Ian Jee','Student Assistant','qwerty182',false,2);

INSERT INTO accounts (userID,last_name,first_name,position,password,status,level) 
VALUES('18100001211','Perater','Jayson','Student','qwerty182',false,1);


