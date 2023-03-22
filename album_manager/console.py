from models.album import Album
from models.artist import Artist
import repositories.album_repository as album_repository
import repositories.artist_repository as artist_repository

album_repository.delete_all()
artist_repository.delete_all()

genre = "Rock"


artist1 = Artist("John", "Lennon")
artist_repository.save(artist1)

artist2 = Artist("Paul", "McCartney")
artist_repository.save(artist2)

album1 = Album("Abbey Road", artist1, 1969, genre)
album_repository.save(album1)

album2 = Album("Revolver", artist2, 1966, genre)
album_repository.save(album2)


album1.title = "Abbey Road (Remastered)"
album_repository.update(album1)

result = album_repository.select_all()

for album in result:
    print(album.id)

artist1_albums = album_repository.albums_for_artist(artist1)

print(f"{artist2.first_name}'s albums:")
for album in artist1_albums:
    print(f"{album2.title} ({album2.genre})")


