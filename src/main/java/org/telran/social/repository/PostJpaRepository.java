package org.telran.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telran.social.entity.Post;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
}
