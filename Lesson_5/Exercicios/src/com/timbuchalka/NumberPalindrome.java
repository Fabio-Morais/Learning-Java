package com.timbuchalka;


public class NumberPalindrome {
    public static boolean isPalindrome(int number){
        int reverse=0;
        int aux=number;

        while(aux!=0) {
            System.out.println(aux);
            reverse *= 10;
            reverse += aux % 10;
            aux/=10;
            System.out.println(reverse);
        }
        return (reverse == number);
    }
    /*      OU      */
    public static boolean isPalindromeString(int number){
        String num=""+Math.abs(number);
        String reverse = new StringBuilder(num).reverse().toString();
        return (num.equals(reverse));
    }


}
