use Progetto_Modulo_2;

CREATE TABLE `Credenziali` (
  `id_utente` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `passsword` varchar(100) NOT NULL,

  PRIMARY KEY (`id_utente`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

insert into `Credenziali` (`username`,`passsword`)
values ("Stefano","root"),
 ("Michele","user"),("Simona","user"),
 ("Daniele","user"),("Cosmin","user"),
 ("Maurizio","user");

drop table  `Credenziali`;