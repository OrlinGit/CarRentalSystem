package com.rental.rentalmanager;

import com.rental.usermanager.User;
import com.rental.vehiclemanager.Vehicle;

import java.time.LocalDate;
import java.util.UUID;
/*
The Rent class is created to hold the information about each rent action.
This class makes the connection between each rented vehicle and the timeline.
 */
public class Rent {
	private UUID id;
	private Rentable vehicle;
	private User user;
	private LocalDate rentDate;
	private LocalDate returnDate;

	public Rent(Rentable vehicle, User user, LocalDate rentDate, LocalDate returnDate){
		this.id = UUID.randomUUID();
		this.vehicle = vehicle;
		this.user = user;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		vehicle.makeNotAvailable();
	}

	public Rentable getVehicle() {
		return vehicle;
	}

	public void setVehicle(Rentable vehicle) {
		this.vehicle = vehicle;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getRentDate() {
		return rentDate;
	}

	public void setRentDate(LocalDate rentDate) {
		this.rentDate = rentDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public void returnVehicle(Vehicle vehicle){
		vehicle.makeAvailable();
	}

	/* This method turns the Rent instance into String where the information is separated by comas.
	In this way the instance can be saved to csv file.
	 */
	public String toFile(){
		return String.join(",", String.valueOf(this.id),
				vehicle.toString(),
				user.toString(),
				String.valueOf(rentDate),
				String.valueOf(returnDate));
	}
/*
Makes the instance to String available for printing.
It shows only information needed by the user.
 */
	@Override
	public String toString() {
		return ("Vehicle id: " + this.vehicle + " user: " + this.user.getName() + " start date: " + this.rentDate +
				" return date: " + this.returnDate);
	}

}
