package com.atechsolutions.fullstack.exercises;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Car {
    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("make", make)
                .append("model", model)
                .append("year", year)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return new EqualsBuilder()
                .append(year, car.year)
                .append(make, car.make)
                .append(model, car.model)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(make)
                .append(model)
                .append(year)
                .toHashCode();
    }
}
