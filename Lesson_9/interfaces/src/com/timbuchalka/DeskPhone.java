package com.timbuchalka;

/* para chamarmos uma interface */
public class DeskPhone implements ITelephone {
    private int myNumber;
    private boolean isRinging;


    public DeskPhone(int myNumber) {
        this.myNumber = myNumber;
    }

    @Override
    public void powerOn() {
        System.out.println("No action taken, desk dows not have power button");
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("now ringing " + phoneNumber);
    }

    @Override
    public void answer() {
        if(isRinging)
        {
            System.out.println("answering the desk phone");
            isRinging=false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if(myNumber==phoneNumber){
            isRinging=true;
            System.out.println("ring");
        }else
            isRinging=false;
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
