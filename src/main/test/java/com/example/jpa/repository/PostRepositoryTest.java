package com.example.jpa.repository;

import com.example.jpa.config.PostgresDbTestContainers;
import com.example.jpa.entity.Post;
import com.example.jpa.service.PostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Тестирование методов репозитория для работы с постами")
public class PostRepositoryTest extends PostgresDbTestContainers {

    @Autowired
    private PostRepository postRepository;
    private PostService postService;

    @Test
    @DisplayName("Тест метода для получения постов по id пользователя")
    void shouldGetPostByUserId() {
        List<Post> posts = postRepository.findByUserId(1L);
        assertThat(posts).isNotEmpty();
        assertEquals(2, posts.size());
    }

    @Test
    @DisplayName("Тест метода для получения постов по названию")
    void shouldGetPostByTitle() {
        List<Post> posts = postRepository.findByTitle("Hello World!");
        assertThat(posts).isNotEmpty();
        assertEquals(1, posts.size());
    }

    @Test
    @DisplayName("Тест метода для получения постов по пользователю с пагинацией")
    void shouldGetPostsByUserWithPageable() {
        List<Post> posts = postService.findPostsByUserWithPageable(1L, 0, 2);
        assertThat(posts).isNotEmpty();
        assertEquals(2, posts.size());
    }

    @Test
    @DisplayName("Тест метода для получения постов с пользователями")
    void shouldGetPostsWithUsers () {
        List<Post> posts = postRepository.findPostsWithUsers(1L);
        assertThat(posts).isNotEmpty();
        assertEquals(2, posts.size());
    }

}
