package com.graphql.test.schema;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.test.exception.UserNotFoundException;
import com.graphql.test.model.Comment;
import com.graphql.test.model.Post;
import com.graphql.test.model.User;
import com.graphql.test.service.CommentService;
import com.graphql.test.service.PostsService;
import com.graphql.test.service.UserService;

@Component
public class QueryResolver implements GraphQLQueryResolver {

	@Autowired
	private UserService userService;

	@Autowired
	private PostsService postsService;

	@Autowired
	private CommentService commentService;    
    		

    //post(id: Int!): Post
	public Post post(Integer id) {
		return postsService.read(id);
	}

	// comment(id: Int!): Comment
	public Comment comment(Integer id) {
		return commentService.read(id);
	}

	// commentsByPost(postId: Int!): [Comment]
	public List<Comment> commentsByPost(Integer postId) {
		return commentService.readByPost(postId);
	}

	// user(id: Int!): User
	public User user(Integer id) {
		return userService.read(id);
	}
}
