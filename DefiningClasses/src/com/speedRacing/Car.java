package com.speedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelConsumptionPer1KM;
    private int travelledDistance;

    public Car(String model, double fuelAmount, double fuelConsumptionPer1KM) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelConsumptionPer1KM = fuelConsumptionPer1KM;
        this.travelledDistance = 0;
    }

    public double calculateRequiredFuel(int distance){
        return this.getFuelConsumptionPer1KM() * distance;
    }

    public boolean hasEnoughFuel(int distance){
        return fuelAmount >= calculateRequiredFuel(distance);
    }

    public void drive(int distance){
        if(hasEnoughFuel(distance)){
            this.fuelAmount -= calculateRequiredFuel(distance);
            this.travelledDistance += distance;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelConsumptionPer1KM() {
        return fuelConsumptionPer1KM;
    }

    public void setFuelConsumptionPer1KM(double fuelConsumptionPer1KM) {
        this.fuelConsumptionPer1KM = fuelConsumptionPer1KM;
    }

    public int getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(int travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", model, fuelAmount, travelledDistance);
    }
}
