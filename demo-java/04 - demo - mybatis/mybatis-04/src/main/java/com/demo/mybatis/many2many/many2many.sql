create table mybatis_many2many_cart (
   many2many_cart_id int(3) auto_increment not null primary key,
   many2many_cart_code varchar(50) not null,
   many2many_cart_name varchar(50) not null);

create table mybatis_many2many_student (
   many2many_student_id int(3) auto_increment not null primary key,
   many2many_name varchar(50) not null,
   many2many_gender varchar(50) ,
   many2many_major varchar(50) ,
   many2many_grade varchar(50));

create table mybatis_many2many_other (
  many2many_other_id  int(3) auto_increment not null primary key,
  many2many_student_id int references mybatis_many2many_student(many2many_student_id),
  many2many_cart_id int references mybatis_many2many_cart(many2many_cart_id));


insert into mybatis_many2many_cart
(many2many_cart_name,many2many_cart_code) values
('JavaSE',1);
insert into mybatis_many2many_cart
(many2many_cart_name,many2many_cart_code) values
('JavaEE',2);
insert into mybatis_many2many_cart
(many2many_cart_name,many2many_cart_code) values
('MyBatis',1);

insert into mybatis_many2many_student
(many2many_name,many2many_gender,many2many_major,many2many_grade)
 values('John','johncom','1890','123-7890');
insert into mybatis_many2many_student
(many2many_name,many2many_gender,many2many_major,many2many_grade)
values('Paul','paulcom','111-333','123-90');

insert into mybatis_many2many_other(many2many_student_id,many2many_cart_id)values(1,1);
insert into mybatis_many2many_other(many2many_student_id,many2many_cart_id)values(1,2);
insert into mybatis_many2many_other(many2many_student_id,many2many_cart_id)values(1,3);
insert into mybatis_many2many_other(many2many_student_id,many2many_cart_id)values(2,1);
insert into mybatis_many2many_other(many2many_student_id,many2many_cart_id)values(2,2);
insert into mybatis_many2many_other(many2many_student_id,many2many_cart_id)values(2,3);

