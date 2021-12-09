package pl.mlisowski.dbprojekt.borrowings.application.port;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mlisowski.dbprojekt.borrowings.domain.core.Borrowing;

public interface BorrowingRepository extends JpaRepository<Borrowing, Integer> {
    void deleteBorrowingByUser_IdAndBook_Id(Integer userId, Integer bookId);
}
