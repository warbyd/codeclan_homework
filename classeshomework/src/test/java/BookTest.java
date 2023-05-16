import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    @Test
    public void testBookCreation() {
        Book book = new Book("Title", "Author", "Genre");
        assertEquals("Title", book.getTitle());
        assertEquals("Author", book.getAuthor());
        assertEquals("Genre", book.getGenre());
    }
}
