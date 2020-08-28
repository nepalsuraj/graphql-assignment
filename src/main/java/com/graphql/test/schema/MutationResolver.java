package com.graphql.test.schema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.test.model.Post;
import com.graphql.test.service.PostsService;

@Component
public class MutationResolver implements GraphQLMutationResolver {

	@Autowired
	private PostsService postsService;

	// deletePost(id: Int!)
	public Boolean deletePost(int postId) {
		postsService.delete(postId);
		return true;
	}

	//  updatePost(id: Int!, title: String!, body: String!)
	public Boolean updatePost(int id, String title, String body) {
		postsService.update(Post.builder().id(id).title(title).body(body).build());
		return true;
	}

}
