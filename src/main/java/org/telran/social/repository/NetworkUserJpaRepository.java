package org.telran.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.telran.social.entity.NetworkUser;

@Repository
public interface NetworkUserJpaRepository extends JpaRepository<NetworkUser,Long> {
}
