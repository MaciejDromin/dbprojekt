package pl.mlisowski.dbprojekt.borrowings.domain.core;

import pl.mlisowski.dbprojekt.administration.domain.core.User;
import pl.mlisowski.dbprojekt.bookmanagement.domain.core.Book;
import pl.mlisowski.dbprojekt.common.utils.BaseEntity;

import javax.persistence.*;

@Entity
@Table(indexes = {
        @Index(name = "index1", columnList = "ID"),
        @Index(name = "index2", columnList = "USER_ID")
})
public class Borrowing extends BaseEntity {

    public Borrowing(){}

    public Borrowing(User user, Book book) {
        this.user = user;
        this.book = book;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
