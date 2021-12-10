package pl.mlisowski.dbprojekt.bookmanagement.domain.core;

import pl.mlisowski.dbprojekt.borrowings.domain.core.Borrowing;
import pl.mlisowski.dbprojekt.common.utils.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(indexes = {
        @Index(name = "index1", columnList = "ID"),
        @Index(name = "index2", columnList = "NAME"),
        @Index(name = "index3", columnList = "AUTHOR_ID"),
        @Index(name = "index4", columnList = "AUTHOR_ID, NAME")
})
public class Book extends BaseEntity {

    public Book(){}

    public Book(String name, Integer quantity, Author author) {
        this.name = name;
        this.quantity = quantity;
        this.author = author;
    }

    @Column()
    private String name;

    @Column()
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(mappedBy = "book")
    private Set<Borrowing> borrowings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer incrementQuantity(){
        return ++this.quantity;
    }

    public Integer decrementQuantity(){
        return --this.quantity;
    }
}
