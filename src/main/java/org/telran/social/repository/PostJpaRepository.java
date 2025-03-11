package org.telran.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.telran.social.entity.Post;

@Repository
public interface PostJpaRepository extends JpaRepository<Post,Long> {
}
