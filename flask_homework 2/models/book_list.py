from models.book import *
import uuid



book1 = Book("Harry Potter", "J.K. Rowling", "A boy wizard saves the world from a dark wizard", genre="Fantasy", checked_out=True)
book2 = Book("The Lord of the Rings", "J.R.R. Tolkien", "A hobbit, a wizard, and a fellowship of other creatures embark on a journey to destroy a powerful ring and defeat an evil lord.", genre="Fantasy", checked_out=True)
book3 = Book("Alex Rider", "Anthony Horowitz", "A teenage spy takes on dangerous missions to save the world.", genre="Action/Adventure", checked_out=True)
book4 = Book("The Hobbit", "J.R.R. Tolkien", "Bilbo Baggins, a hobbit, embarks on a quest to reclaim treasure from a dragon.", genre="Fantasy", checked_out=False)
book5 = Book("Dune", "Frank Herbert", "In the far future, noble houses and religious orders battle for control of a desert planet that is the only source of a valuable spice.", genre="Science Fiction", checked_out=False)
book6 = Book("The Notebook", "Nicholas Sparks", "A young couple falls in love in the 1940s, but is separated by war and class differences.", genre="Romance", checked_out=True)
book7 = Book("The Adventures of Sherlock Holmes", "Arthur Conan Doyle", "Sherlock Holmes and Dr. Watson solve a series of baffling cases involving murder, theft, and deceit in Victorian London.", genre="Mystery", checked_out=False)




books = [book1, book2, book3, book4, book5, book6, book7]


def add_new_book(book):
    books.append(book)

def delete_item(book):
    if book in books:
        books.remove(book)
        return({'message': f'{book} has been removed from the list.'})
    else:
        return({'message': f'{book} is not in the list.'}), 404
    
def find_book(book_id):
    for book in books:
        if book.id == book_id:
            return book
    print(f"No book found with ID {book_id}")
    return None

def update_book(book_id, checked_out):
    book = find_book(book_id)
    if book:
        book.checked_out = checked_out
        return {'message': f"{book.title} has been updated."}
    else:
        return {'message': f"Book with ID {book_id} not found."}, 404





    
  

