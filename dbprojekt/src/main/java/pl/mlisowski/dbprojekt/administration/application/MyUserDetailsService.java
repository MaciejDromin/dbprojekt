package pl.mlisowski.dbprojekt.administration.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.mlisowski.dbprojekt.administration.domain.core.User;
import pl.mlisowski.dbprojekt.administration.domain.enums.Role;
import pl.mlisowski.dbprojekt.security.cfg.SecurityConfig;

import java.util.Collection;
import java.util.HashSet;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    private UserService service;

    public MyUserDetailsService(){
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = service.findUserByUsername(username).orElse(null);
        if (user == null) {
            return new org.springframework.security.core.userdetails.User(
                    " ", " ", true, true, true, true,
                    getAuthorities("USER"));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), user.isEnabled(), true, true,
                true, getAuthorities(user.getRole().toString()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        Collection<GrantedAuthority> col = new HashSet<>();
        logger.info("---Pobieram Authorities---");
        col.add(new SimpleGrantedAuthority("ROLE_"+role));
        return col;
    }
}
