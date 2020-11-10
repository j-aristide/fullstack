package com.atechsolutions.fullstack.exercises;

public class LoopingThroughArrayProgram {
    public static void main(String args[]) {
        String students[] = new String[]{"Oyebek", "Nathaniel", "Arisha", "Angel", "Guna", "Santiago", "Gusmanov", "Matthew", "James"};

        // External Iterator
        // Print all Students
        System.out.println("\nList of Students\n");
        for(int i=0; i<students.length; i++) {
            System.out.printf("\tHi %s, welcome to the class\n", students[i]);
        }

        // Print all Students reverse order
        System.out.println("\nList of Students in Reverse order\n");
        for(int i=students.length -1; i>=0; i--) {
            System.out.printf("\tHi %s, welcome to the class\n", students[i]);
        }

        // For each Loop
        System.out.println("\nList of Students using for-each loop\n");
        for(String student : students) {
            System.out.printf("\tHi %s, welcome to the class\n", student);
        }

        // For each Loop
        System.out.println("\nList of Students using for-each loop\n");
        for(String student : students) {
            System.out.printf("\tHi %s, welcome to the class\n", student);

            if("Vladimir".equalsIgnoreCase(student))
                continue;

            System.out.print("Take this syllabus");

            if("Naomi".equalsIgnoreCase(student))
                break;
        }

        // While Loop
        System.out.println("\nList of Students using while loop\n");
        int index = 0;
        while(index <students.length) {
            System.out.printf("\tHi %s, welcome to the class\n", students[index++]);
        }

        // While Reverse Order
        System.out.println("\nList of Students using while loop in reverse\n");
        index = students.length;
        while(index >0) {
            System.out.printf("\tHi %s, welcome to the class\n", students[--index]);
        }

        // Do While Loop -- Notice this will run N+1 times
        // While Loop
        index = 0;
        System.out.println("\nAdmit students to class\n");
        do {
            System.out.printf("\tAdmitted into the class -- index position: %d -- number of students in array: %d\n", index, students.length);
        } while (index++<students.length);

    }
}
