package com.timbuchalka;

public class MobilePhone implements ITelephone{
    private int myNumber;
    private boolean isRinging;
    private boolean isOn=false;

    public MobilePhone(int myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void powerOn() {
        isOn=true;
        System.out.println("Mobile phone powered up");
    }

    @Override
    public void dial(int phoneNumber) {
        if(isOn)
            System.out.println("now ringing " + phoneNumber);
        else
            System.out.println("phone is switched off");
    }

    @Override
    public void answer() {
        if(isRinging)
        {
            System.out.println("answering the mobile phone");
            isRinging=false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if(myNumber==phoneNumber && isOn){
            isRinging=true;
            System.out.println("ring ring");
        }else
            isRinging=false;
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
