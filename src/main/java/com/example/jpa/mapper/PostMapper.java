package com.example.jpa.mapper;

import com.example.jpa.dto.PostDto;
import com.example.jpa.entity.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostDto toPostDto(Post post);
    Post toPost(PostDto postDto);
}
