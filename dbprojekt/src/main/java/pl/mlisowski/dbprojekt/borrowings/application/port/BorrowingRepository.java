package pl.mlisowski.dbprojekt.borrowings.application.port;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mlisowski.dbprojekt.borrowings.domain.core.Borrowing;

import java.util.List;

public interface BorrowingRepository extends JpaRepository<Borrowing, Integer> {
    void deleteBorrowingByUser_IdAndBook_Id(Integer userId, Integer bookId);
    List<Borrowing> findAllByUser_Id(Integer userId);
}
