CREATE TABLE users (
    username varchar(50) primary key not null,
    password varchar(50)  not null,
    enabled  smallint not null
);

Insert into users (username,password,enabled) values ('Ashish','{noop}Ash2002',1),('Adith','{noop}Ash2002',1)
,('Anoop','{noop}Ash2002',1);


create table authorities(
	username varchar(50) not null,
	authority varchar(50) not null,
	foreign key (username) references users(username)
)

insert into authorities (username,authority) values ('Ashish','ROLE_EMPLOYEE'),
('Ashish','ROLE_MANAGER'),
('Ashish','ROLE_ADMIN'),
('Anoop','ROLE_EMPLOYEE'),
('Adith','ROLE_EMPLOYEE'),
('Adith','ROLE_MANAGER')