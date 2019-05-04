CREATE TABLE exhibition (
	id int PRIMARY KEY,
	name varchar(25) not null unique,
	description varchar(1000),
	urlphoto varchar(1000)
);
CREATE TABLE user (
	id int primary key,
	username varchar(15) unique not null,
	passord varchar(15) not null,
	exhibition int,
	type int,
	FOREIGN KEY (exhibition) REFERENCES exhibition (id)
);
CREATE TABLE vote (
	user_id int not null,
	exhibition_id int not null,
	weight int not null,
	PRIMARY KEY (user_id, exhibition_id),
	FOREIGN KEY (user_id) REFERENCES user (id),
	FOREIGN KEY (exhibition_id) REFERENCES exhibition (id)
);