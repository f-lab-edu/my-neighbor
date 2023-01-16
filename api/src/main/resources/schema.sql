DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users
(
    user_id           bigint      NOT NULL AUTO_INCREMENT,
    email             varchar(50) NOT NULL,
    name              varchar(20) NOT NULL,
    password          varchar(50) NOT NULL,
    city_id           int                  DEFAULT 0,
    town_id           int                  DEFAULT 0,
    profile_image_url varchar(255)         DEFAULT NULL,
    last_login_at     datetime             DEFAULT NULL,
    create_at         datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    primary key (user_id),
    CONSTRAINT unq_user_email UNIQUE (email)
);
