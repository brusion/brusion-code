
create table mybatis_one2many_person(
one2many_person_id int(3) auto_increment not null primary key,
one2many_name varchar(100),
one2many_email varchar(100),
one2many_phone varchar(15));

create table mybatis_one2many_classes(
one2many_classes_id int(3) auto_increment not null primary key,
one2many_name varchar(100) not null,
one2many_description varchar(512),
one2many_start_date date ,
one2many_end_date date ,
one2many_person_ids int references mybatis_one2many_tutors (one2many_person_id));


insert into mybatis_one2many_person
(one2many_name,one2many_email,one2many_phone)
values('test name','zs@briup.com','123-456-7890');

insert into mybatis_one2many_person
(one2many_name,one2many_email,one2many_phone)
values('test name','ls@briup.com','111-222-3333');

insert into mybatis_one2many_classes
(one2many_name,one2many_description,one2many_person_ids) values
('JavaSE','JavaSE',1);

insert into mybatis_one2many_classes
(one2many_name,one2many_description,one2many_person_ids) values
('JavaEE','JavaEE',2);

insert into mybatis_one2many_classes
(one2many_name,one2many_description,one2many_person_ids) values
('MyBatis','MyBatis',1);


