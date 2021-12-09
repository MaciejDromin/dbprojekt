package pl.mlisowski.dbprojekt.bookmanagement.domain.core;

import pl.mlisowski.dbprojekt.common.utils.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(indexes = {
        @Index(name = "index1", columnList = "ID"),
        @Index(name = "index2", columnList = "NAME")
})
public class Author extends BaseEntity {

    public Author(){}

    public Author(String name, Integer bookCnt) {
        this.name = name;
        this.bookCnt = bookCnt;
        this.books = books;
    }

    @Column()
    private String name;

    @Column()
    private Integer bookCnt;

    @OneToMany(mappedBy = "author")
    private Set<Book> books;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBookCnt() {
        return bookCnt;
    }

    public void setBookCnt(Integer bookCnt) {
        this.bookCnt = bookCnt;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void incrementBookCnt(){
        this.bookCnt++;
    }
}
