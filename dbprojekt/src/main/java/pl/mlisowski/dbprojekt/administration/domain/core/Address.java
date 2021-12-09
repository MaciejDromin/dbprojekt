package pl.mlisowski.dbprojekt.administration.domain.core;

import pl.mlisowski.dbprojekt.common.utils.BaseEntity;

import javax.persistence.*;

@Entity
@Table(indexes = {
        @Index(name = "index1", columnList = "ID"),
        @Index(name = "index2", columnList = "CITY"),
        @Index(name = "index3", columnList = "CITY, ZIPCODE"),
        @Index(name = "index4", columnList = "CITY, STREET")
})
public class Address extends BaseEntity {

    public Address(){};

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
    public Address(String city, String street, String zipcode, User user) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.user = user;
    }

    @Column()
    private String city;
    @Column()
    private String street;
    @Column()
    private String zipcode;

    @OneToOne(mappedBy = "address")
    private User user;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
