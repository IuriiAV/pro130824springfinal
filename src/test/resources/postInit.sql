DROP TABLE IF EXISTS posts;
CREATE TABLE posts
(
    id          BIGINT primary key auto_increment,
    content     VARCHAR(255),
    post_status VARCHAR(255),
    user_id BIGINT
);


insert into posts ( content, post_status) values ('Hello','DRAFT');