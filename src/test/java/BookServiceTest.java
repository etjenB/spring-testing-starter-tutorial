import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    //------ assertTrue assertFalse

    @Test
    @DisplayName("Test Get Library Empty")
    @Disabled
    void testGetLibrary() {
        BookService bookService = new BookService();
        List<Book> foundLibrary = bookService.getLibrary();
        assertTrue(foundLibrary.isEmpty(), "Library should be empty!");
    }

    @Test
    void testAddBookToLibrary() {
        BookService bookService = new BookService();
        Book book = Book.builder()
                .id(1L)
                .title("Harry Potter and the Sorcerer's Stone")
                .author("J.K. Rowling")
                .publishedYear(1997)
                .inStock(true)
                .ratings(List.of(5, 4, 5, 3 ,5))
                .build();
        bookService.addBookToLibrary(book);
        List<Book> foundLibrary = bookService.getLibrary();
        assertFalse(foundLibrary.isEmpty());
    }

    //------ assertNull assertNotNull

    @Test
    void testGetBookById() {
        BookService bookService = new BookService();
        Book book = Book.builder()
                .id(1L)
                .title("Harry Potter and the Sorcerer's Stone")
                .author("J.K. Rowling")
                .publishedYear(1997)
                .inStock(true)
                .ratings(List.of(5, 4, 5, 3 ,5))
                .build();
        bookService.addBookToLibrary(book);
        Book foundBook = bookService.getBookById(book.getId());
        assertNotNull(foundBook);
    }

    @Test
    void testGetBookByIdNotFound() {
        BookService bookService = new BookService();
        Book book = Book.builder()
                .id(1L)
                .title("Harry Potter and the Sorcerer's Stone")
                .author("J.K. Rowling")
                .publishedYear(1997)
                .inStock(true)
                .ratings(List.of(5, 4, 5, 3 ,5))
                .build();
        bookService.addBookToLibrary(book);
        Book foundBook = bookService.getBookById(Long.MAX_VALUE);
        assertNull(foundBook, "Book should be null!");
    }

    //------ assertEquals assertNotEquals

    @Test
    void testSetOutOfStock() {
        BookService bookService = new BookService();
        Book book = Book.builder()
                .id(1L)
                .title("Harry Potter and the Sorcerer's Stone")
                .author("J.K. Rowling")
                .publishedYear(1997)
                .inStock(true)
                .ratings(List.of(5, 4, 5, 3 ,5))
                .build();
        bookService.addBookToLibrary(book);
        bookService.setOutOfStock(book);
        assertEquals(false, book.getInStock());
        assertFalse(book.getInStock());
    }

    @Test
    void testSetAuthorByBookId() {
        BookService bookService = new BookService();
        String oldAuthor = "J.K. Rowling";
        Book book = Book.builder()
                .id(1L)
                .title("Harry Potter and the Sorcerer's Stone")
                .author(oldAuthor)
                .publishedYear(1997)
                .inStock(true)
                .ratings(List.of(5, 4, 5, 3 ,5))
                .build();
        bookService.addBookToLibrary(book);
        bookService.setNewAuthorByBookId(book.getId(), "new author");
        assertNotEquals(oldAuthor, book.getAuthor());
    }

    @Test
    void testSetAuthorByBookIdBookNotFound() {
        BookService bookService = new BookService();
        String oldAuthor = "J.K. Rowling";
        Book book = Book.builder()
                .id(1L)
                .title("Harry Potter and the Sorcerer's Stone")
                .author(oldAuthor)
                .publishedYear(1997)
                .inStock(true)
                .ratings(List.of(5, 4, 5, 3 ,5))
                .build();
        bookService.addBookToLibrary(book);
        bookService.setNewAuthorByBookId(Long.MAX_VALUE, "new author");
        assertEquals(oldAuthor, book.getAuthor());
    }

    //----- assertArrayEquals

