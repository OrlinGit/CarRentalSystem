package com.rental.carmanager;

public interface Rentable {
	boolean isAvailable();
	void makeNotAvailable();
	void makeAvailable();
}
