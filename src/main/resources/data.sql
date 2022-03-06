INSERT INTO `roles` (`id`, `name`) VALUES ('1', 'USER');
INSERT INTO `roles` (`id`, `name`) VALUES ('2', 'CREATOR');
INSERT INTO `roles` (`id`, `name`) VALUES ('3', 'EDITOR');
INSERT INTO `roles` (`id`, `name`) VALUES ('4', 'ADMIN');

INSERT INTO `users` (`id`, `username`, `email`, `first_name`, `last_name`, `password`, `enabled`) VALUES ('1', 'patrick', 'patrick@test.com', 'patrick', 'patrick','$2a$10$cTUErxQqYVyU2qmQGIktpup5chLEdhD2zpzNEyYqmxrHHJbSNDOG.', true);
INSERT INTO `users` (`id`, `username`, `email`, `first_name`, `last_name`, `password`, `enabled`) VALUES ('5', 'admin', 'admin@test.com', 'admin', 'admin', '$2a$10$IqTJTjn39IU5.7sSCDQxzu3xug6z/LPU6IF0azE/8CkHCwYEnwBX.', true);

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1, 1); -- user patrick has role USER
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (5, 4); -- user admin has role ADMIN