package org.ssa.ironyard;

import org.springframework.stereotype.Component;

@Component
public class Property {

    int cost;
    String street;
    String city;
    int squareFootage;

    public Property(int cost, String city, String street, int squareFootage) {
	this.cost = cost;
	this.street = street;
	this.city = city;
	this.squareFootage = squareFootage;
    }
    
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(int squareFootage) {
        this.squareFootage = squareFootage;
    }

    public Property(){
	
    }

}