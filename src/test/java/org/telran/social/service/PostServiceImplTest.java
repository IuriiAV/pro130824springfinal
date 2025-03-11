package org.telran.social.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.telran.social.entity.Post;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceImplTest {

    @Autowired
    private PostService postService;

    @Test
    public void testGetAll() {
        List<Post> posts = postService.getAll();
    }

    @Test
    public void testGetById() {
        Post post = postService.getById(1L);
    }

    @Test
    public void testCreate() {
        Post post = postService.create(new Post(null, "This is my first post here!"));
    }

    @Test
    public void testDeleteById() {
        postService.deleteById(1L);
    }
}