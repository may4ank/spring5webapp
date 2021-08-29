package guru.springframework.spring5webapp.bootStrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootStapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Mayank","Sharma");
        Book eric_book = new Book("Iam happy", "2345667" );
        Publisher pub1 = new Publisher("72 bank colony", "Agra","282001");

        eric.getBooks().add(eric_book);
        eric_book.getAuthors().add(eric);
        pub1.getBooks().add(eric_book);
        eric_book.setPublisher(pub1);
        authorRepository.save(eric);
        bookRepository.save(eric_book);
        publisherRepository.save(pub1);

        Author karni = new Author("Karnika", "sharma");
        Book KAr_bk = new Book("life with me", "112222333");
        Publisher pub2 = new Publisher("137 kanker khera","Meerut", "250001");

        karni.getBooks().add(KAr_bk);
        KAr_bk.getAuthors().add(karni);


        authorRepository.save(karni);
        bookRepository.save(KAr_bk);
        publisherRepository.save(pub2);
        System.out.println("started in Bootstrap");
        System.out.println("Number of Books" + bookRepository.count());
        System.out.println("Number of Author" + authorRepository.count());
        System.out.println("number of Publisher" + publisherRepository.count());

    }

}
