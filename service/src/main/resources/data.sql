INSERT INTO users(email,name,password) VALUES ('test00@gmail.com','tester00','pw-00');
INSERT INTO users(email,name,password) VALUES ('test01@gmail.com','tester01','pw-01');
INSERT INTO users(email,name,password) VALUES ('test02@gmail.com','tester02','pw-02');

INSERT INTO groups(category_id,leader_id,name,public_type,max_num,region_id,create_at) VALUES (1,1,'test group 1','public',10,1,'2022-12-20 10:00:00');
INSERT INTO groups(category_id,leader_id,name,public_type,max_num,region_id,create_at) VALUES (3,2,'test group 2','public',40,4,'2022-03-01 13:15:00');

INSERT INTO posts(group_id,writer_id,writer_email,writer_name,contents,count,public_type,modify_at,create_at) VALUES (1,2,'test01@gmail.com','tester01','posting content 1',215,'public','2023-01-25 13:15:00','2023-01-03 19:23:40');
INSERT INTO posts(group_id,writer_id,writer_email,writer_name,contents,count,public_type,modify_at,create_at) VALUES (1,2,'test01@gmail.com','tester01','posting content 2',30,'public','2023-01-25 13:15:00','2023-01-03 19:23:40');
INSERT INTO posts(group_id,writer_id,writer_email,writer_name,contents,count,public_type,modify_at,create_at) VALUES (2,3,'test02@gmail.com','tester02','posting content 3',5,'public','2023-01-25 13:15:00','2023-01-01 19:23:40');

INSERT INTO connections(group_id,user_id,create_at) VALUES (1,1,'2023-01-05 10:00:00');
INSERT INTO connections(group_id,user_id,create_at) VALUES (1,3,'2022-12-20 10:00:00');
INSERT INTO connections(group_id,user_id,create_at) VALUES (2,3,'2022-12-20 10:00:00');

