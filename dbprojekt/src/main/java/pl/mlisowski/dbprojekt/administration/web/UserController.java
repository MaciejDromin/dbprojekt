package pl.mlisowski.dbprojekt.administration.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mlisowski.dbprojekt.administration.application.AddressService;
import pl.mlisowski.dbprojekt.administration.application.UserService;
import pl.mlisowski.dbprojekt.administration.domain.core.Address;
import pl.mlisowski.dbprojekt.administration.domain.core.User;

@Controller
@RequestMapping("/users")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService service;
    private AddressService addressService;

    public UserController(UserService service, AddressService addressService){
        this.service = service;
        this.addressService = addressService;
    }

    @GetMapping("/")
    public String getAll(Model model){
        model.addAttribute("users", service.getAllUsers());
        logger.info("---Rozwiazalem nazwe, zwracam widok---");
        return "users.html";
    }

    @GetMapping("/add")
    public String getAddUser(Model model){
        model.addAttribute("addresses", addressService.getAllByUserIsNull());
        return "addUser.html";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String role,
                          @RequestParam Integer addressId,
                          Model model){
        User u = service.addUser(username, password, role, addressId, 1);
        model.addAttribute("user", u);
        return "viewUser.html";
    }

    @GetMapping("/delete")
    public String getDeleteUser(Model model){
        model.addAttribute("users", service.getAllUsers());
        return "deleteUser.html";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam Integer userId,
                             Model model){
        User u = service.getUserById(userId);
        model.addAttribute("user", u);
        service.deleteUser(userId);
        return "viewUser.html";
    }
}
