package com.atechsolutions.fullstack.exercises.inheritance;

public class ContactInformation {
    private String streetName;
    private String aptNumber;
    private String city;
    private String state;
    private String zipcode;


    public String getStreetName() {
        return streetName;
    }

    public String getAptNumber() {
        return aptNumber;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public ContactInformation streetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public ContactInformation apartmentNumber(String apartmentNumber) {
        this.aptNumber = apartmentNumber;
        return this;
    }

    public ContactInformation city(String city) {
        this.city = city;
        return this;
    }

    public ContactInformation state(String state) {
        this.state = state;
        return this;
    }

    public ContactInformation zipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    @Override
    public String toString() {
        return "ContactInformation{" +
                "streetName='" + streetName + '\'' +
                ", aptNumber='" + aptNumber + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
