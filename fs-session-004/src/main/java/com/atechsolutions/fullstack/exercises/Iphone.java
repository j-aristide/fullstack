package com.atechsolutions.fullstack.exercises;

public class Iphone implements Phone, Camera {


    @Override
    public void takePic() {
        System.out.println("Iphone picture taken");
    }

    @Override
    public void call(String phoneNumber) {
        System.out.println("IPhone Making call to " + phoneNumber);
    }
}
