package com.timbuchalka;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("yorkie");
        dog.eat();
        dog.breathe();

        Parrot bird = new Parrot("parrot");
        bird.breathe();
        bird.eat();
        bird.fly();

        Penguin penguin = new Penguin("emperor");
        penguin.fly();
    }
}
