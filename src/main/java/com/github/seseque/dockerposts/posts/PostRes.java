package com.github.seseque.dockerposts.posts;

import lombok.Data;

@Data
public class PostRes {
    Integer id;
    Integer authorId;
    String text;
}
