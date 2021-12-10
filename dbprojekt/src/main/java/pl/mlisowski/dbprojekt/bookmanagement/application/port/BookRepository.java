package pl.mlisowski.dbprojekt.bookmanagement.application.port;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mlisowski.dbprojekt.bookmanagement.domain.core.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByQuantityGreaterThan(Integer val);
    Optional<Book> findByNameAndAuthor_Id(String name, Integer authorId);
}
