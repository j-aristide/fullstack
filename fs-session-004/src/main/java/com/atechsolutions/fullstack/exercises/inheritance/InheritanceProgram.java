package com.atechsolutions.fullstack.exercises.inheritance;

import static com.atechsolutions.fullstack.exercises.inheritance.DateUtils.now;

public class InheritanceProgram {
    public static void main(String args[]) {
        SoftwareDeveloper softwareDeveloper = new SoftwareDeveloper("Akshat", "SomeLastName", "123456", 820000, now(), .1, .15);
        Employee salesman = new Salesman("Jean", "Aristide", "987654", 50000, now(), .02, 2500000).withTotalSales(2250000);

        System.out.println(salesman.calculateTotalCompensation());


        ContactInformation contactInformation = new ContactInformation().streetName("123 Acme Street").city("Miami").state("FL").zipcode("33168");
        System.out.println(contactInformation);


        softwareDeveloper.nowYouSeeMe();

    }
}
