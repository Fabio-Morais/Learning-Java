package com.timbuchalka;

public class SumOddRange {
    public static boolean isOdd(int x){
        if(x<=0)
            return false;

        return (x%2 != 0);

    }
    public static int sumOdd(int start, int end){
       if(end < start || start < 0 || end < 0)
           return -1;

       int totalSum=0;
       for(int i=start; i<=end; i++){
           if(isOdd(i))
               totalSum+=i;
       }
       return totalSum;
    }
}
