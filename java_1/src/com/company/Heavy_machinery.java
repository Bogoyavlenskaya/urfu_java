package com.company;

public class Heavy_machinery extends Car {
    public Heavy_machinery (String code_car, int gos_number, double mileage, double dop_param)
    {
        super(code_car, gos_number, mileage, dop_param);
        double cost_liter = 48.90;
        double fuel_consumption = 20.00;
    }
}
