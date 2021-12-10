package pl.mlisowski.dbprojekt.bookmanagement.application;

import org.springframework.stereotype.Service;
import pl.mlisowski.dbprojekt.bookmanagement.application.port.BookRepository;
import pl.mlisowski.dbprojekt.bookmanagement.domain.core.Author;
import pl.mlisowski.dbprojekt.bookmanagement.domain.core.Book;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {

    private BookRepository repository;
    private AuthorService authorService;

    public BookService(BookRepository repository, AuthorService authorService){
        this.repository = repository;
        this.authorService = authorService;
    }

    public Book addBook(String name, Integer quantity, Integer author){
        Book b = new Book(name, quantity, authorService.getAuthorById(author));
        authorService.incrementBooks(author);
        return repository.save(b);
    }

    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    public List<Book> findAllByQuantity(Integer val){
        return repository.findAllByQuantityGreaterThan(val);
    }

    public Optional<Book> findBookById(Integer id){
        return repository.findById(id);
    }

    public Book getBookById(Integer id){
        return repository.getById(id);
    }

    public Integer incrementQuantity(Integer id){
        Book b = repository.getById(id);
        Integer ret = b.incrementQuantity();
        repository.save(b);
        return ret;
    }

    public Integer decrementQuantity(Integer id){
        Book b = repository.getById(id);
        Integer ret = b.decrementQuantity();
        repository.save(b);
        return ret;
    }
}
