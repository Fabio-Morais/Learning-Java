package com.timbuchalka;

public class SharedDigit {
    public static boolean hasSharedDigit(int x, int y){
        if(!(x>=10 && x<=99) || !(y>=10 && y<=99))
            return false;

        while(x > 0){
            int aux=y;
            while(aux>0){
                System.out.println("x: "+x);
                System.out.println("aux: "+ aux);
                if(x%10 == aux%10)
                    return true;
                aux/=10;
            }
            x/=10;
        }
        return false;
    }
}
