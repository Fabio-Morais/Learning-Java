package com.timbuchalka;

public class EvenDigitSum {
    public static int getEvenDigitSum(int number){
        if(number < 0)
            return -1;
        int totalSum=0;
        while(number>0){
            if((number%10) %2 ==0 )
                totalSum+=number%10;
            number/=10;
        }
        return totalSum;
    }
}
