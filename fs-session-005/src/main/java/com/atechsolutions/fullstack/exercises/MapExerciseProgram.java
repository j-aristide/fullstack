package com.atechsolutions.fullstack.exercises;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapExerciseProgram {
    public static void main(String[] args) {
        Map<String, String> userDetails = new LinkedHashMap<>();
        userDetails.put("First Name", "Jean");
        userDetails.put("Last Name", "Aristide");
        userDetails.put("City", "Tampa");
        userDetails.put("State", "FL");
        userDetails.put("State", "FL");

        System.out.println(userDetails);

        System.out.println(userDetails.get("State"));

        for(Map.Entry<String, String> entry : userDetails.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

    }
}
