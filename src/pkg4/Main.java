package pkg4;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Book book3 = new Book("3","title3", "author3");
        System.out.println(book3.getTitle());

        InMemoryBookRepository lib = new InMemoryBookRepository();
        Book book1 = lib.findById("1");
        System.out.println(book1.getAuthor());

        Book book4=lib.putNewBook("4","title4","author4");
        System.out.println(book4.getAuthor());

        String book3Id=lib.putBook(book3);
        System.out.println(book3Id);

        BookService libService = new BookService(lib);
        Book book5=libService.putNewBook("5","title5","author5");

        System.out.println("---");
        List<Book> books =  lib.findAll();
        for (Book el: books) {
            System.out.println(el.getTitle());
        }

    }
}
