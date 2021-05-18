CREATE DATABASE IF NOT EXISTS test_spring_hibernate_ipz CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
SHOW DATABASES;
USE test_spring_hibernate_ipz;
DROP TABLE books;
CREATE TABLE books
(
    id INT AUTO_INCREMENT,
    title VARCHAR(100),
    author VARCHAR(100),
    rating int,
    description VARCHAR(255),
    PRIMARY KEY(id)
);



