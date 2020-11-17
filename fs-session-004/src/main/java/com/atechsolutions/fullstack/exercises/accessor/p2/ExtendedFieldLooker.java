package com.atechsolutions.fullstack.exercises.accessor.p2;

import com.atechsolutions.fullstack.exercises.accessor.p1.FieldAccess;

public class ExtendedFieldLooker extends FieldAccess {
    public static void main(String[] args) {
        ExtendedFieldLooker access = new ExtendedFieldLooker();
        //System.out.println("Field: " + access.privateField);
        System.out.println("Field: " + access.protectedField);
        //System.out.println("Field: " + access.defaultField);
        System.out.println("Field: " + access.publicField);
    }
}
