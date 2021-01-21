package com.atechsolutions;

public class DecoratorPatternProgram {
    public static void main(String[] args) {
        Beverage beverage = new Mocha(new Whip(new DarkRoast()));

        System.out.println(beverage.cost());
    }
}

abstract class Beverage {
    //abstract String description();

    abstract double cost();
}


abstract class Condiment extends Beverage {
}

class Whip extends Condiment {
    private Beverage beverage;
    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    double cost() {
        return .15 + beverage.cost();
    }
}

class Mocha extends Condiment {
    private Beverage beverage;
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    double cost() {
        return .30 + beverage.cost();
    }
}



class HouseBlend extends Beverage {

    @Override
    public double cost() {
        return 1.25;
    }
}

class DarkRoast extends Beverage {
    @Override
    public double cost() {
        return 1.50;
    }
}




