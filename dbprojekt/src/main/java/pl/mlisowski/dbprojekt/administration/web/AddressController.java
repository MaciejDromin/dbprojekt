package pl.mlisowski.dbprojekt.administration.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mlisowski.dbprojekt.administration.application.AddressService;
import pl.mlisowski.dbprojekt.administration.domain.core.Address;

@Controller
@RequestMapping("/address")
public class AddressController {

    private AddressService service;

    public AddressController (AddressService service){
        this.service = service;
    }

    @GetMapping("/")
    public String getAll(Model model){
        model.addAttribute("addresses", service.findAll());
        return "address.html";
    }

    @GetMapping("/add")
    public String getAddAddress(){
        return "addAddress.html";
    }

    @PostMapping("/add")
    public String addAddress(@RequestParam String city,
                             @RequestParam String street,
                             @RequestParam String zipcode,
                             Model model){
        Address a = service.addAddress(city, street, zipcode);
        model.addAttribute("address", a);
        return "viewAddress.html";
    }
}
