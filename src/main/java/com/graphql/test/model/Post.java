package com.graphql.test.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode

public class Post {


    private Integer id;

    private User user;
    
    private Integer userId;

    private String title;
    
    private String body;
    
    private List<Comment> comments;

}