//    @Test
//    void testFindBooksByAuthorName() {
//        BookService bookService = new BookService();
//        Book book1 = Book.builder()
//                .id(1L)
//                .title("BookA1")
//                .author("Author1")
//                .publishedYear(1997)
//                .inStock(true)
//                .ratings(List.of(5, 4, 5, 3 ,5))
//                .build();
//        Book book2 = Book.builder()
//                .id(2L)
//                .title("BookA2")
//                .author("Author1")
//                .publishedYear(1997)
//                .inStock(true)
//                .ratings(List.of(5, 4, 5, 3 ,5))
//                .build();
//        Book book3 = Book.builder()
//                .id(3L)
//                .title("BookB1")
//                .author("Author2")
//                .publishedYear(1997)
//                .inStock(true)
//                .ratings(List.of(5, 4, 5, 3 ,5))
//                .build();
//        bookService.addBookToLibrary(book1);
//        bookService.addBookToLibrary(book2);
//        bookService.addBookToLibrary(book3);
//        Book[] foundBooks = bookService.getBooksByAuthorName("Author1");
//        assertArrayEquals(new Book[]{book1, book2}, foundBooks);
//    }

    @Test
    void testFindBooksByAuthorName() {
        BookService bookService = new BookService();
        Book book1 = Book.builder()
                .id(1L)
                .title("BookA1")
                .author("Author1")
                .publishedYear(1997)
                .inStock(true)
                .ratings(List.of(5, 4, 5, 3 ,5))
                .build();
        Book book2 = Book.builder()
                .id(2L)
                .title("BookA2")
                .author("Author1")
                .publishedYear(1997)
                .inStock(true)
                .ratings(List.of(5, 4, 5, 3 ,5))
                .build();
        Book book3 = Book.builder()
                .id(3L)
                .title("BookB1")
                .author("Author2")
                .publishedYear(1997)
                .inStock(true)
                .ratings(List.of(5, 4, 5, 3 ,5))
                .build();
        bookService.addBookToLibrary(book1);
        bookService.addBookToLibrary(book2);
        bookService.addBookToLibrary(book3);
        List<Book> foundBooks = bookService.getBooksByAuthorName("Author1");
        assertEquals(List.of(book1, book2), foundBooks);
    }

    //------ assertIterableEquals

    @Test
    void testFindBooksByAuthorNameIterable() {
        BookService bookService = new BookService();
        Book book1 = Book.builder()
                .id(1L)
                .title("BookA1")
                .author("Author1")
                .publishedYear(1997)
                .inStock(true)
                .ratings(List.of(5, 4, 5, 3 ,5))
                .build();
        Book book2 = Book.builder()
                .id(2L)
                .title("BookA2")
                .author("Author1")
                .publishedYear(1997)
                .inStock(true)
                .ratings(List.of(5, 4, 5, 3 ,5))
                .build();
        Book book3 = Book.builder()
                .id(3L)
                .title("BookB1")
                .author("Author2")
                .publishedYear(1997)
                .inStock(true)
                .ratings(List.of(5, 4, 5, 3 ,5))
                .build();
        bookService.addBookToLibrary(book1);
        bookService.addBookToLibrary(book2);
        bookService.addBookToLibrary(book3);
        List<Book> foundBooks = bookService.getBooksByAuthorName("Author1");
        LinkedList<Book> expectedBooks = new LinkedList<>(List.of(book1, book2));
        assertIterableEquals(expectedBooks, foundBooks);
    }

    //------ assertThrows assertThrowsExactly

    @Test
    void testGetBookByTitleThrowsBookNotFoundException() {
        BookService bookService = new BookService();
        Book book = Book.builder()
                .id(1L)
                .title("Harry Potter and the Sorcerer's Stone")
                .author("J.K. Rowling")
                .publishedYear(1997)
                .inStock(true)
                .ratings(List.of(5, 4, 5, 3 ,5))
                .build();
        bookService.addBookToLibrary(book);
        assertThrows(BookNotFoundException.class, () -> bookService.getBookByTitle(""));
    }

    @Test
    void testGetBookByTitleThrowsExactlyBookNotFoundException() {
        BookService bookService = new BookService();
        Book book = Book.builder()
                .id(1L)
                .title("Harry Potter and the Sorcerer's Stone")
                .author("J.K. Rowling")
                .publishedYear(1997)
                .inStock(true)
                .ratings(List.of(5, 4, 5, 3 ,5))
                .build();
        bookService.addBookToLibrary(book);
        assertThrowsExactly(BookNotFoundException.class, () -> bookService.getBookByTitle(""));
    }

    //------ assertSame assertNotSame

    @Test
    void testGetByBookIdSame() {
        BookService bookService = new BookService();
        Book book = Book.builder()
                .id(1L)
                .title("Harry Potter and the Sorcerer's Stone")
                .author("J.K. Rowling")
                .publishedYear(1997)
                .inStock(true)
                .ratings(List.of(5, 4, 5, 3 ,5))
                .build();
        bookService.addBookToLibrary(book);
        Book foundBook = bookService.getBookById(book.getId());
        assertSame(book, foundBook);
    }

    @Test
    void testTwoBooksNotSame() {
        Book book1 = Book.builder()
                .id(1L)
                .title("Harry Potter and the Sorcerer's Stone")
                .author("J.K. Rowling")
                .publishedYear(1997)
                .inStock(true)
                .ratings(List.of(5, 4, 5, 3 ,5))
                .build();
        Book book2 = Book.builder()
                .id(1L)
                .title("Harry Potter and the Sorcerer's Stone")
                .author("J.K. Rowling")
                .publishedYear(1997)
                .inStock(true)
                .ratings(List.of(5, 4, 5, 3 ,5))
                .build();
        assertEquals(book1, book2);
        assertNotSame(book1, book2);
    }
}