insert into public.user(id, username, password, first_name, last_name, email_address, address, active)
    values (0, 'root', '$2a$10$XpLVTvFHekyqAIvKkPIwuuKXiL/3RNswPldw85T6MtDFQcxo2OUve', 'Root', 'Root', 'root@local.host', 'root address', true);
insert into authority(id, username, authority, active) values (0, 'root', 'ROLE_SUPERADMIN', true);
insert into brand(id, name, active) values (0, 'OPPO', true);
insert into brand(id, name, active) values (1, 'SAMSUNG', true);
insert into category(id, name, active) values (0, 'Phones', true);
insert into product(id, name, description, image, barcode, brand_id, category_id, price, quantity, weight, discount, active) 
    values (0, 'F1 Plus', 'The 16MP front camera sensor was exclusively designed for OPPO and the F1 Plus with the ability to pick up four times the incoming light as other smartphone cameras.', 'f1plus.jpg', '123456', 0, 0, 4500, 5, 250, 0, true);
insert into product(id, name, description, image, barcode, brand_id, category_id, price, quantity, weight, discount, active) 
    values (1, 'S10', 'Triple rear camera setup: 16MP with f2.2 aperture ultra wide + 12MP with f1.5 and f2.4 aperture wide + 12MP f2.4 tele.', 's10.jpg', '654321', 1, 0, 9000, 5, 200, 0, true);
