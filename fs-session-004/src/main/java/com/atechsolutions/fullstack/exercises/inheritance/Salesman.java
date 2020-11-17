package com.atechsolutions.fullstack.exercises.inheritance;

import java.util.Date;

public class Salesman extends Employee {
    private double commisionRate;
    private double salesQuota;
    private double totalSales;

    public Salesman(String fname, String lname, String employeeNumber, double salary, Date startDate) {
        super(fname, lname, employeeNumber, salary, startDate);
    }

    public Salesman(String fname, String lname, String employeeNumber, double salary, Date startDate, double commisionRate, double salesQuota) {
        super(fname, lname, employeeNumber, salary, startDate);
        this.commisionRate = commisionRate;
        this.salesQuota = salesQuota;
    }


    public Salesman withTotalSales(double totalSales) {
        this.totalSales = totalSales;
        return this;
    }


    @Override
    public double calculateTotalCompensation() {
        if (salesQuota <= totalSales) {
            return commisionRate * totalSales + getSalary();
        } else if(salesQuota * .8 <= totalSales) {
            return getSalary();
        }


        throw new RuntimeException("You are fired!!!");
    }
}
