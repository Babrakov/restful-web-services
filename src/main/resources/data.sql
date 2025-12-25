insert into user_details(id, user_name, birth_date) values (10001, 'Alice', CURRENT_DATE);
insert into user_details(id, user_name, birth_date) values (10002, 'Bob', CURRENT_DATE);
insert into user_details(id, user_name, birth_date) values (10003, 'John', CURRENT_DATE);

insert into post(id,description,user_id) values (20001,'I want to learn AWS',10001);
insert into post(id,description,user_id) values (20002,'I want to learn microservices',10001);
insert into post(id,description,user_id) values (20003,'I want to get 1M euros',10002);