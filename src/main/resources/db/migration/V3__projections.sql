create table reservation (
    id bigserial not null,
    canceled boolean,
    user_id bigserial not null references "user",
    projection_id bigserial not null references projection,
    primary key (id)
);
