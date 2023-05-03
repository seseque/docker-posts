package com.github.seseque.dockerposts.posts;

public interface PostService {

    PostRes createPost(PostReq post);

    PostRes getPost(Long id);

    void deletePost(Long id);

    PostRes updatePost(Long id, PostReq post);
}
