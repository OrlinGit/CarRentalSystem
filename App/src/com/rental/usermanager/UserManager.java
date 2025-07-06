package com.rental.usermanager;

import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserManager {
	private final Map<UUID, User> users = new HashMap<>();
	private final Path pathToUsers = Path.of("App", "src", "com", "rental", "datarepository", "users.csv");
	private final BufferedWriter writer;
	private final BufferedReader reader;

	{
		try {
			reader = new BufferedReader(new FileReader(String.valueOf(pathToUsers)));
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File is not available to read!");
		}
	}

	{
		try {
			writer = new BufferedWriter(new FileWriter(String.valueOf(pathToUsers)));
		} catch (IOException e) {
			throw new RuntimeException("File is not available to write!");
		}
	}

	public User registerUser(String username, String password){
		User user = new User(username, password);
		addUser(user);
		return user;
	}

	public boolean addUser(User user){
		users.put(user.getId(), user);
		return true;
	}

	public User checkUser(String name, String password){
		UUID idToCheck = UUID.nameUUIDFromBytes(String.join(",", name, password).getBytes());
		if(users.containsKey(idToCheck)){
			return new User(name, password);
		}
		return null;
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

	public HashMap<UUID, User> getRegisteredUsers() throws IOException {
		HashMap<UUID, User> registeredUSers = new HashMap<>();
		String line = reader.readLine();
		while (line != null){
			String[] data = line.split(",");
			UUID id = UUID.fromString(data[0]);
			String name = data[1];
			String password = data[2];
			User currentUser = new User(name, password);
			registeredUSers.put(id, currentUser);
			line = reader.readLine();
		}
		reader.close();
		return registeredUSers;
	}
}
