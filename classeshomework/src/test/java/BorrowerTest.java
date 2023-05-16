import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BorrowerTest {
    @Test
    public void testBorrowBook() {
        Library library = new Library(5);
        Book book = new Book("Title", "Author", "Genre");
        library.addBook(book);
        Borrower borrower = new Borrower();
        borrower.borrowBook(library, book);
        assertEquals(1, borrower.getBorrowedBooks().size());
        assertEquals(0, library.countBooks());
    }
}
