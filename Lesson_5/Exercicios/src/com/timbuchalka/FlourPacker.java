package com.timbuchalka;

public class FlourPacker {
   /* public static boolean canPack(int bigCount, int smallCount, int goal){
        if(bigCount < 0 || smallCount < 0 || goal < 0)
            return false;
        int sum=0;
        for(int i=0; i<bigCount; i++){
            if((sum+5) <= goal)
                sum+=5;
            else
                break;
        }
        for(int i=0; i<smallCount; i++){
            if(sum < goal)
                sum++;
            else
                break;
        }
        return (sum == goal);
    }*/

    /*  OUTRA SOLUÇAO   */
    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if(bigCount < 0 || smallCount < 0 || goal < 0)
            return false;
        if(bigCount * 5 <= goal)
            return (bigCount*5 +smallCount >=goal);
        else
            return ((goal % 5) <= smallCount);
    }
}
