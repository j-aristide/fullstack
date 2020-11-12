package com.atechsolutions.fullstack.exercises;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ObjectExerciseProgram {
    public static void main(String[] args) {
        Student oybek = new Student("Oybek", "Gusmanov", '-');
        oybek.setGradePointAverage(4.0);
        oybek.setExpectedGraduationDate("12-12-2020");

        System.out.println(oybek.getFirstName());
    }
}

class Teacher {
    private Student[] students;
}

class Student {
    private Teacher teacher;
    private final String firstName;
    private final char middleInitial;
    private final String lastName;
    private double gradePointAverage;
    private String expectedGraduationDate;

    public Student(String firstName, String lastName, char middleInitial) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
    }

    public String getFirstName() {
        return firstName;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public double getGradePointAverage() {
        return gradePointAverage;
    }

    public void setGradePointAverage(double gradePointAverage) {
        this.gradePointAverage = gradePointAverage;
    }

    public String getExpectedGraduationDate() {
        return expectedGraduationDate;
    }

    public void setExpectedGraduationDate(String expectedGraduationDate) {
        this.expectedGraduationDate = expectedGraduationDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("firstName", firstName)
                .append("middleInitial", middleInitial)
                .append("lastName", lastName)
                .append("gradePointAverage", gradePointAverage)
                .append("expectedGraduationDate", expectedGraduationDate)
                .toString();
    }
}
