package com.atechsolutions.fullstack.exercises;

public class OperatorProgram {
    public static void main(String args[]) {
        // Non-Decimal operations
        int a = 10 + 5;
        System.out.println("Value of a: " + a);

        int b = (10 + 5) * 10;
        System.out.println("Value of b: " + b);

        int c = (10 + 5) / 10;
        System.out.println("Value of c: " + c);

        double d = (10 + 5) / 10.0;
        System.out.println("Value of d: " + d);

        // Decimal Operations
        System.out.println();
        double e = 1.0 + 1.0;
        System.out.println("Value of e: " + e);

        double f = 1 / 1.0;
        System.out.println("Value of f: " + f);

        // Bitwise Operators
        System.out.println();
        boolean g = true | false;
        System.out.println("Value of g: " + g);

        boolean h = true | true;
        System.out.println("Value of h: " + h);

        boolean i = false | false;
        System.out.println("Value of i: " + i);

        boolean j = true & false;
        System.out.println("Value of j: " + j);

        boolean k = true & true;
        System.out.println("Value of k: " + k);

        boolean l = true & false;
        System.out.println("Value of l: " + l);

        // Bitwise Shift
        //0000 1000  -> 8
        System.out.println();
        int m = 8;
        System.out.println("Shift to right: " + (m >> 1)); // 0100 -> 4 -- No zero fill
        System.out.println("Shift to right: " + (m >>> 1)); // 0000 0100 -> 4 -- zero fill
        System.out.println("Shift to right: " + (m >> 1)); // 0000 0100 -> 4
        System.out.println("Shift to left: " + (m << 1)); // 0001 0000 -> 16
        System.out.println("Exclusive OR: " + (~m)); // 0001 0000 -> -9


        // Modulo Operator
        System.out.println();
        int n = 29 % 3;
        System.out.println("Modulo test: " + n);

        // Short cut operator
        System.out.println();
        int o = 19;
        System.out.println("Short cut multiplier: " + (o *= 2));

        // Increment & Decrement
        System.out.println();
        int p = 0;
        System.out.println("Post-Increment " + p++);
        System.out.println("Pre-Increment " + ++p);

        int q = 0;
        System.out.println("Post-Decrement " + q--);
        System.out.println("Pre-Decrement " + --q);
    }
}
