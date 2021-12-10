package pl.mlisowski.dbprojekt.borrowings.application;

import org.springframework.stereotype.Service;
import pl.mlisowski.dbprojekt.administration.application.UserService;
import pl.mlisowski.dbprojekt.bookmanagement.application.BookService;
import pl.mlisowski.dbprojekt.borrowings.application.port.BorrowingRepository;
import pl.mlisowski.dbprojekt.borrowings.domain.core.Borrowing;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BorrowingService {

    private BorrowingRepository repository;
    private UserService userService;
    private BookService bookService;

    public BorrowingService(BorrowingRepository repository,
                            UserService userService,
                            BookService bookService){
        this.repository = repository;
        this.userService = userService;
        this.bookService = bookService;
    }

    public List<Borrowing> findAll(){
        return repository.findAll();
    }

    public List<Borrowing> findAllByUserId(Integer userId){
        return repository.findAllByUser_Id(userId);
    }

    public Borrowing addBorrowing(Integer userid, Integer bookid){
        Borrowing b = new Borrowing(userService.getUserById(userid), bookService.getBookById(bookid));
        bookService.decrementQuantity(bookid);
        return repository.save(b);
    }

    public void deleteBorrowing(Integer userid, Integer bookid){
        bookService.incrementQuantity(bookid);
        repository.deleteBorrowingByUser_IdAndBook_Id(userid, bookid);
    }

}
