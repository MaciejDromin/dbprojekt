package pl.mlisowski.dbprojekt.bookmanagement.application.port;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mlisowski.dbprojekt.bookmanagement.domain.core.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
