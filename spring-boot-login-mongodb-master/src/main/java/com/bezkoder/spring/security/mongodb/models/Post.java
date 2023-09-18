package com.bezkoder.spring.security.mongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Document
    public class Post {
        @Id
        private String id;
        private String content;
        private User user;
        private List<User> likedUsers;
        private List<Comment> comments;
        private LocalDateTime created;
        private String postImageUrl;
    }


