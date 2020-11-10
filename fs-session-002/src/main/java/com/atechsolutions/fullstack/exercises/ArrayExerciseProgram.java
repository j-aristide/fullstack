package com.atechsolutions.fullstack.exercises;

import java.util.Arrays;

public class ArrayExerciseProgram {
    public static void main(String args[]) {
        String group1Students[] = new String[]{"Angel", "Oybek", "Arisha"};
        String group2Students[] = new String[]{"Santiago", "Gusmanov", "Nathaniel", "Guna", "Jean", "John"};

        // Exposed variables on an array -- no () present
        System.out.println("Number of Students from the Groups\n");
        System.out.println("\tNumber of students in group 1: " + group1Students.length);
        System.out.println("\tNumber of students in group 2: " + group2Students.length);

        // Exposed functions on an array -- this clones the array
        System.out.println("\nClone\n");
        String [] group1Clone = group1Students.clone();
        String [] group2Clone = group2Students.clone();

        System.out.println("\tNumber of students in group 1 clone: " + group1Clone.length);
        System.out.println("\tNumber of students in group 2 clone: " + group2Clone.length);
        System.out.println("\tAre Group1 and Group1Clone the same: " + (group1Students == group1Clone));
        System.out.println("\tAre Group2 and Group2Clone the same: " + (group2Students == group2Clone));

        // In arrays '==' and equals method are the same
        System.out.println("\tAre Group1 and Group1Clone the same from equals method: " + (group1Students.equals(group1Clone)));
        System.out.println("\tAre Group2 and Group2Clone the same from equals method: " + (group2Students.equals(group2Clone)));

        // To verify equality of content of arrays, must use function Arrays.equals
        System.out.println("\tAre Group1 and Group1Clone equal using Arrays.equals method: "+ Arrays.equals(group1Students, group1Clone));
        System.out.println("\tAre Group2 and Group2Clone equal using Arrays.equals method: "+ Arrays.equals(group2Students, group2Clone));


        // Accessing data from an array
        System.out.println("\nReading data from an array\n");
        System.out.println("\tStudent at position(0): " + group1Students[0]);
        System.out.println("\tStudent at position(1): " + group1Students[1]);
        System.out.println("\tStudent at position(2): " + group1Students[2]);

        // Replacing records in an array
        System.out.println("\nRecord replacement\n");
        System.out.println("\tOriginal Student at position(1): " + group2Students[1]);
        group2Students[1] = "Jason";
        System.out.println("\tNew Student at position(1): " + group2Students[1]);

        // Deleting records from an array
        System.out.println("\nRecord deletion\n");
        System.out.println("\tOriginal Student at position(1): " + group2Students[1]);
        group2Students[1] = null;
        System.out.println("\tNew Student at position(1): " + group2Students[1]);


        // Arrays Utility
        System.out.println("\nArrays Utility\n");
        System.out.printf("\tLet's search for the location of %s: %s", "Oybek", Arrays.binarySearch(group1Clone, "Oybek"));
    }
}
