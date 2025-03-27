package org.telran.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.telran.social.entity.Message;

import java.util.List;

@Repository
public interface MessageJpaRepository extends JpaRepository<Message, Long> {

    @Query("SELECT m FROM Message AS m WHERE m.sender.id = :id")
    List<Message> findAllByUserId(@Param("id") Long id);
}
