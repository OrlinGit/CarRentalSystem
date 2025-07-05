package com.rental.vehiclemanager;

public class Truck extends Vehicle{
	private int weight;

	public Truck(String make, int weight) {
		super(make);
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toFile(){
		return String.join(",",
				String.valueOf(this.getId()),
				this.getMake(),
				String.valueOf(this.getWeight()),
				String.valueOf(this.isAvailable()));
	}

	@Override
	public String getType() {
		return "Truck";
	}

	@Override
	public String toString() {
		return String.join(" ",
				String.valueOf(this.getId()),
				this.getMake(),
				String.valueOf(this.getWeight()),
				String.valueOf(this.isAvailable()));
	}
}
