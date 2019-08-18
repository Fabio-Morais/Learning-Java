package com.timbuchalka;

import java.util.Scanner;

public class HelloThread extends Thread{

    private int from;
    private int to;
    public HelloThread(int from, int to) {
        this.from=from;
        this.to=to;
    }

    @Override
    public void run() {
        for (double i = from; i <= (to*10000); i++) {
            System.out.println(i);
        }
    }
}
