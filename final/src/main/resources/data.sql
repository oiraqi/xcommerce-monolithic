insert into public.user(id, username, password, first_name, last_name, email_address, address, active)
    values (0, 'root', '$2a$10$XpLVTvFHekyqAIvKkPIwuuKXiL/3RNswPldw85T6MtDFQcxo2OUve', 'Root', 'Root', 'root@local.host', 'root address', true);
insert into authority(id, username, authority, active) values (0, 'root', 'ROLE_SUPERADMIN', true);