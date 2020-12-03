package com.atechsolutions.fullstack.exercises;

import java.io.*;

public class Exception107 {
    public static void main(String[] args)throws Exception {

        try(BufferedReader reader = new BufferedReader(new FileReader(new File("path")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);

            }
        }
    }
}
