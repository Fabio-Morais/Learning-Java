package com.timbuchalka;

import java.util.Scanner;

public class InputCalculator {
    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);
        int count = 0, sum = 0;
        while (scanner.hasNextInt()) {
            sum += scanner.nextInt();
            count++;
        }
        System.out.println("SUM = " + sum + " AVG = " + Math.round((double) sum / count));
    }
}
