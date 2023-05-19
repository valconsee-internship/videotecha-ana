create table movie (
    id bigserial not null,
    deleted boolean,
    description varchar(255) not null,
    director varchar(255) not null,
    length integer not null,
    name varchar(255) not null,
    primary key (id)
);

create table movie_genres (
    movie_id bigserial not null references movie,
    genres varchar(255)
);

create table theater (
    id bigserial not null,
    name varchar(255) not null,
    number_of_seats integer not null,
    primary key (id)
);

create table projection (
    id bigserial not null,
    deleted boolean,
    number_of_available_seats integer not null,
    start_date_and_time timestamp(6) not null,
    ticket_price integer not null,
    movie_id bigserial not null references movie,
    theater_id bigserial not null references theater,
    primary key (id)
);

create table "user" (
    id bigserial not null,
    email varchar(255) not null unique,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    password varchar(255) not null,
    role varchar(255),
    username varchar(255) not null unique,
    primary key (id)
);
