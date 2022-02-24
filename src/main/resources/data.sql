INSERT INTO `roles` (`id`, `name`) VALUES ('1', 'USER');
INSERT INTO `roles` (`id`, `name`) VALUES ('2', 'CREATOR');
INSERT INTO `roles` (`id`, `name`) VALUES ('3', 'EDITOR');
INSERT INTO `roles` (`id`, `name`) VALUES ('4', 'ADMIN');

INSERT INTO `users` (`id`, `username`, `email`, `password`, `enabled`) VALUES ('1', 'patrick', 'patrick@test.com', '$2a$10$cTUErxQqYVyU2qmQGIktpup5chLEdhD2zpzNEyYqmxrHHJbSNDOG.', true);
INSERT INTO `users` (`id`, `username`, `email`, `password`, `enabled`) VALUES ('2', 'alex', 'alex@test.com', '$2a$10$.tP2OH3dEG0zms7vek4ated5AiQ.EGkncii0OpCcGq4bckS9NOULu', true);
INSERT INTO `users` (`id`, `username`, `email`, `password`, `enabled`) VALUES ('3', 'john', 'john@test.com', '$2a$10$E2UPv7arXmp3q0LzVzCBNeb4B4AtbTAGjkefVDnSztOwE7Gix6kea', true);
INSERT INTO `users` (`id`, `username`, `email`, `password`, `enabled`) VALUES ('4', 'namhm', 'nahmh@test.com', '$2a$10$GQT8bfLMaLYwlyUysnGwDu6HMB5G.tin5MKT/uduv2Nez0.DmhnOq', true);
INSERT INTO `users` (`id`, `username`, `email`, `password`, `enabled`) VALUES ('5', 'admin', 'admin@test.com', '$2a$10$IqTJTjn39IU5.7sSCDQxzu3xug6z/LPU6IF0azE/8CkHCwYEnwBX.', true);

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1, 1); -- user patrick has role USER
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (2, 2); -- user alex has role CREATOR
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (3, 3); -- user john has role EDITOR
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (4, 2); -- user namhm has role CREATOR
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (4, 3); -- user namhm has role EDITOR
INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (5, 4); -- user admin has role ADMIN