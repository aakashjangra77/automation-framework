package com.sdet.framework.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	private String name;
	private String email;

	public String getName() {
		return name;
	}

	public String email() {
		return email;
	}

}