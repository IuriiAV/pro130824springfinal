package org.telran.social.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.social.dto.PostCreateRequestDto;
import org.telran.social.emuns.PostStatus;
import org.telran.social.entity.NetworkUser;
import org.telran.social.entity.Post;
import org.telran.social.repository.PostJpaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostJpaRepository repository;

    @Autowired
    private NetworkUserService userService;

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
        return repository.save(post);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Post> getAllByUserId(Long id) {
        return repository.findAllByUserId(id);
    }

    @Override
    public Post createFromDto(PostCreateRequestDto postDto) {
        NetworkUser userEntity = userService.getById(postDto.userId());
        Post post = new Post(postDto.content(),
                PostStatus.getValue(postDto.postStatus()),
                userEntity);
        return repository.save(post);
    }
}
