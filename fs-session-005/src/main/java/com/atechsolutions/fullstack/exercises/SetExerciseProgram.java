package com.atechsolutions.fullstack.exercises;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Key Points:
 *  Order is preserved in a list.
 *  Items can be added, removed, updated.
 *  List can be iterated through.
 *  Duplicate records can be added to a list.
 */
public class SetExerciseProgram {
    public static void main(String args[]) {
        //hashSet();
        //linkedHashSet();
        treeSet();
    }

    public static void treeSet() {
        System.out.println("\nTreeSet:");
        TreeSet<String> values = new TreeSet<>();
        values.add("January");
        values.add("February");
        values.add("March");
        values.add("April");
        values.add("May");
        values.add("June");
        values.add("July");
        values.add("August");
        values.add("September");
        values.add("October");
        values.add("November");
        values.add("December");

        System.out.println("\tInitial set size: " + values.size());
        System.out.println("\tInitial set: " + values);

        for(String value : values) {
            System.out.println("Looping through: " + value);
        }

    }

    public static void linkedHashSet() {
        System.out.println("\nLinkedHashSet:");
        LinkedHashSet<String> values = new LinkedHashSet<>();
        values.add("January");
        values.add("February");
        values.add("March");
        values.add("April");
        values.add("May");
        values.add("June");
        values.add("July");
        values.add("August");
        values.add("September");
        values.add("October");
        values.add("November");
        values.add("December");

        System.out.println("\tInitial set size: " + values.size());
        System.out.println("\tInitial set: " + values);

    }

    public static void hashSet() {
        System.out.println("\nHashSet:");
        Set<String> values = new HashSet();

        values.add("January");
        values.add("February");
        values.add("March");
        values.add("April");
        values.add("May");
        values.add("June");



        // Display contents of list
        System.out.println("\tInitial set size: " + values.size());
        System.out.println("\tInitial set: " + values);

        values.add("July");
        values.add("August");
        values.add("September");
        values.add("October");
        values.add("November");
        values.add("December");

        System.out.println("\t**Initial set size: " + values.size());
        System.out.println("\t**Initial set: " + values);

        values.add("December");

        System.out.println("\t--Initial set size: " + values.size());
        System.out.println("\t--Initial set: " + values);
    }
}
