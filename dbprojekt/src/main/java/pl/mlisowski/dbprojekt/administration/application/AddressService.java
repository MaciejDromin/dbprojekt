package pl.mlisowski.dbprojekt.administration.application;

import org.springframework.stereotype.Service;
import pl.mlisowski.dbprojekt.administration.application.port.AddressRepository;
import pl.mlisowski.dbprojekt.administration.domain.core.Address;

import java.util.Optional;

@Service
public class AddressService {

    private AddressRepository repository;

    public AddressService(AddressRepository repository){
        this.repository = repository;
    }

    public Address addAddress(String city, String street, String zipcode){
        Address u = new Address(city, street, zipcode);
        return repository.save(u);
    }

    public Optional<Address> findAddressById(Integer id){
        return repository.findById(id);
    }
    
    public Address getAddressById(Integer id){
        return repository.getById(id);
    }
}
