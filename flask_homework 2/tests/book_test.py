import unittest
from app import app
from models.book_list import books
from models.book import Book


class TestBook(unittest.TestCase):

    def setUp(self):
        self.app = app.test_client()
        app.config['TESTING'] = True

    def test_add_book(self):
        title = "Harry Potter"
        author = "J.K. Rowling"
        synopsis = "A boy wizard saves the world from a dark wizard"
        genre = "Fantasy"
        checked_out = True

        data = {
            'title': title,
            'author': author,
            'synopsis': synopsis,
            'genre': genre
        }

        response = self.app.post('/books', data=data, follow_redirects=True)
        self.assertEqual(response.status_code, 200)
        self.assertEqual(len(books), 8)
        self.assertEqual(books[0].title, title)
        self.assertEqual(books[0].author, author)
        self.assertEqual(books[0].synopsis, synopsis)
        self.assertEqual(books[0].genre, genre)
        self.assertEqual(books[0].checked_out, checked_out)

    def test_book_detail(self):
        book = Book(title="Test Book", author="Test Author", synopsis="Test Synopsis", genre="Test Genre", checked_out=False)
        books.append(book)

        response = self.app.get(f'/books/{book.id}')
        self.assertEqual(response.status_code, 200)
        self.assertIn(book.title.encode(), response.data)
        self.assertIn(book.author.encode(), response.data)
        self.assertIn(book.synopsis.encode(), response.data)
        self.assertIn(book.genre.encode(), response.data)

    def test_remove_book(self):
        book = Book(title="Test Book", author="Test Author", synopsis="Test Synopsis", genre="Test Genre", checked_out=False)
        books.append(book)

        response = self.app.post(f'/books/{book.id}/remove', follow_redirects=True)
        self.assertEqual(response.status_code, 200)
        self.assertEqual(len(books), 9)

    def test_update_book(self):
        book = Book(title="Test Book", author="Test Author", synopsis="Test Synopsis", genre="Test Genre", checked_out=False)
        books.append(book)

        response = self.app.post(f'/books/{book.id}/update', follow_redirects=True)
        self.assertEqual(response.status_code, 200)
        self.assertTrue(book.checked_out)
