import java.util.*;

public class Borrower {
    private List<Book> borrowedBooks;

    public Borrower() {
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Library library, Book book) {
        Book removedBook = library.removeBook(book);
        if (removedBook != null) {
            borrowedBooks.add(removedBook);
        }
    }

    // method to check the borrower's collection
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
