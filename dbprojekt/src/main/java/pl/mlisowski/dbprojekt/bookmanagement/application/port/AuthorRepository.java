package pl.mlisowski.dbprojekt.bookmanagement.application.port;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mlisowski.dbprojekt.bookmanagement.domain.core.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
