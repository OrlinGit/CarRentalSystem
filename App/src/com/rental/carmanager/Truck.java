package com.rental.carmanager;

public class Truck extends Vehicle{
	private int weight;

	public Truck(String make, int weight) {
		super(make);
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

}
