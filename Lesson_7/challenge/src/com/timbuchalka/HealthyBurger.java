package com.timbuchalka;

public class HealthyBurger extends Hamburger {

    private String addExtra1;
    private int priceAddExtra1;
    private String addExtra2;
    private int priceAddExtra2;

    public HealthyBurger(String rollType, String meat, int price, String name) {
        super(rollType, meat, price, name);

    }

    public void addExtraHealth1(String extra, int price){
        this.addExtra1=extra;
        this.priceAddExtra1=price;
    }

    public void addExtraHealth2(String extra, int price){
        this.addExtra2=extra;
        this.priceAddExtra2=price;
    }

    @Override
    public void finalHamburger() {
        super.finalHamburger();
        if(addExtra1!= null){
            System.out.println("extr: "+ addExtra1);

        }

    }
}
