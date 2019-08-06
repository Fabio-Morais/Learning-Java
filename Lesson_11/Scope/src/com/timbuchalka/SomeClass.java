package com.timbuchalka;

public class SomeClass {
    private static int classCounter=0;
    /*final = const*/
    public final int instanceNumber;
    private final String name;
    static {
        System.out.println("loading....");
    }
    public SomeClass(String name) {
        this.name=name;
        classCounter++;
        instanceNumber=classCounter;
        System.out.println(name + " created, instance is "+ instanceNumber);
    }
}
