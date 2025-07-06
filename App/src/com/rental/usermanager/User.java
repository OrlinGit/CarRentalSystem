package com.rental.usermanager;

import java.util.UUID;

/*
This class is responsible for the creation and handling of the users.
 */
public class User {
	private UUID id;
	private String name;
	private String password;

	/*
	In this constructor I use deterministic ID based on username and password.
	This way we can identify a user just by the UUID and can determine if the user exists.
	It is faster to search for users and check credentials,
	 */
	public User(String name, String password) {
		this.id = UUID.nameUUIDFromBytes(String.join(",", name, password).getBytes());
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
