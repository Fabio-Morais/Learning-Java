package com.timbuchalka;

public class Main {

    /*constante*/
    private static final String INVALID_MESSAGE = "Invalid value";

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
        int score = 100;
        /*               argumentos*/
        System.out.println("Final value: " + calculateScore(gameOver, score) + "\n");
        System.out.println("Final value: " + calculateScore(200) + "\n");
        System.out.println("Final value: " + calculateScore() + "\n");


        System.out.println(getDurationString(65, 45));
        System.out.println(getDurationString(3945L));
        System.out.println(getDurationString(-41));
        System.out.println(getDurationString(65, 9));

    }

    /**
     * METHOD OVERLOADING, cria varios metodos com nome igual, mas com diferentes parametros
     **/
    /*                                      parametros*/
    public static int calculateScore(boolean gameOver, int score) {
        if (gameOver) {
            System.out.println("method calculateScore()");
            System.out.println("score: " + score);
            int finalValue = score / 2 * 5;
            return finalValue;
        }
        return 0;
    }

    public static int calculateScore(int score) {
        System.out.println("another method");
        int finalValue = score / 2 * 7;
        return finalValue;
    }

    /*SE MUDARMOS DE INT PARA VOID JÁ NÃO DÁ*/
    public static int calculateScore() {
        System.out.println("method with no parametres ");
        return 0;
    }

    private static String getDurationString(long minutes, long seconds) {
        if ((minutes < 0) || (seconds < 0) || (seconds > 59)) {
            return INVALID_MESSAGE;
        }

        long hours = minutes / 60;
        long remainingMinutes = minutes % 60;

        String hoursString = hours + "h";
        if (hours < 10) {
            hoursString = "0" + hoursString;
        }

        String minutesString = remainingMinutes + "m";
        if (remainingMinutes < 10) {
            minutesString = "0" + minutesString;
        }

        String secondsString = seconds + "s";
        if (seconds < 10) {
            secondsString = "0" + secondsString;
        }


        return hoursString + " " + minutesString + " " + secondsString + "";
    }

    private static String getDurationString(long seconds) {
        if (seconds < 0) {
            return INVALID_MESSAGE;
        }

        long minutes = seconds / 60;
        long remainingSeconds = seconds % 60;

        return getDurationString(minutes, remainingSeconds);
    }

}
