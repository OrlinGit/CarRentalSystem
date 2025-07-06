package com.rental.vehiclemanager;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class VehicleManager {
	private final List<Vehicle> vehicles = new ArrayList<>();
	private final Path pathToCars = Path.of("App", "src", "com", "rental", "datarepository", "cars.csv");
	private final BufferedWriter writer;
	private final BufferedReader reader;

	{
		try {
			reader = new BufferedReader(new FileReader(String.valueOf(pathToCars)));
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File is not available to read!");
		}
		try {
			writer = new BufferedWriter(new FileWriter(String.valueOf(pathToCars)));
		} catch (IOException e) {
			throw new RuntimeException("File is not available to write!");
		}
	}

	public static Car makeCar(String make, String model, int year) {
		return new Car(make, model, year);
	}

	public static Truck makeTruck(String make, int weight){
		return new Truck(make, weight);
	}

	public void addVehicle(Vehicle vehicle){
		vehicles.add(vehicle);
		System.out.println(vehicle.toString());
	}

	public Vehicle getVehicle(int id){
		for (int i = 0; i < vehicles.size(); i++) {
			if(vehicles.get(i).getId() == id){
				return vehicles.get(i);
			}
		}
		return null;
	}

	public Car editCar(Car carToModify, String make, String model, int year){
		int id = carToModify.getId();
		boolean isAvailable = carToModify.isAvailable();
		carToModify.setId(id);
		carToModify.setMake(make);
		carToModify.setModel(model);
		carToModify.setYear(year);
		if(isAvailable){
			carToModify.makeAvailable();
		} else {
			carToModify.makeNotAvailable();
		}
		return carToModify;
	}

	public Truck editTruck(Truck truckToModify, String make, int weight){
		int id = truckToModify.getId();
		boolean isAvailable = truckToModify.isAvailable();
		truckToModify.setId(id);
		truckToModify.setMake(make);
		truckToModify.setWeight(weight);
		if(isAvailable){
			truckToModify.makeAvailable();
		} else {
			truckToModify.makeNotAvailable();
		}
		return truckToModify;
	}

	public void removeVehicle(int index){
		vehicles.remove(index);
		System.out.println(vehicles.get(index).toString());
	}

	public void printAllVehicles(){
		for (int i = 0; i < vehicles.size(); i++) {
			System.out.println(vehicles.get(i).toString());
		}
	}
	public void printAvailable(){
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).isAvailable()) {
				System.out.println(vehicles.get(i).toString());
			}
		}
	}

	public void printCars(){
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).getType().equals("Car")) {
				System.out.println(vehicles.get(i).toString());
			}
		}
	}

	public void printTrucks(){
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).getType().equals("Truck")) {
				System.out.println(vehicles.get(i).toString());
			}
		}
	}

	public void writeToFile() throws IOException {
		for (int i = 0; i < vehicles.size() ; i++) {
			writer.write(vehicles.get(i).toFile());
			writer.newLine();
		}
		writer.close();
	}

	public void printFromFile() throws IOException {
		String line = reader.readLine();
		while (line != null){
			System.out.println(line);
			line = reader.readLine();
		}
		reader.close();
	}

	public int size(){
		return vehicles.size();
	}
}
