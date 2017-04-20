create database icoffee;
create user hibernate@'%' identified by 'p@ssword';
grant all on icoffee.* to hibernate@'%';
use icoffee;

create table coffee (
	id      serial,
	name    varchar(255),
	size    char,
	price   double
);

insert into coffee(name,size,price) values('Latte', 'T', 110);
insert into coffee(name,size,price) values('Latte', 'G', 125);
insert into coffee(name,size,price) values('Latte', 'V', 140);
insert into coffee(name,size,price) values('Mocha', 'T', 125);
insert into coffee(name,size,price) values('Mocha', 'G', 140);
insert into coffee(name,size,price) values('Mocha', 'V', 155);
