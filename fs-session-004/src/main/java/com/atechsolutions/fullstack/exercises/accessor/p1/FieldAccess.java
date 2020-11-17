package com.atechsolutions.fullstack.exercises.accessor.p1;

public class FieldAccess {
    private String privateField = "Private";
    protected String protectedField = "Protected";
    String defaultField = "Default";
    public String publicField = "Public";

    public static void main(String[] args) {
        FieldAccess access = new FieldAccess();
        System.out.println("Field: " + access.privateField);
        System.out.println("Field: " + access.protectedField);
        System.out.println("Field: " + access.defaultField);
        System.out.println("Field: " + access.publicField);
    }
}
