package org.telran.social.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.telran.social.dto.PostCreateRequestDto;
import org.telran.social.emuns.PostStatus;
import org.telran.social.entity.Post;
import org.telran.social.service.PostService;

import java.util.List;

@RestController
@RequestMapping("api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAll() {
        return postService.getAll();
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable Long id) {
        return postService.getById(id);
    }

    @GetMapping("/user/{id}") // localhost:8080/api/posts/user/123
    public List<Post> getAllByUserId(@PathVariable Long id) {
        return postService.getAllByUserId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody PostCreateRequestDto postDto) {
        return postService.createFromDto(postDto);
    }
}
