package org.telran.social.service;

import org.telran.social.entity.NetworkUser;

import java.util.List;

public interface NetworkUserService {

    List<NetworkUser> getAll();

    NetworkUser getById(Long id);

    NetworkUser create(NetworkUser networkUser);

    void deleteById(Long id);

    List<NetworkUser> filter(Long minAge, Long maxAge);

    void generatePost(Long id);

}
