package com.timbuchalka;

public class Main {

    public static void main(String[] args) {
        Hamburger hamburger = new Hamburger("bread roll", "carne", 5, "white");
        hamburger.addAddition1("cheese",1);
        hamburger.addAddition2("milk", 1);
        hamburger.finalHamburger();
        System.out.println();
        HealthyBurger healthyBurger = new HealthyBurger("ro", "veg", 10, "black");
        healthyBurger.addAddition1("lol", 2);
        healthyBurger.addExtraHealth1("cees", 3);
        healthyBurger.finalHamburger();
    }
}
