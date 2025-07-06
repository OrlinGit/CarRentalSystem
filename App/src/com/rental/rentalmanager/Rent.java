package com.rental.rentalmanager;

import com.rental.usermanager.User;
import com.rental.vehiclemanager.Vehicle;

import java.time.LocalDate;
import java.util.UUID;

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

	public String toFile(){
		return String.join(",", String.valueOf(this.id),
				vehicle.toString(),
				user.toString(),
				String.valueOf(rentDate),
				String.valueOf(returnDate));
	}

	@Override
	public String toString() {
		return ("Vehicle id: " + this.vehicle + " user: " + this.user.getName() + " start date: " + this.rentDate +
				" return date: " + this.returnDate);
	}

}
