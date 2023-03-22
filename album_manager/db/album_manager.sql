DROP TABLE IF EXISTS albums;
DROP TABLE IF EXISTS artists;

CREATE TABLE artists (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(50),
  last_name VARCHAR(50)
);

CREATE TABLE albums (
  id SERIAL PRIMARY KEY,
  title VARCHAR(255),
  artist_id INT NOT NULL REFERENCES artists(id) ON DELETE CASCADE,
  genre VARCHAR(255)
);

