package org.telran.social.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.telran.social.emuns.PostStatus;
import org.telran.social.entity.NetworkUser;
import org.telran.social.entity.Post;
import org.telran.social.repository.NetworkUserJpaRepository;

import java.util.List;

@Service
public class NetworkUserServiceImpl implements NetworkUserService {

    @Autowired
    private NetworkUserJpaRepository userRepository;

    @Override
    public List<NetworkUser> getAll() {
        List<NetworkUser> users = userRepository.findAll();
        return users;
    }

    @Override
    public NetworkUser getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public NetworkUser create(NetworkUser networkUser) {
        return userRepository.save(networkUser);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<NetworkUser> filter(Long minAge, Long maxAge) {
        return null;
    }

    @Override
    public void generatePost(Long id) {
        Post post = new Post("Bye", PostStatus.DRAFT);
        NetworkUser networkUser = getById(id);
        networkUser.getPost().add(post);
        create(networkUser);
    }

    @Override
    public NetworkUser findByLogin(String login) {
        return userRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("User with login" + login + " is not found"));
    }

    @Override
    public NetworkUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        String name = authentication.getName();
        return findByLogin(name);
    }

    //bank app
    //user -> account
    //transaction -> accountFrom, accountTo(accountService.save(accountFrom),accountService.save(accountTo) )
}   // user - > accountList
//create account , accountList.add(account).save
