package com.graphql.test.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graphql.test.model.Comment;
import com.graphql.test.schema.QueryResolver;

@RestController
@RequestMapping("api/rest/comments")
public class CommentsResource {
    @Autowired
    private QueryResolver query;

    @GetMapping(value = "/post/{id}")
    public List<Comment> getCommentsByPost(@PathVariable("id") Integer postId) {
        return query.commentsByPost(postId);
    }

    @GetMapping(value = "/{id}")
    public Comment get(@PathVariable("id") Integer id) {
        return query.comment(id);
    }


}
