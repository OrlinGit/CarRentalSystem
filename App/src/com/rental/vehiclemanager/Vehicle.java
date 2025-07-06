package com.rental.vehiclemanager;

import com.rental.rentalmanager.Rentable;

/*
This is abstract parent class that defines the needed attributes for each Vehicle type that is used by the
Car rental system.
Counter based id is used (instead od UUID) to count all created vehicles,
in order to ease the functionality of the system and make the use of the system user-friendly.
 */
public abstract class Vehicle implements Rentable {
	private static int counter = 0;
	private int id;
	private String make;
	private boolean isAvailable;

	public Vehicle(String make) {
		this.id = ++counter;
		this.make = make;
		this.isAvailable = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getType() {
		return "Vehicle";
	}

	/*
	This function generates String with coma separated information that is valid to write to a csv file.
	*/
	public String toFile() {
		return String.join(",",
				String.valueOf(this.getId()),
				this.getMake(),
				String.valueOf(this.isAvailable()));
	}

	@Override
	public boolean isAvailable() {
		return isAvailable;
	}

	@Override
	public void makeNotAvailable() {
		this.isAvailable = false;

	}

	@Override
	public void makeAvailable() {
		this.isAvailable = true;
	}

	@Override
	public String toString() {
		return this.id + this.make + this.isAvailable;
	}
}
