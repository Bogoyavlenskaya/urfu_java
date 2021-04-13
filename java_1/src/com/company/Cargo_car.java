package com.company;

public class Cargo_car extends Car {
    public Cargo_car (String code_car, int gos_number, double mileage, double dop_param)
    {
        super(code_car, gos_number, mileage, dop_param);
        double cost_liter = 48.90;
        double fuel_consumption = 12.00;
    }
}
