package com.atechsolutions.fullstack.exercises;

public class InstanceFunctionProgram {
    public static void main(String args[]) {
        Employee employee = new Employee("Jean Aristide");
        employee.empAge(44);
        employee.empDesignation("Manager");
        employee.empSalary(100000.00);


        employee.printEmployee();
    }
}

class Employee {

    private String name;
    private int age;
    private String designation;
    private double salary;

    // This is the constructor of the class Employee
    public Employee(String name) {
        this.name = name;
    }

    // Assign the age of the Employee  to the variable age.
    public void empAge(int empAge) {
        age = empAge;
    }

    /* Assign the designation to the variable designation.*/
    public void empDesignation(String empDesig) {
        designation = empDesig;
    }

    /* Assign the salary to the variable	salary.*/
    public void empSalary(double empSalary) {
        salary = empSalary;
    }

    /* Print the Employee details */
    public void printEmployee() {
        System.out.println("Name:"+ name );
        System.out.println("Age:" + age );
        System.out.println("Designation:" + designation );
        System.out.println("Salary:" + salary);
    }
}

