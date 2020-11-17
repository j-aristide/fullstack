package com.atechsolutions.fullstack.exercises.inheritance;

import java.util.Date;

public class SoftwareDeveloper extends Employee {
    private double minimumBonusRate;
    private double maximumBonusRate;

    public SoftwareDeveloper(String fname, String lname, String employeeNumber, double salary, Date startDate) {
        super(fname, lname, employeeNumber, salary, startDate);
    }

    public SoftwareDeveloper(String fname, String lname, String employeeNumber, double salary, Date startDate, double minimumBonusRate, double maximumBonusRate) {
        super(fname, lname, employeeNumber, salary, startDate);
        this.minimumBonusRate = minimumBonusRate;
        this.maximumBonusRate = maximumBonusRate;
    }

    public double calculateTotalCompensation() {
        return getSalary() * (1 + (maximumBonusRate + minimumBonusRate) / 2);
    }

    public void nowYouSeeMe() {
        System.out.println("Now you see me!!");
    }
}
