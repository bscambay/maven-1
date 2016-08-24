package org.ssa.ironyard;

public class Property {
    final int cost;
    final String street;
    final String city;
    final int squareFootage;

    public Property(int cost, String streetAddress, String city, int squareFootage) {
	this.cost = cost;
	this.street = streetAddress;
	this.city = city;
	this.squareFootage = squareFootage;
    }

}