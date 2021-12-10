package pl.mlisowski.dbprojekt.bookmanagement.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mlisowski.dbprojekt.bookmanagement.application.AuthorService;
import pl.mlisowski.dbprojekt.bookmanagement.application.BookService;
import pl.mlisowski.dbprojekt.bookmanagement.domain.core.Book;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService service;
    private AuthorService authorService;

    public BookController(BookService service, AuthorService authorService){
        this.service = service;
        this.authorService = authorService;
    }

    @GetMapping("/")
    public String getAll(Model model){
        model.addAttribute("books", service.getAllBooks());
        return "books.html";
    }

    @GetMapping("/add")
    public String getAddBook(Model model){
        model.addAttribute("authors", authorService.getAllAuthors());
        return "addBook.html";
    }

    @PostMapping("/add")
    public String addBook(@RequestParam String name,
                          @RequestParam Integer authorId,
                          Model model){
        Book b = service.addBook(name, 1, authorId);
        model.addAttribute("book", b);
        return "viewBook.html";
    }

}
