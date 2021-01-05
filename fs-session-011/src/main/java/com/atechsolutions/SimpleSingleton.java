package com.atechsolutions;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SimpleSingleton {
    public static void main(String[] args) {
        System.out.println(Hospital.getInstance());
        System.out.println(Hospital.getInstance());
        System.out.println(Hospital.getInstance());
        System.out.println(Hospital.getInstance());
        System.out.println(Hospital.getInstance());
        System.out.println(Hospital.getInstance());

    }
}

class Hospital {
    private final static Hospital hospital = new Hospital(RandomStringUtils.randomAlphabetic(10));
    private String name;

    private Hospital(String name) {
        this.name = name;
    }

    public static Hospital getInstance() {
        return hospital;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .toString();
    }
}
