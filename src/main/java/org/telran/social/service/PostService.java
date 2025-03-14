package org.telran.social.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.telran.social.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> getAll();

    Post getById(Long id);

    Post create(Post post);

    void deleteById(Long id);

    List<Post> getAllByUserId(Long id);
}
