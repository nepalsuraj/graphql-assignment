package com.graphql.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graphql.test.model.Post;
import com.graphql.test.schema.MutationResolver;
import com.graphql.test.schema.QueryResolver;

@RestController
@RequestMapping("api/rest/posts")
public class PostsResource {
	@Autowired
	private QueryResolver query;

	@Autowired
	private MutationResolver mutation;

	@GetMapping("/{id}")
	public Post getPost(@PathVariable("id") Integer id) {
		return query.post(id);
	}

	@PutMapping
	public ResponseEntity<String> update(@RequestBody Post post) {
		mutation.updatePost(post.getId(),post.getTitle(), post.getBody());
		return ResponseEntity.ok("Post Updated.");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		mutation.deletePost(id);
		return ResponseEntity.ok("Post Deleted.");
	}
}
