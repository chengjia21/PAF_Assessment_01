create database mybnb;
use mybnb;


create table acc_occupancy(
acc_id int not null,
vacancy int,

constraint pk_acc_id primary key(acc_id),
constraint CHK_acc_id CHECK (acc_id>=0 AND acc_id<=9999999999)

-- Below line is if vacancy constraints (between 0-100 days) are desired
constraint CHK_vacancy CHECK (vacancy>=0 AND vacancy<=100)

);



create table reservations(
resv_id int not null,
name varchar(128),
email varchar(128),
acc_id int not null,
arrival_date date,
duration int,

constraint CHK_resv_id CHECK (resv_id>=0 AND resv_id<=99999999),
constraint pk_resv_id primary key(resv_id),
constraint fk_acc_id foreign key (acc_id) references acc_occupancy(acc_id)
);



-- select * from acc_occupancy;
-- select * from reservations;

