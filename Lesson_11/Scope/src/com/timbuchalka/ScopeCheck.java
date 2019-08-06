package com.timbuchalka;

public class ScopeCheck {
    public int publicVar=0;
    private int privateVar=1;

    public ScopeCheck() {
        System.out.println("created " + publicVar + " : "+ privateVar);
    }

    public int getPrivateVar() {
        return privateVar;
    }
    public void timsTwo(){
        int privateVar=2;
        for(int i=0; i<10; i++)
            System.out.println(i + "  "+ i*privateVar);
    }
}
