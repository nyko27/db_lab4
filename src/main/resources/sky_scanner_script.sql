create database if not exists sky_scanner;
use sky_scanner;


drop table if exists user_profile_has_ticket;
drop table if exists ticket;
drop table if exists user_profile;
drop table if exists flight;
drop table if exists airport;
drop table if exists airline;
drop table if exists route;
drop table if exists route_has_flight;

create table airline(
id int auto_increment primary key,
airline_name varchar(100)
) engine = INNODB;

create table airport(
id int auto_increment primary key,
airport_name varchar(100) not null,
city varchar(100) not null,
country varchar(100) not null,
airline_id int not null
) engine = INNODB;

create table flight(
id int auto_increment primary key,
airplane_name varchar(100) not null,
allowed_baggage_in_kilogrms int not null,
departure_airport_id int not null,
arrival_airport_id int not null,
airline_id int not null
) engine = INNODB;

create table ticket(
id int auto_increment primary key,
flight_id int not null,
price_in_uah decimal(15,2) not null
)engine = INNODB;

create table user_profile(
id int auto_increment primary key,
user_name varchar(100) not null,
surname varchar(100) not null
)engine = INNODB;

create table user_profile_has_ticket(
user_profile_id int not null,
ticket_id int not null,
primary key(user_profile_id,ticket_id)
)engine = INNODB;

alter table airport

add constraint FK_airport_airline
foreign key (airline_id)
references airline(id)
ON DELETE CASCADE;



alter table flight

add constraint FK_flight_airline
foreign key (airline_id)
references airline(id)
ON DELETE CASCADE,

add constraint FK_flight_departure_airport
foreign key (departure_airport_id)
references airport(id)
ON DELETE CASCADE,

add constraint FK_flight_arrival_airport
foreign key (arrival_airport_id)
references airport(id)
ON DELETE CASCADE;


alter table ticket
add constraint FK_ticket_flight
foreign key (flight_id)
references flight(id)
ON DELETE CASCADE;


alter table user_profile_has_ticket
add constraint FK_user_profile_has_ticket_user_profile
foreign key (user_profile_id)
references user_profile(id)
ON DELETE CASCADE,

add constraint FK_user_profile_has_ticket_ticket
foreign key (ticket_id)
references ticket(id)
ON DELETE CASCADE;

insert into airline(airline_name) values
('Qatar Airways'),
('Singapore Airlines'),
('ANA All Nippon Airways'),
('Emirates'),
('EVA Air'),
('Hainan Airlines'),
('Qantas Airways'),
('Lufthansa'),
('Thai Airways'),
('Cathay Pacific Airways');

insert into airport(airport_name, city ,country , airline_id) values
('Dubai International Airport', 'Dubai', 'United Arab Emirates',4),
('Paris Charles de Gaulle Airport ', 'Paris', 'France', 8),
('Frankfurt Airport ', 'Frankfurt', 'Germany', 8),
('Hartsfield-Jackson Atlanta International Airport', 'Atlanta', 'USA', 1),
('Tokyo Haneda Airport', 'Tokyo', 'Japan', 2),
('Marseille Charles de Gaulle Airport ', 'Marseille', 'France', 5),
('Berlin Airport ', 'Berlin', 'Germany', 7),
('Los Angeles International Airport', 'Los Angeles', 'USA', 3),
('Suvarnabhumi Airport', 'Suvarnabhumi', 'Thailand', 9),
('John F. Kennedy International Airport', 'New-York', 'USA', 6);

insert into flight( airplane_name, allowed_baggage_in_kilogrms,
 departure_airport_id, arrival_airport_id, airline_id) values
('airbus_a310',12,3,1,1),
('boeing_737',14,1,2,2),
('boeing_737',14,5,3,2),
('airbus_a310',12,4,3,5),
('boeing_737',14,9,5,6),
('airbus_a310',12,7,8,7),
('boeing_737',14,5,4,4),
('airbus_a310',12,3,6,3),
('airbus_a310',12,7,2,9),
('boeing_737',14,8,1,8);


insert into ticket(flight_id, price_in_uah) values
(3,1000),
(5,3400),
(7,570),
(8,5000),
(8,1340),
(4,2700),
(6,10000),
(1,3250),
(2,1800),
(2,8900);

insert into user_profile(user_name, surname) values
('John','Brown'),
('Bogdan', 'Khmelnytskyy'),
('Andriy' ,'Baker'),
('Stepan', 'Bandera'),
('Oleksndra', 'Sira'),
('Emilia' ,'Kravchenko'),
('Ella', 'Fisher'),
('Evelyn', 'Fisher'),
('Sofia', 'Smith'),
('Roman', 'Marchuk');

insert into user_profile_has_ticket(user_profile_id, ticket_id ) values
(8, 3),
(1, 3),
(4, 9),
(5, 7),
(1, 2),
(3, 8),
(2, 7),
(5, 2),
(9, 6),
(6, 2);

create index user_name_surname on user_profile(user_name, surname);
create index flight_baggage_max_weight on flight(allowed_baggage_in_kilogrms);

 
