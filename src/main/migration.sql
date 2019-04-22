create database if not exists adlister_db

use adlister_db;

CREATE TABLE users (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  username VARCHAR(255),
  email VARCHAR(255),
  password VARCHAR(255),
  PRIMARY KEY (id)
);

CREATE TABLE ads (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  title VARCHAR(100) not null,
  description VARCHAR(255) not null,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) references users (id)
    on delete cascade
);


