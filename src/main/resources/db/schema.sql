create table posts(
    id integer primary key,
    user_id integer not null,
    text varchar(400)
);

CREATE SEQUENCE posts_seq START 1;