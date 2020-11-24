package com.atechsolutions.fullstack.exercises.homework;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.*;

public class GPACalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = readStudent(scanner);


        System.out.println(student.calculateGrade());
        System.out.println(student.name + " completed " + student.numberOfCredits() + " credits");


    }

    private static Student readStudent(Scanner scanner) {
        System.out.print("Print your name: ");
        String name = scanner.nextLine();

        int index =0;
        String done = "";
        Class[] classes = new Class[10];

        do {
            System.out.print("Print your class name: ");
            String className = scanner.nextLine();

            System.out.print("How many credits is this class: ");
            int credits = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Print your grade: ");
            String grade = scanner.nextLine();



            classes[index++] = new Class(className, credits, Grade.find(grade));



            System.out.print("Press enter to continue or 'done' to stop: ");
            done = scanner.nextLine();
        } while (!done.equalsIgnoreCase("done") || classes.length < 10);

        return new Student(name, classes);
    }
}

enum Grade {
    A(4), B(3), C(2), D(1), F(0), APA(6), APB(5), APC(3);

    int gradeNumber;
    Grade(int gradeNumber) {
        this.gradeNumber = gradeNumber;
    }

    static Grade find(String value) {
        for(Grade grade : Grade.values()) {
            if(grade.name().equalsIgnoreCase(value))
                return grade;
        }

        throw new IllegalArgumentException("Bad grade provided");
    }
}

class Class {
    String title;
    Grade grade;
    int credits;

    Class(String title, int credits, Grade grade) {
        this.grade = grade;
        this.credits = credits;
        this.title = title;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("title", title)
                .append("grade", grade)
                .toString();
    }
}

class Student {
    String name;
    private Class[] classes;

    Student(String name, Class[] classes) {
        this.name = name;
        this.classes = classes;
    }

    public int numberOfCredits() {
        int numberOfCredits = 0;


        for(Class c : classes) {
            if(c!= null) {
                numberOfCredits += c.credits;
            }
        }

        return numberOfCredits;
    }

    public double calculateGrade() {
        double total = 0;
        int numberOfGrades = 0;


        for(Class c : classes) {
            if(c!= null) {
                total += (c.grade.gradeNumber * c.credits);
                numberOfGrades += c.credits;
            }
        }

        return total/numberOfGrades;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("classes", Arrays.asList(classes))
                .toString();
    }
}
