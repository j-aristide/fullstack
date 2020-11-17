package com.atechsolutions.fullstack.exercises.accessor.p1;

public class SamePackageFieldLooker {
    public static void main(String[] args) {
        FieldAccess access = new FieldAccess();
        //System.out.println("Field: " + access.privateField);
        System.out.println("Field: " + access.protectedField);
        System.out.println("Field: " + access.defaultField);
        System.out.println("Field: " + access.publicField);
    }
}
