package com.example.jpa.service;

import com.example.jpa.dto.PostDto;
import com.example.jpa.entity.Post;

import java.util.List;

public interface PostService {
    public void addPost(PostDto dto);
    List<Post> findByUserId(Long userId);
    List<Post> findByTitle(String title);
    List<Post> findPostsByUserWithPageable(Long userId, int pageNumber, int pageSize);
    List<Post> findPostsWithUsers (Long userId);

}
