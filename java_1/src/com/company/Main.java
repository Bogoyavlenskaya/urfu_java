package com.company;
import com.company.Motor_car;
import com.company.Cargo_car;
import com.company.Passenger_car;
import com.company.Heavy_machinery;
import com.company.Car;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String[] arrayCars = new String[] {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50", "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100", "C300_3-150-29", "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};
        ArrayList<Car> cars = new ArrayList();
        for (int i = 0; i < arrayCars.length; i++) {
            Car car = parse(arrayCars[i]);
            cars.add(car);
        }

        double cost_all_cars = count_cost_all_cars(cars);
        String output_info = get_car_info(cars);
        String car_highest_cost = get_car_highest_cost(cars);
        String car_least_cost = get_car_least_cost(cars);
        System.out.println("All car cost: " + cost_all_cars);
        System.out.println("The type of car with the highest cost " + car_highest_cost);
        System.out.println("The type of car with the lowest cost of spending " + car_least_cost);
        System.out.println("Information about car \n" + output_info);
    }

    private static Car parse(String car) {
        car = car.replace("C","").replace("_", "-");
        String[] car_params = car.split("-");
        String code_car = car_params[0];
        int gos_number = (int) Double.parseDouble(car_params[1]);
        double mileage = Double.parseDouble(car_params[2]);
        double dop_param = 0;
        if (car_params.length == 4) {
            dop_param = Double.parseDouble(car_params[3]);
        }
        return switch (code_car) {
            case "100" -> new Motor_car(code_car, gos_number, mileage, dop_param);
            case "200" -> new Cargo_car(code_car, gos_number, mileage, dop_param);
            case "300" -> new Passenger_car(code_car, gos_number, mileage, dop_param);
            case "400" -> new Heavy_machinery(code_car, gos_number, mileage, dop_param);
            default -> throw new IllegalStateException("Unexpected value: " + code_car);
        };
    }
    // общая стоимость расходов на ГСМ
    private static double count_cost_all_cars(ArrayList<Car> cars) {
        double cost_all_cars = 0.;
        for (Car car :cars) {
            cost_all_cars = cost_all_cars + car.count_cost();
        }
        return cost_all_cars;
    }

    // общая стоимость расходов на каждый класс авто
    private static final String[] car_types = {"100", "200", "300", "400"};
    private static Map<String, Double> count_cost_type_cars(ArrayList<Car> cars) {
        Map<String, Double> cost_type_cars = new HashMap<>();
        for (String car_type : car_types) {
            cost_type_cars.put(car_type, 0.);
        }
        for (Car car : cars) {
            double one_type = cost_type_cars.get(car.code_car);
            double cost_one_type = car.count_cost();
            cost_type_cars.put(car.code_car, one_type + cost_one_type);
        }
        return cost_type_cars;
    }

    // тип авто имеющий наибольшую стоимость расходов
    private static String get_car_highest_cost (ArrayList<Car> cars) {
        double highest_cost = -1.;
        String highest_cost_type = null;
        Map<String, Double> cost_type_by_cars = count_cost_type_cars(cars);
        for (Map.Entry<String, Double> entry : cost_type_by_cars.entrySet()) {
            String car_type = entry.getKey();
            double cost_type_cars = entry.getValue();
            if (cost_type_cars > highest_cost || highest_cost == -1.){
                highest_cost = cost_type_cars;
                highest_cost_type = car_type;
            }
        }
        return highest_cost_type;
    }

    // тип авто имеющий наименьшую стоимость расходов
    private static String get_car_least_cost(ArrayList<Car> cars) {
        double least_cost = -1;
        String least_cost_type = null;
        Map<String, Double> cost_type_by_cars = count_cost_type_cars(cars);
        for (Map.Entry<String, Double> entry : cost_type_by_cars.entrySet()) {
            String car_type = entry.getKey();
            double cost_type_cars = entry.getValue();
            if (cost_type_cars < least_cost || least_cost == -1){
                least_cost = cost_type_cars;
                least_cost_type = car_type;
            }
        }
        return least_cost_type;
    }

    // выводит информацию о каждом авто
    private static String get_car_info(ArrayList<Car> cars) {
        Comparator<Car> cmp = Comparator.comparing(car -> car.mileage);
        cmp = cmp.thenComparing(car -> car.dop_param);
        String output_info = "";
        for (String type : car_types) {
            output_info = output_info.concat("Type car " + type.toUpperCase() + "\n");
            ArrayList<Car> typeList = new ArrayList<>();
            for (Car car : cars) {
                if (car.code_car.equals(type)) {
                    typeList.add(car);
                }
            }
            Stream<Car> typeListStream = typeList.stream().sorted(cmp);
            List<Car> sortedTypeList = typeListStream.collect(Collectors.toList());
            for (Car car : sortedTypeList) {
                String car_info = "";
                car_info = car_info.concat(
                        "Code_car: " + car.code_car + ", gos_number: " + car.gos_number + ", mileage: " + car.mileage + ", dop_param: " + car.dop_param + "\n"
                );
                output_info = output_info.concat(car_info);
            }
            output_info = output_info.concat("\n");
        }
        return output_info;
    }
}
