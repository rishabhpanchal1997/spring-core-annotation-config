package com.engine;

import org.springframework.stereotype.Component;

@Component
public class DieselEngine implements Engine{
    private String fuel;
    private int weight;

    //Setter Injection → Requires default constructor
    //Constructor Injection → Does not require default constructor
    public DieselEngine(String fuel, int weight) {
        this.fuel = fuel;
        this.weight = weight;
    }

    public DieselEngine(){
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void start() {
        System.out.println("Diesel Engine started with fuel: " + fuel + ", weight: " + weight + "kg.");
    }
}
