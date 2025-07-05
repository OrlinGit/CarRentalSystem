package com.rental.rentalmanager;

public interface Rentable {
	boolean isAvailable();
	void makeNotAvailable();
	void makeAvailable();
}
