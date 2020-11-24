package com.atechsolutions.fullstack.exercises.accessor.p1;

public class AnotherBlueprintInSamePackage {
    public static void main(String[] args) {
        Blueprint instance = new Blueprint();
        //System.out.println("Field: " + instance.privateField);
        System.out.println("Field: " + instance.protectedField);
        System.out.println("Field: " + instance.defaultField);
        System.out.println("Field: " + instance.publicField);
    }
}
