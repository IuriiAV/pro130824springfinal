package org.telran.social.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.social.entity.Post;
import org.telran.social.repository.PostJpaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostJpaRepository repository;

    @Override
    public List<Post> getAll() {
        return repository.findAll();
    }

    @Override
    public Post getById(Long id) {
        Optional<Post> post = repository.findById(id);
        return post.get();
    }

    @Override
    public Post create(Post post) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
