CREATE TABLE IF NOT EXISTS network_users
(
    id       BIGINT primary key auto_increment,
    name     varchar(255),
    surname  varchar(255),
    login    varchar(255),
    password varchar(255)
);

CREATE TABLE IF NOT EXISTS messages
(
    id          BIGINT primary key auto_increment,
    text        varchar(255),
    sender_id   BIGINT,
    receiver_id BIGINT,
    status      varchar(255),
    foreign key (sender_id) references network_users (id),
    foreign key (receiver_id) references network_users (id)
);