package guru.springframework.spring5webapp.bootStrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;


    public BootStapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Mayank","Sharma");
        Book eric_book = new Book("Iam happy", "2345667" );

        eric.getBooks().add(eric_book);
        eric_book.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(eric_book);

        Author karni = new Author("Karnika", "sharma");
        Book KAr_bk = new Book("life with me", "112222333");

        karni.getBooks().add(KAr_bk);
        KAr_bk.getAuthors().add(karni);

        authorRepository.save(karni);
        bookRepository.save(KAr_bk);
        System.out.println("started in Bootstrap");
        System.out.println("Number of Books" + bookRepository.count());
        System.out.println("Number of Author" + authorRepository.count());

    }

}
