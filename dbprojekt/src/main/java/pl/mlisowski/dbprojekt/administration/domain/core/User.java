package pl.mlisowski.dbprojekt.administration.domain.core;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.mlisowski.dbprojekt.administration.domain.enums.Role;
import pl.mlisowski.dbprojekt.borrowings.domain.core.Borrowing;
import pl.mlisowski.dbprojekt.common.utils.BaseEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(indexes = {
        @Index(name = "index1", columnList = "ID")
})
public class User extends BaseEntity implements UserDetails {

    public User(){}

    public User(String username, String password, Role role, Address address, Integer enabled) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.address = address;
        this.enabled = enabled;
    }

    @Column()
    private String username;

    @Column()
    private String password;

    @Column()
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column
    private Integer enabled;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "user")
    private Set<Borrowing> borrowings;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
