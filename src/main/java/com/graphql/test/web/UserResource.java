package com.graphql.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.graphql.test.model.User;
import com.graphql.test.schema.QueryResolver;

@RestController
@RequestMapping("api/rest/users")
public class UserResource {
	@Autowired
	private QueryResolver query;
	
	@GetMapping("/{id}")
	@ResponseBody
	public User getUser(@PathVariable("id") Integer id) {
		return query.user(id);
	}

}