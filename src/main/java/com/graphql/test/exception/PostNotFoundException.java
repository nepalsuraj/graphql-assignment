package com.graphql.test.exception;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;


public class PostNotFoundException extends RuntimeException implements GraphQLError {

    private Integer postId;



    public PostNotFoundException(Integer postId) {
        this.postId = postId;
    }



    @Override
    public String getMessage() {
        return "Post with ID " + postId + " could not be found";
    }



    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }



    @Override
    public Map<String, Object> getExtensions() {
        return Collections.singletonMap("postId", postId);
    }



    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
