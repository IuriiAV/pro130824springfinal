package org.telran.social.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.telran.social.entity.Post;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql("/postInit.sql")
class PostServiceImplTest {

    @Autowired
    private PostService postService;

    @Test
    void testGetAll() {
        List<Post> posts = postService.getAll();
        assertEquals(1, posts.size());
    }

    @Test
    void testGetById() {
        Post post = postService.getById(1l);
        assertEquals("Hello", post.getContent());
    }

    @Test
    void testCreate() {
        Post newPost = postService.create(new Post(null, "new post"));
        assertEquals(1l, postService.getAll().size());
    }

    @Test
    void testDeleteById() {
        postService.deleteById(1l);
        assertEquals(0, postService.getAll().size());
    }
}