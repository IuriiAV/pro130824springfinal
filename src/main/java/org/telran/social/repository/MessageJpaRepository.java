package org.telran.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.telran.social.entity.Message;

@Repository
public interface MessageJpaRepository extends JpaRepository<Message, Long> {
}
