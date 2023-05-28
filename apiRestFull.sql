CREATE USER 'millanRoman'@'%' IDENTIFIED by 'millanRoman';
CREATE DATABASE IF NOT EXISTS `proyectoRestMillanRoman`;
GRANT ALL PRIVILEGES ON `proyectoRestMillanRoman`.* TO 'millanRoman'@'%';


CREATE TABLE proyectoRestMillanRoman.userdb( 
	username VARCHAR(32), 
	password VARCHAR(100), 
	email VARCHAR(32),   
	realusername VARCHAR(32),
	surname VARCHAR(32), 
	birthdate DATE,
	admin BOOLEAN,
	verification_code VARCHAR(100),
	profile VARCHAR(100),
	enable BOOLEAN,
	CONSTRAINT PK_userdb PRIMARY KEY(username) 
);


CREATE TABLE proyectoRestMillanRoman.course(
	corsename VARCHAR(32),
	description VARCHAR(100),
	duration int(3),
	difficulty int(1)
	CONSTRAINT PK_course PRIMARY KEY(corsename)
);

CREATE TABLE proyectoRestMillanRoman.topicdb(
	topicname VARCHAR(32),
	content VARCHAR(100),
	pages int(5),
	price double(10,2),
	key_course VARCHAR(32),
	CONSTRAINT PK_topicdb PRIMARY KEY(topicname),
	CONSTRAINT FK_topicdb FOREIGN KEY(key_course) REFERENCES course(corsename) ON DELETE CASCADE
);


CREATE TABLE proyectoRestMillanRoman.studydb(
	key_user  VARCHAR(32),
	key_topic VARCHAR(32),
	date_begin datetime,
	date_end datatime,
	score int(2),
	CONSTRAINT PK_studydb PRIMARY KEY(key_user, key_topic),
	CONSTRAINT FK_studydb FOREIGN KEY(key_user) REFERENCES userdb(username) ON DELETE CASCADE,
	CONSTRAINT FK_studydb2 FOREIGN KEY(key_topic) REFERENCES topicdb(topicname) ON DELETE CASCADE
);

/*datos course*/
insert into proyectoRestMillanRoman.course (corsename, description, duration, difficulty) values ('Matematicas', 'lacinia nisi venenatis tristique fusce congue', 976, 5);
insert into proyectoRestMillanRoman.course (corsename, description, duration, difficulty) values ('Física', 'erat tortor sollicitudin mi sit', 867, 4);
insert into proyectoRestMillanRoman.course (corsename, description, duration, difficulty) values ('Anatomía', 'in porttitor pede justo eu', 800, 5);
insert into proyectoRestMillanRoman.course (corsename, description, duration, difficulty) values ('Naturales', 'venenatis turpis enim blandit mi', 600, 3);
insert into proyectoRestMillanRoman.course (corsename, description, duration, difficulty) values ('Química', 'leo maecenas pulvinar lobortis est phasellus', 900, 4);
insert into proyectoRestMillanRoman.course (corsename, description, duration, difficulty) values ('Lengua Castellana', 'turpis donec posuere metus vitae', 890, 4);
insert into proyectoRestMillanRoman.course (corsename, description, duration, difficulty) values ('Inglés', 'at feugiat non pretium quis lectus', 500, 3);
insert into proyectoRestMillanRoman.course (corsename, description, duration, difficulty) values ('Francés', 'phasellus id sapien in sapien', 600, 4);
insert into proyectoRestMillanRoman.course (corsename, description, duration, difficulty) values ('Somalí', 'vel accumsan tellus nisi eu orci', 700, 4);
insert into proyectoRestMillanRoman.course (corsename, description, duration, difficulty) values ('Educación Física', 'tempus semper est quam pharetra', 700, 3);
insert into proyectoRestMillanRoman.course (corsename, description, duration, difficulty) values ('Literatura', 'urna ut tellus nulla ut', 670, 2);
insert into proyectoRestMillanRoman.course (corsename, description, duration, difficulty) values ('Informática', 'at velit eu est congue elementum', 980, 5);
insert into proyectoRestMillanRoman.course (corsename, description, duration, difficulty) values ('Historia', 'ornare consequat lectus in est', 850, 4);


