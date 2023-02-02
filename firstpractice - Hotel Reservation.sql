-- Create database
#create database hotelreservation;

-- Use database
use hotelreservation;

-- Create and link tables
-- To link main to child table > foreign key(child-field to link) references main-table(main primary key)
/*
create table room(
	id int not null auto_increment,
    room_type enum ('standard', 'deluxe', 'suite', 'presidential') not null,
    price int not null,
    constraint room_id primary key(id)
);

create table employee (
	id int not null auto_increment,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    salary int not null,
	constraint employee_id primary key(id)
);

create table dependant(
	id int not null auto_increment,
    employee_id int not null,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    relationship varchar(50) not null,
    birth_date date,
    constraint dependant_id primary key(id),
    foreign key(employee_id) references employee(id)
);
*/

-- Adding some data into the tables
-- Main value must exist to be inserted into child table
/*
insert into room (room_type, price) values ('standard', '100');
insert into room (room_type, price) values ('deluxe', '200');
insert into room (room_type, price) values ('suite', '300');
insert into room (room_type, price) values ('presidential', '400');

insert into employee (first_name, last_name, salary) values ('Terry', 'Lim', '3000');
insert into employee (first_name, last_name, salary) values ('Gregory', 'Chua', '5000');
insert into employee (first_name, last_name, salary) values ('Maxim', 'Ng', '6000');

insert into dependant (employee_id, first_name, last_name, relationship, birth_date) values ('1', 'Sam', 'Lim', 'father', '1998-01-02');
insert into dependant (employee_id, first_name, last_name, relationship, birth_date) values ('1', 'Sally', 'Tan', 'spouse', '1970-05-09');
insert into dependant (employee_id, first_name, last_name, relationship, birth_date) values ('2', 'Pamela', 'Chua', 'father', '2010-08-28');
insert into dependant (employee_id, first_name, last_name, relationship, birth_date) values ('3', 'Joseph', 'Ng', 'father', '2008-04-01');
*/

-- CRUD SQL Commands
/*
-- Room ---
insert into room (room_type, price) values (?, ?);

select * from room;
select * from room where id = ?;
select count(*) from room;

update room set room_type = ?, price =? where id = ?;

delete from room where id = ?;

-- Employee --
insert into employee (first_name, last_name, salary) values (?, ?, ?);

select * from employee;
select * from employee where id = ?;

update employee set first_name = ?, last_name = ?, salary = ? where id = ?;

delete from employee where id = ?;

-- Inner join adds main-tables to the child table > select fields required from child-table inner join main-table on child linked-field = main-field
select e.id employee_id, e.first_name, e.last_name, e.salary, d.id dependant_id, d.first_name, d.last_name, d.relationship, d.birth_date
from employee e inner join dependant
d on e.id = d.employee_id;
*/