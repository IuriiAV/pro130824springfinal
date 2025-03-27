package org.telran.social.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    //BCrypt hjfhgkjdfghdkjgkjghrjkrglerkjglgjdflgjlk  -> from ui (12345)
    //from database -> hjfhgkjdfghdkjgkjghrjkrglerkjglgjdflgjlk

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User("user", "12345",
                List.of(new SimpleGrantedAuthority("ROLE_USER")));
        return user;
    }
}