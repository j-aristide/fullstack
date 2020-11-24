package com.atechsolutions.fullstack.exercises.accessor.p1;

public class Blueprint {
    private String privateField = "Private";
    protected String protectedField = "Protected";
    String defaultField = "Default";
    public String publicField = "Public";

    public static void main(String[] args) {
        Blueprint instance = new Blueprint();

        System.out.println("Field: " + instance.privateField);
        System.out.println("Field: " + instance.protectedField);
        System.out.println("Field: " + instance.defaultField);
        System.out.println("Field: " + instance.publicField);
    }
}
