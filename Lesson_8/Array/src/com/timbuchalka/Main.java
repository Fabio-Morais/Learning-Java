package com.timbuchalka;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] myIntArray = new int[10]; // alocar memoria para 10 posiçoes
        int[] myIntArray2 = {1,2,3,4,5,6,7,8,9,10,11,12}; //aloca o que precisar
        for(int i=0; i<myIntArray.length; i++) {
            myIntArray[i]=i;
        }
        myIntArray[0]= 2;
        myIntArray[1]=3;
        printArray(myIntArray);
        System.out.println(myIntArray2[2]);

        /*************************/
        System.out.println("Returning");
        System.out.println("who many elements do you want? ");
        int num=scanner.nextInt();
        int[] myIntegers = getIntegers(num);
        printArray(myIntegers);

        /**********REFERENCE VS VALUE TYPE*****************/
        int value=10;//10
        int value2=value;//10
        value2++; //11

        /*referencia*/
        int[] myInt = new int[5];
        int[] myInt2=myInt;
        System.out.println("myInt= "+ Arrays.toString(myInt));//0
        System.out.println("myInt2= "+ Arrays.toString(myInt2));//0
        myInt2[0]=1;
        System.out.println("myInt= "+ Arrays.toString(myInt));//1
        System.out.println("myInt2= "+ Arrays.toString(myInt2));//1
        /*Muda os 2 porque está por referencia*/


    }
    public static int[] getIntegers (int number){
        int[] values = new int[number];
        System.out.println("Enter "+ number+ " numbers");
        for(int i=0; i<values.length; i++){
            values[i]= scanner.nextInt();
        }
        return values;
    }


    public static void printArray(int[] array){
        for(int i=0; i<array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
