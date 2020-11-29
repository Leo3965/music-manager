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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


-- music_manager.user_genres definition

CREATE TABLE `user_genres` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `genreId` int(11) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_genres_userId_IDX` (`userId`,`genreId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


-- music_manager.users definition

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(256) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


-- music_manager.avaliations definition

CREATE TABLE `avaliations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `score` smallint(6) NOT NULL,
  `userId` int(11) NOT NULL,
  `musicId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `avaliations_userId_IDX` (`userId`,`musicId`) USING BTREE,
  KEY `avaliations_FK` (`musicId`),
  CONSTRAINT `avaliations_FK` FOREIGN KEY (`musicId`) REFERENCES `music` (`id`),
  CONSTRAINT `avaliations_FK_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;


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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

INSERT INTO music_manager.avaliations (score,userId,musicId) VALUES
	 (5,1,1),
	 (4,1,2),
	 (3,1,3),
	 (9,1,4);

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

   INSERT INTO music_manager.music (name) VALUES
	 ('Time'),
	 ('Highway to Hell'),
	 ('Angel of death'),
	 ('Starway to haven');

   INSERT INTO music_manager.music_genres (musicId,genreId) VALUES
	 (1,1),
	 (2,1),
	 (3,1),
	 (4,1);

   INSERT INTO music_manager.user_genres (userId,genreId,`date`) VALUES
	 (1,1,'2020-11-29 19:10:35.0'),
	 (2,1,'2020-11-29 20:13:06.0');

   INSERT INTO music_manager.users (name,password,email) VALUES
	 ('Luciano','$2a$10$j7KZuHbLWZdpUhKNklMIMORmAgXHOpJmKw92Wou3ABbrq9U8JsWqm','luciano.ssants@gmail.com'),
	 ('Vinicius','$2a$10$fyL8TNh8hMnxC/J1CJNbWeJmvmb8y9mOMGfXBoIJWwHRB2e4ehoa.','vinicius@teste.com');