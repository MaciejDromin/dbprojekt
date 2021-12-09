package pl.mlisowski.dbprojekt.administration.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.mlisowski.dbprojekt.administration.application.UserService;
import pl.mlisowski.dbprojekt.security.cfg.SecurityConfig;

@Controller
@RequestMapping("/admin/users")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping("/")
    public String getAll(Model model){
        model.addAttribute("users", service.getAllUsers());
        logger.info("---Rozwiazalem nazwe, zwracam widok---");
        return "users.html";
    }
}
