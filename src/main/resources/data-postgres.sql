
-- registered user
INSERT INTO public.users (id, email, first_name, last_name, "password", "role", username)
VALUES (nextval('user_sequence_generator'), 'admin@gmail.com', 'Admin', 'Admin', '123', 'ADMIN', 'admin'),
       (nextval('user_sequence_generator'), 'ana@valcon.com', 'Ana', 'Gavrilovic', '123', 'USER', 'ana'),
       (nextval('user_sequence_generator'), 'sanja@gmail.com', 'Sanja', 'Drinic', '123', 'USER', 'sanja');
