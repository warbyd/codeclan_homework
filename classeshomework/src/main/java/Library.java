import java.util.*;

public class Library {
    private List<Book> books;
    private int capacity;

    public Library(int capacity) {
        this.books = new ArrayList<>();
        this.capacity = capacity;
    }

    public int countBooks() {
        return books.size();
    }

    public boolean addBook(Book book) {
        if (books.size() < capacity) {
            books.add(book);
            return true;
        } else {
            return false;
        }
    }

    public Map<String, Integer> getBooksByGenre() {
        Map<String, Integer> booksByGenre = new HashMap<>();

        for (Book book : books) {
            String genre = book.getGenre();
            int count = booksByGenre.getOrDefault(genre, 0);
            booksByGenre.put(genre, count + 1);
        }

        return booksByGenre;
    }

    // method to remove a book from the library
    public Book removeBook(Book book) {
        if (books.remove(book)) {
            return book;
        } else {
            return null;
        }
    }
}
