
-- users
INSERT INTO public.user (id, email, first_name, last_name, "password", "role", username)
VALUES (nextval('user_sequence_generator'), 'admin@gmail.com', 'Admin', 'Admin', '123', 'ADMIN', 'admin'),
       (nextval('user_sequence_generator'), 'ana@valcon.com', 'Ana', 'Gavrilovic', '123', 'USER', 'ana'),
       (nextval('user_sequence_generator'), 'sanja@gmail.com', 'Sanja', 'Drinic', '123', 'USER', 'sanja');

--  theatres
INSERT INTO public.theater(id, "name", number_of_seats)
VALUES (nextval('theater_sequence_generator'), 'Grand Room', 50),
       (nextval('theater_sequence_generator'), 'Indie Room', 10),
       (nextval('theater_sequence_generator'), 'Couple Room', 2);
