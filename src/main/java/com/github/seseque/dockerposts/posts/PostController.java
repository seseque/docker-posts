package com.github.seseque.dockerposts.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService PostService;

    @GetMapping("/greeting")
    String greeting() {
        return "Hello, k8s!";
    }

    @PostMapping("/posts")
    PostRes createPost(@RequestBody PostReq Post) {
        return PostService.createPost(Post);
    }

    @GetMapping("/posts/{id}")
    PostRes getPost(@PathVariable Long id) {
        return PostService.getPost(id);
    }

    @DeleteMapping("/posts/{id}")
    void deletePost(@PathVariable Long id) {
        PostService.deletePost(id);
    }

    @PutMapping("/posts/{id}")
    PostRes updatePost(@PathVariable Long id, @RequestBody PostReq Post) {
        return PostService.updatePost(id, Post);
    }
}
