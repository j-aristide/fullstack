package com.atechsolutions.fullstack.exercises;

public class Exception101 {
    public static void main(String[] args) {
        // Certain operations in java  can produce undesired results.  These results are wrapped into a special object type called exceptions.

        // Exploring out-of-box generated exception (ArrayOutOfBoundsException)
        int array[] = {1,2};

        // The array is initialized with 2 values (1 and 2)
        // This throws an ArrayOutOfBoundsException since the array has been sized to only hold 2 values
        System.out.println("What is at the 3rd position: " + array[2]);
    }
}
