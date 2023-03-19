import uuid

class Book:
    def __init__(self, title, author, synopsis, checked_out=False, genre=None, id=None):
        self.title = title
        self.author = author
        self.synopsis = synopsis
        self.checked_out = checked_out
        self.genre = genre
        self.id = id or uuid.uuid4().hex # assign a unique ID if none is provided
