package guru.springframework.spring5webapp.controller;


import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;


@RequestMapping("/books")
    private String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("authors",authorRepository.findAll());
        return "/list";
    }


}

