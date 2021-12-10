package pl.mlisowski.dbprojekt.administration.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.mlisowski.dbprojekt.administration.application.port.UserRepository;
import pl.mlisowski.dbprojekt.administration.domain.core.User;
import pl.mlisowski.dbprojekt.administration.domain.enums.Role;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private UserRepository repository;
    private AddressService addressService;
    @Autowired
    private PasswordEncoder enc;

    public UserService(UserRepository repository, AddressService addressService){
        this.repository = repository;
        this.addressService = addressService;
    }

    public User addUser(String name, String password, String role, Integer address, Integer enabled){
        User u = new User(name, enc.encode(password), Role.valueOf(role), addressService.getAddressById(address), enabled);
        return repository.save(u);
    }

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public boolean deleteUserById(Integer id){
        boolean exists = repository.existsById(id);
        if(!exists) return exists;
        repository.deleteById(id);
        return exists;
    }

    public Optional<User> findUserById(Integer id){
        return repository.findById(id);
    }

    public Optional<User> findUserByUsername(String username){
        return repository.findUserByUsername(username);
    }

    public User getUserById(Integer id){
        return repository.getById(id);
    }

}
