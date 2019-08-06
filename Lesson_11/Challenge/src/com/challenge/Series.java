package com.challenge;

public class Series {

    public int nSum(int n){
        int sum=0;
        for(int i=0; i<=n; i++)
        {
            sum+=i;
            if(i<n)
                System.out.print(sum+", ");
            else if(i==n)
                System.out.println(sum);
        }
        return sum;
    }

    public int factorial(int n){
        int fac=1;
        for(int i=0; i<=n; i++)
        {
            fac*=i;
            if(i<n)
            {
                System.out.print(fac+", ");
                if(i==0)
                    fac++;
            }
            else if(i==n)
                System.out.println(fac);
        }
        return fac;
    }

    public int fibonacci(int n){

        /* Declare an array to store Fibonacci numbers. */
        int f[] = new int[n+2]; // 1 extra to handle case, n = 0
        int i;

        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0;
        System.out.print(f[0]+" ");
        f[1] = 1;
        System.out.print(f[1]+" ");

        for (i = 2; i <= n; i++)
        {
       /* Add the previous 2 numbers in the series
         and store it */
            f[i] = f[i-1] + f[i-2];
            System.out.print(f[i]+" ");
        }

        return f[n];
    }

}
