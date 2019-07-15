package com.timbuchalka;

public class Main {

    public static void main(String[] args) {
        Car porsche = new Car(); //Criar um objeto
        /*ao fazer o new estamos a chamar o constructor*/
        Car holden = new Car();
        System.out.println("Model is: "+porsche.getModel());
        porsche.setModel("Carrera");
        System.out.println("Model is: "+porsche.getModel());
        /*OU USAR O CONSTRUCTOR*/

        Car fiat = new Car(2,4,"fiat", "v1", "azul");

        /*OU*/

        Car mercedes = new Car();

        /*OU*/

        Car pe = new Car("das");

        /**     INHERITANCE     **/
        Animal animal = new Animal("Animal",1,1,5,5);
        Dog dog = new Dog("Yorkie", 8,20,2,3,1,20,"long silky");
        dog.eat();
        dog.move(2);

        /**
         * Animal animal = new Animal();
         * Cria uma instancia de classe animal
         * coloca na variavel animal, que é objeto
         * **/

/**
 * House myhouse= new House();
 * House anotherHouse = myhouse;
 *
 * FICAM AS 2 APONTADAS PARA O MESMO LADO
 *
 * Se fizer:
 * anotherHouse.setColor("red");
 * Entao a cor vermelha vai para as 2

    House mySeconHome = new House();
 TEMOS 2 OBJETOS E 3 REFERENCIAS (myhouse, anotherHouse, mySeconHome)

 * */

        /**
         *
         * */


    }
}
