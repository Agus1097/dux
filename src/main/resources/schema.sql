DROP TABLE IF EXISTS `teams`;

CREATE TABLE `teams` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `league` VARCHAR(100) NOT NULL,
    `country` VARCHAR(100) NOT NULL,
    CONSTRAINT unique_teams_name_league_country UNIQUE (`name`, `league`, `country`)
);

CREATE TABLE IF NOT EXISTS `app_user` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR(100) NOT NULL,
    `password` VARCHAR(100) NOT NULL
);