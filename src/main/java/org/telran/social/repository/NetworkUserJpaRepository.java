package org.telran.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.telran.social.entity.NetworkUser;

import java.util.Optional;

@Repository
public interface NetworkUserJpaRepository extends JpaRepository<NetworkUser,Long> {

    public Optional<NetworkUser> findByLogin(String login);
}
