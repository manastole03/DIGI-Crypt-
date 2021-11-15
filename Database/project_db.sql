use locker;

create table create_t
(
Name char(50) NOT NULL,
e_mail varchar(50)  NOT NULL,
mobile_number int(10)  NOT NULL,
username varchar(50)  NOT NULL,
password varchar(50) NOT NULL
);

create table create_tablee
(
Name char(50) NOT NULL,
e_mail varchar(50) UNIQUE NOT NULL,
mobile_number int(10) UNIQUE NOT NULL,
username varchar(50) UNIQUE NOT NULL PRIMARY KEY,
password varchar(50) NOT NULL
);

desc create_tablee;

select * from create_t;
SELECT * FROM create_t WHERE password='manas' ;

select * from create_tablee where username=? and password=?;

CREATE TABLE t1b (
  id int(10) NOT NULL,
  fullname varchar(50) NOT NULL,
  username varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  email_address varchar(50) NOT NULL,
  mobile_number varchar(50) NOT NULL
);

ALTER TABLE t1b
  ADD PRIMARY KEY (id),
  ADD UNIQUE KEY id (id);

ALTER TABLE t1b
  MODIFY id int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

select * from t1b;

insert into t1b values (id,"manas","manas039","mnas01","tole001",1000);


create table new_password
(
	username varchar(20) not null,
    phone_number int(10) not null,
    email_address varchar(100) not null,
	account_name varchar(20) not null,
    account_password varchar(20) not null
);

select * from new_password;
insert into new_password values ("manas039",688787,"mnas01","tole001","1000");

create table new_document
(
username varchar(100) not null,
document_name varchar(100) not null,
document_number varchar(100) not null,
description varchar(2000),
photo longblob not null
);

select * from new_document;