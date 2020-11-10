package com.atechsolutions.fullstack.exercises;

/**
 * How Strings work
 */
public class StringExerciseProgram {
    public static void main(String args[]) {
        String stringLiteral1 = "My name is Jean";
        String stringLiteral2 = "My name is Jean";

        String stringObject =  new String("My name is Jean");

        // Check if string literals are the same
        System.out.println("\nLiteral1 == Literal2\n");
        System.out.println("\tAre the string literals pointing to the same object: " + (stringLiteral1 == stringLiteral2));

        // Check if string literals are the same as the string object
        System.out.println("\nLiteral1 == Object1\n");
        System.out.println("\tAre the string literals pointing to the same object as the stringObject: " + (stringLiteral1 == stringObject));
        System.out.println("\tAre the string literals pointing to the same object as the stringObject: " + (stringLiteral1.equals(stringObject)));

        // Bring the object in the pool
        System.out.println("\nLiteral1 == Interned Object\n");
        stringObject.intern();
        System.out.println("\tAre the string literals pointing to the same object as the stringObject (calling intern by itself): " + (stringLiteral1 == stringObject));
        stringObject = stringObject.intern();
        System.out.println("\tAre the string literals pointing to the same object as the stringObject (result from intern):" + (stringLiteral1 == stringObject));



        String topher = "Topher's name";
        System.out.println(topher);

        // String Functions
        System.out.println("\nString functions\n");
        System.out.println("\tMy string contain the word Jean. " + stringLiteral1.contains("Jean"));
        System.out.println("\tMy string variable points the same reference as another. " + stringLiteral1.equalsIgnoreCase(stringLiteral2));
        System.out.println("\tReplacing parts of my string. " + stringLiteral1.replace("Jean", "<Student Name Goes Here>"));
        System.out.println("\tI want to see it in CAPS. " + stringLiteral1.toUpperCase());

        // String format
        System.out.println("\nString formatting\n");
        System.out.println(String.format("1.Hello World!!!\n\nHello World!!!")); // New Line
        System.out.println(String.format("2.Hello World!!!\t\t\tHello World!!!")); // Tabs
        System.out.println(String.format("3.Hello %s", "Jean")); // String Placeholder
        System.out.println(String.format("4.%s has %d children", "Jean", 4)); // Number Placeholder
        System.out.println(String.format("My name is %1$s. %1$s is married to  %2$s.", "Jean", "Charlene"));


    }
}
