package com.atechsolutions.fullstack.exercises;

public class SamsungNote20 implements Camera, Phone {
    @Override
    public void takePic() {
        System.out.println("SamsungNote20 picture taken");
    }

    @Override
    public void call(String phoneNumber) {
        System.out.println("SamsungNote20 Making call to " + phoneNumber);
    }


}
