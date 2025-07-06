package com.rental.rentalmanager;

import com.rental.usermanager.User;
import com.rental.vehiclemanager.Vehicle;
import com.rental.vehiclemanager.VehicleManager;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
This class is responsible for all connections and functions that the associated with the actions on renting vehicles.
 */
public class RentalManager {
	public final List<Rent> rentedVehicles = new ArrayList<>();
	Path pathToRents = Path.of("App", "src", "com", "rental", "datarepository", "rents.csv");
	public final BufferedWriter writer;
	public final BufferedReader reader;
	public final VehicleManager vehicleManager = new VehicleManager();

	{
		try {
			reader = new BufferedReader(new FileReader(String.valueOf(pathToRents)));
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File is not available to read!");
		}
		try {
			writer = new BufferedWriter(new FileWriter(String.valueOf(pathToRents), true));
		} catch (IOException e) {
			throw new RuntimeException("File is not available to write!");
		}
	}

	public void rentVehicle(Rentable vehicle, User user, LocalDate rentDate, LocalDate returnDate) {
		if (!vehicle.isAvailable()) {
			System.out.println("Vehicle is not available for renting!");
		} else {
			Rent rentedVehicle = new Rent(vehicle, user, rentDate, returnDate);
			rentedVehicles.add(rentedVehicle);
			print(rentedVehicle);
		}
	}

	public void returnVehicle(int id) {
		Vehicle vehicle = vehicleManager.getVehicle(id);
		vehicle.makeAvailable();
		System.out.println(vehicle.toString());
	}

	/*
	This function is used to print the details of each rented vehicle to confirm successful action on renting vehicle.
	 */
	public void print(Rent rent) {
		System.out.println(rent.toString());
	}

	/*
	This function is used to write all the rented vehicles
	that are saved in the List rentedVehicles before closing the application.
	 */
	public void writeToFile() throws IOException {
		for (int i = 0; i < rentedVehicles.size(); i++) {
			writer.write(rentedVehicles.get(i).toFile());
			writer.newLine();
		}
		writer.close();
	}

	/*
	This function is used to print all teh information saved in the csv file.
	 */
	public void printFromFile() throws IOException {
		String line = reader.readLine();
		while (line != null) {
			System.out.println(line);
			line = reader.readLine();
		}
		reader.close();
	}

	/*
	This function is used to print all the rented vehicles in the List that are not yet saved to the file.
	 */
	public void printRentedVehicles() {
		for (int i = 0; i < rentedVehicles.size(); i++) {
			System.out.println(rentedVehicles.get(i));
		}
	}
}
