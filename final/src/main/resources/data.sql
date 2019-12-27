insert into public.user(id, username, password, first_name, last_name, email_address, address, active)
    values (0, 'root', '$2a$10$XpLVTvFHekyqAIvKkPIwuuKXiL/3RNswPldw85T6MtDFQcxo2OUve', 'Root', 'Root', 'root@local.host', 'root address', true);
insert into authority(id, username, authority, active) values (0, 'root', 'ROLE_SUPERADMIN', true);

insert into brand(id, name, active) values (0, 'OPPO', true);
insert into brand(id, name, active) values (1, 'SAMSUNG', true);
insert into brand(id, name, active) values (2, 'APPLE', true);

insert into category(id, name, active) values (0, 'Root', true);
insert into category(id, name, parent_category_id, active) values (1, 'Electronics', 0, true);
insert into category(id, name, parent_category_id, active) values (2, 'Phones', 1, true);
insert into category(id, name, parent_category_id, active) values (3, 'Workstaions', 1, true);
insert into category(id, name, parent_category_id, active) values (4, 'Laptops', 1, true);
insert into category(id, name, parent_category_id, active) values (5, 'Bikes', 0, true);
insert into category(id, name, parent_category_id, active) values (6, 'Cruiser Bikes', 5, true);
insert into category(id, name, parent_category_id, active) values (7, 'Sport Bikes', 5, true);
insert into category(id, name, parent_category_id, active) values (8, 'Touring Bikes', 5, true);
insert into category(id, name, parent_category_id, active) values (9, 'Dirt Bikes', 5, true);
insert into category(id, name, parent_category_id, active) values (10, 'Books', 0, true);
insert into category(id, name, parent_category_id, active) values (11, 'Literature', 10, true);
insert into category(id, name, parent_category_id, active) values (12, 'Fiction', 10, true);
insert into category(id, name, parent_category_id, active) values (13, 'Science', 10, true);

insert into product(id, name, description, image, barcode, brand_id, category_id, price, quantity, weight, discount, active) 
    values (0, 'F1 Plus', 'The 16MP front camera sensor was exclusively designed for OPPO and the F1 Plus with the ability to pick up four times the incoming light as other smartphone cameras.', 'f1plus.jpg', '123456', 0, 2, 450, 5, 250, 0, true);
insert into product(id, name, description, image, barcode, brand_id, category_id, price, quantity, weight, discount, active)
    values (1, 'S10', 'Triple rear camera setup: 16MP with f2.2 aperture ultra wide + 12MP with f1.5 and f2.4 aperture wide + 12MP f2.4 tele.', 's10.jpg', '654321', 1, 2, 900, 5, 200, 0, true);
insert into product(id, name, description, image, barcode, brand_id, category_id, price, quantity, weight, discount, active) 
    values (2, 'iPhone X', 'A11 Bionic Chip with Hexa-Core Processor, iOS, Embedded M11 Motion CoProcessor.', 'ix.jpg', '743987', 2, 2, 1100, 5, 200, 0, true);
insert into product(id, name, description, image, barcode, brand_id, category_id, price, quantity, weight, discount, active) 
    values (3, 'iPhone 11', 'A11 Bionic Chip with Hexa-Core Processor, iOS, Embedded M11 Motion CoProcessor.', 'ix.jpg', '769654', 2, 2, 1300, 5, 200, 0, true);
