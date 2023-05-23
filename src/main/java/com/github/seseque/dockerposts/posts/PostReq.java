package com.github.seseque.dockerposts.posts;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PostReq {
    @NotNull
    Integer authorId;
    String text;
}
