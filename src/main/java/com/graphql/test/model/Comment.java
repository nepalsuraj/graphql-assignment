package com.graphql.test.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class Comment {

  
    private Integer id;

    private Integer postId;
    
    private Post post;

    private String name;

    private String email;

    private String body;
  
}
