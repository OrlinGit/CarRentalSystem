package com.rental.rentalmanager;

/*
The Rentable interface creates the  logic of what a logic a Rentable item should implement.
 */
public interface Rentable {
	boolean isAvailable();
	void makeNotAvailable();
	void makeAvailable();
}
