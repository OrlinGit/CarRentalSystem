package com.rental.usermanager;

import java.util.UUID;

public class User {
	private UUID id;
	private String name;
	private String password;

	public User(String name, String password) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.password = password;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
}
