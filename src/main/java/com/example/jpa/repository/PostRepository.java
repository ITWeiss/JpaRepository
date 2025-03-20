package com.example.jpa.repository;

import com.example.jpa.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUserId(Long user);

    @Query("SELECT p FROM Post p WHERE p.title = :title")
    List<Post> findByTitle(@Param("title") String title);

    @Query("SELECT p FROM Post p WHERE p.user_id = :user_id")
    Page<Post> findPostsByUserWithPageable(@Param("user_id") Long userId, Pageable pageable);

    @Query("SELECT p FROM Post p JOIN FETCH p.user WHERE p.user_id = :user_id")
    List<Post> findPostsWithUsers(@Param("user_id") Long userId);
}
