package com.challenge;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        System.out.println("enter a number: ");
        X x = new X(new Scanner(System.in).nextInt());
        x.x();
    }
}
