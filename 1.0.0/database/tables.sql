-- genres definition

CREATE TABLE `genres` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


-- music definition

CREATE TABLE `music` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


-- users definition

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(256) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


-- avaliations definition

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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


-- music_genres definition

CREATE TABLE `music_genres` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `musicId` int(11) DEFAULT NULL,
  `genreId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `music_genres_FK` (`musicId`),
  KEY `music_genres_FK_1` (`genreId`),
  CONSTRAINT `music_genres_FK` FOREIGN KEY (`musicId`) REFERENCES `music` (`id`),
  CONSTRAINT `music_genres_FK_1` FOREIGN KEY (`genreId`) REFERENCES `genres` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


-- user_genres definition

CREATE TABLE `user_genres` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `genreId` int(11) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_genres_userId_IDX` (`userId`,`genreId`) USING BTREE,
  KEY `user_genres_FK` (`genreId`),
  CONSTRAINT `user_genres_FK` FOREIGN KEY (`genreId`) REFERENCES `genres` (`id`),
  CONSTRAINT `user_genres_FK_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


   INSERT INTO genres (name) VALUES
	 ('Rock'),
	 ('Sertanejo'),
	 ('Pagode'),
	 ('Pop'),
	 ('MPB');


   INSERT INTO music (name) VALUES
	 ('Time'),
	 ('Highway to Hell'),
	 ('Angel of death'),
	 ('Starway to haven'),
	 ('Garota de Ipanema'),
	 ('Aquarela'),
	 ('Dormi na praça'),
	 ('Evidências'),
	 ('Back in Black'),
	 ('Eu Sei Que Vou Te Amar');
INSERT INTO music (name) VALUES
	 ('Como é Grande o meu amor por você'),
	 ('Aquarela Brasileira'),
	 ('Querendo te amar'),
	 ('Sinônimos'),
	 ('Infiel'),
	 ('Lancinho'),
	 ('Futuro Prometido'),
	 ('Péssimo Negócio'),
	 ('Me Apaixonei Pela Pessoa Errada'),
	 ('Deixa Acontecer Naturalmente');
INSERT INTO music (name) VALUES
	 ('Photograph'),
	 ('Talking to the moon'),
	 ('Love Someone'),
	 ('93 Million Miles'),
	 ('Break My Heart');


      INSERT INTO users (name,password,email) VALUES
	 ('Teste 1','$2a$10$YlwVoLn1jtMRVu2Cv.6tEu1.PuTTNdwVOE7JZxpE2SEln/De7SwQe','teste1@teste.com'),
	 ('Teste 2','$2a$10$hwBh3FEpgk28q4GCuobMG.NgnidFuXYKPHk4NqJSGsK9sMDAQ2o4y','teste2@teste.com'),
	 ('Teste 3','$2a$10$VKt7ZAeupwjDHhmTz9DyVOXk3TTz9KdpCP7NtIBQBHd0GCbhtJE0S','teste3@teste.com'),
	 ('Teste 4','$2a$10$jpfO66GkVTZ8i8c2tRwa7OeboMEBN/pKtHKNJISysyvQpH5DGGb.i','teste4@teste.com'),
	 ('Teste 5','$2a$10$ts49ycLg4BBFbxPTySbimuCKirJVWvtLQ5AXVRLKpEabUADkyfHuC','teste5@teste.com');



   INSERT INTO music_genres (musicId,genreId) VALUES
	 (1,1),
	 (2,1),
	 (3,1),
	 (4,1),
	 (5,9),
	 (6,9),
	 (7,4),
	 (8,4),
	 (9,1),
	 (10,9);
INSERT INTO music_genres (musicId,genreId) VALUES
	 (11,9),
	 (12,9),
	 (15,4),
	 (14,4),
	 (13,4),
	 (16,6),
	 (17,6),
	 (18,6),
	 (19,6),
	 (20,6);
INSERT INTO music_genres (musicId,genreId) VALUES
	 (21,7),
	 (22,7),
	 (23,7),
	 (24,7),
	 (25,7);

   INSERT INTO user_genres (userId,genreId,`date`) VALUES
	 (4,1,'2020-12-01 23:06:22.0'),
	 (4,4,'2020-12-01 23:06:25.0'),
	 (8,1,'2020-12-01 23:13:59.0'),
	 (8,4,'2020-12-01 23:14:09.0');

   INSERT INTO avaliations (score,userId,musicId) VALUES
	 (1,4,1),
	 (5,4,2),
	 (4,4,3),
	 (2,4,4),
	 (3,4,9),
	 (1,5,1),
	 (4,5,2),
	 (2,5,3),
	 (2,5,4),
	 (6,5,9);
INSERT INTO avaliations (score,userId,musicId) VALUES
	 (1,6,1),
	 (2,6,2),
	 (3,6,3),
	 (4,6,4),
	 (5,6,9),
	 (5,6,7),
	 (4,6,8),
	 (3,6,15),
	 (2,6,14),
	 (1,6,13);
INSERT INTO avaliations (score,userId,musicId) VALUES
	 (4,6,16),
	 (3,6,17),
	 (4,6,18),
	 (5,6,19),
	 (2,6,20),
	 (5,8,1),
	 (5,8,3);

