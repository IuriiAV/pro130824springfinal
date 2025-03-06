CREATE TABLE IF NOT EXISTS network_users(
    id BIGINT primary key auto_increment,
    name varchar(255),
    surname varchar(255),
    login varchar(255),
    password varchar(255)
);