package org.telran.social.repository.legacy;

import org.telran.social.entity.NetworkUser;

import java.util.List;

public interface NetworkUserRepository {

    List<NetworkUser> getAll();

    NetworkUser getById(Long id);

    NetworkUser create(NetworkUser networkUser);

    void deleteById(Long id);

    List<NetworkUser> filter(Long minAge, Long maxAge);
}
