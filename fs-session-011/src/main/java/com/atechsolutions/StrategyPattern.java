package com.atechsolutions;

import java.sql.DriverAction;

public class StrategyPattern {

    public static void main(String[] args) {
        new Resource(new DrivingAction()).performFunction();
        new Resource(new FlyAction()).performFunction();

    }
}

class FlyAction implements  Action {
    public void doAction() {
        System.out.println("Watch me fly");
    }
}

class DrivingAction implements Action {
    public void doAction() {
        System.out.println("I'm driving");
    }
}

interface Action {
    void doAction();
}

// Noun
class Resource {
    private Action action;

    public Resource(Action action) {
        this.action = action;
    }

    public void performFunction() {
        action.doAction();
    }
}
