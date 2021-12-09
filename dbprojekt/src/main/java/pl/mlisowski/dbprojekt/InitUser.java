package pl.mlisowski.dbprojekt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.mlisowski.dbprojekt.administration.application.AddressService;
import pl.mlisowski.dbprojekt.administration.application.UserService;
import pl.mlisowski.dbprojekt.administration.domain.core.Address;
import pl.mlisowski.dbprojekt.administration.domain.enums.Role;


public class InitUser implements CommandLineRunner {

    @Autowired
    private PasswordEncoder enc;

    @Autowired
    private UserService userService;

    @Autowired
    private AddressService addressService;

    @Override
    public void run(String... args) throws Exception {
        //addressService.addAddress("Test", "papa", "Cipa");
        //userService.addUser("Testowy", enc.encode("test123"), Role.ADMIN.name(), 1);
    }
}
