package com.atechsolutions.fullstack.exercises.accessor.p2;

import com.atechsolutions.fullstack.exercises.accessor.p1.Blueprint;

public class DifferentPackageFieldLooker {
    public static void main(String[] args) {
        Blueprint access = new Blueprint();
        //System.out.println("Field: " + access.privateField);
        //System.out.println("Field: " + access.protectedField);
        //System.out.println("Field: " + access.defaultField);
        System.out.println("Field: " + access.publicField);
    }
}
