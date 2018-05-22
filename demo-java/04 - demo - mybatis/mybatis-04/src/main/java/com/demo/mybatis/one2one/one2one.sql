create table mybatis_one2one_addresses(
one2one_addr_id int(3) auto_increment not null primary key,
one2one_street varchar(20) not null,
one2one_city varchar(20) not null,
one2one_state varchar(20) not null,
one2one_zip varchar(10),
one2one_country varchar(20));

create table mybatis_one2one_students(
one2one_stud_id int(3)auto_increment not null primary key,
one2one_name varchar(20) not null,
one2one_email varchar(20),
one2one_dob date,
one2one_phone varchar(15),
one2one_addr_id int references addresses(one2one_addr_id));

insert into mybatis_one2one_addresses(one2one_addr_id,one2one_street,one2one_city,one2one_state,one2one_zip,one2one_country) values(1,'redSt','kunshan','W','12345','china');
insert into mybatis_one2one_addresses(one2one_addr_id,one2one_street,one2one_city,one2one_state,one2one_zip,one2one_country) values(2,'blueST','kunshan','W','12345','china');

insert into mybatis_one2one_students(one2one_stud_id,one2one_name,one2one_email,one2one_phone,one2one_addr_id) values(1,'John','john@gmail.com','123-456-7890',1);
insert into mybatis_one2one_students(one2one_stud_id,one2one_name,one2one_email,one2one_phone,one2one_addr_id) values(2,'Paul','paul@gmail.com','111-222-3333',2);

