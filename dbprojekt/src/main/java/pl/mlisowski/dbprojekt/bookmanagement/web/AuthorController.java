package pl.mlisowski.dbprojekt.bookmanagement.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mlisowski.dbprojekt.bookmanagement.application.AuthorService;
import pl.mlisowski.dbprojekt.bookmanagement.domain.core.Author;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService service;

    public AuthorController(AuthorService service){
        this.service = service;
    }

    @GetMapping("/")
    public String getAll(Model model){
        model.addAttribute("author", service.getAllAuthors());
        return "authors.html";
    }

    @GetMapping("/add")
    public String getAddBook(Model model){
        return "addAuthor.html";
    }

    @PostMapping("/add")
    public String addBook(@RequestParam String name, Model model){
        Author a = service.addAuthor(name);
        model.addAttribute("author", a);
        return "viewAuthor.html";
    }

}
