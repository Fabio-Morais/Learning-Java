package com.timbuchalka;

public class Hello {
    public static void main (String[] args){
        System.out.println("Hello Wolrd");

        /*PRIMITIVE DATA TYPES*/

        /*INT       32*/
        int myFirstNumber=9_342_100; // para ler melhor o numero
        System.out.println("int: "+myFirstNumber); // sout -> para fazer o System.out.println

        /*BYTE      8*/
        byte myByteValue= 127; /* max: 127, min: -127*/
        byte newByte= (byte)(myByteValue/2); // (byte) fazer o cast
        System.out.println("byte: "+newByte);

        /*SHORT     16*/
        short myShortValue= 32_767; /*max 32767, min: -32768 */
        short myNewShort = (short)(myShortValue/2);
        System.out.println("short: "+myShortValue);

        /*LONG      64*/
        long myLongValue=100L; /*necessario colocar um L a seguir ao numero*/
        long myNewLong= 5000L + 10L +(myShortValue + myByteValue +myFirstNumber); // nao é preciso fazer cast porque long aceita int
        System.out.println("long: "+myNewLong);


        /*FLOAT     32*/
        float myFloatValue=5f/3f;/*ou usar cast*/
        System.out.println("float: "+myFloatValue);

        /*double é mais rapido nos pcs mais modernos*/
        /*DOUBLE    64*/
        double myDoubleValue=5d/3d; /*se nao usar o 5d e 3d o resultado fica INT, logo fica 1*/
        System.out.println("double: "+myDoubleValue);

        /*CHAR 16*/
        char myChar= '\u00A9'; // ir ao unicode-table ver os simbolos
        System.out.println("char: "+myChar);

        /*BOOLEAN*/
        boolean myBoolean = false;
        System.out.println("boolean: "+ myBoolean);

        /**************NOT PRIMITIVE DATA TYPES***********************/

        /*STRING*/
        String myString= "This is a string";
        myString = myString + ", and this is more.";
        System.out.println(myString);

     /*IFS IGUAL AO C*/
        boolean isCar=true;
        boolean wasCar = isCar ?  true : false;
        if(wasCar)
            System.out.println("wasCar is true");
    }
}
