package com.graphql.test.service;

import org.springframework.stereotype.Service;

import com.graphql.test.exception.UserNotFoundException;
import com.graphql.test.model.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService extends BaseService {

	public User read(Integer userId) {
		try {
		return restTemplate.getForEntity(url + "/users/{id}", User.class, userId).getBody();
		}catch (RuntimeException e) {
			log.error("Can not fetch user "+e);
			throw new UserNotFoundException(userId);
		}
	}

}
