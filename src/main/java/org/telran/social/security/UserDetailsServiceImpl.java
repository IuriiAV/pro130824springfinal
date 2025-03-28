package org.telran.social.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.telran.social.entity.NetworkUser;
import org.telran.social.service.NetworkUserService;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    //BCrypt hjfhgkjdfghdkjgkjghrjkrglerkjglgjdflgjlk  -> from ui (12345)
    //from database -> hjfhgkjdfghdkjgkjghrjkrglerkjglgjdflgjlk

    @Autowired
    private NetworkUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NetworkUser networkUser = userService.findByLogin(username);
        return new User(networkUser.getLogin(),
                networkUser.getPassword(),
                List.of(new SimpleGrantedAuthority(networkUser.getRole().name())));
    }
}