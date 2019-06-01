insert into `users` (username, password, enabled) VALUES ('rodo', '$2a$10$Fm9qCH73CX0HQQjJO./4K.AWszwsFPEbOkE2RATkSO5.Zo/a67F9K',1);


insert into `users` (username, password, enabled) VALUES ('ventas', '$2a$10$B8htJIk12nSbf0EPDQGG/Om8tMMO2AOPmG78DRHZtzpUxyH/NUWkC',1);



insert into `authorities` (user_id, authority) VALUES(1, 'ROLE_ADMIN');
insert into `authorities` (user_id, authority) VALUES(2, 'ROLE_ADMIN');
