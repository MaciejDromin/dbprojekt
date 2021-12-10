package pl.mlisowski.dbprojekt.borrowings.web;

import org.springframework.context.annotation.Role;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mlisowski.dbprojekt.administration.application.UserService;
import pl.mlisowski.dbprojekt.administration.domain.core.User;
import pl.mlisowski.dbprojekt.bookmanagement.application.BookService;
import pl.mlisowski.dbprojekt.bookmanagement.domain.core.Book;
import pl.mlisowski.dbprojekt.borrowings.application.BorrowingService;
import pl.mlisowski.dbprojekt.borrowings.domain.core.Borrowing;

@Controller
@RequestMapping("/borrowings")
public class BorrowingController {

    private BorrowingService service;
    private BookService bookService;
    private UserService userService;

    public BorrowingController(BorrowingService service,
                               BookService bookService,
                               UserService userService){
        this.service = service;
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAll(Model model){
        model.addAttribute("borrowings", service.findAll());
        return "borrowings.html";
    }

    @GetMapping("/add")
    public String getAddBorrowing(Model model){
        model.addAttribute("books", bookService.findAllByQuantity(0));
        return "addBorrowing.html";
    }

    @PostMapping("/add")
    public String addBorrowing(@RequestParam Integer bookId, Model model){
        User u = userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
        Borrowing b = service.addBorrowing(u.getId(), bookId);
        model.addAttribute("borrowing", b);
        return "viewBorrowing.html";
    }

    @GetMapping("/return")
    public String getReturnBorrowing(Model model){
        User u = userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
        model.addAttribute("borrowings", service.findAllByUserId(u.getId()));
        return "returnBorrowing.html";
    }

    @PostMapping("/return")
    public String removeBorrowing(@RequestParam Integer bookId, Model model){
        User u = userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
        Book b = bookService.getBookById(bookId);
        model.addAttribute("book", b);
        service.deleteBorrowing(u.getId(), bookId);
        return "viewReturnBor.html";
    }

}
