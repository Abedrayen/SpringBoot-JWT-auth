package com.bezkoder.spring.security.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.bezkoder.spring.security.mongodb.models.*;
import com.bezkoder.spring.security.mongodb.repository.PostRepository;
import com.bezkoder.spring.security.mongodb.repository.UserRepository;
import com.bezkoder.spring.security.mongodb.payload.request.CommentRequest;
import com.bezkoder.spring.security.mongodb.payload.request.LikeRequest;
import com.bezkoder.spring.security.mongodb.security.services.NotificationStorageService;
import com.bezkoder.spring.security.mongodb.security.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@SpringBootApplication
@EnableMongoRepositories
public class SpringBootMongodbLoginApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootMongodbLoginApplication.class, args);
	}
	@Autowired
	UserRepository userRepository;

	@Autowired
	PostRepository postRepository;

	@Autowired
	PostService postService;

	@Autowired
	NotificationStorageService notificationStorageService;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		postRepository.deleteAll();

		User user = userRepository.save(User.builder().username("grkn").name("Gurkan").profileImageUrl("https://avatars.githubusercontent.com/u/25080366?v=4").build());
		User user2 = userRepository.save(User.builder().username("sezai").name("sezai").profileImageUrl("https://pbs.twimg.com/profile_images/1232374207729799170/IqtUTP4s_400x400.jpg").build());



		Post post1 = postService.create(Post.builder().content("first post, this is test!").user(user).build());


//        Comment comment = Comment.builder().user(user).content("comment 1").build();
//        Comment comment2 = Comment.builder().user(user3).content("comment 2").build();
//        Comment comment3 = Comment.builder().user(user).content("comment 3").build();

		for (int i = 0; i < 5; i++) {
			postService.addComment(new CommentRequest(post1, Comment.builder().user(user).content("comment " + i).build()));
		}


		postService.addLike(new LikeRequest(post1, user2));

		notificationStorageService.clear();


	}
}

