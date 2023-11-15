package pkg4;

import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public Book findBookById(String id)
    {
        return bookRepository.findById(id);
    }

    public List<Book> findAllBooks()
    {
        return bookRepository.findAll();
    }

    public Book putNewBook(String id, String title, String author){
        return bookRepository.putNewBook(id,title,author);
    }

    public String putBook(Book book){
         return bookRepository.putBook(book);
    }
}

