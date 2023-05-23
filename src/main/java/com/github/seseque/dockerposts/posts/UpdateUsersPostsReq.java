package com.github.seseque.dockerposts.posts;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateUsersPostsReq {
    Integer amount;
}
