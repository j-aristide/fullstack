package com.atechsolutions.fullstack.exercises;

public class MultiDimensionalArrayProgram {
    public static void main(String args[]) {
        String students [][] = {{"Oybek", "Gusmanov", "4.0", "2020", "2020"}, {"Angel", "Santiago", "4.0", "2020", "2021"}};

        String fname = null;
        for(String[] student : students) {
            showStudentInfo(student);
            fname = student[0];
            System.out.println();
        }



    }

    private static void showStudentInfo(String[] student) {
        System.out.printf("First Name: %s\tLastName: %s\n", student[0], student[1]);
    }

}