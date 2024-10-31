INSERT INTO authors (name,nickname,birthday)
VALUES ('Fov Rus Tandarovich','RF','2002-01-01'),
       ('Ivanov Ivan Ivanovich','IvI','1990-01-01'),
       ('Tatianova Tatiana Tatovna','Miranda','2001-12-12');

INSERT INTO genres (name)
VALUES ('classic'),
       ('detective'),
       ('horror'),
       ('adventure'),
       ('drama'),
       ('autobiography'),
       ('humor'),
       ('fairy'),
       ('fable'),
       ('tall'),
       ('historical'),
       ('mystery'),
       ('realistic'),
       ('science'),
       ('biography'),
       ('poetry'),
       ('tragedy');

INSERT INTO stories (genre_id, name)
VALUES (4,'Adventure Of Vasya Pupkin'),
       (14,'Computer Science');

INSERT INTO authors_stories(author_id,story_id) VALUES
                                                    (1,1),
                                                    (2,1),
                                                    (1,2),
                                                    (3,2);