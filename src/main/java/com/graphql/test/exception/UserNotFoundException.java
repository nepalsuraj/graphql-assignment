package com.graphql.test.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserNotFoundException extends RuntimeException implements GraphQLError {

	private Integer userId;

	private Map<String, Object> extensions = new HashMap<>();

	public UserNotFoundException(String message, Integer userId) {
		super(message);
		extensions.put("userId", userId);
	}

	public UserNotFoundException(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String getMessage() {
		return "User with ID " + userId + " could not be found";
	}

	@Override
	public List<SourceLocation> getLocations() {
		return null;
	}

	@Override
	public Map<String, Object> getExtensions() {
		return Collections.singletonMap("userId", userId);
	}

	@Override
	public ErrorType getErrorType() {
		return ErrorType.DataFetchingException;
	}
}
