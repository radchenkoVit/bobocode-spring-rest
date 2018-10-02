drop table if exists actor;
drop table if exists movie;
drop table if exists movie_actor;

create table actor(
  id BIGINT IDENTITY,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  CONSTRAINT actor_PK PRIMARY KEY (id)
);

create table movie(
  id BIGINT IDENTITY,
  name varchar(255) NOT NULL,
  CONSTRAINT movie_PK PRIMARY KEY (id)
);

create table movie_actor(
  movie_id BIGINT,
  actor_id BIGINT,
  CONSTRAINT movie_actor_movie_FK FOREIGN KEY (movie_id) REFERENCES movie,
  CONSTRAINT movie_actor_actor_FK FOREIGN KEY (actor_id) REFERENCES actor,
  CONSTRAINT movie_actor_PK PRIMARY KEY (movie_id, actor_id)
);

INSERT INTO actor values (1, 'Jackie', 'Chan');
INSERT INTO movie values (1, 'The karate kid');
INSERT INTO movie_actor values (1, 1);