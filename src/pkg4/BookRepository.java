package pkg4;

import java.util.List;

public interface BookRepository {
    Book findById(String id);
    List<Book> findAll();
    Book putNewBook(String id, String title, String author);
    String putBook(Book book);
}
