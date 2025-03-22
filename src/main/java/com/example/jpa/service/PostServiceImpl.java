package com.example.jpa.service;

import com.example.jpa.dto.PostDto;
import com.example.jpa.entity.Post;
import com.example.jpa.mapper.PostMapper;
import com.example.jpa.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository repository;
    private final PostMapper mapper;

    @Override
    public void addPost(PostDto dto) {
        Post post = mapper.toPost(dto);
        repository.save(post);
    }

    @Override
    public List<Post> findByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Post> findByTitle(String title) {
        return repository.findByTitle(title);
    }

    @Override
    public List<Post> findPostsByUserWithPageable(Long userId, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Post> page = repository.findPostsByUserWithPageable(userId, pageable);
        return page.getContent();
    }

    @Override
    public List<Post> findPostsWithUsers(Long userId) {
        return repository.findPostsWithUsers(userId);
    }
}
