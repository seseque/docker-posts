package com.github.seseque.dockerposts.posts;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", source = "authorId")
    Post toEntity(PostReq req);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "authorId", source = "userId")
    PostRes toResponse(Post post);

}
