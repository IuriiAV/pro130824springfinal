package org.telran.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.telran.social.entity.NetworkUser;
import org.telran.social.entity.Post;

import java.util.List;

@Repository
public interface PostJpaRepository extends JpaRepository<Post,Long> {

    //1 - Exists query
    //2 - Custom query (custom SQL)
    //3 - Custom query with Spring Data JPA (parse method name)

    @Query("SELECT p FROM Post AS p WHERE p.user.id = :id")
    List<Post> findAllByUserId(@Param(value = "id") Long id);

    //findAll - SELECT * FROM , By - WHERE User = user
    List<Post> findAllByUser(NetworkUser user);

    Post findPostByIdAndUser(Long id, NetworkUser user);
}
