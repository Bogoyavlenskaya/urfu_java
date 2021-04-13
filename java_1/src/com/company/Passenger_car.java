package com.company;

public class Passenger_car extends Car {
    public Passenger_car (String code_car, int gos_number, double mileage, double dop_param)
    {
        super(code_car, gos_number, mileage, dop_param);
        double cost_liter = 47.50;
        double fuel_consumption = 11.5;
    }
}
