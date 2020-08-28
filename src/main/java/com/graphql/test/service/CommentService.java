package com.graphql.test.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.graphql.test.model.Comment;

@Service
public class CommentService extends BaseService {

	public Comment read(Integer commentId) {
		return restTemplate.getForEntity(url + "comments/{id}", Comment.class, commentId).getBody();
	}

	public List<Comment> readByPost(Integer postId) {
		Comment[] comments = restTemplate.getForEntity(url + "comments/{id}", Comment[].class, postId).getBody();
		return Arrays.asList(comments);
	}
}
