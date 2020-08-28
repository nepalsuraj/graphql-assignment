package com.graphql.test.service;

import org.springframework.stereotype.Service;

import com.graphql.test.exception.PostNotFoundException;
import com.graphql.test.model.Post;

@Service
public class PostsService extends BaseService {

	private static final String POSTS_URL = "/posts";

	public Post read(Integer postId) {
		try {
			return restTemplate.getForEntity(url + POSTS_URL + "/{id}", Post.class, postId).getBody();
		} catch (RuntimeException e) {
			throw new PostNotFoundException(postId);
		}
	}

	public Post create(Post post) {
		return restTemplate.postForEntity(url + POSTS_URL, post, Post.class).getBody();
	}

	public void update(Post post) {
		restTemplate.put(url + POSTS_URL + "/{id}", post, post.getId());
	}

	public void delete(Integer postId) {
		restTemplate.delete(url + POSTS_URL + "/{id}", postId);
	}

}