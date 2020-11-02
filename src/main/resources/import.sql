INSERT INTO roles (id, role) VALUES (1,'USER');
INSERT INTO roles (id, role) VALUES (2,'ADMIN');
INSERT INTO users (age, email, first_name, last_name, password) VALUES (33, 'admin@mail.com', 'Admin', 'class', 'a');
INSERT INTO users (age, email, first_name, last_name, password) VALUES (25, 'user@test.com', 'User', 'class', 'u');
INSERT INTO users_roles (user_id, roles_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, roles_id) VALUES (1, 2);
INSERT INTO users_roles (user_id, roles_id) VALUES (2, 2);
