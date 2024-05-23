DROP TABLE IF EXISTS restoran;
CREATE TABLE restoran
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    naziv   VARCHAR(255) NOT NULL,
    adresa  VARCHAR(255) NOT NULL,
    telefon VARCHAR(255),
    ocena   DOUBLE
);

DROP TABLE IF EXISTS jelo;
CREATE TABLE jelo
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    naziv       VARCHAR(255) NOT NULL,
    opis        VARCHAR(255),
    cena        DOUBLE       NOT NULL,
    restoran_id BIGINT,
    FOREIGN KEY (restoran_id) REFERENCES restoran (id)
);

INSERT INTO restoran (naziv, adresa, telefon, ocena)
VALUES ('Restoran1', 'Adresa1', 'Telefon1', 4.5);

INSERT INTO restoran (naziv, adresa, telefon, ocena)
VALUES ('Restoran2', 'Adresa2', 'Telefon2', 4.2);

INSERT INTO restoran (naziv, adresa, telefon, ocena)
VALUES ('Restoran3', 'Adresa3', 'Telefon3', 4.8);

INSERT INTO restoran (naziv, adresa, telefon, ocena)
VALUES ('Restoran4', 'Adresa4', 'Telefon4', 4.4);

INSERT INTO restoran (naziv, adresa, telefon, ocena)
VALUES ('Restoran5', 'Adresa5', 'Telefon5', 4.1);

INSERT INTO jelo (naziv, opis, cena, restoran_id)
VALUES ('Jelo1', 'Opis1', 500, 1);
INSERT INTO jelo (naziv, opis, cena, restoran_id)
VALUES ('Jelo2', 'Opis2', 600, 2);
