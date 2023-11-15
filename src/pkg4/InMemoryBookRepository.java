package pkg4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryBookRepository implements BookRepository  {
    private final Map<String, Book> books;

    public InMemoryBookRepository() {
        this.books = new HashMap<>();
        books.put("1", new Book("1", "Book1", "Author1"));
        books.put("2", new Book("2", "Book2", "Author2"));
    }

    @Override
    public Book findById(String id) {
        return books.get(id);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Book putNewBook(String id, String title, String author){
        Book book = new Book(id, title, author);
        books.put(id, book);
        return book;
    }

    @Override
    public String putBook(Book book){
        String id=book.getId();
        books.put(id, book);
        return id;
    }

}
