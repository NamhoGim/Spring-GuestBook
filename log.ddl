CREATE TABLE log (
    id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    ip varchar(255) NOT NULL,
    method varchar(10) NOT NULL,
    regdate datetime,
    PRIMARY KEY (id)
);