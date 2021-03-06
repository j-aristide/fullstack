package com.atechsolutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class ReadingIsFundamental {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/jean.aristide/Downloads/moby.txt"))) {
            String line;

            int counter = 0;
            while ((line = reader.readLine()) != null) {
                counter += line.split(" ").length;
            }

            System.out.println("Number of words: " + counter);
        }
    }
}
