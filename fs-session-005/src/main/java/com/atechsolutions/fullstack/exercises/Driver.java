package com.atechsolutions.fullstack.exercises;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Driver {
    public static void main(String[] args) {
        Set<Car> cars = new HashSet<>();
        cars.add(new Car("Genesis", "G70", 2019));
        cars.add(new Car("Honda", "Civic", 2019));

        cars.add(new Car("Honda", "Civic", 2019));
        //cars.add(new Car("Honda", "Odyssey", 2020));
        //cars.add(new Car("Honda", "Accord", 2006));
        //cars.add(new Car("Porsche", "924S", 1987));

        Driver oybek = new Driver("Oybek", cars);


        System.out.println("------>" + oybek);

        System.out.println(cars.contains(new Car("Honda", "Civic", 2019)));
    }


    private String name;
    private Set<Car> cars;

    public Driver(String name, Set<Car> cars) {
        this.name = name;
        this.cars = cars;
    }



    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
                .append("name", name)
                .append("cars", cars)
                .toString();
    }
}
