package com.timbuchalka;

public class Main {

    public static int multiplier= 7;
    public static void main(String[] args) {
        /*StaticTest firstInstance = new StaticTest("1st Instance");
        System.out.println(firstInstance.getName() + " is instance number " + firstInstance.getNumInstances());

        StaticTest secondInstance = new StaticTest("2nd instance");
        System.out.println(secondInstance.getName() + " is instance number " + secondInstance.getNumInstances());

        StaticTest thirdInstance = new StaticTest("3rd instance");
       System.out.println(thirdInstance.getName() + " is instance number " + thirdInstance.getNumInstances());
        int answer = multiply(7);
        System.out.println(answer);*/



        SomeClass one = new SomeClass("one");
        SomeClass two = new SomeClass("two");
        SomeClass three = new SomeClass("three");







    }
    public static int multiply (int number){
        return number * multiplier;
    }
}
