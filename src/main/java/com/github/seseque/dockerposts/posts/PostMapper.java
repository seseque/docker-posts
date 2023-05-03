package com.github.seseque.dockerposts.posts;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post toEntity(PostReq req);

    PostRes toResponse(Post post);

}
