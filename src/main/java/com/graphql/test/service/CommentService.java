package com.graphql.test.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.test.model.Comment;

@Service
public class CommentService extends BaseService {

	@Autowired
	PostsService postsService;
	
	public Comment read(Integer commentId) {
		Comment comment =  restTemplate.getForEntity(url + "/comments/{id}", Comment.class, commentId).getBody();
		addPostData(comment);
		return comment;
	}

	public List<Comment> readByPost(Integer postId) {
		Comment[] comments = restTemplate.getForEntity(url + "/comments?postId={postId}", Comment[].class, postId)
				.getBody();
		for (Comment comment : comments) {
			addPostData(comment);
		}
		return Arrays.asList(comments);
	}
	
	private void addPostData( Comment comment) {
		//comment.setPost(postsService.read(comment.getPostId()));
	}
}
