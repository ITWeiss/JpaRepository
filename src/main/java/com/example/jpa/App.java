package com.example.jpa;

import com.example.jpa.config.AppConfig;
import com.example.jpa.dto.PostDto;
import com.example.jpa.dto.UserDto;
import com.example.jpa.entity.Post;
import com.example.jpa.entity.User;
import com.example.jpa.service.PostService;
import com.example.jpa.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        PostService postService = context.getBean(PostService.class);

//        UserDto userDto = new UserDto(null, "Luck", "luck@gmail.com", 28);
//
//        userService.addUser(userDto);
//
//        List<User> users = userService.findUsersOlderThan(29);
//        users.forEach(System.out::println);
//
//        PostDto postDto = new PostDto(null, "Hello World!", "This is my first post!", LocalDateTime.now(), 2L);
//        postService.addPost(postDto);

        List<Post> posts1 = postService.findByUserId(1L);
        posts1.forEach(System.out::println);

        List<Post> posts2 = postService.findByTitle("Hello");
        posts2.forEach(System.out::println);



        context.close();
    }
}
