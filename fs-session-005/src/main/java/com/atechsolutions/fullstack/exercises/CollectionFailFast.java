package com.atechsolutions.fullstack.exercises;

import java.util.ArrayList;
import java.util.List;

public class CollectionFailFast {
    public static void main(String[] args) {
        List<String> values = new ArrayList<>();
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


        for (int i=0; i<values.size(); i++) {
            System.out.println(values.get(i));
        }
    }
}
