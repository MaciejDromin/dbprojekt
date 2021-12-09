package pl.mlisowski.dbprojekt.administration.application.port;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mlisowski.dbprojekt.administration.domain.core.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
