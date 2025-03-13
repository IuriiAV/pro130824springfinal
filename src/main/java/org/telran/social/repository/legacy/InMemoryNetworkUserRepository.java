package org.telran.social.repository.legacy;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.telran.social.entity.NetworkUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Profile("TEST")
public class InMemoryNetworkUserRepository implements NetworkUserRepository {

    private Map<Long, NetworkUser> storage = new HashMap<>();

    @PostConstruct
    public void init() {
        storage.put(1L, NetworkUser
                .builder()
                .id(1L)
                .name("Alex")
                .surname("Alexeev")
                .login("alex345")
                .password("alexalex")
                .build());

        storage.put(2L, NetworkUser
                .builder()
                .id(2L)
                .name("Oleg")
                .surname("Olegov")
                .login("oleg56456")
                .password("53453454")
                .build());
    }

    @Override
    public List<NetworkUser> getAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public NetworkUser getById(Long id) {
        return storage.get(id);
    }

    @Override
    public NetworkUser create(NetworkUser networkUser) {
        return storage.put(networkUser.getId(), networkUser);
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }

    @Override
    public List<NetworkUser> filter(Long minAge, Long maxAge) {
        return null;
    }
}
