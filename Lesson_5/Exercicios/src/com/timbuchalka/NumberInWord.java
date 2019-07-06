package com.timbuchalka;

public class NumberInWord {

    public static void printNumberInWord(int number) {
        String result = "OTHER";
        switch (number) {
            case 0:
                result = "ZERO";
                break;
            case 1:
                result = "ONE";
                break;
            case 2:
                result = "TWO";
                break;
            case 3:
                result = "THREE";
                break;
            case 4:
                result = "FOUR";
                break;
            case 5:
                result = "FIVE";
                break;
            case 6:
                result = "SIX";
                break;
            case 7:
                result = "SEVEN";
                break;
            case 8:
                result = "EIGHT";
                break;
            case 9:
                result = "NINE";
                break;
        }
        System.out.println(result);
    }
}
