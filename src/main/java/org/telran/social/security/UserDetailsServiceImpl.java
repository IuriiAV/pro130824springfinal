package org.telran.social.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.telran.social.entity.NetworkUser;
import org.telran.social.service.NetworkUserServiceImpl;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private NetworkUserServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NetworkUser networkUser = userService.findByLogin(username);
        return new User(networkUser.getLogin(), networkUser.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
