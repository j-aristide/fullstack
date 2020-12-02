package com.atechsolutions.fullstack.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Key Points:
 *  Order is preserved in a list.
 *  Items can be added, removed, updated.
 *  List can be iterated through.
 *  Duplicate records can be added to a list.
 */
public class ListExerciseProgram {
    public static void main(String[] args) {
        arrayList();
        //linkedList();
    }

    /**
     * If you intend to manipulate the data this is the list to use.
     */
    public static void linkedList() {
        LinkedList<String> values = new LinkedList<>();
        values.addFirst("June");
        values.addLast( "July");

        System.out.println("List:\t" + values);

        values.addFirst("May");
        values.addLast("August");

        System.out.println("List:\t" + values);

        values.add(0, "April");
        System.out.println("List:\t" + values);

        values.add("September");
        System.out.println("List:\t" + values);

        values.add("September");
        System.out.println("List:\t" + values);

        for(String value : values) {
            System.out.println("Looping through: " + value);
        }
    }

    /**
     * When to use:
     *  This is implemented using a dynamic array.  It is costly every time you have to modify this object.
     *  Not good you plan to do a lot of updates (deletes and additions)
     *  Easily queried
     */
    public static void arrayList() {
        // Create a list
        System.out.println("Create and populate list\n");
        ArrayList<String> values = new ArrayList<>();
        values.add("Jean");
        values.add("Nathaniel");

        // Display contents of list
        System.out.println("\tInitial list:" + values);

        // Expand list by adding more elements
        values.add("Tyler");
        values.add("Arisha");

        // Now, display contents list
        System.out.println("\tAdding more values to list:" + values);

        // Add some more and display, include duplicate records
        values.add("Jean");
        values.add("Oybek");

        System.out.println("\tAdding duplicate value for Jean: " + values);

        // Data retrieval
        System.out.println("\tGetting the first record from the list: " + values.get(0));

        // Looping -- array rules apply here -- refer to arrays lesson
        System.out.println("\nIterating through a list similar to array\n");
        for(String value : values)
            System.out.println("\t" + value);

        // Removing data from a list
        System.out.println("\nRemoving Jean from the list\n");
        System.out.println("\tInitial values: " + values);
        System.out.println("\tArrayList size: " + values.size());
        values.remove("Jean");

        System.out.println("\tAfter executing remove command" + values);
        System.out.println("\tArrayList size: " + values.size());

        // Create List from Array using Arrays utility -- all functions of list apply to this
        List<String> list1 = Arrays.asList("Jean", "Oybek", "Tyler", "Angel");
        System.out.println("\nCreating list in line:" + list1);

        // Creating a list from another list
        ArrayList<String> list2 = new ArrayList(list1);
        System.out.println("\nCreating list from an existing list" + list2);

    }
}
