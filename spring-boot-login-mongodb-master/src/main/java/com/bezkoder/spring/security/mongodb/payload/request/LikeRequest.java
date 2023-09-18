package com.bezkoder.spring.security.mongodb.payload.request;

import com.bezkoder.spring.security.mongodb.models.Post;
import com.bezkoder.spring.security.mongodb.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LikeRequest {

    private Post post;
    private User user;


}
