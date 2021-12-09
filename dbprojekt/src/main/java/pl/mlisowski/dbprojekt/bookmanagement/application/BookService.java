package pl.mlisowski.dbprojekt.bookmanagement.application;

import org.springframework.stereotype.Service;
import pl.mlisowski.dbprojekt.bookmanagement.application.port.BookRepository;
import pl.mlisowski.dbprojekt.bookmanagement.domain.core.Book;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository repository;
    private AuthorService authorService;

    public BookService(BookRepository repository, AuthorService authorService){
        this.repository = repository;
        this.authorService = authorService;
    }

    public Book addBook(String name, Integer quantity, Integer author){
        Book b = new Book(name, quantity, authorService.getAuthorById(author));
        return repository.save(b);
    }

    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    public Optional<Book> findBookById(Integer id){
        return repository.findById(id);
    }

    public Book getBookById(Integer id){
        return repository.getById(id);
    }
}
