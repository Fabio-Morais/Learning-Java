package com.timbuchalka;

public class Main {

    public static void main(String[] args) {
        /*USAMOS O ITelephone para utilizar no DeskPhone e MobilePhone*/
        ITelephone timsPhone;
        timsPhone = new DeskPhone(12345);
        timsPhone.powerOn();;
        timsPhone.callPhone(12345);
        timsPhone.answer();

        timsPhone = new MobilePhone(24565);
        timsPhone.powerOn();
        timsPhone.callPhone(24565);
        timsPhone.answer();
    }
}
