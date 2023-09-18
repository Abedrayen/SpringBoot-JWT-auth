package com.bezkoder.spring.security.mongodb.repository;


import com.bezkoder.spring.security.mongodb.models.Post;
import com.bezkoder.spring.security.mongodb.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    Optional<Post> findPostById(String id);


}

