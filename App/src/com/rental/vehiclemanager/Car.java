package com.rental.vehiclemanager;

public class Car extends Vehicle {
	private String model;
	private int year;


	public Car(String make, String model, int year) {
		super(make);
		this.model = model;
		this.year = year;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toFile() {
		return String.join(",",
				String.valueOf(this.getId()),
				this.getMake(),
				this.getModel(),
				String.valueOf(this.getYear()),
				String.valueOf(this.isAvailable()));
	}

	public Car fromFile(Car car, String[] data){
		if(data.length != 5){
			System.out.println("Data size not correct!");
		} else {
			int id = Integer.parseInt(data[0]);
			String make = data[1];
			String model = data[2];
			int year = Integer.parseInt(data[3]);
			boolean isAvailable = Boolean.parseBoolean(data[4]);
			car.setId(id);
			car.setMake(make);
			car.setModel(model);
			if(isAvailable){
				car.makeAvailable();
			} else {
				car.makeNotAvailable();
			}
		}
		return car;
	}

	@Override
	public String getType() {
		return "Car";
	}

	@Override
	public String toString() {
		return String.join(" ",
				String.valueOf(this.getId()),
				this.getMake(),
				this.getModel(),
				String.valueOf(this.getYear()),
				String.valueOf(this.isAvailable()));
	}
}