/*datos de topic*/
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Matematicas 1', 'dis parturient montes nascetur ridiculus', 194, 4, 'Matematicas');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Matematicas 2', 'massa donec dapibus duis at velit', 208, 14, 'Matematicas');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Matematicas 3', 'lacus purus aliquet at feugiat non', 631, 37, 'Matematicas');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Matematicas 4', 'sed tincidunt eu felis fusce posuere', 531, 0, 'Matematicas');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Física 1', 'vivamus tortor duis mattis egestas metus', 408, 15, 'Física');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Física 2', 'accumsan odio curabitur convallis duis', 115, 15, 'Física');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Física 3', 'nulla sed vel enim sit amet', 157, 43, 'Física');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Física 4', 'leo pellentesque ultrices mattis odio', 900, 45, 'Física');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Anatomía 1', 'augue aliquam erat volutpat in congue', 945, 22, 'Anatomía');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Anatomía 2', 'lobortis ligula sit amet eleifend pede', 850, 52, 'Anatomía');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Anatomía 3', 'proin at turpis a pede', 511, 0, 'Anatomía');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Anatomía 4', 'ut mauris eget massa tempor convallis', 885, 4, 'Anatomía');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Naturales 1', 'posuere cubilia curae duis faucibus accumsan', 245, 44, 'Naturales');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Naturales 2', 'felis eu sapien cursus vestibulum', 931, 13, 'Naturales');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Naturales 3', 'vestibulum sagittis sapien cum sociis natoque', 1000, 13, 'Naturales');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Naturales 4', 'eu felis fusce posuere felis', 251, 16, 'Naturales');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Química 1', 'etiam justo etiam pretium iaculis', 434, 20, 'Química');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Química 2', 'dis parturient montes nascetur ridiculus', 694, 41, 'Química');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Química 3', 'lacus morbi quis tortor id nulla', 622, 53, 'Química');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Química 4', 'luctus rutrum nulla tellus in', 285, 52, 'Química');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Lengua Castellana 1', 'hac habitasse platea dictumst maecenas ut', 157, 10, 'Lengua Castellana');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Lengua Castellana 2', 'sagittis dui vel nisl duis ac', 901, 46, 'Lengua Castellana');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Lengua Castellana 3', 'lacus curabitur at ipsum ac tellus', 99, 11, 'Lengua Castellana');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Lengua Castellana 4', 'sagittis nam congue risus semper', 224, 22, 'Lengua Castellana');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Inglés 1', 'interdum venenatis turpis enim blandit mi', 787, 0, 'Inglés');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Inglés 2', 'iaculis justo in hac habitasse', 826, 11, 'Inglés');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Inglés 3', 'lectus aliquam sit amet diam in', 645, 45, 'Inglés');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Inglés 4', 'sit amet consectetuer adipiscing elit', 954, 18, 'Inglés');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Francés 1', 'etiam faucibus cursus urna ut', 722, 28, 'Francés');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Francés 2', 'pretium iaculis justo in hac habitasse', 914, 56, 'Francés');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Francés 3', 'aliquam convallis nunc proin at', 627, 10, 'Francés');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Francés 4', 'sollicitudin ut suscipit a feugiat', 239, 14, 'Francés');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Somalí 1', 'lorem quisque ut erat curabitur gravida', 976, 9, 'Somalí');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Somalí 2', 'vivamus vel nulla eget eros', 411, 9, 'Somalí');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Somalí 3', 'tincidunt eget tempus vel pede', 257, 22, 'Somalí');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Somalí 4', 'curabitur convallis duis consequat dui', 373, 60, 'Somalí');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Educación Física 1', 'turpis donec posuere metus vitae', 769, 49, 'Educación Física');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Educación Física 2', 'nunc nisl duis bibendum felis sed', 502, 8, 'Educación Física');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Educación Física 3', 'massa id nisl venenatis lacinia', 479, 47, 'Educación Física');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Educación Física 4', 'quisque porta volutpat erat quisque', 152, 28, 'Educación Física');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Literatura 1', 'odio odio elementum eu interdum', 400, 4, 'Literatura');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Literatura 2', 'sagittis nam congue risus semper porta', 261, 10, 'Literatura');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Literatura 3', 'in felis eu sapien cursus vestibulum', 811, 9, 'Literatura');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Literatura 4', 'justo sit amet sapien dignissim vestibulum', 251, 11, 'Literatura');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Informática 1', 'in felis eu sapien cursus vestibulum', 298, 57, 'Informática');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Informática 2', 'sed tincidunt eu felis fusce', 141, 44, 'Informática');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Informática 3', 'tincidunt in leo maecenas pulvinar', 590, 30, 'Informática');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Informática 4', 'tempor turpis nec euismod scelerisque', 271, 58, 'Informática');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Historia 1', 'sagittis nam congue risus semper porta', 509, 55, 'Historia');
insert into proyectoRestMillanRoman.topicdb (topicname, content, pages, price, key_course) values ('Historia 2', 'massa id lobortis convallis tortor', 602, 59, 'Historia');


