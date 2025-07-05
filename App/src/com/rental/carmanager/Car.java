package com.rental.carmanager;

public class Car extends Vehicle{
	private String model;
	private int year;

	public Car(String make, String model, int year) {
		super(make);
		this.model = model;
		this.year= year;
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

}
