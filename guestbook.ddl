CREATE TABLE guestbook (
    id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    content text,
    regdate datetime,
    PRIMARY KEY (id)
);