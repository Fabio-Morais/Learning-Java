package com.timbuchalka;
import java.util.Scanner;

public class Main {

    /*depois de um enter chamar um call next int, para capturar o enter e nao estragar o outro scanner*/
    public static void userInput(){
        Scanner scanner = new Scanner(System.in);//criar um novo objeto do tipo Scanner
        System.out.println("Your birth age :");

        /*Dá check se é um numero ou nao*/
        boolean hasNextInt = scanner.hasNextInt();
        if(hasNextInt) {
            int age = scanner.nextInt();
            scanner.nextLine();//caputre the return
            System.out.println("Enter your name: ");
            String name = scanner.nextLine();
            System.out.println("Your name is " + name);
            System.out.println("you age is: " + (2019 - age));
        }else
        {
            System.out.println("Invalid age");
        }
        scanner.close();
    }

    public static void main(String[] args) {
        int x;

        x=3;


        switch (x){
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:case 4:case 5:
                System.out.println("3, 4 ou 5");
                break;
            default:
                System.out.println("other number");
                break;
        }

        String y="SouUmaString";
        switch (y.toLowerCase()){
            case "souumastring":
                System.out.println("ok");
                break;
            default:
                System.out.println("erro");
                break;
        }

        calculate(x);
        convertString();
        userInput();
    }

    /**         FOR LOOP  /     WHILE          **/
    public static void calculate(int x){

        for(int i=0; i<x; i++ ){
            System.out.println(i);
        }
        int i=0;
        while(i<x) {
            System.out.println("while loop " + i);
            i++;
        }
    }

    /**     CONVERTER STRING PARA NUM**/
    public static void convertString(){
        String numberString="2019";
        /*
        * Se tier numerString="2019a" dá erro, porue tem de ser tudo numeros
        * */
        System.out.println("string= "+ numberString);
        int num=Integer.parseInt(numberString); //CONVERTE PARA INT
        /*OU*/
        double numDouble= Double.parseDouble("2019.1235");
        System.out.println("num= "+ num);
        System.out.println("double= "+ numDouble);
        numberString+=1;
        num+=1;
        System.out.println("string= "+ numberString);
        System.out.println("num= "+ num);
    }
}
