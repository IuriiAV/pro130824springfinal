package org.telran.social.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.social.emuns.PostStatus;
import org.telran.social.entity.NetworkUser;
import org.telran.social.entity.Post;
import org.telran.social.repository.NetworkUserJpaRepository;
import org.telran.social.repository.legacy.NetworkUserRepository;

import java.util.List;

@Service
public class NetworkUserServiceImpl implements NetworkUserService {

    @Autowired
    private NetworkUserJpaRepository userRepository;

    @Override
    public List<NetworkUser> getAll() {
        return userRepository.findAll();
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

    //bank app
    //user -> account
    //transaction -> accountFrom, accountTo(accountService.save(accountFrom),accountService.save(accountTo) )
}   // user - > accountList
    //create account , accountList.add(account).save
