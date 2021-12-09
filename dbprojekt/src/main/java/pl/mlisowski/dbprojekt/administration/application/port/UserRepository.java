package pl.mlisowski.dbprojekt.administration.application.port;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mlisowski.dbprojekt.administration.domain.core.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByUsername(String username);
}
