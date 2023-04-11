create table client
(
    client_id serial primary key,
    name      varchar(100) not null unique,
    age       int check ( age > 0 AND age < 120 ),
    email     varchar(100) not null unique
);

create table request
(
    request_id serial primary key,
    client_id  int references client (client_id) on delete cascade
);

create table item
(
    item_id serial primary key,
    name    varchar(100) not null unique,
    price   int check ( price > 0 )
);

create table request_item
(
    request_id int references request (request_id) on delete cascade,
    item_id  int references item (item_id) on delete cascade,
    primary key (request_id, item_id)
);

insert into client(name, age, email)
values ('Petro', 30, 'petro@email');
insert into client(name, age, email)
values ('Vasyl', 25, 'vasyl@email');
insert into client(name, age, email)
values ('Alice', 50, 'alice@email');

insert into request(client_id)
values (3);
insert into request(client_id)
values (1);
insert into request(client_id)
values (1);
insert into request(client_id)
values (2);

insert into item(name, price)
values ('Banana', 50);
insert into item(name, price)
values ('Tomato', 60);
insert into item(name, price)
values ('Apple', 30);
insert into item(name, price)
values ('Strawberry', 100);

insert into request_item
values (1, 2);
insert into request_item
values (2, 1);
insert into request_item
values (3, 4);
insert into request_item
values (4, 4);