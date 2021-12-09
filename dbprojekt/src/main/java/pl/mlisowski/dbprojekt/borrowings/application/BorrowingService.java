package pl.mlisowski.dbprojekt.borrowings.application;

import org.springframework.stereotype.Service;
import pl.mlisowski.dbprojekt.borrowings.application.port.BorrowingRepository;
import pl.mlisowski.dbprojekt.borrowings.domain.core.Borrowing;

import java.util.List;

@Service
public class BorrowingService {

    private BorrowingRepository repository;

    public BorrowingService(BorrowingRepository repository){
        this.repository = repository;
    }

    public List<Borrowing> findAll(){
        return repository.findAll();
    }

    public void deleteBorrowing(Integer userid, Integer bookid){
        repository.deleteBorrowingByUser_IdAndBook_Id(userid, bookid);
    }

}
