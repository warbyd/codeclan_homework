import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    @Test
    public void testLibraryCreation() {
        Library library = new Library(5);
        assertEquals(0, library.countBooks());
    }

    @Test
    public void testAddBook() {
        Library library = new Library(5);
        Book book = new Book("Title", "Author", "Genre");
        assertTrue(library.addBook(book));
        assertEquals(1, library.countBooks());
    }

    @Test
    public void testAddBookBeyondCapacity() {
        Library library = new Library(1);
        Book book1 = new Book("Title1", "Author1", "Genre1");
        Book book2 = new Book("Title2", "Author2", "Genre2");
        library.addBook(book1);
        assertFalse(library.addBook(book2));
        assertEquals(1, library.countBooks());
    }

    @Test
    public void testGetBooksByGenre() {
        Library library = new Library(5);
        Book book1 = new Book("Title1", "Author1", "Genre1");
        Book book2 = new Book("Title2", "Author2", "Genre1");
        library.addBook(book1);
        library.addBook(book2);
        Map<String, Integer> booksByGenre = library.getBooksByGenre();
        assertEquals(2, booksByGenre.get("Genre1").intValue());
    }
}

