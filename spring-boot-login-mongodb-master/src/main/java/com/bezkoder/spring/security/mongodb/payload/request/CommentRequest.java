package com.bezkoder.spring.security.mongodb.payload.request;

import com.bezkoder.spring.security.mongodb.models.Comment;
import com.bezkoder.spring.security.mongodb.models.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentRequest {

    private Post post;
    private Comment comment;

}