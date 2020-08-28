package com.graphql.test.model;

import java.util.List;

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
public class User {

	private Integer id;
	
	private String name;
	
	private String username;
	
	private String email;
	
	private String phone;
	
	private String website;
	
	private UserAddress address;

}
