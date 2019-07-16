package com.timbuchalka;

public class Hamburger {
    private String name;
    private String rollType;
    private String meat;
    private int price;

    private String add1;
    private int priceAdd1;
    private String add2;
    private int priceAdd2;
    private String add3;
    private int priceAdd3;
    private String add4;
    private int priceAdd4;

    private int total;



    public Hamburger(String rollType, String meat, int price, String name) {
        this.rollType = rollType;
        this.meat = meat;
        this.price = price;
        this.name=name;
    }

    public void addAddition1(String add1, int price){
        this.add1=add1;
        this.priceAdd1=price;
    }
    public void addAddition2(String add2, int price){
        this.add2=add2;
        this.priceAdd2=price;
    }
    public void addAddition3(String add3, int price){
        this.add3=add3;
        this.priceAdd3=price;
    }
    public void addAddition4(String add4, int price){
        this.add4=add4;
        this.priceAdd4=price;
    }

    public void finalHamburger(){
        if(add1 != null) {
            total+=priceAdd1;
            System.out.println("Added "+ add1);
        }
        if(add2 != null){
            total+=priceAdd2;
            System.out.println("Added "+ add2);
        }
        if(add3 != null){
            total+=priceAdd3;
            System.out.println("Added "+ add3);
        }
        if(add4 != null){
            total+=priceAdd4;
            System.out.println("Added "+ add4);
        }
        total+=price;
        System.out.println("The hamburger "+ name+ " on a "+ rollType+ " with "+meat+ ", price = "+total);

    }

}
