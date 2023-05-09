
-- registered user
INSERT INTO public.registered_user (reg_user_id, email, first_name, last_name, "password", "role", username)
VALUES (nextval('user_sequence_generator'), 'admin@gmail.com', 'Admin', 'Admin', '123', 0, 'admin'),
       (nextval('user_sequence_generator'), 'ana@valcon.com', 'Ana', 'Gavrilovic', '123', 1, 'ana'),
       (nextval('user_sequence_generator'), 'sanja@gmail.com', 'Sanja', 'Drinic', '123', 1, 'sanja');
