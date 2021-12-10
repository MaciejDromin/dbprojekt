package pl.mlisowski.dbprojekt.bookmanagement.application;

import org.springframework.stereotype.Service;
import pl.mlisowski.dbprojekt.bookmanagement.application.port.AuthorRepository;
import pl.mlisowski.dbprojekt.bookmanagement.domain.core.Author;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthorService {

    private AuthorRepository repository;

    public AuthorService(AuthorRepository repository){
        this.repository = repository;
    }

    public Author addAuthor(String name){
        Author a = new Author(name, 0);
        return repository.save(a);
    }

    public Author incrementBooks(Integer author){
        Author a = repository.getById(author);
        a.incrementBookCnt();
        return repository.save(a);
    }

    public Optional<Author> findAuthorById(Integer id){
        return repository.findById(id);
    }

    public Author getAuthorById(Integer id){
        return repository.getById(id);
    }

    public List<Author> getAllAuthors(){
        return repository.findAll();
    }
}
