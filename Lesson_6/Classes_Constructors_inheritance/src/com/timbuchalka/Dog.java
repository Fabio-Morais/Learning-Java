package com.timbuchalka;

/*
*       INHERITANCE
* */

/*generalização de aniaml,
* podemos inserir mais coisas para alem do que tem no ANIMAL
* */
public class Dog extends Animal {
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    public Dog(String name, int size, int weigth, int eyes, int legs, int tail, int teeth, String coat) {
        super(name, 1, 1, size, weigth); /*PARA A CLASS ANIMAL*/
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }
    private void chew(){
        System.out.println("chew dog");
        move(5);
    }
    public void run(){
        System.out.println("run called");
        move(10);
    }
    /*overloading*/
    private void modeLegs(int speed){
        System.out.println("movelegs called");
    }
    private void modeLegs(){

    }
    /*overriding*/
    @Override
    public void move(int speed) {
        System.out.println("do.move() called" );
        modeLegs(speed);
        super.move(speed);
    }

    @Override
    public void eat() {
        System.out.println("dog.eat()");
        chew();
        super.eat();
    }
}
