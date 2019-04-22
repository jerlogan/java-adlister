USE codeup_test_db;
TRUNCATE albums;


-- CREATE TABLE users (
--   id INT UNSIGNED NOT NULL AUTO_INCREMENT,
--   username VARCHAR(255),
--   email VARCHAR(255),
--   password VARCHAR(255),
--   PRIMARY KEY (id)
-- );
--
-- CREATE TABLE ads (
--   id INT UNSIGNED NOT NULL AUTO_INCREMENT,
--   user_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
--   title VARCHAR(100) not null,
--   description VARCHAR(255) not null,
--   PRIMARY KEY (id),
--   FOREIGN KEY (user_id) references users (id)
--     on delete cascade
-- );

INSERT INTO users (username, email, password)
VALUES
('username1', 'username1@codeup.com', 'password'),
('username2', 'username2@codeup.com', 'password'),
('username3', 'username3@codeup.com', 'password');


INSERT INTO ads (title, description, user_id)
VALUES
('Dog for sale', 'a dog is for sale!', 2),
('Cat for sale', 'A cat is for sale!', 1);

