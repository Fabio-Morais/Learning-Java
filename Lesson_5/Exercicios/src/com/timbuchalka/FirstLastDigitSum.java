package com.timbuchalka;

public class FirstLastDigitSum {
    /*public static int sumFirstAndLastDigit(int number){
        if(number < 0)
            return -1;
        int firstNumber=0,lastNumber=0,aux=number;

        lastNumber=aux%10;
        firstNumber=lastNumber;

        while(aux > 0)
        {
            firstNumber=aux%10;
            aux/=10;
        }

        return firstNumber + lastNumber;
    }*/

    public static int sumFirstAndLastDigit(int number){
        if(number < 0)
            return -1;
        String num=""+number;
        String firstNumber=""+num.charAt(0);
        String lastNumber=num.substring(num.length()-1);

        return Integer.parseInt(firstNumber) + Integer.parseInt(lastNumber);
    }
}
