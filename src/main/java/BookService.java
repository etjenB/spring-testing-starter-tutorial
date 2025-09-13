import java.util.ArrayList;
import java.util.List;

public class BookService {
    private List<Book> library = new ArrayList<>();

    public List<Book> getLibrary() {
        return library;
    }

    public void addBookToLibrary(Book book) {
        library.add(book);
    }

    public Book getBookById(Long id) {
        return library.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void setOutOfStock(Book book) {
        book.setInStock(false);
    }

    public void setNewAuthorByBookId(Long bookId, String author) {
        Book foundBook = library.stream()
                .filter(book -> book.getId().equals(bookId))
                .findFirst()
                .orElse(null);
        if (foundBook == null)
            return;
        foundBook.setAuthor(author);
    }

//    public Book[] getBooksByAuthorName(String author) {
//        return library.stream().filter(book -> book.getAuthor().equals(author)).toArray(Book[]::new);
//    }

    public List<Book> getBooksByAuthorName(String author) {
        return library.stream().filter(book -> book.getAuthor().equals(author)).toList();
    }

    public Book getBookByTitle(String title) {
        return library
                .stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book was not found!"));
    }
}
