create table persons(

    id bigint not null auto_increment,
    name varchar(255) not null,
    date_birth varchar(255) not null,

    primary key(id)

);

create table address(


    id bigint not null auto_increment,
    street varchar(255) not null,
    zip varchar(9) not null,
    number varchar(20) not null,
    city varchar(255) not null,
    person_id bigint not null,

    primary key(id),
    foreign key (person_id) references persons(id)

);

create table persons_address(

    person_id bigint not null,
    address_id bigint not null

);