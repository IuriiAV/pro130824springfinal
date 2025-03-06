package org.telran.social.repository;

import org.telran.social.model.NetworkUser;

import java.util.List;

public interface NetworkUserRepository {

    List<NetworkUser> getAll();

    NetworkUser getById(Long id);

    NetworkUser create(NetworkUser networkUser);

    void deleteById(Long id);

    List<NetworkUser> filter(Long minAge, Long maxAge);
}
