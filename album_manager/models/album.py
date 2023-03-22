class Album:
    def __init__(self, title, artist, year, genre, id=None, rating=None):
        
        self.title = title
        self.artist = artist
        self.year = year
        self.genre = genre
        self.id = id
        self.rating = rating

    def set_rating(self, rating):
        self.rating = rating
