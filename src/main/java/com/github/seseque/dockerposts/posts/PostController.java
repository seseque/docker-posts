package com.github.seseque.dockerposts.posts;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<PostRes> createPost(@RequestBody @Valid PostReq Post) {
        return ResponseEntity.ok(PostService.createPost(Post));
    }

    @GetMapping("/posts/{id}")
    ResponseEntity<PostRes> getPost(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(PostService.getPost(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/posts/{id}")
    ResponseEntity<PostRes> deletePost(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(PostService.deletePost(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/posts/{id}")
    ResponseEntity<PostRes> updatePost(@PathVariable Long id, @RequestBody @Valid PostUpdReq Post) {
        try {
            return ResponseEntity.ok(PostService.updatePost(id, Post));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
