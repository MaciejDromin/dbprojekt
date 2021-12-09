package pl.mlisowski.dbprojekt.administration.application.port;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mlisowski.dbprojekt.administration.domain.core.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
