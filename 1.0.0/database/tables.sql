-- music_manager.avaliations definition

CREATE TABLE `avaliations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `score` smallint(6) NOT NULL,
  `userId` int(11) NOT NULL,
  `musicId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `avaliations_userId_IDX` (`userId`,`musicId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- music_manager.genres definition

CREATE TABLE `genres` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


-- music_manager.music definition

CREATE TABLE `music` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- music_manager.user_genres definition

CREATE TABLE `user_genres` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `genreId` int(11) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_genres_userId_IDX` (`userId`,`genreId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;


-- music_manager.users definition

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(256) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


-- music_manager.music_genres definition

CREATE TABLE `music_genres` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `musicId` int(11) DEFAULT NULL,
  `genreId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `music_genres_FK` (`musicId`),
  KEY `music_genres_FK_1` (`genreId`),
  CONSTRAINT `music_genres_FK` FOREIGN KEY (`musicId`) REFERENCES `music` (`id`),
  CONSTRAINT `music_genres_FK_1` FOREIGN KEY (`genreId`) REFERENCES `genres` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO music_manager.genres (name) VALUES
	 ('Rock'),
	 ('Gospel'),
	 ('Jazz'),
	 ('Sertanejo'),
	 ('Pop'),
	 ('Pagode'),
	 ('Samba'),
	 ('Forró'),
	 ('Funk');