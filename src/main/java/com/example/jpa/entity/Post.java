package com.example.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
//import org.w3c.dom.Text;

import java.time.LocalDateTime;

@Entity
@Table(schema = "company", name = "posts")
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


}
