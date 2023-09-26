CREATE DATABASE football;

USE football;

CREATE TABLE football.team (
                               id BIGINT auto_increment NOT NULL,
                               name varchar(200) NULL,
                               coach varchar(200) NULL,
                               `national` varchar(200) NULL,
                               CONSTRAINT team_PK PRIMARY KEY (id)
)
    ENGINE=InnoDB AUTO_INCREMENT=1
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci;

TRUNCATE table  football.team;


INSERT INTO football.team (name, coach, `national`)
VALUES
    ('Bayern Munich', 'Hansi Flick', 'Germany'),
    ('Liverpool', 'Jurgen Klopp', 'England'),
    ('Real Madrid', 'Carlo Ancelotti', 'Spain'),
    ('Paris Saint-Germain', 'Mauricio Pochettino', 'France'),
    ('Juventus', 'Massimiliano Allegri', 'Italy'),
    ('Manchester City', 'Pep Guardiola', 'England'),
    ('Chelsea', 'Thomas Tuchel', 'England'),
    ('Atletico Madrid', 'Diego Simeone', 'Spain'),
    ('Barcelona', 'Ronald Koeman', 'Spain'),
    ('Manchester United', 'Ole Gunnar Solskjaer', 'England'),
    ('Inter Milan', 'Simone Inzaghi', 'Italy'),
    ('AC Milan', 'Stefano Pioli', 'Italy'),
    ('Borussia Dortmund', 'Marco Rose', 'Germany'),
    ('Ajax', 'Erik ten Hag', 'Netherlands');




