package com.timbuchalka;

public class GreatestCommonDivisor {
    public static int getGreatestCommonDivisor(int first, int second){
        if(first < 10 || second < 10)
            return -1;
        int maxCommonDivisor=0;
        int maxFirst=0;
        int count=1;
        int count2=1;
        while(count<=first){
            if(first % count == 0)
                maxFirst=count;
            count2=1;
            while(count2<=second){
                if(second % count2 == 0)
                    if(maxFirst == count2)
                        maxCommonDivisor=count2;
                count2++;
            }

            count++;
        }
        return maxCommonDivisor;
    }
}
