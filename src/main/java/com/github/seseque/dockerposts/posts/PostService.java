package com.github.seseque.dockerposts.posts;

public interface PostService {

    PostRes createPost(PostReq post);

    PostRes getPost(Long id);

    PostRes deletePost(Long id);

    PostRes updatePost(Long id, PostUpdReq post);
}
