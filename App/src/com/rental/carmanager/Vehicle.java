package com.rental.carmanager;

public abstract class Vehicle implements Rentable{
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

	public String getMake() {
		return make;
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
}
