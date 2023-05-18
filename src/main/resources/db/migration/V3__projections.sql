create table reservation (
    id bigserial not null,
    canceled boolean,
    user_id bigserial not null,
    projection_id bigserial not null,
    primary key (id)
);

alter table if exists reservation
add constraint fk_user_id
foreign key (user_id)
references "user";

alter table if exists reservation
add constraint fk_projection_id
foreign key (projection_id)
references projection;