package com.rental.usermanager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserManager {
	private final Map<UUID, User> users = new HashMap<>();
	private final Path pathToUsers = Path.of("src", "com.rental", "datarepository", "users");
	private final BufferedWriter writer;

	{
		try {
			writer = new BufferedWriter(new FileWriter(String.valueOf(pathToUsers)));
		} catch (IOException e) {
			throw new RuntimeException("File is not available!");
		}
	}

	public void addUser(User user){
		users.put(user.getId(), user);
	}

	public void printUsers(){
		for(Map.Entry<UUID, User> user : users.entrySet()){
			System.out.println("User: " + user.getValue().getName());
		}
	}
	public void writeToFile() throws IOException {
		for(Map.Entry<UUID, User> user : users.entrySet()){
			String id = String.valueOf(user.getKey());
			String name = user.getValue().getName();
			String password = user.getValue().getPassword();
			String line = String.join(",",id,name,password);
			writer.write(line);
			writer.newLine();
		}
		writer.close();
	}

}
