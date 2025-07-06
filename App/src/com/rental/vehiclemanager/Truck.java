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

	public Truck fromFile(Truck truck, String[] data){
		if(data.length != 4){
			System.out.println("Data size not correct!");
		} else {
			int id = Integer.parseInt(data[0]);
			String make = data[1];
			int weight = Integer.parseInt(data[3]);
			boolean isAvailable = Boolean.parseBoolean(data[4]);
			truck.setId(id);
			truck.setMake(make);
			truck.setWeight(weight);
			if(isAvailable){
				truck.makeAvailable();
			} else {
				truck.makeNotAvailable();
			}
		}
		return truck;
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
