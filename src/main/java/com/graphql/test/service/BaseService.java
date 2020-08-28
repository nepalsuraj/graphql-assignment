package com.graphql.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class BaseService {


	@Value("${typicode.url}")
	protected String url;

	@Autowired
	protected RestTemplate restTemplate;
}
