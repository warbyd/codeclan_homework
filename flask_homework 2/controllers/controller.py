from flask import render_template, request, redirect
from app import app
from models.book_list import books, uuid, find_book
from models.book import Book

@app.route('/books')
def index():
    return render_template('index.html', title='Library Book List', books=books)

@app.route('/books', methods=['GET', 'POST',])
def add_book():
    if request.method == 'POST':
        
        title = request.form.get('title')
        author = request.form.get('author')
        synopsis = request.form.get('synopsis')
        genre = request.form.get('genre')
        checked_out = False  

        book = Book(title=title, author=author, synopsis=synopsis, genre=genre, checked_out=checked_out)
        books.append(book)

        return redirect('/books')

@app.route('/books/<book_id>')
def book_detail(book_id):
    book = find_book(book_id)
    if book:
        return render_template('book_detail.html', book=book)
    else:
        return "Book not found"




@app.route('/books/<book_id>/remove', methods=['POST'])
def remove_book(book_id):
    for book in books:
        if book.id == book_id:
            books.remove(book)
            break
    return redirect('/books')

@app.route('/books/<book_id>/update', methods=['POST'])
def update_book(book_id):
    book = find_book(book_id)
    if book:
        book.checked_out = not book.checked_out
        return redirect('/books')
    else:
        return "Book not found"












