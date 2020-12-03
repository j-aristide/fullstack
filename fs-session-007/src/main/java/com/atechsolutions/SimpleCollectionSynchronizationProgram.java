package com.atechsolutions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SimpleCollectionSynchronizationProgram {
    public static void main(String[] args)throws InterruptedException {
        Datastore datastore = new Datastore();
        DataCollector jean = new DataCollector(datastore);
        DataCollector james = new DataCollector(datastore);
        DataCollector kevin = new DataCollector(datastore);

        jean.start();
        kevin.start();
        james.start();
        jean.join();
        james.join();
        kevin.join();

        System.out.println(datastore.getUserCount());
    }


}

class DataCollector extends Thread {
    private static final List<String> firstNames = Arrays.asList("Jean", "Samuel", "Solomon", "David", "Paul", "Juan", "Samual", "Jerome", "Akshat", "Heidi", "Vlamir", "Vladimir", "Logan");
    private static final List<String> lastNames = Arrays.asList("Jacobs", "Fernandez", "Phillips", "Jean-Pierre", "Hitler", "Trump", "Obama", "Clinton", "Fluellen",
            "Jean", "Solomon", "David", "Paul", "Juan", "Samual", "Jerome", "Akshat", "Heidi", "Vlamir", "Vladimir", "Logan");

    private Random random = new Random();
    private Datastore datastore;
    DataCollector(Datastore datastore) {
        this.datastore = datastore;
    }

    public void run() {

        for (int i = 0; i < 25; i++){
            int fIndex = random.nextInt(firstNames.size());
            int lIndex = random.nextInt(lastNames.size());

            datastore.addUser(firstNames.get(fIndex), lastNames.get(lIndex));
        }


    }
}

class Datastore {
    private List<User> users = new ArrayList<>();

    synchronized void addUser(String firstName, String lastName) {
        users.add(new User(firstName, lastName));
    }

    int getUserCount() {
        return users.size();
    }

}

class User {
    private String firstName;
    private String lastName;
    User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
