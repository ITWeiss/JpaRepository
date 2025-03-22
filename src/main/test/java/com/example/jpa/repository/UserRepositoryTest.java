package com.example.jpa.repository;

import com.example.jpa.config.PostgresDbTestContainers;
import com.example.jpa.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayName("Тестирование методов репозитория для работы с пользователями")
public class UserRepositoryTest extends PostgresDbTestContainers {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Тест метода для получения пользователей старше указанного возраста")
    void shouldGetUserByAgeGreaterThan() {
        List<User> users = userRepository.findByAgeGreaterThan(18);
        assertThat(users).isNotEmpty();
        assertEquals(3, users.size());
    }

    @Test
    @DisplayName("Тест метода для получения пользователя по имени пользователя")
    void shouldGetUserByUsername() {
        Optional<User> user = userRepository.findByUsername("Luck");
        assertThat(user).isNotEmpty();
        assertEquals("Luck", user.get().getUsername());
    }

    @Test
    @DisplayName("Тест метода для получения пользователей старше указанного возраста с Query")
    void shouldGetUsersOlderThan() {
        List<User> users = userRepository.findUsersOlderThan(18);
        assertThat(users).isNotEmpty();
        assertEquals(3, users.size());
    }

}
