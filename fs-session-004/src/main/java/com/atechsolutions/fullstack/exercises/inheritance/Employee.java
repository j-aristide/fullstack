package com.atechsolutions.fullstack.exercises.inheritance;

import java.util.Date;

public abstract class Employee {
    private final String fname;
    private final String lname;
    private final String employeeNumber;
    private final double salary;
    private final Date startDate;
    private Date endDate;
    private ContactInformation contactInformation;

    public Employee(String fname, String lname, String employeeNumber, double salary, Date startDate) {
        this.fname = fname;
        this.lname = lname;
        this.employeeNumber = employeeNumber;
        this.salary = salary;
        this.startDate = startDate;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public double getSalary() {
        return salary;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public abstract double calculateTotalCompensation();

    @Override
    public String toString() {
        return "Employee{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", salary=" + salary +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
