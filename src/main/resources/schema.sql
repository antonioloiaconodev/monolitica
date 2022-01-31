-- -----------------------------------------------------
-- Table `users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `users` (
    `id` INT NOT NULL,
    `username` VARCHAR(255) NULL,
    `first_name` VARCHAR(255) NULL,
    `last_name` VARCHAR(255) NULL
);

-- -----------------------------------------------------
-- Table `videogames`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `videogames` (
    `videogame_id` INT NOT NULL,
    `name` VARCHAR(255) NULL,
    `platform` VARCHAR(255) NULL,
    `genre` VARCHAR(255) NULL,
    `publisher` VARCHAR(255) NULL,
    `release` DATE NULL
);

-- -----------------------------------------------------
-- Table `users_has_videogames`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `users_has_videogames` (
  `user_id` INT NOT NULL,
  `videogame_id` INT NOT NULL
);
CREATE INDEX `fk_users_has_videogames_videogames_idx` ON `users_has_videogames` (`videogame_id` ASC);
CREATE INDEX `fk_users_has_videogames_users_idx` ON `users_has_videogames` (`user_id` ASC);

-- -----------------------------------------------------
-- Table `ratings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ratings` (
    `id` INT NOT NULL,
    `user_id` INT NULL,
    `videogame_id` INT NULL,
    `rating` TINYINT(1) NULL
);
CREATE INDEX `fk_ratings_videogames1_idx` ON `ratings` (`videogame_id`);
CREATE INDEX `fk_ratings_users1_idx` ON `ratings` (`user_id` ASC);
