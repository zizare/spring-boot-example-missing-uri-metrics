package com.example.restemplate.uri.controller;

import java.net.URI;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ExampleController {

	private final RestTemplate restTemplate;

	public ExampleController(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.rootUri("http://localhost:8080").build();
	}

	@GetMapping("/hello")
	public String hello() {
		return "HELLO";
	}

	@GetMapping("/rest-template/hello")
	public String helloViaRestTemplate() {
		URI uri = UriComponentsBuilder.fromUri(restTemplate.getUriTemplateHandler().expand("/hello"))
			.build()
			.toUri();

		return restTemplate.getForObject(uri, String.class);
	}

}
