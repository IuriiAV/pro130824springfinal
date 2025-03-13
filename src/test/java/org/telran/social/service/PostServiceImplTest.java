package org.telran.social.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.telran.social.emuns.PostStatus;
import org.telran.social.entity.Post;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql("/postInit.sql")
class PostServiceImplTest {

    @Autowired
    private PostService postService;

    @Test
    public void testGetAll() {
        List<Post> posts = postService.getAll();
        assertEquals(1, posts.size());
    }

    @Test
    public void testGetById() {
        Post post = postService.getById(1L);
        assertEquals("Hello", post.getContent());
    }

    @Test
    public void testCreate() {
        Post post = new Post("This is my first post here!", PostStatus.DRAFT);
        Post postEntity = postService.create(post);
        assertNotNull(postEntity.getId());
        assertEquals(2, postService.getAll().size());
    }

    @Test
    public void testDeleteById() {
        postService.deleteById(1L);
        assertEquals(0, postService.getAll().size());
    }
}