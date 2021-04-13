package com.company;

public class Motor_car extends Car {
    public Motor_car (String code_car, int gos_number, double mileage, double dop_param)
    {
        super(code_car, gos_number, mileage, dop_param);
        double cost_liter = 46.10;
        double fuel_consumption = 12.5;
    }
}
