package com.timbuchalka;

public class Main {

    /*É um metodo       void por nao retornar nada*/
    public static void main(String[] args) {
        // write your code here
        int myVariable = 50;
        /*
         * Expression->  myVariable=50
         * Statment-> int myVariable=50;
         */
        System.out.println("This is" +
                "another" +
                "still more");

        boolean gameOver = true;
        if (gameOver) {
            int score = 100;
        }
        /*
        System.out.println(score);
        Erro, porque variavel score definida entre {}
         */
        int score=100;
        /*               argumentos*/
        System.out.println("Final value: "+calculateScore(gameOver, score)+ "\n");
        System.out.println("Final value: "+calculateScore(gameOver, 200)+ "\n");
        System.out.println("Final value: "+ calculateScore(gameOver, 300)+ "\n");

    }
    /*                                      parametros*/
    public static int calculateScore(boolean gameOver, int score) {
        if (gameOver) {
            System.out.println("method calculateScore()");
            System.out.println("score: "+score);
            int finalValue= score/2 *5;
            return finalValue;
        }
        return 0;
    }

}
