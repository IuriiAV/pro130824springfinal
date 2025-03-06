package org.telran.social.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.social.model.NetworkUser;
import org.telran.social.repository.NetworkUserRepository;

import java.util.List;

@Service
public class NetworkUserServiceImpl implements NetworkUserService {

    @Autowired
    private NetworkUserRepository userRepository;

    @Override
    public List<NetworkUser> getAll() {
        return userRepository.getAll();
    }

    @Override
    public NetworkUser getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public NetworkUser create(NetworkUser networkUser) {
        return userRepository.create(networkUser);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<NetworkUser> filter(Long minAge, Long maxAge) {
        return null;
    }
}
