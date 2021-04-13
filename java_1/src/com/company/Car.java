package com.company;

public class Car {
    // код транспортного средства
    String code_car;
    // гос номер
    int gos_number;
    // пробег
    double mileage;
    // доп. параметры
    double dop_param;
    // стоимость литра топлива
    double cost_liter;
    // расход топлива на 100 км
    double fuel_consumption;

    public Car(String code_car, int gos_number, double mileage, double dop_param) {
        this.code_car = code_car;
        this.gos_number = gos_number;
        this.mileage = mileage;
        this.dop_param = dop_param;
    }

    public double count_cost() {
        return cost_liter*fuel_consumption*mileage;
    }
}
