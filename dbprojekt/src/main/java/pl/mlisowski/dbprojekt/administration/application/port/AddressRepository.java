package pl.mlisowski.dbprojekt.administration.application.port;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mlisowski.dbprojekt.administration.domain.core.Address;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> getAllByUserIsNull();
}
